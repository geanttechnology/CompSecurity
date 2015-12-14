// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import com.crashlytics.android.Crashlytics;

public class yo
{

    public static final boolean a(Context context)
    {
        SharedPreferences sharedpreferences;
        sharedpreferences = context.getSharedPreferences("sysconfig", 0);
        boolean flag = sharedpreferences.getBoolean("isWebViewProbablyCorrupt", true);
        if (!flag)
        {
            return flag;
        }
        context = context.openOrCreateDatabase("webviewCache.db", 0, null);
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        context.close();
        sharedpreferences.edit().putBoolean("isWebViewProbablyCorrupt", false).commit();
        return false;
        context;
        Crashlytics.logException(context);
        return true;
    }
}
