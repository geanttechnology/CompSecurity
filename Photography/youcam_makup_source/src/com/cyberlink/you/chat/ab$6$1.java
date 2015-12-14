// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.you.chat;

import com.cyberlink.you.database.Group;
import com.cyberlink.you.database.MessageObj;
import com.cyberlink.you.database.d;
import com.cyberlink.you.database.f;
import java.util.concurrent.Semaphore;
import org.jivesoftware.smack.packet.Message;

// Referenced classes of package com.cyberlink.you.chat:
//            r, ab, d, n

class a
    implements r
{

    final a a;

    public void a()
    {
        ab.c(a.a).release();
        ab.a(a.a, true, a.a);
    }

    public void b()
    {
        ab.c(a.a).release();
        ab.a(a.a, false, a.a);
    }

    sageObj(sageObj sageobj)
    {
        a = sageobj;
        super();
    }

    // Unreferenced inner class com/cyberlink/you/chat/ab$6

/* anonymous class */
    class ab._cls6
        implements Runnable
    {

        final MessageObj a;
        final String b;
        final ab c;

        public void run()
        {
            Object obj;
            Object obj1;
            Thread.currentThread().setName("SendMessage (Internal)");
            try
            {
                ab.c(c).acquire();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ab.c(c).release();
                return;
            }
            obj = com.cyberlink.you.chat.ab.d(c);
            obj;
            JVM INSTR monitorenter ;
            obj1 = c.f().a(a.c());
            if (obj1 != null)
            {
                break MISSING_BLOCK_LABEL_75;
            }
            ab.c(c).release();
            obj;
            JVM INSTR monitorexit ;
            return;
            obj1 = d.a(((Group) (obj1)).e, b, a);
            String s = a.b();
            a.a(((Message) (obj1)).q());
            c.e().a(s, a, "MessageId");
            obj;
            JVM INSTR monitorexit ;
            if (n.a != org.jivesoftware.smack.packet.Presence.Type.a)
            {
                ab.c(c).release();
                return;
            } else
            {
                c.a(((Message) (obj1)), new ab._cls6._cls1(this));
                return;
            }
            obj1;
            obj;
            JVM INSTR monitorexit ;
            throw obj1;
        }

            
            {
                c = ab1;
                a = messageobj;
                b = s;
                super();
            }
    }

}
