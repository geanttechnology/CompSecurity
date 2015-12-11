// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.a;

import java.util.Stack;

// Referenced classes of package org.simpleframework.xml.a:
//            b

public class e
    implements b
{

    private Stack a;

    public e()
    {
        a = new Stack();
    }

    public final String a(String s)
    {
        int i = a.size();
        do
        {
            i--;
            if (i >= 0)
            {
                String s1 = ((b)a.get(i)).a(s);
                if (s1 != null)
                {
                    return s1;
                }
            } else
            {
                return null;
            }
        } while (true);
    }

    public final void a(b b1)
    {
        a.push(b1);
    }
}
