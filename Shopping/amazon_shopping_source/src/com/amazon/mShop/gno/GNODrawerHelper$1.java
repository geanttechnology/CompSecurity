// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;


// Referenced classes of package com.amazon.mShop.gno:
//            GNODrawerHelper, GNODrawer

static final class ODrawerListener extends ODrawerListener
{

    final Runnable val$runnable;

    public void onDrawerClosed(GNODrawer gnodrawer)
    {
        gnodrawer.removeListener(this);
        val$runnable.run();
    }

    ODrawerListener(Runnable runnable1)
    {
        val$runnable = runnable1;
        super();
    }
}
