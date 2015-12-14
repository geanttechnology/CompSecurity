// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseObject, ParseCommand

class val.sessionToken
    implements Callable
{

    final ParseObject this$0;
    final String val$sessionToken;

    public ParseCommand call()
        throws Exception
    {
        Object obj = mutex;
        obj;
        JVM INSTR monitorenter ;
        ParseCommand parsecommand;
        JSONObject jsonobject;
        parsecommand = new ParseCommand("get", val$sessionToken);
        parsecommand.enableRetrying();
        parsecommand.put("classname", ParseObject.access$900(ParseObject.this));
        jsonobject = new JSONObject();
        jsonobject.put("objectId", ParseObject.access$000(ParseObject.this));
        parsecommand.put("data", jsonobject);
        return parsecommand;
        Object obj1;
        obj1;
        throw new RuntimeException(((JSONException) (obj1)).getMessage());
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    n()
    {
        this$0 = final_parseobject;
        val$sessionToken = String.this;
        super();
    }
}
