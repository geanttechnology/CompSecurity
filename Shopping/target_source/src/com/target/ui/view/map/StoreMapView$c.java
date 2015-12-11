// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.map;

import android.view.View;
import android.widget.ImageView;
import com.pointinside.maps.MapView;

// Referenced classes of package com.target.ui.view.map:
//            StoreMapView, ZoneSelectionView

private class arrowDown
{

    ImageView arrowDown;
    ImageView arrowLeft;
    ImageView arrowRight;
    ImageView arrowUp;
    MapView mapView;
    View progress;
    final StoreMapView this$0;
    View translucentOverlay;
    ZoneSelectionView zoneSelector;

    public ew(View view)
    {
        this$0 = StoreMapView.this;
        super();
        translucentOverlay = view.findViewById(0x7f100452);
        mapView = (MapView)view.findViewById(0x7f10044c);
        zoneSelector = (ZoneSelectionView)view.findViewById(0x7f10044d);
        progress = view.findViewById(0x7f100171);
        arrowLeft = (ImageView)view.findViewById(0x7f10044f);
        arrowRight = (ImageView)view.findViewById(0x7f10044e);
        arrowUp = (ImageView)view.findViewById(0x7f100450);
        arrowDown = (ImageView)view.findViewById(0x7f100451);
    }
}
