// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            OfflineStore, ParseSQLiteDatabase

class iteDatabaseCallable
    implements ct
{

    final OfflineStore this$0;
    final iteDatabaseCallable val$callable;

    public cu then(final cu db)
        throws Exception
    {
        db = (ParseSQLiteDatabase)db.e();
        return ((cu)val$callable.call(db)).b(new ct() {

            final OfflineStore._cls47 this$1;
            final ParseSQLiteDatabase val$db;

            public cu then(cu cu1)
                throws Exception
            {
                db.closeAsync();
                return cu1;
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$1 = OfflineStore._cls47.this;
                db = parsesqlitedatabase;
                super();
            }
        });
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    iteDatabaseCallable()
    {
        this$0 = final_offlinestore;
        val$callable = iteDatabaseCallable.this;
        super();
    }
}
