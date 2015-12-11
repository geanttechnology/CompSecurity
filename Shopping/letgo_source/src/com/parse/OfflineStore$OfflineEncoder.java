// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseEncoder, OfflineStore, ParseObject, ParseSQLiteDatabase

private class db extends ParseEncoder
{

    private ParseSQLiteDatabase db;
    private ArrayList tasks;
    private final Object tasksLock = new Object();
    final OfflineStore this$0;

    public JSONObject encodeRelatedObject(ParseObject parseobject)
    {
        JSONObject jsonobject;
        if (parseobject.getObjectId() == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        jsonobject = new JSONObject();
        jsonobject.put("__type", "Pointer");
        jsonobject.put("objectId", parseobject.getObjectId());
        jsonobject.put("className", parseobject.getClassName());
        return jsonobject;
        final JSONObject result;
        result = new JSONObject();
        result.put("__type", "OfflineObject");
        synchronized (tasksLock)
        {
            tasks.add(OfflineStore.access$200(OfflineStore.this, parseobject, db).c(new ct() {

                final OfflineStore.OfflineEncoder this$1;
                final JSONObject val$result;

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

                public Void then(cu cu1)
                    throws Exception
                {
                    result.put("uuid", cu1.e());
                    return null;
                }

            
            {
                this$1 = OfflineStore.OfflineEncoder.this;
                result = jsonobject;
                super();
            }
            }));
        }
        return result;
        parseobject;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw parseobject;
        }
        // Misplaced declaration of an exception variable
        catch (ParseObject parseobject)
        {
            throw new RuntimeException(parseobject);
        }
    }

    public cu whenFinished()
    {
        return cu.a(tasks).b(new ct() {

            final OfflineStore.OfflineEncoder this$1;

            public cu then(cu cu1)
                throws Exception
            {
label0:
                {
                    cu cu3;
                    synchronized (tasksLock)
                    {
                        Iterator iterator = tasks.iterator();
                        do
                        {
                            if (!iterator.hasNext())
                            {
                                break label0;
                            }
                            cu3 = (cu)iterator.next();
                        } while (!cu3.d() && !cu3.c());
                    }
                    return cu3;
                }
                cu cu2;
                tasks.clear();
                cu2 = cu.a((Void)null);
                cu1;
                JVM INSTR monitorexit ;
                return cu2;
                exception;
                cu1;
                JVM INSTR monitorexit ;
                throw exception;
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$1 = OfflineStore.OfflineEncoder.this;
                super();
            }
        });
    }



    public _cls2.val.result(ParseSQLiteDatabase parsesqlitedatabase)
    {
        this$0 = OfflineStore.this;
        super();
        tasks = new ArrayList();
        db = parsesqlitedatabase;
    }
}
