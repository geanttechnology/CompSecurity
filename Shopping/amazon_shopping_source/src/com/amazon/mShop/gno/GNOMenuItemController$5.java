// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import com.amazon.mShop.AmazonActivity;

// Referenced classes of package com.amazon.mShop.gno:
//            GNOMenuItemController, GNODrawer

class stomRunnable
    implements temOnClickListener
{

    final GNOMenuItemController this$0;
    final stomRunnable val$onClickRunnable;

    public void onClick(AmazonActivity amazonactivity, GNODrawer gnodrawer)
    {
        val$onClickRunnable.run(amazonactivity);
    }

    stomRunnable()
    {
        this$0 = final_gnomenuitemcontroller;
        val$onClickRunnable = stomRunnable.this;
        super();
    }
}
