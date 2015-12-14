// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import bolts.Continuation;
import bolts.Task;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.parse:
//            OfflineQueryLogic, ParseObject, OfflineStore, ParseQuery, 
//            ParseSQLiteDatabase

class val.object
    implements Continuation
{

    final then this$1;
    final ParseObject val$object;

    public Task then(Task task)
        throws Exception
    {
        return queryLogic.fetchIncludes(val$object, query, db);
    }

    public volatile Object then(Task task)
        throws Exception
    {
        return then(task);
    }

    se()
    {
        this$1 = final_se;
        val$object = ParseObject.this;
        super();
    }

    // Unreferenced inner class com/parse/OfflineStore$7

/* anonymous class */
    class OfflineStore._cls7
        implements Continuation
    {

        final OfflineStore this$0;
        final ParseSQLiteDatabase val$db;
        final boolean val$isCount;
        final ParseQuery val$query;
        final OfflineQueryLogic val$queryLogic;
        final List val$results;

        public Task then(Task task)
            throws Exception
        {
            queryLogic.sort(results, query);
            final Object finalTrimmedResults = results;
            int i = query.getSkip();
            task = ((Task) (finalTrimmedResults));
            if (!isCount)
            {
                task = ((Task) (finalTrimmedResults));
                if (i >= 0)
                {
                    task = ((List) (finalTrimmedResults)).subList(Math.min(query.getSkip(), ((List) (finalTrimmedResults)).size()), ((List) (finalTrimmedResults)).size());
                }
            }
            i = query.getLimit();
            finalTrimmedResults = task;
            if (!isCount)
            {
                finalTrimmedResults = task;
                if (i >= 0)
                {
                    finalTrimmedResults = task;
                    if (task.size() > i)
                    {
                        finalTrimmedResults = task.subList(0, i);
                    }
                }
            }
            task = Task.forResult(null);
            for (Iterator iterator = ((List) (finalTrimmedResults)).iterator(); iterator.hasNext();)
            {
                task = task.onSuccessTask(((ParseObject)iterator.next()). new OfflineStore._cls7._cls1());
            }

            return task.onSuccess(new OfflineStore._cls7._cls2());
        }

        public volatile Object then(Task task)
            throws Exception
        {
            return then(task);
        }

            
            {
                this$0 = final_offlinestore;
                queryLogic = offlinequerylogic;
                results = list;
                query = parsequery;
                isCount = flag;
                db = ParseSQLiteDatabase.this;
                super();
            }

        // Unreferenced inner class com/parse/OfflineStore$7$2

/* anonymous class */
        class OfflineStore._cls7._cls2
            implements Continuation
        {

            final OfflineStore._cls7 this$1;
            final List val$finalTrimmedResults;

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            public List then(Task task)
                throws Exception
            {
                return finalTrimmedResults;
            }

                    
                    {
                        this$1 = OfflineStore._cls7.this;
                        finalTrimmedResults = list;
                        super();
                    }
        }

    }

}
