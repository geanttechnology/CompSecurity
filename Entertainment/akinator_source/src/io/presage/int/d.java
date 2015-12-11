// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.int;


// Referenced classes of package io.presage.int:
//            c

final class d
    implements Runnable
{

    final String a;
    final c b;

    d(c c, String s)
    {
        b = c;
        a = s;
        super();
    }

    public final void run()
    {
        throw new RuntimeException(a);
    }
}
