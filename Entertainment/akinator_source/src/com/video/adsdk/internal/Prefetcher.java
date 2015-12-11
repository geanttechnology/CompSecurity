// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.video.adsdk.internal;

import com.video.adsdk.interfaces.DownloadProgressListener;
import com.video.adsdk.interfaces.FileDownloader;
import com.video.adsdk.interfaces.PrefetcherListener;
import com.video.adsdk.interfaces.WifiMonitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

// Referenced classes of package com.video.adsdk.internal:
//            ADVideoFile

public class Prefetcher
    implements DownloadProgressListener
{

    private Thread backgroundDownloadProcess;
    private FileDownloader fileDownloader;
    private boolean isWifiActive;
    List listeners;
    private final Queue videoUrlQueue = new ConcurrentLinkedQueue();
    private boolean wiFiOnly;
    private WifiMonitor wifiMonitor;

    public Prefetcher()
    {
        isWifiActive = false;
        backgroundDownloadProcess = null;
        listeners = new ArrayList();
        wiFiOnly = true;
    }

    private boolean canDownload()
    {
        return !wiFiOnly || isWifiActive;
    }

    private Thread createDownloaderThread()
    {
        return new Thread(new _cls1());
    }

    private void prefetchingFailed()
    {
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((PrefetcherListener)iterator.next()).onPrefetchingFailed()) { }
    }

    public void addPrefetcherListener(PrefetcherListener prefetcherlistener)
    {
        if (prefetcherlistener != null && !listeners.contains(prefetcherlistener))
        {
            listeners.add(prefetcherlistener);
        }
    }

    public void deleteExpiredFiles()
    {
        if (fileDownloader != null)
        {
            fileDownloader.deleteExpiredFiles();
        }
    }

    public boolean isPrefetchingRunning()
    {
        return backgroundDownloadProcess != null && backgroundDownloadProcess.isAlive();
    }

    public void onProgress(double d)
    {
        for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((PrefetcherListener)iterator.next()).onProgress(d)) { }
    }

    public void prefetchFile(ADVideoFile advideofile)
    {
        Iterator iterator = videoUrlQueue.iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        if (!((ADVideoFile)iterator.next()).getUrl().equals(advideofile.getUrl())) goto _L4; else goto _L3
_L3:
        return;
_L2:
        videoUrlQueue.add(advideofile);
        if (!isPrefetchingRunning())
        {
            startPrefetching();
            return;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public void removeListener(PrefetcherListener prefetcherlistener)
    {
        if (listeners.contains(prefetcherlistener))
        {
            listeners.remove(prefetcherlistener);
        }
    }

    public void setFileDownloader(FileDownloader filedownloader)
    {
        fileDownloader = filedownloader;
        fileDownloader.setDownloadProgressListener(this);
    }

    public void setWiFiOnly(boolean flag)
    {
        wiFiOnly = flag;
    }

    public void setWifiMonitor(WifiMonitor wifimonitor)
    {
        wifiMonitor = wifimonitor;
        isWifiActive = wifimonitor.isWifiActive();
        wifiMonitor.registerWifiListener(new _cls2());
    }

    public void startPrefetching()
    {
        if (!isPrefetchingRunning())
        {
            backgroundDownloadProcess = createDownloaderThread();
            backgroundDownloadProcess.start();
        }
    }

    public void stopPrefetching()
    {
        if (isPrefetchingRunning())
        {
            backgroundDownloadProcess.interrupt();
            backgroundDownloadProcess = null;
        }
    }






/*
    static boolean access$402(Prefetcher prefetcher, boolean flag)
    {
        prefetcher.isWifiActive = flag;
        return flag;
    }

*/

    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
