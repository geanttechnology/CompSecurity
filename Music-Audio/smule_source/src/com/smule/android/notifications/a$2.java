// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.notifications;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.smule.android.c.aa;
import com.smule.android.network.a.p;
import com.smule.android.network.core.b;
import com.smule.android.network.core.o;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.smule.android.notifications:
//            a, GCMIntentService

class b extends AsyncTask
{

    final GoogleCloudMessaging a;
    final Context b;
    final a c;

    protected transient Void a(Void avoid[])
    {
        String s = com.smule.android.network.core.b.d().a(true);
        avoid = s;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        avoid = com.smule.android.network.core.b.d().c();
        String s1 = a.register(new String[] {
            GCMIntentService.a()
        });
        aa.c(com.smule.android.notifications.a.c(), (new StringBuilder()).append("registerInBackground - device registered; registration ID = ").append(s1).toString());
        if (p.a(s1, avoid, true).a())
        {
            aa.c(com.smule.android.notifications.a.c(), (new StringBuilder()).append("registerInBackground - network call successful; registration ID = ").append(s1).append(", device ID = ").append(avoid).toString());
            com.smule.android.notifications.a.a(c, b, com.smule.android.notifications.a.a(c), s1, avoid);
        }
_L2:
        return null;
        avoid;
        aa.e(com.smule.android.notifications.a.c(), "registerInBackground - IOException thrown while registering");
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected void a(Void void1)
    {
        super.onPostExecute(void1);
        com.smule.android.notifications.a.b(c).set(false);
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Void)obj);
    }

    udMessaging(a a1, GoogleCloudMessaging googlecloudmessaging, Context context)
    {
        c = a1;
        a = googlecloudmessaging;
        b = context;
        super();
    }
}
