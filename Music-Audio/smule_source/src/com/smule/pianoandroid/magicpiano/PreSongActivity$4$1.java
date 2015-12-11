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
    implements Runnable
{

    final a a;

    public void run()
    {
        com.smule.pianoandroid.magicpiano.PreSongActivity.a(a.a, 3);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/PreSongActivity$4

/* anonymous class */
    class PreSongActivity._cls4
        implements android.view.View.OnClickListener
    {

        final PreSongActivity a;

        public void onClick(View view)
        {
            if (com.smule.pianoandroid.d.a.b(a) > 3)
            {
                com.smule.pianoandroid.magicpiano.PreSongActivity.a(a);
                com.smule.pianoandroid.magicpiano.PreSongActivity.a(a, 3);
                return;
            }
            view = a.getSharedPreferences("user", 0);
            if (!view.getBoolean("hard_shown", false))
            {
                o.a(a, 4, a.getResources().getString(0x7f0c0138), new PreSongActivity._cls4._cls1(this));
                view = view.edit();
                view.putBoolean("hard_shown", true);
                p.a(view);
                return;
            } else
            {
                com.smule.pianoandroid.magicpiano.PreSongActivity.a(a, 3);
                return;
            }
        }

            
            {
                a = presongactivity;
                super();
            }
    }

}
