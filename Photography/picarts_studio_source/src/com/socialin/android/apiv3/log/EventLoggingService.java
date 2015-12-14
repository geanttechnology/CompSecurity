// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.log;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.socialin.android.apiv3.SocialinV3;
import com.socialin.android.apiv3.exception.ExceptionReportService;
import com.socialin.android.apiv3.model.AppProps;
import com.socialin.android.apiv3.model.Settings;
import com.socialin.android.apiv3.model.User;
import com.socialin.android.apiv3.model.parsers.StringParser;
import com.socialin.android.apiv3.util.Utils;
import com.socialin.android.util.s;
import com.socialin.asyncnet.Request;
import com.socialin.asyncnet.b;
import com.socialin.asyncnet.d;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.socialin.android.apiv3.log:
//            Event, Attribute, AnalyticsDatabaseHelper

public class EventLoggingService extends Service
    implements android.os.Handler.Callback
{

    private static final String ACTIVITY_LIFE = "ACTIVITY_LIFE";
    public static final String ADD_ATTRIBUTE_ACTION = "picsart.event.add.attribute";
    public static final String ADD_EVENT_ACTION = "picsart.event.add.action";
    public static final String ANALYTICS_DEBUG_REQUEST_ACTION = "picsart.analytics.debug.request.action";
    public static final String APPLICATION_SESSION = "APPLICATION_SESSION";
    private static final int MSG_SEND_DEBUG_EVENT = 3;
    private static final int MSG_WRITE_ATTRIBUTE_TO_DB = 2;
    private static final int MSG_WRITE_EVENT_TO_DB = 1;
    private static final String PROTOCOL_VERSION = "1.4";
    public static final String SEND_CONTACT_EVENT_ACTION = "picsart.contact.send.action";
    public static final String SESSION_ENDED_ACTION = "picsart.end.session.action";
    public static final String SESSION_ID = "SESSION_ID";
    public static final String SESSION_STARTED_ACTION = "picsart.start.session.action";
    private static final String SESSION_TIMESTAMP = "SESSION_TIMESTAMP";
    public static final String TAG = "EventLoggingService";
    private static android.content.SharedPreferences.Editor editor;
    private static AnalyticsDatabaseHelper eventDb;
    private static SharedPreferences pref;
    private static Runnable requestSend;
    private String ADVERTISING_ID;
    public String analyticsUrl;
    private ArrayList attributeIds;
    private JSONArray batch;
    private ArrayList eventIds;
    BroadcastReceiver eventListener;
    public int eventsBatchTime;
    private Handler handler;
    public boolean isSending;
    public long sessionTimeOut;
    public int timeStampUnit;

    public EventLoggingService()
    {
        eventsBatchTime = 0x1d4c0;
        sessionTimeOut = 15000L;
        timeStampUnit = 1000;
        isSending = false;
        analyticsUrl = "https://analytics.picsart.com/";
        batch = new JSONArray();
        eventListener = new BroadcastReceiver() {

            private EventLoggingService a;

            public final void onReceive(Context context, Intent intent)
            {
                if ("picsart.event.add.action".equals(intent.getAction()))
                {
                    a.queueEvents(intent);
                } else
                {
                    if ("picsart.event.add.attribute".equals(intent.getAction()))
                    {
                        a.queueAttributes(intent);
                        return;
                    }
                    if ("picsart.start.session.action".equals(intent.getAction()))
                    {
                        a.handleSessionStart(intent);
                        return;
                    }
                    if ("picsart.end.session.action".equals(intent.getAction()))
                    {
                        if (EventLoggingService.pref.getBoolean("ACTIVITY_LIFE", false))
                        {
                            if (SocialinV3.getInstance().getAppProps().getData().log != null)
                            {
                                EventLoggingService.editor.putLong("SESSION_TIMESTAMP", System.currentTimeMillis() / (long)SocialinV3.getInstance().getAppProps().getData().log.timeStampUnit);
                            } else
                            {
                                EventLoggingService.editor.putLong("SESSION_TIMESTAMP", System.currentTimeMillis() / (long)a.timeStampUnit);
                            }
                        }
                        EventLoggingService.editor.putBoolean("ACTIVITY_LIFE", false);
                        EventLoggingService.editor.commit();
                        return;
                    }
                    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()))
                    {
                        s.c(a.getApplicationContext());
                        return;
                    }
                    if (intent.getAction().equals("picsart.analytics.debug.request.action"))
                    {
                        context = a.handler.obtainMessage(3);
                        Bundle bundle = new Bundle();
                        bundle.putString("event_id", intent.getExtras().getString("event_id"));
                        bundle.putString("data", intent.getExtras().getString("data"));
                        bundle.putLong("timeStamp", intent.getExtras().getLong("timeStamp"));
                        context.setData(bundle);
                        a.handler.sendMessage(context);
                        return;
                    }
                    if ("picsart.contact.send.action".equals(intent.getAction()))
                    {
                        context = new JSONObject();
                        JSONObject jsonobject = new JSONObject();
                        JSONObject jsonobject1 = new JSONObject();
                        JSONArray jsonarray = new JSONArray();
                        try
                        {
                            jsonobject.put("event_type", intent.getExtras().getString("event_id"));
                            jsonobject.put("data", new JSONObject(intent.getExtras().getString("data")));
                            jsonobject.put("timestamp", intent.getExtras().getString("timestamp"));
                            jsonarray.put(jsonobject);
                            a.createRequestHeader(jsonobject1, a.getSessionId());
                            context.put("events", jsonarray);
                            context.put("header", jsonobject1);
                            intent = new JSONArray();
                            intent.put(context);
                            a.sendUserConnsRequest(intent.toString());
                            return;
                        }
                        // Misplaced declaration of an exception variable
                        catch (Context context)
                        {
                            context.getMessage();
                        }
                        return;
                    }
                }
            }

            
            {
                a = EventLoggingService.this;
                super();
            }
        };
    }

    private void blink(String s, Result result)
    {
        Object obj = getBaseContext();
        s = createToastLayout(getEventTypeFromResponse(s), result);
        obj = new Toast(((Context) (obj)));
        ((Toast) (obj)).setDuration(0);
        ((Toast) (obj)).setGravity(119, 0, 0);
        ((Toast) (obj)).setView(s);
        ((Toast) (obj)).show();
        int i = 200;
        if (result == Result.VALID)
        {
            i = 350;
        }
        (new Handler()).postDelayed(new Runnable(((Toast) (obj))) {

            private Toast a;

            public final void run()
            {
                a.cancel();
            }

            
            {
                a = toast;
                super();
            }
        }, i);
    }

    private void createRequest(String s, List list, List list1)
    {
        JSONObject jsonobject;
        JSONObject jsonobject1;
        JSONArray jsonarray;
        JSONArray jsonarray1;
        if (list == null || list1 == null)
        {
            return;
        }
        jsonobject = new JSONObject();
        jsonobject1 = new JSONObject();
        jsonarray = new JSONArray();
        jsonarray1 = new JSONArray();
        try
        {
            JSONObject jsonobject3;
            for (list = list.iterator(); list.hasNext(); jsonarray.put(jsonobject3))
            {
                Event event = (Event)list.next();
                jsonobject3 = new JSONObject();
                jsonobject3.put("event_type", event.getEventId());
                jsonobject3.put("data", new JSONObject(event.getParameters()));
                jsonobject3.put("timestamp", event.getTimeStamp());
                eventIds.add(Integer.toString(event.getId()));
            }

        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.getMessage();
            ExceptionReportService.report(s);
            return;
        }
        JSONObject jsonobject2;
        for (list = list1.iterator(); list.hasNext(); jsonarray1.put(jsonobject2))
        {
            list1 = (Attribute)list.next();
            jsonobject2 = new JSONObject();
            jsonobject2.put("name", list1.getAttributeName());
            jsonobject2.put("type", list1.getAttributeType());
            jsonobject2.put("value", list1.getAttributeValue().get("value"));
            attributeIds.add(Integer.toString(list1.getId()));
        }

        createRequestHeader(jsonobject1, s);
        if (jsonarray1.length() > 0)
        {
            jsonobject.put("attributes", jsonarray1);
        }
        if (jsonarray.length() > 0)
        {
            jsonobject.put("events", jsonarray);
        }
        jsonobject.put("header", jsonobject1);
        this;
        JVM INSTR monitorenter ;
        batch.put(jsonobject);
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    private void createRequestHeader(JSONObject jsonobject, String s)
    {
        if (SocialinV3.getInstance().getUser().id > 1L)
        {
            jsonobject.put("user_id", SocialinV3.getInstance().getUser().id);
        }
        jsonobject.put("v", "1.4");
        jsonobject.put("session_id", s);
        jsonobject.put("language_code", getApplicationContext().getResources().getConfiguration().locale.getLanguage());
        jsonobject.put("country_code", Utils.getCountryCode(getApplicationContext()));
        jsonobject.put("segments", Arrays.toString(SocialinV3.getInstance().getSettings().getSegments()));
        if (TimeZone.getDefault() != null)
        {
            jsonobject.put("timezone", TimeZone.getDefault().getID());
            TimeZone.getDefault().getDisplayName(false, 0);
        }
        jsonobject.put("device_id", SocialinV3.getInstance().getDeviceId());
        if (!TextUtils.isEmpty(ADVERTISING_ID))
        {
            jsonobject.put("advertising_id", ADVERTISING_ID);
        }
        try
        {
            s = getPackageManager().getPackageInfo(getPackageName(), 0);
            if (((PackageInfo) (s)).versionCode > 0)
            {
                jsonobject.put("version", Integer.toString(((PackageInfo) (s)).versionCode));
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.getMessage();
        }
        jsonobject.put("platform", "android");
        if (getString(0x7f0808c8) != null)
        {
            jsonobject.put("market", getString(0x7f0808c8));
        }
    }

    private View createToastLayout(String s, Result result)
    {
        View view = LayoutInflater.from(getBaseContext()).inflate(0x7f0300e9, null);
        final class _cls7
        {

            static final int a[];

            static 
            {
                a = new int[Result.values().length];
                try
                {
                    a[Result.VALID.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[Result.UNKNOWN.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[Result.INVALID.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls7.a[result.ordinal()];
        JVM INSTR tableswitch 1 3: default 48
    //                   1 80
    //                   2 97
    //                   3 116;
           goto _L1 _L2 _L3 _L4
_L1:
        view.setBackgroundColor(Color.argb(60, 255, 255, 0));
_L6:
        ((TextView)view.findViewById(0x7f1004c4)).setText(s);
        return view;
_L2:
        view.setBackgroundColor(Color.argb(60, 0, 255, 0));
        continue; /* Loop/switch isn't completed */
_L3:
        view.setBackgroundColor(Color.argb(70, 255, 255, 0));
        continue; /* Loop/switch isn't completed */
_L4:
        view.setBackgroundColor(Color.argb(60, 255, 0, 0));
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void deleteAttributesIds(ArrayList arraylist)
    {
        this;
        JVM INSTR monitorenter ;
        AnalyticsDatabaseHelper analyticsdatabasehelper = eventDb;
        if (analyticsdatabasehelper != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        eventDb.deleteItemsByIds("attributes", arraylist);
        if (true) goto _L1; else goto _L3
_L3:
        arraylist;
        throw arraylist;
    }

    private void deleteEventsByIds(ArrayList arraylist)
    {
        this;
        JVM INSTR monitorenter ;
        AnalyticsDatabaseHelper analyticsdatabasehelper = eventDb;
        if (analyticsdatabasehelper != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        eventDb.deleteItemsByIds("events", arraylist);
        if (true) goto _L1; else goto _L3
_L3:
        arraylist;
        throw arraylist;
    }

    private String getEventTypeFromResponse(String s)
    {
        if (s == null)
        {
            return null;
        }
        try
        {
            s = (String)(new JSONObject(s)).get("event_type");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.getMessage();
            return null;
        }
        return s;
    }

    private String getSessionId()
    {
        return pref.getString("SESSION_ID", (new StringBuilder("0_")).append(SocialinV3.getInstance().getDeviceId()).toString());
    }

    private ArrayList getSessionIds()
    {
        this;
        JVM INSTR monitorenter ;
        if (eventDb != null) goto _L2; else goto _L1
_L1:
        ArrayList arraylist = new ArrayList();
_L4:
        this;
        JVM INSTR monitorexit ;
        return arraylist;
_L2:
        arraylist = eventDb.getSessionIds();
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    private boolean openSession()
    {
        if (SocialinV3.getInstance().getAppProps().getData().log != null) goto _L2; else goto _L1
_L1:
        long l;
        long l2;
        l = System.currentTimeMillis() / (long)timeStampUnit;
        l2 = pref.getLong("SESSION_TIMESTAMP", 0L);
        if (pref.getBoolean("ACTIVITY_LIFE", false) || l - l2 < sessionTimeOut / (long)timeStampUnit) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        int i = SocialinV3.getInstance().getAppProps().getData().log.timeStampUnit;
        long l1 = SocialinV3.getInstance().getAppProps().getData().log.sessionTimeOut;
        long l3 = System.currentTimeMillis() / (long)i;
        long l4 = pref.getLong("SESSION_TIMESTAMP", 0L);
        if (pref.getBoolean("ACTIVITY_LIFE", false) || l3 - l4 < l1 / (long)i)
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    private String parser(HttpResponse httpresponse)
    {
        if (httpresponse == null || httpresponse.getEntity() == null)
        {
            return null;
        }
        httpresponse = new BufferedReader(new InputStreamReader(httpresponse.getEntity().getContent()));
        StringBuilder stringbuilder = new StringBuilder();
        do
        {
            String s = httpresponse.readLine();
            if (s != null)
            {
                stringbuilder.append(s);
            } else
            {
                return stringbuilder.toString();
            }
        } while (true);
    }

    private void putSessionId(String s)
    {
        editor.putString("SESSION_ID", s);
        editor.commit();
    }

    private void queueAttributes(Intent intent)
    {
        if (handler == null || intent == null || !intent.hasExtra("attribute_name"))
        {
            return;
        } else
        {
            Message message = handler.obtainMessage(2);
            Bundle bundle = new Bundle();
            bundle.putString("attribute_name", intent.getExtras().getString("attribute_name"));
            bundle.putString("attribute_type", intent.getExtras().getString("attribute_type"));
            bundle.putString("attribute_value", intent.getExtras().getString("attribute_value"));
            message.setData(bundle);
            handler.sendMessage(message);
            return;
        }
    }

    private void queueEvents(Intent intent)
    {
        if (handler == null || intent == null || !intent.hasExtra("event_id"))
        {
            return;
        } else
        {
            Message message = handler.obtainMessage(1);
            Bundle bundle = new Bundle();
            bundle.putString("event_id", intent.getExtras().getString("event_id"));
            bundle.putString("data", intent.getExtras().getString("data"));
            bundle.putLong("timeStamp", intent.getExtras().getLong("timeStamp"));
            message.setData(bundle);
            handler.sendMessage(message);
            return;
        }
    }

    private List readAttributesBySessionId(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (eventDb != null) goto _L2; else goto _L1
_L1:
        s = new ArrayList();
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = eventDb.getAttributesBySessionId(s);
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    private List readEventsBySessionId(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (eventDb != null) goto _L2; else goto _L1
_L1:
        s = new ArrayList();
_L4:
        this;
        JVM INSTR monitorexit ;
        return s;
_L2:
        s = eventDb.getEventsBySessionId(s);
        if (true) goto _L4; else goto _L3
_L3:
        s;
        throw s;
    }

    private void sendDebugEvent(String s, String s1, long l)
    {
        Object obj = new JSONObject();
        try
        {
            createRequestHeader(((JSONObject) (obj)), getSessionId());
            ((JSONObject) (obj)).put("timestamp", l);
            ((JSONObject) (obj)).put("event_type", s);
            ((JSONObject) (obj)).put("data", new JSONObject(s1));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.getMessage();
        }
        try
        {
            s = new DefaultHttpClient();
            s1 = new HttpPost("http://debug.analytics.picsart.com/api/events");
            obj = new StringEntity(((JSONObject) (obj)).toString());
            ((StringEntity) (obj)).setContentType(new BasicHeader("Content-Type", "application/json"));
            s1.setEntity(((HttpEntity) (obj)));
            s = parser(s.execute(s1));
            blink(s, validate(s));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            (new StringBuilder("ClientProtocolException : ")).append(s.getMessage());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            (new StringBuilder("IOException : ")).append(s.getMessage());
        }
    }

    private Result validate(String s)
    {
        if (s == null)
        {
            return Result.INVALID;
        }
        s = (String)(new JSONObject(s)).get("status");
        s.hashCode();
        JVM INSTR lookupswitch 3: default 137
    //                   -1617199657: 83
    //                   81434588: 68
    //                   433141802: 98;
           goto _L1 _L2 _L3 _L4
_L9:
        return Result.UNKNOWN;
_L3:
        if (!s.equals("VALID")) goto _L1; else goto _L5
_L5:
        byte byte0 = 0;
          goto _L6
_L2:
        if (!s.equals("INVALID")) goto _L1; else goto _L7
_L7:
        byte0 = 1;
          goto _L6
_L4:
        if (!s.equals("UNKNOWN")) goto _L1; else goto _L8
_L8:
        byte0 = 2;
          goto _L6
_L10:
        return Result.VALID;
_L11:
        return Result.INVALID;
_L12:
        s = Result.UNKNOWN;
        return s;
        s;
        s.getMessage();
        return Result.INVALID;
_L1:
        byte0 = -1;
_L6:
        byte0;
        JVM INSTR tableswitch 0 2: default 168
    //                   0 113
    //                   1 117
    //                   2 121;
           goto _L9 _L10 _L11 _L12
    }

    private void writeAttributeToDb(Attribute attribute)
    {
        this;
        JVM INSTR monitorenter ;
        AnalyticsDatabaseHelper analyticsdatabasehelper = eventDb;
        if (analyticsdatabasehelper != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        eventDb.addAttribute(attribute);
        if (true) goto _L1; else goto _L3
_L3:
        attribute;
        throw attribute;
    }

    private void writeEventToDb(Event event)
    {
        this;
        JVM INSTR monitorenter ;
        AnalyticsDatabaseHelper analyticsdatabasehelper = eventDb;
        if (analyticsdatabasehelper != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        eventDb.addEvent(event);
        if (true) goto _L1; else goto _L3
_L3:
        event;
        throw event;
    }

    public boolean handleMessage(Message message)
    {
        message.what;
        JVM INSTR tableswitch 1 3: default 32
    //                   1 34
    //                   2 81
    //                   3 160;
           goto _L1 _L2 _L3 _L4
_L1:
        return false;
_L2:
        message = message.getData();
        writeEventToDb(new Event(getSessionId(), message.getString("event_id"), message.getString("data"), Long.valueOf(message.getLong("timeStamp"))));
        continue; /* Loop/switch isn't completed */
_L3:
        Object obj = message.getData();
        message = getSessionId();
        String s = ((Bundle) (obj)).getString("attribute_name");
        String s1 = ((Bundle) (obj)).getString("attribute_type");
        obj = ((Bundle) (obj)).getString("attribute_value");
        try
        {
            writeAttributeToDb(new Attribute(message, s, s1, new JSONObject(((String) (obj)))));
        }
        // Misplaced declaration of an exception variable
        catch (Message message)
        {
            Log.e("EventLoggingService", message.getMessage());
        }
        continue; /* Loop/switch isn't completed */
_L4:
        message = message.getData();
        sendDebugEvent(message.getString("event_id"), message.getString("data"), message.getLong("timeStamp"));
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void handleSessionStart(Intent intent)
    {
        if (intent == null || !"picsart.start.session.action".equals(intent.getAction()))
        {
            return;
        }
        if (openSession())
        {
            putSessionId((new StringBuilder()).append(System.currentTimeMillis()).append("_").append(SocialinV3.getInstance().getDeviceId()).toString());
        }
        editor.putBoolean("ACTIVITY_LIFE", true);
        editor.commit();
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
        Object obj = getApplicationContext().getSharedPreferences("APPLICATION_SESSION", 4);
        pref = ((SharedPreferences) (obj));
        editor = ((SharedPreferences) (obj)).edit();
        obj = new HandlerThread("EventLoggingThread", -2);
        ((HandlerThread) (obj)).start();
        handler = new Handler(((HandlerThread) (obj)).getLooper(), this);
        obj = new IntentFilter();
        ((IntentFilter) (obj)).addAction("picsart.event.add.action");
        ((IntentFilter) (obj)).addAction("picsart.end.session.action");
        ((IntentFilter) (obj)).addAction("picsart.start.session.action");
        ((IntentFilter) (obj)).addAction("picsart.analytics.debug.request.action");
        ((IntentFilter) (obj)).addAction("android.net.conn.CONNECTIVITY_CHANGE");
        ((IntentFilter) (obj)).addAction("picsart.contact.send.action");
        registerReceiver(eventListener, ((IntentFilter) (obj)));
        eventDb = AnalyticsDatabaseHelper.getInstance(getApplicationContext());
        startScheduleTask();
        (new Thread(new Runnable() {

            private EventLoggingService a;

            public final void run()
            {
                try
                {
                    a.ADVERTISING_ID = AdvertisingIdClient.getAdvertisingIdInfo(a.getApplicationContext()).getId();
                    return;
                }
                catch (Exception exception)
                {
                    return;
                }
            }

            
            {
                a = EventLoggingService.this;
                super();
            }
        })).start();
        eventIds = new ArrayList();
        attributeIds = new ArrayList();
    }

    public void onDestroy()
    {
        super.onDestroy();
        unregisterReceiver(eventListener);
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        super.onStartCommand(intent, i, j);
        queueEvents(intent);
        queueAttributes(intent);
        handleSessionStart(intent);
        return 2;
    }

    public void sendRequest(String s, String s1)
    {
        com.socialin.android.apiv3.model.AppProps.Data data = SocialinV3.getInstance().getAppProps().getData();
        if (isSending || data == null || data.log == null || !data.log.logInfo)
        {
            return;
        } else
        {
            isSending = true;
            s = new Request(s, StringParser.instance(), "POST");
            s.b("REQUEST", s1);
            b.a().a(s, new d() {

                private EventLoggingService a;

                public final volatile void onCancelRequest(Object obj, Request request)
                {
                }

                public final void onFailure(Exception exception, Request request)
                {
                    a.isSending = false;
                }

                public final transient void onProgressUpdate(Integer ainteger[])
                {
                }

                public final void onSuccess(Object obj, Request request)
                {
                    obj = (String)obj;
                    a.isSending = false;
                    if (!"OK".equals((new JSONObject(((String) (obj)))).get("status")))
                    {
                        return;
                    }
                    try
                    {
                        if (a.eventIds != null && a.eventIds.size() > 0)
                        {
                            a.deleteEventsByIds(a.eventIds);
                            a.eventIds.clear();
                        }
                        if (a.attributeIds != null && a.attributeIds.size() > 0)
                        {
                            a.deleteAttributesIds(a.attributeIds);
                            a.attributeIds.clear();
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (Request request)
                    {
                        Log.e("EventLoggingService", (new StringBuilder("Could not parse malformed JSON: \"")).append(((String) (obj))).append("\"").toString());
                    }
                    return;
                }

            
            {
                a = EventLoggingService.this;
                super();
            }
            });
            return;
        }
    }

    public void sendUserConnsRequest(String s)
    {
        com.socialin.android.apiv3.model.AppProps.Data data = SocialinV3.getInstance().getAppProps().getData();
        if (data.api == null)
        {
            return;
        } else
        {
            Request request = new Request(data.api.contactAnalyticsUrl, StringParser.instance(), "POST");
            request.j = data.api.contactsSendGZIP;
            request.b("REQUEST", s);
            b.a().a(request, new d() {

                public final volatile void onCancelRequest(Object obj, Request request1)
                {
                }

                public final void onFailure(Exception exception, Request request1)
                {
                }

                public final transient void onProgressUpdate(Integer ainteger[])
                {
                }

                public final volatile void onSuccess(Object obj, Request request1)
                {
                }

            });
            return;
        }
    }

    public void startScheduleTask()
    {
        Handler handler1 = new Handler();
        requestSend = new Runnable(handler1) {

            private Handler a;
            private EventLoggingService b;

            public final void run()
            {
                try
                {
                    String s1;
                    for (Iterator iterator = b.getSessionIds().iterator(); iterator.hasNext(); b.createRequest(s1, b.readEventsBySessionId(s1), b.readAttributesBySessionId(s1)))
                    {
                        s1 = (String)iterator.next();
                    }

                }
                catch (Exception exception)
                {
                    exception.getMessage();
                    ExceptionReportService.report(exception);
                    return;
                }
                if (b.batch == null || b.batch.length() <= 0) goto _L2; else goto _L1
_L1:
                String s;
                s = b.batch.toString();
                if (SocialinV3.getInstance().getAppProps().getData().api == null)
                {
                    break MISSING_BLOCK_LABEL_198;
                }
                b.sendRequest(SocialinV3.getInstance().getAppProps().getData().api.analyticsUrl, s);
_L4:
                b.batch = new JSONArray();
_L2:
                if (SocialinV3.getInstance().getAppProps().getData().log != null)
                {
                    a.postDelayed(EventLoggingService.requestSend, SocialinV3.getInstance().getAppProps().getData().log.eventsBatchTime);
                    return;
                }
                break MISSING_BLOCK_LABEL_216;
                b.sendRequest(b.analyticsUrl, s);
                if (true) goto _L4; else goto _L3
_L3:
                a.postDelayed(EventLoggingService.requestSend, b.eventsBatchTime);
                return;
            }

            
            {
                b = EventLoggingService.this;
                a = handler1;
                super();
            }
        };
        if (SocialinV3.getInstance().getAppProps().getData().log != null)
        {
            handler1.postDelayed(requestSend, SocialinV3.getInstance().getAppProps().getData().log.eventsBatchTime);
            return;
        } else
        {
            handler1.postDelayed(requestSend, eventsBatchTime);
            return;
        }
    }







/*
    static JSONArray access$1202(EventLoggingService eventloggingservice, JSONArray jsonarray)
    {
        eventloggingservice.batch = jsonarray;
        return jsonarray;
    }

*/












/*
    static String access$702(EventLoggingService eventloggingservice, String s)
    {
        eventloggingservice.ADVERTISING_ID = s;
        return s;
    }

*/



    private class Result extends Enum
    {

        private static final Result $VALUES[];
        public static final Result INVALID;
        public static final Result UNKNOWN;
        public static final Result VALID;

        public static Result valueOf(String s)
        {
            return (Result)Enum.valueOf(com/socialin/android/apiv3/log/EventLoggingService$Result, s);
        }

        public static Result[] values()
        {
            return (Result[])$VALUES.clone();
        }

        static 
        {
            VALID = new Result("VALID", 0);
            INVALID = new Result("INVALID", 1);
            UNKNOWN = new Result("UNKNOWN", 2);
            $VALUES = (new Result[] {
                VALID, INVALID, UNKNOWN
            });
        }

        private Result(String s, int i)
        {
            super(s, i);
        }
    }

}
