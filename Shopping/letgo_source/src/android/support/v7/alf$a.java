// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package android.support.v7:
//            alf, aky

private static class a extends Handler
{

    private final alf a;

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            aky.a.post(new Runnable(message) {

                final Message a;
                final alf.a b;

                public void run()
                {
                    throw new AssertionError((new StringBuilder()).append("Unhandled stats message.").append(a.what).toString());
                }

            
            {
                b = alf.a.this;
                a = message;
                super();
            }
            });
            return;

        case 0: // '\0'
            a.c();
            return;

        case 1: // '\001'
            a.d();
            return;

        case 2: // '\002'
            a.b(message.arg1);
            return;

        case 3: // '\003'
            a.c(message.arg1);
            return;

        case 4: // '\004'
            a.a((Long)message.obj);
            break;
        }
    }

    public _cls1.a(Looper looper, alf alf1)
    {
        super(looper);
        a = alf1;
    }
}
