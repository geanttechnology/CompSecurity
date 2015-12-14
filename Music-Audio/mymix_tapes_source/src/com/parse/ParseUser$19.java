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

class 
    implements Continuation
{

    final ParseUser this$0;
    final Capture val$operations;

    public Task then(final Task commandResult)
        throws Exception
    {
        commandResult = (JSONObject)commandResult.getResult();
        if (OfflineStore.isEnabled() && !commandResult.optBoolean("is_new"))
        {
            return Task.forResult(commandResult);
        } else
        {
            return handleSaveResultAsync(commandResult, (ParseOperationSet)val$operations.get()).onSuccess(new Continuation() {

                final ParseUser._cls19 this$1;
                final JSONObject val$commandResult;

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

                public JSONObject then(Task task)
                    throws Exception
                {
                    return commandResult;
                }

            
            {
                this$1 = ParseUser._cls19.this;
                commandResult = jsonobject;
                super();
            }
            });
        }
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    ()
    {
        this$0 = final_parseuser;
        val$operations = Capture.this;
        super();
    }
}
