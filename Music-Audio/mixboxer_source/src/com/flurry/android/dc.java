// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

// Referenced classes of package com.flurry.android:
//            al, dw, av

final class dc extends al
{

    dc(Context context, String s1)
    {
        cD = dw.e(context, s1);
        cE = "registeredDirtyObjectsTable";
    }

    public final int r(String s1)
    {
        s1 = cD.getReadableDatabase().query(cE, null, (new StringBuilder()).append("objectsId='").append(s1).append("'").toString(), null, null, null, "objectsId ASC, julianday(timestamp)");
        if (s1.moveToFirst())
        {
            return s1.getInt(s1.getColumnIndex("value"));
        } else
        {
            return -1;
        }
    }

    public final void readAll()
    {
        Cursor cursor = cD.getReadableDatabase().query(cE, null, null, null, null, null, "objectsId ASC, julianday(timestamp)");
        if (cursor.moveToFirst())
        {
            int i = cursor.getColumnIndex("objectsId");
            int j = cursor.getColumnIndex("value");
            do
            {
                Log.w("CacheDirtyOperationsDB", (new StringBuilder()).append("id = ").append(cursor.getString(i)).append(", oper_status = ").append(cursor.getInt(j)).toString());
            } while (cursor.moveToNext());
        } else
        {
            Log.w("CacheDirtyOperationsDB", "TABLE IS EMPTY");
        }
        cursor.close();
    }

    public final void s(String s1)
    {
        cD.getWritableDatabase().delete(cE, (new StringBuilder()).append("objectsId='").append(s1).append("'").toString(), null);
    }
}
