// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Environment;
import java.io.File;

public class aaj
{

    public static File a(Context context)
    {
        File file = context.getExternalCacheDir();
        if (file == null || !file.exists()) goto _L2; else goto _L1
_L1:
        return file;
_L2:
        File file1;
        file1 = context.getCacheDir();
        if (file1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        file = file1;
        if (file1.exists()) goto _L1; else goto _L3
_L3:
        context = (new StringBuilder()).append("/Android/data/").append(context.getPackageName()).append("/cache/").toString();
        return new File((new StringBuilder()).append(Environment.getExternalStorageDirectory().getPath()).append(context).toString());
    }

    public static boolean a()
    {
        return android.os.Build.VERSION.SDK_INT >= 8;
    }

    public static boolean b()
    {
        return android.os.Build.VERSION.SDK_INT >= 9;
    }

    public static boolean c()
    {
        return android.os.Build.VERSION.SDK_INT >= 11;
    }

    public static boolean d()
    {
        return android.os.Build.VERSION.SDK_INT >= 12;
    }

    public static boolean e()
    {
        return android.os.Build.VERSION.SDK_INT >= 14;
    }

    public static boolean f()
    {
        return android.os.Build.VERSION.SDK_INT >= 15;
    }

    public static boolean g()
    {
        return android.os.Build.VERSION.SDK_INT >= 16;
    }

    public static boolean h()
    {
        return android.os.Build.VERSION.SDK_INT >= 19;
    }

    public static boolean i()
    {
        return "mounted".equals(Environment.getExternalStorageState());
    }
}
