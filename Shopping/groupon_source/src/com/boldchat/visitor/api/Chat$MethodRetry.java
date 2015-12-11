// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api;

import com.boldchat.visitor.api.internal.RPCMethod;
import com.boldchat.visitor.api.internal.ResultListener;
import com.boldchat.visitor.api.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;

// Referenced classes of package com.boldchat.visitor.api:
//            Chat

private class <init>
    implements Runnable
{

    final Chat this$0;
    RPCMethod topMethod;

    public void run()
    {
        long l = 15L;
        if (Chat.access$2900(Chat.this) <= 15L) goto _L2; else goto _L1
_L1:
        Thread.sleep(l);
_L3:
        synchronized (Chat.access$100(Chat.this))
        {
            if (Chat.access$100(Chat.this).size() > 0)
            {
                topMethod = (RPCMethod)Chat.access$100(Chat.this).remove(0);
            }
        }
        if (topMethod != null && Chat.access$2400(Chat.this) == null)
        {
            Chat.access$3000(Chat.this, topMethod.getMethod(), topMethod.getParams(), new ResultListener() {

                final Chat.MethodRetry this$1;

                public void failure(int i, String s, JSONObject jsonobject)
                {
                    Chat.access$2908(this$0);
                    synchronized (Chat.access$100(this$0))
                    {
                        Chat.access$100(this$0).add(0, topMethod);
                    }
                    (new Thread(Chat.access$202(this$0, new Chat.MethodRetry(null)))).start();
                    return;
                    jsonobject;
                    s;
                    JVM INSTR monitorexit ;
                    throw jsonobject;
                }

                public void failure(IOException ioexception)
                {
                    failure(-1, ioexception.getMessage(), null);
                }

                public void success(JSONObject jsonobject)
                {
                    Chat.access$2902(this$0, 0L);
                    topMethod.getListener().success(jsonobject);
                    (new Thread(Chat.access$202(this$0, new Chat.MethodRetry(null)))).start();
                }

            
            {
                this$1 = Chat.MethodRetry.this;
                super();
            }
            });
            return;
        } else
        {
            Chat.access$202(Chat.this, null);
            return;
        }
_L2:
        l = Chat.access$2900(Chat.this);
        l *= 2000L;
          goto _L1
        obj;
        ((InterruptedException) (obj)).printStackTrace();
          goto _L3
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
          goto _L1
    }

    private _cls1.this._cls1()
    {
        this$0 = Chat.this;
        super();
        topMethod = null;
    }

    topMethod(topMethod topmethod)
    {
        this();
    }
}
