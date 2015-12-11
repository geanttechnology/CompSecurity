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
    implements Runnable
{

    final a a;

    public void run()
    {
        a.a.b();
        SettingsActivity.a(a.a);
        c.a(SettingsActivity.b(a.a), s.a().b(), 0, true);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/SettingsActivity$1

/* anonymous class */
    class SettingsActivity._cls1
        implements android.view.View.OnClickListener
    {

        final SettingsActivity a;

        public void onClick(View view)
        {
            o.a(a, new SettingsActivity._cls1._cls1(this));
        }

            
            {
                a = settingsactivity;
                super();
            }
    }

}
