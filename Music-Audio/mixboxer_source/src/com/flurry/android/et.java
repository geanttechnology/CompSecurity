// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

// Referenced classes of package com.flurry.android:
//            AppCloudUser, FlurryAppCloud

final class et
{

    private static Context mContext = null;

    et()
    {
    }

    static void A(String s)
    {
        com/flurry/android/et;
        JVM INSTR monitorenter ;
        Context context = mContext;
        if (context != null) goto _L2; else goto _L1
_L1:
        com/flurry/android/et;
        JVM INSTR monitorexit ;
        return;
_L2:
        android.content.SharedPreferences.Editor editor = mContext.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).edit();
        editor.putString("flurry_last_user_pass", s);
        editor.commit();
        if (true) goto _L1; else goto _L3
_L3:
        s;
        throw s;
    }

    static void aX()
    {
        com/flurry/android/et;
        JVM INSTR monitorenter ;
        Context context = mContext;
        if (context != null) goto _L2; else goto _L1
_L1:
        com/flurry/android/et;
        JVM INSTR monitorexit ;
        return;
_L2:
        android.content.SharedPreferences.Editor editor = mContext.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).edit();
        editor.putString("flurry_last_user_session", "");
        editor.commit();
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    static AppCloudUser aY()
    {
        Object obj = null;
        com/flurry/android/et;
        JVM INSTR monitorenter ;
        Object obj1 = mContext;
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        com/flurry/android/et;
        JVM INSTR monitorexit ;
        return ((AppCloudUser) (obj));
_L2:
        obj1 = new AppCloudUser();
        String s = aZ();
        if (TextUtils.isEmpty(s))
        {
            continue; /* Loop/switch isn't completed */
        }
        ((AppCloudUser) (obj1)).setId(s);
        obj = ba();
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            ((AppCloudUser) (obj1)).setUsername(((String) (obj)));
        }
        obj = bb();
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            ((AppCloudUser) (obj1)).setEmail(((String) (obj)));
        }
        obj1.password = bc();
        obj = obj1;
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    static String aZ()
    {
        com/flurry/android/et;
        JVM INSTR monitorenter ;
        if (mContext != null) goto _L2; else goto _L1
_L1:
        String s = "";
_L4:
        com/flurry/android/et;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = mContext.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).getString("flurry_last_user_id", "");
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    static String ba()
    {
        com/flurry/android/et;
        JVM INSTR monitorenter ;
        if (mContext != null) goto _L2; else goto _L1
_L1:
        String s = "";
_L4:
        com/flurry/android/et;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = mContext.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).getString("flurry_last_user_name", "");
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    static String bb()
    {
        com/flurry/android/et;
        JVM INSTR monitorenter ;
        if (mContext != null) goto _L2; else goto _L1
_L1:
        String s = "";
_L4:
        com/flurry/android/et;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = mContext.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).getString("flurry_last_user_email", "");
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    static String bc()
    {
        com/flurry/android/et;
        JVM INSTR monitorenter ;
        if (mContext != null) goto _L2; else goto _L1
_L1:
        String s = "";
_L4:
        com/flurry/android/et;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = mContext.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).getString("flurry_last_user_pass", "");
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    static String bd()
    {
        com/flurry/android/et;
        JVM INSTR monitorenter ;
        if (mContext != null) goto _L2; else goto _L1
_L1:
        String s = "";
_L4:
        com/flurry/android/et;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = mContext.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).getString("flurry_last_user_session", "");
        Log.i("AppCloudUserHelper", (new StringBuilder()).append("User Session = ").append(s).toString());
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    static void be()
    {
        com/flurry/android/et;
        JVM INSTR monitorenter ;
        Context context = mContext;
        if (context != null) goto _L2; else goto _L1
_L1:
        com/flurry/android/et;
        JVM INSTR monitorexit ;
        return;
_L2:
        mContext.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).edit().clear().commit();
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    static void d(String s, String s1, String s2)
    {
        com/flurry/android/et;
        JVM INSTR monitorenter ;
        Context context = mContext;
        if (context != null) goto _L2; else goto _L1
_L1:
        com/flurry/android/et;
        JVM INSTR monitorexit ;
        return;
_L2:
        android.content.SharedPreferences.Editor editor = mContext.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).edit();
        if (!TextUtils.isEmpty(s))
        {
            editor.putString("flurry_last_user_name", s);
        }
        if (!TextUtils.isEmpty(s))
        {
            editor.putString("flurry_last_user_email", s1);
        }
        if (!TextUtils.isEmpty(s2))
        {
            editor.putString("flurry_last_user_session", s2);
        }
        editor.commit();
        Log.i("AppCloudUserHelper", (new StringBuilder()).append("saveLastLoggedInUserData, (Name, Email, Token) = ( ").append(s).append(" , ").append(s1).append(" , ").append(s2).append(" )").toString());
        if (true) goto _L1; else goto _L3
_L3:
        s;
        throw s;
    }

    static void g(Context context)
    {
        mContext = context;
    }

    static void z(String s)
    {
        com/flurry/android/et;
        JVM INSTR monitorenter ;
        Context context = mContext;
        if (context != null) goto _L2; else goto _L1
_L1:
        com/flurry/android/et;
        JVM INSTR monitorexit ;
        return;
_L2:
        android.content.SharedPreferences.Editor editor = mContext.getSharedPreferences("FLURRY_SHARED_PREFERENCES", 0).edit();
        editor.putString("flurry_last_user_id", s);
        editor.commit();
        if (!TextUtils.isEmpty(s))
        {
            FlurryAppCloud.d(mContext, s);
        }
        if (true) goto _L1; else goto _L3
_L3:
        s;
        throw s;
    }

}
