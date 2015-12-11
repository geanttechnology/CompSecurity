// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.cu;

// Referenced classes of package com.parse:
//            OfflineStore, ParseSQLiteDatabase

class val.name
    implements iteDatabaseCallable
{

    final OfflineStore this$0;
    final String val$name;

    public cu call(ParseSQLiteDatabase parsesqlitedatabase)
    {
        return OfflineStore.access$2100(OfflineStore.this, val$name, parsesqlitedatabase);
    }

    public volatile Object call(ParseSQLiteDatabase parsesqlitedatabase)
    {
        return call(parsesqlitedatabase);
    }

    ase()
    {
        this$0 = final_offlinestore;
        val$name = String.this;
        super();
    }
}
