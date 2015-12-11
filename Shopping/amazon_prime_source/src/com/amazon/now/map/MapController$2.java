// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.map;

import com.amazon.now.account.UserListener;

// Referenced classes of package com.amazon.now.map:
//            MapController

class this._cls0
    implements UserListener
{

    final MapController this$0;

    public void userSignedIn()
    {
        MapController.access$300(MapController.this);
    }

    public void userSignedOut()
    {
    }

    ()
    {
        this$0 = MapController.this;
        super();
    }
}
