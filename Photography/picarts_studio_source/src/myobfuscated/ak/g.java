// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ak;


// Referenced classes of package myobfuscated.ak:
//            f

final class g extends f
{

    private volatile boolean a;

    private g()
    {
        super((byte)0);
    }

    g(byte byte0)
    {
        this();
    }

    public final void a(boolean flag)
    {
        a = flag;
    }

    public final void b()
    {
        if (a)
        {
            throw new IllegalStateException("Already released");
        } else
        {
            return;
        }
    }
}
