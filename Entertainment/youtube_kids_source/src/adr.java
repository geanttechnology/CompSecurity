// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class adr extends SQLiteOpenHelper
{

    private static final int CURRENT_VERSION = 1;
    public static final String DATABASE_FILE = "KidsLocal.db";
    private static final String ON_CREATE_METHOD_NAME = "onTableCreate";
    private static final String ON_UPDATE_METHOD_NAME = "onTableUpdate";
    private static final Class dataTableList[] = {
        aek
    };

    public adr(Context context)
    {
        super(context, "KidsLocal.db", null, 1);
    }

    public final void onCreate(SQLiteDatabase sqlitedatabase)
    {
        int i = 0;
        Class aclass[] = dataTableList;
        int j = aclass.length;
        while (i < j) 
        {
            Class class1 = aclass[i];
            try
            {
                class1.getDeclaredMethod("onTableCreate", new Class[] {
                    android/database/sqlite/SQLiteDatabase
                }).invoke(null, new Object[] {
                    sqlitedatabase
                });
            }
            // Misplaced declaration of an exception variable
            catch (SQLiteDatabase sqlitedatabase)
            {
                throw new RuntimeException(sqlitedatabase);
            }
            // Misplaced declaration of an exception variable
            catch (SQLiteDatabase sqlitedatabase)
            {
                throw new RuntimeException(sqlitedatabase);
            }
            // Misplaced declaration of an exception variable
            catch (SQLiteDatabase sqlitedatabase)
            {
                throw new RuntimeException(sqlitedatabase);
            }
            // Misplaced declaration of an exception variable
            catch (SQLiteDatabase sqlitedatabase)
            {
                throw new RuntimeException(sqlitedatabase);
            }
            i++;
        }
    }

    public final void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        int k = 0;
        Class aclass[] = dataTableList;
        int l = aclass.length;
        while (k < l) 
        {
            Class class1 = aclass[k];
            try
            {
                class1.getDeclaredMethod("onTableUpdate", new Class[] {
                    android/database/sqlite/SQLiteDatabase, java/lang/Integer, java/lang/Integer
                }).invoke(null, new Object[] {
                    sqlitedatabase, Integer.valueOf(i), Integer.valueOf(j)
                });
            }
            // Misplaced declaration of an exception variable
            catch (SQLiteDatabase sqlitedatabase)
            {
                throw new RuntimeException(sqlitedatabase);
            }
            // Misplaced declaration of an exception variable
            catch (SQLiteDatabase sqlitedatabase)
            {
                throw new RuntimeException(sqlitedatabase);
            }
            // Misplaced declaration of an exception variable
            catch (SQLiteDatabase sqlitedatabase)
            {
                throw new RuntimeException(sqlitedatabase);
            }
            // Misplaced declaration of an exception variable
            catch (SQLiteDatabase sqlitedatabase)
            {
                throw new RuntimeException(sqlitedatabase);
            }
            k++;
        }
    }

}
