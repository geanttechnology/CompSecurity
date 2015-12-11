// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.cs;
import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            OfflineStore, ParseSQLiteDatabase, ParseObject

class ase
    implements ct
{

    final OfflineStore this$0;
    final ParseSQLiteDatabase val$db;
    final ParseObject val$object;
    final cs val$uuidCapture;

    public cu then(cu cu1)
        throws Exception
    {
        cu1 = (String)cu1.e();
        val$uuidCapture.a(cu1);
        return OfflineStore.access$800(OfflineStore.this, cu1, val$object, val$db);
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ase()
    {
        this$0 = final_offlinestore;
        val$uuidCapture = cs1;
        val$object = parseobject;
        val$db = ParseSQLiteDatabase.this;
        super();
    }
}
