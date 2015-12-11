// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            OfflineQueryLogic, ParseObject, ParseSQLiteDatabase

class val.key
    implements ct
{

    final OfflineQueryLogic this$0;
    final Object val$container;
    final ParseSQLiteDatabase val$db;
    final String val$key;

    public cu then(cu cu1)
        throws Exception
    {
        cu1 = null;
        if (val$container instanceof ParseObject)
        {
            cu1 = OfflineQueryLogic.access$600(OfflineQueryLogic.this, val$container, null, val$db).c(new ct() {

                final OfflineQueryLogic._cls20 this$1;

                public Object then(cu cu2)
                    throws Exception
                {
                    return ((ParseObject)container).get(key);
                }

            
            {
                this$1 = OfflineQueryLogic._cls20.this;
                super();
            }
            });
        } else
        {
            if (val$container instanceof Map)
            {
                return cu.a(((Map)val$container).get(val$key));
            }
            if (val$container instanceof JSONObject)
            {
                return cu.a(((JSONObject)val$container).opt(val$key));
            }
            if (!JSONObject.NULL.equals(val$container))
            {
                return cu.a(new IllegalStateException("include is invalid"));
            }
        }
        return cu1;
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
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
