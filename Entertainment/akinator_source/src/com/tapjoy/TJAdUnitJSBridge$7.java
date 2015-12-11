// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;


// Referenced classes of package com.tapjoy:
//            TJAdUnitJSBridge

final class a
    implements UnitAsyncTaskListner
{

    final String a;
    final TJAdUnitJSBridge b;

    public final void onComplete(boolean flag)
    {
        b.invokeJSCallback(a, new Object[] {
            Boolean.valueOf(flag)
        });
    }

    UnitAsyncTaskListner(TJAdUnitJSBridge tjadunitjsbridge, String s)
    {
        b = tjadunitjsbridge;
        a = s;
        super();
    }
}
