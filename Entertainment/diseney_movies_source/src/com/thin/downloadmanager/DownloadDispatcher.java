// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.thin.downloadmanager;

import android.net.Uri;
import android.os.Process;
import android.util.Log;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.BlockingQueue;

// Referenced classes of package com.thin.downloadmanager:
//            DownloadRequest

public class DownloadDispatcher extends Thread
{

    public static final String TAG = "ThinDownloadManager";
    public final int BUFFER_SIZE = 4096;
    private final int DEFAULT_TIMEOUT = 20000;
    private final int HTTP_REQUESTED_RANGE_NOT_SATISFIABLE = 416;
    private final int HTTP_TEMP_REDIRECT = 307;
    public final int MAX_REDIRECTS = 5;
    private long mContentLength;
    private long mCurrentBytes;
    private DownloadRequestQueue.CallBackDelivery mDelivery;
    private final BlockingQueue mQueue;
    private volatile boolean mQuit;
    private int mRedirectionCount;
    private DownloadRequest mRequest;
    boolean shouldAllowRedirects;

    public DownloadDispatcher(BlockingQueue blockingqueue, DownloadRequestQueue.CallBackDelivery callbackdelivery)
    {
        mQuit = false;
        mRedirectionCount = 0;
        shouldAllowRedirects = true;
        mQueue = blockingqueue;
        mDelivery = callbackdelivery;
    }

    private void cleanupDestination()
    {
        Log.d("ThinDownloadManager", (new StringBuilder()).append("cleanupDestination() deleting ").append(mRequest.getDestinationURI().toString()).toString());
        File file = new File(mRequest.getDestinationURI().toString());
        if (file.exists())
        {
            file.delete();
        }
    }

    private void executeDownload(String s)
    {
        Object obj;
        Object obj1;
        int i;
        try
        {
            obj1 = new URL(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            updateDownloadFailed(1007, "MalformedURLException: URI passed is malformed.");
            return;
        }
        obj = null;
        s = null;
        obj1 = (HttpURLConnection)((URL) (obj1)).openConnection();
        s = ((String) (obj1));
        obj = obj1;
        ((HttpURLConnection) (obj1)).setInstanceFollowRedirects(false);
        s = ((String) (obj1));
        obj = obj1;
        ((HttpURLConnection) (obj1)).setConnectTimeout(20000);
        s = ((String) (obj1));
        obj = obj1;
        ((HttpURLConnection) (obj1)).setReadTimeout(20000);
        s = ((String) (obj1));
        obj = obj1;
        i = ((HttpURLConnection) (obj1)).getResponseCode();
        s = ((String) (obj1));
        obj = obj1;
        Log.v("ThinDownloadManager", (new StringBuilder()).append("Response code obtained for downloaded Id ").append(mRequest.getDownloadId()).append(" : httpResponse Code ").append(i).toString());
        i;
        JVM INSTR lookupswitch 8: default 522
    //                   200: 247
    //                   301: 332
    //                   302: 332
    //                   303: 332
    //                   307: 332
    //                   416: 468
    //                   500: 504
    //                   503: 486;
           goto _L1 _L2 _L3 _L3 _L3 _L3 _L4 _L5 _L6
_L1:
        s = ((String) (obj1));
        obj = obj1;
        updateDownloadFailed(1002, (new StringBuilder()).append("Unhandled HTTP response:").append(i).append(" message:").append(((HttpURLConnection) (obj1)).getResponseMessage()).toString());
_L14:
        if (obj1 != null)
        {
            ((HttpURLConnection) (obj1)).disconnect();
        }
_L11:
        return;
_L2:
        s = ((String) (obj1));
        obj = obj1;
        shouldAllowRedirects = false;
        s = ((String) (obj1));
        obj = obj1;
        if (readResponseHeaders(((HttpURLConnection) (obj1))) != 1) goto _L8; else goto _L7
_L7:
        s = ((String) (obj1));
        obj = obj1;
        transferData(((HttpURLConnection) (obj1)));
_L10:
        if (obj1 != null)
        {
            ((HttpURLConnection) (obj1)).disconnect();
        }
        return;
_L8:
        s = ((String) (obj1));
        obj = obj1;
        updateDownloadFailed(1006, "Can't know size of download, giving up");
        if (true) goto _L10; else goto _L9
_L9:
        obj1;
        obj = s;
        ((IOException) (obj1)).printStackTrace();
        obj = s;
        updateDownloadFailed(1004, "Trouble with low-level sockets");
        if (s != null)
        {
            s.disconnect();
        }
          goto _L11
_L3:
        s = ((String) (obj1));
        obj = obj1;
        int j = mRedirectionCount;
        s = ((String) (obj1));
        obj = obj1;
        mRedirectionCount = j + 1;
        if (j >= 5)
        {
            break; /* Loop/switch isn't completed */
        }
        s = ((String) (obj1));
        obj = obj1;
        if (!shouldAllowRedirects)
        {
            break; /* Loop/switch isn't completed */
        }
        s = ((String) (obj1));
        obj = obj1;
        Log.v("ThinDownloadManager", (new StringBuilder()).append("Redirect for downloaded Id ").append(mRequest.getDownloadId()).toString());
        s = ((String) (obj1));
        obj = obj1;
        executeDownload(((HttpURLConnection) (obj1)).getHeaderField("Location"));
        if (true) goto _L3; else goto _L12
        s;
        if (obj != null)
        {
            ((HttpURLConnection) (obj)).disconnect();
        }
        throw s;
_L12:
        s = ((String) (obj1));
        obj = obj1;
        if (mRedirectionCount <= 5) goto _L14; else goto _L13
_L13:
        s = ((String) (obj1));
        obj = obj1;
        updateDownloadFailed(1005, "Too many redirects, giving up");
        if (obj1 != null)
        {
            ((HttpURLConnection) (obj1)).disconnect();
        }
        return;
_L4:
        s = ((String) (obj1));
        obj = obj1;
        updateDownloadFailed(416, ((HttpURLConnection) (obj1)).getResponseMessage());
          goto _L14
_L6:
        s = ((String) (obj1));
        obj = obj1;
        updateDownloadFailed(503, ((HttpURLConnection) (obj1)).getResponseMessage());
          goto _L14
_L5:
        s = ((String) (obj1));
        obj = obj1;
        updateDownloadFailed(500, ((HttpURLConnection) (obj1)).getResponseMessage());
          goto _L14
    }

    private int readFromResponse(byte abyte0[], InputStream inputstream)
    {
        int i;
        try
        {
            i = inputstream.read(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            if ("unexpected end of stream".equals(abyte0.getMessage()))
            {
                return -1;
            } else
            {
                updateDownloadFailed(1004, "IOException: Failed reading response");
                return 0x80000000;
            }
        }
        return i;
    }

    private int readResponseHeaders(HttpURLConnection httpurlconnection)
    {
        String s = httpurlconnection.getHeaderField("Transfer-Encoding");
        if (s == null)
        {
            mContentLength = getHeaderFieldLong(httpurlconnection, "Content-Length", -1L);
        } else
        {
            Log.v("ThinDownloadManager", (new StringBuilder()).append("Ignoring Content-Length since Transfer-Encoding is also defined for Downloaded Id ").append(mRequest.getDownloadId()).toString());
            mContentLength = -1L;
        }
        return mContentLength != -1L || s != null && s.equalsIgnoreCase("chunked") ? 1 : -1;
    }

    private void transferData(InputStream inputstream, OutputStream outputstream)
    {
        byte abyte0[];
        abyte0 = new byte[4096];
        mCurrentBytes = 0L;
        mRequest.setDownloadState(4);
        Log.v("ThinDownloadManager", (new StringBuilder()).append("Content Length: ").append(mContentLength).append(" for Download Id ").append(mRequest.getDownloadId()).toString());
_L6:
        if (!mRequest.isCanceled()) goto _L2; else goto _L1
_L1:
        Log.v("ThinDownloadManager", (new StringBuilder()).append("Stopping the download as Download Request is cancelled for Downloaded Id ").append(mRequest.getDownloadId()).toString());
        mRequest.finish();
        updateDownloadFailed(1008, "Download cancelled");
_L4:
        return;
_L2:
        int i;
        i = readFromResponse(abyte0, inputstream);
        if (mContentLength != -1L)
        {
            updateDownloadProgress((int)((mCurrentBytes * 100L) / mContentLength), mCurrentBytes);
        }
        if (i == -1)
        {
            updateDownloadComplete();
            return;
        }
        if (i == 0x80000000) goto _L4; else goto _L3
_L3:
        writeDataToDestination(abyte0, i, outputstream);
        mCurrentBytes = mCurrentBytes + (long)i;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void transferData(HttpURLConnection httpurlconnection)
    {
        Object obj;
        Object obj1;
        HttpURLConnection httpurlconnection1;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        File file;
        Object obj7;
        obj7 = null;
        file = null;
        obj6 = null;
        obj1 = null;
        obj5 = null;
        obj3 = null;
        obj4 = null;
        cleanupDestination();
        httpurlconnection1 = obj7;
        obj = obj1;
        obj2 = obj5;
        httpurlconnection = httpurlconnection.getInputStream();
_L1:
        httpurlconnection1 = httpurlconnection;
        obj = obj1;
        obj2 = obj5;
        file = new File(mRequest.getDestinationURI().getPath().toString());
        httpurlconnection1 = httpurlconnection;
        obj = obj1;
        obj2 = obj5;
        obj1 = new FileOutputStream(file, true);
        obj = ((FileOutputStream)obj1).getFD();
        obj3 = obj;
_L2:
        httpurlconnection1 = httpurlconnection;
        obj = obj1;
        obj2 = obj3;
        transferData(((InputStream) (httpurlconnection)), ((OutputStream) (obj1)));
        try
        {
            httpurlconnection.close();
        }
        // Misplaced declaration of an exception variable
        catch (HttpURLConnection httpurlconnection)
        {
            httpurlconnection.printStackTrace();
        }
        if (obj1 != null)
        {
            try
            {
                ((OutputStream) (obj1)).flush();
            }
            // Misplaced declaration of an exception variable
            catch (HttpURLConnection httpurlconnection)
            {
                try
                {
                    ((OutputStream) (obj1)).close();
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (HttpURLConnection httpurlconnection)
                {
                    httpurlconnection.printStackTrace();
                }
                return;
            }
            finally { }
        }
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_138;
        }
        ((FileDescriptor) (obj3)).sync();
        break MISSING_BLOCK_LABEL_138;
        httpurlconnection;
        httpurlconnection1 = obj7;
        obj = obj1;
        obj2 = obj5;
        httpurlconnection.printStackTrace();
        httpurlconnection = file;
          goto _L1
        httpurlconnection;
_L4:
        try
        {
            httpurlconnection1.close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            ((IOException) (obj1)).printStackTrace();
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_178;
        }
        ((OutputStream) (obj)).flush();
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_188;
        }
        ((FileDescriptor) (obj2)).sync();
        try
        {
            ((OutputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
        }
_L3:
        throw httpurlconnection;
        obj3;
        obj1 = obj6;
_L5:
        httpurlconnection1 = httpurlconnection;
        obj = obj1;
        obj2 = obj5;
        ((IOException) (obj3)).printStackTrace();
        httpurlconnection1 = httpurlconnection;
        obj = obj1;
        obj2 = obj5;
        updateDownloadFailed(1001, "Error in writing download contents to the destination file");
        obj3 = obj4;
          goto _L2
        try
        {
            ((OutputStream) (obj1)).close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HttpURLConnection httpurlconnection)
        {
            httpurlconnection.printStackTrace();
        }
        return;
        try
        {
            ((OutputStream) (obj1)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
        }
        throw httpurlconnection;
        obj1;
        try
        {
            ((OutputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
        }
          goto _L3
        httpurlconnection;
        try
        {
            ((OutputStream) (obj)).close();
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
        }
        throw httpurlconnection;
        Exception exception;
        exception;
        obj = obj1;
        httpurlconnection1 = httpurlconnection;
        obj2 = obj3;
        httpurlconnection = exception;
          goto _L4
        obj3;
          goto _L5
    }

    private void writeDataToDestination(byte abyte0[], int i, OutputStream outputstream)
    {
        do
        {
            try
            {
                outputstream.write(abyte0, 0, i);
                return;
            }
            catch (IOException ioexception)
            {
                updateDownloadFailed(1001, "IOException when writing download contents to the destination file");
            }
        } while (true);
    }

    public long getHeaderFieldLong(URLConnection urlconnection, String s, long l)
    {
        long l1;
        try
        {
            l1 = Long.parseLong(urlconnection.getHeaderField(s));
        }
        // Misplaced declaration of an exception variable
        catch (URLConnection urlconnection)
        {
            return l;
        }
        return l1;
    }

    public void quit()
    {
        mQuit = true;
        interrupt();
    }

    public void run()
    {
        Process.setThreadPriority(10);
        do
        {
            try
            {
                do
                {
                    mRequest = (DownloadRequest)mQueue.take();
                    mRedirectionCount = 0;
                    Log.v("ThinDownloadManager", (new StringBuilder()).append("Download initiated for ").append(mRequest.getDownloadId()).toString());
                    updateDownloadState(2);
                    executeDownload(mRequest.getUri().toString());
                } while (true);
            }
            catch (InterruptedException interruptedexception) { }
        } while (!mQuit);
        if (mRequest != null)
        {
            mRequest.finish();
            updateDownloadFailed(1008, "Download cancelled");
        }
    }

    public void updateDownloadComplete()
    {
        mRequest.setDownloadState(8);
        if (mRequest.getDownloadListener() != null)
        {
            mDelivery.postDownloadComplete(mRequest);
            mRequest.finish();
        }
    }

    public void updateDownloadFailed(int i, String s)
    {
        shouldAllowRedirects = false;
        mRequest.setDownloadState(16);
        cleanupDestination();
        if (mRequest.getDownloadListener() != null)
        {
            mDelivery.postDownloadFailed(mRequest, i, s);
            mRequest.finish();
        }
    }

    public void updateDownloadProgress(int i, long l)
    {
        if (mRequest.getDownloadListener() != null)
        {
            mDelivery.postProgressUpdate(mRequest, mContentLength, l, i);
        }
    }

    public void updateDownloadState(int i)
    {
        mRequest.setDownloadState(i);
    }
}
