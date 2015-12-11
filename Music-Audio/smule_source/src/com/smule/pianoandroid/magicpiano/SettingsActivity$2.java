// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.View;
import android.widget.Button;
import com.facebook.login.LoginManager;
import com.smule.android.c.h;
import com.smule.android.facebook.a;
import com.smule.pianoandroid.f.b;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            SettingsActivity

class a
    implements android.view.r
{

    final SettingsActivity a;

    public void onClick(View view)
    {
        if (!com.smule.android.facebook.a.a().h())
        {
            com.smule.android.c.a.c(h.c.a());
            LoginManager.getInstance().logInWithReadPermissions(a, b.b);
            return;
        } else
        {
            SettingsActivity.g(a).setClickable(false);
            com.smule.android.facebook.a.a().a(false, new com.smule.android.facebook.b() {

                final SettingsActivity._cls2 a;

                public void a(boolean flag)
                {
                    SettingsActivity settingsactivity = a.a;
                    if (!flag)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    settingsactivity.a(flag);
                    SettingsActivity.g(a.a).setClickable(true);
                }

            
            {
                a = SettingsActivity._cls2.this;
                super();
            }
            });
            return;
        }
    }

    _cls1.a(SettingsActivity settingsactivity)
    {
        a = settingsactivity;
        super();
    }
}
