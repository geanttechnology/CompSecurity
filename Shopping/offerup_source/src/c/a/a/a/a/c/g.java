// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a.a.c;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package c.a.a.a.a.c:
//            f, a

final class g extends Handler
{

    public g()
    {
        super(Looper.getMainLooper());
    }

    public final void handleMessage(Message message)
    {
        f f1 = (f)message.obj;
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            a.c(f1.a, f1.b[0]);
            return;

        case 2: // '\002'
            a.c();
            break;
        }
    }
}
