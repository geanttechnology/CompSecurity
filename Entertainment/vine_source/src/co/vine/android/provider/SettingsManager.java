// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import co.vine.android.util.Util;

// Referenced classes of package co.vine.android.provider:
//            VineDatabaseHelper

public class SettingsManager
{

    private static final String CURRENT_ACCOUNT_KEY = "current_account";
    private static final String CURRENT_ACCOUNT_NAME = "current_name";
    private static final String CURRENT_USER_ID_KEY = "current_user_id";
    private static final String VALUE_PROJECTION[] = {
        "value"
    };

    private SettingsManager()
    {
    }

    public static String getCurrentAccount(Context context)
    {
        return getValue(context, "current_account", ((String) (null)));
    }

    public static String getCurrentAccountName(Context context)
    {
        return getValue(context, "current_name", ((String) (null)));
    }

    public static long getCurrentUserId(Context context)
    {
        return getValue(context, "current_user_id", 0L);
    }

    public static String getEdition(Context context)
    {
        return Util.getDefaultSharedPrefs(context).getString("settings_edition", null);
    }

    private static long getValue(Context context, String s, long l)
    {
        co/vine/android/provider/SettingsManager;
        JVM INSTR monitorenter ;
        context = context.getContentResolver().query(Vine.Settings.CONTENT_URI, VALUE_PROJECTION, "name=?", new String[] {
            s
        }, null);
        long l1;
        l1 = l;
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        if (context.moveToFirst())
        {
            l = context.getLong(0);
        }
        context.close();
        l1 = l;
        co/vine/android/provider/SettingsManager;
        JVM INSTR monitorexit ;
        return l1;
        context;
        throw context;
    }

    private static String getValue(Context context, String s, String s1)
    {
        co/vine/android/provider/SettingsManager;
        JVM INSTR monitorenter ;
        s = context.getContentResolver().query(Vine.Settings.CONTENT_URI, VALUE_PROJECTION, "name=?", new String[] {
            s
        }, null);
        context = s1;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        if (s.moveToFirst())
        {
            s1 = s.getString(0);
        }
        s.close();
        context = s1;
        co/vine/android/provider/SettingsManager;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public static void setCurrentAccount(Context context, String s, String s1, long l)
    {
        setValue(context, "current_account", s);
        setValue(context, "current_user_id", l);
        setValue(context, "current_name", s1);
    }

    private static void setValue(Context context, String s, long l)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("value", Long.valueOf(l));
        VineDatabaseHelper.getDatabaseHelper(context).saveUserValue(s, contentvalues);
    }

    private static void setValue(Context context, String s, String s1)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("value", s1);
        VineDatabaseHelper.getDatabaseHelper(context).saveUserValue(s, contentvalues);
    }

}
