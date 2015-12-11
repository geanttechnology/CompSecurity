// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            OfflineQueryLogic, ParseSQLiteDatabase, ParseObject, OfflineStore

static final class val.db
    implements i
{

    final ParseSQLiteDatabase val$db;
    final String val$include;
    final ParseObject val$object;
    final OfflineStore val$store;

    public j then(j j)
        throws Exception
    {
        return OfflineQueryLogic.access$600(val$store, val$object, val$include, val$db);
    }

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    (OfflineStore offlinestore, ParseObject parseobject, String s, ParseSQLiteDatabase parsesqlitedatabase)
    {
        val$store = offlinestore;
        val$object = parseobject;
        val$include = s;
        val$db = parsesqlitedatabase;
        super();
    }
}
