// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Capture;
import bolts.Continuation;
import bolts.Task;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseUser, OfflineStore, ParseOperationSet

class val.commandResult
    implements Continuation
{

    final val.commandResult this$1;
    final JSONObject val$commandResult;

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    public JSONObject then(Task task)
        throws Exception
    {
        return val$commandResult;
    }

    l.operations()
    {
        this$1 = final_operations;
        val$commandResult = JSONObject.this;
        super();
    }

    // Unreferenced inner class com/parse/ParseUser$19

/* anonymous class */
    class ParseUser._cls19
        implements Continuation
    {

        final ParseUser this$0;
        final Capture val$operations;

        public Task then(Task task)
            throws Exception
        {
            task = (JSONObject)task.getResult();
            if (OfflineStore.isEnabled() && !task.optBoolean("is_new"))
            {
                return Task.forResult(task);
            } else
            {
                return handleSaveResultAsync(task, (ParseOperationSet)operations.get()).onSuccess(task. new ParseUser._cls19._cls1());
            }
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                this$0 = final_parseuser;
                operations = Capture.this;
                super();
            }
    }

}
