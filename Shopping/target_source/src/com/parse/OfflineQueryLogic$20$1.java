// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseObject, OfflineQueryLogic, ParseSQLiteDatabase, OfflineStore

class this._cls0
    implements i
{

    final l.key this$0;

    public Object then(j j)
        throws Exception
    {
        return ((ParseObject)container).get(key);
    }

    l.key()
    {
        this$0 = this._cls0.this;
        super();
    }

    // Unreferenced inner class com/parse/OfflineQueryLogic$20

/* anonymous class */
    static final class OfflineQueryLogic._cls20
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
            if (container instanceof ParseObject)
            {
                j1 = OfflineQueryLogic.access$600(store, container, null, db).c(new OfflineQueryLogic._cls20._cls1());
            } else
            {
                if (container instanceof Map)
                {
                    return j.a(((Map)container).get(key));
                }
                if (container instanceof JSONObject)
                {
                    return j.a(((JSONObject)container).opt(key));
                }
                if (!JSONObject.NULL.equals(container))
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

            
            {
                container = obj;
                store = offlinestore;
                db = parsesqlitedatabase;
                key = s;
                super();
            }
    }

}
