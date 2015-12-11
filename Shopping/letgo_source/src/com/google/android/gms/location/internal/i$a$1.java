// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.j;

// Referenced classes of package com.google.android.gms.location.internal:
//            i

class a extends Handler
{

    final j a;
    final ility b;

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 0: // '\0'
            a.a((LocationResult)message.obj);
            return;

        case 1: // '\001'
            a.a((LocationAvailability)message.obj);
            break;
        }
    }

    ility(ility ility, Looper looper, j j1)
    {
        b = ility;
        a = j1;
        super(looper);
    }
}
