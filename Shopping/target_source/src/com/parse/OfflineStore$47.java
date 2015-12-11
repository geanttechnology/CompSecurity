// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            OfflineStore, ParseSQLiteDatabase

class iteDatabaseCallable
    implements i
{

    final OfflineStore this$0;
    final iteDatabaseCallable val$callable;

    public j then(final j db)
        throws Exception
    {
        db = (ParseSQLiteDatabase)db.e();
        return ((j)val$callable.call(db)).b(new i() {

            final OfflineStore._cls47 this$1;
            final ParseSQLiteDatabase val$db;

            public j then(j j1)
                throws Exception
            {
                db.closeAsync();
                return j1;
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$1 = OfflineStore._cls47.this;
                db = parsesqlitedatabase;
                super();
            }
        });
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    iteDatabaseCallable()
    {
        this$0 = final_offlinestore;
        val$callable = iteDatabaseCallable.this;
        super();
    }
}
