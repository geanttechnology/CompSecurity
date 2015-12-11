// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

final class ala extends Handler
{

    private bkn a;
    private amr b;
    private chq c;
    private boolean d;
    private amd e;
    private cqg f;
    private akx g;

    ala(akx akx1, bkn bkn1, amr amr1, chq chq, boolean flag, amd amd1, cqg cqg1)
    {
        g = akx1;
        a = bkn1;
        b = amr1;
        c = chq;
        d = flag;
        e = amd1;
        f = cqg1;
        super();
    }

    public final void handleMessage(Message message)
    {
        if (g.m) goto _L2; else goto _L1
_L1:
        return;
_L2:
        switch (message.what)
        {
        default:
            return;

        case 0: // '\0'
            if (a.a())
            {
                b.a(g.c);
            } else
            {
                if (!g.a.isEmpty())
                {
                    message = c;
                }
                message = g;
                ame ame1;
                for (Iterator iterator = ((akx) (message)).b.iterator(); iterator.hasNext(); message.b(ame1))
                {
                    ame1 = (ame)iterator.next();
                    ((akx) (message)).a.remove(ame1);
                }

                ((akx) (message)).b.clear();
            }
            if (d)
            {
                g.j.sendEmptyMessageDelayed(0, 500L);
                return;
            } else
            {
                g.j.sendEmptyMessageDelayed(0, 5000L);
                return;
            }

        case 1: // '\001'
            g.b();
            if (!g.j.hasMessages(1))
            {
                g.j.sendEmptyMessageDelayed(1, 10000L);
                return;
            }
            break;

        case 2: // '\002'
            message = (Set)message.obj;
            if (!message.isEmpty())
            {
                message = message.iterator();
                while (message.hasNext()) 
                {
                    Object obj = (als)message.next();
                    if (((als) (obj)).a.d)
                    {
                        cgt cgt1 = ((als) (obj)).a.g;
                        Integer integer = (Integer)g.h.get(cgt1);
                        if (integer != null && integer.intValue() < 5 && e.a(((ame) (obj))))
                        {
                            chq chq = c;
                            obj = ((als) (obj)).a.c;
                            int i = integer.intValue();
                            (new StringBuilder(String.valueOf(obj).length() + 156)).append("RemoteControl connected/connecting to ").append(((String) (obj))).append(" . Will not remove the screen from the list of available devices even though it timed out. Time out count: ").append(i + 1);
                            g.h.put(cgt1, Integer.valueOf(integer.intValue() + 1));
                        } else
                        if (((als) (obj)).a.b != null)
                        {
                            Object obj2 = c;
                            obj2 = ((als) (obj)).a.c;
                            (new StringBuilder(String.valueOf(obj2).length() + 45)).append("Screen ").append(((String) (obj2))).append(" timed out. Will check the app status.");
                            f.a(((als) (obj)).a.b, new alb(g, ((als) (obj))));
                        } else
                        {
                            (new alb(g, ((als) (obj)))).a(new cfy(-2));
                        }
                    }
                }
            }
            break;

        case 3: // '\003'
            Object obj1 = (Pair)message.obj;
            message = (cgt)((Pair) (obj1)).first;
            obj1 = ((Pair) (obj1)).second;
            ((Boolean)g.f.get(message)).booleanValue();
            g.f.remove(message);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }
}
