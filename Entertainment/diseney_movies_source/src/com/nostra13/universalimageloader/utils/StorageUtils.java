// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.utils;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.nostra13.universalimageloader.utils:
//            L

public final class StorageUtils
{

    private static final String INDIVIDUAL_DIR_NAME = "uil-images";

    private StorageUtils()
    {
    }

    public static File getCacheDirectory(Context context)
    {
        File file = null;
        if (Environment.getExternalStorageState().equals("mounted"))
        {
            file = getExternalCacheDir(context);
        }
        File file1 = file;
        if (file == null)
        {
            file1 = context.getCacheDir();
        }
        return file1;
    }

    private static File getExternalCacheDir(Context context)
    {
        File file;
label0:
        {
            file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "com.ywh.imgcache"), "allicon"), "com.ywh.imgcache"), "allicon");
            context = file;
            if (!file.exists())
            {
                if (file.mkdirs())
                {
                    break label0;
                }
                L.w("Unable to create external cache directory", new Object[0]);
                context = null;
            }
            return context;
        }
        try
        {
            (new File(file, ".nomedia")).createNewFile();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            L.i("Can't create \".nomedia\" file in application external cache directory", new Object[0]);
            return file;
        }
        return file;
    }

    public static File getIndividualCacheDirectory(Context context)
    {
        File file = getCacheDirectory(context);
        File file1 = new File(file, "uil-images");
        context = file1;
        if (!file1.exists())
        {
            context = file1;
            if (!file1.mkdir())
            {
                context = file;
            }
        }
        return context;
    }

    public static File getOwnCacheDirectory(Context context, String s)
    {
label0:
        {
            File file = null;
            if (Environment.getExternalStorageState().equals("mounted"))
            {
                file = new File(Environment.getExternalStorageDirectory(), s);
            }
            if (file != null)
            {
                s = file;
                if (file.exists())
                {
                    break label0;
                }
                s = file;
                if (file.mkdirs())
                {
                    break label0;
                }
            }
            s = context.getCacheDir();
        }
        return s;
    }
}
