// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.content.ContentProviderClient;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.amazon.identity.auth.device.framework.ContentProviderClientCallback;
import com.amazon.identity.auth.device.framework.RemoteMAPException;
import com.amazon.identity.auth.device.framework.SecureContentResolver;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            MAPLog

public final class DBHelpers
{

    private static final String TAG = com/amazon/identity/auth/device/utils/DBHelpers.getName();

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
        break MISSING_BLOCK_LABEL_47;
        sqlitedatabase;
        MAPLog.w(TAG, "Error inserting into database in ifCannotUpdateThenInsert");
        flag = false;
        return flag;
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
        if (as == null)
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
        return querySingleResult$6d1cdcdd(sqlitedatabase, s, s1, s2, as);
    }

    public static String querySingleResult$2dd5bf17(SecureContentResolver securecontentresolver, Uri uri, String s)
        throws RemoteMAPException
    {
        return (String)securecontentresolver.acquireContentProviderClient(uri, new ContentProviderClientCallback(uri, s) {

            final String val$column;
            final String val$selection = null;
            final String val$selectionArgs[] = null;
            final String val$sortOrder = null;
            final Uri val$uri;

            public volatile Object useContentProviderClient(ContentProviderClient contentproviderclient)
                throws Exception
            {
                return useContentProviderClient(contentproviderclient);
            }

            public String useContentProviderClient(ContentProviderClient contentproviderclient)
                throws Exception
            {
                Uri uri1 = uri;
                String s2 = column;
                String s3 = selection;
                String as[] = selectionArgs;
                String s4 = sortOrder;
                contentproviderclient = contentproviderclient.query(uri1, new String[] {
                    s2
                }, s3, as, s4);
                if (contentproviderclient == null)
                {
                    return null;
                }
                String s1 = DBHelpers.getResultFromCursor(contentproviderclient, column);
                contentproviderclient.close();
                return s1;
                Exception exception;
                exception;
                contentproviderclient.close();
                throw exception;
            }

            
            {
                uri = uri1;
                column = s;
                super();
            }
        });
    }

    public static String querySingleResult$6d1cdcdd(SQLiteDatabase sqlitedatabase, String s, String s1, String s2, String as[])
    {
        sqlitedatabase = sqlitedatabase.query(s, new String[] {
            s1
        }, s2, as, null, null, null);
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
            return false;
        }
        if (l >= 0L)
        {
            flag = true;
        }
        return flag;
    }


}
