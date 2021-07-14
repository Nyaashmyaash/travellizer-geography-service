package com.nyash.travellizer.travellizergeographyservice.model.entity;


import com.nyash.travellizer.travellizergeographyservice.model.City;
import com.nyash.travellizer.travellizergeographyservice.model.Station;
import com.nyash.travellizer.travellizergeographyservice.model.TransportType;
import com.nyash.travellizer.travellizergeographyservice.model.criteria.StationCriteria;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Verifies functionality of the {@link Station} domain entity
 * @author Nyash
 *
 */
public class StationTest {

    @Test
    void testMatchCriteriaNotInitialized(){
        City city = new City("Moscow");
        Station station = city.addStation(TransportType.ROADWAY);

        assertThrows(NullPointerException.class, () -> station.match(null));
    }

    @Test
    void testMatchByNameSuccess(){
        City city = new City("Moscow");
        Station station = city.addStation(TransportType.RAILWAY);

        assertTrue(station.match(StationCriteria.byName("Moscow")));
    }

    @Test
    void testMatchByNameNotFound() {
        City city = new City("Moscow");
        Station station = city.addStation(TransportType.WATER);

        assertFalse(station.match(StationCriteria.byName("Tokyo")));
    }
}
