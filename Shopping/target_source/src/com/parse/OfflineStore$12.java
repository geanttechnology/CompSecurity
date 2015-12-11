// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.j;

// Referenced classes of package com.parse:
//            OfflineStore, ParseObject, ParseSQLiteDatabase

class val.object
    implements iteDatabaseCallable
{

    final OfflineStore this$0;
    final ParseObject val$object;

    public j call(ParseSQLiteDatabase parsesqlitedatabase)
    {
        return fetchLocallyAsync(val$object, parsesqlitedatabase);
    }

    public volatile Object call(ParseSQLiteDatabase parsesqlitedatabase)
    {
        return call(parsesqlitedatabase);
    }

    ase()
    {
        this$0 = final_offlinestore;
        val$object = ParseObject.this;
        super();
    }
}
