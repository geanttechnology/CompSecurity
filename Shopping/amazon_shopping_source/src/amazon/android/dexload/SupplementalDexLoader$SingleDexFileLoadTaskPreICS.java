// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.android.dexload;

import android.content.Context;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.zip.ZipFile;

// Referenced classes of package amazon.android.dexload:
//            SupplementalDexLoader

private static class mLoadingLatch
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
            SupplementalDexLoader.access$000(mIndex, mFileName, mNewPaths, mNewFiles, mNewZips, mNewDexs, mContext);
        }
        catch (IOException ioexception) { }
        mLoadingLatch.countDown();
    }

    public (int i, String s, String as[], File afile[], ZipFile azipfile[], DexFile adexfile[], Context context, 
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
