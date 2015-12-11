// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;
import java.util.List;

public final class t
{

    public final String a;
    public final String b;
    public final List c;
    public final boolean d;

    t(String s, String s1, List list, boolean flag)
    {
        a = s;
        b = s1;
        c = list;
        d = flag;
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("Server Correlation Context:\n");
        stringbuilder.append("\tClient Request GUID: ").append(a).append("\n");
        stringbuilder.append("\tServer Snapshot: ");
        if (b == null)
        {
            stringbuilder.append("none");
        } else
        {
            stringbuilder.append(b);
        }
        stringbuilder.append("\n");
        stringbuilder.append("\tServer Entry Point Errors: ").append(d).append("\n");
        if (!c.isEmpty())
        {
            stringbuilder.append("\tBusiness Transactions:\n");
            u u1;
            for (Iterator iterator = c.iterator(); iterator.hasNext(); stringbuilder.append("\t").append(u1.toString()).append("\n"))
            {
                u1 = (u)iterator.next();
            }

        }
        return stringbuilder.toString();
    }
}
