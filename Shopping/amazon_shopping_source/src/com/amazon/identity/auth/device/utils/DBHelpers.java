// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.amazon.identity.auth.device.framework.SQLTable;
import com.amazon.identity.auth.device.framework.SecureContentResolver;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            MAPLog, StringHelpers

public final class DBHelpers
{

    public static final int FALSE = 0;
    private static final String TAG = com/amazon/identity/auth/device/utils/DBHelpers.getName();
    public static final int TRUE = 1;

    private DBHelpers()
    {
    }

    public static void closeCursor(Cursor cursor)
    {
        if (cursor == null)
        {
            return;
        } else
        {
            cursor.close();
            return;
        }
    }

    public static boolean containsColumn(Cursor cursor, String s)
    {
        return cursor.getColumnIndex(s) >= 0;
    }

    public static String getAliasColumnName(String s, String s1, String s2)
    {
        return String.format("%s.%s as %s", new Object[] {
            s, s1, s2
        });
    }

    public static boolean getBoolean(Cursor cursor, String s)
    {
        return getLong(cursor, s) == 1L;
    }

    public static Date getDate(Cursor cursor, String s)
    {
        return new Date(getLong(cursor, s));
    }

    public static int getInt(Cursor cursor, String s)
    {
        return cursor.getInt(cursor.getColumnIndex(s));
    }

    public static long getLong(Cursor cursor, String s)
    {
        return cursor.getLong(cursor.getColumnIndex(s));
    }

    public static String getNamespaceColumnName(String s, String s1)
    {
        return String.format("%s.%s", new Object[] {
            s, s1
        });
    }

    private static String getResultFromCursor(Cursor cursor, String s)
    {
        if (!cursor.moveToFirst())
        {
            return null;
        } else
        {
            return getString(cursor, s);
        }
    }

    public static String getString(Cursor cursor, String s)
    {
        return cursor.getString(cursor.getColumnIndex(s));
    }

    public static boolean ifCannotUpdateThenInsert(SQLiteDatabase sqlitedatabase, String s, ContentValues contentvalues, String s1, String as[])
    {
        boolean flag = true;
        if (sqlitedatabase.update(s, contentvalues, s1, as) > 0)
        {
            return true;
        }
        long l = sqlitedatabase.insertOrThrow(s, null, contentvalues);
        if (l < 0L)
        {
            return false;
        }
        break MISSING_BLOCK_LABEL_51;
        sqlitedatabase;
        MAPLog.w(TAG, "Error inserting into database in ifCannotUpdateThenInsert");
        sqlitedatabase = TAG;
        flag = false;
        return flag;
    }

    public static boolean isNull(Cursor cursor, String s)
    {
        return cursor.isNull(cursor.getColumnIndex(s));
    }

    public static Cursor populateCursor(String as[], Collection collection)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = obj1;
        if (as == null) goto _L2; else goto _L1
_L1:
        if (collection != null) goto _L4; else goto _L3
_L3:
        obj = obj1;
_L2:
        return ((Cursor) (obj));
_L4:
        if (as.length >= 10000)
        {
            MAPLog.e(TAG, String.format("The number of columns %d is too large to be handled. Issue tracked in SSO-160.", new Object[] {
                Integer.valueOf(as.length)
            }));
            return null;
        }
        MatrixCursor matrixcursor = new MatrixCursor(as);
        collection = collection.iterator();
        do
        {
            obj = matrixcursor;
            if (!collection.hasNext())
            {
                continue;
            }
            obj = (Map)collection.next();
            String as1[] = new String[as.length];
            int i = 0;
            while (i < as.length) 
            {
                String s = as[i];
                if (((Map) (obj)).containsKey(s))
                {
                    as1[i] = (String)((Map) (obj)).get(s);
                } else
                {
                    String s1 = TAG;
                    String.format("Column %s not supported", new Object[] {
                        s
                    });
                }
                i++;
            }
            matrixcursor.addRow(as1);
        } while (true);
        if (true) goto _L2; else goto _L5
_L5:
    }

    public static Cursor populateCursor(String as[], Map map)
    {
        if (as == null || map == null)
        {
            return null;
        } else
        {
            return populateCursor(as, ((Collection) (Arrays.asList(new Map[] {
                map
            }))));
        }
    }

    public static String querySingleResult(SQLiteDatabase sqlitedatabase, String s, String s1, String s2, String as[])
    {
        return querySingleResult(sqlitedatabase, s, s1, s2, as, null);
    }

    public static String querySingleResult(SQLiteDatabase sqlitedatabase, String s, String s1, String s2, String as[], String s3)
    {
        sqlitedatabase = sqlitedatabase.query(s, new String[] {
            s1
        }, s2, as, null, null, s3);
        if (sqlitedatabase == null)
        {
            return null;
        }
        s = getResultFromCursor(sqlitedatabase, s1);
        sqlitedatabase.close();
        return s;
        s;
        sqlitedatabase.close();
        throw s;
    }

    public static String querySingleResult(SecureContentResolver securecontentresolver, Uri uri, String s, String s1, String as[])
    {
        return querySingleResult(securecontentresolver, uri, s, s1, as, null);
    }

    public static String querySingleResult(SecureContentResolver securecontentresolver, Uri uri, String s, String s1, String as[], String s2)
    {
        securecontentresolver = securecontentresolver.query(uri, new String[] {
            s
        }, s1, as, s2);
        if (securecontentresolver == null)
        {
            return null;
        }
        uri = getResultFromCursor(securecontentresolver, s);
        securecontentresolver.close();
        return uri;
        uri;
        securecontentresolver.close();
        throw uri;
    }

    public static boolean tryInsert(SQLiteDatabase sqlitedatabase, String s, ContentValues contentvalues)
    {
        boolean flag = false;
        long l;
        try
        {
            l = sqlitedatabase.insertOrThrow(s, null, contentvalues);
        }
        // Misplaced declaration of an exception variable
        catch (SQLiteDatabase sqlitedatabase)
        {
            MAPLog.w(TAG, "Error inserting into database in tryInsert");
            sqlitedatabase = TAG;
            return false;
        }
        if (l >= 0L)
        {
            flag = true;
        }
        return flag;
    }

    public static transient void upgradeTable(SQLiteDatabase sqlitedatabase, SQLTable sqltable, String as[])
    {
        SQLTable sqltable1 = new SQLTable(sqltable);
        sqltable1.setName((new StringBuilder("temp_")).append(sqltable.getName()).toString());
        sqlitedatabase.execSQL(sqltable1.toString());
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            sqlitedatabase.execSQL(as[i]);
        }

        as = StringHelpers.join(", ", sqltable1.getColumnNames());
        sqlitedatabase.execSQL(String.format("INSERT INTO %s (%s) SELECT %s FROM %s;", new Object[] {
            sqltable1.getName(), as, as, sqltable.getName()
        }));
        sqlitedatabase.execSQL(String.format("DROP TABLE %s;", new Object[] {
            sqltable.getName()
        }));
        sqlitedatabase.execSQL(String.format("ALTER TABLE %s RENAME TO %s;", new Object[] {
            sqltable1.getName(), sqltable.getName()
        }));
    }

}
