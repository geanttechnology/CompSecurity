// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.extension.medialets;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import tv.freewheel.hybrid.utils.Logger;

// Referenced classes of package tv.freewheel.hybrid.extension.medialets:
//            MedialetsExtension

class this._cls0
    implements InvocationHandler
{

    final MedialetsExtension this$0;

    public Object invoke(Object obj, Method method, Object aobj[])
        throws Throwable
    {
        if (method.getName().equals("onServiceConnected"))
        {
            MedialetsExtension.access$600(MedialetsExtension.this).debug("The Proxy is called back to launch onServiceConnected");
            MedialetsExtension.access$900(MedialetsExtension.this);
        }
        return null;
    }

    ()
    {
        this$0 = MedialetsExtension.this;
        super();
    }
}
