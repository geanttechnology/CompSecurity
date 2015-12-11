// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.kahuna.sdk;

import android.content.SharedPreferences;
import android.util.Log;
import com.google.android.gms.gcm.d;
import java.util.TimerTask;

// Referenced classes of package com.kahuna.sdk:
//            h, m

private class b extends TimerTask
{

    final h a;
    private String b;

    public void run()
    {
        if (b != null && !"".equals(b))
        {
            String s1;
            try
            {
                String s = d.a(h.a(h.f())).a(new String[] {
                    b
                });
                h.b(s);
                Object obj = com.kahuna.sdk.h.d(h.a(h.f()));
                int i = h.e(h.a(h.f()));
                h.c((new StringBuilder()).append("Saving regId on app version ").append(i).toString());
                obj = ((SharedPreferences) (obj)).edit();
                ((android.content.edPreferences.Editor) (obj)).putString("registration_id", s);
                ((android.content.edPreferences.Editor) (obj)).putInt("appVersion", i);
                ((android.content.edPreferences.Editor) (obj)).commit();
                return;
            }
            catch (Exception exception)
            {
                if (m.s())
                {
                    Log.e("Kahuna", (new StringBuilder()).append("Exception registering for Push: ").append(exception).toString());
                    exception.printStackTrace();
                }
                s1 = exception.getMessage();
            }
            if (s1 != null && "SERVICE_NOT_AVAILABLE".equals(s1))
            {
                h.e();
                return;
            }
        }
    }

    public (h h1, String s)
    {
        a = h1;
        super();
        b = s;
    }
}
