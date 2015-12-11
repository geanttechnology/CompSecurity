// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.f.a.a.a.a;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.google.api.a.f.a.a.a.a:
//            b, c

public static final class <init>
{
    private static final class a
    {

        public final StringBuilder a;
        public boolean b;

        private a()
        {
            a = new StringBuilder();
        }

        public a(byte byte0)
        {
            this();
        }
    }


    public final List a;
    private final String b;
    private boolean c;

    public final String toString()
    {
        boolean flag2 = c;
        StringBuilder stringbuilder = (new StringBuilder(32)).append(b).append('{');
        Iterator iterator = a.iterator();
        boolean flag = false;
        while (iterator.hasNext()) 
        {
            a a1 = (a)iterator.next();
            boolean flag1;
            if (flag2)
            {
                flag1 = flag;
                if (a1.b)
                {
                    continue;
                }
            }
            if (flag)
            {
                stringbuilder.append(", ");
            } else
            {
                flag = true;
            }
            stringbuilder.append(a1.a);
            flag1 = flag;
            flag = flag1;
        }
        return stringbuilder.append('}').toString();
    }

    private a(String s)
    {
        a = new LinkedList();
        c = false;
        b = (String)com.google.api.a.f.a.a.a.a.c.a(s);
    }

    public b(String s, byte byte0)
    {
        this(s);
    }
}
