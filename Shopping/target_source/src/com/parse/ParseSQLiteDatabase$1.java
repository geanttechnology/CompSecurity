// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;

// Referenced classes of package com.parse:
//            ParseSQLiteDatabase

static final class val.db
    implements i
{

    final ParseSQLiteDatabase val$db;

    public j then(j j1)
        throws Exception
    {
        return j.a(val$db);
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    (ParseSQLiteDatabase parsesqlitedatabase)
    {
        val$db = parsesqlitedatabase;
        super();
    }
}
