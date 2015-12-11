// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;


// Referenced classes of package com.tapjoy:
//            TJAdUnitJSBridge, TJAdUnitActivity

final class a
    implements Runnable
{

    final boolean a;
    final TJAdUnitJSBridge b;

    public final void run()
    {
        ((TJAdUnitActivity)TJAdUnitJSBridge.d(b)).setCloseButtonVisibility(a);
    }

    (TJAdUnitJSBridge tjadunitjsbridge, boolean flag)
    {
        b = tjadunitjsbridge;
        a = flag;
        super();
    }
}
