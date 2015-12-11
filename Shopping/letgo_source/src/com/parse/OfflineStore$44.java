// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            OfflineStore, ParsePin, ParseSQLiteDatabase, ParseUser

class ase
    implements ct
{

    final OfflineStore this$0;
    final ParseSQLiteDatabase val$db;
    final  val$state;
    final ParseUser val$user;

    public cu then(cu cu1)
        throws Exception
    {
        cu1 = (ParsePin)cu1.e();
        return OfflineStore.access$2300(OfflineStore.this, val$state, val$user, cu1, false, val$db);
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
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
