// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.iid;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;

// Referenced classes of package com.google.android.gms.iid:
//            e, MessengerCompat

final class a extends Handler
{

    final e a;

    public final void handleMessage(Message message)
    {
        e e1 = a;
        if (message != null && (message.obj instanceof Intent))
        {
            Object obj = (Intent)message.obj;
            ((Intent) (obj)).setExtrasClassLoader(com/google/android/gms/iid/MessengerCompat.getClassLoader());
            if (((Intent) (obj)).hasExtra("google.messenger"))
            {
                obj = ((Intent) (obj)).getParcelableExtra("google.messenger");
                if (obj instanceof MessengerCompat)
                {
                    e1.i = (MessengerCompat)obj;
                }
                if (obj instanceof Messenger)
                {
                    e1.h = (Messenger)obj;
                }
            }
            e1.b((Intent)message.obj);
        }
    }

    engerCompat(e e1, Looper looper)
    {
        a = e1;
        super(looper);
    }
}
