// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import com.groupon.adapter.DateTimePickerAdapter;

// Referenced classes of package com.groupon.fragment:
//            DateTimeFilterDialog

class val.currentTime
    implements Runnable
{

    final DateTimeFilterDialog this$0;
    final DateTimePickerAdapter val$adapter;
    final long val$currentTime;
    final int val$localCounter;
    final int val$position;

    public void run()
    {
        val$adapter.setSelectedPosition(val$position, true);
        if (val$localCounter == 0)
        {
            DateTimeFilterDialog.access$800(DateTimeFilterDialog.this, Long.valueOf(val$currentTime));
        }
    }

    ()
    {
        this$0 = final_datetimefilterdialog;
        val$adapter = datetimepickeradapter;
        val$position = i;
        val$localCounter = j;
        val$currentTime = J.this;
        super();
    }
}
