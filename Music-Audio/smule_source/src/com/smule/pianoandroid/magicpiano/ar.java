// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import com.smule.android.f.p;
import com.smule.android.network.core.r;
import com.smule.android.network.managers.a;
import com.smule.pianoandroid.a.z;
import com.smule.pianoandroid.magicpiano.registration.RegistrationEntryActivity;
import com.smule.pianoandroid.utils.o;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            n

public class ar
{

    public static String a = "SEEN_SONGBOOK";
    private static final String b = com/smule/pianoandroid/magicpiano/ar.getName();

    public ar()
    {
    }

    public static Dialog a(Activity activity, String s, String s1, Runnable runnable)
    {
        String s2 = activity.getString(0x7f0c020b);
        if (com.smule.android.network.managers.a.a().a("piandroid.offers", "fb-login.reward", 0) > 0 && r.a(activity))
        {
            s1 = (new StringBuilder()).append(s1).append("\n\n").append(activity.getString(0x7f0c020c)).toString();
        }
        activity = com.smule.pianoandroid.magicpiano.n.a(activity, 0x7f02010e, s2, null, s1, activity.getString(0x7f0c0258), null, new Runnable(activity, s) {

            final Activity a;
            final String b;

            public void run()
            {
                if (r.a(a))
                {
                    com.smule.android.c.a.a(false);
                    android.content.Intent intent = RegistrationEntryActivity.a(a, false, true, null, null, b);
                    a.startActivity(intent);
                    return;
                } else
                {
                    o.c();
                    return;
                }
            }

            
            {
                a = activity;
                b = s;
                super();
            }
        }, null);
        activity.setCancelable(true);
        activity.setCanceledOnTouchOutside(true);
        activity.setOnCancelListener(new android.content.DialogInterface.OnCancelListener(runnable) {

            final Runnable a;

            public void onCancel(DialogInterface dialoginterface)
            {
                if (a != null)
                {
                    a.run();
                }
            }

            
            {
                a = runnable;
                super();
            }
        });
        return activity;
    }

    public static void a(boolean flag)
    {
        android.content.SharedPreferences.Editor editor = z.a().c();
        editor.putBoolean(a, flag);
        p.a(editor);
    }

    public static boolean a()
    {
        return z.a().b().getBoolean(a, false);
    }

}
