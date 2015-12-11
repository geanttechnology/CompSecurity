// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            OfflineStore, ParseSQLiteDatabase, ParseObject

class e
    implements ct
{

    final then this$1;
    final ParseSQLiteDatabase val$db;

    public cu then(cu cu1)
        throws Exception
    {
        return OfflineStore.access$1400(_fld0, object, val$db).d(new ct() {

            final OfflineStore._cls29._cls1 this$2;

            public cu then(cu cu2)
                throws Exception
            {
                return db.setTransactionSuccessfulAsync();
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                this$2 = OfflineStore._cls29._cls1.this;
                super();
            }
        }).b(new ct() {

            final OfflineStore._cls29._cls1 this$2;

            public cu then(cu cu2)
                throws Exception
            {
                db.endTransactionAsync();
                db.closeAsync();
                return cu2;
            }

            public volatile Object then(cu cu2)
                throws Exception
            {
                return then(cu2);
            }

            
            {
                this$2 = OfflineStore._cls29._cls1.this;
                super();
            }
        });
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    e()
    {
        this$1 = final_e;
        val$db = ParseSQLiteDatabase.this;
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

}
