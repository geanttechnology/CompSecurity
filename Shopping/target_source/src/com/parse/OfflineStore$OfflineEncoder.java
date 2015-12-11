// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
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
            tasks.add(OfflineStore.access$200(OfflineStore.this, parseobject, db).c(new i() {

                final OfflineStore.OfflineEncoder this$1;
                final JSONObject val$result;

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

                public Void then(j j1)
                    throws Exception
                {
                    result.put("uuid", j1.e());
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

    public j whenFinished()
    {
        return j.a(tasks).b(new i() {

            final OfflineStore.OfflineEncoder this$1;

            public j then(j j1)
                throws Exception
            {
label0:
                {
                    j j3;
                    synchronized (tasksLock)
                    {
                        Iterator iterator = tasks.iterator();
                        do
                        {
                            if (!iterator.hasNext())
                            {
                                break label0;
                            }
                            j3 = (j)iterator.next();
                        } while (!j3.d() && !j3.c());
                    }
                    return j3;
                }
                j j2;
                tasks.clear();
                j2 = j.a((Void)null);
                j1;
                JVM INSTR monitorexit ;
                return j2;
                exception;
                j1;
                JVM INSTR monitorexit ;
                throw exception;
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
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
