// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseObject, OfflineStore, ParseException, ParseTraverser, 
//            ParseSQLiteDatabase

class val.offlineObjects
    implements Continuation
{

    final val.offlineObjects this$1;
    final JSONObject val$json;
    final Map val$offlineObjects;

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    public Void then(Task task)
        throws Exception
    {
        object.mergeREST(val$json, new neDecoder(_fld0, val$offlineObjects, null));
        return null;
    }

    l.object()
    {
        this$1 = final_object;
        val$json = jsonobject;
        val$offlineObjects = Map.this;
        super();
    }

    // Unreferenced inner class com/parse/OfflineStore$13

/* anonymous class */
    class OfflineStore._cls13
        implements Continuation
    {

        final OfflineStore this$0;
        final ParseSQLiteDatabase val$db;
        final ParseObject val$object;

        public Task then(final Task json)
            throws Exception
        {
            json = (String)json.getResult();
            if (json == null)
            {
                return Task.forError(new ParseException(120, "Attempted to fetch an object offline which was never saved to the offline cache."));
            }
            final HashMap offlineObjects;
            try
            {
                json = new JSONObject(json);
            }
            // Misplaced declaration of an exception variable
            catch (final Task json)
            {
                return Task.forError(json);
            }
            offlineObjects = new HashMap();
            (new OfflineStore._cls13._cls1()).setTraverseParseObjects(false).setYieldRoot(false).traverse(json);
            return Task.whenAll(offlineObjects.values()).onSuccess(offlineObjects. new OfflineStore._cls13._cls2());
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                this$0 = final_offlinestore;
                db = parsesqlitedatabase;
                object = ParseObject.this;
                super();
            }

        // Unreferenced inner class com/parse/OfflineStore$13$1

/* anonymous class */
        class OfflineStore._cls13._cls1 extends ParseTraverser
        {

            final OfflineStore._cls13 this$1;
            final Map val$offlineObjects;

            protected boolean visit(Object obj)
            {
                if ((obj instanceof JSONObject) && ((JSONObject)obj).optString("__type").equals("OfflineObject"))
                {
                    obj = ((JSONObject)obj).optString("uuid");
                    offlineObjects.put(obj, OfflineStore.access$600(this$0, ((String) (obj)), db));
                }
                return true;
            }

                    
                    {
                        this$1 = OfflineStore._cls13.this;
                        offlineObjects = map;
                        super();
                    }
        }

    }

}
