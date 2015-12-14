// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;

public class brd
{

    public static bre a(Context context)
    {
        Object obj = context.getSharedPreferences("com.wantu.android.WantuSetting", 0);
        context = ((SharedPreferences) (obj)).getString("com.wantu.android.weibo.qq_token", null);
        obj = ((SharedPreferences) (obj)).getString("com.wantu.android.weibo.qq_secret", null);
        bre bre1 = new bre();
        bre1.a(context);
        bre1.b(((String) (obj)));
        return bre1;
    }

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
}
