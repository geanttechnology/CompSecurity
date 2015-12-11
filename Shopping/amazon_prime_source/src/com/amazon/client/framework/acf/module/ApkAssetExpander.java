// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf.module;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.amazon.client.framework.acf.WeakRegistrar;
import com.amazon.client.framework.acf.util.AcfLog;
import com.amazon.client.framework.acf.util.Preconditions;
import com.amazon.client.framework.androidresparser.AndroidManifest;
import com.amazon.client.framework.androidresparser.BinaryParser;
import dalvik.system.DexFile;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

// Referenced classes of package com.amazon.client.framework.acf.module:
//            PrivateApk, MultiDex

public final class ApkAssetExpander
{
    public static interface ApkAssetExpanderObserver
    {

        public abstract void onAssetExpansionEnd(ApkAssetExpander apkassetexpander, Result result);

        public abstract void onAssetExpansionProgress(ApkAssetExpander apkassetexpander, int i, int j);

        public abstract void onAssetExpansionStart(ApkAssetExpander apkassetexpander);
    }

    private class InteralTaskType extends AsyncTask
    {

        private final ThreadLocal mProgressPart;
        final ApkAssetExpander this$0;

        protected transient Result doInBackground(String as[])
        {
            Context context = (Context)mCtx.get();
            if (context != null && !mTask.isCancelled()) goto _L2; else goto _L1
_L1:
            Object obj = Result.FAIL_CANCELLED;
_L12:
            return ((Result) (obj));
_L2:
            String as1[];
            String s;
            ProgressPart progresspart;
            int i;
            if (as.length == 0)
            {
                mError = new IllegalArgumentException("No asset name provided to execute methods.");
                return Result.FAIL_BADARG;
            }
            as1 = as[0].split(":");
            s = as[1];
            progresspart = (ProgressPart)mProgressPart.get();
            obj = Result.OK;
            i = 0;
_L9:
            as = ((String []) (obj));
            if (i >= as1.length) goto _L4; else goto _L3
_L3:
            if (obj == Result.OK || obj == Result.OK_NO_CHANGE) goto _L6; else goto _L5
_L5:
            as = ((String []) (obj));
_L4:
            obj = as;
            if (mPatchClassPath)
            {
                obj = new ArrayList(2);
                if (mExpanded != null)
                {
                    ((List) (obj)).add(new File(mExpanded.apkpath));
                }
                if (mExpandedDex != null)
                {
                    ((List) (obj)).add(mExpandedDex);
                }
                MultiDex.installExpandedDexes(context, new File(mExpanded.dexoptpath), ((List) (obj)));
                return as;
            }
            continue; /* Loop/switch isn't completed */
_L6:
            obj = as1[i];
            if (!((String) (obj)).endsWith(".apk"))
            {
                break; /* Loop/switch isn't completed */
            }
            if (mExpanded != null)
            {
                throw new RuntimeException("Asset expander only expands one APK");
            }
            as = BinaryParser.parseManifest(context.getAssets(), ((String) (obj)), true);
            if (as.getPackageName() == null)
            {
                mError = new IllegalArgumentException((new StringBuilder()).append(((String) (obj))).append(" Did not contain a valid manifest. It must have a valid package name.").toString());
                return Result.FAIL_BADARG;
            }
            break; /* Loop/switch isn't completed */
            as;
            mError = as;
            as = Result.FAIL_RESOURCE_EXPANSION;
            if (true) goto _L4; else goto _L7
_L7:
            ApkAssetExpander.sInstallLock.lock();
            obj = doPrivateInstallApk(context, progresspart, ((String) (obj)), as, s);
            ApkAssetExpander.cleanup(context, s, as.getPackageName());
            ApkAssetExpander.sInstallLock.unlock();
_L10:
            i++;
            if (true) goto _L9; else goto _L8
            obj;
            ApkAssetExpander.cleanup(context, s, as.getPackageName());
            ApkAssetExpander.sInstallLock.unlock();
            throw obj;
_L8:
            if (!((String) (obj)).endsWith(".dex"))
            {
                break MISSING_BLOCK_LABEL_477;
            }
            ApkAssetExpander.sInstallLock.lock();
            if (mExpandedDex != null)
            {
                throw new RuntimeException("Asset expander only expands one extra DEX.");
            }
            obj = doPrivateInstallDex(context, progresspart, ((String) (obj)), s);
            ApkAssetExpander.sInstallLock.unlock();
              goto _L10
            as;
            ApkAssetExpander.sInstallLock.unlock();
            throw as;
            mError = new IllegalArgumentException((new StringBuilder()).append(((String) (obj))).append(" extension is unsupported.").toString());
            return Result.FAIL_BADARG;
            if (true) goto _L12; else goto _L11
_L11:
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected void onPostExecute(Result result)
        {
            if (mError != null && Log.isLoggable(ApkAssetExpander.TAG, 6))
            {
                Log.e(ApkAssetExpander.TAG, result.toString(), mError);
            }
            for (Iterator iterator = mObservers.iterator(); iterator.hasNext(); ((ApkAssetExpanderObserver)iterator.next()).onAssetExpansionEnd(ApkAssetExpander.this, result)) { }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Result)obj);
        }

        protected void onPreExecute()
        {
            for (Iterator iterator = mObservers.iterator(); iterator.hasNext(); ((ApkAssetExpanderObserver)iterator.next()).onAssetExpansionStart(ApkAssetExpander.this)) { }
        }

        protected transient void onProgressUpdate(Integer ainteger[])
        {
            for (Iterator iterator = mObservers.iterator(); iterator.hasNext(); ((ApkAssetExpanderObserver)iterator.next()).onAssetExpansionProgress(ApkAssetExpander.this, ainteger[0].intValue(), ainteger[1].intValue())) { }
        }

        protected volatile void onProgressUpdate(Object aobj[])
        {
            onProgressUpdate((Integer[])aobj);
        }


        private InteralTaskType()
        {
            this$0 = ApkAssetExpander.this;
            super();
            mProgressPart = new _cls1();
        }

    }

    private final class InteralTaskType.ProgressPart
    {

        private int mMinProgress;
        private float mProgressRange;
        final InteralTaskType this$1;

        public final void publishProgress(float f)
        {
            int i = Math.round(mProgressRange * f);
            if (i >= 0 && mMinProgress + i <= 100)
            {
                InteralTaskType.this.publishProgress(new Integer[] {
                    Integer.valueOf(mMinProgress + i), Integer.valueOf(100)
                });
            }
        }

        public final void setPart(int i, int j)
        {
            mMinProgress = i;
            mProgressRange = j - i;
        }

        private InteralTaskType.ProgressPart()
        {
            this$1 = InteralTaskType.this;
            super();
        }

    }

    public static final class Result extends Enum
    {

        private static final Result $VALUES[];
        public static final Result FAIL_BADARG;
        public static final Result FAIL_BADREAD;
        public static final Result FAIL_BADWRITE;
        public static final Result FAIL_CANCELLED;
        public static final Result FAIL_CODEOPT;
        public static final Result FAIL_NATIVE_LIB_EXPANSION;
        public static final Result FAIL_RESOURCE_EXPANSION;
        public static final Result OK;
        public static final Result OK_NO_CHANGE;

        public static Result valueOf(String s)
        {
            return (Result)Enum.valueOf(com/amazon/client/framework/acf/module/ApkAssetExpander$Result, s);
        }

        public static Result[] values()
        {
            return (Result[])$VALUES.clone();
        }

        static 
        {
            OK = new Result("OK", 0);
            OK_NO_CHANGE = new Result("OK_NO_CHANGE", 1);
            FAIL_CANCELLED = new Result("FAIL_CANCELLED", 2);
            FAIL_BADREAD = new Result("FAIL_BADREAD", 3);
            FAIL_BADWRITE = new Result("FAIL_BADWRITE", 4);
            FAIL_RESOURCE_EXPANSION = new Result("FAIL_RESOURCE_EXPANSION", 5);
            FAIL_NATIVE_LIB_EXPANSION = new Result("FAIL_NATIVE_LIB_EXPANSION", 6);
            FAIL_CODEOPT = new Result("FAIL_CODEOPT", 7);
            FAIL_BADARG = new Result("FAIL_BADARG", 8);
            $VALUES = (new Result[] {
                OK, OK_NO_CHANGE, FAIL_CANCELLED, FAIL_BADREAD, FAIL_BADWRITE, FAIL_RESOURCE_EXPANSION, FAIL_NATIVE_LIB_EXPANSION, FAIL_CODEOPT, FAIL_BADARG
            });
        }

        private Result(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class VersionQueryResponse extends Enum
    {

        private static final VersionQueryResponse $VALUES[];
        public static final VersionQueryResponse ALWAYS_UPGRADE;
        public static final VersionQueryResponse DONT_UPGRADE;
        public static final VersionQueryResponse USE_DEFAULT_UPGRADE_LOGIC;

        public static VersionQueryResponse valueOf(String s)
        {
            return (VersionQueryResponse)Enum.valueOf(com/amazon/client/framework/acf/module/ApkAssetExpander$VersionQueryResponse, s);
        }

        public static VersionQueryResponse[] values()
        {
            return (VersionQueryResponse[])$VALUES.clone();
        }

        static 
        {
            USE_DEFAULT_UPGRADE_LOGIC = new VersionQueryResponse("USE_DEFAULT_UPGRADE_LOGIC", 0);
            DONT_UPGRADE = new VersionQueryResponse("DONT_UPGRADE", 1);
            ALWAYS_UPGRADE = new VersionQueryResponse("ALWAYS_UPGRADE", 2);
            $VALUES = (new VersionQueryResponse[] {
                USE_DEFAULT_UPGRADE_LOGIC, DONT_UPGRADE, ALWAYS_UPGRADE
            });
        }

        private VersionQueryResponse(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface VersioningAuthority
    {

        public abstract VersionQueryResponse queryUpgradeAction(AndroidManifest androidmanifest, AndroidManifest androidmanifest1);
    }


    public static final String DEFAULT_APP_DIR = "acf";
    private static final String NATIVE_LIB_SUBDIR_SUFFIX = "-libs";
    private static final String OPTIMIZED_CODE_SUFFIX = ".dex";
    private static final String PACKAGE_SUFFIX = ".apk";
    private static final int READ_BUFFER_BYTES = 8192;
    private static final String TAG = AcfLog.getTag(com/amazon/client/framework/acf/module/ApkAssetExpander);
    private static final String VERSION_COOKIE_SUFFIX = ".ver";
    private static final String ZIPFILE_NATIVE_LIB_PATH = "lib/";
    private static final Lock sInstallLock = new ReentrantLock(true);
    private static final AtomicInteger sInstallSeed = new AtomicInteger(1);
    private final WeakReference mCtx;
    private volatile Exception mError;
    private volatile PrivateApk mExpanded;
    private volatile File mExpandedDex;
    private final WeakRegistrar mObservers;
    private final boolean mPatchClassPath;
    private final ThreadLocal mReadBuffer;
    private final AsyncTask mTask;
    private final VersioningAuthority mVersioningAuthority;

    public ApkAssetExpander(Context context)
    {
        this(context, null, false);
    }

    public ApkAssetExpander(Context context, VersioningAuthority versioningauthority)
    {
        this(context, versioningauthority, false);
    }

    public ApkAssetExpander(Context context, VersioningAuthority versioningauthority, boolean flag)
    {
        boolean flag1;
        if (context != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Preconditions.checkArgument(flag1, "No context passed into constructor.");
        mPatchClassPath = flag;
        mVersioningAuthority = versioningauthority;
        mCtx = new WeakReference(context.getApplicationContext());
        mObservers = new WeakRegistrar();
        mReadBuffer = new ThreadLocal() {

            final ApkAssetExpander this$0;

            protected volatile Object initialValue()
            {
                return initialValue();
            }

            protected byte[] initialValue()
            {
                return new byte[8192];
            }

            
            {
                this$0 = ApkAssetExpander.this;
                super();
            }
        };
        mTask = new InteralTaskType();
    }

    public ApkAssetExpander(Context context, boolean flag)
    {
        this(context, null, flag);
    }

    private static void cleanup(Context context, String s, String s1)
    {
        s = context.getDir(s, 0);
        int j;
        int k;
        j = readVersionCookie(context, s, s1);
        Log.i(TAG, String.format("Cleaning up for version %d of package %s", new Object[] {
            Integer.valueOf(j), s1
        }));
        context = s.listFiles();
        k = context.length;
        int i = 0;
_L2:
        if (i >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        deleteIfNotValid(j, s1, context[i]);
        i++;
        if (true) goto _L2; else goto _L1
        context;
        Log.w(TAG, "IOException when trying to cleanup unused resources.", context);
_L1:
    }

    private static void deleteIfNotValid(int i, String s, File file)
    {
        String s1 = file.getName();
        if (s1.startsWith(s)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (!file.isDirectory())
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!s1.endsWith("-libs") || isValidVersion(i, "-libs".length(), s1)) goto _L1; else goto _L3
_L3:
        s = file.listFiles();
        int j = s.length;
        for (i = 0; i < j; i++)
        {
            s[i].delete();
        }

        Log.i(TAG, (new StringBuilder()).append("Deleting invalid directory: ").append(file.getAbsolutePath()).toString());
        file.delete();
        return;
        if ((!s1.endsWith(".apk") || isValidVersion(i, ".apk".length(), s1)) && (!s1.endsWith(".dex") || isValidVersion(i, ".dex".length(), s1))) goto _L1; else goto _L4
_L4:
        Log.i(TAG, (new StringBuilder()).append("Deleting invalid file: ").append(file.getAbsolutePath()).toString());
        file.delete();
        return;
    }

    private File doDexOpt(InteralTaskType.ProgressPart progresspart, Context context, File file)
        throws IOException
    {
        progresspart.publishProgress(0.1F);
        context = generateOptimizedCodePath(context, file);
        progresspart.publishProgress(0.25F);
        if (DexFile.isDexOptNeeded(file.getAbsolutePath()))
        {
            progresspart.publishProgress(0.5F);
            DexFile.loadDex(file.getAbsolutePath(), context.getAbsolutePath(), 0);
        }
        progresspart.publishProgress(1.0F);
        return context;
    }

    private Result doPrivateInstallApk(Context context, InteralTaskType.ProgressPart progresspart, String s, AndroidManifest androidmanifest, String s1)
    {
        String s2;
        Object obj;
        int i;
label0:
        {
            int k;
label1:
            {
                s1 = context.getDir(s1, 0);
                s2 = androidmanifest.getPackageName();
                File file;
                int j;
                try
                {
                    k = readVersionCookie(context, s1, s2);
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    mError = context;
                    return Result.FAIL_BADREAD;
                }
                if (k <= 0)
                {
                    i = sInstallSeed.getAndIncrement();
                } else
                {
                    do
                    {
                        j = sInstallSeed.getAndIncrement();
                        i = j;
                    } while (j == k);
                }
                obj = new StringBuffer(s2);
                ((StringBuffer) (obj)).append('-');
                if (k <= 0)
                {
                    break label0;
                }
                j = ((StringBuffer) (obj)).length();
                ((StringBuffer) (obj)).append(k);
                ((StringBuffer) (obj)).append(".apk");
                file = new File(s1, ((StringBuffer) (obj)).toString());
                ((StringBuffer) (obj)).setLength(j);
                try
                {
                    if (needsUpgrade(context, androidmanifest, file))
                    {
                        break label1;
                    }
                    mExpanded = new PrivateApk(androidmanifest, file.getParent(), file.getAbsolutePath(), generateOptimizedCodePath(context, file).getParentFile().getAbsolutePath(), generateLibsPath(context, file).getAbsolutePath());
                    context = Result.OK_NO_CHANGE;
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    mError = context;
                    return Result.FAIL_RESOURCE_EXPANSION;
                }
                return context;
            }
            Log.i(TAG, String.format("Existing embedded APK requires update: package = %s, version = %d", new Object[] {
                s2, Integer.valueOf(k)
            }));
        }
        ((StringBuffer) (obj)).append(i);
        ((StringBuffer) (obj)).append(".apk");
        File file1 = new File(s1, ((StringBuffer) (obj)).toString());
        if (mTask.isCancelled())
        {
            return Result.FAIL_CANCELLED;
        }
        Log.i(TAG, String.format("Expanding embedded APK %s: package = %s, version = %d", new Object[] {
            s, s2, Integer.valueOf(i)
        }));
        try
        {
            progresspart.setPart(1, 60);
            obj = expandAsset(progresspart, context, s, file1);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e(TAG, (new StringBuilder()).append("Failed to expand APK asset: ").append(s).toString());
            mError = context;
            return Result.FAIL_RESOURCE_EXPANSION;
        }
        if (mTask.isCancelled())
        {
            return Result.FAIL_CANCELLED;
        }
        s = generateLibsPath(context, file1);
        try
        {
            progresspart.setPart(61, 90);
            extractNativeLibs(progresspart, context, ((File) (obj)), s);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            mError = context;
            return Result.FAIL_NATIVE_LIB_EXPANSION;
        }
        if (mTask.isCancelled())
        {
            return Result.FAIL_CANCELLED;
        }
        progresspart.setPart(91, 100);
        try
        {
            progresspart = doDexOpt(progresspart, context, ((File) (obj))).getParentFile();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            mError = context;
            return Result.FAIL_CODEOPT;
        }
        if (mTask.isCancelled())
        {
            return Result.FAIL_CANCELLED;
        }
        try
        {
            writeVersionCookie(context, s1, s2, i);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            mError = context;
            return Result.FAIL_BADWRITE;
        }
        mExpanded = new PrivateApk(androidmanifest, ((File) (obj)).getParent(), ((File) (obj)).getAbsolutePath(), progresspart.getAbsolutePath(), s.getAbsolutePath());
        return Result.OK;
    }

    private Result doPrivateInstallDex(Context context, InteralTaskType.ProgressPart progresspart, String s, String s1)
    {
        String as[] = s.split(File.separator);
        String s2 = as[as.length - 1].replace(".dex", "");
        s1 = context.getDir(s1, 0);
        Object obj;
        int i;
        int l;
        try
        {
            l = readVersionCookie(context, s1, s2);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            mError = context;
            return Result.FAIL_BADREAD;
        }
        int k;
        if (l <= 0)
        {
            i = sInstallSeed.getAndIncrement();
        } else
        {
            do
            {
                k = sInstallSeed.getAndIncrement();
                i = k;
            } while (k == l);
        }
        obj = new StringBuffer(s2);
        ((StringBuffer) (obj)).append('-');
        if (l > 0)
        {
            int j = ((StringBuffer) (obj)).length();
            ((StringBuffer) (obj)).append(l);
            ((StringBuffer) (obj)).append(".dex");
            File file = new File(s1, ((StringBuffer) (obj)).toString());
            ((StringBuffer) (obj)).setLength(j);
            if (!needsUpgradeDex(context, s2, file))
            {
                mExpandedDex = file;
                return Result.OK_NO_CHANGE;
            }
        }
        ((StringBuffer) (obj)).append(i);
        ((StringBuffer) (obj)).append(".dex");
        obj = new File(s1, ((StringBuffer) (obj)).toString());
        if (mTask.isCancelled())
        {
            return Result.FAIL_CANCELLED;
        }
        try
        {
            progresspart.setPart(1, 60);
            mExpandedDex = expandDex(progresspart, context, ((File) (obj)), s);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            mError = context;
            return Result.FAIL_RESOURCE_EXPANSION;
        }
        if (mTask.isCancelled())
        {
            return Result.FAIL_CANCELLED;
        }
        try
        {
            writeVersionCookie(context, s1, s2, i);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            mError = context;
            return Result.FAIL_BADWRITE;
        }
        return Result.OK;
    }

    private File expandAsset(InteralTaskType.ProgressPart progresspart, Context context, String s, File file)
        throws IOException
    {
        FileOutputStream fileoutputstream;
        byte abyte0[];
        abyte0 = (byte[])mReadBuffer.get();
        fileoutputstream = new FileOutputStream(file);
        long l;
        context = context.getAssets().openFd(s);
        l = tryGetAssetSizeBytes(context);
        float f;
        float f1;
        f1 = l;
        f = 0.0F;
        s = context.createInputStream();
_L2:
        int i = s.read(abyte0, 0, 8192);
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        if (mTask.isCancelled())
        {
            break MISSING_BLOCK_LABEL_138;
        }
        fileoutputstream.write(abyte0, 0, i);
        if (f1 <= 0.0F) goto _L2; else goto _L1
_L1:
        f += i;
        progresspart.publishProgress(f / f1);
          goto _L2
        progresspart;
        s.close();
        throw progresspart;
        progresspart;
        context.close();
        throw progresspart;
        progresspart;
        fileoutputstream.close();
        throw progresspart;
        s.close();
        context.close();
        fileoutputstream.close();
        return file;
    }

    private File expandDex(InteralTaskType.ProgressPart progresspart, Context context, File file, String s)
        throws IOException
    {
        progresspart = new File(context.getDir(file.getName(), 0), file.getName());
        context = new BufferedInputStream(context.getAssets().open(s));
        file = new BufferedOutputStream(new FileOutputStream(progresspart));
        s = new byte[8192];
_L3:
        int i = context.read(s, 0, 8192);
        if (i <= 0) goto _L2; else goto _L1
_L1:
        file.write(s, 0, i);
          goto _L3
        progresspart;
        file.close();
        throw progresspart;
        progresspart;
_L5:
        context.close();
        throw progresspart;
_L2:
        file.close();
        context.close();
        return progresspart;
        progresspart;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void extractNativeLib(InteralTaskType.ProgressPart progresspart, Context context, ZipFile zipfile, ZipEntry zipentry, File file)
        throws IOException
    {
        context = (byte[])mReadBuffer.get();
        String s = zipentry.getName();
        int i = s.lastIndexOf('/');
        if (-1 == i)
        {
            throw new IOException("Unexpected library path provided to method.");
        }
        file = new File(file, s.substring(i));
        if (!file.exists())
        {
            file.getParentFile().mkdirs();
        }
        zipfile = zipfile.getInputStream(zipentry);
        float f1 = zipentry.getSize();
        float f = 0.0F;
        zipentry = new FileOutputStream(file);
_L2:
        int j = zipfile.read(context, 0, 8192);
        if (j <= 0)
        {
            break MISSING_BLOCK_LABEL_185;
        }
        if (mTask.isCancelled())
        {
            break MISSING_BLOCK_LABEL_185;
        }
        zipentry.write(context, 0, j);
        if (f1 <= 0.0F) goto _L2; else goto _L1
_L1:
        f += j;
        progresspart.publishProgress(f / f1);
          goto _L2
        progresspart;
        zipentry.close();
        throw progresspart;
        progresspart;
        zipfile.close();
        throw progresspart;
        zipentry.close();
        zipfile.close();
        return;
    }

    private boolean extractNativeLibs(InteralTaskType.ProgressPart progresspart, Context context, File file, File file1)
        throws IOException
    {
        boolean flag;
        file = new ZipFile(file);
        flag = false;
        String as[];
        int j;
        as = supportedAbis();
        j = as.length;
        int i = 0;
          goto _L1
_L6:
        Enumeration enumeration;
        String s;
        enumeration = file.entries();
        s = (new StringBuilder()).append("lib/").append(s).append("/").toString();
_L2:
        ZipEntry zipentry;
        do
        {
            if (!enumeration.hasMoreElements())
            {
                break MISSING_BLOCK_LABEL_121;
            }
            zipentry = (ZipEntry)enumeration.nextElement();
        } while (!zipentry.getName().startsWith(s));
        flag = true;
        extractNativeLib(progresspart, context, file, zipentry, file1);
          goto _L2
        progresspart;
        file.close();
        throw progresspart;
        boolean flag1;
        flag1 = flag;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_169;
        }
_L4:
        file.close();
        return false || false;
_L1:
        if (i >= j) goto _L4; else goto _L3
_L3:
        if ((s = as[i]) != null) goto _L6; else goto _L5
_L5:
        flag1 = flag;
        i++;
        flag = flag1;
          goto _L1
    }

    static File generateLibsPath(Context context, File file)
    {
        context = file.getName();
        int i = context.lastIndexOf('.');
        if (i < 0)
        {
            context = (new StringBuilder()).append(context).append("-libs").toString();
        } else
        {
            context = (new StringBuilder()).append(context.substring(0, i)).append("-libs").toString();
        }
        return new File(file.getParent(), context);
    }

    static File generateOptimizedCodePath(Context context, File file)
    {
        context = file.getName();
        int i = context.lastIndexOf('.');
        if (i < 0)
        {
            context = (new StringBuilder()).append(context).append(".dex").toString();
        } else
        {
            context = (new StringBuilder()).append(context.substring(0, i)).append(".dex").toString();
        }
        return new File(file.getParent(), context);
    }

    private static File getVersionCookie(Context context, File file, String s)
    {
        return new File(file, (new StringBuilder()).append(s).append(".ver").toString());
    }

    public static boolean isOk(Result result)
    {
        static class _cls2
        {

            static final int $SwitchMap$com$amazon$client$framework$acf$module$ApkAssetExpander$Result[];
            static final int $SwitchMap$com$amazon$client$framework$acf$module$ApkAssetExpander$VersionQueryResponse[];

            static 
            {
                $SwitchMap$com$amazon$client$framework$acf$module$ApkAssetExpander$VersionQueryResponse = new int[VersionQueryResponse.values().length];
                try
                {
                    $SwitchMap$com$amazon$client$framework$acf$module$ApkAssetExpander$VersionQueryResponse[VersionQueryResponse.ALWAYS_UPGRADE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$client$framework$acf$module$ApkAssetExpander$VersionQueryResponse[VersionQueryResponse.DONT_UPGRADE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                $SwitchMap$com$amazon$client$framework$acf$module$ApkAssetExpander$Result = new int[Result.values().length];
                try
                {
                    $SwitchMap$com$amazon$client$framework$acf$module$ApkAssetExpander$Result[Result.OK.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$client$framework$acf$module$ApkAssetExpander$Result[Result.OK_NO_CHANGE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls2..SwitchMap.com.amazon.client.framework.acf.module.ApkAssetExpander.Result[result.ordinal()])
        {
        default:
            return false;

        case 1: // '\001'
        case 2: // '\002'
            return true;
        }
    }

    private static boolean isValidVersion(int i, int j, String s)
    {
        j = s.length() - (j + 1);
        return i == Integer.parseInt(s.substring(j, j + 1));
    }

    private boolean needsUpgrade(Context context, AndroidManifest androidmanifest, File file)
        throws IOException
    {
        if (file.exists()) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        context = BinaryParser.parseManifest(file);
        if (mVersioningAuthority == null) goto _L4; else goto _L3
_L3:
        _cls2..SwitchMap.com.amazon.client.framework.acf.module.ApkAssetExpander.VersionQueryResponse[mVersioningAuthority.queryUpgradeAction(androidmanifest, context).ordinal()];
        JVM INSTR tableswitch 1 2: default 60
    //                   1 7
    //                   2 75;
           goto _L4 _L5 _L6
_L5:
        continue; /* Loop/switch isn't completed */
_L4:
        if (context.getVersionCodeOrDefault(0) >= androidmanifest.getVersionCodeOrDefault(0))
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        return false;
        if (true) goto _L1; else goto _L7
_L7:
    }

    private boolean needsUpgradeDex(Context context, String s, File file)
    {
        if (file.exists());
        return true;
    }

    static int readVersionCookie(Context context, File file, String s)
        throws IOException
    {
        int i;
        context = getVersionCookie(context, file, s);
        i = -1;
        if (!context.exists())
        {
            break MISSING_BLOCK_LABEL_71;
        }
        context = new FileInputStream(context);
        file = ByteBuffer.allocate(4);
        s = file.array();
        i = 0;
_L2:
        int j = context.read(s, i, s.length - i);
        if (j <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        i += j;
        if (true) goto _L2; else goto _L1
_L1:
        i = file.getInt();
        context.close();
        return i;
        file;
        context.close();
        throw file;
    }

    private static String[] supportedAbis()
    {
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            return supportedAbis21();
        } else
        {
            return (new String[] {
                Build.CPU_ABI, Build.CPU_ABI2
            });
        }
    }

    private static String[] supportedAbis21()
    {
        return Build.SUPPORTED_ABIS;
    }

    private long tryGetAssetSizeBytes(AssetFileDescriptor assetfiledescriptor)
        throws IOException
    {
        ParcelFileDescriptor parcelfiledescriptor;
        long l;
        long l1;
        l1 = assetfiledescriptor.getDeclaredLength();
        l = l1;
        if (l1 == -1L)
        {
            l = assetfiledescriptor.getLength();
        }
        l1 = l;
        if (l != -1L)
        {
            break MISSING_BLOCK_LABEL_71;
        }
        parcelfiledescriptor = assetfiledescriptor.getParcelFileDescriptor();
        l1 = parcelfiledescriptor.getStatSize();
        if (-1L == l1)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        l = assetfiledescriptor.getStartOffset();
        l = l1 - l;
        parcelfiledescriptor.close();
        l1 = l;
        return l1;
        assetfiledescriptor;
        parcelfiledescriptor.close();
        throw assetfiledescriptor;
    }

    private static void writeVersionCookie(Context context, File file, String s, int i)
        throws IOException
    {
        file = getVersionCookie(context, file, s);
        context = ByteBuffer.allocate(4).putInt(i);
        file = new FileOutputStream(file);
        file.write(context.array());
        file.close();
        return;
        context;
        file.close();
        throw context;
    }

    public void addApkAssetExpanderObserver(ApkAssetExpanderObserver apkassetexpanderobserver)
    {
        mObservers.add(apkassetexpanderobserver);
    }

    public void cancel()
    {
        mTask.cancel(true);
    }

    public final void expandAsset(String s)
    {
        expandAsset(s, "acf");
    }

    public final void expandAsset(String s, String s1)
    {
        expandAssetOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, s, s1);
    }

    public final void expandAssetOnExecutor(Executor executor, String s)
    {
        expandAssetOnExecutor(executor, s, "acf");
    }

    public final void expandAssetOnExecutor(Executor executor, String s, String s1)
    {
        boolean flag;
        if (s != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "No asset name provided to method.");
        if (s1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "No app directory name provided to method.");
        mTask.executeOnExecutor(executor, new String[] {
            s, s1
        });
    }

    public Result get()
        throws InterruptedException, ExecutionException
    {
        return (Result)mTask.get();
    }

    public Result get(long l, TimeUnit timeunit)
        throws InterruptedException, ExecutionException, TimeoutException
    {
        return (Result)mTask.get(l, timeunit);
    }

    public Context getContext()
    {
        return (Context)mCtx.get();
    }

    public Exception getError()
    {
        return mError;
    }

    public PrivateApk getExpanded()
        throws InterruptedException, ExecutionException
    {
        get();
        return mExpanded;
    }

    public PrivateApk getExpanded(long l, TimeUnit timeunit)
        throws InterruptedException, ExecutionException, TimeoutException
    {
        get(l, timeunit);
        return mExpanded;
    }

    public android.os.AsyncTask.Status getStatus()
    {
        return mTask.getStatus();
    }

    public void removeApkAssetExpanderObserver(ApkAssetExpanderObserver apkassetexpanderobserver)
    {
        mObservers.remove(apkassetexpanderobserver);
    }











/*
    static Exception access$502(ApkAssetExpander apkassetexpander, Exception exception)
    {
        apkassetexpander.mError = exception;
        return exception;
    }

*/





    // Unreferenced inner class com/amazon/client/framework/acf/module/ApkAssetExpander$InteralTaskType$1

/* anonymous class */
    class InteralTaskType._cls1 extends ThreadLocal
    {

        final InteralTaskType this$1;
        final ApkAssetExpander val$this$0;

        protected InteralTaskType.ProgressPart initialValue()
        {
            return new InteralTaskType.ProgressPart();
        }

        protected volatile Object initialValue()
        {
            return initialValue();
        }

            
            {
                this$1 = final_interaltasktype;
                this$0 = ApkAssetExpander.this;
                super();
            }
    }

}
