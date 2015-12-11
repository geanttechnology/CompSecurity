// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crittercism.app;

import android.content.Context;
import android.content.res.AssetManager;
import crittercism.android.dg;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CrittercismNDK
{

    private static boolean isNdkInstalled = false;

    public static boolean copyLibFromAssets(Context context, File file)
    {
        dg.b();
        byte abyte0[];
        file.getParentFile().mkdirs();
        file = new FileOutputStream(file);
        context = getJarredLibFileStream(context);
        abyte0 = new byte[8192];
_L1:
        int i = context.read(abyte0);
label0:
        {
            if (i < 0)
            {
                break label0;
            }
            try
            {
                file.write(abyte0, 0, i);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                dg.b("Crittercism", (new StringBuilder("Could not install breakpad library: ")).append(context.toString()).toString());
                return false;
            }
        }
          goto _L1
        context.close();
        file.close();
        return true;
    }

    public static boolean doNdkSharedLibrariesExist(Context context)
    {
        try
        {
            getJarredLibFileStream(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return true;
    }

    public static InputStream getJarredLibFileStream(Context context)
    {
        String s = "armeabi";
        if (System.getProperty("os.arch").contains("v7"))
        {
            s = (new StringBuilder()).append("armeabi").append("-v7a").toString();
        }
        return context.getAssets().open((new StringBuilder()).append(s).append("/libcrittercism-v3.so").toString());
    }

    public static native boolean installNdk(String s);

    public static void installNdkLib(Context context, String s)
    {
        boolean flag = true;
        s = (new StringBuilder()).append(context.getFilesDir().getAbsolutePath()).append("/").append(s).toString();
        if (doNdkSharedLibrariesExist(context))
        {
            flag = loadLibraryFromAssets(context);
        } else
        {
            try
            {
                System.loadLibrary("crittercism-v3");
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                flag = false;
            }
        }
        if (!flag)
        {
            return;
        }
        try
        {
            if (installNdk(s))
            {
                (new File(s)).mkdirs();
                isNdkInstalled = true;
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
        dg.c("Crittercism", "Unable to initialize NDK crash reporting.");
        return;
    }

    public static boolean loadLibraryFromAssets(Context context)
    {
        File file1 = new File(context.getFilesDir(), "/com.crittercism/lib/");
        File file = new File(file1, "libcrittercism-v3.so");
        file1 = new File(file1, "libcrittercism-ndk.so");
        if (!file.exists())
        {
            if (!copyLibFromAssets(context, file))
            {
                file.delete();
                return false;
            }
            file1.delete();
        }
        try
        {
            System.load(file.getAbsolutePath());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            dg.a("Crittercism", "Unable to install NDK library", context);
            file.delete();
            return false;
        }
        return true;
    }

}
