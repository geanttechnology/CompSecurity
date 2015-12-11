// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.client;

import com.amazon.retailsearch.log.MessageLogger;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

// Referenced classes of package com.amazon.retailsearch.client:
//            UiInvocationHandler

class val.args
    implements Runnable
{

    final UiInvocationHandler this$0;
    final Object val$args[];
    final Method val$method;

    public void run()
    {
        Object obj = UiInvocationHandler.access$000(UiInvocationHandler.this).get();
        if (obj == null)
        {
            return;
        }
        try
        {
            val$method.invoke(obj, val$args);
            return;
        }
        catch (Exception exception)
        {
            UiInvocationHandler.access$100().error((new StringBuilder()).append("Failed to invoke method ").append(val$method.getName()).toString(), exception);
        }
    }

    ()
    {
        this$0 = final_uiinvocationhandler;
        val$method = method1;
        val$args = _5B_Ljava.lang.Object_3B_.this;
        super();
    }
}
