// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.map;

import com.amazon.geo.mapsv2.AmazonMap;
import com.amazon.geo.mapsv2.OnMapReadyCallback;

// Referenced classes of package com.amazon.now.map:
//            MapWebActivity

class this._cls0
    implements OnMapReadyCallback
{

    final MapWebActivity this$0;

    public void onMapReady(AmazonMap amazonmap)
    {
        amazonmap.clear();
    }

    back()
    {
        this$0 = MapWebActivity.this;
        super();
    }
}
