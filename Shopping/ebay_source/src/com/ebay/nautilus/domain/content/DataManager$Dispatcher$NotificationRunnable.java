// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content;

import java.lang.reflect.Method;

// Referenced classes of package com.ebay.nautilus.domain.content:
//            DataManager

private final class args
    implements Runnable
{

    public final Object args[];
    public final Method method;
    final args this$0;

    public void run()
    {
        args.this.args(method, args);
    }

    public (Method method1, Object aobj[])
    {
        this$0 = this._cls0.this;
        super();
        method = method1;
        args = aobj;
    }
}
