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

class val.results
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
        final ic.ConstraintMatcher matcher = val$queryLogic.createMatcher(val$query, val$user, val$ignoreACLs);
        task = Task.forResult(null);
        cursor.moveToFirst();
        for (; !cursor.isAfterLast(); cursor.moveToNext())
        {
            final String uuid = cursor.getString(0);
            final Capture object = new Capture();
            task = task.onSuccessTask(new Continuation() {

                final OfflineStore._cls8 this$1;
                final String val$uuid;

                public Task then(Task task1)
                    throws Exception
                {
                    return OfflineStore.access$600(this$0, uuid, db);
                }

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

            
            {
                this$1 = OfflineStore._cls8.this;
                uuid = s;
                super();
            }
            }).onSuccessTask(new Continuation() {

                final OfflineStore._cls8 this$1;
                final Capture val$object;

                public Task then(Task task1)
                    throws Exception
                {
                    object.set(task1.getResult());
                    return fetchLocallyAsync((ParseObject)object.get(), db);
                }

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

            
            {
                this$1 = OfflineStore._cls8.this;
                object = capture;
                super();
            }
            }).onSuccessTask(new Continuation() {

                final OfflineStore._cls8 this$1;
                final OfflineQueryLogic.ConstraintMatcher val$matcher;
                final Capture val$object;

                public Task then(Task task1)
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

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

            
            {
                this$1 = OfflineStore._cls8.this;
                object = capture;
                matcher = constraintmatcher;
                super();
            }
            }).onSuccess(new Continuation() {

                final OfflineStore._cls8 this$1;
                final Capture val$object;

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

                public Void then(Task task1)
                {
                    if (((Boolean)task1.getResult()).booleanValue())
                    {
                        results.add(object.get());
                    }
                    return null;
                }

            
            {
                this$1 = OfflineStore._cls8.this;
                object = capture;
                super();
            }
            });
        }

        return task;
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    base()
    {
        this$0 = final_offlinestore;
        val$queryLogic = offlinequerylogic;
        val$query = parsequery;
        val$user = parseuser;
        val$ignoreACLs = flag;
        val$db = parsesqlitedatabase;
        val$results = List.this;
        super();
    }
}
