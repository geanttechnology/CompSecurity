// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.parse:
//            OfflineQueryLogic, ParseObject, OfflineStore, ParseSQLiteDatabase

class val.object
    implements ct
{

    final then this$1;
    final ParseObject val$object;

    public cu then(cu cu)
        throws Exception
    {
        return queryLogic.fetchIncludes(val$object, query, db);
    }

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
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
        implements ct
    {

        final OfflineStore this$0;
        final ParseSQLiteDatabase val$db;
        final boolean val$isCount;
        final ParseQuery.State val$query;
        final OfflineQueryLogic val$queryLogic;
        final List val$results;

        public cu then(final cu finalTrimmedResults)
            throws Exception
        {
            queryLogic.sort(results, query);
            Object obj = results;
            int i = query.skip();
            finalTrimmedResults = ((cu) (obj));
            if (!isCount)
            {
                finalTrimmedResults = ((cu) (obj));
                if (i >= 0)
                {
                    finalTrimmedResults = ((List) (obj)).subList(Math.min(query.skip(), ((List) (obj)).size()), ((List) (obj)).size());
                }
            }
            i = query.limit();
            if (!isCount && i >= 0 && finalTrimmedResults.size() > i)
            {
                finalTrimmedResults = finalTrimmedResults.subList(0, i);
            }
            obj = cu.a(null);
            for (Iterator iterator = finalTrimmedResults.iterator(); iterator.hasNext();)
            {
                obj = ((cu) (obj)).d(((ParseObject)iterator.next()). new OfflineStore._cls5._cls1());
            }

            return ((cu) (obj)).c(new OfflineStore._cls5._cls2());
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                this$0 = final_offlinestore;
                queryLogic = offlinequerylogic;
                results = list;
                query = state;
                isCount = flag;
                db = ParseSQLiteDatabase.this;
                super();
            }

        // Unreferenced inner class com/parse/OfflineStore$5$2

/* anonymous class */
        class OfflineStore._cls5._cls2
            implements ct
        {

            final OfflineStore._cls5 this$1;
            final List val$finalTrimmedResults;

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            public List then(cu cu1)
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
