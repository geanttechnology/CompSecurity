// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// Referenced classes of package net.tsz.afinal:
//            FinalDb

class mDbUpdateListener extends SQLiteOpenHelper
{

    private r mDbUpdateListener;
    final FinalDb this$0;

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        if (mDbUpdateListener == null) goto _L2; else goto _L1
_L1:
        mDbUpdateListener.onUpgrade(sqlitedatabase, i, j);
_L4:
        return;
_L2:
        Cursor cursor = sqlitedatabase.rawQuery("SELECT name FROM sqlite_master WHERE type ='table'", null);
        if (cursor == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        for (; cursor.moveToNext(); sqlitedatabase.execSQL((new StringBuilder("DROP TABLE ")).append(cursor.getString(0)).toString()))
        {
            break MISSING_BLOCK_LABEL_57;
        }

        if (cursor == null) goto _L4; else goto _L3
_L3:
        cursor.close();
        return;
    }

    public .CursorFactory(Context context, String s, int i, r r)
    {
        this$0 = FinalDb.this;
        super(context, s, null, i);
        mDbUpdateListener = r;
    }
}
