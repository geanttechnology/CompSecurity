// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            akh, alh

static final class b
    implements Runnable
{

    final alh a;
    final RuntimeException b;

    public void run()
    {
        throw new RuntimeException((new StringBuilder()).append("Transformation ").append(a.a()).append(" crashed with exception.").toString(), b);
    }

    n(alh alh1, RuntimeException runtimeexception)
    {
        a = alh1;
        b = runtimeexception;
        super();
    }
}
