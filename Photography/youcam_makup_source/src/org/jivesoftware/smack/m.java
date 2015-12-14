// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack;

import org.jivesoftware.smack.b.i;
import org.jivesoftware.smack.packet.e;

// Referenced classes of package org.jivesoftware.smack:
//            h

public class m
{

    private h a;
    private i b;

    public m(h h1, i j)
    {
        a = h1;
        b = j;
    }

    public void a(e e)
    {
        if (b == null || b.a(e))
        {
            a.processPacket(e);
        }
    }
}
