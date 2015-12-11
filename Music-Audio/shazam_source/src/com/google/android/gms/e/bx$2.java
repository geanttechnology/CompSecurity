// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import android.os.Handler;
import android.os.Message;

// Referenced classes of package com.google.android.gms.e:
//            bx

final class a
    implements android.os.er.Callback
{

    final bx a;

    public final boolean handleMessage(Message message)
    {
        if (1 == message.what && bx.e().equals(message.obj))
        {
            a.a();
            if (bx.b(a) > 0 && !bx.c(a))
            {
                bx.d(a).sendMessageDelayed(bx.d(a).obtainMessage(1, bx.e()), bx.b(a));
            }
        }
        return true;
    }

    (bx bx1)
    {
        a = bx1;
        super();
    }
}
