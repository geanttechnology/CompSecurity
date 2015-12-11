// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseSQLiteDatabase, OfflineStore, ParseException, OfflineSQLiteOpenHelper, 
//            ParseObject

class this._cls3
    implements i
{

    final then this$3;

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

    ject()
    {
        this$3 = this._cls3.this;
        super();
    }

    // Unreferenced inner class com/parse/OfflineStore$26

/* anonymous class */
    class OfflineStore._cls26
        implements i
    {

        final OfflineStore this$0;
        final ParseObject val$object;

        public j then(j j1)
            throws Exception
        {
            if (j1.d())
            {
                if ((j1.f() instanceof ParseException) && ((ParseException)j1.f()).getCode() == 120)
                {
                    return j.a(null);
                } else
                {
                    return j1.j();
                }
            } else
            {
                return OfflineStore.access$1300(OfflineStore.this).getWritableDatabaseAsync().b(new OfflineStore._cls26._cls1());
            }
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
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
        implements i
    {

        final OfflineStore._cls26 this$1;

        public j then(j j1)
            throws Exception
        {
            j1 = (ParseSQLiteDatabase)j1.e();
            return j1.beginTransactionAsync().d(j1. new OfflineStore._cls26._cls1._cls1());
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$1 = OfflineStore._cls26.this;
                super();
            }
    }


    // Unreferenced inner class com/parse/OfflineStore$26$1$1

/* anonymous class */
    class OfflineStore._cls26._cls1._cls1
        implements i
    {

        final OfflineStore._cls26._cls1 this$2;
        final ParseSQLiteDatabase val$db;

        public j then(j j1)
            throws Exception
        {
            return OfflineStore.access$1200(this$0, object, db).d(new OfflineStore._cls26._cls1._cls1._cls2()).b(new OfflineStore._cls26._cls1._cls1._cls1());
        }

        public volatile Object then(j j1)
            throws Exception
        {
            return then(j1);
        }

            
            {
                this$2 = final__pcls1;
                db = ParseSQLiteDatabase.this;
                super();
            }

        // Unreferenced inner class com/parse/OfflineStore$26$1$1$2

/* anonymous class */
        class OfflineStore._cls26._cls1._cls1._cls2
            implements i
        {

            final OfflineStore._cls26._cls1._cls1 this$3;

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
                        this$3 = OfflineStore._cls26._cls1._cls1.this;
                        super();
                    }
        }

    }

}
