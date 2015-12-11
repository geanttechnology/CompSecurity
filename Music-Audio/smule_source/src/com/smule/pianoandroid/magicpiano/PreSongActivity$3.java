// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.view.View;
import com.smule.android.f.p;
import com.smule.pianoandroid.d.a;
import com.smule.pianoandroid.utils.o;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            PreSongActivity

class a
    implements android.view.er
{

    final PreSongActivity a;

    public void onClick(View view)
    {
        if (com.smule.pianoandroid.d.a.b(a) > 2)
        {
            com.smule.pianoandroid.magicpiano.PreSongActivity.a(a);
            com.smule.pianoandroid.magicpiano.PreSongActivity.a(a, 2);
            return;
        }
        view = a.getSharedPreferences("user", 0);
        if (!view.getBoolean("medium_shown", false))
        {
            o.a(a, 3, a.getResources().getString(0x7f0c017e), new Runnable() {

                final PreSongActivity._cls3 a;

                public void run()
                {
                    com.smule.pianoandroid.magicpiano.PreSongActivity.a(a.a, 2);
                }

            
            {
                a = PreSongActivity._cls3.this;
                super();
            }
            });
            view = view.edit();
            view.putBoolean("medium_shown", true);
            p.a(view);
            return;
        } else
        {
            com.smule.pianoandroid.magicpiano.PreSongActivity.a(a, 2);
            return;
        }
    }

    _cls1.a(PreSongActivity presongactivity)
    {
        a = presongactivity;
        super();
    }
}
