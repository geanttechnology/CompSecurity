// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.bitmap.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import java.io.File;

public class BitmapCommonUtils
{

    private static final String TAG = "BitmapCommonUtils";

    public BitmapCommonUtils()
    {
    }

    public static int getBitmapSize(Bitmap bitmap)
    {
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public static File getDiskCacheDir(Context context, String s)
    {
        if ("mounted".equals(Environment.getExternalStorageState()))
        {
            context = getExternalCacheDir(context).getPath();
        } else
        {
            context = context.getCacheDir().getPath();
        }
        return new File((new StringBuilder(String.valueOf(context))).append(File.separator).append(s).toString());
    }

    public static File getExternalCacheDir(Context context)
    {
        context = (new StringBuilder("/Android/data/")).append(context.getPackageName()).append("/cache/").toString();
        return new File((new StringBuilder(String.valueOf(Environment.getExternalStorageDirectory().getPath()))).append(context).toString());
    }

    public static long getUsableSpace(File file)
    {
        int i;
        long l;
        try
        {
            file = new StatFs(file.getPath());
            l = file.getBlockSize();
            i = file.getAvailableBlocks();
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            Log.e("BitmapCommonUtils", "\u83B7\u53D6 sdcard \u7F13\u5B58\u5927\u5C0F \u51FA\u9519\uFF0C\u8BF7\u67E5\u770BAndroidManifest.xml \u662F\u5426\u6DFB\u52A0\u4E86sdcard\u7684\u8BBF\u95EE\u6743\u9650");
            file.printStackTrace();
            return -1L;
        }
        return l * (long)i;
    }
}
