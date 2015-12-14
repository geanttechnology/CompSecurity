// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class bxv
{

    public static float a(Context context)
    {
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            context = (ActivityManager)context.getSystemService("activity");
            android.app.ActivityManager.MemoryInfo memoryinfo = new android.app.ActivityManager.MemoryInfo();
            context.getMemoryInfo(memoryinfo);
            return (float)memoryinfo.totalMem / 1.073742E+09F;
        }
        float f;
        String s;
        String as[];
        String s1;
        int i;
        int j;
        try
        {
            context = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
            s = context.readLine();
            as = s.split("\\s+");
            j = as.length;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return -1F;
        }
        i = 0;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = as[i];
        Log.i(s, (new StringBuilder()).append(s1).append("\t").toString());
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_79;
_L1:
        f = (float)Integer.valueOf(as[1]).intValue() / 1048576F;
        context.close();
        return f;
    }

    public static Bitmap a(Context context, String s)
    {
        Object obj = null;
        android.graphics.BitmapFactory.Options options = new android.graphics.BitmapFactory.Options();
        options.inScaled = false;
        options.inPreferredConfig = android.graphics.Bitmap.Config.ARGB_8888;
        Context context1 = obj;
        try
        {
            s = context.getAssets().open(s);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return context1;
        }
        context1 = obj;
        context = BitmapFactory.decodeStream(s, null, options);
        context1 = context;
        s.close();
        return context;
    }
}
