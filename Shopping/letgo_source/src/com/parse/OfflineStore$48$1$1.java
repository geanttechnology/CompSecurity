// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseSQLiteDatabase, OfflineStore

class this._cls2
    implements ct
{

    final then this$2;

    public cu then(cu cu)
        throws Exception
    {
        db.endTransactionAsync();
        db.closeAsync();
        return cu;
    }

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    lable()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/parse/OfflineStore$48

/* anonymous class */
    class OfflineStore._cls48
        implements ct
    {

        final OfflineStore this$0;
        final OfflineStore.SQLiteDatabaseCallable val$callable;

        public cu then(cu cu1)
            throws Exception
        {
            cu1 = (ParseSQLiteDatabase)cu1.e();
            return cu1.beginTransactionAsync().d(cu1. new OfflineStore._cls48._cls1());
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
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
        implements ct
    {

        final OfflineStore._cls48 this$1;
        final ParseSQLiteDatabase val$db;

        public cu then(cu cu1)
            throws Exception
        {
            return ((cu)callable.call(db)).d(new OfflineStore._cls48._cls1._cls2()).b(new OfflineStore._cls48._cls1._cls1());
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                this$1 = final__pcls48;
                db = ParseSQLiteDatabase.this;
                super();
            }

        // Unreferenced inner class com/parse/OfflineStore$48$1$2

/* anonymous class */
        class OfflineStore._cls48._cls1._cls2
            implements ct
        {

            final OfflineStore._cls48._cls1 this$2;

            public cu then(cu cu1)
                throws Exception
            {
                return db.setTransactionSuccessfulAsync();
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

                    
                    {
                        this$2 = OfflineStore._cls48._cls1.this;
                        super();
                    }
        }

    }

}
