// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            tv

public class xs extends Exception
{

    public final tv a;
    private long b;

    public xs()
    {
        a = null;
    }

    public xs(tv tv)
    {
        a = tv;
    }

    public xs(Throwable throwable)
    {
        super(throwable);
        a = null;
    }

    void a(long l)
    {
        b = l;
    }
}
