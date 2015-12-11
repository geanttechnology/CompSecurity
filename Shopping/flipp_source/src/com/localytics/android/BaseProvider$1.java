// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

// Referenced classes of package com.localytics.android:
//            BaseProvider

class this._cls0
    implements Runnable
{

    final BaseProvider this$0;

    public void run()
    {
        Cursor cursor;
        Cursor cursor1;
        cursor1 = null;
        cursor = null;
        Cursor cursor2 = mDb.rawQuery("PRAGMA incremental_vacuum(0);", null);
_L2:
        cursor = cursor2;
        cursor1 = cursor2;
        boolean flag = cursor2.moveToNext();
        if (flag) goto _L2; else goto _L1
_L1:
        if (cursor2 != null)
        {
            cursor2.close();
        }
_L4:
        return;
        Exception exception1;
        exception1;
        cursor1 = cursor;
        w("Auto-vacuum error", exception1);
        if (cursor == null) goto _L4; else goto _L3
_L3:
        cursor.close();
        return;
        Exception exception;
        exception;
        if (cursor1 != null)
        {
            cursor1.close();
        }
        throw exception;
    }

    ()
    {
        this$0 = BaseProvider.this;
        super();
    }
}
