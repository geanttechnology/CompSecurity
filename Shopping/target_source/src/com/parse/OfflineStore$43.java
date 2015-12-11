// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.j;

// Referenced classes of package com.parse:
//            OfflineStore, ParseUser, ParseSQLiteDatabase

class val.user
    implements iteDatabaseCallable
{

    final OfflineStore this$0;
    final String val$name;
    final  val$state;
    final ParseUser val$user;

    public j call(ParseSQLiteDatabase parsesqlitedatabase)
    {
        return OfflineStore.access$2200(OfflineStore.this, val$name, val$state, val$user, parsesqlitedatabase);
    }

    public volatile Object call(ParseSQLiteDatabase parsesqlitedatabase)
    {
        return call(parsesqlitedatabase);
    }

    ()
    {
        this$0 = final_offlinestore;
        val$name = s;
        val$state = ;
        val$user = ParseUser.this;
        super();
    }
}
