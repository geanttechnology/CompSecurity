// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseObject, KnownParseObjectDecoder

class val.result
    implements Continuation
{

    final ParseObject this$0;
    final Map val$fetchedObjects;
    final JSONObject val$result;

    public Task then(Task task)
        throws Exception
    {
        synchronized (mutex)
        {
            ParseObject.access$700(ParseObject.this).clear();
            ParseObject.access$800(ParseObject.this).clear();
            KnownParseObjectDecoder knownparseobjectdecoder = new KnownParseObjectDecoder(val$fetchedObjects);
            mergeAfterFetch(val$result, knownparseobjectdecoder, true);
        }
        return null;
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

    tDecoder()
    {
        this$0 = final_parseobject;
        val$fetchedObjects = map;
        val$result = JSONObject.this;
        super();
    }
}
