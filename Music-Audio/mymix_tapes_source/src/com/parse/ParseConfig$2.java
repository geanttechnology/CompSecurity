// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseConfig, ParseDecoder, Parse

static final class 
    implements Continuation
{

    public ParseConfig then(Task task)
        throws Exception
    {
        ParseConfig parseconfig = new ParseConfig((JSONObject)task.getResult(), new ParseDecoder());
        ParseConfig.access$100(parseconfig, Parse.applicationContext, "currentConfig");
        synchronized (ParseConfig.access$200())
        {
            ParseConfig.access$302(parseconfig);
            parseconfig = ParseConfig.access$300();
        }
        return parseconfig;
        exception;
        task;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ()
    {
    }
}
