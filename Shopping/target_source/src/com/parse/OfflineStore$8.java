// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.h;
import a.i;
import a.j;

// Referenced classes of package com.parse:
//            OfflineStore, ParseSQLiteDatabase

class val.select
    implements i
{

    final OfflineStore this$0;
    final ParseSQLiteDatabase val$db;
    final String val$select[];
    final h val$uuid;

    public j then(j j1)
        throws Exception
    {
        val$uuid.a(j1.e());
        j1 = (String)val$uuid.a();
        return val$db.queryAsync("ParseObjects", val$select, "uuid = ?", new String[] {
            j1
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
        val$uuid = h1;
        val$db = parsesqlitedatabase;
        val$select = _5B_Ljava.lang.String_3B_.this;
        super();
    }
}
