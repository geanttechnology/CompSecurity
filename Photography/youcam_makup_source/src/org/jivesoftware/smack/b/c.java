// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack.b;

import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.packet.IQ;
import org.jivesoftware.smack.packet.b;
import org.jivesoftware.smack.packet.e;
import org.jivesoftware.smack.util.p;

// Referenced classes of package org.jivesoftware.smack.b:
//            i, a, g, d, 
//            j, b

public class c
    implements i
{

    private static final Logger a = Logger.getLogger(org/jivesoftware/smack/b/c.getName());
    private final i b;
    private final g c = new g();
    private final String d;
    private final String e;
    private final String f;
    private final String g;

    public c(IQ iq, XMPPConnection xmppconnection)
    {
        d = iq.r();
        if (xmppconnection.e() == null)
        {
            e = null;
        } else
        {
            e = xmppconnection.e().toLowerCase(Locale.US);
        }
        f = xmppconnection.b().toLowerCase(Locale.US);
        g = iq.q();
        b = new a(new i[] {
            new g(new i[] {
                new d(b.d), new d(b.c)
            }), new j(iq)
        });
        c.a(org.jivesoftware.smack.b.b.b(d));
        if (d == null)
        {
            if (e != null)
            {
                c.a(org.jivesoftware.smack.b.b.a(e));
            }
            c.a(org.jivesoftware.smack.b.b.b(f));
        } else
        if (e != null && d.toLowerCase(Locale.US).equals(p.d(e)))
        {
            c.a(org.jivesoftware.smack.b.b.b(null));
            return;
        }
    }

    public boolean a(e e1)
    {
        if (!b.a(e1))
        {
            return false;
        }
        if (c.a(e1))
        {
            return true;
        } else
        {
            String s = String.format("Rejected potentially spoofed reply to IQ-packet. Filter settings: packetId=%s, to=%s, local=%s, server=%s. Received packet with from=%s", new Object[] {
                g, d, e, f, e1.s()
            });
            a.log(Level.WARNING, s, e1);
            return false;
        }
    }

}
