// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.b;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.nostra13.universalimageloader.b:
//            d

public final class f
{

    public static File a(Context context)
    {
        return a(context, true);
    }

    public static File a(Context context, boolean flag)
    {
        Object obj1 = null;
        File file;
        Object obj;
        try
        {
            obj = Environment.getExternalStorageState();
        }
        catch (NullPointerException nullpointerexception)
        {
            obj = "";
        }
        file = obj1;
        if (flag)
        {
            file = obj1;
            if ("mounted".equals(obj))
            {
                file = obj1;
                if (d(context))
                {
                    file = c(context);
                }
            }
        }
        obj = file;
        if (file == null)
        {
            obj = context.getCacheDir();
        }
        file = ((File) (obj));
        if (obj == null)
        {
            context = (new StringBuilder()).append("/data/data/").append(context.getPackageName()).append("/cache/").toString();
            com.nostra13.universalimageloader.b.d.c("Can't define system cache directory! '%s' will be used.", new Object[] {
                context
            });
            file = new File(context);
        }
        return file;
    }

    public static File b(Context context)
    {
        context = a(context);
        File file = new File(context, "uil-images");
        if (!file.exists() && !file.mkdir())
        {
            return context;
        } else
        {
            return file;
        }
    }

    private static File c(Context context)
    {
        File file;
label0:
        {
            file = new File(new File(new File(new File(Environment.getExternalStorageDirectory(), "Android"), "data"), context.getPackageName()), "cache");
            context = file;
            if (!file.exists())
            {
                if (file.mkdirs())
                {
                    break label0;
                }
                com.nostra13.universalimageloader.b.d.c("Unable to create external cache directory", new Object[0]);
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
            com.nostra13.universalimageloader.b.d.b("Can't create \".nomedia\" file in application external cache directory", new Object[0]);
            return file;
        }
        return file;
    }

    private static boolean d(Context context)
    {
        return context.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }
}
