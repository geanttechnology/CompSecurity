// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.b.a;


// Referenced classes of package android.support.b.a:
//            a

private static final class <init>
{

    ll a;

    public final void a(<init> <init>1)
    {
        this;
        JVM INSTR monitorenter ;
        a(<init>1);
        if (a == <init>1)
        {
            a = null;
        }
        notifyAll();
        this;
        JVM INSTR monitorexit ;
        return;
        <init>1;
        throw <init>1;
    }

    public final void b(ll ll)
    {
        if (a == ll)
        {
            a = null;
        }
        notifyAll();
    }

    private ()
    {
    }

    (byte byte0)
    {
        this();
    }
}
