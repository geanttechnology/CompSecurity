// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            OfflineQueryLogic, ParseSQLiteDatabase, OfflineStore

static final class val.db
    implements i
{

    final ParseSQLiteDatabase val$db;
    final String val$rest;
    final OfflineStore val$store;

    public j then(j j1)
        throws Exception
    {
        return OfflineQueryLogic.access$600(val$store, j1.e(), val$rest, val$db);
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    (OfflineStore offlinestore, String s, ParseSQLiteDatabase parsesqlitedatabase)
    {
        val$store = offlinestore;
        val$rest = s;
        val$db = parsesqlitedatabase;
        super();
    }
}
