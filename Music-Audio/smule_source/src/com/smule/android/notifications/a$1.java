// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.notifications;

import android.content.Context;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.smule.android.c.aa;

// Referenced classes of package com.smule.android.notifications:
//            a

class a
    implements Runnable
{

    final Context a;
    final a b;

    public void run()
    {
        if (!com.smule.android.notifications.a.a(b, a))
        {
            aa.e(com.smule.android.notifications.a.c(), "register - Google Play services are not available; aborting register");
            return;
        }
        GoogleCloudMessaging googlecloudmessaging = GoogleCloudMessaging.getInstance(a);
        if (com.smule.android.notifications.a.b(b, a).isEmpty())
        {
            aa.c(com.smule.android.notifications.a.c(), "register - registering device for push notifications.");
            com.smule.android.notifications.a.a(b, googlecloudmessaging, a);
            return;
        } else
        {
            aa.c(com.smule.android.notifications.a.c(), "register - registrationId is not empty, so not registering again");
            return;
        }
    }

    udMessaging(a a1, Context context)
    {
        b = a1;
        a = context;
        super();
    }
}
