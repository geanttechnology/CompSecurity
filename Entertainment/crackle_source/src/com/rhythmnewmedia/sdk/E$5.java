// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk;


// Referenced classes of package com.rhythmnewmedia.sdk:
//            E, M, G

final class a
    implements Runnable
{

    final G a;
    final E b;

    public final void run()
    {
        M m = new M(b.getContext(), b, a);
        a.g = m;
    }

    (E e, G g)
    {
        b = e;
        a = g;
        super();
    }
}
