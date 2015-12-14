// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.service;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.location.Location;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.targetspot.android.sdk.AdSettings;
import com.targetspot.android.sdk.TSContentSize;
import com.targetspot.android.sdk.util.NetworkUtil;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.UUID;

// Referenced classes of package com.targetspot.android.sdk.service:
//            LocationTracker, WebService, DownloadManager, WebException, 
//            CacheManager, AdClientImpl, LoggingManager, AdBreak, 
//            AdSegment

public class AdManager extends BroadcastReceiver
{
    class ManagerThread extends Thread
    {

        final AdManager this$0;

        public void run()
        {
            Looper.prepare();
            synchronized (notify)
            {
                handler = new Handler() {

                    final ManagerThread this$1;

                    public void handleMessage(Message message)
                    {
                        boolean flag2 = true;
                        boolean flag = true;
                        switch (message.what)
                        {
                        default:
                            return;

                        case 0: // '\0'
                            Log.d("AdManager", "Thread start (MSG_START)");
                            if ((activeClient != null || backgroundClient != null) && !isManagedMode())
                            {
                                Log.d("AdManager", "Refreshing preroll for unmanaged mode");
                                fetchAd(true, 0);
                            }
                            startRefresh();
                            return;

                        case 4: // '\004'
                            Log.d("AdManager", "Fetch ad (MSG_FETCH_AD)");
                            int i;
                            if (message.arg1 == 0)
                            {
                                flag = false;
                            }
                            i = message.arg2;
                            fetchAd(flag, i);
                            return;

                        case 2: // '\002'
                            Log.d("AdManager", "Refresh ads (MSG_REFRESH)");
                            refreshAds();
                            return;

                        case 3: // '\003'
                            Log.d("AdManager", "Release ads (MSG_RELEASE)");
                            AdManager admanager = _fld0;
                            boolean flag1;
                            if (message.arg1 == 4)
                            {
                                flag1 = flag2;
                            } else
                            {
                                flag1 = false;
                            }
                            admanager.releaseAds(flag1);
                            return;

                        case 1: // '\001'
                            Log.d("AdManager", "Thread exit (MSG_QUIT)");
                            stopService();
                            Looper.myLooper().quit();
                            return;
                        }
                    }

            
            {
                this$1 = ManagerThread.this;
                super();
            }
                };
                handler.sendEmptyMessage(0);
                notify.notify();
            }
            Looper.loop();
            AdManager.state = 0;
            handler = null;
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        ManagerThread()
        {
            this$0 = AdManager.this;
            super();
        }
    }


    static final int MSG_AD_AVAILABLE = 5;
    static final int MSG_AD_FAILED = 7;
    static final int MSG_AD_FETCHED = 6;
    static final int MSG_AD_POSITION = 11;
    static final int MSG_AD_REFRESHING = 8;
    static final int MSG_AD_START = 9;
    static final int MSG_AD_STOP = 10;
    static final int MSG_FETCH_AD = 4;
    static final int MSG_QUIT = 1;
    static final int MSG_REFRESH = 2;
    static final int MSG_RELEASE = 3;
    static final int MSG_START = 0;
    private static final String PREFS_NAME = "AdManager";
    private static final int REFRESH_INTERVAL = 0x1b7740;
    private static final int RETRY_AFTER_RECONNECT = 15000;
    private static final int RETRY_INTERVAL = 0x493e0;
    static final int STATE_AD_PLAYING = 3;
    static final int STATE_AD_PREROLL = 4;
    static final int STATE_DOWNLOADING = 2;
    static final int STATE_STOPPED = 0;
    static final int STATE_STOPPING = 5;
    static final int STATE_WAITING = 1;
    private static AdManager instance = null;
    private static int state = 0;
    private double FID_EXPIRATION;
    private AdClientImpl activeClient;
    private List adBreaks;
    private List adPreRoll;
    private AdSettings adSettings;
    private Context appContext;
    private AdClientImpl backgroundClient;
    private CacheManager cache;
    private AdBreak currentAd;
    private DownloadManager downloader;
    private String failedAds[];
    private int failedAttempts;
    private LinkedList fidList;
    private Map fidTimeElapse;
    private Handler handler;
    private AdClientImpl lastClient;
    private Location lastLocation;
    private long lastRefresh;
    private LocationTracker location;
    private LoggingManager logger;
    private boolean networkConnection;
    private Object notify;
    private ManagerThread thread;
    private String userId;

    private AdManager()
    {
        appContext = null;
        adSettings = null;
        activeClient = null;
        backgroundClient = null;
        lastClient = null;
        userId = null;
        thread = null;
        handler = null;
        adBreaks = null;
        adPreRoll = null;
        failedAds = null;
        failedAttempts = 0;
        currentAd = null;
        lastRefresh = 0L;
        lastLocation = null;
        networkConnection = true;
        downloader = null;
        cache = null;
        logger = null;
        location = null;
        notify = new Object();
        fidTimeElapse = new HashMap();
        fidList = new LinkedList();
        FID_EXPIRATION = 180000D;
    }

    private void clearState()
    {
        if (state != 0)
        {
            state = 1;
        }
    }

    private void createUserId()
    {
        android.content.SharedPreferences.Editor editor = appContext.getSharedPreferences("AdManager", 0).edit();
        userId = UUID.randomUUID().toString();
        editor.putString("userId", userId);
        editor.commit();
    }

    private void fetchAd(boolean flag, int i)
    {
        String as[] = getFids();
        String s;
        Object obj;
        StringBuilder stringbuilder;
        try
        {
            lastLocation = location.getLocation();
            obj = WebService.requestAds(adSettings, userId, i, flag, getImageSize(), lastLocation, getOnWifi(), as);
            downloader.prepareAds(((List) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            StringBuilder stringbuilder1 = (new StringBuilder()).append("Unable to get ");
            if (flag)
            {
                s = "preroll";
            } else
            {
                s = "inline";
            }
            Log.d("AdManager", stringbuilder1.append(s).append(" ad: ").append(((Exception) (obj)).getMessage()).toString());
            if (flag)
            {
                adPreRoll = null;
            } else
            {
                adBreaks = null;
            }
            sendEvent(7, getStatus(((Exception) (obj))), ((Exception) (obj)));
            return;
        }
        stringbuilder = (new StringBuilder()).append("Fetched ");
        if (flag)
        {
            s = "preroll";
        } else
        {
            s = "inline";
        }
        Log.d("AdManager", stringbuilder.append(s).append(" ad(s)").toString());
        if (flag)
        {
            adPreRoll = ((List) (obj));
        } else
        {
            adBreaks = ((List) (obj));
        }
        sendEvent(6, 0);
    }

    private String[] getFids()
    {
        Log.d("AdManager", (new StringBuilder()).append("Number of unreleased FIDs: ").append(fidList.size()).toString());
        ListIterator listiterator = fidList.listIterator();
        Object obj = new LinkedList();
        do
        {
            if (!listiterator.hasNext())
            {
                break;
            }
            String s = (String)listiterator.next();
            long l;
            if (fidTimeElapse.get(s) != null)
            {
                l = ((Long)fidTimeElapse.get(s)).longValue();
            } else
            {
                l = 0L;
            }
            if ((double)(SystemClock.elapsedRealtime() - l) >= FID_EXPIRATION)
            {
                Log.d("AdManager", (new StringBuilder()).append("Release FID: ").append(s).toString());
                fidTimeElapse.remove(s);
                listiterator.remove();
            } else
            if (s != null)
            {
                ((LinkedList) (obj)).add(s);
            }
        } while (true);
        int i = 0;
        String as[] = new String[((LinkedList) (obj)).size()];
        for (obj = ((LinkedList) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            as[i] = (String)((Iterator) (obj)).next();
            i++;
        }

        return as;
    }

    public static AdManager getInstance()
    {
        if (instance == null)
        {
            instance = new AdManager();
        }
        return instance;
    }

    private boolean getOnWifi()
    {
        return (NetworkUtil.networkStatus(appContext) & 2) != 0;
    }

    private int getStatus(Exception exception)
    {
        byte byte1 = -2;
        byte byte0 = byte1;
        if (exception instanceof WebException)
        {
            byte0 = byte1;
            if (((WebException)exception).getStatusCode() == 3)
            {
                byte0 = -3;
            }
        }
        return byte0;
    }

    public static boolean isActive()
    {
        return instance != null && state != 0 && state != 0;
    }

    private void releaseAds(boolean flag)
    {
        Object obj;
        Object obj1 = (new StringBuilder()).append("Releasing ");
        if (flag)
        {
            obj = "preroll";
        } else
        {
            obj = "inline";
        }
        Log.d("AdManager", ((StringBuilder) (obj1)).append(((String) (obj))).append(" ads").toString());
        obj1 = downloader;
        if (!flag) goto _L2; else goto _L1
_L1:
        obj = adPreRoll;
_L3:
        ((DownloadManager) (obj1)).releaseAds(((List) (obj)));
_L4:
        IOException ioexception;
        StringBuilder stringbuilder;
        if (flag)
        {
            adPreRoll = null;
        } else
        {
            adBreaks = null;
        }
        cache.cleanCache(false);
        return;
_L2:
        obj = adBreaks;
          goto _L3
        ioexception;
        stringbuilder = (new StringBuilder()).append("Exception releasing ");
        if (flag)
        {
            ioexception = "preroll";
        } else
        {
            ioexception = "inline";
        }
        Log.e("DownloadManager", stringbuilder.append(ioexception).append(" ads").toString());
          goto _L4
    }

    private void sendEvent(int i, int j)
    {
        sendEvent(i, j, null);
    }

    private void sendEvent(int i, int j, Exception exception)
    {
        if (activeClient != null)
        {
            Message.obtain(activeClient.gethandler(), i, j, 0, exception).sendToTarget();
        } else
        if (backgroundClient != null)
        {
            Message.obtain(backgroundClient.gethandler(), i, j, 0, exception).sendToTarget();
            return;
        }
    }

    private void stopService()
    {
        try
        {
            if (adBreaks != null)
            {
                downloader.releaseAds(adBreaks);
                adBreaks = null;
            }
            if (adPreRoll != null)
            {
                downloader.releaseAds(adPreRoll);
                adPreRoll = null;
            }
            if (cache != null)
            {
                cache.stopCache();
                cache = null;
            }
            if (logger != null)
            {
                logger.stopLogger();
                logger = null;
            }
            if (location != null)
            {
                location.stopTracker();
                location = null;
            }
            fidTimeElapse = new HashMap();
            fidList = new LinkedList();
        }
        catch (Exception exception)
        {
            Log.e("AdManager", (new StringBuilder()).append("Exception during shutdown: ").append(exception.getMessage()).toString());
        }
        downloader = null;
        thread = null;
        currentAd = null;
    }

    public void enterActivity(AdClientImpl adclientimpl)
    {
        for (activeClient = adclientimpl; handler == null || backgroundClient != null;)
        {
            return;
        }

        startRefresh();
    }

    public void enterService(AdClientImpl adclientimpl)
    {
        for (backgroundClient = adclientimpl; handler == null || activeClient != null;)
        {
            return;
        }

        startRefresh();
    }

    public AdClientImpl getActiveClient()
    {
        return activeClient;
    }

    public int[] getAdLengths()
    {
        List list = adBreaks;
        int ai[];
        if (list != null)
        {
            int ai1[] = new int[list.size()];
            int i = 0;
            do
            {
                ai = ai1;
                if (i >= list.size())
                {
                    break;
                }
                ai1[i] = ((AdBreak)list.get(i)).getDuration();
                i++;
            } while (true);
        } else
        {
            ai = null;
        }
        return ai;
    }

    public AdSettings getAdSettings()
    {
        return adSettings;
    }

    public AdClientImpl getClient(int i)
    {
        if (activeClient != null && activeClient.getId() == i)
        {
            return activeClient;
        }
        if (lastClient != null && lastClient.getId() == i)
        {
            return lastClient;
        } else
        {
            return new AdClientImpl(i);
        }
    }

    public AdBreak getCurrentAd()
    {
        return currentAd;
    }

    public DownloadManager getDownloader()
    {
        return downloader;
    }

    public TSContentSize getImageSize()
    {
        int i;
label0:
        {
            TSContentSize tscontentsize = adSettings.getContentSize();
            Object obj = tscontentsize;
            if (tscontentsize == TSContentSize.TSContentSizeDefault)
            {
                obj = new DisplayMetrics();
                ((WindowManager)appContext.getSystemService("window")).getDefaultDisplay().getMetrics(((DisplayMetrics) (obj)));
                i = Math.min(((DisplayMetrics) (obj)).widthPixels, ((DisplayMetrics) (obj)).heightPixels);
                if (i > 240)
                {
                    break label0;
                }
                obj = TSContentSize.TSContentSizeSmall;
            }
            return ((TSContentSize) (obj));
        }
        if (i <= 320)
        {
            return TSContentSize.TSContentSizeMedium;
        } else
        {
            return TSContentSize.TSContentSizeLarge;
        }
    }

    public LoggingManager getLogger()
    {
        return logger;
    }

    public String getUserId()
    {
        return userId;
    }

    public boolean isAdAvailable(boolean flag)
    {
        if (!flag) goto _L2; else goto _L1
_L1:
        if (adPreRoll == null) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (adBreaks == null)
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public boolean isHoursValid(int ai[])
    {
        int k;
        boolean flag1;
        flag1 = false;
        k = (new Date()).getHours();
        if (ai[0] != -1) goto _L2; else goto _L1
_L1:
        boolean flag = true;
_L4:
        Object obj;
        obj = "";
        for (int i = 0; i < ai.length; i++)
        {
            obj = (new StringBuilder()).append(((String) (obj))).append(ai[i]).append(" ").toString();
        }

        break MISSING_BLOCK_LABEL_126;
_L2:
        if (ai.length != 2 || ai[0] != 0 || ai[1] != -1)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = true;
        if (true) goto _L4; else goto _L3
_L3:
        int j = 0;
        do
        {
            flag = flag1;
            if (j >= ai.length)
            {
                break;
            }
            if (ai[j] == k)
            {
                flag1 = true;
            }
            j++;
        } while (true);
        if (true) goto _L4; else goto _L5
_L5:
        obj = (new StringBuilder()).append("Hours: ").append(((String) (obj)).trim()).append(" (Valid:");
        if (flag)
        {
            ai = "YES";
        } else
        {
            ai = "NO";
        }
        Log.d("AdManager", ((StringBuilder) (obj)).append(ai).append(")").toString());
        return flag;
    }

    public boolean isManagedMode()
    {
        return adSettings.isManagedMode();
    }

    public void leaveActivity(AdClientImpl adclientimpl)
    {
        lastClient = adclientimpl;
        activeClient = null;
        if (handler != null && backgroundClient == null)
        {
            stopRefresh();
        }
    }

    public void leaveService(AdClientImpl adclientimpl)
    {
        backgroundClient = null;
        if (handler != null && activeClient == null)
        {
            stopRefresh();
        }
    }

    public void logAdClicked(AdSegment adsegment)
    {
        logger.logImpression(adsegment.getClickThrough());
    }

    public void logAdPlayed(AdSegment adsegment)
    {
        logger.logImpression(adsegment);
    }

    public void onReceive(Context context, Intent intent)
    {
        boolean flag = intent.getBooleanExtra("noConnectivity", false);
        context = (NetworkInfo)intent.getParcelableExtra("networkInfo");
        if (!flag)
        {
            if (context.getType() == 0 || context.getType() == 1)
            {
                Log.d("AdManager", "Network connection restored");
                networkConnection = true;
                if (state == 1 && adBreaks == null && lastRefresh == 0L)
                {
                    handler.removeMessages(2, this);
                    context = handler.obtainMessage(2, this);
                    handler.sendMessageDelayed(context, 15000L);
                }
            }
        } else
        if (context.getType() == 0 || context.getType() == 1)
        {
            Log.d("AdManager", "Network connection lost");
            networkConnection = false;
            return;
        }
    }

    public void playbackEnd(boolean flag)
    {
        if (state == 5 || state == 0)
        {
            return;
        }
        if (adSettings.isBackToBackMode() && state != 4)
        {
            Log.d("AdManager", "Back-to-Back Mode");
            Iterator iterator = adBreaks.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                if ((AdBreak)iterator.next() != currentAd)
                {
                    continue;
                }
                iterator.remove();
                break;
            } while (true);
            if (adBreaks.size() > 0)
            {
                String s;
                for (Iterator iterator1 = currentAd.getSegments().iterator(); iterator1.hasNext(); fidTimeElapse.put(s, Long.valueOf(SystemClock.elapsedRealtime())))
                {
                    s = ((AdSegment)iterator1.next()).getAdId();
                    fidList.add(s);
                }

                state = 1;
                return;
            }
        }
        handler.removeMessages(2, this);
        Object obj1 = (new StringBuilder()).append("Ad playback ");
        Object obj;
        if (state == 4)
        {
            obj = "(preroll) ";
        } else
        {
            obj = "(inline) ";
        }
        obj1 = ((StringBuilder) (obj1)).append(((String) (obj)));
        if (flag)
        {
            obj = "finished";
        } else
        {
            obj = "stopped";
        }
        Log.d("AdManager", ((StringBuilder) (obj1)).append(((String) (obj))).toString());
        if (state != 4) goto _L2; else goto _L1
_L1:
        obj = currentAd.getSegments().iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            obj1 = ((AdSegment)((Iterator) (obj)).next()).getAdId();
            fidTimeElapse.put(obj1, Long.valueOf(SystemClock.elapsedRealtime()));
            if (!fidList.contains(obj1))
            {
                fidList.add(obj1);
            }
        } while (true);
        releaseAds(true);
        Message message = handler.obtainMessage(2, this);
        handler.sendMessage(message);
_L4:
        clearState();
        return;
_L2:
        if (state == 3)
        {
            Message message1 = handler.obtainMessage(2, this);
            handler.sendMessage(message1);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public AdBreak playbackStart(boolean flag, int i)
    {
label0:
        {
            Object obj2 = (new StringBuilder()).append("playbackStart - ");
            Object obj;
            if (flag)
            {
                obj = " preroll";
            } else
            {
                obj = " inline";
            }
            Log.d("AdManager", ((StringBuilder) (obj2)).append(((String) (obj))).append(" ad").toString());
            if (state != 1)
            {
                return null;
            }
            handler.removeMessages(2, this);
            StringBuilder stringbuilder1;
            boolean flag1;
            if (flag)
            {
                obj = adPreRoll;
            } else
            {
                obj = adBreaks;
            }
            if (obj == null)
            {
                break label0;
            }
            obj = ((List) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
                obj2 = (AdBreak)((Iterator) (obj)).next();
                flag1 = isHoursValid(((AdBreak) (obj2)).getValidHour());
            } while (((AdBreak) (obj2)).getDuration() != i || !flag1);
            stringbuilder1 = (new StringBuilder()).append("Returning ");
            if (flag)
            {
                obj = "preroll";
            } else
            {
                obj = "inline";
            }
            Log.d("AdManager", stringbuilder1.append(((String) (obj))).append(" ad for playback").toString());
            currentAd = ((AdBreak) (obj2));
            if (flag)
            {
                i = 4;
            } else
            {
                i = 3;
            }
            state = i;
            logger.logTracking(((AdBreak) (obj2)));
            return ((AdBreak) (obj2));
        }
        Object obj1 = (new StringBuilder()).append("Number of ad breaks: ");
        StringBuilder stringbuilder;
        int j;
        if (adBreaks != null)
        {
            j = adBreaks.size();
        } else
        {
            j = 0;
        }
        Log.d("AdManager", ((StringBuilder) (obj1)).append(j).toString());
        obj1 = handler.obtainMessage(2, this);
        handler.sendMessage(((Message) (obj1)));
        stringbuilder = (new StringBuilder()).append("No");
        if (flag)
        {
            obj1 = " preroll";
        } else
        {
            obj1 = " inline";
        }
        Log.d("AdManager", stringbuilder.append(((String) (obj1))).append(" ads available for playback").toString());
        logger.logUnfilled(adSettings, userId, i, lastLocation, flag);
        return null;
    }

    public void refreshAds()
    {
        Log.d("AdManager", "Start refreshAds");
        Message message = handler.obtainMessage(2, this);
        state = 2;
        if (currentAd != null)
        {
            Iterator iterator = currentAd.getSegments().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                AdSegment adsegment = (AdSegment)iterator.next();
                Log.d("AdManager", (new StringBuilder()).append("currentAd adId: ").append(adsegment.getAdId()).toString());
                fidTimeElapse.put(adsegment.getAdId(), Long.valueOf(SystemClock.elapsedRealtime()));
                if (!fidList.contains(adsegment.getAdId()))
                {
                    fidList.add(adsegment.getAdId());
                }
            } while (true);
        }
        if (failedAds != null)
        {
            String as[] = failedAds;
            int k = as.length;
            for (int i = 0; i < k; i++)
            {
                String s = as[i];
                fidTimeElapse.put(s, Long.valueOf(SystemClock.elapsedRealtime()));
                if (!fidList.contains(s))
                {
                    fidList.add(s);
                }
            }

        }
        DateFormat dateformat = DateFormat.getTimeInstance(2);
        Log.d("AdManager", (new StringBuilder()).append("Refreshing ads at ").append(dateformat.format(new Date())).toString());
        sendEvent(8, 0);
        try
        {
            if (adBreaks != null)
            {
                downloader.releaseAds(adBreaks);
                adBreaks = null;
            }
            String as1[] = getFids();
            lastLocation = location.getLocation();
            List list = WebService.requestAds(adSettings, userId, -1, false, getImageSize(), lastLocation, getOnWifi(), as1);
            downloader.prepareAds(list);
            adBreaks = list;
            cache.cleanCache(false);
            lastRefresh = SystemClock.uptimeMillis();
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            Log.d("AdManager", (new StringBuilder()).append("Download error for adId: ").append(filenotfoundexception.getMessage()).toString());
            adBreaks = null;
            int j = 0;
            String as2[];
            if (failedAds != null)
            {
                as2 = new String[failedAds.length + 1];
                String as3[] = failedAds;
                int i1 = as3.length;
                int l = 0;
                for (j = 0; l < i1; j++)
                {
                    as2[j] = as3[l];
                    l++;
                }

            } else
            {
                as2 = new String[1];
            }
            as2[j] = filenotfoundexception.getMessage();
            failedAds = as2;
            failedAttempts = failedAttempts + 1;
            clearState();
            sendEvent(7, -2, filenotfoundexception);
            lastRefresh = 0L;
            if (failedAttempts <= 3)
            {
                refreshAds();
                return;
            } else
            {
                handler.sendMessageDelayed(message, 0x493e0L);
                return;
            }
        }
        catch (Exception exception)
        {
            Log.d("AdManager", (new StringBuilder()).append("Unable to refresh ads: ").append(exception.getMessage()).toString());
            adBreaks = null;
            if (getStatus(exception) == -3)
            {
                handler.sendMessageDelayed(message, 0x1b7740L);
                lastRefresh = SystemClock.uptimeMillis();
            } else
            {
                handler.sendMessageDelayed(message, 0x493e0L);
                lastRefresh = 0L;
            }
            clearState();
            sendEvent(7, getStatus(exception), exception);
            return;
        }
        failedAttempts = 0;
        handler.sendMessageDelayed(message, 0x1b7740L);
        clearState();
        sendEvent(5, 0);
    }

    public void requestAd(boolean flag, int i)
    {
        if (state != 0 && handler != null)
        {
            Object obj = handler;
            int j;
            if (flag)
            {
                j = 1;
            } else
            {
                j = 0;
            }
            obj = ((Handler) (obj)).obtainMessage(4, j, i);
            handler.sendMessage(((Message) (obj)));
        }
    }

    public void startAdSession(Context context, AdSettings adsettings)
    {
        if (state != 0)
        {
            break MISSING_BLOCK_LABEL_243;
        }
        Context context1 = context;
        if (context instanceof Activity)
        {
            context1 = context.getApplicationContext();
        }
        appContext = context1;
        adSettings = adsettings;
        state = 1;
        lastRefresh = 0L;
        downloader = new DownloadManager(context1);
        logger = new LoggingManager(context1);
        cache = new CacheManager(context1);
        location = new LocationTracker(context1);
        userId = appContext.getSharedPreferences("AdManager", 0).getString("userId", "");
        if (userId.length() == 0)
        {
            createUserId();
        }
        Log.d("AdManager", (new StringBuilder()).append("userId: ").append(userId).toString());
        location.startTracker(adsettings);
        thread = new ManagerThread();
        thread.start();
        context = ((Context) (notify));
        context;
        JVM INSTR monitorenter ;
        if (handler == null)
        {
            notify.wait();
        }
_L1:
        return;
        adsettings;
        Log.e("AdManager", (new StringBuilder()).append("Unexpected error waiting for service thread to start: ").append(adsettings.getMessage()).toString());
          goto _L1
        adsettings;
        context;
        JVM INSTR monitorexit ;
        throw adsettings;
    }

    void startRefresh()
    {
        Log.d("AdManager", "Starting ad refresh loop");
        Message message = handler.obtainMessage(2, this);
        if (adBreaks != null && SystemClock.uptimeMillis() - lastRefresh < 0x1b7740L)
        {
            sendEvent(5, 0);
            handler.sendMessageAtTime(message, lastRefresh + 0x1b7740L);
        } else
        {
            handler.sendMessage(message);
            lastRefresh = 1L;
        }
        appContext.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void stopAdSession()
    {
        if (state != 0)
        {
            if (activeClient != null && (state == 3 || state == 4))
            {
                activeClient.hideInlineAd();
            }
            state = 5;
            stopRefresh();
            handler.sendEmptyMessage(1);
            thread = null;
        }
    }

    void stopRefresh()
    {
        Log.d("AdManager", "Stopping ad refresh loop");
        handler.removeMessages(2, this);
        try
        {
            appContext.unregisterReceiver(this);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }





/*
    static Handler access$102(AdManager admanager, Handler handler1)
    {
        admanager.handler = handler1;
        return handler1;
    }

*/







/*
    static int access$702(int i)
    {
        state = i;
        return i;
    }

*/
}
