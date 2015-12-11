// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.download;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.penthera.virtuososdk.client.IVirtuosoAsset;
import com.penthera.virtuososdk.interfaces.toolkit.VirtuosoContentBox;
import com.penthera.virtuososdk.internal.interfaces.IEngFileFragment;
import com.penthera.virtuososdk.internal.interfaces.IEngVFile;
import com.penthera.virtuososdk.internal.interfaces.IEngVHLSFile;
import com.penthera.virtuososdk.internal.interfaces.IEngVIdentifier;
import com.penthera.virtuososdk.utility.CommonUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

// Referenced classes of package com.penthera.virtuososdk.download:
//            Downloader, VirtuosoDownloadEngineStatus, MD5

private class iFile extends Thread
{
    private class HlsDownload
    {

        private volatile boolean mAbort;
        private int mActiveWorkers;
        private HttpClient mClient;
        private int mConnectionType;
        private String mEventBearerType;
        private IEngVHLSFile mFile;
        private List mFragments;
        private Object mHlsWorkerLock;
        private volatile int mIndex;
        final Downloader.VirtuosoDownloadThread this$1;

        private int MAX()
        {
            return 3;
        }

        private com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion download(IEngFileFragment iengfilefragment)
        {
            int i;
            com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion efiledownloadcompletion = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadComplete;
            i = 0;
            if (TextUtils.isEmpty(iengfilefragment.filePath()))
            {
                iengfilefragment.generateFilePath();
            }
            iengfilefragment.setDownloadStatus(com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Downloading);
            mFile.updateFragment(CommonUtil.getApplicationContext(), iengfilefragment);
_L10:
            boolean flag;
            if (i != 0)
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.w(Downloader.access$0(), (new StringBuilder("tryDownloadItem(): Network failure -- trying again for fragment: ")).append(iengfilefragment.remotePath()).toString());
                com.penthera.virtuososdk.utility.CommonUtil.Log.w(Downloader.access$0(), (new StringBuilder("tryDownloadItem(): bytes read on the previous attempt: ")).append(iDownloadInfo.iLastBytesRead).toString());
            }
            iDownloadInfo.iLastBytesRead = 0L;
            flag = false;
            Object obj1 = downloadFragment(iengfilefragment, mConnectionType, mEventBearerType, mClient);
            if (com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EInternalErrorRetryOn416 != obj1) goto _L2; else goto _L1
_L1:
            Object obj = downloadFragment(iengfilefragment, mConnectionType, mEventBearerType, mClient);
_L4:
            iDownloadInfo.iDownloadExceptions = 0;
            i = ((flag) ? 1 : 0);
_L8:
            if (iDownloadInfo.iDownloadExceptions < 3)
            {
                continue; /* Loop/switch isn't completed */
            }
            com.penthera.virtuososdk.utility.CommonUtil.Log.e(Downloader.access$0(), (new StringBuilder("c[ ")).append(iClientAuthority).append("] No internet connection: connection not usable").toString());
            iengfilefragment.setDownloadStatus(completionToState(((com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion) (obj))));
            mFile.updateFragment(CommonUtil.getApplicationContext(), iengfilefragment);
            obj1 = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorsMaxed;
_L11:
            return ((com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion) (obj1));
_L2:
            if (com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorFileExpectedSize == obj1 || com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorFileMimeType == obj1)
            {
                break; /* Loop/switch isn't completed */
            }
            obj = obj1;
            if (com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorHTTP != obj1) goto _L4; else goto _L3
_L7:
            if (com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorFileExpectedSize == obj1 || com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorFileMimeType == obj1)
            {
                break; /* Loop/switch isn't completed */
            }
            obj = obj1;
            if (com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorHTTP != obj1) goto _L4; else goto _L5
_L5:
            obj = obj1;
            if (i >= 3) goto _L4; else goto _L6
_L6:
            obj1 = downloadFragment(iengfilefragment, mConnectionType, mEventBearerType, mClient);
            i++;
              goto _L7
            obj;
            com.penthera.virtuososdk.utility.CommonUtil.Log.w(Downloader.access$0(), (new StringBuilder("tryDownloadItem(): Network unavaialble -- Received unknown host excpetion: ")).append(((UnknownHostException) (obj)).getMessage()).toString());
            obj = iDownloadInfo;
            obj.iDownloadExceptions = ((Downloader.DownloadInfo) (obj)).iDownloadExceptions + 1;
            com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.sendBroadcast("virtuoso.intent.action.UNKNOWN_HOST");
            obj = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorNetwork;
            i = 1;
              goto _L8
            obj;
            com.penthera.virtuososdk.utility.CommonUtil.Log.w(Downloader.access$0(), (new StringBuilder("tryDownloadItem(): Network problem -- Received a network error: ")).append(((Exception) (obj)).getMessage()).toString());
            obj = iDownloadInfo;
            obj.iDownloadExceptions = ((Downloader.DownloadInfo) (obj)).iDownloadExceptions + 1;
            obj = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorNetwork;
            i = 1;
              goto _L8
            obj;
            com.penthera.virtuososdk.utility.CommonUtil.Log.w(Downloader.access$0(), (new StringBuilder("tryDownloadItem(): Network problem -- unknown error: ")).append(((Throwable) (obj)).getMessage()).toString());
            obj = iDownloadInfo;
            obj.iDownloadExceptions = ((Downloader.DownloadInfo) (obj)).iDownloadExceptions + 1;
            obj = com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadBlockedErrorNetwork;
            i = 1;
              goto _L8
            if (i != 0 && iDownloadInfo.iLastBytesRead > 0L) goto _L10; else goto _L9
_L9:
            if (obj == com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadComplete)
            {
                iengfilefragment.markComplete();
            } else
            {
                iengfilefragment.setDownloadStatus(completionToState(((com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion) (obj))));
            }
            if (iengfilefragment.downloadStatus() == com.penthera.virtuososdk.Common.EFileDownloadStatus.kVDE_Download_File_Copy_Error && iengfilefragment.currentSize() <= 0.0D)
            {
                iengfilefragment.setFilePath(null);
            }
            mFile.updateFragment(CommonUtil.getApplicationContext(), iengfilefragment);
            obj1 = obj;
            if (obj == com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadComplete)
            {
                reportFragmentComplete(mFile, iengfilefragment);
                return ((com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion) (obj));
            }
              goto _L11
_L3:
            i = 1;
              goto _L7
        }

        public void begin()
        {
            Downloader.access$1(this$0, com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadComplete);
            mActiveWorkers = 0;
            int j = MAX();
            int i = 0;
            do
            {
                if (i >= j)
                {
                    return;
                }
                mActiveWorkers = mActiveWorkers + 1;
                (new Thread(new Runnable() {

                    final HlsDownload this$2;

                    public void run()
                    {
_L5:
                        obj = getNext();
                        if (obj == null) goto _L2; else goto _L1
_L1:
                        boolean flag = mAbort;
                        if (!flag) goto _L3; else goto _L2
_L2:
                        obj = HlsDownload.this;
                        obj.mActiveWorkers = ((HlsDownload) (obj)).mActiveWorkers - 1;
                        if (mActiveWorkers <= 0 && !mAbort)
                        {
                            synchronized (mHlsLock)
                            {
                                mHlsLock.notify();
                            }
                        }
                        return;
_L3:
                        obj = download(((IEngFileFragment) (obj)));
                        obj1 = mHlsWorkerLock;
                        obj1;
                        JVM INSTR monitorenter ;
                        if (killed)
                        {
                            obj = killCode;
                        }
                        if (!mAbort)
                        {
                            Downloader.access$1(this$0, ((com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion) (obj)));
                        }
                        if (obj == com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadComplete)
                        {
                            break MISSING_BLOCK_LABEL_298;
                        }
                        mAbort = true;
                        mClient.getConnectionManager().shutdown();
                        synchronized (mHlsLock)
                        {
                            mHlsLock.notify();
                        }
                        obj1;
                        JVM INSTR monitorexit ;
                          goto _L2
                        obj;
                        obj1;
                        JVM INSTR monitorexit ;
                        throw obj;
                        obj;
                        obj1 = HlsDownload.this;
                        obj1.mActiveWorkers = ((HlsDownload) (obj1)).mActiveWorkers - 1;
                        if (mActiveWorkers <= 0 && !mAbort)
                        {
                            synchronized (mHlsLock)
                            {
                                mHlsLoc