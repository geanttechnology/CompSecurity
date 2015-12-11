// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseSQLiteDatabase, OfflineStore

class e
    implements i
{

    final then this$1;
    final ParseSQLiteDatabase val$db;

    public j then(j j1)
        throws Exception
    {
        return ((j)callable.call(val$db)).d(new i() {

            final OfflineStore._cls48._cls1 this$2;

            public j then(j j2)
                throws Exception
            {
                return db.setTransactionSuccessfulAsync();
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$2 = OfflineStore._cls48._cls1.this;
                super();
            }
        }).b(new i() {

            final OfflineStore._cls48._cls1 this$2;

            public j then(j j2)
                throws Exception
            {
                db.endTransactionAsync();
                db.closeAsync();
                return j2;
            }

            public volatile Object then(j j2)
                throws Exception
            {
                return then(j2);
            }

            
            {
                this$2 = OfflineStore._cls48._cls1.this;
                super();
            }
        });
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    e()
    {
        this$1 = final_e;
        val$db = ParseSQLiteDatabase.this;
        super();
    }

    // Unreferenced inner class com/parse/OfflineStore$48

/* anonymous class */
    class OfflineStore._cls48
        implements i
    {

        final OfflineStore this$0;
        final OfflineStore.SQLiteDatabaseCallable val$callable;

        public j then(j j1)
            throws Exception
        {
            j1 = (ParseSQLiteDatabase)j1.e();
            return j1.beginTransactionAsync().d(j1. new OfflineStore._cls48._cls1());
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$0 = final_offlinestore;
                callable = OfflineStore.SQLiteDatabaseCallable.this;
                super();
            }
    }

}
