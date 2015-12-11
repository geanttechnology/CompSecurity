// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseObject, OfflineQueryLogic, ParseSQLiteDatabase

class this._cls1
    implements ct
{

    final l.key this$1;

    public Object then(cu cu)
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
            if (container instanceof ParseObject)
            {
                cu1 = OfflineQueryLogic.access$600(OfflineQueryLogic.this, container, null, db).c(new OfflineQueryLogic._cls20._cls1());
            } else
            {
                if (container instanceof Map)
                {
                    return cu.a(((Map)container).get(key));
                }
                if (container instanceof JSONObject)
                {
                    return cu.a(((JSONObject)container).opt(key));
                }
                if (!JSONObject.NULL.equals(container))
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

            
            {
                this$0 = final_offlinequerylogic;
                container = obj;
                db = parsesqlitedatabase;
                key = String.this;
                super();
            }
    }

}
