// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.res.Resources;
import android.widget.Button;
import com.smule.pianoandroid.f.a;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            SettingsActivity

class a
    implements Runnable
{

    final boolean a;
    final SettingsActivity b;

    public void run()
    {
        if (a)
        {
            SettingsActivity.g(b).setBackgroundDrawable(b.getResources().getDrawable(0x7f020068));
            SettingsActivity.g(b).setTextColor(b.getResources().getColor(0x7f08003c));
            SettingsActivity.g(b).setText(0x7f0c00d0);
        } else
        {
            SettingsActivity.g(b).setBackgroundDrawable(b.getResources().getDrawable(0x7f020075));
            SettingsActivity.g(b).setTextColor(b.getResources().getColor(0x7f08007f));
            SettingsActivity.g(b).setText(0x7f0c00af);
        }
        com.smule.pianoandroid.f.a.a(b).a(a);
    }

    (SettingsActivity settingsactivity, boolean flag)
    {
        b = settingsactivity;
        a = flag;
        super();
    }
}
