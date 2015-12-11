// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            OfflineStore, ParseSQLiteDatabase

class base
    implements ct
{

    final OfflineStore this$0;
    final ParseSQLiteDatabase val$db;
    final e val$query;

    public cu then(cu cu1)
        throws Exception
    {
        cu1 = (String)cu1.e();
        String s = (new StringBuilder()).append("className=? AND key=?").append(" AND isDeletingEventually=0").toString();
        String s1 = val$query.className();
        return val$db.queryAsync("ParseObjects A  INNER JOIN Dependencies B  ON A.uuid=B.uuid", new String[] {
            "A.uuid"
        }, s, new String[] {
            s1, cu1
        });
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    base()
    {
        this$0 = final_offlinestore;
        val$query = e;
        val$db = ParseSQLiteDatabase.this;
        super();
    }
}
