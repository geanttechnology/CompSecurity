// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import android.os.Handler;

// Referenced classes of package com.pointinside.maps:
//            MapView, PIMGL

class this._cls0
    implements Runnable
{

    final MapView this$0;

    public void run()
    {
        if (MapView.access$100(MapView.this))
        {
            refreshAccessibility();
        }
        PIMGL.update(MapView.access$200(MapView.this));
        MapView.access$400(MapView.this).postDelayed(MapView.access$300(MapView.this), 33L);
    }

    ()
    {
        this$0 = MapView.this;
        super();
    }
}
