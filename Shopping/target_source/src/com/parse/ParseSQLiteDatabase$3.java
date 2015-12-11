// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import android.database.sqlite.SQLiteDatabase;

// Referenced classes of package com.parse:
//            ParseSQLiteDatabase

class this._cls0
    implements i
{

    final ParseSQLiteDatabase this$0;

    public Boolean then(j j)
        throws Exception
    {
        return Boolean.valueOf(ParseSQLiteDatabase.access$300(ParseSQLiteDatabase.this).isReadOnly());
    }

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    tabase()
    {
        this$0 = ParseSQLiteDatabase.this;
        super();
    }
}
