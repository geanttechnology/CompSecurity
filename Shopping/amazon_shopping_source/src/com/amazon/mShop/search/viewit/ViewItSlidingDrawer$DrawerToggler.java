// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.view.View;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItSlidingDrawer

private class <init>
    implements android.view.wer.DrawerToggler
{

    final ViewItSlidingDrawer this$0;

    public void onClick(View view)
    {
        if (ViewItSlidingDrawer.access$200(ViewItSlidingDrawer.this))
        {
            return;
        }
        if (ViewItSlidingDrawer.access$300(ViewItSlidingDrawer.this))
        {
            animateToggle();
            return;
        } else
        {
            toggle();
            return;
        }
    }

    private ()
    {
        this$0 = ViewItSlidingDrawer.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
