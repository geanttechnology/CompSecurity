// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jeremyfeinstein.slidingmenu.lib;


// Referenced classes of package com.jeremyfeinstein.slidingmenu.lib:
//            SlidingActivityHelper, SlidingMenu

class val.secondary
    implements Runnable
{

    final SlidingActivityHelper this$0;
    final boolean val$open;
    final boolean val$secondary;

    public void run()
    {
        if (val$open)
        {
            if (val$secondary)
            {
                SlidingActivityHelper.access$000(SlidingActivityHelper.this).showSecondaryMenu(false);
                return;
            } else
            {
                SlidingActivityHelper.access$000(SlidingActivityHelper.this).showMenu(false);
                return;
            }
        } else
        {
            SlidingActivityHelper.access$000(SlidingActivityHelper.this).showContent(false);
            return;
        }
    }

    A()
    {
        this$0 = final_slidingactivityhelper;
        val$open = flag;
        val$secondary = Z.this;
        super();
    }
}
