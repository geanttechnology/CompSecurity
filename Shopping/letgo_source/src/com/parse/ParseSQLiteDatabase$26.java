// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.database.Cursor;
import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseSQLiteDatabase, ParseSQLiteCursor

class this._cls0
    implements ct
{

    final ParseSQLiteDatabase this$0;

    public Cursor then(cu cu1)
        throws Exception
    {
        cu1 = ParseSQLiteCursor.create((Cursor)cu1.e(), ParseSQLiteDatabase.access$500());
        cu1.getCount();
        return cu1;
    }

    public volatile Object then(cu cu1)
        throws Exception
    {
        return then(cu1);
    }

    ()
    {
        this$0 = ParseSQLiteDatabase.this;
        super();
    }
}
