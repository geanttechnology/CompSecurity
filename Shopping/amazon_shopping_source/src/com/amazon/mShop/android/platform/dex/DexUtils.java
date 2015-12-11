// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.android.platform.dex;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.util.Log;
import dalvik.system.DexFile;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;

public class DexUtils
{

    public DexUtils()
    {
    }

    private static boolean appIsUpdated(Context context)
    {
        long l;
        long l1;
        try
        {
            l = context.getSharedPreferences("app_dependencies_update", 0).getLong("lastUpdate", 0L);
            l1 = (new File(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir)).lastModified();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return true;
        }
        return l1 > l;
    }

    public static File copyJarAndOptimize(Context context, String s)
    {
        File file;
        file = new File(getDexOutputDir(context), s);
        s = (new StringBuilder()).append("dependencies/").append(s).toString();
        if (file.exists() && !differentLength(context, file, s) && !appIsUpdated(context)) goto _L2; else goto _L1
_L1:
        Object obj1;
        Object obj2;
        Object obj = null;
        Object obj4 = null;
        obj1 = null;
        Object obj3 = null;
        obj2 = null;
        int i;
        try
        {
            s = new BufferedInputStream(context.getAssets().open(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            context = obj4;
            obj1 = obj2;
            continue; /* Loop/switch isn't completed */
        }
        finally { }
        obj = new BufferedOutputStream(new FileOutputStream(file));
        obj1 = new byte[8192];
_L5:
        i = s.read(((byte []) (obj1)), 0, 8192);
        if (i <= 0) goto _L4; else goto _L3
_L3:
        ((BufferedOutputStream) (obj)).write(((byte []) (obj1)), 0, i);
          goto _L5
        obj1;
        context = s;
        s = ((String) (obj1));
        obj1 = obj;
_L9:
        obj = context;
        throw new IllegalStateException("Could not copy .dex from APK to data directory", s);
_L7:
        if (obj1 != null)
        {
            try
            {
                ((BufferedOutputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        if (obj != null)
        {
            try
            {
                ((BufferedInputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        throw context;
_L4:
        if (obj != null)
        {
            try
            {
                ((BufferedOutputStream) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj) { }
        }
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
_L2:
        if (file.length() > 0L)
        {
            try
            {
                context = optimizedPathFor(file, getPrivateDexCache(context));
                s = new File(context);
                if (s.exists())
                {
                    s.delete();
                }
                DexFile.loadDex(file.getAbsolutePath(), context, 0);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return file;
            }
        }
        return file;
        context;
        obj = s;
        obj1 = obj3;
        continue; /* Loop/switch isn't completed */
        context;
        obj1 = obj;
        obj = s;
        if (true) goto _L7; else goto _L6
_L6:
        break MISSING_BLOCK_LABEL_88;
        IOException ioexception;
        ioexception;
        context = s;
        obj1 = obj2;
        s = ioexception;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public static String copyJarsToAppPrivateFolder(Context context, ThreadPoolExecutor threadpoolexecutor)
        throws IOException
    {
        Object obj = getDexFileListFromAssets(context);
        ArrayList arraylist = new ArrayList();
        context.getDir("dependencies-cache", 0).mkdirs();
        if (threadpoolexecutor != null)
        {
            CountDownLatch countdownlatch = new CountDownLatch(((List) (obj)).size());
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); threadpoolexecutor.execute(new Runnable(context, (String)((Iterator) (obj)).next(), arraylist, countdownlatch) {

        final Context val$context;
        final List val$destFileList;
        final CountDownLatch val$loadingLatch;
        final String val$singleDexFileName;

        public void run()
        {
            File file1 = DexUtils.copyJarAndOptimize(context, singleDexFileName);
            Collections.synchronizedList(destFileList).add(file1.getAbsolutePath());
            loadingLatch.countDown();
        }

            
            {
                context = context1;
                singleDexFileName = s;
                destFileList = list;
                loadingLatch = countdownlatch;
                super();
            }
    })) { }
            try
            {
                countdownlatch.await();
            }
            // Misplaced declaration of an exception variable
            catch (ThreadPoolExecutor threadpoolexecutor)
            {
                Log.d("SecondDexEntry", "Dex copying and optimize interrupted", threadpoolexecutor);
            }
        } else
        {
            threadpoolexecutor = ((List) (obj)).iterator();
            while (threadpoolexecutor.hasNext()) 
            {
                File file = copyJarAndOptimize(context, (String)threadpoolexecutor.next());
                Collections.synchronizedList(arraylist).add(file.getAbsolutePath());
            }
        }
        recordLastDexModification(context);
        return TextUtils.join(File.pathSeparator, arraylist);
    }

    private static boolean differentLength(Context context, File file, String s)
    {
        long l;
        long l1;
        try
        {
            l = file.length();
            l1 = context.getAssets().openFd(s).getLength();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return true;
        }
        return l != l1;
    }

    public static String getAppPrivateNativeLibsPath(Context context)
        throws android.content.pm.PackageManager.NameNotFoundException
    {
        return context.getPackageManager().getApplicationInfo(context.getPackageName(), 1024).nativeLibraryDir;
    }

    public static List getDexFileListFromAssets(Context context)
        throws IOException
    {
        Object obj;
        context = new BufferedReader(new InputStreamReader(context.getAssets().open("dependencies/jarlist.txt")));
        obj = new LinkedList();
_L1:
        String s = context.readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        ((LinkedList) (obj)).add(s);
          goto _L1
        obj;
        context.close();
        throw obj;
        context.close();
        return ((List) (obj));
    }

    private static File getDexOutputDir(Context context)
    {
        return context.getDir("dependencies", 0);
    }

    private static File getPrivateDexCache(Context context)
    {
        return context.getDir("dependencies-cache", 0);
    }

    public static String getPrivateDexCachePath(Context context)
    {
        return getPrivateDexCache(context).getAbsolutePath();
    }

    private static String optimizedPathFor(File file, File file1)
    {
        String s = file.getName();
        file = s;
        if (!s.endsWith(".dex"))
        {
            int i = s.lastIndexOf(".");
            if (i < 0)
            {
                file = (new StringBuilder()).append(s).append(".dex").toString();
            } else
            {
                file = new StringBuilder(i + 4);
                file.append(s, 0, i);
                file.append(".dex");
                file = file.toString();
            }
        }
        return (new File(file1, file)).getPath();
    }

    private static void recordLastDexModification(Context context)
    {
        try
        {
            SharedPreferences sharedpreferences = context.getSharedPreferences("app_dependencies_update", 0);
            long l = (new File(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir)).lastModified();
            sharedpreferences.edit().putLong("lastUpdate", l).commit();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return;
        }
    }
}
