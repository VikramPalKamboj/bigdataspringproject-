package example.springdata.rest.stores;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.querydsl.core.types.dsl.StringPath;

public interface StoreRepository extends PagingAndSortingRepository<Store, UUID>, QueryDslPredicateExecutor<Store> {

	@RestResource(rel = "by-location")
	Page<Store> findByAddressLocationNear(Point location, Distance distance, Pageable pageable);

	default void customize(QuerydslBindings bindings, QStore store) {

		bindings.bind(store.address.city).first((path, value) -> path.endsWith(value));
		bindings.bind(String.class).first((StringPath path, String value) -> path.contains(value));
	}
}
