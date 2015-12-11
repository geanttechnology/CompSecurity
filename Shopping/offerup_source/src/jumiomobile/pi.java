// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import java.io.Serializable;

// Referenced classes of package jumiomobile:
//            pj

public abstract class pi
    implements Serializable
{

    private Double a;

    public pi()
    {
    }

    public double a()
    {
        a = new Double(b());
        return a.doubleValue();
    }

    public abstract double b();

    public abstract String c();

    public Double d()
    {
        return a;
    }

    public abstract String e();

    public abstract pj f();
}
