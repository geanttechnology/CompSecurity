// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.text.TextUtils;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.utils.EnvironmentUtils;
import com.millennialmedia.internal.utils.HttpUtils;
import com.millennialmedia.internal.utils.IOUtils;
import com.millennialmedia.internal.utils.ThreadUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.millennialmedia.internal:
//            PlayList, Handshake

public class AdPlacementReporter
{
    public static class ElapsedTimer
    {

        private long endTime;
        private long startTime;

        public long getElapsedTime()
        {
            if (endTime == 0L)
            {
                stop();
            }
            return endTime - startTime;
        }

        public void start()
        {
            startTime = SystemClock.elapsedRealtime();
            endTime = 0L;
        }

        public void stop()
        {
            endTime = SystemClock.elapsedRealtime();
        }

        public ElapsedTimer()
        {
        }
    }

    public class PlayListItemReporter
    {

        public String buyer;
        private ElapsedTimer elapsedTimer;
        public String itemId;
        public String pru;
        public int status;
        final AdPlacementReporter this$0;


        PlayListItemReporter()
        {
            this$0 = AdPlacementReporter.this;
            super();
            elapsedTimer = new ElapsedTimer();
            elapsedTimer.start();
        }
    }

    static final class UploadState extends Enum
    {

        private static final UploadState $VALUES[];
        public static final UploadState ERROR_NETWORK_UNAVAILABLE;
        public static final UploadState ERROR_SENDING_TO_SERVER;
        public static final UploadState IDLE;
        public static final UploadState UPLOADING;

        public static UploadState valueOf(String s)
        {
            return (UploadState)Enum.valueOf(com/millennialmedia/internal/AdPlacementReporter$UploadState, s);
        }

        public static UploadState[] values()
        {
            return (UploadState[])$VALUES.clone();
        }

        static 
        {
            IDLE = new UploadState("IDLE", 0);
            UPLOADING = new UploadState("UPLOADING", 1);
            ERROR_NETWORK_UNAVAILABLE = new UploadState("ERROR_NETWORK_UNAVAILABLE", 2);
            ERROR_SENDING_TO_SERVER = new UploadState("ERROR_SENDING_TO_SERVER", 3);
            $VALUES = (new UploadState[] {
                IDLE, UPLOADING, ERROR_NETWORK_UNAVAILABLE, ERROR_SENDING_TO_SERVER
            });
        }

        private UploadState(String s, int i)
        {
            super(s, i);
        }
    }

    static class Uploader
    {

        private static String buildRequest(File afile[])
        {
            JSONObject jsonobject;
            JSONArray jsonarray;
            JSONArray jsonarray1;
            JSONArray jsonarray2;
            JSONObject jsonobject1;
            Object obj;
            int i;
            jsonobject = new JSONObject();
            jsonarray = new JSONArray();
            jsonarray1 = new JSONArray();
            jsonarray2 = new JSONArray();
            int j;
            try
            {
                j = afile.length;
            }
            // Misplaced declaration of an exception variable
            catch (File afile[])
            {
                MMLog.e(AdPlacementReporter.TAG, "Error creating SSP reporting request", afile);
                return null;
            }
            i = 0;
_L2:
            if (i >= j)
            {
                break MISSING_BLOCK_LABEL_145;
            }
            obj = afile[i];
            jsonobject1 = retrieveEvent(((File) (obj)));
            if (jsonobject1 == null)
            {
                break MISSING_BLOCK_LABEL_247;
            }
            obj = ((File) (obj)).getName();
            if (((String) (obj)).startsWith("request_"))
            {
                jsonarray.put(jsonobject1);
                break MISSING_BLOCK_LABEL_247;
            }
            if (((String) (obj)).startsWith("display_"))
            {
                jsonarray1.put(jsonobject1);
                break MISSING_BLOCK_LABEL_247;
            }
            if (((String) (obj)).startsWith("click_"))
            {
                jsonarray2.put(jsonobject1);
            }
            break MISSING_BLOCK_LABEL_247;
            if (jsonarray.length() > 0)
            {
                jsonobject.put("req", jsonarray);
            }
            if (jsonarray1.length() > 0)
            {
                jsonobject.put("display", jsonarray1);
            }
            if (jsonarray2.length() > 0)
            {
                jsonobject.put("click", jsonarray2);
            }
            try
            {
                afile = jsonobject.toString(2);
            }
            // Misplaced declaration of an exception variable
            catch (File afile[])
            {
                afile = "Unable to format report with indentation";
            }
            if (MMLog.isDebugEnabled() && MMLog.isDebugEnabled())
            {
                MMLog.d(AdPlacementReporter.TAG, (new StringBuilder()).append("Generated report.\n").append(afile).toString());
            }
            return jsonobject.toString();
            i++;
            if (true) goto _L2; else goto _L1
_L1:
        }

        private static void countQueuedEvents()
        {
            File afile[] = AdPlacementReporter.reportingDir.listFiles();
            int k = 0;
            int l = afile.length;
            int j = 0;
            while (j < l) 
            {
                File file = afile[j];
                int i;
                if (file.getName().endsWith(".tmp"))
                {
                    i = k;
                    if (setEventAsCompleted(file, false))
                    {
                        i = k + 1;
                    }
                } else
                {
                    i = k;
                    if (file.getName().endsWith(".json"))
                    {
                        i = k + 1;
                    }
                }
                j++;
                k = i;
            }
            AdPlacementReporter.numQueuedEvents.set(k);
        }

        private static void deleteUploadedEvents(File afile[])
        {
            int j = 0;
            int k = afile.length;
            int i = 0;
            while (i < k) 
            {
                File file = afile[i];
                if (!file.delete())
                {
                    MMLog.e(AdPlacementReporter.TAG, (new StringBuilder()).append("Failed to delete reporting file <").append(file.getName()).append(">").toString());
                } else
                {
                    j--;
                }
                i++;
            }
            AdPlacementReporter.numQueuedEvents.addAndGet(j);
        }

        private static File[] getEventsToUpload()
        {
            return AdPlacementReporter.reportingDir.listFiles(new FilenameFilter() {

                public boolean accept(File file, String s)
                {
                    return s.endsWith(".json");
                }

            });
        }

        private static void incrementQueuedEventsCount()
        {
            synchronized (AdPlacementReporter.stateLock)
            {
                int i = AdPlacementReporter.numQueuedEvents.incrementAndGet();
                if (AdPlacementReporter.uploadState == UploadState.IDLE && i >= Handshake.getReportingBatchSize())
                {
                    if (MMLog.isDebugEnabled())
                    {
                        MMLog.d(AdPlacementReporter.TAG, "Reporting batch size limit detected -- requesting upload");
                    }
                    setUploadState(UploadState.UPLOADING);
                }
            }
            return;
            exception;
            obj;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public static String readFromFile(File file)
        {
            Object obj;
            Object obj3;
            Object obj4;
            Object obj1 = null;
            obj3 = null;
            obj4 = null;
            obj = obj4;
            if (!file.exists())
            {
                break MISSING_BLOCK_LABEL_43;
            }
            obj = obj1;
            Object obj2 = new FileInputStream(file);
            obj = IOUtils.read(((java.io.InputStream) (obj2)), "UTF-8");
            if (obj2 == null)
            {
                break MISSING_BLOCK_LABEL_234;
            }
            try
            {
                ((FileInputStream) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj2)
            {
                MMLog.e(AdPlacementReporter.TAG, (new StringBuilder()).append("Failed to close file <").append(file.getName()).append(">").toString(), ((Throwable) (obj2)));
                return ((String) (obj));
            }
_L2:
            return ((String) (obj));
            obj;
            obj2 = obj3;
            obj3 = obj;
_L5:
            obj = obj2;
            MMLog.e(AdPlacementReporter.TAG, (new StringBuilder()).append("Error opening file <").append(file.getName()).append(">").toString(), ((Throwable) (obj3)));
            obj = obj4;
            if (obj2 == null) goto _L2; else goto _L1
_L1:
            try
            {
                ((FileInputStream) (obj2)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                MMLog.e(AdPlacementReporter.TAG, (new StringBuilder()).append("Failed to close file <").append(file.getName()).append(">").toString(), ((Throwable) (obj)));
                return null;
            }
            return null;
            obj2;
_L4:
            if (obj != null)
            {
                try
                {
                    ((FileInputStream) (obj)).close();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    MMLog.e(AdPlacementReporter.TAG, (new StringBuilder()).append("Failed to close file <").append(file.getName()).append(">").toString(), ((Throwable) (obj)));
                }
            }
            throw obj2;
            obj3;
            obj = obj2;
            obj2 = obj3;
            if (true) goto _L4; else goto _L3
_L3:
            obj3;
              goto _L5
            return ((String) (obj));
        }

        private static JSONObject retrieveEvent(File file)
        {
            Object obj = null;
            if (file.exists())
            {
                obj = readFromFile(file);
                try
                {
                    obj = new JSONObject(((String) (obj)));
                }
                catch (JSONException jsonexception)
                {
                    MMLog.e(AdPlacementReporter.TAG, (new StringBuilder()).append("Error parsing reporting file <").append(file.getName()).append(">").toString(), jsonexception);
                    return null;
                }
            }
            return ((JSONObject) (obj));
        }

        private static String retrieveSiteId()
        {
            return readFromFile(new File(AdPlacementReporter.reportingDir, "siteid"));
        }

        public static boolean saveToFile(File file, String s)
        {
            Object obj;
            Object obj2;
            boolean flag;
            flag = false;
            obj = null;
            obj2 = null;
            Object obj1 = new FileOutputStream(file);
            IOUtils.write(((java.io.OutputStream) (obj1)), s);
            if (obj1 == null)
            {
                break MISSING_BLOCK_LABEL_224;
            }
            try
            {
                ((FileOutputStream) (obj1)).close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                MMLog.e(AdPlacementReporter.TAG, (new StringBuilder()).append("Failed to close file <").append(file.getName()).append(">").toString(), s);
                return false;
            }
            flag = true;
_L2:
            return flag;
            obj1;
            s = obj2;
_L5:
            obj = s;
            MMLog.e(AdPlacementReporter.TAG, (new StringBuilder()).append("Error writing to file <").append(file.getName()).append(">").toString(), ((Throwable) (obj1)));
            if (s == null) goto _L2; else goto _L1
_L1:
            try
            {
                s.close();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                MMLog.e(AdPlacementReporter.TAG, (new StringBuilder()).append("Failed to close file <").append(file.getName()).append(">").toString(), s);
                return false;
            }
            return true;
            s;
_L4:
            if (obj != null)
            {
                try
                {
                    ((FileOutputStream) (obj)).close();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    MMLog.e(AdPlacementReporter.TAG, (new StringBuilder()).append("Failed to close file <").append(file.getName()).append(">").toString(), ((Throwable) (obj)));
                }
            }
            throw s;
            s;
            obj = obj1;
            if (true) goto _L4; else goto _L3
_L3:
            Exception exception;
            exception;
            s = ((String) (obj1));
            obj1 = exception;
              goto _L5
            return false;
        }

        private static boolean setEventAsCompleted(File file, boolean flag)
        {
            File file1 = new File(file.getPath().replace(".tmp", ".json"));
            if (file1.exists())
            {
                MMLog.w(AdPlacementReporter.TAG, (new StringBuilder()).append("Target file already exists + <").append(file1.getName()).append(">").toString());
            } else
            if (file.renameTo(file1))
            {
                if (flag)
                {
                    incrementQueuedEventsCount();
                }
                return true;
            }
            MMLog.w(AdPlacementReporter.TAG, (new StringBuilder()).append("Unable to rename temp file <").append(file.getName()).append(">").toString());
            if (!file.delete())
            {
                MMLog.e(AdPlacementReporter.TAG, (new StringBuilder()).append("Error deleting temp file <").append(file.getName()).append(">").toString());
            }
            return false;
        }

        static void setUploadState(UploadState uploadstate)
        {
label0:
            {
                synchronized (AdPlacementReporter.stateLock)
                {
                    if (uploadstate != AdPlacementReporter.uploadState)
                    {
                        break label0;
                    }
                }
                return;
            }
            AdPlacementReporter.uploadState = uploadstate;
            obj;
            JVM INSTR monitorexit ;
            static class _cls1
            {

                static final int $SwitchMap$com$millennialmedia$internal$AdPlacementReporter$UploadState[];

                static 
                {
                    $SwitchMap$com$millennialmedia$internal$AdPlacementReporter$UploadState = new int[UploadState.values().length];
                    try
                    {
                        $SwitchMap$com$millennialmedia$internal$AdPlacementReporter$UploadState[UploadState.IDLE.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$millennialmedia$internal$AdPlacementReporter$UploadState[UploadState.UPLOADING.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$millennialmedia$internal$AdPlacementReporter$UploadState[UploadState.ERROR_NETWORK_UNAVAILABLE.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$millennialmedia$internal$AdPlacementReporter$UploadState[UploadState.ERROR_SENDING_TO_SERVER.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls1..SwitchMap.com.millennialmedia.internal.AdPlacementReporter.UploadState[AdPlacementReporter.uploadState.ordinal()])
            {
            default:
                return;

            case 1: // '\001'
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(AdPlacementReporter.TAG, "Reporting upload state set to IDLE");
                }
                AdPlacementReporter.scheduledRunnable = ThreadUtils.runOnWorkerThreadDelayed(new Runnable() {

                    public void run()
                    {
                        if (MMLog.isDebugEnabled())
                        {
                            MMLog.d(AdPlacementReporter.TAG, "Reporting batch frequency detected -- requesting upload");
                        }
                        Uploader.setUploadState(UploadState.UPLOADING);
                    }

                }, Handshake.getReportingBatchFrequency());
                return;

            case 2: // '\002'
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(AdPlacementReporter.TAG, "Reporting upload state set to UPLOADING");
                }
                if (AdPlacementReporter.scheduledRunnable != null)
                {
                    AdPlacementReporter.scheduledRunnable.cancel();
                }
                uploadNow();
                return;

            case 3: // '\003'
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(AdPlacementReporter.TAG, "Reporting upload state set to ERROR_NETWORK_UNAVAILABLE");
                }
                EnvironmentUtils.getApplicationContext().registerReceiver(new BroadcastReceiver() {

                    public void onReceive(Context context, Intent intent)
                    {
                        if (EnvironmentUtils.isNetworkAvailable())
                        {
                            if (MMLog.isDebugEnabled())
                            {
                                MMLog.d(AdPlacementReporter.TAG, "Reporting detected network is now available -- requesting upload");
                            }
                            EnvironmentUtils.getApplicationContext().unregisterReceiver(this);
                            Uploader.setUploadState(UploadState.UPLOADING);
                        }
                    }

                }, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                return;

            case 4: // '\004'
                break;
            }
            break MISSING_BLOCK_LABEL_177;
            uploadstate;
            obj;
            JVM INSTR monitorexit ;
            throw uploadstate;
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(AdPlacementReporter.TAG, "Reporting upload state set to ERROR_SENDING_TO_SERVER");
            }
            AdPlacementReporter.scheduledRunnable = ThreadUtils.runOnWorkerThreadDelayed(new Runnable() {

                public void run()
                {
                    if (MMLog.isDebugEnabled())
                    {
                        MMLog.d(AdPlacementReporter.TAG, "Reporting batch frequency detected -- requesting upload");
                    }
                    Uploader.setUploadState(UploadState.UPLOADING);
                }

            }, Handshake.getReportingBatchFrequency());
            return;
        }

        private static void start()
        {
            AdPlacementReporter.reportingDir = new File((new StringBuilder()).append(EnvironmentUtils.getMillennialDir()).append("/.reporting/").toString());
            AdPlacementReporter.reportingDir.mkdirs();
            if (!AdPlacementReporter.reportingDir.isDirectory())
            {
                MMLog.e(AdPlacementReporter.TAG, "Unable to creating reporting directory");
                return;
            } else
            {
                countQueuedEvents();
                AdPlacementReporter.scheduledRunnable = ThreadUtils.runOnWorkerThreadDelayed(new Runnable() {

                    public void run()
                    {
                        if (MMLog.isDebugEnabled())
                        {
                            MMLog.d(AdPlacementReporter.TAG, "Reporting startup -- requesting upload");
                        }
                        Uploader.setUploadState(UploadState.UPLOADING);
                    }

                }, 5000L);
                return;
            }
        }

        private static File storeEvent(String s, String s1, JSONObject jsonobject, boolean flag)
        {
            if (s1 == null)
            {
                s = null;
            } else
            {
                s1 = (new StringBuilder()).append(s).append(s1);
                if (flag)
                {
                    s = ".json";
                } else
                {
                    s = ".tmp";
                }
                s = s1.append(s).toString();
                s1 = new File(AdPlacementReporter.reportingDir, s);
                s = s1;
                if (saveToFile(s1, jsonobject.toString()))
                {
                    s = s1;
                    if (flag)
                    {
                        incrementQueuedEventsCount();
                        return s1;
                    }
                }
            }
            return s;
        }

        private static void storeSiteId(String s)
        {
            saveToFile(new File(AdPlacementReporter.reportingDir, "siteid"), s);
        }

        static void uploadNow()
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(AdPlacementReporter.TAG, "Reporting is starting upload");
            }
            ThreadUtils.runOnWorkerThread(new Runnable() {

                public void run()
                {
                    Object obj;
                    Object obj1;
                    String s;
                    obj = Uploader.getEventsToUpload();
                    obj1 = UploadState.IDLE;
                    s = Handshake.getReportingBaseUrl();
                    if (s == null)
                    {
                        MMLog.e(AdPlacementReporter.TAG, "Unable to determine base url for request");
                        return;
                    }
                    s = s.concat(AdPlacementReporter.SSP_REPORTING_PATH);
                    if (obj.length <= 0) goto _L2; else goto _L1
_L1:
                    obj1 = Uploader.retrieveSiteId();
                    if (TextUtils.isEmpty(((CharSequence) (obj1))))
                    {
                        MMLog.e(AdPlacementReporter.TAG, "Unable to upload report -- siteId has not been set");
                        obj = UploadState.ERROR_SENDING_TO_SERVER;
                    } else
                    {
                        String s1 = Uploader.buildRequest(((File []) (obj)));
                        obj1 = HttpUtils.getContentFromPostRequest((new StringBuilder()).append(s).append(AdPlacementReporter.SSP_SITE_ID_PARAMETER).append(((String) (obj1))).toString(), s1, "application/json");
                        if (((com.millennialmedia.internal.utils.HttpUtils.Response) (obj1)).code == 200)
                        {
                            if (MMLog.isDebugEnabled())
                            {
                                MMLog.d(AdPlacementReporter.TAG, (new StringBuilder()).append("Reporting successfully uploaded ").append(obj.length).append(" events").toString());
                            }
                            Uploader.deleteUploadedEvents(((File []) (obj)));
                            if (AdPlacementReporter.numQueuedEvents.get() >= Handshake.getReportingBatchSize())
                            {
                                Uploader.uploadNow();
                                return;
                            }
                            obj = UploadState.IDLE;
                        } else
                        if (!EnvironmentUtils.isNetworkAvailable())
                        {
                            MMLog.e(AdPlacementReporter.TAG, "Reporting failed to upload because network is unavailable");
                            obj = UploadState.ERROR_NETWORK_UNAVAILABLE;
                        } else
                        {
                            MMLog.e(AdPlacementReporter.TAG, (new StringBuilder()).append("Reporting failed to upload with response code <").append(((com.millennialmedia.internal.utils.HttpUtils.Response) (obj1)).code).append(">").toString());
                            obj = UploadState.ERROR_SENDING_TO_SERVER;
                        }
                    }
_L4:
                    Uploader.setUploadState(((UploadState) (obj)));
                    return;
_L2:
                    obj = obj1;
                    if (MMLog.isDebugEnabled())
                    {
                        MMLog.d(AdPlacementReporter.TAG, "Reporting found no events to upload");
                        obj = obj1;
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

            });
        }









        Uploader()
        {
        }
    }


    private static final String EVENT_CLICK = "click_";
    private static final String EVENT_DISPLAY = "display_";
    private static final String EVENT_REQUEST = "request_";
    private static final String EXTENSION_JSON = ".json";
    private static final String EXTENSION_TEMP = ".tmp";
    public static final String REPORTING_DIR = "/.reporting/";
    private static final String REPORT_KEY_ADNET = "adnet";
    private static final String REPORT_KEY_BUYER = "buyer";
    private static final String REPORT_KEY_CLICK = "click";
    private static final String REPORT_KEY_DISPLAY = "display";
    private static final String REPORT_KEY_ITEM_ID = "tag";
    private static final String REPORT_KEY_PLACEMENT_NAME = "zone";
    private static final String REPORT_KEY_PRU = "pru";
    private static final String REPORT_KEY_REQUEST = "req";
    private static final String REPORT_KEY_RESPONSE_ID = "a";
    private static final String REPORT_KEY_RESPONSE_TIME = "resp";
    private static final String REPORT_KEY_STATUS = "status";
    private static final String REPORT_KEY_TIMESTAMP = "ts";
    public static final String SITEID_FILENAME = "siteid";
    public static String SSP_REPORTING_PATH = "/admax/sdk/report/2";
    public static String SSP_SITE_ID_PARAMETER = "?dcn=";
    private static final int STARTUP_DELAY_IN_SECONDS = 5;
    public static final int STATUS_AD_SERVED = 1;
    public static final int STATUS_NO_AD = -1;
    public static final int STATUS_NO_AD_ERROR = -3;
    public static final int STATUS_NO_AD_TIMEOUT = -2;
    private static final String TAG = com/millennialmedia/internal/AdPlacementReporter.getSimpleName();
    private static volatile AtomicInteger numQueuedEvents = new AtomicInteger(0);
    private static volatile File reportingDir;
    private static volatile com.millennialmedia.internal.utils.ThreadUtils.ScheduledRunnable scheduledRunnable = null;
    private static final Object stateLock = new Object();
    private static volatile UploadState uploadState;
    private volatile PlayListItemReporter activePlayListItemReporter;
    private volatile String buyer;
    private boolean clickReported;
    private boolean displayReported;
    private volatile String eventId;
    private volatile String itemId;
    private volatile String placementName;
    private volatile ElapsedTimer playlistProcessingElapsedTimer;
    private volatile JSONObject playlistReportJson;
    private volatile String pru;
    private volatile String responseId;

    private AdPlacementReporter(PlayList playlist)
        throws Exception
    {
        clickReported = false;
        displayReported = false;
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Creating new reporting instance for responseId: ").append(playlist.responseId).toString());
        }
        Uploader.storeSiteId(playlist.siteId);
        if (!TextUtils.isEmpty(playlist.responseId))
        {
            eventId = UUID.randomUUID().toString();
        }
        responseId = playlist.responseId;
        placementName = playlist.placementName;
        playlistReportJson = new JSONObject();
        playlistReportJson.put("ts", System.currentTimeMillis());
        playlistReportJson.put("adnet", new JSONArray());
        playlistReportJson.put("a", responseId);
        playlistReportJson.put("zone", placementName);
        Uploader.storeEvent("request_", eventId, playlistReportJson, false);
        playlistProcessingElapsedTimer = new ElapsedTimer();
        playlistProcessingElapsedTimer.start();
    }

    public static PlayListItemReporter getPlayListItemReporter(AdPlacementReporter adplacementreporter)
    {
        if (adplacementreporter == null)
        {
            return null;
        } else
        {
            adplacementreporter.activePlayListItemReporter = adplacementreporter.getPlayListItemReporter();
            return adplacementreporter.activePlayListItemReporter;
        }
    }

    public static AdPlacementReporter getPlayListReporter(PlayList playlist)
    {
        if (!playlist.reportingEnabled)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        playlist = new AdPlacementReporter(playlist);
        return playlist;
        playlist;
        MMLog.e(TAG, "Error starting ad placement reporting");
        return null;
    }

    public static void init()
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, "Initializing");
        }
        Uploader.start();
    }

    public static void reportPlayList(AdPlacementReporter adplacementreporter)
    {
        if (adplacementreporter == null)
        {
            return;
        }
        if (adplacementreporter.activePlayListItemReporter != null)
        {
            adplacementreporter.activePlayListItemReporter.status = -2;
            reportPlayListItem(adplacementreporter, adplacementreporter.activePlayListItemReporter);
        }
        adplacementreporter.reportPlayList();
    }

    public static void reportPlayListItem(AdPlacementReporter adplacementreporter, PlayListItemReporter playlistitemreporter)
    {
        if (adplacementreporter != null)
        {
            if (adplacementreporter.activePlayListItemReporter != playlistitemreporter)
            {
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(TAG, "reportPlayListItem called but item is not the active item");
                    return;
                }
            } else
            {
                adplacementreporter.reportPlayListItem(playlistitemreporter);
                adplacementreporter.activePlayListItemReporter = null;
                return;
            }
        }
    }

    public static void reportPlayListItem(AdPlacementReporter adplacementreporter, PlayListItemReporter playlistitemreporter, int i)
    {
        if (playlistitemreporter == null)
        {
            return;
        } else
        {
            playlistitemreporter.status = i;
            reportPlayListItem(adplacementreporter, playlistitemreporter);
            return;
        }
    }

    public static void setClicked(AdPlacementReporter adplacementreporter)
    {
        if (adplacementreporter == null)
        {
            return;
        } else
        {
            adplacementreporter.setClicked();
            return;
        }
    }

    public static void setDisplayed(AdPlacementReporter adplacementreporter)
    {
        if (adplacementreporter == null)
        {
            return;
        } else
        {
            adplacementreporter.setDisplayed();
            return;
        }
    }

    PlayListItemReporter getPlayListItemReporter()
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Reporting playlist item start for responseId: ").append(responseId).toString());
        }
        return new PlayListItemReporter();
    }

    void reportPlayList()
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Reporting playlist stop for responseId: ").append(responseId).toString());
        }
        File file;
        try
        {
            playlistReportJson.put("resp", playlistProcessingElapsedTimer.getElapsedTime());
            file = Uploader.storeEvent("request_", eventId, playlistReportJson, false);
        }
        catch (Exception exception)
        {
            MMLog.e(TAG, "Error stopping playlist reporting");
            return;
        }
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        Uploader.setEventAsCompleted(file, true);
        playlistReportJson = null;
        return;
    }

    void reportPlayListItem(PlayListItemReporter playlistitemreporter)
    {
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("Reporting playlist item stop for responseId: ").append(responseId).toString());
        }
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("tag", playlistitemreporter.itemId);
            jsonobject.put("status", playlistitemreporter.status);
            jsonobject.put("resp", playlistitemreporter.elapsedTimer.getElapsedTime());
            if (playlistitemreporter.status == 1)
            {
                itemId = playlistitemreporter.itemId;
                buyer = playlistitemreporter.buyer;
                pru = playlistitemreporter.pru;
                playlistReportJson.put("buyer", buyer);
                playlistReportJson.put("pru", pru);
            }
            playlistReportJson.getJSONArray("adnet").put(jsonobject);
            Uploader.storeEvent("request_", eventId, playlistReportJson, false);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (PlayListItemReporter playlistitemreporter)
        {
            MMLog.e(TAG, "Error adding playlist item");
        }
    }

    void setClicked()
    {
        if (!clickReported)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TAG, (new StringBuilder()).append("Reporting ad clicked for responseId: ").append(responseId).toString());
            }
            try
            {
                JSONObject jsonobject = new JSONObject();
                jsonobject.put("a", responseId);
                jsonobject.put("ts", System.currentTimeMillis());
                jsonobject.put("zone", placementName);
                jsonobject.put("tag", itemId);
                Uploader.storeEvent("click_", eventId, jsonobject, true);
            }
            catch (Exception exception)
            {
                MMLog.e(TAG, "Error recording click");
            }
            clickReported = true;
        }
    }

    void setDisplayed()
    {
        if (!displayReported)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TAG, (new StringBuilder()).append("Reporting ad displayed for responseId: ").append(responseId).toString());
            }
            try
            {
                JSONObject jsonobject = new JSONObject();
                jsonobject.put("a", responseId);
                jsonobject.put("ts", System.currentTimeMillis());
                jsonobject.put("zone", placementName);
                jsonobject.put("tag", itemId);
                jsonobject.put("buyer", buyer);
                jsonobject.put("pru", pru);
                Uploader.storeEvent("display_", eventId, jsonobject, true);
            }
            catch (Exception exception)
            {
                MMLog.e(TAG, "Error recording display");
            }
            displayReported = true;
        }
    }

    static 
    {
        uploadState = UploadState.IDLE;
    }



/*
    static File access$002(File file)
    {
        reportingDir = file;
        return file;
    }

*/






/*
    static UploadState access$402(UploadState uploadstate)
    {
        uploadState = uploadstate;
        return uploadstate;
    }

*/



/*
    static com.millennialmedia.internal.utils.ThreadUtils.ScheduledRunnable access$502(com.millennialmedia.internal.utils.ThreadUtils.ScheduledRunnable scheduledrunnable)
    {
        scheduledRunnable = scheduledrunnable;
        return scheduledrunnable;
    }

*/
}
