// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.amazon.gallery.foundation.utils.log.GLogger;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            TruthDBConnectionManager

class this._cls0 extends SQLiteOpenHelper
{

    final TruthDBConnectionManager this$0;

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
    }

    public void onOpen(SQLiteDatabase sqlitedatabase)
    {
        GLogger.i(TruthDBConnectionManager.access$000(), "Connection to Truth DB opened successfully.", new Object[0]);
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
    }

    (Context context, String s, android.database.sqlite.y y, int i)
    {
        this$0 = TruthDBConnectionManager.this;
        super(context, s, y, i);
    }
}
