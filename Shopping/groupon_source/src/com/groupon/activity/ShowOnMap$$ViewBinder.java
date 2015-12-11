// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.google.android.gms.maps.MapView;

// Referenced classes of package com.groupon.activity:
//            ShowOnMap, GrouponActivity

public class inder extends inder
{

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (ShowOnMap)grouponactivity, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, ShowOnMap showonmap, Object obj)
    {
        super.bind(ewbinder, showonmap, obj);
        showonmap.mapView = (MapView)ewbinder.tView((View)ewbinder.dRequiredView(obj, 0x7f100521, "field 'mapView'"), 0x7f100521, "field 'mapView'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (ShowOnMap)obj, obj1);
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((ShowOnMap)grouponactivity);
    }

    public void unbind(ShowOnMap showonmap)
    {
        super.unbind(showonmap);
        showonmap.mapView = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((ShowOnMap)obj);
    }

    public inder()
    {
    }
}
