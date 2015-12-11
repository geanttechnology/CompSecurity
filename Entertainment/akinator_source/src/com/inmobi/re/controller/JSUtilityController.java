// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.re.controller;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Environment;
import android.os.Vibrator;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import com.inmobi.androidsdk.IMBrowserActivity;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.internal.ApiStatCollector;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.metric.EventLog;
import com.inmobi.commons.metric.Logger;
import com.inmobi.re.configs.ConfigParams;
import com.inmobi.re.configs.Initializer;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.mraidimpl.AudioTriggerCallback;
import com.inmobi.re.container.mraidimpl.AudioTriggerer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.inmobi.re.controller:
//            JSController, JSDisplayController

public class JSUtilityController extends JSController
{

    public static SimpleDateFormat calendarUntiFormats[] = {
        new SimpleDateFormat("yyyyMMdd'T'HHmmssZ"), new SimpleDateFormat("yyyyMMdd'T'HHmm"), new SimpleDateFormat("yyyyMMdd")
    };
    public static SimpleDateFormat formats[];
    DownloadManager a;
    Object b;
    int c;
    private JSDisplayController d;
    private boolean e;
    private Map f;
    private AudioTriggerCallback g;
    private boolean h;
    private boolean i;

    public JSUtilityController(IMWebView imwebview, Context context)
    {
        super(imwebview, context);
        a = null;
        e = false;
        c = 0;
        f = new HashMap();
        g = new _cls8();
        h = false;
        i = false;
        d = new JSDisplayController(imwebview, context);
        imwebview.addJavascriptInterface(d, "displayController");
    }

    private int a()
    {
        Object obj = new String[2];
        obj[0] = "_id";
        obj[1] = "title";
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            obj = imWebView.getActivity().getContentResolver().query(Uri.parse("content://com.android.calendar/events"), ((String []) (obj)), null, null, null);
        } else
        {
            obj = imWebView.getActivity().getContentResolver().query(Uri.parse("content://calendar/events"), ((String []) (obj)), null, null, null);
        }
        if (obj != null && ((Cursor) (obj)).moveToLast())
        {
            int j = ((Cursor) (obj)).getColumnIndex("title");
            int k = ((Cursor) (obj)).getColumnIndex("_id");
            String s = ((Cursor) (obj)).getString(j);
            obj = ((Cursor) (obj)).getString(k);
            if (s != null)
            {
                return Integer.parseInt(((String) (obj)));
            }
        }
        return 0;
    }

    static int a(JSUtilityController jsutilitycontroller)
    {
        return jsutilitycontroller.a();
    }

    private int a(String s, int j)
    {
        int k;
        try
        {
            k = Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return j;
        }
        return k;
    }

    private String b(String s)
    {
        String s1;
        if (TextUtils.isEmpty(s))
        {
            s1 = null;
        } else
        {
            s1 = s;
            if (!s.startsWith("tel:"))
            {
                StringBuilder stringbuilder = new StringBuilder("tel:");
                stringbuilder.append(s);
                return stringbuilder.toString();
            }
        }
        return s1;
    }

    private int[] b()
    {
        int ai[] = new int[2];
        try
        {
            FrameLayout framelayout = (FrameLayout)((ViewGroup)imWebView.getOriginalParent()).getRootView().findViewById(0x1020002);
            ai[0] = (int)((float)framelayout.getWidth() / imWebView.getDensity());
            ai[1] = (int)((float)framelayout.getHeight() / imWebView.getDensity());
        }
        catch (Exception exception)
        {
            ai[1] = 0;
            ai[0] = 0;
            return ai;
        }
        return ai;
    }

    private void c()
    {
        if (i)
        {
            registerMicListener();
        }
    }

    private void c(String s)
    {
        (new _cls3(s)).start();
    }

    public static GregorianCalendar convertDateString(String s)
    {
        SimpleDateFormat asimpledateformat[];
        int j;
        int k;
        asimpledateformat = formats;
        k = asimpledateformat.length;
        j = 0;
_L2:
        Object obj;
        if (j >= k)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = asimpledateformat[j];
        obj = ((SimpleDateFormat) (obj)).parse(s);
        GregorianCalendar gregoriancalendar = new GregorianCalendar();
        gregoriancalendar.setTime(((java.util.Date) (obj)));
        obj = (GregorianCalendar)gregoriancalendar;
        return ((GregorianCalendar) (obj));
        Exception exception;
        exception;
        j++;
        if (true) goto _L2; else goto _L1
_L1:
        return null;
    }

    private void d()
    {
        i = h;
        unRegisterMicListener();
    }

    boolean a(String s)
    {
        PackageManager packagemanager = imWebView.getActivity().getPackageManager();
        return packagemanager.checkPermission(s, packagemanager.getNameForUid(Binder.getCallingUid())) == 0;
    }

    public void asyncPing(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(31), null));
        try
        {
            Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("JSUtilityController-> asyncPing: url: ").append(s).toString());
            if (!URLUtil.isValidUrl(s))
            {
                imWebView.raiseError("Invalid url", "asyncPing");
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
        c(s);
        return;
    }

    public void cancelSaveContent(String s)
    {
        imWebView.cancelSaveContent(s);
    }

    public void closeVideo(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(50), null));
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("JSUtilityController-> closeVideo: id :").append(s).toString());
        imWebView.closeVideo(s);
    }

    public void createCalendarEvent(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9)
    {
        if (a("android.permission.READ_CALENDAR") && a("android.permission.WRITE_CALENDAR"))
        {
            c = a();
        }
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(30), null));
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("JSUtilityController-> createEvent: date: ").append(s1).append(" location: ").append(s3).append(" body: ").append(s4).toString());
        if (!supports("calendar"))
        {
            Log.internal("[InMobi]-[RE]-4.5.5", "createCalendarEvent called even if it is not supported");
            imWebView.raiseError("createCalendarEvent called even if it is not supported", "createCalendarEvent");
            return;
        }
        GregorianCalendar gregoriancalendar;
        gregoriancalendar = convertDateString(s1);
        s2 = convertDateString(s2);
        if (gregoriancalendar == null || s2 == null)
        {
            try
            {
                Log.debug("[InMobi]-[RE]-4.5.5", "exception");
                imWebView.raiseError("Date format is incorrect", "createCalendarEvent");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.internal("[InMobi]-[RE]-4.5.5", "Error creating reminder event", s);
            }
            return;
        }
        Intent intent;
        intent = new Intent(imWebView.getActivity(), com/inmobi/androidsdk/IMBrowserActivity);
        intent.putExtra("extra_browser_type", 100);
        intent.putExtra("id", IMBrowserActivity.generateId(new _cls2(s6, s9, s1)));
        intent.putExtra("eventId", s);
        intent.putExtra("action", "createCalendarEvent");
        intent.putExtra("description", s4);
        intent.putExtra("summary", s5);
        intent.putExtra("location", s3);
        intent.putExtra("start", gregoriancalendar.getTimeInMillis());
        intent.putExtra("end", s2.getTimeInMillis());
        intent.putExtra("status", s6);
        intent.putExtra("transparency", s7);
        intent.putExtra("recurrence", s8);
        if (s9 == null)
        {
            break MISSING_BLOCK_LABEL_383;
        }
        if (!"".equals(s9))
        {
            intent.putExtra("hasAlarm", true);
        }
        imWebView.getActivity().startActivity(intent);
        if (imWebView.mListener != null)
        {
            imWebView.mListener.onLeaveApplication();
        }
        return;
    }

    public int getAudioVolume(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(37), null));
        Log.debug("[InMobi]-[RE]-4.5.5", "JSUtilityController-> getAudioVolume: ");
        return imWebView.getAudioVolume(s);
    }

    public String getCurrentPosition()
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(18), null));
        Log.debug("[InMobi]-[RE]-4.5.5", "JSUtilityController-> getCurrentPosition");
        Object obj = imWebView.mutexcPos;
        obj;
        JVM INSTR monitorenter ;
        imWebView.sendToCPHandler();
_L1:
        boolean flag = imWebView.acqMutexcPos.get();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        imWebView.mutexcPos.wait();
          goto _L1
        Object obj1;
        obj1;
        Log.debug("[InMobi]-[RE]-4.5.5", "mutexcPos failed ", ((Throwable) (obj1)));
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        imWebView.acqMutexcPos.set(true);
        obj;
        JVM INSTR monitorexit ;
        return imWebView.curPosition.toString();
    }

    public String getDefaultPosition()
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(19), null));
        Log.debug("[InMobi]-[RE]-4.5.5", "JSUtilityController-> getDefaultPosition");
        Object obj = imWebView.mutexdPos;
        obj;
        JVM INSTR monitorenter ;
        imWebView.sendToDPHandler();
_L1:
        boolean flag = imWebView.acqMutexdPos.get();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        imWebView.mutexdPos.wait();
          goto _L1
        Object obj1;
        obj1;
        Log.debug("[InMobi]-[RE]-4.5.5", "mutexdPos failed ", ((Throwable) (obj1)));
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        imWebView.acqMutexdPos.set(true);
        obj;
        JVM INSTR monitorexit ;
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("mutexdPassed").append(imWebView.defPosition).toString());
        return imWebView.defPosition.toString();
    }

    public String getGalleryImage()
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(25), null));
        if (!supports("getGalleryImage"))
        {
            Log.internal("[InMobi]-[RE]-4.5.5", "getGalleryImage called even if it is not supported");
        } else
        {
            Intent intent = new Intent(imWebView.getActivity(), com/inmobi/androidsdk/IMBrowserActivity);
            intent.putExtra("extra_browser_type", 100);
            intent.putExtra("id", IMBrowserActivity.generateId(new _cls6()));
            intent.putExtra("action", "getGalleryImage");
            imWebView.getActivity().startActivity(intent);
            if (imWebView.mListener != null)
            {
                imWebView.mListener.onLeaveApplication();
                return null;
            }
        }
        return null;
    }

    public String getMaxSize()
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(20), null));
        int ai[] = b();
        JSONObject jsonobject = new JSONObject();
        try
        {
            jsonobject.put("width", ai[0]);
            jsonobject.put("height", ai[1]);
        }
        catch (JSONException jsonexception) { }
        return jsonobject.toString();
    }

    public double getMicIntensity()
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(51), null));
        return imWebView.getLastGoodKnownMicValue();
    }

    public String getScreenSize()
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(17), null));
        Log.debug("[InMobi]-[RE]-4.5.5", "JSUtilityController-> getScreenSize");
        Object obj = new DisplayMetrics();
        ((WindowManager)mContext.getSystemService("window")).getDefaultDisplay().getMetrics(((DisplayMetrics) (obj)));
        int j = (int)((float)((DisplayMetrics) (obj)).widthPixels / ((DisplayMetrics) (obj)).density);
        int k = (int)((float)((DisplayMetrics) (obj)).heightPixels / ((DisplayMetrics) (obj)).density);
        obj = new JSONObject();
        try
        {
            ((JSONObject) (obj)).put("width", j);
            ((JSONObject) (obj)).put("height", k);
        }
        catch (JSONException jsonexception)
        {
            Log.debug("[InMobi]-[RE]-4.5.5", "Failed to get screen size");
        }
        return ((JSONObject) (obj)).toString();
    }

    public String getSdkVersion()
    {
        return InMobi.getVersion();
    }

    public int getVideoVolume(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(45), null));
        Log.debug("[InMobi]-[RE]-4.5.5", "JSUtilityController-> getVideoVolume: ");
        return imWebView.getVideoVolume(s);
    }

    public void hideVideo(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(48), null));
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("JSUtilityController-> hideVideo: id :").append(s).toString());
        imWebView.hideVideo(s);
    }

    public void incentCompleted(String s)
    {
        HashMap hashmap;
        Iterator iterator;
        s = new JSONObject(s);
        hashmap = new HashMap();
        iterator = s.keys();
_L1:
        String s1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_68;
        }
        s1 = (String)iterator.next();
        try
        {
            hashmap.put(s1, s.get(s1));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            try
            {
                imWebView.incentCompleted(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.internal("[InMobi]-[RE]-4.5.5", "JSON error");
            }
            break MISSING_BLOCK_LABEL_87;
        }
          goto _L1
        imWebView.incentCompleted(hashmap);
        return;
        imWebView.incentCompleted(null);
        return;
    }

    public boolean isAudioMuted(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(35), null));
        Log.debug("[InMobi]-[RE]-4.5.5", "JSUtilityController-> isAudioMuted: ");
        return imWebView.isAudioMuted(s);
    }

    public boolean isVideoMuted(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(43), null));
        Log.debug("[InMobi]-[RE]-4.5.5", "JSUtilityController-> isVideoMuted: ");
        return imWebView.isVideoMuted(s);
    }

    public void log(String s)
    {
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("Ad Log Message: ").append(s).toString());
    }

    public void makeCall(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(29), null));
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("JSUtilityController-> makeCall: number: ").append(s).toString());
        s = b(s);
        if (s == null)
        {
            try
            {
                imWebView.raiseError("Bad Phone Number", "makeCall");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.debug("[InMobi]-[RE]-4.5.5", "Exception in making call ", s);
            }
            break MISSING_BLOCK_LABEL_129;
        }
        s = new Intent("android.intent.action.VIEW", Uri.parse(s.toString()));
        s.addFlags(0x10000000);
        imWebView.getActivity().startActivity(s);
        imWebView.fireOnLeaveApplication();
        return;
        imWebView.raiseError("Exception in making call", "makeCall");
        return;
    }

    public void muteAudio(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(33), null));
        Log.debug("[InMobi]-[RE]-4.5.5", "JSUtilityController-> muteAudio: ");
        imWebView.muteAudio(s);
    }

    public void muteVideo(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(41), null));
        Log.debug("[InMobi]-[RE]-4.5.5", "JSUtilityController-> muteVideo: ");
        imWebView.muteVideo(s);
    }

    public void onUserInteraction(String s)
    {
        HashMap hashmap;
        Iterator iterator;
        s = new JSONObject(s);
        hashmap = new HashMap();
        iterator = s.keys();
_L1:
        String s1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_63;
        }
        s1 = (String)iterator.next();
        try
        {
            hashmap.put(s1, s.getString(s1));
        }
        catch (JSONException jsonexception) { }
          goto _L1
        try
        {
            imWebView.userInteraction(hashmap);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
    }

    public void openExternal(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(2), null));
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("JSUtilityController-> openExternal: url: ").append(s).toString());
        imWebView.openExternal(s);
    }

    public void pauseAudio(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(39), null));
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("JSUtilityController-> pauseAudio: id :").append(s).toString());
        imWebView.pauseAudio(s);
    }

    public void pauseVideo(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(47), null));
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("JSUtilityController-> pauseVideo: id :").append(s).toString());
        imWebView.pauseVideo(s);
    }

    public void playAudio(String s, boolean flag, boolean flag1, boolean flag2, String s1, String s2, String s3)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(32), null));
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("playAudio: url: ").append(s).append(" autoPlay: ").append(flag).append(" controls: ").append(flag1).append(" loop: ").append(flag2).append(" startStyle: ").append(s1).append(" stopStyle: ").append(s2).append(" id:").append(s3).toString());
        imWebView.playAudio(s, flag, flag1, flag2, s1, s2, s3);
    }

    public void playVideo(String s, boolean flag, boolean flag1, boolean flag2, boolean flag3, String s1, String s2, 
            String s3, String s4, String s5, String s6, String s7)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(40), null));
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("JSUtilityController-> playVideo: url: ").append(s).append(" audioMuted: ").append(flag).append(" autoPlay: ").append(flag1).append(" controls: ").append(flag2).append(" loop: ").append(flag3).append(" x: ").append(s1).append(" y: ").append(s2).append(" width: ").append(s3).append(" height: ").append(s4).append(" startStyle: ").append(s5).append(" stopStyle: ").append(s6).append(" id:").append(s7).toString());
        JSController.Dimensions dimensions = new JSController.Dimensions();
        dimensions.x = a(s1, 0xfffe7961);
        dimensions.y = a(s2, 0xfffe7961);
        dimensions.width = a(s3, 0xfffe7961);
        dimensions.height = a(s4, 0xfffe7961);
        if (dimensions.width == 0xfffe7961 && dimensions.height == 0xfffe7961)
        {
            s1 = b();
            dimensions.x = 0;
            dimensions.y = 0;
            dimensions.width = s1[0];
            dimensions.height = s1[1];
        }
        imWebView.playVideo(s, flag, flag1, flag2, flag3, dimensions, s5, s6, s7);
    }

    public void postToSocial(int j, String s, String s1, String s2)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(21), null));
        if (!supports((new StringBuilder()).append("postToSocial.").append(j).toString()))
        {
            imWebView.raiseError((new StringBuilder()).append("Social type ").append(j).append(" is not supported.").toString(), "postToSocial");
        } else
        {
            if (s == null)
            {
                s = "";
            }
            if (s1 == null)
            {
                s = "";
            }
            String s3 = s2;
            if (s2 == null)
            {
                s3 = "";
            }
            s2 = new Intent(imWebView.getActivity(), com/inmobi/androidsdk/IMBrowserActivity);
            int k = IMBrowserActivity.generateId(new _cls4());
            s2.putExtra("extra_browser_type", 100);
            s2.putExtra("id", k);
            s2.putExtra("action", "postToSocial");
            s2.putExtra("socialType", j);
            s2.putExtra("text", s);
            s2.putExtra("link", s1);
            s2.putExtra("image", s3);
            imWebView.getActivity().startActivity(s2);
            if (imWebView.mListener != null)
            {
                imWebView.mListener.onLeaveApplication();
                return;
            }
        }
    }

    public void registerBroadcastListener()
    {
        c();
        while (b != null || android.os.Build.VERSION.SDK_INT <= 8) 
        {
            return;
        }
        try
        {
            if (a == null)
            {
                a = (DownloadManager)imWebView.getActivity().getSystemService("download");
            }
            b = new _cls1();
            if (!e)
            {
                imWebView.getActivity().registerReceiver((BroadcastReceiver)b, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
                return;
            }
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[RE]-4.5.5", "JSUtilityController-> registerBroadcastListener. Unable to register download listener", exception);
            return;
        }
        b = null;
        return;
    }

    public void registerMicListener()
    {
        if (h)
        {
            return;
        } else
        {
            h = true;
            AudioTriggerer.addEventListener(g);
            return;
        }
    }

    public void reset()
    {
        if (d != null)
        {
            d.reset();
        }
    }

    public void saveContent(String s, String s1)
    {
        imWebView.saveFile(s, s1);
    }

    public void seekAudio(String s, int j)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(38), null));
        Log.debug("[InMobi]-[RE]-4.5.5", "JSUtilityController-> seekAudio: ");
        imWebView.seekAudio(s, j);
    }

    public void seekVideo(String s, int j)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(46), null));
        Log.debug("[InMobi]-[RE]-4.5.5", "JSUtilityController-> seekVideo: ");
        imWebView.seekVideo(s, j);
    }

    public void sendMail(String s, String s1, String s2)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(28), null));
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("JSUtilityController-> sendMail: recipient: ").append(s).append(" subject: ").append(s1).append(" body: ").append(s2).toString());
        try
        {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("plain/text");
            intent.putExtra("android.intent.extra.EMAIL", new String[] {
                s
            });
            intent.putExtra("android.intent.extra.SUBJECT", s1);
            intent.putExtra("android.intent.extra.TEXT", s2);
            intent.addFlags(0x10000000);
            s = Intent.createChooser(intent, "Choose the Email Client.");
            imWebView.getActivity().startActivity(s);
            imWebView.fireOnLeaveApplication();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.debug("[InMobi]-[RE]-4.5.5", "Exception in sending mail ", s);
        }
        imWebView.raiseError("Exception in sending mail", "sendMail");
    }

    public void sendSMS(String s, String s1)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(27), null));
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("JSUtilityController-> sendSMS: recipient: ").append(s).append(" body: ").append(s1).toString());
        try
        {
            s = new Intent("android.intent.action.SENDTO", Uri.parse((new StringBuilder()).append("smsto:").append(Uri.encode(s)).toString()));
            s.putExtra("sms_body", s1);
            s.addFlags(0x10000000);
            imWebView.getActivity().startActivity(s);
            imWebView.fireOnLeaveApplication();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.debug("[InMobi]-[RE]-4.5.5", "Exception in sending SMS ", s);
        }
        imWebView.raiseError("Exception in sending SMS", "sendSMS");
    }

    public void setAudioVolume(String s, int j)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(36), null));
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("JSUtilityController-> setAudioVolume: ").append(s).append(" ").append(j).toString());
        imWebView.setAudioVolume(s, j);
    }

    public void setPlayableSettings(String s)
    {
        HashMap hashmap;
        Iterator iterator;
        s = new JSONObject(s);
        hashmap = new HashMap();
        iterator = s.keys();
_L1:
        String s1;
        if (!iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_108;
        }
        s1 = (String)iterator.next();
        try
        {
            hashmap.put(s1, s.get(s1));
        }
        catch (JSONException jsonexception)
        {
            try
            {
                Log.internal("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("Playable Ads Settings map key ").append(s1).append(" has invalid value").toString());
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Log.internal("[InMobi]-[RE]-4.5.5", "Exception setting playable settings", s);
                return;
            }
        }
          goto _L1
        imWebView.getPlayableListener().onPlayableSettingsReceived(hashmap);
        return;
    }

    public void setVideoVolume(String s, int j)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(44), null));
        Log.debug("[InMobi]-[RE]-4.5.5", "JSUtilityController-> setVideoVolume: ");
        imWebView.setVideoVolume(s, j);
    }

    public void setWebViewClosed(boolean flag)
    {
        e = flag;
    }

    public void showAlert(String s)
    {
        Log.debug("[InMobi]-[RE]-4.5.5", s);
    }

    public void showVideo(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(49), null));
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("JSUtilityController-> showVideo: id :").append(s).toString());
        imWebView.showVideo(s);
    }

    public void stopAllListeners()
    {
        try
        {
            d.stopAllListeners();
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public void storePicture(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(23), null));
        Log.debug("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("Store picture called on URL: ").append(s).toString());
        android.app.DownloadManager.Request request;
        try
        {
            s = Uri.parse(InternalSDKUtil.getFinalRedirectedUrl(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            imWebView.raiseError("Invalid URL.", "storePicture");
            return;
        }
        if (!supports("storePicture"))
        {
            break MISSING_BLOCK_LABEL_97;
        }
        request = new android.app.DownloadManager.Request(s);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, s.getLastPathSegment());
        a.enqueue(request);
        return;
        s;
        imWebView.raiseError("Unable to store.", "storePicture");
        return;
    }

    public boolean supports(String s)
    {
        Object obj;
        boolean flag6;
        boolean flag7 = true;
        boolean flag8 = true;
        flag6 = true;
        boolean flag1 = true;
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(22), null));
        if (s.equals("html5video") || s.equals("inlineVideo"))
        {
            Boolean boolean1;
            if (android.os.Build.VERSION.SDK_INT >= 11)
            {
                if (imWebView.isHardwareAccelerated() && imWebView.isEnabledHardwareAcceleration())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                boolean1 = Boolean.valueOf(flag1);
            } else
            {
                boolean1 = Boolean.valueOf(true);
            }
            f.put(s, boolean1);
            return boolean1.booleanValue();
        }
        obj = (Boolean)f.get(s);
        if (obj != null)
        {
            return ((Boolean) (obj)).booleanValue();
        }
        obj = imWebView.getActivity().getPackageManager();
        if (s.equals("tel"))
        {
            f.put(s, Boolean.valueOf(true));
            return true;
        }
        if (s.equals("sms"))
        {
            obj = new Intent("android.intent.action.VIEW");
            ((Intent) (obj)).setType("vnd.android-dir/mms-sms");
            if (imWebView.getActivity().getPackageManager().resolveActivity(((Intent) (obj)), 0x10000) == null)
            {
                obj = Boolean.valueOf(false);
            } else
            {
                obj = Boolean.valueOf(true);
            }
            f.put(s, obj);
            return ((Boolean) (obj)).booleanValue();
        }
        if (s.equals("calendar"))
        {
            obj = new Intent("android.intent.action.VIEW");
            ((Intent) (obj)).setType("vnd.android.cursor.item/event");
            if (imWebView.getActivity().getPackageManager().resolveActivity(((Intent) (obj)), 0x10000) == null)
            {
                obj = Boolean.valueOf(false);
            } else
            {
                obj = Boolean.valueOf(true);
            }
            f.put(s, obj);
            return ((Boolean) (obj)).booleanValue();
        }
        if (s.equals("microphone"))
        {
            if (((PackageManager) (obj)).checkPermission("android.permission.RECORD_AUDIO", ((PackageManager) (obj)).getNameForUid(Binder.getCallingUid())) != 0)
            {
                flag1 = false;
            }
            obj = Boolean.valueOf(flag1);
            f.put(s, obj);
            return ((Boolean) (obj)).booleanValue();
        }
        if (s.equals("storePicture"))
        {
            boolean flag2;
            if (android.os.Build.VERSION.SDK_INT > 8 && ((PackageManager) (obj)).checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", ((PackageManager) (obj)).getNameForUid(Binder.getCallingUid())) == 0)
            {
                flag2 = flag7;
            } else
            {
                flag2 = false;
            }
            obj = Boolean.valueOf(flag2);
            f.put(s, obj);
            return ((Boolean) (obj)).booleanValue();
        }
        if (s.equals("postToSocial.2") || s.equals("postToSocial.3"))
        {
            obj = Boolean.valueOf(true);
            f.put(s, obj);
            return ((Boolean) (obj)).booleanValue();
        }
        if (s.equals("takeCameraPicture"))
        {
            Object obj1 = new Intent("android.media.action.IMAGE_CAPTURE");
            obj1 = imWebView.getActivity().getPackageManager().resolveActivity(((Intent) (obj1)), 0x10000);
            boolean flag;
            if (((PackageManager) (obj)).checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", ((PackageManager) (obj)).getNameForUid(Binder.getCallingUid())) == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (obj1 == null)
            {
                obj = Boolean.valueOf(false);
            } else
            {
                boolean flag3;
                if (flag)
                {
                    flag3 = flag8;
                } else
                {
                    flag3 = false;
                }
                obj = Boolean.valueOf(flag3);
            }
            f.put(s, obj);
            return ((Boolean) (obj)).booleanValue();
        }
        if (s.equals("getGalleryImage"))
        {
            obj = new Intent("android.intent.action.PICK", android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            if (imWebView.getActivity().getPackageManager().resolveActivity(((Intent) (obj)), 0x10000) == null)
            {
                obj = Boolean.valueOf(false);
            } else
            {
                obj = Boolean.valueOf(true);
            }
            f.put(s, obj);
            return ((Boolean) (obj)).booleanValue();
        }
        if (!s.equals("vibrate")) goto _L2; else goto _L1
_L1:
        Vibrator vibrator;
        boolean flag4;
        if (((PackageManager) (obj)).checkPermission("android.permission.VIBRATE", ((PackageManager) (obj)).getNameForUid(Binder.getCallingUid())) == 0)
        {
            flag4 = true;
        } else
        {
            flag4 = false;
        }
        obj = Boolean.valueOf(flag4);
        vibrator = (Vibrator)d.imWebView.getActivity().getSystemService("vibrator");
        if (vibrator != null) goto _L4; else goto _L3
_L3:
        obj = Boolean.valueOf(false);
_L5:
        f.put(s, obj);
        return ((Boolean) (obj)).booleanValue();
_L4:
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            boolean flag5;
            if (((Boolean) (obj)).booleanValue() && vibrator.hasVibrator())
            {
                flag5 = flag6;
            } else
            {
                flag5 = false;
            }
            obj = Boolean.valueOf(flag5);
        }
        if (true) goto _L5; else goto _L2
_L2:
        return false;
    }

    public String supportsFeature(String s)
    {
        return String.valueOf(supports(s));
    }

    public String takeCameraPicture()
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(24), null));
        if (!supports("takeCameraPicture"))
        {
            Log.internal("[InMobi]-[RE]-4.5.5", "takeCameraPicture called even if it is not supported");
        } else
        {
            Intent intent = new Intent(imWebView.getActivity(), com/inmobi/androidsdk/IMBrowserActivity);
            intent.putExtra("extra_browser_type", 100);
            Object obj = new ContentValues();
            obj = mContext.getContentResolver().insert(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, ((ContentValues) (obj)));
            intent.putExtra("id", IMBrowserActivity.generateId(new _cls5(((Uri) (obj)))));
            intent.putExtra("URI", ((android.os.Parcelable) (obj)));
            intent.putExtra("action", "takeCameraPicture");
            imWebView.getActivity().startActivity(intent);
            if (imWebView.mListener != null)
            {
                imWebView.mListener.onLeaveApplication();
                return null;
            }
        }
        return null;
    }

    public void unMuteAudio(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(34), null));
        Log.debug("[InMobi]-[RE]-4.5.5", "JSUtilityController-> unMuteAudio: ");
        imWebView.unMuteAudio(s);
    }

    public void unMuteVideo(String s)
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(42), null));
        Log.debug("[InMobi]-[RE]-4.5.5", "JSUtilityController-> unMuteVideo: ");
        imWebView.unMuteVideo(s);
    }

    public void unRegisterBroadcastListener()
    {
        try
        {
            d();
            if (android.os.Build.VERSION.SDK_INT > 8)
            {
                imWebView.getActivity().unregisterReceiver((BroadcastReceiver)b);
                b = null;
            }
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[RE]-4.5.5", "JSUtilityController-> unregisterBroadcastListener. Unable to unregister download listener");
        }
    }

    public void unRegisterMicListener()
    {
        if (!h)
        {
            return;
        } else
        {
            h = false;
            AudioTriggerer.removeEventListener(g);
            return;
        }
    }

    public void vibrate()
    {
        ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(26), null));
        if (!imWebView.isViewable())
        {
            imWebView.raiseError("Creative not visible. Will not vibrate.", "vibrate");
            return;
        }
        if (supports("vibrate"))
        {
            ((Vibrator)imWebView.getActivity().getSystemService("vibrator")).vibrate(2000L);
            (new Timer()).schedule(new _cls7(), 2000L);
            return;
        } else
        {
            Log.internal("[InMobi]-[RE]-4.5.5", "vibrate called even if it is not supported");
            return;
        }
    }

    public void vibrate(String s, int j)
    {
        Vibrator vibrator;
        try
        {
            ApiStatCollector.getLogger().logEvent(new EventLog(new com.inmobi.commons.internal.ApiStatCollector.ApiEventType(26), null));
            if (!imWebView.isViewable())
            {
                imWebView.raiseError("Creative not visible. Will not vibrate.", "vibrate");
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.internal("[InMobi]-[RE]-4.5.5", "vibrate exception", s);
            return;
        }
        if (!supports("vibrate")) goto _L2; else goto _L1
_L1:
        vibrator = (Vibrator)imWebView.getActivity().getSystemService("vibrator");
        s = s.replaceAll("\\[", "").replaceAll("\\]", "");
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        if (!"".equals(s.trim()))
        {
            break MISSING_BLOCK_LABEL_128;
        }
        vibrator.cancel();
        return;
        long al[];
        int k;
        s = s.split(",");
        k = s.length;
        if (k > Initializer.getConfigParams().getMaxVibPatternLength())
        {
            Log.internal("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("vibration pattern exceeds max length. Will be truncated to max ").append(Initializer.getConfigParams().getMaxVibPatternLength()).append("ms").toString());
            k = Initializer.getConfigParams().getMaxVibPatternLength();
        }
        al = new long[k];
        int l = 0;
_L10:
        if (l >= k) goto _L4; else goto _L3
_L3:
        al[l] = Long.parseLong(s[l]);
        if (al[l] > (long)Initializer.getConfigParams().getMaxVibDuration())
        {
            Log.internal("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("vibration duration exceeds max. Will only vibrate for max ").append(Initializer.getConfigParams().getMaxVibDuration()).append("ms").toString());
            al[l] = Initializer.getConfigParams().getMaxVibDuration();
        }
        if (al[l] >= 0L) goto _L6; else goto _L5
_L5:
        imWebView.raiseError("Negative duration not allowed in vibration .", "vibrate");
          goto _L6
        s;
        imWebView.raiseError("Invalid values of pattern in vibration .", "vibrate");
        return;
_L4:
        if (al == null) goto _L8; else goto _L7
_L7:
        if (al.length != 0)
        {
            vibrator.vibrate(al, j);
            return;
        }
          goto _L8
_L2:
        imWebView.raiseError("Vibrate called even if it is not supported.", "vibrate");
        Log.internal("[InMobi]-[RE]-4.5.5", "vibrate called even if it is not supported");
        return;
_L8:
        return;
_L6:
        l++;
        if (true) goto _L10; else goto _L9
_L9:
    }

    static 
    {
        formats = (new SimpleDateFormat[] {
            new SimpleDateFormat("yyyy-MM-dd'T'hh:mmZ", Locale.ENGLISH), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ENGLISH), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz", Locale.ENGLISH), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH), new SimpleDateFormat("yyyyMMddHHmmssZ", Locale.ENGLISH), new SimpleDateFormat("yyyyMMddHHmm", Locale.ENGLISH), new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH), new SimpleDateFormat("yyyyMM", Locale.ENGLISH), new SimpleDateFormat("yyyy", Locale.ENGLISH)
        });
    }

    /* member class not found */
    class _cls8 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls7 {}

}
