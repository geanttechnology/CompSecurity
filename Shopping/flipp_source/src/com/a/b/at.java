// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package com.a.b:
//            ad, au, as

final class at extends Handler
{

    private final as a;

    public at(Looper looper, as as1)
    {
        super(looper);
        a = as1;
    }

    public final void handleMessage(Message message)
    {
        as as2;
        switch (message.what)
        {
        default:
            ad.a.post(new au(this, message));
            return;

        case 0: // '\0'
            message = a;
            message.d = ((as) (message)).d + 1L;
            return;

        case 1: // '\001'
            message = a;
            message.e = ((as) (message)).e + 1L;
            return;

        case 2: // '\002'
            as as1 = a;
            long l = message.arg1;
            as1.j = as1.j + 1;
            as1.f = l + as1.f;
            int i = as1.j;
            as1.h = as1.f / (long)i;
            return;

        case 3: // '\003'
            as2 = a;
            break;
        }
        long l1 = message.arg1;
        as2.k = as2.k + 1;
        as2.g = l1 + as2.g;
        int j = as2.j;
        as2.i = as2.g / (long)j;
    }
}
