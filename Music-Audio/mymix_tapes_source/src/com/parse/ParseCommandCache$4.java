// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseCommandCache, ParseException, LocalIdManager

class val.localId
    implements Continuation
{

    final ParseCommandCache this$0;
    final String val$localId;
    final bolts.ource val$tcs;

    public Task then(Task task)
        throws Exception
    {
_L2:
        do
        {
            return task;
        } while ((obj instanceof ParseException) && ((ParseException)obj).getCode() == 100 || val$tcs == null);
        val$tcs.setError(((Exception) (obj)));
        return task;
        Object obj = task.getError();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_9;
        }
        obj = task.getResult();
        if (val$tcs != null)
        {
            val$tcs.setResult(obj);
            return task;
        }
        if (val$localId != null && (obj instanceof JSONObject) && ((JSONObject)obj).has("data") && ((JSONObject)obj).getJSONObject("data").has("objectId"))
        {
            obj = ((JSONObject)obj).getJSONObject("data").getString("objectId");
            LocalIdManager.getDefaultInstance().setObjectId(val$localId, ((String) (obj)));
            return task;
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    e()
    {
        this$0 = final_parsecommandcache;
        val$tcs = ource;
        val$localId = String.this;
        super();
    }
}
