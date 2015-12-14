// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.util.Set;
import java.util.concurrent.Callable;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseUser

class 
    implements Callable
{

    final ParseUser this$0;
    final JSONObject val$authData;
    final String val$authType;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public Void call()
        throws Exception
    {
        synchronized (mutex)
        {
            ParseUser.access$900(ParseUser.this).put(val$authType, val$authData);
            ParseUser.access$1000(ParseUser.this).add(val$authType);
            ParseUser.access$1300(ParseUser.this);
            ParseUser.access$502(ParseUser.this, true);
        }
        return null;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    llable()
    {
        this$0 = final_parseuser;
        val$authType = s;
        val$authData = JSONObject.this;
        super();
    }
}
