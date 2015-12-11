// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.base;

import android.content.Context;
import android.util.Log;
import java.io.File;

// Referenced classes of package org.chromium.base:
//            PathUtils

public class ResourceExtractor
{

    private static String a[] = null;
    private static boolean b = true;
    private final Context c;

    static File a(ResourceExtractor resourceextractor)
    {
        return resourceextractor.d();
    }

    static boolean a(String s)
    {
        return "icudtl.dat".equals(s) || "natives_blob.bin".equals(s) || "snapshot_blob.bin".equals(s);
    }

    static String[] a()
    {
        return null;
    }

    static File b(ResourceExtractor resourceextractor)
    {
        return resourceextractor.c();
    }

    static boolean b()
    {
        return b;
    }

    private File c()
    {
        return new File(PathUtils.getDataDirectory(c));
    }

    static void c(ResourceExtractor resourceextractor)
    {
        File file = new File(resourceextractor.c(), "icudtl.dat");
        if (file.exists() && !file.delete())
        {
            Log.e("ResourceExtractor", (new StringBuilder("Unable to remove the icudata ")).append(file.getName()).toString());
        }
        file = new File(resourceextractor.c(), "natives_blob.bin");
        if (file.exists() && !file.delete())
        {
            Log.e("ResourceExtractor", (new StringBuilder("Unable to remove the v8 data ")).append(file.getName()).toString());
        }
        file = new File(resourceextractor.c(), "snapshot_blob.bin");
        if (file.exists() && !file.delete())
        {
            Log.e("ResourceExtractor", (new StringBuilder("Unable to remove the v8 data ")).append(file.getName()).toString());
        }
        resourceextractor = resourceextractor.d();
        if (resourceextractor.exists())
        {
            resourceextractor = resourceextractor.listFiles();
            int j = resourceextractor.length;
            for (int i = 0; i < j; i++)
            {
                File file1 = resourceextractor[i];
                if (!file1.delete())
                {
                    Log.e("ResourceExtractor", (new StringBuilder("Unable to remove existing resource ")).append(file1.getName()).toString());
                }
            }

        }
    }

    static Context d(ResourceExtractor resourceextractor)
    {
        return resourceextractor.c;
    }

    private File d()
    {
        return new File(c(), "paks");
    }

    static 
    {
        org/chromium/base/ResourceExtractor.desiredAssertionStatus();
    }
}
