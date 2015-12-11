// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseTraverser, OfflineStore, ParseException, ParseSQLiteDatabase, 
//            ParseObject

class it> extends ParseTraverser
{

    final l.db this$1;
    final Map val$offlineObjects;

    protected boolean visit(Object obj)
    {
        if ((obj instanceof JSONObject) && ((JSONObject)obj).optString("__type").equals("OfflineObject"))
        {
            obj = ((JSONObject)obj).optString("uuid");
            val$offlineObjects.put(obj, OfflineStore.access$600(_fld0, ((String) (obj)), db));
        }
        return true;
    }

    l.object()
    {
        this$1 = final_object;
        val$offlineObjects = Map.this;
        super();
    }

    // Unreferenced inner class com/parse/OfflineStore$11

/* anonymous class */
    class OfflineStore._cls11
        implements ct
    {

        final OfflineStore this$0;
        final ParseSQLiteDatabase val$db;
        final ParseObject val$object;

        public cu then(final cu json)
            throws Exception
        {
            json = (String)json.e();
            if (json == null)
            {
                return cu.a(new ParseException(120, "Attempted to fetch an object offline which was never saved to the offline cache."));
            }
            final HashMap offlineObjects;
            try
            {
                json = JSONObjectInstrumentation.init(json);
            }
            // Misplaced declaration of an exception variable
            catch (final cu json)
            {
                return cu.a(json);
            }
            offlineObjects = new HashMap();
            (offlineObjects. new OfflineStore._cls11._cls1()).setTraverseParseObjects(false).setYieldRoot(false).traverse(json);
            return cu.a(offlineObjects.values()).c(new OfflineStore._cls11._cls2());
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                this$0 = final_offlinestore;
                db = parsesqlitedatabase;
                object = ParseObject.this;
                super();
            }

        // Unreferenced inner class com/parse/OfflineStore$11$2

/* anonymous class */
        class OfflineStore._cls11._cls2
            implements ct
        {

            final OfflineStore._cls11 this$1;
            final JSONObject val$json;
            final Map val$offlineObjects;

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            public Void then(cu cu1)
                throws Exception
            {
                object.mergeREST(object.getState(), json, new OfflineStore.OfflineDecoder(this$0, offlineObjects, null));
                return null;
            }

                    
                    {
                        this$1 = OfflineStore._cls11.this;
                        json = jsonobject;
                        offlineObjects = map;
                        super();
                    }
        }

    }

}
