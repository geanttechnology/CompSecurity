// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.b;


// Referenced classes of package com.offerup.android.b:
//            c

final class d
    implements Runnable
{

    private Object a;
    private c b;

    d(c c1, Object obj)
    {
        b = c1;
        a = obj;
        super();
    }

    public final void run()
    {
        b.post(a);
    }
}
