// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseObject, OfflineQueryLogic, ParseSQLiteDatabase

class this._cls1
    implements Continuation
{

    final l.key this$1;

    public Object then(Task task)
        throws Exception
    {
        return ((ParseObject)container).get(key);
    }

    l.key()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/parse/OfflineQueryLogic$20

/* anonymous class */
    class OfflineQueryLogic._cls20
        implements Continuation
    {

        final OfflineQueryLogic this$0;
        final Object val$container;
        final ParseSQLiteDatabase val$db;
        final String val$key;

        public Task then(Task task)
            throws Exception
        {
            if (container instanceof ParseObject)
            {
                return OfflineQueryLogic.access$600(OfflineQueryLogic.this, container, null, db).onSuccess(new OfflineQueryLogic._cls20._cls1());
            }
            if (container instanceof Map)
            {
                return Task.forResult(((Map)container).get(key));
            }
            if (container instanceof JSONObject)
            {
                return Task.forResult(((JSONObject)container).opt(key));
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

            
            {
                this$0 = final_offlinequerylogic;
                container = obj;
                db = parsesqlitedatabase;
                key = String.this;
                super();
            }
    }

}
