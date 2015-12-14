// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.parse:
//            ParseObjectEncodingStrategy, OfflineStore, ParseObject, ParseSQLiteDatabase

private class db
    implements ParseObjectEncodingStrategy
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
            tasks.add(OfflineStore.access$200(OfflineStore.this, parseobject, db).onSuccess(new Continuation() {

                final OfflineStore.OfflineEncodingStrategy this$1;
                final JSONObject val$result;

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

                public Void then(Task task)
                    throws Exception
                {
                    result.put("uuid", task.getResult());
                    return null;
                }

            
            {
                this$1 = OfflineStore.OfflineEncodingStrategy.this;
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

    public Task whenFinished()
    {
        return Task.whenAll(tasks).continueWithTask(new Continuation() {

            final OfflineStore.OfflineEncodingStrategy this$1;

            public Task then(Task task)
                throws Exception
            {
label0:
                {
                    Task task2;
                    synchronized (tasksLock)
                    {
                        Iterator iterator = tasks.iterator();
                        do
                        {
                            if (!iterator.hasNext())
                            {
                                break label0;
                            }
                            task2 = (Task)iterator.next();
                        } while (!task2.isFaulted() && !task2.isCancelled());
                    }
                    return task2;
                }
                Task task1;
                tasks.clear();
                task1 = Task.forResult((Void)null);
                task;
                JVM INSTR monitorexit ;
                return task1;
                exception;
                task;
                JVM INSTR monitorexit ;
                throw exception;
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$1 = OfflineStore.OfflineEncodingStrategy.this;
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
