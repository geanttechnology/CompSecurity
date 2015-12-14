// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.database.Cursor;
import bolts.Capture;
import bolts.Continuation;
import bolts.Task;
import java.util.List;

// Referenced classes of package com.parse:
//            OfflineStore, OfflineQueryLogic, ParseSQLiteDatabase, ParseQuery, 
//            ParseUser, ParseObject

class val.object
    implements Continuation
{

    final val.object this$1;
    final Capture val$object;

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    public Void then(Task task)
    {
        if (((Boolean)task.getResult()).booleanValue())
        {
            results.add(val$object.get());
        }
        return null;
    }

    l.results()
    {
        this$1 = final_results;
        val$object = Capture.this;
        super();
    }

    // Unreferenced inner class com/parse/OfflineStore$8

/* anonymous class */
    class OfflineStore._cls8
        implements Continuation
    {

        final OfflineStore this$0;
        final ParseSQLiteDatabase val$db;
        final boolean val$ignoreACLs;
        final ParseQuery val$query;
        final OfflineQueryLogic val$queryLogic;
        final List val$results;
        final ParseUser val$user;

        public Task then(Task task)
            throws Exception
        {
            Cursor cursor = (Cursor)task.getResult();
            final OfflineQueryLogic.ConstraintMatcher matcher = queryLogic.createMatcher(query, user, ignoreACLs);
            task = Task.forResult(null);
            cursor.moveToFirst();
            for (; !cursor.isAfterLast(); cursor.moveToNext())
            {
                final String uuid = cursor.getString(0);
                final Capture object = new Capture();
                task = task.onSuccessTask(new OfflineStore._cls8._cls4()).onSuccessTask(new OfflineStore._cls8._cls3()).onSuccessTask(new OfflineStore._cls8._cls2()).onSuccess(object. new OfflineStore._cls8._cls1());
            }

            return task;
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                this$0 = final_offlinestore;
                queryLogic = offlinequerylogic;
                query = parsequery;
                user = parseuser;
                ignoreACLs = flag;
                db = parsesqlitedatabase;
                results = List.this;
                super();
            }

        // Unreferenced inner class com/parse/OfflineStore$8$2

/* anonymous class */
        class OfflineStore._cls8._cls2
            implements Continuation
        {

            final OfflineStore._cls8 this$1;
            final OfflineQueryLogic.ConstraintMatcher val$matcher;
            final Capture val$object;

            public Task then(Task task)
                throws Exception
            {
                if (!((ParseObject)object.get()).isDataAvailable())
                {
                    return Task.forResult(Boolean.valueOf(false));
                } else
                {
                    return matcher.matchesAsync((ParseObject)object.get(), db);
                }
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

                    
                    {
                        this$1 = OfflineStore._cls8.this;
                        object = capture;
                        matcher = constraintmatcher;
                        super();
                    }
        }


        // Unreferenced inner class com/parse/OfflineStore$8$3

/* anonymous class */
        class OfflineStore._cls8._cls3
            implements Continuation
        {

            final OfflineStore._cls8 this$1;
            final Capture val$object;

            public Task then(Task task)
                throws Exception
            {
                object.set(task.getResult());
                return fetchLocallyAsync((ParseObject)object.get(), db);
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

                    
                    {
                        this$1 = OfflineStore._cls8.this;
                        object = capture;
                        super();
                    }
        }


        // Unreferenced inner class com/parse/OfflineStore$8$4

/* anonymous class */
        class OfflineStore._cls8._cls4
            implements Continuation
        {

            final OfflineStore._cls8 this$1;
            final String val$uuid;

            public Task then(Task task)
                throws Exception
            {
                return OfflineStore.access$600(this$0, uuid, db);
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

                    
                    {
                        this$1 = OfflineStore._cls8.this;
                        uuid = s;
                        super();
                    }
        }

    }

}
