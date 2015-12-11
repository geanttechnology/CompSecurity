// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            OfflineStore, ParseSQLiteDatabase

class base
    implements i
{

    final OfflineStore this$0;
    final ParseSQLiteDatabase val$db;
    final e val$query;

    public j then(j j1)
        throws Exception
    {
        j1 = (String)j1.e();
        String s = (new StringBuilder()).append("className=? AND key=?").append(" AND isDeletingEventually=0").toString();
        String s1 = val$query.className();
        return val$db.queryAsync("ParseObjects A  INNER JOIN Dependencies B  ON A.uuid=B.uuid", new String[] {
            "A.uuid"
        }, s, new String[] {
            s1, j1
        });
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    base()
    {
        this$0 = final_offlinestore;
        val$query = e;
        val$db = ParseSQLiteDatabase.this;
        super();
    }
}
