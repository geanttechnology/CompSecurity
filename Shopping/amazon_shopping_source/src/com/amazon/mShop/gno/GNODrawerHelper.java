// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.gno;

import com.amazon.mShop.AmazonActivity;

// Referenced classes of package com.amazon.mShop.gno:
//            GNODrawer

public class GNODrawerHelper
{

    public GNODrawerHelper()
    {
    }

    public static void closeDrawerAndExecute(AmazonActivity amazonactivity, boolean flag, Runnable runnable)
    {
        GNODrawer gnodrawer = amazonactivity.getGNODrawer();
        if (gnodrawer.isClosed())
        {
            runnable.run();
            return;
        }
        gnodrawer.addListener(new GNODrawer.SimpleGNODrawerListener(runnable) {

            final Runnable val$runnable;

            public void onDrawerClosed(GNODrawer gnodrawer1)
            {
                gnodrawer1.removeListener(this);
                runnable.run();
            }

            
            {
                runnable = runnable1;
                super();
            }
        });
        if (flag)
        {
            amazonactivity.pushTemporaryBlankView();
        }
        gnodrawer.close();
    }
}
