// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseSQLiteDatabase, OfflineStore

class e
    implements ct
{

    final then this$1;
    final ParseSQLiteDatabase val$db;

    public cu then(cu cu)
        throws Exception
    {
        val$db.closeAsync();
        return cu;
    }

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    e()
    {
        this$1 = final_e;
        val$db = ParseSQLiteDatabase.this;
        super();
    }

    // Unreferenced inner class com/parse/OfflineStore$47

/* anonymous class */
    class OfflineStore._cls47
        implements ct
    {

        final OfflineStore this$0;
        final OfflineStore.SQLiteDatabaseCallable val$callable;

        public cu then(cu cu1)
            throws Exception
        {
            cu1 = (ParseSQLiteDatabase)cu1.e();
            return ((cu)callable.call(cu1)).b(cu1. new OfflineStore._cls47._cls1());
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

}
