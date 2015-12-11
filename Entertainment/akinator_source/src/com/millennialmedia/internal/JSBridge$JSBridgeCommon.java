// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import com.millennialmedia.MMLog;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.internal:
//            JSBridge

class this._cls0
{

    final JSBridge this$0;

    public void fileLoaded(String s)
        throws JSONException
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(JSBridge.access$000(), (new StringBuilder()).append("fileLoaded: ").append(s).toString());
        }
        s = new JSONObject(s);
        scriptsAwaitingLoad.remove(s.getString("filename"));
        if (scriptsAwaitingLoad.size() == 0)
        {
            if (JSBridge.access$300(JSBridge.this) != null)
            {
                JSBridge.access$300(JSBridge.this).onInjectedScriptsLoaded();
            }
            setReadyState();
        }
    }

    public String getActionsQueue()
    {
        JSBridge jsbridge = JSBridge.this;
        jsbridge;
        JVM INSTR monitorenter ;
        String s;
        if (JSBridge.access$200(JSBridge.this) == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        s = JSBridge.access$200(JSBridge.this).toString();
        JSBridge.access$202(JSBridge.this, null);
        return s;
        jsbridge;
        JVM INSTR monitorexit ;
        return null;
        Exception exception;
        exception;
        jsbridge;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Boolean useActionsQueue()
    {
        return Boolean.valueOf(JSBridge.useActionsQueue);
    }

    r()
    {
        this$0 = JSBridge.this;
        super();
    }
}
