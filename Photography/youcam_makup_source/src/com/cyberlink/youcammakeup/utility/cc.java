// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import android.content.Context;
import android.content.SharedPreferences;
import com.cyberlink.beautycircle.utility.AccountManager;
import com.cyberlink.youcammakeup.Globals;

public final class cc
{

    public static String a()
    {
        return Globals.d().getApplicationContext().getSharedPreferences("UnlockShareLookFile", 0).getString("ApplyShareLookGUID", "null");
    }

    public static void a(String s)
    {
        if (d(s))
        {
            return;
        } else
        {
            android.content.SharedPreferences.Editor editor = Globals.d().getApplicationContext().getSharedPreferences("UnlockShareLookFile", 0).edit();
            editor.putString("ApplyShareLookGUID", s);
            editor.commit();
            return;
        }
    }

    public static void a(String s, String s1)
    {
        android.content.SharedPreferences.Editor editor = Globals.d().getApplicationContext().getSharedPreferences("UnlockShareLookSucceedDescriptionFile", 0).edit();
        editor.putString(s, s1);
        editor.commit();
    }

    public static boolean a(com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata.UnlockMethod unlockmethod)
    {
        return unlockmethod == com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata.UnlockMethod.b && AccountManager.b() != null;
    }

    public static String b(String s)
    {
        return Globals.d().getApplicationContext().getSharedPreferences("UnlockShareLookFile", 0).getString(s, "");
    }

    public static void b()
    {
        a("null");
    }

    public static void c(String s)
    {
        android.content.SharedPreferences.Editor editor = Globals.d().getApplicationContext().getSharedPreferences("UnlockShareLookFile", 0).edit();
        editor.putString(s, "KEY__UNLOCKED");
        editor.commit();
    }

    public static boolean d(String s)
    {
        return b(s).equals("KEY__UNLOCKED");
    }

    public static String e(String s)
    {
        return Globals.d().getApplicationContext().getSharedPreferences("UnlockShareLookSucceedDescriptionFile", 0).getString(s, "");
    }
}
