// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseSQLiteDatabase, OfflineStore, ParseObject

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

    object()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/parse/OfflineStore$29

/* anonymous class */
    class OfflineStore._cls29
        implements ct
    {

        final OfflineStore this$0;
        final ParseObject val$object;

        public cu then(cu cu1)
            throws Exception
        {
            cu1 = (ParseSQLiteDatabase)cu1.e();
            return cu1.beginTransactionAsync().d(cu1. new OfflineStore._cls29._cls1());
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


    // Unreferenced inner class com/parse/OfflineStore$29$1

/* anonymous class */
    class OfflineStore._cls29._cls1
        implements ct
    {

        final OfflineStore._cls29 this$1;
        final ParseSQLiteDatabase val$db;

        public cu then(cu cu1)
            throws Exception
        {
            return OfflineStore.access$1400(this$0, object, db).d(new OfflineStore._cls29._cls1._cls2()).b(new OfflineStore._cls29._cls1._cls1());
        }

        public volatile Object then(cu cu1)
            throws Exception
        {
            return then(cu1);
        }

            
            {
                this$1 = final__pcls29;
                db = ParseSQLiteDatabase.this;
                super();
            }

        // Unreferenced inner class com/parse/OfflineStore$29$1$2

/* anonymous class */
        class OfflineStore._cls29._cls1._cls2
            implements ct
        {

            final OfflineStore._cls29._cls1 this$2;

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
                        this$2 = OfflineStore._cls29._cls1.this;
                        super();
                    }
        }

    }

}
