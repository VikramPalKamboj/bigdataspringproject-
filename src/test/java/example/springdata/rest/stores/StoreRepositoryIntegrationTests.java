package example.springdata.rest.stores;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import example.springdata.rest.stores.Store.Address;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class StoreRepositoryIntegrationTests {

	@Autowired StoreRepository repository;

	@Before
	@After
	public void clearDb() {
		repository.deleteAll();
	}

	@Test
	public void findsStoresByLocation() {

		Point location = new Point(-73.995146, 40.740337);
		Store store = new Store("Foo", new Address("street", "city", "zip", location));

		store = repository.save(store);

		Page<Store> stores = repository.findByAddressLocationNear(location, new Distance(1.0, Metrics.KILOMETERS),
				new PageRequest(0, 10));

		assertThat(stores.getContent(), hasSize(1));
		assertThat(stores.getContent(), hasItem(store));
	}
}
