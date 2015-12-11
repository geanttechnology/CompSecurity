// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            OfflineQueryLogic, ParseObject, ParseSQLiteDatabase, OfflineStore

static final class val.key
    implements i
{

    final Object val$container;
    final ParseSQLiteDatabase val$db;
    final String val$key;
    final OfflineStore val$store;

    public j then(j j1)
        throws Exception
    {
        j1 = null;
        if (val$container instanceof ParseObject)
        {
            j1 = OfflineQueryLogic.access$600(val$store, val$container, null, val$db).c(new i() {

                final OfflineQueryLogic._cls20 this$0;

                public Object then(j j2)
                    throws Exception
                {
                    return ((ParseObject)container).get(key);
                }

            
            {
                this$0 = OfflineQueryLogic._cls20.this;
                super();
            }
            });
        } else
        {
            if (val$container instanceof Map)
            {
                return j.a(((Map)val$container).get(val$key));
            }
            if (val$container instanceof JSONObject)
            {
                return j.a(((JSONObject)val$container).opt(val$key));
            }
            if (!JSONObject.NULL.equals(val$container))
            {
                return j.a(new IllegalStateException("include is invalid"));
            }
        }
        return j1;
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    _cls1.this._cls0(Object obj, OfflineStore offlinestore, ParseSQLiteDatabase parsesqlitedatabase, String s)
    {
        val$container = obj;
        val$store = offlinestore;
        val$db = parsesqlitedatabase;
        val$key = s;
        super();
    }
}
