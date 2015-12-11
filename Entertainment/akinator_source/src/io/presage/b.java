// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage;


// Referenced classes of package io.presage:
//            Presage

final class b
    implements Runnable
{

    final Presage a;

    b(Presage presage)
    {
        a = presage;
        super();
    }

    public final void run()
    {
        Presage.access$002(a, false);
    }
}
