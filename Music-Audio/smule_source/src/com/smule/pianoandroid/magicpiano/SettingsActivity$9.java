// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.Dialog;
import android.view.View;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            SettingsActivity

class a
    implements android.view.r
{

    final Dialog a;
    final SettingsActivity b;

    public void onClick(View view)
    {
        a.dismiss();
        SettingsActivity.a(0);
    }

    (SettingsActivity settingsactivity, Dialog dialog)
    {
        b = settingsactivity;
        a = dialog;
        super();
    }
}
