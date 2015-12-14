// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack;

import java.util.Map;
import java.util.WeakHashMap;
import org.jivesoftware.smack.packet.Registration;

// Referenced classes of package org.jivesoftware.smack:
//            e, XMPPConnection

public class b extends e
{

    private static final Map b = new WeakHashMap();
    private Registration c;
    private boolean d;

    private b(XMPPConnection xmppconnection)
    {
        super(xmppconnection);
        c = null;
        d = false;
        b.put(xmppconnection, this);
    }

    public static b a(XMPPConnection xmppconnection)
    {
        org/jivesoftware/smack/b;
        JVM INSTR monitorenter ;
        b b2 = (b)b.get(xmppconnection);
        b b1;
        b1 = b2;
        if (b2 != null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        b1 = new b(xmppconnection);
        org/jivesoftware/smack/b;
        JVM INSTR monitorexit ;
        return b1;
        xmppconnection;
        throw xmppconnection;
    }

    void a(boolean flag)
    {
        d = flag;
    }

}
