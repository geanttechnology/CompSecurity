// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.timessquare;


// Referenced classes of package com.squareup.timessquare:
//            CalendarPickerView, Logr

class val.smoothScroll
    implements Runnable
{

    final CalendarPickerView this$0;
    final int val$selectedIndex;
    final boolean val$smoothScroll;

    public void run()
    {
        Logr.d("Scrolling to position %d", new Object[] {
            Integer.valueOf(val$selectedIndex)
        });
        if (val$smoothScroll)
        {
            smoothScrollToPosition(val$selectedIndex);
            return;
        } else
        {
            setSelection(val$selectedIndex);
            return;
        }
    }

    ()
    {
        this$0 = final_calendarpickerview;
        val$selectedIndex = i;
        val$smoothScroll = Z.this;
        super();
    }
}
