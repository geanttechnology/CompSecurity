// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.map;

import com.amazon.geo.mapsv2.MapsInitializer;
import com.amazon.geo.mapsv2.util.AmazonMapsRuntimeUtilInternal;
import com.amazon.now.account.User;

// Referenced classes of package com.amazon.now.map:
//            MapController

class this._cls0
    implements Runnable
{

    final MapController this$0;

    public void run()
    {
        MapsInitializer.initialize(MapController.access$200(MapController.this));
        AmazonMapsRuntimeUtilInternal.setAccountInfo(User.getUserCor(), User.getUserPfm());
    }

    psRuntimeUtilInternal()
    {
        this$0 = MapController.this;
        super();
    }
}
