// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.gcm;

import android.content.Context;
import com.cyberlink.beautycircle.Globals;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import java.io.IOException;

// Referenced classes of package com.cyberlink.beautycircle.controller.gcm:
//            a, b

final class a extends j
{

    final Context a;

    protected b a(Void void1)
    {
        b b1 = new b();
        GoogleCloudMessaging googlecloudmessaging;
        try
        {
            void1 = com.cyberlink.beautycircle.controller.gcm.a.c(a);
        }
        // Misplaced declaration of an exception variable
        catch (Void void1)
        {
            e.e(new Object[] {
                "Failed, msg: ", void1
            });
            b1.a = 2;
            return b1;
        }
        if (void1 == null) goto _L2; else goto _L1
_L1:
        if (void1.isEmpty()) goto _L2; else goto _L3
_L3:
        e.b(new Object[] {
            "Read registration ID: ", void1
        });
_L4:
        b1.a = 1;
        b1.b = void1;
        return b1;
_L2:
        googlecloudmessaging = GoogleCloudMessaging.getInstance(a);
        if (Globals.s().equals("YCP"))
        {
            void1 = "655894889550";
        } else
        {
            void1 = "8121036310";
        }
        void1 = googlecloudmessaging.register(new String[] {
            void1
        });
        e.b(new Object[] {
            "Device registered, registration ID: ", void1
        });
        com.cyberlink.beautycircle.controller.gcm.a.a(a, void1);
          goto _L4
    }

    protected volatile Object a(Object obj)
    {
        return a((Void)obj);
    }

    g(Context context)
    {
        a = context;
        super();
    }
}
