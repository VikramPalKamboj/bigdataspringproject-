package example.springdata.rest.stores;

import static org.springframework.data.mongodb.core.index.GeoSpatialIndexType.*;

import lombok.Value;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Value
@Document
public class Store {

	@Id UUID id = UUID.randomUUID();
	String name;
	Address address;

	/**
	 * Value object to represent an {@link Address}.
	 * 
	 * @author Oliver Gierke
	 */
	@Value
	public static class Address {

		String street, city, zip;
		@GeoSpatialIndexed(type = GEO_2DSPHERE) Point location;

		/*
		 * (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return String.format("%s, %s %s", street, zip, city);
		}
	}
}
