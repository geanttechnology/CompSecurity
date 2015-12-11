// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.h;
import a.i;
import a.j;
import android.content.ContentValues;

// Referenced classes of package com.parse:
//            OfflineStore, ParseSQLiteDatabase

class ase
    implements i
{

    final OfflineStore this$0;
    final ParseSQLiteDatabase val$db;
    final String val$key;
    final h val$uuidCapture;

    public j then(j j)
        throws Exception
    {
        j = new ContentValues();
        j.put("key", val$key);
        j.put("uuid", (String)val$uuidCapture.a());
        return val$db.insertWithOnConflict("Dependencies", j, 4);
    }

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    ase()
    {
        this$0 = final_offlinestore;
        val$key = s;
        val$uuidCapture = h1;
        val$db = ParseSQLiteDatabase.this;
        super();
    }
}
