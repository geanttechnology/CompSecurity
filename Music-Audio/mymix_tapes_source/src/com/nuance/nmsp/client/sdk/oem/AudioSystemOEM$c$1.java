// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmsp.client.sdk.oem;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package com.nuance.nmsp.client.sdk.oem:
//            AudioSystemOEM

final class a extends Handler
{

    private a a;

    public final void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            try
            {
                a(a);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Message message)
            {
                a(a, message);
            }
            return;

        case 2: // '\002'
            a(a);
            return;

        case 3: // '\003'
            message = Looper.myLooper();
            break;
        }
        if (message != null)
        {
            message.quit();
        }
        a(a);
    }

    ( )
    {
        a = ;
        super();
    }
}
