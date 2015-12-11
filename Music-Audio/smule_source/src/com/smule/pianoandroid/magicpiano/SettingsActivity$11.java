// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.View;
import android.widget.TextView;
import com.smule.android.b.a.a;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            SettingsActivity

class a
    implements Runnable
{

    final SettingsActivity a;

    public void run()
    {
        a.findViewById(0x7f0a021b).setVisibility(0);
        TextView textview = (TextView)a.findViewById(0x7f0a021e);
        textview.setVisibility(0);
        textview.setText(SettingsActivity.h(a).c());
    }

    (SettingsActivity settingsactivity)
    {
        a = settingsactivity;
        super();
    }
}
