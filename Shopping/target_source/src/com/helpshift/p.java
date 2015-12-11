// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.helpshift.g.b.a;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.helpshift:
//            l, HSReview, u, HSRetryService, 
//            x, s

final class p
    implements android.app.Application.ActivityLifecycleCallbacks
{

    private static p a = null;
    private static l b = null;
    private static s c = null;
    private static int d;
    private static int e;
    private static boolean f;

    private p()
    {
    }

    public static p a()
    {
        if (a == null)
        {
            a = new p();
        }
        return a;
    }

    public static boolean b()
    {
        return f;
    }

    static l c()
    {
        return b;
    }

    static s d()
    {
        return c;
    }

    public void onActivityCreated(Activity activity, Bundle bundle)
    {
    }

    public void onActivityDestroyed(Activity activity)
    {
    }

    public void onActivityPaused(Activity activity)
    {
    }

    public void onActivityResumed(Activity activity)
    {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle)
    {
    }

    public void onActivityStarted(Activity activity)
    {
        if (b == null)
        {
            b = new l(activity.getApplication());
            c = b.a;
        }
        d++;
        if (!f)
        {
            b.h();
            activity = activity.getApplicationContext();
            if (b.f().booleanValue())
            {
                Intent intent = new Intent(activity, com/helpshift/HSReview);
                intent.setFlags(0x10000000);
                activity.startActivity(intent);
            }
            try
            {
                b.b(new Handler() {

                    final p a;

                    public void handleMessage(Message message)
                    {
                        com.helpshift.g.b.a.b((JSONObject)message.obj);
                        message = p.c().B();
                        if (!TextUtils.isEmpty(message))
                        {
                            p.d().a(message);
                        }
                    }

            
            {
                a = p.this;
                super();
            }
                }, new Handler());
            }
            catch (JSONException jsonexception)
            {
                x.b("HelpShiftDebug", jsonexception.toString(), jsonexception);
            }
            if (com.helpshift.u.a(activity))
            {
                activity.startService(new Intent(activity, com/helpshift/HSRetryService));
            }
            b.u();
            b.d();
        }
        f = true;
    }

    public void onActivityStopped(Activity activity)
    {
        e++;
        if (d == e)
        {
            f = false;
        }
    }

}
