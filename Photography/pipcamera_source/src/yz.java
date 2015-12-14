// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;

public class yz
{

    public static void a(Context context, boolean flag, String s, String s1)
    {
        int i = 0;
        context = context.getSharedPreferences("com.wantu.android.WantuSetting", 0).edit();
        if (flag)
        {
            i = 1;
        }
        context.putInt("com.wantu.android.weibo.qq_status", i);
        context.putString("com.wantu.android.weibo.qq_token", s);
        context.putString("com.wantu.android.weibo.qq_secret", s1);
        context.commit();
    }

    public static boolean a(Context context)
    {
        return context.getSharedPreferences("com.wantu.android.WantuSetting", 0).getInt("com.wantu.android.weibo.qq_status", 0) != 0;
    }

    public static za b(Context context)
    {
        Object obj = context.getSharedPreferences("com.wantu.android.WantuSetting", 0);
        context = ((SharedPreferences) (obj)).getString("com.wantu.android.weibo.qq_token", null);
        obj = ((SharedPreferences) (obj)).getString("com.wantu.android.weibo.qq_secret", null);
        za za1 = new za();
        za1.a(context);
        za1.b(((String) (obj)));
        return za1;
    }
}
