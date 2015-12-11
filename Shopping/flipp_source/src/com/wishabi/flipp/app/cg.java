// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import com.wishabi.flipp.b.a;
import com.wishabi.flipp.util.p;

// Referenced classes of package com.wishabi.flipp.app:
//            cv, HelpActivity, ch, do, 
//            MainActivity

final class cg
    implements cv
{

    final HelpActivity a;

    cg(HelpActivity helpactivity)
    {
        a = helpactivity;
        super();
    }

    public final void a()
    {
        com.wishabi.flipp.app.HelpActivity.a(a, true);
    }

    public final void a(String s)
    {
        com.wishabi.flipp.app.HelpActivity.a(a, false);
        if (s == null)
        {
            (new android.app.AlertDialog.Builder(a)).setMessage(0x7f0e00bb).setNeutralButton(0x104000a, new ch(this)).create().show();
            return;
        }
        a.getSharedPreferences("com.wishabi.flipp.preferences", 0).edit().putString("postal_code", s).commit();
        a.a.k = s;
        int i = com.wishabi.flipp.app.do.a.a();
        s = com.wishabi.flipp.app.do.a;
        if (s.a() != 3)
        {
            SharedPreferences sharedpreferences = p.a();
            if (sharedpreferences != null)
            {
                s.b = 3;
                sharedpreferences.edit().putInt("last_onboarding_version", 3).commit();
            }
        }
        if (i == 0)
        {
            s = new Intent(a, com/wishabi/flipp/app/MainActivity);
            a.startActivity(s);
            a.finish();
            return;
        } else
        {
            s = new Intent(a, com/wishabi/flipp/app/MainActivity);
            s.addFlags(0x4000000);
            s.addFlags(0x10000000);
            a.startActivity(s);
            a.finish();
            return;
        }
    }
}
