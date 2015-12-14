// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database;


// Referenced classes of package com.cyberlink.youcammakeup.database:
//            l

public class j extends l
{

    protected long a;

    protected j(long l1, int i, int k, long l2, String s, 
            String s1, String s2, String s3, String s4)
    {
        super(i, k, l2, s, s1, s2, s3, s4);
        a = l1;
    }

    protected j(long l1, l l2)
    {
        super(l2);
        a = l1;
    }

    public long a()
    {
        return a;
    }

    public String toString()
    {
        String s = super.toString();
        return (new StringBuilder()).append("ID: ").append(a).append(", ").append(s).toString();
    }
}
