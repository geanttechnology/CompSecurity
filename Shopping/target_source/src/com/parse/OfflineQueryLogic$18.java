// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import org.json.JSONArray;

// Referenced classes of package com.parse:
//            OfflineQueryLogic, ParseSQLiteDatabase, OfflineStore

static final class val.db
    implements i
{

    final JSONArray val$array;
    final ParseSQLiteDatabase val$db;
    final int val$index;
    final String val$path;
    final OfflineStore val$store;

    public j then(j j)
        throws Exception
    {
        return OfflineQueryLogic.access$600(val$store, val$array.get(val$index), val$path, val$db);
    }

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    (OfflineStore offlinestore, JSONArray jsonarray, int j, String s, ParseSQLiteDatabase parsesqlitedatabase)
    {
        val$store = offlinestore;
        val$array = jsonarray;
        val$index = j;
        val$path = s;
        val$db = parsesqlitedatabase;
        super();
    }
}
