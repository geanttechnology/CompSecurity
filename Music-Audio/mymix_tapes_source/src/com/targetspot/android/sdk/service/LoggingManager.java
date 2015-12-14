// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.service;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.targetspot.android.sdk.AdSettings;
import com.targetspot.android.sdk.util.NetworkUtil;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.targetspot.android.sdk.service:
//            WebService, WebException, AdBreak, AdSegment, 
//            AdLog, AdLink

public class LoggingManager
{
    class Impression extends LogInfo
    {

        final LoggingManager this$0;
        public String url;

        void fromJSON(JSONObject jsonobject)
            throws JSONException
        {
            url = jsonobject.getString("url");
            attempts = jsonobject.getInt("count");
        }

        JSONObject toJSON()
            throws JSONException
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("type", "impression");
            jsonobject.put("url", url);
            jsonobject.put("count", attempts);
            return jsonobject;
        }

        Impression()
        {
            this$0 = LoggingManager.this;
            super(0);
        }

        Impression(String s, int i)
        {
            this$0 = LoggingManager.this;
            super(i);
            url = s;
        }
    }

    abstract class LogInfo
    {

        int attempts;
        final LoggingManager this$0;

        abstract void fromJSON(JSONObject jsonobject)
            throws JSONException;

        abstract JSONObject toJSON()
            throws JSONException;

        LogInfo(int i)
        {
            this$0 = LoggingManager.this;
            super();
            attempts = i;
        }
    }

    class LoggerThread extends Thread
    {

        final LoggingManager this$0;

        public void run()
        {
            Looper.prepare();
            handler = new Handler() {

                final LoggerThread this$1;

                public void handleMessage(Message message)
                {
                    message.what;
                    JVM INSTR tableswitch 0 8: default 56
                //                               0 57
                //                               1 112
                //                               2 166
                //                               3 246
                //                               4 272
                //                               5 291
                //                               6 192
                //                               7 138
                //                               8 218;
                       goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10
_L1:
                    return;
_L2:
                    Log.d("LoggingManager", "Started (MSG_START)");
                    loadLogInfo();
                    if (logInfo.size() > 0)
                    {
                        handler.sendEmptyMessageDelayed(4, 0xdbba0L);
                        return;
                    }
                      goto _L1
_L3:
                    Log.d("LoggingManager", "Adding impression(s) (MSG_ADD)");
                    storeImpression((AdBreak)message.obj);
                    return;
_L9:
                    Log.d("LoggingManager", "Adding impression(s) (MSG_ADD_START)");
                    storeImpression((AdBreak)message.obj, "start");
                    return;
_L4:
                    Log.d("LoggingManager", "Adding impression url (MSG_ADD_LINK)");
                    storeImpression((AdLink)message.obj);
                    return;
_L8:
                    Log.d("LoggingManager", "Adding impression (MSG_ADD_SEGMENT)");
                    storeImpression((AdSegment)message.obj);
                    return;
_L10:
                    Log.d("LoggingManager", "Adding impression (MSG_ADD_SEGMENT_START)");
                    storeImpression((AdSegment)message.obj, "start");
                    return;
_L5:
                    Log.d("LoggingManager", "Adding unfilled (MSG_ADD_UNFILLED)");
                    storeUnfilled((Unfilled)message.obj);
                    return;
_L6:
                    Log.d("LoggingManager", "Check for network & send (MSG_SEND)");
                    sendLogInfo();
                    return;
_L7:
                    Log.d("LoggingManager", "Thread exit (MSG_QUIT)");
                    Looper.myLooper().quit();
                    return;
                }

            
            {
                this$1 = LoggerThread.this;
                super();
            }
            };
            handler.sendEmptyMessage(0);
            Looper.loop();
        }

        LoggerThread()
        {
            this$0 = LoggingManager.this;
            super();
        }
    }

    class Unfilled extends LogInfo
    {

        final LoggingManager this$0;
        public String url;

        void fromJSON(JSONObject jsonobject)
            throws JSONException
        {
            url = jsonobject.getString("url");
            attempts = jsonobject.getInt("count");
        }

        JSONObject toJSON()
            throws JSONException
        {
            JSONObject jsonobject = new JSONObject();
            jsonobject.put("type", "unfilled");
            jsonobject.put("url", url);
            jsonobject.put("count", attempts);
            return jsonobject;
        }

        Unfilled()
        {
            this$0 = LoggingManager.this;
            super(0);
        }

        Unfilled(String s, int i)
        {
            this$0 = LoggingManager.this;
            super(i);
            url = s;
        }
    }


    static final String LOG_NAME = "adlog";
    static final int MAX_RETRIES = 10;
    static final long MAX_SIZE = 65535L;
    static final int MSG_ADD = 1;
    static final int MSG_ADD_LINK = 2;
    static final int MSG_ADD_SEGMENT = 6;
    static final int MSG_ADD_SEGMENT_START = 8;
    static final int MSG_ADD_START = 7;
    static final int MSG_ADD_UNFILLED = 3;
    static final int MSG_QUIT = 5;
    static final int MSG_SEND = 4;
    static final int MSG_START = 0;
    static final int RETRY_INTERVAL = 0xdbba0;
    private Context appContext;
    private Handler handler;
    private List logInfo;
    private LoggerThread thread;

    public LoggingManager(Context context)
    {
        thread = null;
        handler = null;
        logInfo = new ArrayList();
        appContext = context;
        thread = new LoggerThread();
        thread.start();
    }

    private boolean getOnWifi()
    {
        return (NetworkUtil.networkStatus(appContext) & 2) != 0;
    }

    public int getNumberLogEntries()
    {
        return logInfo.size();
    }

    public void loadLogInfo()
    {
        logInfo.clear();
        Object obj;
        long l;
        obj = appContext.openFileInput("adlog");
        l = ((FileInputStream) (obj)).getChannel().size();
        if (l <= 65535L) goto _L2; else goto _L1
_L1:
        try
        {
            throw new Exception("Impression file too large, ignoring");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.e("LoggingManager", (new StringBuilder()).append("Error reading impression log: ").append(((Exception) (obj)).getMessage()).toString());
        }
_L6:
        return;
_L2:
        int i = (int)l;
        byte abyte0[] = new byte[i];
        Log.d("LoggingManager", (new StringBuilder()).append("Reading log (").append(l).append(" bytes)").toString());
        ((FileInputStream) (obj)).read(abyte0);
        ((FileInputStream) (obj)).close();
        obj = (new JSONObject(new String(abyte0))).getJSONArray("log");
        i = 0;
_L4:
        JSONObject jsonobject;
        Object obj1;
        if (i >= ((JSONArray) (obj)).length())
        {
            continue; /* Loop/switch isn't completed */
        }
        jsonobject = ((JSONArray) (obj)).getJSONObject(i);
        obj1 = jsonobject.getString("type");
        Log.d("LoggingManager", (new StringBuilder()).append("log type ").append(((String) (obj1))).toString());
        if (((String) (obj1)).equals("impression"))
        {
            obj1 = new Impression();
            ((Impression) (obj1)).fromJSON(jsonobject);
            Log.d("LoggingManager", (new StringBuilder()).append("Adding impression url: ").append(((Impression) (obj1)).url).toString());
            logInfo.add(obj1);
            break MISSING_BLOCK_LABEL_327;
        }
        if (((String) (obj1)).equals("unfilled"))
        {
            Unfilled unfilled = new Unfilled();
            unfilled.fromJSON(jsonobject);
            Log.d("LoggingManager", (new StringBuilder()).append("Adding unfilled url: ").append(unfilled.url).toString());
            logInfo.add(unfilled);
        }
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void logImpression(AdBreak adbreak)
    {
        handler.sendMessage(handler.obtainMessage(1, adbreak));
    }

    public void logImpression(AdLink adlink)
    {
        handler.sendMessage(handler.obtainMessage(2, adlink));
    }

    public void logImpression(AdSegment adsegment)
    {
        handler.sendMessage(handler.obtainMessage(6, adsegment));
    }

    public void logTracking(AdBreak adbreak)
    {
        handler.sendMessage(handler.obtainMessage(7, adbreak));
    }

    public void logTracking(AdSegment adsegment)
    {
        handler.sendMessage(handler.obtainMessage(8, adsegment));
    }

    public void logUnfilled(AdSettings adsettings, String s, int i, Location location, boolean flag)
    {
        Log.d("LoggingManager", "logUnfilled");
        adsettings = WebService.buildUnfilledUri(adsettings, s, i, location, getOnWifi(), flag);
        Log.d("LoggingManager", (new StringBuilder()).append("logUnfilled - uri: ").append(adsettings).toString());
        adsettings = new Unfilled(adsettings, 0);
        adsettings = handler.obtainMessage(3, adsettings);
        handler.sendMessage(adsettings);
    }

    void sendLogInfo()
    {
        boolean flag;
        int i;
        flag = false;
        i = 0;
        if (NetworkUtil.networkStatus(appContext) == 0)
        {
            break MISSING_BLOCK_LABEL_256;
        }
_L6:
        LogInfo loginfo;
        if (i >= logInfo.size())
        {
            break; /* Loop/switch isn't completed */
        }
        loginfo = (LogInfo)logInfo.get(i);
        if (!(loginfo instanceof Impression)) goto _L2; else goto _L1
_L1:
        Log.d("LoggingManager", (new StringBuilder()).append("sendLogInfo: ").append(((Impression)loginfo).url).toString());
        WebService.submitImpressionLog(((Impression)loginfo).url);
_L4:
        logInfo.remove(i);
        flag = true;
        continue; /* Loop/switch isn't completed */
_L2:
        if (!(loginfo instanceof Unfilled)) goto _L4; else goto _L3
_L3:
        Log.d("LoggingManager", (new StringBuilder()).append("sendLogInfo: ").append(((Unfilled)loginfo).url).toString());
        WebService.submitUnfilledLog(((Unfilled)loginfo).url);
          goto _L4
        WebException webexception;
        webexception;
        Log.d("LoggingManager", (new StringBuilder()).append("Failed to send impression: ").append(webexception.getMessage()).toString());
        int j = loginfo.attempts;
        loginfo.attempts = j + 1;
        if (j > 10)
        {
            Log.d("LoggingManager", "Max attempts on log request reached");
            logInfo.remove(i);
            flag = true;
        } else
        {
            i++;
        }
        if (true) goto _L6; else goto _L5
_L5:
        if (flag)
        {
            storeLogInfo();
        }
        if (logInfo.size() > 0)
        {
            handler.sendEmptyMessageDelayed(4, 0xdbba0L);
        }
        return;
    }

    public void stopLogger()
    {
        handler.sendEmptyMessage(5);
        thread = null;
    }

    void storeImpression(AdBreak adbreak)
    {
        storeImpression(adbreak, "complete");
    }

    void storeImpression(AdBreak adbreak, String s)
    {
        adbreak = adbreak.getSegments().iterator();
        do
        {
            if (!adbreak.hasNext())
            {
                break;
            }
            AdSegment adsegment = (AdSegment)adbreak.next();
            if (adsegment.getImpressionLog() != null)
            {
                AdLog aadlog[] = adsegment.getImpressionLog();
                int j = aadlog.length;
                int i = 0;
                while (i < j) 
                {
                    Object obj = aadlog[i];
                    if (((AdLog) (obj)).getEvent().equals(s))
                    {
                        obj = ((AdLog) (obj)).getLogUrl();
                        Log.d("LoggingManager", (new StringBuilder()).append("Storing (").append(s).append(") impression log url: ").append(((String) (obj))).toString());
                        logInfo.add(new Impression(((String) (obj)), 0));
                    }
                    i++;
                }
            }
        } while (true);
        storeLogInfo();
        handler.removeMessages(4);
        handler.sendEmptyMessage(4);
    }

    void storeImpression(AdLink adlink)
    {
        if (adlink.getLinkLog() != null)
        {
            logInfo.add(new Impression(adlink.getLinkLog().getLogUrl(), 0));
            storeLogInfo();
            handler.removeMessages(4);
            handler.sendEmptyMessage(4);
        }
    }

    void storeImpression(AdSegment adsegment)
    {
        storeImpression(adsegment, "complete");
    }

    void storeImpression(AdSegment adsegment, String s)
    {
        if (adsegment.getImpressionLog() != null)
        {
            adsegment = adsegment.getImpressionLog();
            int j = adsegment.length;
            for (int i = 0; i < j; i++)
            {
                AdLog adlog = adsegment[i];
                if (adlog.getEvent().equals(s))
                {
                    logInfo.add(new Impression(adlog.getLogUrl(), 0));
                }
            }

        }
        storeLogInfo();
        handler.removeMessages(4);
        handler.sendEmptyMessage(4);
    }

    public void storeLogInfo()
    {
        Object obj;
        try
        {
            obj = new JSONObject();
            JSONArray jsonarray = new JSONArray();
            ((JSONObject) (obj)).put("log", jsonarray);
            for (Iterator iterator = logInfo.iterator(); iterator.hasNext(); jsonarray.put(((LogInfo)iterator.next()).toJSON())) { }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Log.e("LoggingManager", (new StringBuilder()).append("Error writing impression log: ").append(((Exception) (obj)).getMessage()).toString());
            return;
        }
        byte abyte0[] = ((JSONObject) (obj)).toString().getBytes();
        Log.d("LoggingManager", (new StringBuilder()).append("Writing log (").append(abyte0.length).append(" bytes)").toString());
        FileOutputStream fileoutputstream = appContext.openFileOutput("adlog", 0);
        fileoutputstream.write(abyte0);
        fileoutputstream.close();
        return;
    }

    void storeUnfilled(Unfilled unfilled)
    {
        logInfo.add(unfilled);
        storeLogInfo();
        handler.removeMessages(4);
        handler.sendEmptyMessage(4);
    }



/*
    static Handler access$002(LoggingManager loggingmanager, Handler handler1)
    {
        loggingmanager.handler = handler1;
        return handler1;
    }

*/

}
