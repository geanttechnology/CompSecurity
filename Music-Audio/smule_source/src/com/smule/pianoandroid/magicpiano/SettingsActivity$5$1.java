// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.View;
import com.smule.android.c.a;
import com.smule.android.f.h;
import com.smule.android.network.core.r;
import com.smule.android.network.managers.ar;
import com.smule.pianoandroid.utils.o;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            SettingsActivity

class a
    implements Observer
{

    final a a;

    public void update(Observable observable, Object obj)
    {
        if (((Boolean)obj).booleanValue())
        {
            o.a(a.a, 0x7f0c0232, 0x7f0c01c0);
            a.a.findViewById(0x7f0a01e8).setVisibility(8);
        } else
        {
            com.smule.android.c.a.b("not_subscribed");
            o.a(a.a, 0x7f0c0231, 0x7f0c01c0);
        }
        h.a().b("AutoRap.PURCHASES_RESTORED", a.a.f);
        a.a.f = null;
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/SettingsActivity$5

/* anonymous class */
    class SettingsActivity._cls5
        implements android.view.View.OnClickListener
    {

        final SettingsActivity a;

        public void onClick(View view)
        {
            if (r.a(a))
            {
                a.f = new SettingsActivity._cls5._cls1(this);
                h.a().a("AutoRap.PURCHASES_RESTORED", a.f);
                com.smule.android.c.a.b();
                ar.a().b(a, true);
                return;
            } else
            {
                o.a(a, 0x7f0c02c6, 0x7f0c01c0);
                return;
            }
        }

            
            {
                a = settingsactivity;
                super();
            }
    }

}
