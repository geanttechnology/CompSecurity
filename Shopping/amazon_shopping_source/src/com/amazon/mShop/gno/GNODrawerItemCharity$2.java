// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import com.amazon.mShop.AmazonActivity;

// Referenced classes of package com.amazon.mShop.gno:
//            GNODrawerItemCharity, GNODrawer

class val.drawer
    implements Runnable
{

    final GNODrawerItemCharity this$0;
    final AmazonActivity val$callingActivity;
    final GNODrawer val$drawer;

    public void run()
    {
        GNODrawerItemCharity.access$100(GNODrawerItemCharity.this).onClick(val$callingActivity, val$drawer);
    }

    ItemOnClickListener()
    {
        this$0 = final_gnodraweritemcharity;
        val$callingActivity = amazonactivity;
        val$drawer = GNODrawer.this;
        super();
    }
}
