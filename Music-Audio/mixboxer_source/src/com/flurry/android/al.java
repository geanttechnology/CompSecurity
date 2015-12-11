// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

// Referenced classes of package com.flurry.android:
//            av

abstract class al
{

    av cD;
    String cE;

    al()
    {
        cE = "";
    }

    public void clearTable()
    {
        cD.getWritableDatabase().delete(cE, null, null);
        readAll();
    }

    public boolean contains(String s)
    {
        s = cD.getReadableDatabase().query(cE, null, (new StringBuilder()).append("objectsId='").append(s).append("'").toString(), null, null, null, "objectsId ASC, julianday(timestamp)");
        boolean flag;
        if (s.moveToFirst())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        s.close();
        return flag;
    }

    public boolean isEmpty()
    {
        Cursor cursor = cD.getReadableDatabase().query(cE, null, null, null, null, null, null);
        boolean flag;
        if (cursor.moveToFirst())
        {
            flag = false;
        } else
        {
            flag = true;
        }
        cursor.close();
        return flag;
    }

    public abstract void readAll();

    public int size()
    {
        Cursor cursor = cD.getWritableDatabase().query(cE, null, null, null, null, null, "objectsId ASC, julianday(timestamp)");
        int i = cursor.getCount();
        cursor.close();
        return i;
    }
}
