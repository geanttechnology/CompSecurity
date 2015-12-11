// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.h;
import a.i;
import a.j;
import android.database.Cursor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.parse:
//            OfflineStore, OfflineQueryLogic, ParseSQLiteDatabase, ParseUser, 
//            ParseObject

class val.object
    implements i
{

    final val.object this$1;
    final h val$object;

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    public Void then(j j1)
    {
        if (((Boolean)j1.e()).booleanValue())
        {
            results.add(val$object.a());
        }
        return null;
    }

    l.results()
    {
        this$1 = final_results;
        val$object = h.this;
        super();
    }

    // Unreferenced inner class com/parse/OfflineStore$6

/* anonymous class */
    class OfflineStore._cls6
        implements i
    {

        final OfflineStore this$0;
        final ParseSQLiteDatabase val$db;
        final ParseQuery.State val$query;
        final OfflineQueryLogic val$queryLogic;
        final List val$results;
        final ParseUser val$user;

        public j then(j j1)
            throws Exception
        {
            j1 = (Cursor)j1.e();
            Object obj = new ArrayList();
            j1.moveToFirst();
            for (; !j1.isAfterLast(); j1.moveToNext())
            {
                ((List) (obj)).add(j1.getString(0));
            }

            j1.close();
            final OfflineQueryLogic.ConstraintMatcher matcher = queryLogic.createMatcher(query, user);
            j1 = j.a(null);
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
            {
                final String uuid = (String)((Iterator) (obj)).next();
                final h object = new h();
                j1 = j1.d(new OfflineStore._cls6._cls4()).d(new OfflineStore._cls6._cls3()).d(new OfflineStore._cls6._cls2()).c(object. new OfflineStore._cls6._cls1());
            }

            return j1;
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$0 = final_offlinestore;
                queryLogic = offlinequerylogic;
                query = state;
                user = parseuser;
                db = parsesqlitedatabase;
                results = List.this;
                super();
            }

        // Unreferenced inner class com/parse/OfflineStore$6$2

/* anonymous class */
        class OfflineStore._cls6._cls2
            implements i
        {

            final OfflineStore._cls6 this$1;
            final OfflineQueryLogic.ConstraintMatcher val$matcher;
            final h val$object;

            public j then(j j1)
                throws Exception
            {
                if (!((ParseObject)object.a()).isDataAvailable())
                {
                    return j.a(Boolean.valueOf(false));
                } else
                {
                    return matcher.matchesAsync((ParseObject)object.a(), db);
                }
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

                    
                    {
                        this$1 = OfflineStore._cls6.this;
                        object = h1;
                        matcher = constraintmatcher;
                        super();
                    }
        }


        // Unreferenced inner class com/parse/OfflineStore$6$3

/* anonymous class */
        class OfflineStore._cls6._cls3
            implements i
        {

            final OfflineStore._cls6 this$1;
            final h val$object;

            public j then(j j1)
                throws Exception
            {
                object.a(j1.e());
                return fetchLocallyAsync((ParseObject)object.a(), db);
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

                    
                    {
                        this$1 = OfflineStore._cls6.this;
                        object = h1;
                        super();
                    }
        }


        // Unreferenced inner class com/parse/OfflineStore$6$4

/* anonymous class */
        class OfflineStore._cls6._cls4
            implements i
        {

            final OfflineStore._cls6 this$1;
            final String val$uuid;

            public j then(j j1)
                throws Exception
            {
                return OfflineStore.access$600(this$0, uuid, db);
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

                    
                    {
                        this$1 = OfflineStore._cls6.this;
                        uuid = s;
                        super();
                    }
        }

    }

}
