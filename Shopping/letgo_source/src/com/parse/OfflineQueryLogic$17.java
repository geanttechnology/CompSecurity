// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;
import org.json.JSONArray;

// Referenced classes of package com.parse:
//            OfflineQueryLogic, ParseSQLiteDatabase

class val.db
    implements ct
{

    final OfflineQueryLogic this$0;
    final JSONArray val$array;
    final ParseSQLiteDatabase val$db;
    final int val$index;
    final String val$path;

    public cu then(cu cu)
        throws Exception
    {
        return OfflineQueryLogic.access$600(OfflineQueryLogic.this, val$array.get(val$index), val$path, val$db);
    }

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    ()
    {
        this$0 = final_offlinequerylogic;
        val$array = jsonarray;
        val$index = i;
        val$path = s;
        val$db = ParseSQLiteDatabase.this;
        super();
    }
}
