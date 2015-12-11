// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.a.a;

import com.google.api.a.d.m;
import com.google.api.a.d.p;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.google.api.a.a.a:
//            f

static final class 
    implements 
{

    public final String a(p p1)
    {
label0:
        {
            p1 = p1.b.authorization;
            if (p1 == null)
            {
                break label0;
            }
            p1 = p1.iterator();
            String s;
            do
            {
                if (!p1.hasNext())
                {
                    break label0;
                }
                s = (String)p1.next();
            } while (!s.startsWith("Bearer "));
            return s.substring(7);
        }
        return null;
    }

    public final void a(p p1, String s)
    {
        m m1 = p1.b;
        p1 = String.valueOf("Bearer ");
        s = String.valueOf(s);
        if (s.length() != 0)
        {
            p1 = p1.concat(s);
        } else
        {
            p1 = new String(p1);
        }
        m1.a(p1);
    }

    ()
    {
    }
}
