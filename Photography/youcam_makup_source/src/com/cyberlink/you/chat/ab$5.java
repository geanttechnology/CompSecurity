// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import android.util.Log;
import com.cyberlink.you.database.Group;
import com.cyberlink.you.database.MessageObj;
import com.cyberlink.you.database.d;
import com.cyberlink.you.database.f;
import com.cyberlink.you.friends.l;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

// Referenced classes of package com.cyberlink.you.chat:
//            ab, XMPPObject

class a
    implements Runnable
{

    final ab a;

    public void run()
    {
        ab.b(a).clear();
        Thread.currentThread().setName("Fill Message Queue");
        Object obj = a.e().b();
        if (obj != null)
        {
            obj = ((List) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                MessageObj messageobj = (MessageObj)((Iterator) (obj)).next();
                if ((l.c() - messageobj.d().getTime()) / 1000L < 3600L && ab.a(messageobj.e()))
                {
                    Log.d("XMPPQueue", (new StringBuilder()).append("Add ").append(messageobj.b()).toString());
                    Group group = a.f().a(messageobj.c());
                    if (group != null)
                    {
                        ab.b(a).add(new XMPPObject(group.c, messageobj));
                    }
                } else
                if (!messageobj.j().equals("3"))
                {
                    messageobj.c("3");
                    a.e().a(messageobj.b(), messageobj, "Status");
                }
            } while (true);
            synchronized (ab.a(a))
            {
                ab.a(a).notify();
            }
            return;
        } else
        {
            return;
        }
        exception;
        obj1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    roup(ab ab1)
    {
        a = ab1;
        super();
    }
}
