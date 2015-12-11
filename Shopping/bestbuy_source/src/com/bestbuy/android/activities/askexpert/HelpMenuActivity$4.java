// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.askexpert;

import android.content.SharedPreferences;
import android.widget.CompoundButton;
import nb;

// Referenced classes of package com.bestbuy.android.activities.askexpert:
//            HelpMenuActivity

class a
    implements android.widget.eckedChangeListener
{

    final HelpMenuActivity a;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        if (flag)
        {
            compoundbutton = "On";
        } else
        {
            compoundbutton = "Off";
        }
        nb.a().b().edit().putString("shake_your_device", compoundbutton).commit();
    }

    A(HelpMenuActivity helpmenuactivity)
    {
        a = helpmenuactivity;
        super();
    }
}
