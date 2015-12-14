// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack;

import org.jivesoftware.smack.b.i;
import org.jivesoftware.smack.packet.e;

// Referenced classes of package org.jivesoftware.smack:
//            g

public class k
{

    private g a;
    private i b;

    public k(g g1, i j)
    {
        a = g1;
        b = j;
    }

    public void a(e e)
    {
        if (b == null || b.a(e))
        {
            a.a(e);
        }
    }

    public boolean equals(Object obj)
    {
        if (obj != null)
        {
            if (obj instanceof k)
            {
                return ((k)obj).a.equals(a);
            }
            if (obj instanceof g)
            {
                return obj.equals(a);
            }
        }
        return false;
    }
}
