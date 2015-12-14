// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseObject, KnownParseObjectDecoder, ParseOperationSet

class Set
    implements Continuation
{

    final ParseObject this$0;
    final Map val$fetchedObjects;
    final ParseOperationSet val$operationsBeforeSave;
    final JSONObject val$result;

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    public Void then(Task task)
        throws Exception
    {
        synchronized (mutex)
        {
            KnownParseObjectDecoder knownparseobjectdecoder = new KnownParseObjectDecoder(val$fetchedObjects);
            ParseObject.access$100(ParseObject.this, val$result, knownparseobjectdecoder, val$operationsBeforeSave);
        }
        return null;
        exception;
        task;
        JVM INSTR monitorexit ;
        throw exception;
    }

    Set()
    {
        this$0 = final_parseobject;
        val$fetchedObjects = map;
        val$result = jsonobject;
        val$operationsBeforeSave = ParseOperationSet.this;
        super();
    }
}
