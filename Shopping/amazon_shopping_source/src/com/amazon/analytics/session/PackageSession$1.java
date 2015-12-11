// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics.session;

import com.amazon.analytics.util.Message;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.analytics.session:
//            PackageSession, SessionObserver

class tRunId
    implements Runnable
{

    final Message m;
    final int runId;
    final PackageSession this$0;
    final Message val$message;

    public void run()
    {
        m.getExtras().put("SessionFlag", Integer.valueOf(2));
        m.getExtras().put("SessionRunId", Integer.valueOf(runId));
        sessionObserver.onUpdate(m);
    }

    ()
    {
        this$0 = final_packagesession;
        val$message = Message.this;
        super();
        m = new Message(val$message.getType(), new HashMap(val$message.getExtras()));
        runId = getRunId();
    }
}
