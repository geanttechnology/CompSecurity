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

class val.results
    implements i
{

    final OfflineStore this$0;
    final ParseSQLiteDatabase val$db;
    final e val$query;
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
        final ic.ConstraintMatcher matcher = val$queryLogic.createMatcher(val$query, val$user);
        j1 = j.a(null);
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            final String uuid = (String)((Iterator) (obj)).next();
            final h object = new h();
            j1 = j1.d(new i() {

                final OfflineStore._cls6 this$1;
                final String val$uuid;

                public j then(j j2)
                    throws Exception
                {
                    return OfflineStore.access$600(this$0, uuid, db);
                }

                public volatile Object then(j j2)
                    throws Exception
                {
                    return then(j2);
                }

            
            {
                this$1 = OfflineStore._cls6.this;
                uuid = s;
                super();
            }
            }).d(new i() {

                final OfflineStore._cls6 this$1;
                final h val$object;

                public j then(j j2)
                    throws Exception
                {
                    object.a(j2.e());
                    return fetchLocallyAsync((ParseObject)object.a(), db);
                }

                public volatile Object then(j j2)
                    throws Exception
                {
                    return then(j2);
                }

            
            {
                this$1 = OfflineStore._cls6.this;
                object = h1;
                super();
            }
            }).d(new i() {

                final OfflineStore._cls6 this$1;
                final OfflineQueryLogic.ConstraintMatcher val$matcher;
                final h val$object;

                public j then(j j2)
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

                public volatile Object then(j j2)
                    throws Exception
                {
                    return then(j2);
                }

            
            {
                this$1 = OfflineStore._cls6.this;
                object = h1;
                matcher = constraintmatcher;
                super();
            }
            }).c(new i() {

                final OfflineStore._cls6 this$1;
                final h val$object;

                public volatile Object then(j j2)
                    throws Exception
                {
                    return then(j2);
                }

                public Void then(j j2)
                {
                    if (((Boolean)j2.e()).booleanValue())
                    {
                        results.add(object.a());
                    }
                    return null;
                }

            
            {
                this$1 = OfflineStore._cls6.this;
                object = h1;
                super();
            }
            });
        }

        return j1;
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
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
