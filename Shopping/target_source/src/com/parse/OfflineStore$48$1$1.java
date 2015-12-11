// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseSQLiteDatabase, OfflineStore

class this._cls2
    implements i
{

    final then this$2;

    public j then(j j)
        throws Exception
    {
        db.endTransactionAsync();
        db.closeAsync();
        return j;
    }

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    lable()
    {
        this$2 = this._cls2.this;
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


    // Unreferenced inner class com/parse/OfflineStore$48$1

/* anonymous class */
    class OfflineStore._cls48._cls1
        implements i
    {

        final OfflineStore._cls48 this$1;
        final ParseSQLiteDatabase val$db;

        public j then(j j1)
            throws Exception
        {
            return ((j)callable.call(db)).d(new OfflineStore._cls48._cls1._cls2()).b(new OfflineStore._cls48._cls1._cls1());
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$1 = final__pcls48;
                db = ParseSQLiteDatabase.this;
                super();
            }

        // Unreferenced inner class com/parse/OfflineStore$48$1$2

/* anonymous class */
        class OfflineStore._cls48._cls1._cls2
            implements i
        {

            final OfflineStore._cls48._cls1 this$2;

            public j then(j j1)
                throws Exception
            {
                return db.setTransactionSuccessfulAsync();
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

                    
                    {
                        this$2 = OfflineStore._cls48._cls1.this;
                        super();
                    }
        }

    }

}
