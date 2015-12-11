// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.map;

import com.amazon.geo.mapsv2.AmazonMap;
import com.amazon.geo.mapsv2.OnMapReadyCallback;
import java.util.List;

// Referenced classes of package com.amazon.now.map:
//            DebugMapWebActivity

class val.markers
    implements OnMapReadyCallback
{

    final DebugMapWebActivity this$0;
    final List val$markers;

    public void onMapReady(AmazonMap amazonmap)
    {
        DebugMapWebActivity.access$000(DebugMapWebActivity.this, val$markers);
    }

    ()
    {
        this$0 = final_debugmapwebactivity;
        val$markers = List.this;
        super();
    }
}
