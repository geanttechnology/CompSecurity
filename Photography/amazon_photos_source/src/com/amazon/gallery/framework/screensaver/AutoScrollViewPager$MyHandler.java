// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.screensaver;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

// Referenced classes of package com.amazon.gallery.framework.screensaver:
//            AutoScrollViewPager, CustomDurationScroller

private static class autoScrollViewPager extends Handler
{

    private final WeakReference autoScrollViewPager;

    public void handleMessage(Message message)
    {
        super.handleMessage(message);
        message.what;
        JVM INSTR tableswitch 0 0: default 28
    //                   0 29;
           goto _L1 _L2
_L1:
        return;
_L2:
        if ((message = (AutoScrollViewPager)autoScrollViewPager.get()) != null)
        {
            AutoScrollViewPager.access$100(message).setScrollDurationFactor(AutoScrollViewPager.access$000(message));
            message.scrollOnce();
            AutoScrollViewPager.access$100(message).setScrollDurationFactor(AutoScrollViewPager.access$200(message));
            AutoScrollViewPager.access$400(message, AutoScrollViewPager.access$300(message) + (long)AutoScrollViewPager.access$100(message).getDuration());
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public (AutoScrollViewPager autoscrollviewpager)
    {
        autoScrollViewPager = new WeakReference(autoscrollviewpager);
    }
}
