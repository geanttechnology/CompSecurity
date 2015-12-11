// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseSQLiteDatabase, OfflineStore, ParseException, OfflineSQLiteOpenHelper, 
//            ParseObject

class this._cls3
    implements ct
{

    final then this$3;

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

    ject()
    {
        this$3 = this._cls3.this;
        super();
    }

    // Unreferenced inner class com/parse/OfflineStore$26

/* anonymous class */
    class OfflineStore._cls26
        implements ct
    {

        final OfflineStore this$0;
        final ParseObject val$object;

        public cu then(cu cu1)
            throws Exception
        {
            if (cu1.d())
            {
                if ((cu1.f() instanceof ParseException) && ((ParseException)cu1.f()).getCode() == 120)
                {
                    return cu.a(null);
                } else
                {
                    return cu1.j();
                }
            } else
            {
                return OfflineStore.access$1300(OfflineStore.this).getWritableDatabaseAsync().b(new OfflineStore._cls26._cls1());
            }
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                this$0 = final_offlinestore;
                object = ParseObject.this;
                super();
            }
    }


    // Unreferenced inner class com/parse/OfflineStore$26$1

/* anonymous class */
    class OfflineStore._cls26._cls1
        implements ct
    {

        final OfflineStore._cls26 this$1;

        public cu then(cu cu1)
            throws Exception
        {
            cu1 = (ParseSQLiteDatabase)cu1.e();
            return cu1.beginTransactionAsync().d(cu1. new OfflineStore._cls26._cls1._cls1());
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                this$1 = OfflineStore._cls26.this;
                super();
            }
    }


    // Unreferenced inner class com/parse/OfflineStore$26$1$1

/* anonymous class */
    class OfflineStore._cls26._cls1._cls1
        implements ct
    {

        final OfflineStore._cls26._cls1 this$2;
        final ParseSQLiteDatabase val$db;

        public cu then(cu cu1)
            throws Exception
        {
            return OfflineStore.access$1200(this$0, object, db).d(new OfflineStore._cls26._cls1._cls1._cls2()).b(new OfflineStore._cls26._cls1._cls1._cls1());
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                this$2 = final__pcls1;
                db = ParseSQLiteDatabase.this;
                super();
            }

        // Unreferenced inner class com/parse/OfflineStore$26$1$1$2

/* anonymous class */
        class OfflineStore._cls26._cls1._cls1._cls2
            implements ct
        {

            final OfflineStore._cls26._cls1._cls1 this$3;

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
                        this$3 = OfflineStore._cls26._cls1._cls1.this;
                        super();
                    }
        }

    }

}
