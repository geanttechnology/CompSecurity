// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.widget.CompoundButton;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            SettingsActivity, av

class a
    implements android.widget.ckedChangeListener
{

    final SettingsActivity a;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        av.a(a, Boolean.valueOf(flag));
    }

    (SettingsActivity settingsactivity)
    {
        a = settingsactivity;
        super();
    }
}
