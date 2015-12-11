// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import com.groupon.http.synchronous.SyncHttp;
import java.util.concurrent.Callable;

// Referenced classes of package com.groupon.manager:
//            AsyncHttp

class this._cls0
    implements Callable
{

    final AsyncHttp this$0;

    public Object call()
        throws Exception
    {
        return AsyncHttp.access$000(AsyncHttp.this).call();
    }

    cHttp()
    {
        this$0 = AsyncHttp.this;
        super();
    }
}
