// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

final class akq extends Handler
{

    final akj a;

    akq(akj akj1, Looper looper)
    {
        a = akj1;
        super(looper);
    }

    public final void handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 1 8: default 52
    //                   1 53
    //                   2 52
    //                   3 424
    //                   4 739
    //                   5 52
    //                   6 52
    //                   7 77
    //                   8 150;
           goto _L1 _L2 _L1 _L3 _L4 _L1 _L1 _L5 _L6
_L1:
        return;
_L2:
        akj.a(a);
        akj.a(a, akj.b(a), false);
        return;
_L5:
        if (akj.c(a) == null)
        {
            akj.a(a).b("We should reconnect, but we lost the cloud screen.");
            return;
        } else
        {
            akj.a(a);
            message = akj.d(a);
            ceo ceo1 = new ceo();
            ceo1.c = akj.c(a).f;
            message.a(ceo1.a());
            return;
        }
_L6:
        akt akt1 = (akt)message.obj;
        message = akt1.a.a.f().a;
        ame ame2 = a.f;
        if (ame2 == null || !ame2.h() || !ame2.f().a.equals(message))
        {
            akj.a(a);
            message = String.valueOf(message);
            (new StringBuilder(String.valueOf(message).length() + 55)).append("Waking up of DIAL device ").append(message).append(" was canceled in the meantime.");
            return;
        }
        if (!akt1.b.get() && akt1.c > 0)
        {
            akj.e(a).a(new akr(this, message, akt1));
            akt1.c = akt1.c - 1;
            sendMessageDelayed(Message.obtain(akj.f(a), 8, akt1), 5000L);
            return;
        }
        if (!akt1.b.get() && akt1.c == 0)
        {
            alu alu1 = alu.d;
            akj.a(a);
            message = String.valueOf(message);
            String s = String.valueOf(alu1);
            (new StringBuilder(String.valueOf(message).length() + 32 + String.valueOf(s).length())).append("Could not wake up DIAL device  ").append(message).append(" ").append(s);
            akj.a(a, false);
            akj.g(a).a(alu1);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (akj.d(a).h || akj.d(a).a())
        {
            akj.a(a);
            akj.d(a).a(true);
        }
        message = (ako)message.obj;
        Object obj = ((ako) (message)).a;
        akj.a(a);
        String s1 = String.valueOf(((ame) (obj)).b());
        if (s1.length() != 0)
        {
            "Connecting to ".concat(s1);
        } else
        {
            new String("Connecting to ");
        }
        if (((ame) (obj)).h())
        {
            obj = ((ame) (obj)).f().a;
            if (((cgw) (obj)).b == null && ((cgw) (obj)).h != null)
            {
                (new cfs(akj.a(a))).a(((cgw) (obj)).h);
                sendMessage(Message.obtain(akj.f(a), 8, new akt(message, ((cgw) (obj)).i)));
                return;
            } else
            {
                akj.a(a, ((cgw) (obj)), message);
                return;
            }
        }
        if (((ame) (obj)).g())
        {
            Object obj1 = akj.a(a, ((ame) (obj)).e().a);
            if (obj1 != null)
            {
                akj.a(a, ((cgc) (obj1)), message);
                return;
            }
            obj1 = akj.a(a);
            message = String.valueOf(((ame) (obj)).b());
            if (message.length() != 0)
            {
                message = "Couldn't obtain cloud screen for ".concat(message);
            } else
            {
                message = new String("Couldn't obtain cloud screen for ");
            }
            ((chq) (obj1)).b(message);
            akj.g(a).a(amj.d);
            akj.g(a).a(((ame) (obj)));
            akj.g(a).a(amj.e);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
        message = (akp)message.obj;
        ame ame1 = ((akp) (message)).a;
        if (ame1 != null)
        {
            akj.a(a);
            String s2 = String.valueOf(ame1.b());
            boolean flag;
            if (s2.length() != 0)
            {
                "Disconnecting from ".concat(s2);
            } else
            {
                new String("Disconnecting from ");
            }
            flag = ((akp) (message)).b;
            if (flag)
            {
                akj.b(a, ame1);
            }
            akj.h(a).a();
            if (ame1.h())
            {
                akj.i(a).remove(ame1.f().a.g);
            }
            akj.a(a, akj.b(a), flag);
        } else
        {
            akj.a(a).b("Disconnecting from a yet unknown screen");
            akj.a(a, akj.b(a), false);
        }
        akj.a(a, false);
        akj.b(a, null);
        akj.g(a).a(amj.e);
        return;
    }
}
