// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.core;


// Referenced classes of package com.smule.android.network.core:
//            a, u

final class b
    implements Runnable
{

    final u a;
    final Object b;

    public void run()
    {
        a.handleResponse(b);
    }

    (u u1, Object obj)
    {
        a = u1;
        b = obj;
        super();
    }
}
