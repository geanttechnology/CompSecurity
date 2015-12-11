// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.app;

import android.app.Activity;
import android.app.Fragment;

// Referenced classes of package com.ebay.app:
//            DatePickerDialogFragment

public static class 
{

    private final DatePickerDialogFragment building = new DatePickerDialogFragment();

    public DatePickerDialogFragment createFromActivity(int i, Activity activity)
    {
        building.setTargetFragment(null, i);
        DatePickerDialogFragment.access$302(building, (android.app.r)activity);
        return building;
    }

    public DatePickerDialogFragment createFromFragment(int i, Fragment fragment)
    {
        building.setTargetFragment(fragment, i);
        DatePickerDialogFragment.access$302(building, (android.app.r)fragment);
        return building;
    }

    public building setDay(int i)
    {
        DatePickerDialogFragment.access$202(building, i);
        return this;
    }

    public building setMonth(int i)
    {
        DatePickerDialogFragment.access$102(building, i);
        return this;
    }

    public building setYear(int i)
    {
        DatePickerDialogFragment.access$002(building, i);
        return this;
    }

    public ()
    {
    }
}
