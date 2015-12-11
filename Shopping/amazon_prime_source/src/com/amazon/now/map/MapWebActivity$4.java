// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.map;

import android.animation.TypeEvaluator;
import com.amazon.geo.mapsv2.model.LatLng;

// Referenced classes of package com.amazon.now.map:
//            MapWebActivity

class this._cls0
    implements TypeEvaluator
{

    final MapWebActivity this$0;

    public LatLng evaluate(float f, LatLng latlng, LatLng latlng1)
    {
        return new LatLng((latlng1.latitude - latlng.latitude) * (double)f + latlng.latitude, (latlng1.longitude - latlng.longitude) * (double)f + latlng.longitude);
    }

    public volatile Object evaluate(float f, Object obj, Object obj1)
    {
        return evaluate(f, (LatLng)obj, (LatLng)obj1);
    }

    ()
    {
        this$0 = MapWebActivity.this;
        super();
    }
}
