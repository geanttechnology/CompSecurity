// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.precache;

import android.os.Handler;
import android.os.Message;
import com.supersonicads.sdk.data.SSAFile;
import com.supersonicads.sdk.utils.SDKUtils;
import com.supersonicads.sdk.utils.SupersonicSharedPrefHelper;
import com.supersonicads.sdk.utils.SupersonicStorageUtils;
import java.util.List;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.supersonicads.sdk.precache:
//            DownloadManager

private class tries
    implements Runnable
{

    private long mConnectionRetries;
    private String mFile;
    private String mFileName;
    private String mFolderName;
    private String mPath;
    final DownloadManager this$0;

    public void run()
    {
        Object obj;
        Message message;
        ExecutorService executorservice;
        Object obj1;
        int i;
        obj = new SSAFile(mFileName, mPath);
        message = new Message();
        message.obj = obj;
        if (mFolderName == null)
        {
            message.what = 1017;
            ((SSAFile) (obj)).setErrMsg("unable_to_create_folder");
            DownloadManager.access$100(DownloadManager.this).sendMessage(message);
            return;
        }
        executorservice = Executors.newFixedThreadPool(1);
        obj1 = new ExecutorCompletionService(executorservice);
        ((CompletionService) (obj1)).submit(new (DownloadManager.this, mFile, mFolderName, mFileName, mConnectionRetries, mPath));
        i = 0;
        int j;
        obj1 = (List)((CompletionService) (obj1)).take().get();
        String s = (String)((List) (obj1)).get(0);
        j = ((Integer)((List) (obj1)).get(1)).intValue();
        i = j;
_L1:
        executorservice.shutdown();
        Object obj2;
        try
        {
            executorservice.awaitTermination(0x7fffffffffffffffL, TimeUnit.NANOSECONDS);
        }
        catch (InterruptedException interruptedexception) { }
        switch (i)
        {
        default:
            return;

        case 200: 
            message.what = 1016;
            DownloadManager.access$100(DownloadManager.this).sendMessage(message);
            return;

        case 404: 
        case 1004: 
        case 1005: 
        case 1006: 
        case 1010: 
        case 1011: 
        case 1018: 
            message.what = 1017;
            ((SSAFile) (obj)).setErrMsg("file not found exception");
            DownloadManager.access$100(DownloadManager.this).sendMessage(message);
            executorservice.shutdownNow();
            return;

        case 1008: 
        case 1009: 
            message.what = 1017;
            break;
        }
        break MISSING_BLOCK_LABEL_366;
        obj2;
        Thread.currentThread().interrupt();
          goto _L1
        obj;
        throw obj;
        obj2;
        Thread.currentThread().interrupt();
          goto _L1
        ((SSAFile) (obj)).setErrMsg("io exception");
        DownloadManager.access$100(DownloadManager.this).sendMessage(message);
        executorservice.shutdownNow();
        return;
    }

    public (SSAFile ssafile)
    {
        this$0 = DownloadManager.this;
        super();
        mFile = ssafile.getFile();
        mPath = ssafile.getPath();
        mFileName = SDKUtils.getFileName(mFile);
        mFolderName = SupersonicStorageUtils.makeDir(DownloadManager.access$000(DownloadManager.this), mPath);
        mConnectionRetries = Long.parseLong(SupersonicSharedPrefHelper.getSupersonicPrefHelper().getConnectionRetries());
    }
}
