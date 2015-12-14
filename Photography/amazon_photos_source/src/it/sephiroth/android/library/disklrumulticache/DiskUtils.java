// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.disklrumulticache;

import android.content.Context;
import android.os.Environment;
import java.io.File;

public class DiskUtils
{

    public static final int IO_BUFFER_SIZE = 8192;

    public DiskUtils()
    {
    }

    public static File getExternalCacheDir(Context context)
    {
        if (hasExternalCacheDir())
        {
            File file = context.getExternalCacheDir();
            if (file != null)
            {
                return file;
            }
        }
        return context.getCacheDir();
    }

    public static boolean hasExternalCacheDir()
    {
        return android.os.Build.VERSION.SDK_INT >= 8;
    }

    public static boolean isExternalStorageRemovable()
    {
        if (android.os.Build.VERSION.SDK_INT >= 9)
        {
            return Environment.isExternalStorageRemovable();
        } else
        {
            return true;
        }
    }
}
