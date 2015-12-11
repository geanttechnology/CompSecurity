// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import com.smule.android.f.c;
import com.smule.pianoandroid.utils.s;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            SettingsActivity

class a
    implements Observer
{

    final SettingsActivity a;

    public void update(Observable observable, Object obj)
    {
        c.a(SettingsActivity.b(a), s.a().b(), 0xff444444, true);
    }

    (SettingsActivity settingsactivity)
    {
        a = settingsactivity;
        super();
    }
}
