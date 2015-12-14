// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.utility;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.beautycircle.utility:
//            u

public class v
{

    private Collection a;

    public v()
    {
        a = new HashSet();
    }

    public void a()
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); ((u)iterator.next()).a()) { }
    }

    public void a(u u1)
    {
        if (u1 == null)
        {
            return;
        } else
        {
            a.add(u1);
            return;
        }
    }

    public boolean b(u u1)
    {
        if (u1 == null)
        {
            return false;
        } else
        {
            return a.remove(u1);
        }
    }
}
