// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import com.pointinside.internal.utils.LogUtils;
import com.pointinside.maps.model.MapRouteStyle;
import com.pointinside.maps.model.RouteOverlayOptions;
import com.pointinside.nav.Route;
import com.pointinside.nav.RouteDirection;
import com.pointinside.nav.RouteLeg;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.pointinside.maps:
//            PIMapError, PIMGL, PIMGLRouteAttrs, PIMGLColor, 
//            PIMGLRouteLegAttrs, PIMap, Location, PIMGLUtil, 
//            PIMGLContext

public final class RouteOverlay
{

    private static final int ENTIRE_ROUTE_INDEX = -1;
    private static final String LOG_TAG = LogUtils.makeLogTag(com/pointinside/maps/RouteOverlay.getSimpleName());
    boolean isRemoved;
    PIMap.AddRouteAnimation mAddRouteAnimation;
    PIMGLContext mPimglContext;
    RouteOverlayOptions mRouteOverlayOptions;
    MapRouteStyle mRouteStyle;
    IntByReference reference;

    RouteOverlay(PIMGLContext pimglcontext, RouteOverlayOptions routeoverlayoptions, PIMap.AddRouteAnimation addrouteanimation)
        throws PIMapError
    {
        if (routeoverlayoptions == null)
        {
            throw PIMapError.generateError(PIMapError.Kind.ROUTE, "Route-overlay options cannot be null", new IllegalArgumentException());
        } else
        {
            isRemoved = false;
            mPimglContext = pimglcontext;
            reference = new IntByReference();
            PIMGL.ref_create(pimglcontext, new PointerByReference(reference.getPointer()));
            mRouteStyle = routeoverlayoptions.getMapRouteStyle();
            mAddRouteAnimation = addrouteanimation;
            mRouteOverlayOptions = routeoverlayoptions;
            return;
        }
    }

    public RouteOverlay applyRouteStyle(MapRouteStyle maproutestyle)
    {
        mRouteStyle = MapRouteStyle.copy(maproutestyle);
        return this;
    }

    void draw(PIMap pimap)
    {
        PIMGLRouteAttrs pimglrouteattrs = PIMGLRouteAttrs.fromRouteStyle(mRouteStyle, 1.0F);
        if (mAddRouteAnimation == PIMap.AddRouteAnimation.FADE)
        {
            PIMGLColor pimglcolor = PIMGLColor.fromColor(0xffff0000);
            pimglcolor.mA = 0.0F;
            pimglrouteattrs.mColor = pimglcolor;
        }
        PIMGL.route_create(mPimglContext, reference, pimglrouteattrs);
        List list = mRouteOverlayOptions.getRoute().getLegs();
        for (int i = 0; i < list.size(); i++)
        {
            Object obj = (RouteLeg)list.get(i);
            PIMGLRouteLegAttrs pimglroutelegattrs = null;
            MapRouteStyle maproutestyle = mRouteOverlayOptions.getLegStyle(i);
            if (maproutestyle != null)
            {
                pimglroutelegattrs = PIMGLRouteLegAttrs.fromRouteStyle(maproutestyle);
            }
            Location location;
            IntByReference intbyreference;
            for (obj = ((RouteLeg) (obj)).getDirections().iterator(); ((Iterator) (obj)).hasNext(); PIMGL.route_addPoint(mPimglContext, reference, intbyreference, location))
            {
                location = ((RouteDirection)((Iterator) (obj)).next()).getLocation();
                intbyreference = (IntByReference)pimap.mZoneUUIDToZoneRefMap.get(location.zone);
            }

            PIMGL.route_FinishLeg(mPimglContext, reference, pimglroutelegattrs);
        }

        Pointer pointer = Pointer.NULL;
        if (mAddRouteAnimation == PIMap.AddRouteAnimation.FADE)
        {
            pointer = ((IntByReference)pimap.mActionRefMap.get(PIMap.EventHandlerActions.ROUTE_WITH_ANIMATION)).getPointer();
        }
        int j = PIMGL.route_finishRoute(mPimglContext, reference, pointer);
        if (j != 0)
        {
            remove();
            LogUtils.logE(LOG_TAG, (new StringBuilder()).append("Error occured while drawing route on the map. Please try again").append(PIMGLUtil.errorIntToString(j)).toString());
        } else
        if (mAddRouteAnimation == PIMap.AddRouteAnimation.FADE)
        {
            pimglrouteattrs.mColor.mA = 1.0F;
            pimglrouteattrs.mPercentVisible = 1.0F;
            PIMGL.route_setAttrs(mPimglContext, reference, -1, pimglrouteattrs, 1.0F, 7, false, pointer);
            return;
        }
    }

    public MapRouteStyle getRouteStyle()
    {
        return MapRouteStyle.copy(mRouteStyle);
    }

    public void remove()
    {
        PIMGL.route_delete(mPimglContext, reference);
        reference = null;
        isRemoved = true;
    }

    public void update(PIMap.AddRouteAnimation addrouteanimation)
    {
        float f;
        if (addrouteanimation == PIMap.AddRouteAnimation.NONE)
        {
            f = 0.0F;
        } else
        {
            f = 1.0F;
        }
        addrouteanimation = new PIMGLRouteAttrs();
        PIMGL.route_getAttrs(mPimglContext, reference, -1, addrouteanimation);
        addrouteanimation.mColor = PIMGLColor.fromColor(mRouteStyle.getColor());
        addrouteanimation.mLineStyle = mRouteStyle.getLineStyle().getId();
        addrouteanimation.mCrawlSpeed = mRouteStyle.getCrawlSpeed();
        addrouteanimation.mLineWidth = mRouteStyle.getLineWidth();
        addrouteanimation.mLineSpacing = mRouteStyle.getLineSpacing();
        PIMGL.route_setAttrs(mPimglContext, reference, -1, addrouteanimation, f, 7, false, Pointer.NULL);
    }

}
