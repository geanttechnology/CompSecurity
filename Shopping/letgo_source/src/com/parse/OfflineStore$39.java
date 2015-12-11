// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.cu;
import java.util.List;

// Referenced classes of package com.parse:
//            OfflineStore, ParseSQLiteDatabase

class val.objects
    implements iteDatabaseCallable
{

    final OfflineStore this$0;
    final String val$name;
    final List val$objects;

    public cu call(ParseSQLiteDatabase parsesqlitedatabase)
    {
        return OfflineStore.access$1900(OfflineStore.this, val$name, val$objects, parsesqlitedatabase);
    }

    public volatile Object call(ParseSQLiteDatabase parsesqlitedatabase)
    {
        return call(parsesqlitedatabase);
    }

    ase()
    {
        this$0 = final_offlinestore;
        val$name = s;
        val$objects = List.this;
        super();
    }
}
