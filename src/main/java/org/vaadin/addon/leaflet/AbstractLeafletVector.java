package org.vaadin.addon.leaflet;

import org.vaadin.addon.leaflet.client.AbstractLeafletVectorState;
import org.vaadin.addon.leaflet.client.LeafletMarkerClientRpc;
import org.vaadin.addon.leaflet.client.PopupState;
import org.vaadin.addon.leaflet.jsonmodels.VectorStyle;

public abstract class AbstractLeafletVector extends AbstractLeafletLayer {
    
    private VectorStyle style;
    
    @Override
    protected AbstractLeafletVectorState getState() {
        return (AbstractLeafletVectorState) super.getState();
    }
    
    public VectorStyle getStyle() {
        if(style == null) {
            style = new VectorStyle();
        }
        return style;
    }

    @Override
    public void beforeClientResponse(boolean initial) {
        getState().vectorStyleJson =  style != null ? style.asJson() : "{}";
        super.beforeClientResponse(initial);
    }
    
    
    
    public void setStyle(VectorStyle style) {
        this.style = style;
        markAsDirty();
    }

    public void setColor(String color) {
        getStyle().setColor(color);
        markAsDirty();
    }

    public void setStroke(Boolean stroke) {
        getStyle().setStroke(stroke);
        markAsDirty();
    }

    public void setFill(Boolean fill) {
        getStyle().setFill(fill);
        markAsDirty();
    }

    public void setFillColor(String fillColor) {
        getStyle().setFillColor(fillColor);
        markAsDirty();
    }

    public void setWeight(Integer weight) {
        getStyle().setWeight(weight);
        markAsDirty();
    }

    public void setOpacity(Double opacity) {
        getStyle().setOpacity(opacity);
        markAsDirty();
    }
    
    public void setFillOpacity(Double opacity) {
        getStyle().setFillOpacity(opacity);
        markAsDirty();
    }

    public void setDashArray(String dashArray) {
        getStyle().setDashArray(dashArray);
        markAsDirty();
    }

    public void setLineCap(String lineCap) {
        getStyle().setLineCap(lineCap);
        markAsDirty();
    }

    public void setLineJoin(String lineJoin) {
        getStyle().setLineJoin(lineJoin);
        markAsDirty();
    }

    public void setClickable(Boolean clickable) {
        getState().clickable = clickable;
    }

    public void setPopup(String popup) {
        getState().popup = popup;
    }

    public void setPopupState(PopupState popupState){
        getState().popupState = popupState;
    }

    public void openPopup() {
        getRpcProxy(LeafletMarkerClientRpc.class).openPopup();
    }

    public void closePopup() {
        getRpcProxy(LeafletMarkerClientRpc.class).closePopup();
    }
}