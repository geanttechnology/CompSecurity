// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.b.a;


// Referenced classes of package org.b.a:
//            f

public abstract class b extends f
    implements org.b.b
{

    public b()
    {
    }

    public volatile String a()
    {
        return super.a();
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getName()).append("(").append(a()).append(")").toString();
    }
}
