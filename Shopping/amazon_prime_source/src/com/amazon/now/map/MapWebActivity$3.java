// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.map;

import android.text.TextUtils;
import com.amazon.geo.mapsv2.AmazonMap;
import com.amazon.geo.mapsv2.OnMapReadyCallback;
import com.amazon.geo.mapsv2.model.MarkerOptions;
import com.amazon.now.util.ImageUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.now.map:
//            MapWebActivity

class val.origins
    implements OnMapReadyCallback
{

    final MapWebActivity this$0;
    final List val$couriers;
    final MarkerOptions val$destination;
    final List val$origins;

    public void onMapReady(AmazonMap amazonmap)
    {
        if (MapWebActivity.access$100(MapWebActivity.this) == null && val$destination.getPosition() != null)
        {
            MapWebActivity.access$102(MapWebActivity.this, amazonmap.addMarker(val$destination));
        }
        if (!val$couriers.isEmpty())
        {
            Iterator iterator1 = val$couriers.iterator();
            do
            {
                if (!iterator1.hasNext())
                {
                    break;
                }
                MarkerOptions markeroptions1 = (MarkerOptions)iterator1.next();
                String s3 = markeroptions1.getSnippet();
                String s = null;
                com.amazon.geo.mapsv2.model.Marker marker = null;
                String s2 = marker;
                if (!TextUtils.isEmpty(s3))
                {
                    String as[] = s3.split("###");
                    s3 = as[0];
                    s = s3;
                    s2 = marker;
                    if (as.length == 2)
                    {
                        s2 = as[1];
                        s = s3;
                    }
                }
                markeroptions1.snippet(null);
                marker = amazonmap.addMarker(markeroptions1);
                MapWebActivity.access$200(MapWebActivity.this).put(s, marker);
                if (s2 != null)
                {
                    ImageUtil.setImageFromUrl(new ageReadyCallback(marker), s2, -1, -1, true);
                }
            } while (true);
        }
        if (!val$origins.isEmpty())
        {
            Iterator iterator = val$origins.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                MarkerOptions markeroptions = (MarkerOptions)iterator.next();
                String s1 = null;
                if (markeroptions.getSnippet() != null)
                {
                    s1 = markeroptions.getSnippet();
                }
                markeroptions.snippet(null);
                com.amazon.geo.mapsv2.model.Marker marker1 = amazonmap.addMarker(markeroptions);
                MapWebActivity.access$300(MapWebActivity.this).put(markeroptions.getTitle(), marker1);
                if (s1 != null)
                {
                    ImageUtil.setImageFromUrl(new ageReadyCallback(marker1), s1, -1, -1, true);
                }
            } while (true);
        }
        if (!MapWebActivity.access$400(MapWebActivity.this) && val$couriers.isEmpty())
        {
            pan();
        } else
        if (!MapWebActivity.access$400(MapWebActivity.this) && !val$couriers.isEmpty())
        {
            pan();
            MapWebActivity.access$402(MapWebActivity.this, true);
            return;
        }
    }

    tions()
    {
        this$0 = final_mapwebactivity;
        val$destination = markeroptions;
        val$couriers = list;
        val$origins = List.this;
        super();
    }
}
