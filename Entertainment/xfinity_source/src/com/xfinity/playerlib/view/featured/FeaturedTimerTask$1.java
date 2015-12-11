// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.featured;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

// Referenced classes of package com.xfinity.playerlib.view.featured:
//            FeaturedTimerTask

class this._cls0
    implements Runnable
{

    final FeaturedTimerTask this$0;

    public void run()
    {
        boolean flag;
        flag = false;
        if (position < 0)
        {
            position = gallery.getCurrentItem() + 1;
        }
        if (position >= gallery.getAdapter().getCount())
        {
            position = gallery.getAdapter().getCount() - 1;
        }
        if (position != 0)
        {
            flag = true;
        }
        try
        {
            gallery.setCurrentItem(position, flag);
            FeaturedTimerTask featuredtimertask = FeaturedTimerTask.this;
            featuredtimertask.position = featuredtimertask.position + 1;
            if (position > gallery.getAdapter().getCount() - 1)
            {
                position = 0;
            }
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    ()
    {
        this$0 = FeaturedTimerTask.this;
        super();
    }
}
