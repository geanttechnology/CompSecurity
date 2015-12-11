// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.View;
import com.smule.android.f.c;
import com.smule.pianoandroid.utils.o;
import com.smule.pianoandroid.utils.s;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            SettingsActivity

class a
    implements android.view.r
{

    final SettingsActivity a;

    public void onClick(View view)
    {
        o.a(a, new Runnable() {

            final SettingsActivity._cls1 a;

            public void run()
            {
                a.a.b();
                SettingsActivity.a(a.a);
                c.a(SettingsActivity.b(a.a), s.a().b(), 0, true);
            }

            
            {
                a = SettingsActivity._cls1.this;
                super();
            }
        });
    }

    _cls1.a(SettingsActivity settingsactivity)
    {
        a = settingsactivity;
        super();
    }
}
