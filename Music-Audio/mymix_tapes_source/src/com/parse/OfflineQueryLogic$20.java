// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            OfflineQueryLogic, ParseObject, ParseSQLiteDatabase

class val.key
    implements Continuation
{

    final OfflineQueryLogic this$0;
    final Object val$container;
    final ParseSQLiteDatabase val$db;
    final String val$key;

    public Task then(Task task)
        throws Exception
    {
        if (val$container instanceof ParseObject)
        {
            return OfflineQueryLogic.access$600(OfflineQueryLogic.this, val$container, null, val$db).onSuccess(new Continuation() {

                final OfflineQueryLogic._cls20 this$1;

                public Object then(Task task1)
                    throws Exception
                {
                    return ((ParseObject)container).get(key);
                }

            
            {
                this$1 = OfflineQueryLogic._cls20.this;
                super();
            }
            });
        }
        if (val$container instanceof Map)
        {
            return Task.forResult(((Map)val$container).get(val$key));
        }
        if (val$container instanceof JSONObject)
        {
            return Task.forResult(((JSONObject)val$container).opt(val$key));
        } else
        {
            return Task.forError(new IllegalStateException("include is invalid"));
        }
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    _cls1.this._cls1()
    {
        this$0 = final_offlinequerylogic;
        val$container = obj;
        val$db = parsesqlitedatabase;
        val$key = String.this;
        super();
    }
}
