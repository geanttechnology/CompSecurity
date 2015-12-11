// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.video.adsdk.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JsResult;
import android.webkit.WebView;
import com.video.adsdk.VideoAdSDKListener;
import com.video.adsdk.interfaces.FileDownloader;
import com.video.adsdk.interfaces.JavascriptBridge;
import com.video.adsdk.interfaces.JavascriptBridgeListener;
import com.video.adsdk.interfaces.PrefetcherListener;
import com.video.adsdk.interfaces.VideoBridge;
import com.video.adsdk.interfaces.VideoBridgeListener;
import com.video.adsdk.interfaces.checker.DeviceIdBundle;
import com.video.adsdk.internal.checker.ADConnectivityChecker;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.video.adsdk.internal:
//            ADRequest, ADJavascriptBridge, ADFileDownloader, Prefetcher, 
//            ADWifiMonitor, ADActivity, EmbedViewController, BrowserActivity, 
//            ADVideoFile, ADVideoView

public class VideoAdSDKControllerUsingActivity
    implements JavascriptBridgeListener, PrefetcherListener, VideoBridgeListener
{

    public static VideoAdSDKControllerUsingActivity Instance = new VideoAdSDKControllerUsingActivity();
    private static final int RUN_ON_UI_THREAD = 1;
    private Context applicationContext;
    private ADVideoFile currentFile;
    private ADRequest currentRequest;
    private View embeddedView;
    private FileDownloader fileDownloader;
    private boolean isMovieClicked;
    private boolean isPlayingAdvertising;
    private boolean isVideoReadyToPlay;
    private JavascriptBridge javascriptBridge;
    private VideoAdSDKListener listener;
    private Boolean m_isShowSkipVisible;
    private final Map params = new HashMap();
    private String publisherId;
    int stateSendToJavascriptWithSecondOneAlready;
    Handler uiHandler;
    private VideoBridge videoBridge;
    private Prefetcher videoPrefetcher;
    private boolean wiFiOnly;
    private ADWifiMonitor wifiMonitor;

    private VideoAdSDKControllerUsingActivity()
    {
        listener = null;
        publisherId = null;
        m_isShowSkipVisible = Boolean.valueOf(false);
        isVideoReadyToPlay = false;
        isMovieClicked = false;
        isPlayingAdvertising = false;
        wifiMonitor = null;
        wiFiOnly = true;
        uiHandler = new _cls1(Looper.getMainLooper());
        stateSendToJavascriptWithSecondOneAlready = 0;
    }

    private void advertisingFailedToLoad(Exception exception)
    {
        isPlayingAdvertising = false;
        if (listener != null)
        {
            listener.onAdvertisingFailedToLoad(exception);
        }
    }

    private void advertisingNotAvailable()
    {
        isPlayingAdvertising = false;
        if (listener != null)
        {
            listener.onAdvertisingNotAvailable();
        }
    }

    private void advertisingTimedOut()
    {
        isPlayingAdvertising = false;
        if (listener != null)
        {
            listener.onAdvertisingTimedOut();
        }
    }

    private void createADRequest(boolean flag)
    {
        ADRequest.createRequest(applicationContext, publisherId, new _cls2(flag));
    }

    private String getLocalDirectory()
        throws IOException
    {
        return fileDownloader.getTargetDirectoryPath();
    }

    private boolean registeredWithPublisherId()
    {
        return publisherId != null;
    }

    private void setupJavascriptBridge()
    {
        if (javascriptBridge != null)
        {
            javascriptBridge.cancel();
        }
        javascriptBridge = new ADJavascriptBridge(applicationContext);
        javascriptBridge.addListener(this);
    }

    private void setupPrefetcher(boolean flag)
    {
        fileDownloader = new ADFileDownloader(applicationContext, flag);
        if (videoPrefetcher != null)
        {
            videoPrefetcher.stopPrefetching();
        }
        videoPrefetcher = new Prefetcher();
        videoPrefetcher.setWiFiOnly(wiFiOnly);
        videoPrefetcher.setWifiMonitor(wifiMonitor);
        videoPrefetcher.setFileDownloader(fileDownloader);
        videoPrefetcher.addPrefetcherListener(this);
    }

    private void setupWifiMonitor()
    {
        unregisterReceiver(wifiMonitor);
        wifiMonitor = new ADWifiMonitor(new ADConnectivityChecker(applicationContext));
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
        try
        {
            applicationContext.registerReceiver(wifiMonitor, intentfilter);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    private void unregisterReceiver(BroadcastReceiver broadcastreceiver)
    {
        if (broadcastreceiver == null)
        {
            break MISSING_BLOCK_LABEL_12;
        }
        applicationContext.unregisterReceiver(broadcastreceiver);
        return;
        broadcastreceiver;
    }

    public void advertisingDidHide()
    {
        isMovieClicked = false;
        isPlayingAdvertising = false;
        if (listener != null)
        {
            listener.onAdvertisingDidHide();
        }
    }

    public void clearCache()
    {
        if (fileDownloader != null)
        {
            fileDownloader.deleteAllFiles();
        }
    }

    public void disableEmbedView()
    {
        embeddedView = null;
    }

    public void displayAdvertising()
    {
        isMovieClicked = false;
        if (!registeredWithPublisherId())
        {
            return;
        }
        if (listener != null)
        {
            listener.onAdvertisingWillShow();
        }
        if (isFakeNeeded())
        {
            Intent intent = new Intent(applicationContext, com/video/adsdk/internal/ADActivity);
            intent.setFlags(0x10000000);
            intent.putExtra(ADActivity.PARAM_USE_FAKE, true);
            applicationContext.startActivity(intent);
            return;
        }
        if (isViewEmbed())
        {
            (new EmbedViewController()).displayAdvertising();
            return;
        } else
        {
            Intent intent1 = new Intent(applicationContext, com/video/adsdk/internal/ADActivity);
            intent1.setFlags(0x10000000);
            intent1.putExtra(ADActivity.PARAM_USE_FAKE, false);
            applicationContext.startActivity(intent1);
            return;
        }
    }

    public void enableEmbedView(View view)
    {
        embeddedView = view;
    }

    public ADVideoFile getCurrentFile()
    {
        return currentFile;
    }

    public View getEmbeddedView()
    {
        return embeddedView;
    }

    public JavascriptBridge getJavascriptBridge()
    {
        return javascriptBridge;
    }

    public Prefetcher getPrefetcher()
    {
        return videoPrefetcher;
    }

    public VideoBridge getVideoBridge()
    {
        return videoBridge;
    }

    public boolean isClosableByUI()
    {
        return videoBridge.getCurrentMovieState() != com.video.adsdk.interfaces.VideoBridge.MovieState.MOVIESTATE_PLAYING_NO_SKIP || videoBridge.isClosableByUI();
    }

    public boolean isCorrectVersion()
    {
        return android.os.Build.VERSION.SDK_INT > 7;
    }

    public boolean isFakeNeeded()
    {
        int i;
        if (!Build.FINGERPRINT.startsWith("generic"))
        {
            break MISSING_BLOCK_LABEL_25;
        }
        i = android.os.Build.VERSION.SDK_INT;
        if (i == 10)
        {
            return true;
        }
        break MISSING_BLOCK_LABEL_25;
        Exception exception;
        exception;
        return false;
    }

    Boolean isShowSkipVisible()
    {
        return m_isShowSkipVisible;
    }

    public boolean isVideoPlaying()
    {
        return videoBridge.getCurrentMovieState() == com.video.adsdk.interfaces.VideoBridge.MovieState.MOVIESTATE_PLAYING_SKIP || videoBridge.getCurrentMovieState() == com.video.adsdk.interfaces.VideoBridge.MovieState.MOVIESTATE_PLAYING_NO_SKIP || videoBridge.getCurrentMovieState() == com.video.adsdk.interfaces.VideoBridge.MovieState.MOVIESTATE_PAUSED || videoBridge.getCurrentMovieState() == com.video.adsdk.interfaces.VideoBridge.MovieState.MOVIESTATE_RESUMED || videoBridge.getCurrentMovieState() == com.video.adsdk.interfaces.VideoBridge.MovieState.MOVIESTATE_BUFFERING || videoBridge.getCurrentMovieState() == com.video.adsdk.interfaces.VideoBridge.MovieState.MOVIESTATE_STARTED;
    }

    public boolean isViewEmbed()
    {
        return embeddedView != null;
    }

    public boolean isWiFiOnly()
    {
        return wiFiOnly;
    }

    public void movieClick()
    {
        javascriptBridge.movieClick();
        if (listener != null)
        {
            listener.onAdvertisingClicked();
        }
    }

    public void onDisplay()
    {
        if (listener != null)
        {
            listener.onAdvertisingIsReadyToPlay();
        }
    }

    public void onFinish(int i)
    {
        if (i < 0)
        {
            advertisingNotAvailable();
        }
    }

    public void onOpenURLInBrowser(String s, boolean flag)
    {
        isMovieClicked = true;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        Intent intent;
        intent = new Intent(applicationContext, com/video/adsdk/internal/BrowserActivity);
        intent.putExtra("url", s);
        s = intent;
_L1:
        if (s != null)
        {
            try
            {
                s.setFlags(0x10000000);
                applicationContext.startActivity(s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
            }
        }
        break MISSING_BLOCK_LABEL_79;
        s = new Intent("android.intent.action.VIEW", Uri.parse(s));
          goto _L1
    }

    public void onPageError(int i, String s, String s1)
    {
        advertisingFailedToLoad(new Exception((new StringBuilder()).append(i).append(" ").append(s).append(" ").append(s1).toString()));
    }

    public void onPageLoaded(String s)
    {
        String s1;
        for (s = params.keySet().iterator(); s.hasNext(); getJavascriptBridge().setParam(s1, (String)params.get(s1)))
        {
            s1 = (String)s.next();
        }

        s = currentRequest.getDeviceIdBundle();
        if (s.getMAC() != null)
        {
            getJavascriptBridge().setParam("did1", s.getMAC());
        }
        if (s.getMacSHA1() != null)
        {
            getJavascriptBridge().setParam("did2", s.getMacSHA1());
        }
        if (s.getAdvertisingId() != null)
        {
            getJavascriptBridge().setParam("did3", s.getAdvertisingId().getId());
        }
        if (s.getOpenUDID() != null)
        {
            getJavascriptBridge().setParam("did5", s.getOpenUDID());
        }
        if (s.getAndroidId() != null)
        {
            getJavascriptBridge().setParam("did6", s.getAndroidId());
        }
    }

    public void onPageStartingLoad(String s)
    {
    }

    public void onPageTimeOut(String s, String s1)
    {
        advertisingTimedOut();
    }

    public void onPlayMovie(String s)
    {
        if (s == null || s == "")
        {
            advertisingFailedToLoad(new Exception("Invalid url: null"));
            return;
        }
        stateSendToJavascriptWithSecondOneAlready = 0;
        currentFile = new ADVideoFile(s, System.currentTimeMillis(), true);
        if (!currentFile.isPrefetchedIn(getLocalDirectory()))
        {
            break MISSING_BLOCK_LABEL_109;
        }
        Log.d("VIDEO_AD_SDK", "File already prefetched");
        runOnUiThread(new _cls3());
_L1:
        if (s == null || s == "")
        {
            advertisingFailedToLoad(new Exception("Invalid url: null"));
            return;
        } else
        {
            stateSendToJavascriptWithSecondOneAlready = 0;
            return;
        }
        try
        {
            videoPrefetcher.prefetchFile(currentFile);
        }
        catch (MalformedURLException malformedurlexception)
        {
            advertisingNotAvailable();
            malformedurlexception.printStackTrace();
        }
        catch (IOException ioexception)
        {
            advertisingFailedToLoad(ioexception);
            ioexception.printStackTrace();
        }
          goto _L1
    }

    public void onPrefetchURL(String s, long l)
    {
        try
        {
            s = new ADVideoFile(s, 1000L * l, false);
            videoPrefetcher.prefetchFile(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            advertisingNotAvailable();
        }
    }

    public void onPrefetchedFile(ADVideoFile advideofile)
    {
        currentFile = advideofile;
        if (!advideofile.shouldPlayAfterPrefetching())
        {
            break MISSING_BLOCK_LABEL_80;
        }
        if (videoBridge == null)
        {
            return;
        }
        try
        {
            videoBridge.setUrl((new StringBuilder()).append(Instance.getLocalDirectory()).append(advideofile.getFilename()).toString());
            runOnUiThread(new _cls6());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ADVideoFile advideofile)
        {
            Instance.advertisingFailedToLoad(advideofile);
        }
        advideofile.printStackTrace();
    }

    public void onPrefetchingDidComplete()
    {
        javascriptBridge.prefetchingComplete();
        if (listener != null)
        {
            listener.onAdvertisingPrefetchingDidComplete();
        }
    }

    public void onPrefetchingFailed()
    {
        runOnUiThread(new _cls7());
        advertisingNotAvailable();
    }

    public void onPrefetchingStarted()
    {
    }

    public void onProgress(double d)
    {
        if (listener != null)
        {
            listener.onPrefetcherProgress(d);
        }
    }

    public void onSetBackgroundColor(int i)
    {
        if (videoBridge != null)
        {
            videoBridge.setBackgroundColor(i);
        }
    }

    public void onShowDialog(String s, JsResult jsresult)
    {
    }

    public void onShowSkip()
    {
        m_isShowSkipVisible = Boolean.valueOf(true);
        if (videoBridge == null)
        {
            return;
        } else
        {
            ((View)videoBridge).post(new _cls4());
            return;
        }
    }

    public void onSkipButtonClicked()
    {
        videoPrefetcher.deleteExpiredFiles();
        getJavascriptBridge().moviePulse(com.video.adsdk.interfaces.VideoBridge.MovieState.MOVIESTATE_STOPPED_BY_USER, getVideoBridge().getCurrentSecond());
        javascriptBridge.finalReturn(1);
    }

    public void onTrack(String s)
    {
        if (listener != null)
        {
            listener.onAdvertisingEventTracked(s);
        }
    }

    public void onVideoIsComplete()
    {
        javascriptBridge.finalReturn(1);
    }

    public void onVideoIsReadyToPlay(com.video.adsdk.interfaces.VideoBridge.MovieState moviestate, int i)
    {
        isVideoReadyToPlay = true;
        if (listener != null)
        {
            listener.onAdvertisingIsReadyToPlay();
        }
    }

    public void onVideoPlaybackError(int i, int j)
    {
        String s = String.format("Error: (%d, %d)", new Object[] {
            Integer.valueOf(i), Integer.valueOf(j)
        });
        videoBridge.shutdown();
        advertisingFailedToLoad(new Exception(s));
        javascriptBridge.troubleshoot(s, -1);
    }

    public void onVideoReportsCurrentState(com.video.adsdk.interfaces.VideoBridge.MovieState moviestate, long l)
    {
        ((View)videoBridge).post(new _cls5(l, moviestate));
    }

    void raiseFakeVideoPlayEvents(boolean flag)
    {
label0:
        {
            if (listener != null)
            {
                if (flag)
                {
                    break label0;
                }
                listener.onAdvertisingEventTracked("impression");
                listener.onAdvertisingEventTracked("firstQuartile");
                listener.onAdvertisingEventTracked("midpoint");
                listener.onAdvertisingEventTracked("thirdQuartile");
            }
            return;
        }
        listener.onAdvertisingEventTracked("complete");
    }

    public boolean registerWithPublisherID(Context context, String s, VideoAdSDKListener videoadsdklistener, boolean flag)
    {
        applicationContext = context;
        publisherId = s;
        listener = videoadsdklistener;
        isPlayingAdvertising = false;
        setupWifiMonitor();
        setupPrefetcher(flag);
        return true;
    }

    public void runOnUiThread(Runnable runnable)
    {
        uiHandler.obtainMessage(1, runnable).sendToTarget();
    }

    public void setIsPlayingAdvertising(boolean flag)
    {
        isPlayingAdvertising = flag;
    }

    public boolean setUserAttribute(String s, String s1)
    {
        params.put(s, s1);
        if (javascriptBridge != null)
        {
            getJavascriptBridge().setParam(s, s1);
        }
        return true;
    }

    public void setWiFiOnly(boolean flag)
    {
        wiFiOnly = flag;
        if (videoPrefetcher != null)
        {
            videoPrefetcher.setWiFiOnly(flag);
        }
    }

    public void startLoadingAdvertisingURL()
    {
        setupJavascriptBridge();
        if (registeredWithPublisherId()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (!isFakeNeeded())
        {
            break; /* Loop/switch isn't completed */
        }
        if (listener != null)
        {
            listener.onAdvertisingIsReadyToPlay();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (isPlayingAdvertising)
        {
            if (listener != null)
            {
                listener.onAdvertisingNotAvailable();
                return;
            }
        } else
        {
            isPlayingAdvertising = true;
            isVideoReadyToPlay = false;
            if (videoBridge != null)
            {
                videoBridge.removeWebView();
            }
            videoBridge = new ADVideoView(applicationContext);
            videoBridge.setFileDownloader(fileDownloader);
            videoBridge.addListener(this);
            WebView webview = javascriptBridge.getWebView();
            if (webview.getParent() != null)
            {
                ((ViewGroup)webview.getParent()).removeAllViews();
            }
            videoBridge.setWebview(javascriptBridge.getWebView());
            if (m_isShowSkipVisible.booleanValue())
            {
                onShowSkip();
            }
            createADRequest(false);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void startLoadingPrefetchingURL()
    {
        setupJavascriptBridge();
        if (registeredWithPublisherId())
        {
            if (isFakeNeeded())
            {
                if (listener != null)
                {
                    listener.onAdvertisingEventTracked("prefetch");
                    listener.onAdvertisingPrefetchingDidComplete();
                    listener.onAdvertisingEventTracked("prefetched");
                    return;
                }
            } else
            {
                createADRequest(true);
                return;
            }
        }
    }

    public boolean wasMovieClicked()
    {
        return isMovieClicked;
    }




/*
    static ADRequest access$002(VideoAdSDKControllerUsingActivity videoadsdkcontrollerusingactivity, ADRequest adrequest)
    {
        videoadsdkcontrollerusingactivity.currentRequest = adrequest;
        return adrequest;
    }

*/







    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls7 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls5 {}

}
