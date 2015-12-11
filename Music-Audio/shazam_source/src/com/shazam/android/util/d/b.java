// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.util.d;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b
{

    private static final Map a;

    public static String a(int i)
    {
        if (i <= 0)
        {
            throw new SQLiteException((new StringBuilder("Invalid size of placeholders: ")).append(i).toString());
        }
        StringBuilder stringbuilder = new StringBuilder(i * 2 - 1);
        stringbuilder.append("?");
        for (int j = 1; j < i; j++)
        {
            stringbuilder.append(",?");
        }

        return stringbuilder.toString();
    }

    private static transient void a(SQLiteDatabase sqlitedatabase, a a1, String as[])
    {
    /* block-local class not found */
    class a {}

        Cursor cursor;
        ArrayList arraylist;
        cursor = sqlitedatabase.rawQuery("SELECT name FROM sqlite_master WHERE type = ?", new String[] {
            a1.c
        });
        arraylist = new ArrayList(cursor.getCount());
        as = Arrays.asList(as);
_L3:
        String s1;
        Collection collection;
        if (!cursor.moveToNext())
        {
            break MISSING_BLOCK_LABEL_123;
        }
        s1 = cursor.getString(0);
        collection = (Collection)a.get(a1);
        if (collection == null) goto _L2; else goto _L1
_L1:
        if (collection.contains(s1)) goto _L3; else goto _L2
_L2:
        if (!as.contains(s1))
        {
            arraylist.add(s1);
        }
          goto _L3
        as;
        a1 = a1.c;
        sqlitedatabase.getPath();
_L4:
        return;
        cursor.close();
        as = arraylist.iterator();
        while (as.hasNext()) 
        {
            String s = (String)as.next();
            sqlitedatabase.execSQL((new StringBuilder("DROP ")).append(a1.c).append(" ").append(s).toString());
        }
          goto _L4
        sqlitedatabase;
        throw sqlitedatabase;
    }

    public static transient void a(SQLiteDatabase sqlitedatabase, String as[])
    {
        a(sqlitedatabase, a.a, as);
    }

    public static transient void b(SQLiteDatabase sqlitedatabase, String as[])
    {
        a(sqlitedatabase, a.b, as);
    }

    static 
    {
        EnumMap enummap = new EnumMap(com/shazam/android/util/d/b$a);
        a = enummap;
        enummap.put(a.a, Arrays.asList(new String[] {
            "android_metadata", "sqlite_sequence", "null"
        }));
    }
}
