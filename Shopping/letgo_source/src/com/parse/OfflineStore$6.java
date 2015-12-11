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
//            OfflineStore, OfflineQueryLogic, ParseSQLiteDatabase, ParseUser, 
//            ParseObject

class val.results
    implements ct
{

    final OfflineStore this$0;
    final ParseSQLiteDatabase val$db;
    final e val$query;
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
        final ic.ConstraintMatcher matcher = val$queryLogic.createMatcher(val$query, val$user);
        cu1 = cu.a(null);
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            final String uuid = (String)((Iterator) (obj)).next();
            final cs object = new cs();
            cu1 = cu1.d(new ct() {

                final OfflineStore._cls6 this$1;
                final String val$uuid;

                public cu then(cu cu2)
                    throws Exception
                {
                    return OfflineStore.access$600(this$0, uuid, db);
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            
            {
                this$1 = OfflineStore._cls6.this;
                uuid = s;
                super();
            }
            }).d(new ct() {

                final OfflineStore._cls6 this$1;
                final cs val$object;

                public cu then(cu cu2)
                    throws Exception
                {
                    object.a(cu2.e());
                    return fetchLocallyAsync((ParseObject)object.a(), db);
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            
            {
                this$1 = OfflineStore._cls6.this;
                object = cs1;
                super();
            }
            }).d(new ct() {

                final OfflineStore._cls6 this$1;
                final OfflineQueryLogic.ConstraintMatcher val$matcher;
                final cs val$object;

                public cu then(cu cu2)
                    throws Exception
                {
                    if (!((ParseObject)object.a()).isDataAvailable())
                    {
                        return cu.a(Boolean.valueOf(false));
                    } else
                    {
                        return matcher.matchesAsync((ParseObject)object.a(), db);
                    }
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            
            {
                this$1 = OfflineStore._cls6.this;
                object = cs1;
                matcher = constraintmatcher;
                super();
            }
            }).c(new ct() {

                final OfflineStore._cls6 this$1;
                final cs val$object;

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

                public Void then(cu cu2)
                {
                    if (((Boolean)cu2.e()).booleanValue())
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
            });
        }

        return cu1;
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    base()
    {
        this$0 = final_offlinestore;
        val$queryLogic = offlinequerylogic;
        val$query = e;
        val$user = parseuser;
        val$db = parsesqlitedatabase;
        val$results = List.this;
        super();
    }
}
