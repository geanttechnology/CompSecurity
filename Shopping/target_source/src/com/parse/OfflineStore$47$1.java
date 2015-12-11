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

    public j then(j j)
        throws Exception
    {
        val$db.closeAsync();
        return j;
    }

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
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
        implements i
    {

        final OfflineStore this$0;
        final OfflineStore.SQLiteDatabaseCallable val$callable;

        public j then(j j1)
            throws Exception
        {
            j1 = (ParseSQLiteDatabase)j1.e();
            return ((j)callable.call(j1)).b(j1. new OfflineStore._cls47._cls1());
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
