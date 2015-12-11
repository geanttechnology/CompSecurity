// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            OfflineStore, ParsePin, ParseSQLiteDatabase, ParseUser

class ase
    implements i
{

    final OfflineStore this$0;
    final ParseSQLiteDatabase val$db;
    final  val$state;
    final ParseUser val$user;

    public j then(j j1)
        throws Exception
    {
        j1 = (ParsePin)j1.e();
        return OfflineStore.access$2300(OfflineStore.this, val$state, val$user, j1, false, val$db);
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ase()
    {
        this$0 = final_offlinestore;
        val$state = ;
        val$user = parseuser;
        val$db = ParseSQLiteDatabase.this;
        super();
    }
}
