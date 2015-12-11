// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.a;


// Referenced classes of package org.simpleframework.xml.a:
//            b

public final class f
    implements b
{

    private b a;

    public f()
    {
        this((byte)0);
    }

    private f(byte byte0)
    {
        a = null;
    }

    public final String a(String s)
    {
        String s1 = System.getProperty(s);
        if (s1 != null)
        {
            return s1;
        }
        if (a != null)
        {
            return a.a(s);
        } else
        {
            return null;
        }
    }
}
