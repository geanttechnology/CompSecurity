// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.precache;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.supersonicads.sdk.data.SSAFile;
import com.supersonicads.sdk.utils.Logger;
import com.supersonicads.sdk.utils.SDKUtils;
import com.supersonicads.sdk.utils.SupersonicSharedPrefHelper;
import com.supersonicads.sdk.utils.SupersonicStorageUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class DownloadManager
{
    public class FileWorkerThread
        implements Callable
    {

        private long mConnectionRetries;
        private String mDirectory;
        private String mFile;
        private String mFolderName;
        private String mLink;
        final DownloadManager this$0;

        public volatile Object call()
            throws Exception
        {
            return call();
        }

        public List call()
        {
            List list = null;
            if (mConnectionRetries == 0L)
            {
                mConnectionRetries = 1L;
            }
            for (int i = 0; (long)i < mConnectionRetries; i++)
            {
                new ArrayList();
                list = downloadContent(mLink, mDirectory, mFile, mFolderName, i);
                int j = ((Integer)list.get(1)).intValue();
                if (j != 1008 && j != 1009)
                {
                    return list;
                }
            }

            return list;
        }

        public FileWorkerThread(String s, String s1, String s2, long l, String s3)
        {
            this$0 = DownloadManager.this;
            super();
            mLink = s;
            mDirectory = s1;
            mFile = s2;
            mConnectionRetries = l;
            mFolderName = s3;
        }
    }

    public static interface OnPreCacheCompletion
    {

        public abstract void onFileDownloadFail(SSAFile ssafile);

        public abstract void onFileDownloadSuccess(SSAFile ssafile);
    }

    private class SingleFileWorkerThread
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
                downloadHandler.sendMessage(message);
                return;
            }
            executorservice = Executors.newFixedThreadPool(1);
            obj1 = new ExecutorCompletionService(executorservice);
            ((CompletionService) (obj1)).submit(new FileWorkerThread(mFile, mFolderName, mFileName, mConnectionRetries, mPath));
            i = 0;
            int j;
            obj1 = (List)((CompletionService) (obj1)).take().get();
            String s = (String)((List) (obj1)).get(0);
            j = ((Integer)((List) (obj