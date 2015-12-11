// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.androidsdk;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.WrapperFunctions;
import com.inmobi.re.container.CustomView;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.mraidimpl.MRAIDAudioVideoController;
import com.inmobi.re.container.mraidimpl.MRAIDExpandController;
import com.inmobi.re.container.mraidimpl.MRAIDInterstitialController;
import com.inmobi.re.controller.JSUtilityController;
import com.inmobi.re.controller.util.StartActivityForResultCallback;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class IMBrowserActivity extends Activity
{

    public static final String ANIMATED = "isAnimationEnabledOnDimiss";
    public static final int BROWSER_ACTIVITY = 100;
    public static final int CLOSE_BUTTON_VIEW_ID = 225;
    public static final int CLOSE_REGION_VIEW_ID = 226;
    public static final String EXPANDDATA = "data";
    public static final int EXPAND_ACTIVITY = 102;
    public static final String EXTRA_BROWSER_ACTIVITY_TYPE = "extra_browser_type";
    public static final String EXTRA_URL = "extra_url";
    public static final int GET_IMAGE = 101;
    public static final int INTERSTITIAL_ACTIVITY = 101;
    private static IMWebView b;
    private static com.inmobi.re.container.IMWebView.IMWebViewListener c;
    private static IMWebView d;
    private static FrameLayout e;
    private static Message f;
    private static Map l = new HashMap();
    private static int m = 0;
    private static Activity o;
    private IMWebView a;
    private RelativeLayout g;
    private float h;
    private Boolean i;
    private CustomView j;
    private long k;
    private int n;
    private WebViewClient p;

    public IMBrowserActivity()
    {
        k = 0L;
        p = new WebViewClient() {

            final IMBrowserActivity a;

            public void onPageFinished(WebView webview, String s)
            {
                super.onPageFinished(webview, s);
                if (IMBrowserActivity.b(a) != null)
                {
                    if (webview.canGoForward())
                    {
                        IMBrowserActivity.b(a).setSwitchInt(com.inmobi.re.container.CustomView.SwitchIconType.FORWARD_ACTIVE);
                        IMBrowserActivity.b(a).invalidate();
                    } else
                    {
                        IMBrowserActivity.b(a).setSwitchInt(com.inmobi.re.container.CustomView.SwitchIconType.FORWARD_INACTIVE);
                        IMBrowserActivity.b(a).invalidate();
                    }
                }
                CookieSyncManager.getInstance().sync();
            }

            public void onPageStarted(WebView webview, String s, Bitmap bitmap)
            {
                super.onPageStarted(webview, s, bitmap);
                if (IMBrowserActivity.b(a) != null)
                {
                    IMBrowserActivity.b(a).setSwitchInt(com.inmobi.re.container.CustomView.SwitchIconType.FORWARD_INACTIVE);
                    IMBrowserActivity.b(a).invalidate();
                }
            }

            
            {
                a = IMBrowserActivity.this;
                super();
            }
        };
    }

    static IMWebView a()
    {
        return d;
    }

    static IMWebView a(IMBrowserActivity imbrowseractivity)
    {
        return imbrowseractivity.a;
    }

    private String a(String s)
    {
        Object obj;
        Object obj1;
        boolean flag;
        flag = false;
        obj1 = null;
        obj = obj1;
        if (s == null) goto _L2; else goto _L1
_L1:
        obj = obj1;
        if ("".equals(s)) goto _L2; else goto _L3
_L3:
        SimpleDateFormat asimpledateformat[];
        int i1;
        int j1;
        asimpledateformat = JSUtilityController.formats;
        j1 = asimpledateformat.length;
        i1 = 0;
_L5:
        if (i1 >= j1)
        {
            break MISSING_BLOCK_LABEL_119;
        }
        obj = asimpledateformat[i1];
        obj = ((SimpleDateFormat) (obj)).parse(s);
        s = ((String) (obj));
_L7:
        asimpledateformat = JSUtilityController.calendarUntiFormats;
        j1 = asimpledateformat.length;
        i1 = ((flag) ? 1 : 0);
_L6:
        obj = obj1;
        if (i1 >= j1) goto _L2; else goto _L4
_L4:
        obj = asimpledateformat[i1];
        obj = ((SimpleDateFormat) (obj)).format(Long.valueOf(s.getTime()));
_L2:
        return ((String) (obj));
        Exception exception;
        exception;
        i1++;
          goto _L5
        exception;
        i1++;
          goto _L6
        s = null;
          goto _L7
    }

    private String a(JSONArray jsonarray)
    {
        int i1;
        i1 = 0;
        if (jsonarray == null)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        Object obj;
        if (jsonarray.length() == 0)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        obj = new StringBuilder();
_L1:
        if (i1 >= jsonarray.length())
        {
            break MISSING_BLOCK_LABEL_71;
        }
        Object obj1 = jsonarray.get(i1);
        ((StringBuilder) (obj)).append((new StringBuilder()).append(obj1).append(",").toString());
        i1++;
          goto _L1
        obj = ((StringBuilder) (obj)).toString();
        i1 = ((String) (obj)).length();
        if (i1 != 0) goto _L3; else goto _L2
_L2:
        jsonarray = null;
_L5:
        return jsonarray;
_L3:
        jsonarray = ((JSONArray) (obj));
        if (((String) (obj)).charAt(i1 - 1) != ',') goto _L5; else goto _L4
_L4:
        jsonarray = ((String) (obj)).substring(0, i1 - 1);
        return jsonarray;
        jsonarray;
        Log.internal("[InMobi]-4.5.5", "Couldn't parse json in create calendar event", jsonarray);
        return ((String) (obj));
        jsonarray;
        jsonarray.printStackTrace();
        Log.internal("[InMobi]-[RE]-4.5.5", "Exception parsing recurrence rule", jsonarray);
        return null;
    }

    private String a(JSONArray jsonarray, int i1, int j1)
    {
        int k1 = 0;
        if (jsonarray == null) goto _L2; else goto _L1
_L1:
        if (jsonarray.length() == 0) goto _L2; else goto _L3
_L3:
        Object obj = new StringBuilder();
_L8:
        if (k1 >= jsonarray.length()) goto _L5; else goto _L4
_L4:
        int l1 = jsonarray.getInt(k1);
        if (l1 < i1 || l1 > j1)
        {
            break MISSING_BLOCK_LABEL_160;
        }
        try
        {
            ((StringBuilder) (obj)).append((new StringBuilder()).append(l1).append(",").toString());
            break MISSING_BLOCK_LABEL_160;
        }
        // Misplaced declaration of an exception variable
        catch (JSONArray jsonarray)
        {
            jsonarray.printStackTrace();
            Log.internal("[InMobi]-[RE]-4.5.5", "Exception parsing recurrence rule", jsonarray);
        }
_L2:
        jsonarray = null;
_L7:
        return jsonarray;
_L5:
        obj = ((StringBuilder) (obj)).toString();
        i1 = ((String) (obj)).length();
        if (i1 == 0)
        {
            return null;
        }
        jsonarray = ((JSONArray) (obj));
        if (((String) (obj)).charAt(i1 - 1) != ',') goto _L7; else goto _L6
_L6:
        jsonarray = ((String) (obj)).substring(0, i1 - 1);
        return jsonarray;
        jsonarray;
        Log.internal("[InMobi]-4.5.5", "Couldn't parse json in create calendar event", jsonarray);
        return ((String) (obj));
        k1++;
          goto _L8
    }

    private void a(int i1, String s, String s1, String s2, int j1)
    {
        i1;
        JVM INSTR tableswitch 1 3: default 28
    //                   1 110
    //                   2 117
    //                   3 124;
           goto _L1 _L2 _L3 _L4
_L4:
        break MISSING_BLOCK_LABEL_124;
_L1:
        String s3 = null;
_L5:
        String s4;
        s4 = (new StringBuilder()).append(s).append(" ").append(s1).append(" ").append(s2).toString();
        Intent intent = new Intent();
        intent.setType("text/plain");
        intent.setPackage(s3);
        intent.putExtra("android.intent.extra.TEXT", s4);
        try
        {
            startActivityForResult(intent, j1);
            return;
        }
        catch (Exception exception) { }
        break MISSING_BLOCK_LABEL_133;
_L2:
        s3 = "";
          goto _L5
_L3:
        s3 = "com.google.android.apps.plus";
          goto _L5
        s3 = "com.twitter.android";
          goto _L5
        i1;
        JVM INSTR tableswitch 1 3: default 160
    //                   1 203
    //                   2 282
    //                   3 313;
           goto _L6 _L7 _L8 _L9
_L6:
        s = null;
_L10:
        if (s != null)
        {
            s1 = new Intent("android.intent.action.VIEW");
            s1.setData(Uri.parse(s));
            try
            {
                startActivityForResult(s1, j1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                onActivityResult(j1, 0, null);
            }
            return;
        }
        break; /* Loop/switch isn't completed */
_L7:
        s = (new StringBuilder()).append("https://www.facebook.com/dialog/feed?app_id=181821551957328&link=").append(URLEncoder.encode(s1, "UTF-8")).append("&picture=").append(URLEncoder.encode(s2, "UTF-8")).append("&name=&description=").append(URLEncoder.encode(s, "UTF-8")).append("&redirect_uri=").append(URLEncoder.encode(s1, "UTF-8")).toString();
          goto _L10
_L8:
        s = (new StringBuilder()).append("https://m.google.com/app/plus/x/?v=compose&content=").append(URLEncoder.encode(s4, "UTF-8")).toString();
          goto _L10
_L9:
        s = (new StringBuilder()).append("http://twitter.com/home?status=").append(URLEncoder.encode(s4, "UTF-8")).toString();
          goto _L10
        s;
        Log.internal("[InMobi]-[RE]-4.5.5", "UTF-8 encoding not supported? What sorcery is this?", s);
        if (true) goto _L6; else goto _L11
_L11:
        s = new Intent();
        s.setType("text/plain");
        s.putExtra("android.intent.extra.TEXT", s4);
        try
        {
            startActivityForResult(s, j1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            onActivityResult(j1, 0, null);
        }
        return;
    }

    private void a(long l1, long l2, String s, String s1, String s2, 
            String s3, String s4, int i1)
    {
        Intent intent;
        intent = new Intent("android.intent.action.EDIT");
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra("beginTime", l1);
        intent.putExtra("allDay", false);
        intent.putExtra("endTime", l2);
        intent.putExtra("title", s1);
        intent.putExtra("eventLocation", s);
        intent.putExtra("description", s2);
        if (!s3.equals("transparent")) goto _L2; else goto _L1
_L1:
        intent.putExtra("availability", 1);
_L11:
        if ("".equals(s4) || android.os.Build.VERSION.SDK_INT <= 8) goto _L4; else goto _L3
_L3:
        s = new StringBuilder();
        s1 = new JSONObject(s4);
        s2 = s1.optString("frequency");
        if (s2 == null) goto _L6; else goto _L5
_L5:
        if ("".equals(s2)) goto _L6; else goto _L7
_L7:
        if ("daily".equals(s2) || "weekly".equals(s2) || "monthly".equals(s2) || "yearly".equals(s2))
        {
            s.append((new StringBuilder()).append("freq=").append(s2).append(";").toString());
        }
        s2 = s1.optString("interval");
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_306;
        }
        if (!"".equals(s2))
        {
            s.append((new StringBuilder()).append("interval=").append(Integer.parseInt(s2)).append(";").toString());
        }
_L13:
        s2 = a(s1.optString("expires"));
        if (s2 == null) goto _L9; else goto _L8
_L8:
        s.append((new StringBuilder()).append("until=").append(s2.replace("+", "Z+").replace("-", "Z-")).append(";").toString());
_L15:
        s2 = a(s1.optJSONArray("daysInWeek"));
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_428;
        }
        s.append((new StringBuilder()).append("byday=").append(s2).append(";").toString());
        s2 = a(s1.optJSONArray("daysInMonth"), -30, 31);
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_484;
        }
        s.append((new StringBuilder()).append("bymonthday=").append(s2).append(";").toString());
        s2 = a(s1.optJSONArray("daysInYear"), -364, 365);
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_542;
        }
        s.append((new StringBuilder()).append("byyearday=").append(s2).append(";").toString());
        s2 = a(s1.optJSONArray("weeksInMonth"), -3, 4);
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_597;
        }
        s.append((new StringBuilder()).append("byweekno=").append(s2).append(";").toString());
        s1 = a(s1.optJSONArray("monthsInYear"), 1, 12);
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_652;
        }
        s.append((new StringBuilder()).append("bymonth=").append(s1).append(";").toString());
        Log.internal("[InMobi]-[RE]-4.5.5", (new StringBuilder()).append("Recurrence rule : ").append(s.toString()).toString());
_L12:
        if (!"".equals(s.toString()))
        {
            intent.putExtra("rrule", s.toString());
        }
_L4:
        startActivityForResult(intent, i1);
        return;
_L2:
        if (!s3.equals("opaque")) goto _L11; else goto _L10
_L10:
        intent.putExtra("availability", 0);
          goto _L11
_L6:
        try
        {
            if (a != null)
            {
                a.raiseError("Frequency is incorrect in recurrence rule", "createCalendarEvent");
            }
            startActivityForResult(intent, i1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s1) { }
        try
        {
            Log.internal("[InMobi]-[RE]-4.5.5", "Exception parsing recurrence rule", s1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            onActivityResult(i1, 0, null);
            return;
        }
          goto _L12
        s2;
        if (a != null)
        {
            a.raiseError("Interval is incorrect in recurrence rule", "createCalendarEvent");
        }
        Log.internal("[InMobi]-[RE]-4.5.5", "Invalid interval in recurrence rule", s2);
          goto _L13
_L9:
        if (a == null) goto _L15; else goto _L14
_L14:
        a.raiseError("Date format is incorrect in until", "createCalendarEvent");
          goto _L15
    }

    private void a(Intent intent)
    {
        Object obj;
        int i1;
        obj = intent.getStringExtra("action");
        i1 = intent.getIntExtra("id", 0);
        if (!((String) (obj)).equals("takeCameraPicture"))
        {
            break MISSING_BLOCK_LABEL_77;
        }
        intent = (Uri)intent.getExtras().get("URI");
        obj = new Intent("android.media.action.IMAGE_CAPTURE");
        ((Intent) (obj)).putExtra("output", intent);
        startActivityForResult(((Intent) (obj)), i1);
_L1:
        return;
        intent;
        onActivityResult(i1, 0, null);
        return;
        if (((String) (obj)).equals("getGalleryImage"))
        {
            intent = new Intent("android.intent.action.PICK", android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            try
            {
                startActivityForResult(intent, i1);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Intent intent)
            {
                onActivityResult(i1, 0, null);
            }
            return;
        }
        if (((String) (obj)).equals("postToSocial"))
        {
            a(intent.getIntExtra("socialType", 0), intent.getStringExtra("text"), intent.getStringExtra("link"), intent.getStringExtra("image"), i1);
            return;
        }
        if (((String) (obj)).equals("createCalendarEvent"))
        {
            a(intent.getLongExtra("start", 0L), intent.getLongExtra("end", 0L), intent.getStringExtra("location"), intent.getStringExtra("description"), intent.getStringExtra("summary"), intent.getStringExtra("transparency"), intent.getStringExtra("recurrence"), i1);
            return;
        }
          goto _L1
    }

    private void a(ViewGroup viewgroup)
    {
        LinearLayout linearlayout = new LinearLayout(this);
        linearlayout.setOrientation(0);
        linearlayout.setId(100);
        linearlayout.setWeightSum(100F);
        linearlayout.setOnTouchListener(new android.view.View.OnTouchListener() {

            final IMBrowserActivity a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                return true;
            }

            
            {
                a = IMBrowserActivity.this;
                super();
            }
        });
        linearlayout.setBackgroundResource(0x108009a);
        linearlayout.setBackgroundColor(0xff888888);
        Object obj = new android.widget.RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), (int)(44F * h));
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(12);
        viewgroup.addView(linearlayout, ((android.view.ViewGroup.LayoutParams) (obj)));
        viewgroup = new android.widget.LinearLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
        viewgroup.weight = 25F;
        obj = new CustomView(this, h, com.inmobi.re.container.CustomView.SwitchIconType.CLOSE_ICON);
        linearlayout.addView(((View) (obj)), viewgroup);
        ((CustomView) (obj)).setOnTouchListener(new android.view.View.OnTouchListener() {

            final IMBrowserActivity a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 1)
                {
                    view.setBackgroundColor(0xff888888);
                    a.finish();
                } else
                if (motionevent.getAction() == 0)
                {
                    view.setBackgroundColor(0xff00ffff);
                    return true;
                }
                return true;
            }

            
            {
                a = IMBrowserActivity.this;
                super();
            }
        });
        obj = new CustomView(this, h, com.inmobi.re.container.CustomView.SwitchIconType.REFRESH);
        linearlayout.addView(((View) (obj)), viewgroup);
        ((CustomView) (obj)).setOnTouchListener(new android.view.View.OnTouchListener() {

            final IMBrowserActivity a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 1)
                {
                    view.setBackgroundColor(0xff888888);
                    IMBrowserActivity.a(a).doHidePlayers();
                    IMBrowserActivity.a(a).reload();
                } else
                if (motionevent.getAction() == 0)
                {
                    view.setBackgroundColor(0xff00ffff);
                    return true;
                }
                return true;
            }

            
            {
                a = IMBrowserActivity.this;
                super();
            }
        });
        obj = new CustomView(this, h, com.inmobi.re.container.CustomView.SwitchIconType.BACK);
        linearlayout.addView(((View) (obj)), viewgroup);
        ((CustomView) (obj)).setOnTouchListener(new android.view.View.OnTouchListener() {

            final IMBrowserActivity a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() != 1) goto _L2; else goto _L1
_L1:
                view.setBackgroundColor(0xff888888);
                if (!IMBrowserActivity.a(a).canGoBack()) goto _L4; else goto _L3
_L3:
                IMBrowserActivity.a(a).goBack();
_L6:
                return true;
_L4:
                a.finish();
                return true;
_L2:
                if (motionevent.getAction() == 0)
                {
                    view.setBackgroundColor(0xff00ffff);
                    return true;
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

            
            {
                a = IMBrowserActivity.this;
                super();
            }
        });
        j = new CustomView(this, h, com.inmobi.re.container.CustomView.SwitchIconType.FORWARD_INACTIVE);
        linearlayout.addView(j, viewgroup);
        j.setOnTouchListener(new android.view.View.OnTouchListener() {

            final IMBrowserActivity a;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 1)
                {
                    view.setBackgroundColor(0xff888888);
                    if (IMBrowserActivity.a(a).canGoForward())
                    {
                        IMBrowserActivity.a(a).goForward();
                    }
                } else
                if (motionevent.getAction() == 0)
                {
                    view.setBackgroundColor(0xff00ffff);
                    return true;
                }
                return true;
            }

            
            {
                a = IMBrowserActivity.this;
                super();
            }
        });
    }

    static CustomView b(IMBrowserActivity imbrowseractivity)
    {
        return imbrowseractivity.j;
    }

    public static int generateId(StartActivityForResultCallback startactivityforresultcallback)
    {
        m++;
        l.put(Integer.valueOf(m), startactivityforresultcallback);
        return m;
    }

    public static void requestOnAdDismiss(Message message)
    {
        f = message;
    }

    public static void setExpandedLayout(FrameLayout framelayout)
    {
        if (framelayout != null)
        {
            e = framelayout;
        }
    }

    public static void setExpandedWebview(IMWebView imwebview)
    {
        if (imwebview != null)
        {
            d = imwebview;
        }
    }

    public static void setOriginalActivity(Activity activity)
    {
        if (activity != null)
        {
            o = activity;
        }
    }

    public static void setWebViewListener(com.inmobi.re.container.IMWebView.IMWebViewListener imwebviewlistener)
    {
        c = imwebviewlistener;
    }

    public static void setWebview(IMWebView imwebview)
    {
        if (imwebview != null)
        {
            b = imwebview;
        }
    }

    protected void onActivityResult(int i1, int j1, Intent intent)
    {
        super.onActivityResult(i1, j1, intent);
        try
        {
            ((StartActivityForResultCallback)l.get(Integer.valueOf(i1))).onActivityResult(j1, intent);
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            Log.internal("[InMobi]-[RE]-4.5.5", "onActivityResult failed", intent);
        }
        l.remove(Integer.valueOf(j1));
        if (a == null)
        {
            finish();
        }
    }

    public void onBackPressed()
    {
        if (d != null && n == 102)
        {
            d.close();
            finish();
        }
        super.onBackPressed();
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        if (configuration.orientation == 2)
        {
            Log.internal("[InMobi]-[RE]-4.5.5", "In allow true,  device orientation:ORIENTATION_LANDSCAPE");
        } else
        {
            Log.internal("[InMobi]-[RE]-4.5.5", "In allow true,  device orientation:ORIENTATION_PORTRAIT");
        }
        if (a != null)
        {
            a.onOrientationEventChange();
        }
        super.onConfigurationChanged(configuration);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Object obj;
        CookieSyncManager.createInstance(this);
        CookieSyncManager.getInstance().startSync();
        bundle = getIntent();
        n = bundle.getIntExtra("extra_browser_type", 100);
        k = bundle.getLongExtra("isAnimationEnabledOnDimiss", 0L);
        if (n != 100)
        {
            break MISSING_BLOCK_LABEL_401;
        }
        requestWindowFeature(1);
        if (android.os.Build.VERSION.SDK_INT < 9 || android.os.Build.VERSION.SDK_INT >= 11)
        {
            getWindow().setFlags(1024, 1024);
        }
        obj = (WindowManager)getSystemService("window");
        DisplayMetrics displaymetrics = new DisplayMetrics();
        ((WindowManager) (obj)).getDefaultDisplay().getMetrics(displaymetrics);
        if (bundle.getStringExtra("action") != null)
        {
            a(bundle);
        }
        h = getResources().getDisplayMetrics().density;
        obj = bundle.getStringExtra("extra_url");
        i = Boolean.valueOf(bundle.getBooleanExtra("FIRST_INSTANCE", false));
        Log.debug("[InMobi]-[RE]-4.5.5", "IMBrowserActivity-> onCreate");
        g = new RelativeLayout(this);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_653;
        }
        boolean flag;
        flag = bundle.getBooleanExtra("QAMODE", false);
        a = new IMWebView(this, c, true, true);
        bundle = new android.widget.RelativeLayout.LayoutParams(WrapperFunctions.getParamFillParent(), WrapperFunctions.getParamFillParent());
        bundle.addRule(10);
        bundle.addRule(2, 100);
        g.setBackgroundColor(-1);
        g.addView(a, bundle);
        a(g);
        a.getSettings().setJavaScriptEnabled(true);
        a.setExternalWebViewClient(p);
        a.getSettings().setLoadWithOverviewMode(true);
        a.getSettings().setUseWideViewPort(true);
        if (android.os.Build.VERSION.SDK_INT < 8) goto _L2; else goto _L1
_L1:
        a.loadUrl(((String) (obj)), null);
_L4:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_370;
        }
        bundle = new HashMap();
        bundle.put("mk-carrier", "117.97.87.6");
        bundle.put("x-real-ip", "117.97.87.6");
        setContentView(g);
        return;
_L2:
        try
        {
            a.loadUrl(((String) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            Log.internal("[InMobi]-[RE]-4.5.5", "Exception rendering ad in ImBrowser Activity", bundle);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (n != 101)
        {
            break MISSING_BLOCK_LABEL_503;
        }
        b.setActivity(this);
        b.mInterstitialController.setActivity(this);
        b.mInterstitialController.changeContentAreaForInterstitials(k);
        bundle = findViewById(225);
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_464;
        }
        bundle.setOnClickListener(new android.view.View.OnClickListener() {

            final IMBrowserActivity a;

            public void onClick(View view)
            {
                a.finish();
            }

            
            {
                a = IMBrowserActivity.this;
                super();
            }
        });
        bundle = findViewById(226);
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_488;
        }
        bundle.setOnClickListener(new android.view.View.OnClickListener() {

            final IMBrowserActivity a;

            public void onClick(View view)
            {
                a.finish();
            }

            
            {
                a = IMBrowserActivity.this;
                super();
            }
        });
        b.setOnKeyListener(new android.view.View.OnKeyListener() {

            final IMBrowserActivity a;

            public boolean onKey(View view, int i1, KeyEvent keyevent)
            {
                if (4 == keyevent.getKeyCode() && keyevent.getAction() == 0)
                {
                    a.finish();
                }
                return false;
            }

            
            {
                a = IMBrowserActivity.this;
                super();
            }
        });
        return;
        if (n != 102)
        {
            break MISSING_BLOCK_LABEL_653;
        }
        if (e != null && e.getParent() != null)
        {
            ((ViewGroup)e.getParent()).removeView(e);
        }
        setContentView(e);
        d.setState(com.inmobi.re.container.IMWebView.ViewState.EXPANDED);
        d.mIsViewable = true;
        d.mExpandController.setActivity(this);
        d.setBrowserActivity(this);
        d.mExpandController.handleOrientationForExpand();
        bundle = findViewById(225);
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_615;
        }
        bundle.setOnClickListener(new android.view.View.OnClickListener() {

            final IMBrowserActivity a;

            public void onClick(View view)
            {
                if (IMBrowserActivity.a() != null)
                {
                    IMBrowserActivity.a().close();
                }
                a.finish();
            }

            
            {
                a = IMBrowserActivity.this;
                super();
            }
        });
        bundle = findViewById(226);
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_639;
        }
        bundle.setOnClickListener(new android.view.View.OnClickListener() {

            final IMBrowserActivity a;

            public void onClick(View view)
            {
                if (IMBrowserActivity.a() != null)
                {
                    IMBrowserActivity.a().close();
                }
                a.finish();
            }

            
            {
                a = IMBrowserActivity.this;
                super();
            }
        });
        d.setOnKeyListener(new android.view.View.OnKeyListener() {

            final IMBrowserActivity a;

            public boolean onKey(View view, int i1, KeyEvent keyevent)
            {
                if (4 == keyevent.getKeyCode() && keyevent.getAction() == 0)
                {
                    if (IMBrowserActivity.a() != null)
                    {
                        IMBrowserActivity.a().close();
                    }
                    a.finish();
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                a = IMBrowserActivity.this;
                super();
            }
        });
    }

    protected void onDestroy()
    {
        super.onDestroy();
        try
        {
            c = null;
            if (a != null)
            {
                a.mAudioVideoController.releaseAllPlayers();
            }
            if (f != null && i.booleanValue())
            {
                f.sendToTarget();
                f = null;
            }
            if (b != null)
            {
                b.mAudioVideoController.releaseAllPlayers();
                b = null;
            }
            if (e != null && n == 102)
            {
                e = null;
            }
            if (d != null && n == 102)
            {
                d.setOnKeyListener(null);
                d = null;
            }
            return;
        }
        catch (Exception exception)
        {
            Log.debug("[InMobi]-[RE]-4.5.5", "Exception in onDestroy ", exception);
        }
    }

    protected void onPause()
    {
        super.onPause();
        try
        {
            CookieSyncManager.getInstance().stopSync();
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[RE]-4.5.5", "Exception pausing cookies");
        }
    }

    protected void onResume()
    {
        super.onResume();
        try
        {
            CookieSyncManager.getInstance().startSync();
            return;
        }
        catch (Exception exception)
        {
            Log.internal("[InMobi]-[RE]-4.5.5", "Exception syncing cookies");
        }
    }

}
