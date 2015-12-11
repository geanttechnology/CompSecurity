// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.net.Uri;
import android.view.View;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.UiSettings;
import com.groupon.activity.GlobalSearchResult;
import com.groupon.mapview.DealsMapView;
import com.groupon.models.Place;
import com.groupon.util.GeoPoint;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.service:
//            DealTypeService, LocationService

public class SearchHelper
{

    private DealTypeService dealTypeService;
    private LocationService locationService;
    private View searchListSection;
    private View searchMapSection;
    private DealsMapView searchMapView;

    public SearchHelper()
    {
    }

    public void addDealsToMap(Place place, List list)
    {
        searchMapView.addDeals(list, new GeoPoint((int)(place.lat * 1000000D), (int)(place.lng * 1000000D)));
        searchMapView.moveCameraToFitDeals();
        dealTypeService.preProcessDealListNew(list);
    }

    protected void adjustToFullMapMode(boolean flag)
    {
        searchMapView.enableMapDealDetails(flag);
        enableMyLocation(flag);
    }

    public void enableMyLocation(boolean flag)
    {
        GoogleMap googlemap = searchMapView.getGoogleMap();
        if (googlemap != null)
        {
            googlemap.setMyLocationEnabled(flag);
            googlemap.getUiSettings().setMyLocationButtonEnabled(false);
            googlemap.getUiSettings().setCompassEnabled(flag);
        }
    }

    public Place getPlaceForMap(GlobalSearchResult globalsearchresult)
    {
        Object obj = globalsearchresult.getDeepLinkWithApiParameters();
        if (!Strings.isEmpty(obj)) goto _L2; else goto _L1
_L1:
        obj = globalsearchresult.getPlace();
_L4:
        return ((Place) (obj));
_L2:
        try
        {
            obj = Uri.parse(((String) (obj)));
            globalsearchresult = ((Uri) (obj)).getQueryParameter("lat");
            obj = ((Uri) (obj)).getQueryParameter("lng");
            if (!Strings.notEmpty(globalsearchresult) || !Strings.notEmpty(obj))
            {
                break; /* Loop/switch isn't completed */
            }
            float f = Float.parseFloat(globalsearchresult);
            float f1 = Float.parseFloat(((String) (obj)));
            globalsearchresult = new Place("", f, f1);
        }
        // Misplaced declaration of an exception variable
        catch (GlobalSearchResult globalsearchresult)
        {
            globalsearchresult = null;
        }
_L5:
        obj = globalsearchresult;
        if (globalsearchresult == null)
        {
            globalsearchresult = locationService.getBestGuessForLocation();
            return new Place("", globalsearchresult.getLatitudeDegrees(), globalsearchresult.getLongitudeDegrees());
        }
        if (true) goto _L4; else goto _L3
_L3:
        globalsearchresult = null;
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    public void init(View view, View view1, DealsMapView dealsmapview)
    {
        searchListSection = view;
        searchMapSection = view1;
        searchMapView = dealsmapview;
    }

    public void switchToList()
    {
        searchListSection.setVisibility(0);
        searchMapSection.setVisibility(8);
        adjustToFullMapMode(false);
    }

    public void switchToMap()
    {
        searchListSection.setVisibility(8);
        searchMapSection.setVisibility(0);
        searchMapView.moveCameraToFitDeals();
        adjustToFullMapMode(true);
    }
}
