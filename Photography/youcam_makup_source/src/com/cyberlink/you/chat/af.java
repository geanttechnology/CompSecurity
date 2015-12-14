// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import android.util.Log;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.database.MessageObj;
import com.cyberlink.you.database.d;
import com.cyberlink.you.database.f;
import com.cyberlink.you.database.j;
import com.cyberlink.you.database.k;
import com.cyberlink.you.e;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smackx.receipts.DeliveryReceipt;

// Referenced classes of package com.cyberlink.you.chat:
//            ag, ab

public class af
{

    private boolean a;
    private ExecutorService b;

    public af()
    {
        a = false;
        b = Executors.newFixedThreadPool(1);
    }

    public static af a()
    {
        return ag.a();
    }

    static void a(af af1, Message message, String s)
    {
        af1.a(message, s);
    }

    private void a(Message message, String s)
    {
        ab.a().a(message.r(), s, message);
    }

    static boolean a(af af1)
    {
        return af1.a;
    }

    static boolean a(af af1, boolean flag)
    {
        af1.a = flag;
        return flag;
    }

    public void b()
    {
        Runnable runnable = new Runnable() {

            final af a;

            public void run()
            {
                List list;
                af.a(a, true);
                Thread.currentThread().setName("Resend Receipt");
                Log.d("XMPPReceipt", "[resend] start");
                list = e.j().a();
                if (list == null) goto _L2; else goto _L1
_L1:
                Iterator iterator;
                Log.d("XMPPReceipt", (new StringBuilder()).append("Resend Receipt size=").append(list.size()).toString());
                iterator = list.iterator();
_L6:
                if (!iterator.hasNext()) goto _L2; else goto _L3
_L3:
                k k1 = (k)iterator.next();
                if (af.a(a)) goto _L4; else goto _L2
_L2:
                return;
_L4:
                String s = k1.a();
                MessageObj messageobj = e.d().a(s);
                if (messageobj == null)
                {
                    e.j().c(s);
                } else
                {
                    Object obj = e.f().a(messageobj.c());
                    if (obj != null)
                    {
                        if (((Group) (obj)).e.equals("Dual"))
                        {
                            obj = ((Group) (obj)).c;
                        } else
                        {
                            obj = (new StringBuilder()).append(((Group) (obj)).c).append("/").append(messageobj.i()).toString();
                        }
                        obj = new Message(((String) (obj)), org.jivesoftware.smack.packet.Message.Type.b);
                        ((Message) (obj)).a(new DeliveryReceipt(messageobj.b()));
                        ((Message) (obj)).k(k1.b());
                        af.a(a, ((Message) (obj)), messageobj.b());
                    }
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

            
            {
                a = af.this;
                super();
            }
        };
        b.execute(runnable);
    }

    public void c()
    {
        Log.d("XMPPReceipt", "stop");
        a = false;
    }
}
