// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.controller.recycleritem;

import com.groupon.callbacks.OnDealImageEventListener;

// Referenced classes of package com.groupon.mvc.controller.recycleritem:
//            DetailsHeaderController

private class <init>
    implements OnDealImageEventListener
{

    final DetailsHeaderController this$0;

    public void onImageChange(int i)
    {
        DetailsHeaderController.access$102(DetailsHeaderController.this, i);
    }

    public void onUserInteraction()
    {
        DetailsHeaderController.access$202(DetailsHeaderController.this, false);
    }

    private ()
    {
        this$0 = DetailsHeaderController.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
