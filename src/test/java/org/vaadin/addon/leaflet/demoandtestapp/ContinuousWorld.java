package org.vaadin.addon.leaflet.demoandtestapp;

import org.vaadin.addon.leaflet.LMap;
import org.vaadin.addon.leaflet.LOpenStreetMapLayer;
import org.vaadin.addon.leaflet.LPolyline;
import org.vaadin.addon.leaflet.demoandtestapp.util.AbstractTest;
import org.vaadin.addon.leaflet.shared.Point;

import com.vaadin.ui.Component;

public class ContinuousWorld extends AbstractTest {

	@Override
	public String getDescription() {
		return "Test for continuous world and nowrap.";
	}

	@Override
	public Component getTestComponent() {
		LMap leafletMap = new LMap();

		LOpenStreetMapLayer layer = new LOpenStreetMapLayer();
		layer.setContinuousWorld(true); // default false, how to test?? Some online TMS source?
		layer.setNoWrap(true); // default false

		leafletMap.addBaseLayer(layer, "OSM");

		leafletMap.setCenter(0, 0);
		leafletMap.setZoomLevel(0);
		
		//Should cross pacific ocean
		LPolyline lPolyline = new LPolyline(new Point(0,360),new Point(0,390));
		
		leafletMap.addComponent(lPolyline);

		return leafletMap;
	}

}
