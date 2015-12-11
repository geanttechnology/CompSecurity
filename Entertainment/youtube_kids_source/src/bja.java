// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public final class bja
{

    public static Uri a(Cursor cursor, int i)
    {
        if (!cursor.isNull(i))
        {
            return Uri.parse(cursor.getString(i));
        } else
        {
            return null;
        }
    }

    public static void a(SQLiteDatabase sqlitedatabase)
    {
        Cursor cursor = sqlitedatabase.query("sqlite_master", new String[] {
            "type", "name"
        }, null, null, null, null, null);
_L1:
        String s;
        String s1;
        do
        {
            if (!cursor.moveToNext())
            {
                break MISSING_BLOCK_LABEL_165;
            }
            s = cursor.getString(0);
            s1 = cursor.getString(1);
        } while ("sqlite_sequence".equals(s1));
        s = (new StringBuilder(String.valueOf(s).length() + 16 + String.valueOf(s1).length())).append("DROP ").append(s).append(" IF EXISTS ").append(s1).toString();
        sqlitedatabase.execSQL(s);
          goto _L1
        SQLException sqlexception;
        sqlexception;
        s = String.valueOf(s);
        if (s.length() == 0)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        s = "Error executing ".concat(s);
_L2:
        bmo.a(s, sqlexception);
          goto _L1
        sqlitedatabase;
        cursor.close();
        throw sqlitedatabase;
        s = new String("Error executing ");
          goto _L2
        cursor.close();
        return;
    }

}
