// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.download;

import android.text.TextUtils;
import com.penthera.virtuososdk.internal.interfaces.IEngFileFragment;
import com.penthera.virtuososdk.internal.interfaces.IEngVHLSFile;
import com.penthera.virtuososdk.utility.CommonUtil;
import java.net.UnknownHostException;
import java.util.List;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;

// Referenced classes of package com.penthera.virtuososdk.download:
//            Downloader

private class mFragments
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
    final mIndex this$1;

    private int MAX()
    {
        return 3;
    }

    private com.penthera.virtuososdk.utility. download(IEngFileFragment iengfilefragment)
    {
        int i;
        com.penthera.virtuososdk.utility.  = com.penthera.virtuososdk.utility.mplete;
        i = 0;
        if (TextUtils.isEmpty(iengfilefragment.filePath()))
        {
            iengfilefragment.generateFilePath();
        }
        iengfilefragment.setDownloadStatus(com.penthera.virtuososdk.adStatus);
        mFile.updateFragment(CommonUtil.getApplicationContext(), iengfilefragment);
_L10:
        boolean flag;
        if (i != 0)
        {
            com.penthera.virtuososdk.utility..mFile(Downloader.access$0(), (new StringBuilder("tryDownloadItem(): Network failure -- trying again for fragment: ")).append(iengfilefragment.remotePath()).toString());
            com.penthera.virtuososdk.utility..mFile(Downloader.access$0(), (new StringBuilder("tryDownloadItem(): bytes read on the previous attempt: ")).append(mFile(this._cls1.this).iDownloadInfo._fld1).toString());
        }
        this._mth1(this._cls1.this).iDownloadInfo._fld1 = 0L;
        flag = false;
        Object obj1 = this._mth1(this._cls1.this, iengfilefragment, mConnectionType, mEventBearerType, mClient);
        if (com.penthera.virtuososdk.utility.rorRetryOn416 != obj1) goto _L2; else goto _L1
_L1:
        Object obj = orRetryOn416(this._cls1.this, iengfilefragment, mConnectionType, mEventBearerType, mClient);
_L4:
        mClient(this._cls1.this).iDownloadInfo._fld1 = 0;
        i = ((flag) ? 1 : 0);
_L8:
        if (this._mth1(this._cls1.this).iDownloadInfo._fld1 < 3)
        {
            continue; /* Loop/switch isn't completed */
        }
        com.penthera.virtuososdk.utility..this._mth1(Downloader.access$0(), (new StringBuilder("c[ ")).append(this._mth1(this._cls1.this).iClientAuthority).append("] No internet connection: connection not usable").toString());
        iengfilefragment.setDownloadStatus(this._mth1(this._cls1.this, ((com.penthera.virtuososdk.utility..this._cls1) (obj))));
        mFile.updateFragment(CommonUtil.getApplicationContext(), iengfilefragment);
        obj1 = com.penthera.virtuososdk.utility.ockedErrorsMaxed;
_L11:
        return ((com.penthera.virtuososdk.utility.ockedErrorsMaxed) (obj1));
_L2:
        if (com.penthera.virtuososdk.utility.ockedErrorFileExpectedSize == obj1 || com.penthera.virtuososdk.utility.ockedErrorFileMimeType == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj1;
        if (com.penthera.virtuososdk.utility.ockedErrorHTTP != obj1) goto _L4; else goto _L3
_L7:
        if (com.penthera.virtuososdk.utility.ockedErrorFileExpectedSize == obj1 || com.penthera.virtuososdk.utility.ockedErrorFileMimeType == obj1)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj1;
        if (com.penthera.virtuososdk.utility.ockedErrorHTTP != obj1) goto _L4; else goto _L5
_L5:
        obj = obj1;
        if (i >= 3) goto _L4; else goto _L6
_L6:
        obj1 = ckedErrorHTTP(this._cls1.this, iengfilefragment, mConnectionType, mEventBearerType, mClient);
        i++;
          goto _L7
        obj;
        com.penthera.virtuososdk.utility..mClient(Downloader.access$0(), (new StringBuilder("tryDownloadItem(): Network unavaialble -- Received unknown host excpetion: ")).append(((UnknownHostException) (obj)).getMessage()).toString());
        obj = mClient(this._cls1.this).iDownloadInfo;
        obj._fld1 = ((this._cls1) (obj))._fld1 + 1;
        com.penthera.virtuososdk.utility..this._mth1("virtuoso.intent.action.UNKNOWN_HOST");
        obj = com.penthera.virtuososdk.utility.ockedErrorNetwork;
        i = 1;
          goto _L8
        obj;
        com.penthera.virtuososdk.utility.ockedErrorNetwork(Downloader.access$0(), (new StringBuilder("tryDownloadItem(): Network problem -- Received a network error: ")).append(((Exception) (obj)).getMessage()).toString());
        obj = ckedErrorNetwork(this._cls1.this).iDownloadInfo;
        obj._fld1 = ((this._cls1) (obj))._fld1 + 1;
        obj = com.penthera.virtuososdk.utility.ockedErrorNetwork;
        i = 1;
          goto _L8
        obj;
        com.penthera.virtuososdk.utility.ockedErrorNetwork(Downloader.access$0(), (new StringBuilder("tryDownloadItem(): Network problem -- unknown error: ")).append(((Throwable) (obj)).getMessage()).toString());
        obj = ckedErrorNetwork(this._cls1.this).iDownloadInfo;
        obj._fld1 = ((this._cls1) (obj))._fld1 + 1;
        obj = com.penthera.virtuososdk.utility.ockedErrorNetwork;
        i = 1;
          goto _L8
        if (i != 0 && ckedErrorNetwork(this._cls1.this).iDownloadInfo._fld1 > 0L) goto _L10; else goto _L9
_L9:
        if (obj == com.penthera.virtuososdk.utility.mplete)
        {
            iengfilefragment.markComplete();
        } else
        {
            iengfilefragment.setDownloadStatus(plete(this._cls1.this, ((com.penthera.virtuososdk.utility..this._cls1) (obj))));
        }
        if (iengfilefragment.downloadStatus() == com.penthera.virtuososdk.Copy_Error && iengfilefragment.currentSize() <= 0.0D)
        {
            iengfilefragment.setFilePath(null);
        }
        mFile.updateFragment(CommonUtil.getApplicationContext(), iengfilefragment);
        obj1 = obj;
        if (obj == com.penthera.virtuososdk.utility.mplete)
        {
            plete(this._cls1.this, mFile, iengfilefragment);
            return ((com.penthera.virtuososdk.utility..mFile) (obj));
        }
          goto _L11
_L3:
        i = 1;
          goto _L7
    }

    public void begin()
    {
        Downloader.access$1(mFile(this._cls1.this), com.penthera.virtuososdk.utility.mplete);
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

                final Downloader.VirtuosoDownloadThread.HlsDownload this$2;

                public void run()
                {
_L5:
                    obj = getNext();
                    if (obj == null) goto _L2; else goto _L1
_L1:
                    boolean flag = mAbort;
                    if (!flag) goto _L3; else goto _L2
_L2:
                    obj = Downloader.VirtuosoDownloadThread.HlsDownload.this;
                    obj.mActiveWorkers = ((Downloader.VirtuosoDownloadThread.HlsDownload) (obj)).mActiveWorkers - 1;
                    if (mActiveWorkers <= 0 && !mAbort)
                    {
                        synchronized (Downloader.VirtuosoDownloadThread.access$0(this$1))
                        {
                            Downloader.VirtuosoDownloadThread.access$0(this$1).notify();
                        }
                    }
                    return;
_L3:
                    obj = download(((IEngFileFragment) (obj)));
                    obj1 = mHlsWorkerLock;
                    obj1;
                    JVM INSTR monitorenter ;
                    if (Downloader.VirtuosoDownloadThread.access$1(this$1))
                    {
                        obj = Downloader.VirtuosoDownloadThread.access$2(this$1);
                    }
                    if (!mAbort)
                    {
                        Downloader.access$1(Downloader.VirtuosoDownloadThread.access$8(this$1), ((com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion) (obj)));
                    }
                    if (obj == com.penthera.virtuososdk.utility.CommonUtil.EFileDownloadCompletion.EDownloadComplete)
                    {
                        break MISSING_BLOCK_LABEL_298;
                    }
                    mAbort = true;
                    mClient.getConnectionManager().shutdown();
                    synchronized (Downloader.VirtuosoDownloadThread.access$0(this$1))
                    {
                        Downloader.VirtuosoDownloadThread.access$0(this$1).notify();
                    }
                    obj1;
                    JVM INSTR monitorexit ;
                      goto _L2
                    obj;
                    obj1;
                    JVM INSTR monitorexit ;
                    throw obj;
                    obj;
                    obj1 = Downloader.VirtuosoDownloadThread.HlsDownload.this;
                    obj1.mActiveWorkers = ((Downloader.VirtuosoDownloadThread.HlsDownload) (obj1)).mActiveWorkers - 1;
                    if (mActiveWorkers <= 0 && !mAbort)
                    {
                        synchronized (Downloader.VirtuosoDownloadThread.access$0(this$1))
                        {
                            Downloader.VirtuosoDownloadThread.access$0(this$1).notify();
                        }
                    }
                    throw obj;
                    exception1;
                    obj;
                    JVM INSTR monitorexit ;
                    throw exception1;
                    obj1;
                    JVM INSTR monitorexit ;
                    if (true) goto _L5; else goto _L4
_L4:
                    obj;
                    obj1;
                    JVM INSTR monitorexit ;
                    throw obj;
                    exception;
                    obj;
                    JVM INSTR monitorexit ;
                    throw exception;
                }

            
            {
                this$2 = Downloader.VirtuosoDownloadThread.HlsDownload.this;
                super();
            }
            })).start();
            i++;
        } while (true);
    }

    IEngFileFragment getNext()
    {
        this;
        JVM INSTR monitorenter ;
        IEngFileFragment iengfilefragment = null;
        if (mIndex < mFragments.size())
        {
            iengfilefragment = (IEngFileFragment)mFragments.get(mIndex);
            mIndex = mIndex + 1;
        }
        this;
        JVM INSTR monitorexit ;
        return iengfilefragment;
        Exception exception;
        exception;
        throw exception;
    }









    public _cls1.this._cls2(IEngVHLSFile iengvhlsfile, int i, String s, HttpClient httpclient)
    {
        this$1 = this._cls1.this;
        super();
        mAbort = false;
        mActiveWorkers = 0;
        mHlsWorkerLock = new Object();
        mFile = iengvhlsfile;
        mConnectionType = i;
        mEventBearerType = s;
        mClient = httpclient;
        mFragments = iengvhlsfile.pendingFragments(CommonUtil.getApplicationContext());
    }
}
