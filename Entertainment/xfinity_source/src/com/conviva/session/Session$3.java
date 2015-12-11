// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.conviva.session;

import com.conviva.utils.PlatformUtils;
import java.util.Map;
import java.util.concurrent.Callable;

// Referenced classes of package com.conviva.session:
//            Session

class .With1
    implements Callable
{

    final Session this$0;
    final com.conviva.utils.thParameters.With1 val$encodeCbk;
    final Map val$heartbeat;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public Void call()
        throws Exception
    {
        Session.access$200(Session.this).jsonEncode(val$heartbeat, val$encodeCbk);
        return null;
    }

    .With1()
    {
        this$0 = final_session;
        val$heartbeat = map;
        val$encodeCbk = com.conviva.utils.thParameters.With1.this;
        super();
    }
}
