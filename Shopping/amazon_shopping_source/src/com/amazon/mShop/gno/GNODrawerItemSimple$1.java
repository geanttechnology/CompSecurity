// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import com.amazon.mShop.AmazonActivity;

// Referenced classes of package com.amazon.mShop.gno:
//            GNODrawerItemSimple, GNODrawer

class val.drawer
    implements Runnable
{

    final GNODrawerItemSimple this$0;
    final AmazonActivity val$callingActivity;
    final GNODrawer val$drawer;

    public void run()
    {
        GNODrawerItemSimple.access$100(GNODrawerItemSimple.this).onClick(val$callingActivity, val$drawer);
    }

    OItemOnClickListener()
    {
        this$0 = final_gnodraweritemsimple;
        val$callingActivity = amazonactivity;
        val$drawer = GNODrawer.this;
        super();
    }
}
