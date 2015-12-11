// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.app;

import android.app.Fragment;
import android.os.Bundle;

// Referenced classes of package com.ebay.app:
//            TimePickerDialogFragment

public static class 
{

    private int hourOfDay;
    private int minute;

    public TimePickerDialogFragment createFromActivity(int i)
    {
        TimePickerDialogFragment timepickerdialogfragment = new TimePickerDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("hour", hourOfDay);
        bundle.putInt("minute", minute);
        timepickerdialogfragment.setArguments(bundle);
        timepickerdialogfragment.setTargetFragment(null, i);
        return timepickerdialogfragment;
    }

    public TimePickerDialogFragment createFromFragment(int i, Fragment fragment)
    {
        TimePickerDialogFragment timepickerdialogfragment = createFromActivity(i);
        timepickerdialogfragment.setTargetFragment(fragment, i);
        return timepickerdialogfragment;
    }

    public tFragment setHour(int i)
    {
        hourOfDay = i;
        return this;
    }

    public hourOfDay setMinute(int i)
    {
        minute = i;
        return this;
    }

    public ()
    {
    }
}
