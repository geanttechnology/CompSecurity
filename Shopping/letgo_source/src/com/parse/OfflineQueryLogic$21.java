// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            OfflineQueryLogic, ParseSQLiteDatabase, ParseObject

class val.db
    implements ct
{

    final OfflineQueryLogic this$0;
    final ParseSQLiteDatabase val$db;
    final String val$include;
    final ParseObject val$object;

    public cu then(cu cu)
        throws Exception
    {
        return OfflineQueryLogic.access$600(OfflineQueryLogic.this, val$object, val$include, val$db);
    }

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    ()
    {
        this$0 = final_offlinequerylogic;
        val$object = parseobject;
        val$include = s;
        val$db = ParseSQLiteDatabase.this;
        super();
    }
}
