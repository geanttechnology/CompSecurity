// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.moodstocks.android;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import com.moodstocks.android.advanced.Image;
import com.moodstocks.android.advanced.Synchronizer;
import com.moodstocks.android.core.Loader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.moodstocks.android:
//            MoodstocksError, Result

public final class Scanner
{
    public final class SearchOption
    {

        public static final int DEFAULT = 0;
        public static final int NOPARTIAL = 1;
        public static final int SMALLTARGET = 2;
        final Scanner this$0;

        public SearchOption()
        {
            this$0 = Scanner.this;
            super();
        }
    }

    public static interface SyncListener
    {

        public abstract void onSyncComplete();

        public abstract void onSyncFailed(MoodstocksError moodstockserror);

        public abstract void onSyncProgress(int i, int j);

        public abstract void onSyncStart();
    }


    private static Scanner instance;
    private final long ptr = 0L;
    private SyncListener syncListener;
    private final ExecutorService syncThread = Executors.newSingleThreadExecutor();
    private Synchronizer synchronizer;

    private Scanner()
    {
        synchronizer = null;
        syncListener = null;
        initialize();
    }

    private native void close_native();

    private static void copyAssetFile(InputStream inputstream, OutputStream outputstream)
    {
        byte abyte0[] = new byte[1024];
_L1:
        int i = inputstream.read(abyte0);
label0:
        {
            if (i == -1)
            {
                break label0;
            }
            try
            {
                outputstream.write(abyte0, 0, i);
            }
            // Misplaced declaration of an exception variable
            catch (InputStream inputstream)
            {
                return;
            }
        }
          goto _L1
        inputstream.close();
        outputstream.flush();
        outputstream.close();
        return;
    }

    private native void destruct();

    public static Scanner get()
    {
        if (instance != null) goto _L2; else goto _L1
_L1:
        com/moodstocks/android/Scanner;
        JVM INSTR monitorenter ;
        if (instance == null)
        {
            instance = new Scanner();
        }
        com/moodstocks/android/Scanner;
        JVM INSTR monitorexit ;
_L2:
        return instance;
        Exception exception;
        exception;
        com/moodstocks/android/Scanner;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private native void importBundle_native(String s);

    private static native void init();

    private native void initialize();

    public static boolean isCompatible()
    {
        return Loader.isCompatible();
    }

    private native void open_native(String s, String s1, String s2);

    public static String pathFromFilesDir(Context context, String s)
    {
        return (new StringBuilder()).append(context.getFilesDir().getAbsolutePath()).append("/").append(s).toString();
    }

    public final void cancelSync()
    {
        if (synchronizer != null)
        {
            synchronizer.cancel();
        }
    }

    public final void close()
    {
        close_native();
    }

    public final native int count();

    public final native Result decode(Image image, int i, int j);

    public final void destroy()
    {
        destruct();
        instance = null;
    }

    public final void importBundle(Context context, String s, String s1)
    {
        String s3 = (new StringBuilder()).append(s1).append("/data/").append(s).append("/default").toString();
        s = (new StringBuilder()).append(s3).append("/bundles").toString();
        String s4 = (new StringBuilder()).append(context.getCacheDir()).append("/").append(s3).toString();
        String s2 = (new StringBuilder()).append(s4).append("/bundles").toString();
        Object obj = new File(s4);
        if (!((File) (obj)).exists())
        {
            ((File) (obj)).mkdirs();
        }
        obj = new File(s2);
        if (!((File) (obj)).exists())
        {
            ((File) (obj)).mkdirs();
        }
        obj = context.getAssets();
        copyAssetFile(((AssetManager) (obj)).open((new StringBuilder()).append(s3).append("/syncstate").toString()), new FileOutputStream((new StringBuilder()).append(s4).append("/syncstate").toString()));
        String as[] = ((AssetManager) (obj)).list(s);
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s5 = as[i];
            copyAssetFile(((AssetManager) (obj)).open((new StringBuilder()).append(s).append("/").append(s5).toString()), new FileOutputStream((new StringBuilder()).append(s2).append("/").append(s5).toString()));
        }

        importBundle_native((new StringBuilder()).append(context.getCacheDir()).append("/").append(s1).toString());
    }

    public final native List info();

    public final boolean isSyncing()
    {
        return syncListener != null;
    }

    public final native Result match(Image image, Result result, int i, int j);

    public final void open(String s, String s1, String s2)
    {
        if (!isCompatible())
        {
            throw new RuntimeException("DEVICE IS NOT COMPATIBLE WITH MOODSTOCKS SDK");
        }
        try
        {
            open_native(s, s1, s2);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        if (s.getErrorCode() == 12)
        {
            Log.e("Moodstocks SDK", "Warning: There is a problem with your API key/secret pair.\nYou have already opened the scanner with a different pair. To solve this issue:\n1/ Uninstall the application from your device or clear its data,\n2/ Make sure you have properly set your API key/secret pair,\n3/ Re-build and run.");
        }
        throw s;
    }

    public final native Result search(Image image, int i, int j);

    public final native void setAuthenticatedProxy(String s, int i, String s1, String s2);

    public final void setProxy(String s, int i)
    {
        setAuthenticatedProxy(s, i, null, null);
    }

    public final void setSyncListener(SyncListener synclistener)
    {
        syncListener = synclistener;
        if (synchronizer != null)
        {
            synchronizer.setListener(synclistener);
        }
    }

    public final native void setSyncProxy(String s);

    public final boolean sync()
    {
        if (synchronizer != null)
        {
            return false;
        } else
        {
            synchronizer = new Synchronizer(this);
            synchronizer.setListener(syncListener);
            Runnable runnable = new Runnable() {

                final Scanner this$0;

                public void run()
                {
                    synchronizer.synchronize();
                    synchronizer = null;
                }

            
            {
                this$0 = Scanner.this;
                super();
            }
            };
            syncThread.submit(runnable);
            return true;
        }
    }

    static 
    {
        Loader.load();
        if (isCompatible())
        {
            init();
        }
    }



/*
    static Synchronizer access$002(Scanner scanner, Synchronizer synchronizer1)
    {
        scanner.synchronizer = synchronizer1;
        return synchronizer1;
    }

*/
}
