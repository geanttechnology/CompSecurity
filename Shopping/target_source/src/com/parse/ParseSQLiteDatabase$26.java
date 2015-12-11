// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import android.database.Cursor;

// Referenced classes of package com.parse:
//            ParseSQLiteDatabase, ParseSQLiteCursor

class this._cls0
    implements i
{

    final ParseSQLiteDatabase this$0;

    public Cursor then(j j1)
        throws Exception
    {
        j1 = ParseSQLiteCursor.create((Cursor)j1.e(), ParseSQLiteDatabase.access$500());
        j1.getCount();
        return j1;
    }

    public volatile Object then(j j1)
        throws Exception
    {
        return then(j1);
    }

    ()
    {
        this$0 = ParseSQLiteDatabase.this;
        super();
    }
}
