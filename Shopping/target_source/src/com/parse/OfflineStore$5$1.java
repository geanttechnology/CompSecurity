// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.parse:
//            OfflineQueryLogic, ParseObject, OfflineStore, ParseSQLiteDatabase

class val.object
    implements i
{

    final then this$1;
    final ParseObject val$object;

    public j then(j j)
        throws Exception
    {
        return OfflineQueryLogic.fetchIncludesAsync(_fld0, val$object, query, db);
    }

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    se()
    {
        this$1 = final_se;
        val$object = ParseObject.this;
        super();
    }

    // Unreferenced inner class com/parse/OfflineStore$5

/* anonymous class */
    class OfflineStore._cls5
        implements i
    {

        final OfflineStore this$0;
        final ParseSQLiteDatabase val$db;
        final boolean val$isCount;
        final ParseQuery.State val$query;
        final List val$results;

        public j then(final j finalTrimmedResults)
            throws Exception
        {
            OfflineQueryLogic.sort(results, query);
            Object obj = results;
            int k = query.skip();
            finalTrimmedResults = ((j) (obj));
            if (!isCount)
            {
                finalTrimmedResults = ((j) (obj));
                if (k >= 0)
                {
                    finalTrimmedResults = ((List) (obj)).subList(Math.min(query.skip(), ((List) (obj)).size()), ((List) (obj)).size());
                }
            }
            k = query.limit();
            if (!isCount && k >= 0 && finalTrimmedResults.size() > k)
            {
                finalTrimmedResults = finalTrimmedResults.subList(0, k);
            }
            obj = j.a(null);
            for (Iterator iterator = finalTrimmedResults.iterator(); iterator.hasNext();)
            {
                obj = ((j) (obj)).d(((ParseObject)iterator.next()). new OfflineStore._cls5._cls1());
            }

            return ((j) (obj)).c(new OfflineStore._cls5._cls2());
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$0 = final_offlinestore;
                results = list;
                query = state;
                isCount = flag;
                db = ParseSQLiteDatabase.this;
                super();
            }

        // Unreferenced inner class com/parse/OfflineStore$5$2

/* anonymous class */
        class OfflineStore._cls5._cls2
            implements i
        {

            final OfflineStore._cls5 this$1;
            final List val$finalTrimmedResults;

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            public List then(j j1)
                throws Exception
            {
                return finalTrimmedResults;
            }

                    
                    {
                        this$1 = OfflineStore._cls5.this;
                        finalTrimmedResults = list;
                        super();
                    }
        }

    }

}
