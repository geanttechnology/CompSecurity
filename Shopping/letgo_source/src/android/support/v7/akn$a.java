// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package android.support.v7:
//            akn, aky, akf, akh

private static class a extends Handler
{

    private final akn a;

    public void handleMessage(Message message)
    {
        boolean flag = true;
        akn akn1;
        switch (message.what)
        {
        case 3: // '\003'
        case 8: // '\b'
        default:
            aky.a.post(new Runnable(message) {

                final Message a;
                final akn.a b;

                public void run()
                {
                    throw new AssertionError((new StringBuilder()).append("Unknown handler message received: ").append(a.what).toString());
                }

            
            {
                b = akn.a.this;
                a = message;
                super();
            }
            });
            return;

        case 1: // '\001'
            message = (akf)message.obj;
            a.c(message);
            return;

        case 2: // '\002'
            message = (akf)message.obj;
            a.d(message);
            return;

        case 11: // '\013'
            message = ((Message) (message.obj));
            a.a(message);
            return;

        case 12: // '\f'
            message = ((Message) (message.obj));
            a.b(message);
            return;

        case 4: // '\004'
            message = (akh)message.obj;
            a.e(message);
            return;

        case 5: // '\005'
            message = (akh)message.obj;
            a.d(message);
            return;

        case 6: // '\006'
            message = (akh)message.obj;
            a.a(message, false);
            return;

        case 7: // '\007'
            a.a();
            return;

        case 9: // '\t'
            message = (NetworkInfo)message.obj;
            a.b(message);
            return;

        case 10: // '\n'
            akn1 = a;
            break;
        }
        if (message.arg1 != 1)
        {
            flag = false;
        }
        akn1.b(flag);
    }

    public _cls1.a(Looper looper, akn akn1)
    {
        super(looper);
        a = akn1;
    }
}
