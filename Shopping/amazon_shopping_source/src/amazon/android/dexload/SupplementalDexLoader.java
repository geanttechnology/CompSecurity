// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.android.dexload;

import amazon.android.dexload.compatibility.DexElementCompatibility;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.util.Log;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

// Referenced classes of package amazon.android.dexload:
//            ThreadUtil

public class SupplementalDexLoader
{
    public static final class MultiThreaded extends Enum
    {

        private static final MultiThreaded $VALUES[];
        public static final MultiThreaded NO;
        public static final MultiThreaded YES;

        public static MultiThreaded valueOf(String s)
        {
            return (MultiThreaded)Enum.valueOf(amazon/android/dexload/SupplementalDexLoader$MultiThreaded, s);
        }

        public static MultiThreaded[] values()
        {
            return (MultiThreaded[])$VALUES.clone();
        }

        static 
        {
            YES = new MultiThreaded("YES", 0);
            NO = new MultiThreaded("NO", 1);
            $VALUES = (new MultiThreaded[] {
                YES, NO
            });
        }

        private MultiThreaded(String s, int i)
        {
            super(s, i);
        }
    }

    private static class SingleDexFileLoadTaskICS
        implements Runnable
    {

        protected Object mClassLoaderArray;
        protected Context mContext;
        protected DexElementCompatibility mDexElementCompatibility;
        protected String mFileName;
        protected int mIdx;
        protected CountDownLatch mLoadingLatch;

        public void run()
        {
            try
            {
                SupplementalDexLoader.optimizeAndAddToArray(mContext, mDexElementCompatibility, mClassLoaderArray, mFileName, mIdx);
            }
            catch (Exception exception) { }
            mLoadingLatch.countDown();
        }

        public SingleDexFileLoadTaskICS(Context context, DexElementCompatibility dexelementcompatibility, Object obj, String s, int i, CountDownLatch countdownlatch)
        {
            mContext = context;
            mDexElementCompatibility = dexelementcompatibility;
            mClassLoaderArray = obj;
            mFileName = s;
            mIdx = i;
            mLoadingLatch = countdownlatch;
        }
    }

    private static class SingleDexFileLoadTaskPreICS
        implements Runnable
    {

        private final Context mContext;
        private final String mFileName;
        private final int mIndex;
        private final CountDownLatch mLoadingLatch;
        private final DexFile mNewDexs[];
        private final File mNewFiles[];
        private final String mNewPaths[];
        private final ZipFile mNewZips[];

        public void run()
        {
            try
            {
                SupplementalDexLoader.loadSingleDexPreICS(mIndex, mFileName, mNewPaths, mNewFiles, mNewZips, mNewDexs, mContext);
            }
            catch (IOException ioexception) { }
            mLoadingLatch.countDown();
        }

        public SingleDexFileLoadTaskPreICS(int i, String s, String as[], File afile[], ZipFile azipfile[], DexFile adexfile[], Context context, 
                CountDownLatch countdownlatch)
        {
            mIndex = i;
            mFileName = s;
            mNewPaths = as;
            mNewFiles = afile;
            mNewZips = azipfile;
            mNewDexs = adexfile;
            mContext = context;
            mLoadingLatch = countdownlatch;
        }
    }

    private static class SingletonHolder
    {

        public static final SupplementalDexLoader INSTANCE = new SupplementalDexLoader();


        private SingletonHolder()
        {
        }
    }


    private static final String JARLIST_TXT_FILENAME = String.format("%s/%s", new Object[] {
        "dex", "jarlist.txt"
    });
    private PathClassLoader mClassLoader;
    private final CountDownLatch mDexPathUpdatedLatch = new CountDownLatch(1);
    private final AtomicBoolean mIsLoaded = new AtomicBoolean(false);
    private final AtomicBoolean mIsRunningTestInstrumentation = new AtomicBoolean(false);
    private final List mLoadedJars = new LinkedList();

    public SupplementalDexLoader()
    {
    }

    private static boolean appIsUpdated(Context context)
    {
        long l;
        long l1;
        try
        {
            l = context.getSharedPreferences("app_dex_update", 0).getLong("lastUpdate", 0L);
            l1 = (new File(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir)).lastModified();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return true;
        }
        return l1 > l;
    }

    private static boolean assetMatchesCache(Context context, File file, String s)
    {
        boolean flag = false;
        long l;
        long l1;
        try
        {
            context = context.getAssets().openFd(s);
            l = context.getLength();
            context.close();
            l1 = file.length();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("DexLoad", "Could not compare File and asset length.", context);
            return false;
        }
        if (l1 == l)
        {
            flag = true;
        }
        return flag;
    }

    private static File copyJar(Context context, String s)
    {
        File file;
        String s2;
        file = new File(context.getDir("dex", 0), s);
        s2 = String.format("%s/%s", new Object[] {
            "dex", s
        });
        if (file.exists() && assetMatchesCache(context, file, s2) && !appIsUpdated(context)) goto _L2; else goto _L1
_L1:
        IOException ioexception;
        s = null;
        Object obj1 = null;
        Object obj = null;
        ioexception = null;
        String s1 = null;
        Exception exception;
        int i;
        try
        {
            context = new BufferedInputStream(context.getAssets().open(s2));
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            context = obj1;
            continue; /* Loop/switch isn't completed */
        }
        finally { }
_L6:
        s = new BufferedOutputStream(new FileOutputStream(file));
        obj = new byte[8192];
_L5:
        i = context.read(((byte []) (obj)), 0, 8192);
        if (i <= 0) goto _L4; else goto _L3
_L3:
        s.write(((byte []) (obj)), 0, i);
          goto _L5
        ioexception;
        s1 = s;
_L9:
        s = context;
        obj = s1;
        Log.e("DexLoad", "Could not copy .dex from APK to data directory", ioexception);
        s = context;
        obj = s1;
        throw new IllegalStateException("Could not copy .dex from APK to data directory", ioexception);
_L7:
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
        throw context;
_L4:
        if (s != null)
        {
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        if (context != null)
        {
            try
            {
                context.close();
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return file;
            }
        }
_L2:
        return file;
        exception;
        s = context;
        obj = ioexception;
        context = exception;
        continue; /* Loop/switch isn't completed */
        exception;
        obj = s;
        s = context;
        context = exception;
        if (true) goto _L7; else goto _L6
        ioexception;
        if (true) goto _L9; else goto _L8
_L8:
    }

    private List filterJarList(List list)
    {
        list = new LinkedList(list);
        list.removeAll(mLoadedJars);
        return list;
    }

    private static PathClassLoader getClassLoader(Context context)
    {
        return (PathClassLoader)context.getClassLoader();
    }

    private static List getDexFilesFromAssets(Context context)
        throws IOException
    {
        List list;
        try
        {
            list = getDexListFromFile(context);
        }
        catch (IOException ioexception)
        {
            return Arrays.asList(context.getAssets().list("dex"));
        }
        return list;
    }

    private static List getDexListFromFile(Context context)
        throws IOException
    {
        Object obj;
        obj = new LinkedList();
        context = new BufferedReader(new InputStreamReader(context.getAssets().open(JARLIST_TXT_FILENAME)));
_L1:
        String s = context.readLine();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        ((List) (obj)).add(s);
          goto _L1
        obj;
        context.close();
        throw obj;
        context.close();
        return ((List) (obj));
    }

    public static SupplementalDexLoader getInstance()
    {
        return SingletonHolder.INSTANCE;
    }

    private static String getOutputPath(Context context, String s)
    {
        return (new StringBuilder()).append(context.getDir("dexopt", 0).getAbsolutePath()).append(File.separator).append(s).toString();
    }

    private static void loadSingleDexPreICS(int i, String s, String as[], File afile[], ZipFile azipfile[], DexFile adexfile[], Context context)
        throws IOException
    {
        String s1 = getOutputPath(context, s);
        s = copyJar(context, s);
        context = DexFile.loadDex(s.getAbsolutePath(), s1, 0);
        as[i] = s1;
        afile[i] = new File(s1);
        azipfile[i] = new ZipFile(s);
        adexfile[i] = context;
    }

    private static void optimizeAndAddToArray(Context context, DexElementCompatibility dexelementcompatibility, Object obj, String s, int i)
        throws ZipException, IOException, ArrayIndexOutOfBoundsException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException
    {
        String s1 = getOutputPath(context, s);
        context = copyJar(context, s);
        Array.set(obj, i, dexelementcompatibility.newInstance(context, DexFile.loadDex(context.getAbsolutePath(), s1, 0)));
    }

    private void recordLastDexModification(Context context)
    {
        try
        {
            SharedPreferences sharedpreferences = context.getSharedPreferences("app_dex_update", 0);
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

    private void updateClassLoader(Context context, MultiThreaded multithreaded, List list, boolean flag)
    {
        boolean flag1 = false;
        if (mIsLoaded.compareAndSet(false, flag)) goto _L2; else goto _L1
_L1:
        if (!mIsRunningTestInstrumentation.get()) goto _L4; else goto _L3
_L3:
        Log.w("DexLoad", "ClassLoader already updated, ignoring.");
_L6:
        return;
_L4:
        throw new IllegalStateException("updateClassLoader is finalized, should not bee called again.");
_L2:
        list = filterJarList(list);
        if (!list.isEmpty())
        {
            if (MultiThreaded.YES == multithreaded)
            {
                flag1 = true;
            }
            if (android.os.Build.VERSION.SDK_INT < 14)
            {
                updatePreICSClassLoader(context, flag1, list);
            } else
            {
                updateICSClassLoader(context, flag1, list);
            }
        }
        if (flag)
        {
            mDexPathUpdatedLatch.countDown();
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void updateICSClassLoader(Context context, boolean flag, List list)
    {
        Object obj;
        Field field;
        Object obj1;
        Object obj2;
        Object aobj[];
        DexElementCompatibility dexelementcompatibility;
        Object obj3;
        Iterator iterator;
        int i;
        try
        {
            mClassLoader = getClassLoader(context);
            obj = dalvik/system/PathClassLoader.getSuperclass().getDeclaredField("pathList");
            ((Field) (obj)).setAccessible(true);
            obj = ((Field) (obj)).get(mClassLoader);
            field = obj.getClass().getDeclaredField("dexElements");
            field.setAccessible(true);
            aobj = (Object[])(Object[])field.get(obj);
            obj3 = field.getType().getComponentType();
            obj2 = new CountDownLatch(list.size());
            obj1 = Array.newInstance(((Class) (obj3)), aobj.length + list.size());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IllegalStateException("Failed to modify classloader with supplementary .dex files.", context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IllegalStateException("Failed to modify classloader with supplementary .dex files.", context);
        }
        i = 0;
        if (i >= aobj.length)
        {
            break; /* Loop/switch isn't completed */
        }
        Array.set(obj1, i, aobj[i]);
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_117;
_L1:
        i = aobj.length;
        dexelementcompatibility = DexElementCompatibility.getDexElementCompatibility(((Class) (obj3)));
        if (!flag) goto _L4; else goto _L3
_L3:
        obj3 = ThreadUtil.createExector(new LinkedBlockingQueue(), list.size());
        iterator = list.iterator();
_L5:
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_238;
        }
        ((ThreadPoolExecutor) (obj3)).execute(new SingleDexFileLoadTaskICS(context, dexelementcompatibility, obj1, (String)iterator.next(), i, ((CountDownLatch) (obj2))));
        i++;
          goto _L5
        ((CountDownLatch) (obj2)).await();
_L8:
        field.set(obj, obj1);
        recordLastDexModification(context);
        mLoadedJars.addAll(list);
        return;
_L4:
        obj2 = list.iterator();
_L6:
        if (!((Iterator) (obj2)).hasNext())
        {
            continue; /* Loop/switch isn't completed */
        }
        optimizeAndAddToArray(context, dexelementcompatibility, obj1, (String)((Iterator) (obj2)).next(), i);
        i++;
          goto _L6
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void updatePreICSClassLoader(Context context, boolean flag, List list)
    {
        int i;
        int j;
        Field field;
        Field field1;
        Field field2;
        Field field3;
        CountDownLatch countdownlatch;
        String as[];
        File afile[];
        ZipFile azipfile[];
        DexFile adexfile[];
        Object obj;
        File afile1[];
        ZipFile azipfile1[];
        DexFile adexfile1[];
        int k;
        try
        {
            mClassLoader = getClassLoader(context);
            field = dalvik/system/PathClassLoader.getDeclaredField("mPaths");
            field.setAccessible(true);
            obj = (String[])(String[])field.get(mClassLoader);
            field1 = dalvik/system/PathClassLoader.getDeclaredField("mFiles");
            field1.setAccessible(true);
            afile1 = (File[])(File[])field1.get(mClassLoader);
            field2 = dalvik/system/PathClassLoader.getDeclaredField("mZips");
            field2.setAccessible(true);
            azipfile1 = (ZipFile[])(ZipFile[])field2.get(mClassLoader);
            field3 = dalvik/system/PathClassLoader.getDeclaredField("mDexs");
            field3.setAccessible(true);
            adexfile1 = (DexFile[])(DexFile[])field3.get(mClassLoader);
            countdownlatch = new CountDownLatch(list.size());
            i = obj.length;
            k = obj.length + list.size();
            as = new String[k];
            afile = new File[k];
            azipfile = new ZipFile[k];
            adexfile = new DexFile[k];
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IllegalStateException("Failed to modify classloader with supplementary .dex files.", context);
        }
        j = 0;
        while (j < i) 
        {
            as[j] = obj[j];
            afile[j] = afile1[j];
            azipfile[j] = azipfile1[j];
            adexfile[j] = adexfile1[j];
            j++;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_461;
        }
        obj = ThreadUtil.createExector(new LinkedBlockingQueue(), list.size());
        j = i;
_L2:
        if (j >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        ((ThreadPoolExecutor) (obj)).execute(new SingleDexFileLoadTaskPreICS(j, (String)list.get(j - i), as, afile, azipfile, adexfile, context, countdownlatch));
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        countdownlatch.await();
_L5:
        field3.set(mClassLoader, adexfile);
        field2.set(mClassLoader, azipfile);
        field.set(mClassLoader, as);
        field1.set(mClassLoader, afile);
        mLoadedJars.addAll(list);
        return;
_L3:
        j++;
        for (; j >= k; j = i)
        {
            continue; /* Loop/switch isn't completed */
        }

        loadSingleDexPreICS(j, (String)list.get(j - i), as, afile, azipfile, adexfile, context);
          goto _L3
        if (true) goto _L5; else goto _L4
_L4:
    }

    public Class loadClass(String s)
    {
        return loadClass(s, true);
    }

    public Class loadClass(String s, boolean flag)
    {
        if (flag)
        {
            waitForLoad();
        }
        try
        {
            s = mClassLoader.loadClass(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public void setRunningFromTestInstrumentation(boolean flag)
    {
        mIsRunningTestInstrumentation.set(flag);
    }

    public void updateClassLoader(Context context, MultiThreaded multithreaded)
    {
        try
        {
            updateClassLoader(context, multithreaded, getDexFilesFromAssets(context), true);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new IllegalStateException("Can't complete the dex loading request", context);
        }
    }

    public void updateClassLoader(Context context, MultiThreaded multithreaded, List list)
    {
        updateClassLoader(context, multithreaded, list, false);
    }

    public void waitForLoad()
    {
        try
        {
            mDexPathUpdatedLatch.await();
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            Thread.currentThread().interrupt();
        }
        throw new IllegalStateException("Interrupted during supplemental classload. Cannot recover.");
    }



}
