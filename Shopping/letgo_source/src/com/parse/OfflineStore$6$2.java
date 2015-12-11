// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.database.Cursor;
import android.support.v7.cs;
import android.support.v7.ct;
import android.support.v7.cu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.parse:
//            ParseObject, OfflineStore, OfflineQueryLogic, ParseSQLiteDatabase, 
//            ParseUser

class .ConstraintMatcher
    implements ct
{

    final then this$1;
    final .ConstraintMatcher val$matcher;
    final cs val$object;

    public cu then(cu cu1)
        throws Exception
    {
        if (!((ParseObject)val$object.a()).isDataAvailable())
        {
            return cu.a(Boolean.valueOf(false));
        } else
        {
            return val$matcher.matchesAsync((ParseObject)val$object.a(), db);
        }
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    .ConstraintMatcher()
    {
        this$1 = final_constraintmatcher;
        val$object = cs1;
        val$matcher = .ConstraintMatcher.this;
        super();
    }

    // Unreferenced inner class com/parse/OfflineStore$6

/* anonymous class */
    class OfflineStore._cls6
        implements ct
    {

        final OfflineStore this$0;
        final ParseSQLiteDatabase val$db;
        final ParseQuery.State val$query;
        final OfflineQueryLogic val$queryLogic;
        final List val$results;
        final ParseUser val$user;

        public cu then(cu cu1)
            throws Exception
        {
            cu1 = (Cursor)cu1.e();
            Object obj = new ArrayList();
            cu1.moveToFirst();
            for (; !cu1.isAfterLast(); cu1.moveToNext())
            {
                ((List) (obj)).add(cu1.getString(0));
            }

            cu1.close();
            OfflineQueryLogic.ConstraintMatcher constraintmatcher = queryLogic.createMatcher(query, user);
            cu1 = cu.a(null);
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
            {
                final String uuid = (String)((Iterator) (obj)).next();
                final cs object = new cs();
                cu1 = cu1.d(new OfflineStore._cls6._cls4()).d(new OfflineStore._cls6._cls3()).d(constraintmatcher. new OfflineStore._cls6._cls2()).c(new OfflineStore._cls6._cls1());
            }

            return cu1;
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
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

        // Unreferenced inner class com/parse/OfflineStore$6$1

/* anonymous class */
        class OfflineStore._cls6._cls1
            implements ct
        {

            final OfflineStore._cls6 this$1;
            final cs val$object;

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            public Void then(cu cu1)
            {
                if (((Boolean)cu1.e()).booleanValue())
                {
                    results.add(object.a());
                }
                return null;
            }

                    
                    {
                        this$1 = OfflineStore._cls6.this;
                        object = cs1;
                        super();
                    }
        }


        // Unreferenced inner class com/parse/OfflineStore$6$3

/* anonymous class */
        class OfflineStore._cls6._cls3
            implements ct
        {

            final OfflineStore._cls6 this$1;
            final cs val$object;

            public cu then(cu cu1)
                throws Exception
            {
                object.a(cu1.e());
                return fetchLocallyAsync((ParseObject)object.a(), db);
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

                    
                    {
                        this$1 = OfflineStore._cls6.this;
                        object = cs1;
                        super();
                    }
        }


        // Unreferenced inner class com/parse/OfflineStore$6$4

/* anonymous class */
        class OfflineStore._cls6._cls4
            implements ct
        {

            final OfflineStore._cls6 this$1;
            final String val$uuid;

            public cu then(cu cu1)
                throws Exception
            {
                return OfflineStore.access$600(this$0, uuid, db);
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

                    
                    {
                        this$1 = OfflineStore._cls6.this;
                        uuid = s;
                        super();
                    }
        }

    }

}
