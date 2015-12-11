// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseSQLiteDatabase

class this._cls0
    implements ct
{

    final ParseSQLiteDatabase this$0;

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
    }

    public Void then(cu cu)
        throws Exception
    {
        ParseSQLiteDatabase.access$300(ParseSQLiteDatabase.this).endTransaction();
        return null;
    }

    abase()
    {
        this$0 = ParseSQLiteDatabase.this;
        super();
    }
}
