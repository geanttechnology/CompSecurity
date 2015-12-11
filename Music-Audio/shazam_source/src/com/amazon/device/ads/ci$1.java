// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            cx, ci, f, bi

final class a
    implements cx
{

    final bi a;
    final ci b;

    public final void a(String s)
    {
        ci.a(b).b("mraidBridge.stateChange('expanded');");
        ci.a(b).b("mraidBridge.ready();");
        b.a(a, s);
    }

    (ci ci1, bi bi)
    {
        b = ci1;
        a = bi;
        super();
    }
}
