// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.os.Handler;
import android.view.View;
import com.smule.android.network.core.r;
import com.smule.pianoandroid.magicpiano.b.f;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            SettingsActivity, MagicApplication

class a
    implements android.view.r
{

    final SettingsActivity a;

    public void onClick(View view)
    {
        if (r.a(a))
        {
            (new Handler()).post(new Runnable() {

                final SettingsActivity._cls3 a;

                public void run()
                {
                    (new f(a.a, SettingsActivity.h(a.a), a.a)).execute(new Void[0]);
                }

            
            {
                a = SettingsActivity._cls3.this;
                super();
            }
            });
            return;
        } else
        {
            MagicApplication.getInstance().showToast(a.getString(0x7f0c00f1), 1);
            return;
        }
    }

    _cls1.a(SettingsActivity settingsactivity)
    {
        a = settingsactivity;
        super();
    }
}
