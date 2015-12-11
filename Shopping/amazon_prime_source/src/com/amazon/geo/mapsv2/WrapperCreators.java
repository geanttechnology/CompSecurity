// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2;

import com.amazon.geo.mapsv2.internal.IObjectDelegate;
import com.amazon.geo.mapsv2.internal.IProjectionDelegate;
import com.amazon.geo.mapsv2.internal.IUiSettingsDelegate;
import com.amazon.geo.mapsv2.model.Circle;
import com.amazon.geo.mapsv2.model.GroundOverlay;
import com.amazon.geo.mapsv2.model.IndoorBuilding;
import com.amazon.geo.mapsv2.model.Marker;
import com.amazon.geo.mapsv2.model.Polygon;
import com.amazon.geo.mapsv2.model.Polyline;
import com.amazon.geo.mapsv2.model.TileOverlay;
import com.amazon.geo.mapsv2.model.internal.ICircleDelegate;
import com.amazon.geo.mapsv2.model.internal.IGroundOverlayDelegate;
import com.amazon.geo.mapsv2.model.internal.IIndoorBuildingDelegate;
import com.amazon.geo.mapsv2.model.internal.IMarkerDelegate;
import com.amazon.geo.mapsv2.model.internal.IPolygonDelegate;
import com.amazon.geo.mapsv2.model.internal.IPolylineDelegate;
import com.amazon.geo.mapsv2.model.internal.ITileOverlayDelegate;

// Referenced classes of package com.amazon.geo.mapsv2:
//            Projection, UiSettings

class WrapperCreators
{

    static final com.amazon.geo.mapsv2.pvt.Wrappers.WrapperCreator CIRCLE_CREATOR = new com.amazon.geo.mapsv2.pvt.Wrappers.WrapperCreator() {

        public Circle newWrapper(ICircleDelegate icircledelegate)
        {
            return new Circle(icircledelegate);
        }

        public volatile Object newWrapper(IObjectDelegate iobjectdelegate)
        {
            return newWrapper((ICircleDelegate)iobjectdelegate);
        }

    };
    static final com.amazon.geo.mapsv2.pvt.Wrappers.WrapperCreator GROUNDOVERLAY_CREATOR = new com.amazon.geo.mapsv2.pvt.Wrappers.WrapperCreator() {

        public GroundOverlay newWrapper(IGroundOverlayDelegate igroundoverlaydelegate)
        {
            return new GroundOverlay(igroundoverlaydelegate);
        }

        public volatile Object newWrapper(IObjectDelegate iobjectdelegate)
        {
            return newWrapper((IGroundOverlayDelegate)iobjectdelegate);
        }

    };
    static final com.amazon.geo.mapsv2.pvt.Wrappers.WrapperCreator INDOORBUILDING_CREATOR = new com.amazon.geo.mapsv2.pvt.Wrappers.WrapperCreator() {

        public IndoorBuilding newWrapper(IIndoorBuildingDelegate iindoorbuildingdelegate)
        {
            return new IndoorBuilding(iindoorbuildingdelegate);
        }

        public volatile Object newWrapper(IObjectDelegate iobjectdelegate)
        {
            return newWrapper((IIndoorBuildingDelegate)iobjectdelegate);
        }

    };
    static final com.amazon.geo.mapsv2.pvt.Wrappers.WrapperCreator MARKER_CREATOR = new com.amazon.geo.mapsv2.pvt.Wrappers.WrapperCreator() {

        public Marker newWrapper(IMarkerDelegate imarkerdelegate)
        {
            return new Marker(imarkerdelegate);
        }

        public volatile Object newWrapper(IObjectDelegate iobjectdelegate)
        {
            return newWrapper((IMarkerDelegate)iobjectdelegate);
        }

    };
    static final com.amazon.geo.mapsv2.pvt.Wrappers.WrapperCreator POLYGON_CREATOR = new com.amazon.geo.mapsv2.pvt.Wrappers.WrapperCreator() {

        public Polygon newWrapper(IPolygonDelegate ipolygondelegate)
        {
            return new Polygon(ipolygondelegate);
        }

        public volatile Object newWrapper(IObjectDelegate iobjectdelegate)
        {
            return newWrapper((IPolygonDelegate)iobjectdelegate);
        }

    };
    static final com.amazon.geo.mapsv2.pvt.Wrappers.WrapperCreator POLYLINE_CREATOR = new com.amazon.geo.mapsv2.pvt.Wrappers.WrapperCreator() {

        public Polyline newWrapper(IPolylineDelegate ipolylinedelegate)
        {
            return new Polyline(ipolylinedelegate);
        }

        public volatile Object newWrapper(IObjectDelegate iobjectdelegate)
        {
            return newWrapper((IPolylineDelegate)iobjectdelegate);
        }

    };
    static final com.amazon.geo.mapsv2.pvt.Wrappers.WrapperCreator PROJECTION_CREATOR = new com.amazon.geo.mapsv2.pvt.Wrappers.WrapperCreator() {

        public Projection newWrapper(IProjectionDelegate iprojectiondelegate)
        {
            return new Projection(iprojectiondelegate);
        }

        public volatile Object newWrapper(IObjectDelegate iobjectdelegate)
        {
            return newWrapper((IProjectionDelegate)iobjectdelegate);
        }

    };
    static final com.amazon.geo.mapsv2.pvt.Wrappers.WrapperCreator TILEOVERLAY_CREATOR = new com.amazon.geo.mapsv2.pvt.Wrappers.WrapperCreator() {

        public TileOverlay newWrapper(ITileOverlayDelegate itileoverlaydelegate)
        {
            return new TileOverlay(itileoverlaydelegate);
        }

        public volatile Object newWrapper(IObjectDelegate iobjectdelegate)
        {
            return newWrapper((ITileOverlayDelegate)iobjectdelegate);
        }

    };
    static final com.amazon.geo.mapsv2.pvt.Wrappers.WrapperCreator UISETTINGS_CREATOR = new com.amazon.geo.mapsv2.pvt.Wrappers.WrapperCreator() {

        public UiSettings newWrapper(IUiSettingsDelegate iuisettingsdelegate)
        {
            return new UiSettings(iuisettingsdelegate);
        }

        public volatile Object newWrapper(IObjectDelegate iobjectdelegate)
        {
            return newWrapper((IUiSettingsDelegate)iobjectdelegate);
        }

    };

    WrapperCreators()
    {
    }

}
