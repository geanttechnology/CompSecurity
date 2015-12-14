// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.packet.e;

// Referenced classes of package org.jivesoftware.smack:
//            XMPPConnection, m

class l
    implements Runnable
{

    final XMPPConnection a;
    private e b;

    public l(XMPPConnection xmppconnection, e e)
    {
        a = xmppconnection;
        super();
        b = e;
    }

    public void run()
    {
        Iterator iterator = a.c.values().iterator();
_L2:
        m m1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_61;
        }
        m1 = (m)iterator.next();
        m1.a(b);
        continue; /* Loop/switch isn't completed */
        SmackException.NotConnectedException notconnectedexception;
        notconnectedexception;
        XMPPConnection.D().log(Level.WARNING, "Got not connected exception, aborting", notconnectedexception);
        return;
        Exception exception;
        exception;
        XMPPConnection.D().log(Level.SEVERE, "Exception in packet listener", exception);
        if (true) goto _L2; else goto _L1
_L1:
    }
}
