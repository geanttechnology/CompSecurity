// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack.util.a;


// Referenced classes of package org.jivesoftware.smack.util.a:
//            b

public class c extends b
    implements Comparable
{

    private int a;
    private int b;

    public int a(c c1)
    {
        int j = c1.b - b;
        int i = j;
        if (j == 0)
        {
            i = a - c1.a;
        }
        return i;
    }

    public int compareTo(Object obj)
    {
        return a((c)obj);
    }

    public int d()
    {
        return b;
    }

    public int e()
    {
        return a;
    }

    public String toString()
    {
        return (new StringBuilder()).append(super.toString()).append(" prio:").append(b).append(":w:").append(a).toString();
    }
}
