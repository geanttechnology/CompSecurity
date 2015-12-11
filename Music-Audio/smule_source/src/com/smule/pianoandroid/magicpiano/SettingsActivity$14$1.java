// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.res.Resources;
import android.widget.CompoundButton;
import android.widget.Toast;
import com.smule.android.f.b;
import com.smule.android.network.core.o;
import com.smule.android.network.managers.UserManager;
import com.smule.pianoandroid.magicpiano.b.r;
import com.smule.pianoandroid.magicpiano.b.s;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            SettingsActivity, an

class a
    implements s
{

    final a a;

    public void a(o o, Boolean boolean1, int i)
    {
        if (boolean1.booleanValue() && SettingsActivity.d(a.a).equals(b.b))
        {
            Toast.makeText(a.a, 0x7f0c0249, 1).show();
        }
        if (SettingsActivity.c(a.a) != null)
        {
            SettingsActivity.c(a.a).dismiss();
            SettingsActivity.a(a.a, null);
        }
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/SettingsActivity$14

/* anonymous class */
    class SettingsActivity._cls14
        implements android.widget.CompoundButton.OnCheckedChangeListener
    {

        final SettingsActivity a;

        public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
        {
            if (flag)
            {
                SettingsActivity.a(a, b.c);
            } else
            {
                SettingsActivity.a(a, b.b);
            }
            SettingsActivity.a(a, new an(a, a.getResources().getString(0x7f0c02c7)));
            SettingsActivity.c(a).show();
            (new r(UserManager.n().e(), UserManager.n().f(), UserManager.n().g(), SettingsActivity.d(a), new SettingsActivity._cls14._cls1(this))).execute(new Void[0]);
        }

            
            {
                a = settingsactivity;
                super();
            }
    }

}
