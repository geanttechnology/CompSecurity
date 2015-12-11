// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.advertising;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Vibrator;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.medialets.analytics.MMEvent;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIUtils;

// Referenced classes of package com.medialets.advertising:
//            n, o, p, q, 
//            AdView, a, aa, AdWebView, 
//            i, t, BannerAdView, x, 
//            y, ae, d

public class JSBridge extends WebViewClient
    implements i.b, t.a
{
    private final class a
        implements Runnable
    {

        private String a;
        private JSBridge b;

        public final void run()
        {
            JSBridge.a(b, a, true);
        }

        public a(String s)
        {
            b = JSBridge.this;
            super();
            a = s;
        }
    }

    private final class b
        implements Runnable
    {

        private String a;
        private int b;
        private JSBridge c;

        private void a()
        {
            if (b != 10) goto _L2; else goto _L1
_L1:
            com.medialets.advertising.a.c((new StringBuilder()).append("Maximum number (").append(10).append(") of redirects").append(" reached").toString());
_L4:
            return;
_L2:
            if (JSBridge.a(c, a))
            {
                JSBridge.a(c).post(c. new c(a, true));
                return;
            }
            if (!y.b())
            {
                JSBridge.a(c).post(c.mLoadingViewRunnable);
                return;
            }
            if (JSBridge.b(c)) goto _L4; else goto _L3
_L3:
            Object obj;
            d d1;
            HttpGet httpget;
            int i1;
            try
            {
                d1 = com.medialets.advertising.d.a(JSBridge.c(c).getAdWebView().getSettings().getUserAgentString(), false);
                a = a.replace(" ", "%20");
                httpget = new HttpGet(a);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                com.medialets.advertising.a.c((new StringBuilder()).append("Illegal URL will not load: ").append(((IllegalArgumentException) (obj)).toString()).toString());
                JSBridge.a(c).post(c.mLoadingViewRunnable);
                return;
            }
            if (JSBridge.b(c)) goto _L4; else goto _L5
_L5:
            com.medialets.advertising.a.d((new StringBuilder()).append("Processing URL: ").append(a).toString());
            obj = d1.execute(httpget, d1.a(JSBridge.d(c), a));
            i1 = ((HttpResponse) (obj)).getStatusLine().getStatusCode();
            com.medialets.advertising.a.d((new StringBuilder()).append("URL request response code: ").append(i1).toString());
            if (i1 != 200) goto _L7; else goto _L6
_L6:
            if (!a.startsWith("http")) goto _L9; else goto _L8
_L8:
            JSBridge.a(c).post(c. new c(a, JSBridge.a(c, a)));
_L10:
            d1.a();
            JSBridge.a(c).post(c.mLoadingViewRunnable);
            return;
_L9:
            JSBridge.a(c).post(c. new a(a));
              goto _L10
            obj;
            com.medialets.advertising.a.c((new StringBuilder()).append("Exception while opening URL: ").append(a).append(": ").append(((Exception) (obj)).toString()).toString());
            d1.a();
            JSBridge.a(c).post(c.mLoadingViewRunnable);
            return;
_L7:
            if (i1 < 300 || i1 >= 400)
            {
                break MISSING_BLOCK_LABEL_644;
            }
            String s = ((HttpResponse) (obj)).getHeaders("Location")[0].getValue();
            if (i1 != 301)
            {
                obj = s;
                if (i1 != 302)
                {
                    break MISSING_BLOCK_LABEL_540;
                }
            }
            obj = URIUtils.resolve(httpget.getURI(), s).toString();
            com.medialets.advertising.a.d((new StringBuilder()).append("Loading redirect URL: ").append(((String) (obj))).toString());
            if (!((String) (obj)).startsWith("http"))
            {
                break MISSING_BLOCK_LABEL_618;
            }
            a = ((String) (obj));
            b = b + 1;
            a();
              goto _L10
            obj;
            d1.a();
            JSBridge.a(c).post(c.mLoadingViewRunnable);
            throw obj;
            JSBridge.a(c).post(c. new a(((String) (obj))));
              goto _L10
            com.medialets.advertising.a.c("Response code unrecognised");
              goto _L10
        }

        public final void run()
        {
            a();
        }

        public b(String s)
        {
            c = JSBridge.this;
            super();
            a = s;
            b = 0;
        }
    }

    private final class c
        implements Runnable
    {

        private String a;
        private boolean b;
        private JSBridge c;

        public final void run()
        {
            if (b)
            {
                c.openVideoPlayer(a);
                return;
            } else
            {
                c.openEmbeddedBrowser(a);
                return;
            }
        }

        public c(String s, boolean flag)
        {
            c = JSBridge.this;
            super();
            a = s;
            b = flag;
        }
    }


    private static Class d = com/medialets/advertising/JSBridge;
    private MediaPlayer a;
    private SensorManager b;
    private Context c;
    private float e;
    private float f;
    private boolean g;
    private Handler h;
    private float i;
    private float j;
    private float k;
    private AdView l;
    private SensorEventListener m;
    protected Runnable mDismissRunnable;
    protected Runnable mExpandRunnable;
    protected Runnable mLoadingViewRunnable;

    public JSBridge(AdView adview)
    {
        g = false;
        h = new Handler();
        mExpandRunnable = new n(this);
        mDismissRunnable = new o(this);
        mLoadingViewRunnable = new p(this);
        m = new q(this);
        c = adview.getContext();
        l = adview;
        b = (SensorManager)c.getSystemService("sensor");
        a = new MediaPlayer();
    }

    static float a(JSBridge jsbridge, float f1)
    {
        jsbridge.i = f1;
        return f1;
    }

    static Handler a(JSBridge jsbridge)
    {
        return jsbridge.h;
    }

    static Class a()
    {
        return d;
    }

    private void a(String s)
    {
        int i1 = s.indexOf("?");
        HashMap hashmap = new HashMap();
        String s1 = s;
        if (i1 >= 0)
        {
            s1 = s.substring(0, s.indexOf("?"));
            s = s.substring(s.indexOf("?") + 1).split("&");
            for (int j1 = 0; j1 < s.length; j1++)
            {
                String as[] = s[j1].split("=");
                if (as.length > 1)
                {
                    hashmap.put(as[0], as[1]);
                }
            }

        }
        try
        {
            com/medialets/advertising/JSBridge.getDeclaredMethod(s1, new Class[] {
                java/util/HashMap
            }).invoke(this, new Object[] {
                hashmap
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.medialets.advertising.a.c((new StringBuilder()).append("Error invoking bridge method: ").append(s1).append(": ").append(s.getTargetException().toString()).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.medialets.advertising.a.c((new StringBuilder()).append("Cannot access bridge method: ").append(s1).append(": ").append(s.toString()).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            com.medialets.advertising.a.c((new StringBuilder()).append("Cannot find bridge method: ").append(s1).append(": ").append(s.toString()).toString());
        }
    }

    static boolean a(JSBridge jsbridge, String s)
    {
        return b(s);
    }

    static boolean a(JSBridge jsbridge, String s, boolean flag)
    {
        return jsbridge.a(s, true);
    }

    private boolean a(String s, boolean flag)
    {
        boolean flag1 = true;
        s = s.trim();
        if (!aa.a(s, "mmbridge:", true)) goto _L2; else goto _L1
_L1:
        if (!s.startsWith("mmbridge:batchedEvents")) goto _L4; else goto _L3
_L3:
        s = s.substring(s.indexOf("?") + 1).split("&");
        int i1 = 0;
        do
        {
            flag = flag1;
            try
            {
                if (i1 >= s.length)
                {
                    break;
                }
                a(URLDecoder.decode(s[i1]));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                com.medialets.advertising.a.c(s.getMessage());
                return false;
            }
            i1++;
        } while (true);
          goto _L5
_L4:
        a(s.substring(9));
        return true;
_L2:
        if (!s.startsWith("medialets:noAd")) goto _L7; else goto _L6
_L6:
        com.medialets.advertising.a.a("Did not receive an ad.");
        flag = flag1;
        if (l.mAdListener == null) goto _L5; else goto _L8
_L8:
        l.mAdListener.onNoAdsAvailable(l);
        return true;
_L7:
        if (!s.startsWith("medialets:"))
        {
            break MISSING_BLOCK_LABEL_188;
        }
        com.medialets.advertising.a.a((new StringBuilder()).append("Received a Medialets ad tag request: ").append(s).toString());
        l.loadAdTag(null, s);
        return true;
        if (l.isClicked()) goto _L10; else goto _L9
_L9:
        l.setClicked(true);
        l.showLoadingView();
_L15:
        if (b != null)
        {
            b.unregisterListener(m);
        }
        if (!s.startsWith("tel:")) goto _L12; else goto _L11
_L11:
        l.dismissLoadingView();
        l.setClicked(false);
        l.getAdEvent().incrementNumberForKey("MMAdClickThru_Phone");
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(s));
        intent.addFlags(0x10000000);
        com.medialets.advertising.a.a((new StringBuilder()).append("Telephone link requested: ").append(s).toString());
        c.startActivity(intent);
        return true;
_L12:
        if (!s.startsWith("market:"))
        {
            break MISSING_BLOCK_LABEL_419;
        }
        l.dismissLoadingView();
        l.setClicked(false);
        l.getAdEvent().incrementNumberForKey("MMAdClickThru_AppStore");
        Intent intent1 = new Intent("android.intent.action.VIEW", Uri.parse(s));
        intent1.addFlags(0x10000000);
        com.medialets.advertising.a.a((new StringBuilder()).append("Android Market link requested: ").append(s).toString());
        c.startActivity(intent1);
        return true;
        if (!s.startsWith("sms:"))
        {
            break MISSING_BLOCK_LABEL_513;
        }
        l.dismissLoadingView();
        l.setClicked(false);
        l.getAdEvent().incrementNumberForKey("MMAdClickThru_SMS");
        Intent intent2 = new Intent("android.intent.action.SENDTO", Uri.parse(s));
        intent2.addFlags(0x10000000);
        com.medialets.advertising.a.a((new StringBuilder()).append("SMS link requested: ").append(s).toString());
        c.startActivity(intent2);
        return true;
        if (!s.startsWith("http://maps.google.com/maps?"))
        {
            break MISSING_BLOCK_LABEL_631;
        }
        l.dismissLoadingView();
        l.setClicked(false);
        l.getAdEvent().incrementNumberForKey("MMAdClickThru_GoogleMaps");
        Intent intent3 = new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("geo:0,0").append(s.substring(27)).toString()));
        intent3.addFlags(0x10000000);
        com.medialets.advertising.a.a((new StringBuilder()).append("Google Maps link requested: ").append(s).toString());
        c.startActivity(intent3);
        return true;
        if (!s.startsWith("mailto:")) goto _L14; else goto _L13
_L13:
        Intent intent4;
        l.dismissLoadingView();
        l.setClicked(false);
        l.getAdEvent().incrementNumberForKey("MMAdClickThru_Email");
        com.medialets.advertising.a.a((new StringBuilder()).append("E-Mail link requested: ").append(s).toString());
        intent4 = new Intent("android.intent.action.SENDTO", Uri.parse(s.substring(0, s.indexOf("?"))));
        intent4.addFlags(0x10000000);
        s = s.substring(s.indexOf("?") + 1).split("&");
        int j1 = 0;
_L16:
        if (j1 < s.length)
        {
            String as[] = s[j1].split("=");
            if (as[0].equals("subject"))
            {
                intent4.putExtra("android.intent.extra.SUBJECT", URLDecoder.decode(as[1]));
            }
            if (as[0].equals("cc"))
            {
                intent4.putExtra("android.intent.extra.CC", URLDecoder.decode(as[1]));
            }
            if (as[0].equals("body"))
            {
                intent4.putExtra("android.intent.extra.TEXT", URLDecoder.decode(as[1]));
            }
            break MISSING_BLOCK_LABEL_1026;
        }
        c.startActivity(intent4);
        return true;
_L14:
        if (!b(s))
        {
            break MISSING_BLOCK_LABEL_890;
        }
        l.dismissLoadingView();
        l.setClicked(false);
        openVideoPlayer(s);
        return true;
        if (!s.startsWith("file://"))
        {
            break MISSING_BLOCK_LABEL_964;
        }
        com.medialets.advertising.a.a((new StringBuilder()).append("Loading local file: ").append(s).toString());
        l.dismissLoadingView();
        l.setClicked(false);
        l.getAdWebView().load(s.substring(s.indexOf("file://") + 8));
        return true;
        if (!s.startsWith("http"))
        {
            break MISSING_BLOCK_LABEL_995;
        }
        (new Thread(new b(s))).start();
        return true;
        HashMap hashmap = new HashMap();
        hashmap.put("appURL", s);
        flag = launchApp(hashmap);
_L5:
        return flag;
_L10:
        if (!flag)
        {
            return true;
        }
          goto _L15
        j1++;
          goto _L16
    }

    static float b(JSBridge jsbridge, float f1)
    {
        jsbridge.j = f1;
        return f1;
    }

    static boolean b(JSBridge jsbridge)
    {
        return jsbridge.g;
    }

    private static boolean b(String s)
    {
        return s.endsWith(".m4v") || s.endsWith(".mov") || s.endsWith(".3gp") || s.endsWith(".mp4") || s.endsWith(".webm");
    }

    static float c(JSBridge jsbridge, float f1)
    {
        jsbridge.k = f1;
        return f1;
    }

    static AdView c(JSBridge jsbridge)
    {
        return jsbridge.l;
    }

    static Context d(JSBridge jsbridge)
    {
        return jsbridge.c;
    }

    static float e(JSBridge jsbridge)
    {
        return jsbridge.e;
    }

    static float f(JSBridge jsbridge)
    {
        return jsbridge.i;
    }

    static float g(JSBridge jsbridge)
    {
        return jsbridge.j;
    }

    static float h(JSBridge jsbridge)
    {
        return jsbridge.k;
    }

    static float i(JSBridge jsbridge)
    {
        return jsbridge.f;
    }

    protected void cleanUp()
    {
        g = true;
        if (b != null)
        {
            b.unregisterListener(m);
        }
        if (a != null)
        {
            a.stop();
        }
        if (l.getBrowser() != null)
        {
            l.getBrowser().b(this);
        }
        t.a().b(this);
    }

    protected void clickThrough(HashMap hashmap)
    {
        hashmap = (String)hashmap.get("url");
        if (hashmap != null)
        {
            hashmap = com.medialets.advertising.i.a(l, hashmap);
            l.setBrowser(hashmap);
            return;
        } else
        {
            com.medialets.advertising.a.c("URL of null has been passed, request ignored...");
            return;
        }
    }

    protected void closeBrowser(HashMap hashmap)
    {
        if (l.getBrowser() != null)
        {
            l.getBrowser().dismiss();
        }
    }

    public void dismissAd()
    {
        h.post(mDismissRunnable);
    }

    protected void dismissAd(HashMap hashmap)
    {
        if (l.getSlotType() != 1 && !l.isDismissing())
        {
            l.dismiss();
        }
    }

    protected void endTimerForKey(HashMap hashmap)
    {
        if (l.getAdEvent() != null)
        {
            l.getAdEvent().endTimerForKey((String)hashmap.get("key"));
        }
    }

    public void expandAd()
    {
        h.post(mExpandRunnable);
    }

    protected void expandAd(HashMap hashmap)
    {
        if (l.getSlotType() == 1)
        {
            ((BannerAdView)l).expand();
        }
    }

    protected void forceExpand(HashMap hashmap)
    {
        if (l.getSlotType() == 1)
        {
            ((BannerAdView)l).expand(true);
        }
    }

    protected void getaccel(HashMap hashmap)
    {
        String s = (String)hashmap.get("start");
        if (s.equals("true"))
        {
            e = Float.parseFloat((String)hashmap.get("filteringFactor"));
            f = 2.0F;
            com.medialets.advertising.a.d("Initializing the sensor hardware...");
            hashmap = b.getSensorList(1);
            b.registerListener(m, (Sensor)hashmap.get(0), 3);
        } else
        if (s.equals("false"))
        {
            com.medialets.advertising.a.d("Releasing the sensor hardware...");
            b.unregisterListener(m);
            return;
        }
    }

    protected void incrementKey(HashMap hashmap)
    {
        if (l.getAdEvent() != null)
        {
            l.getAdEvent().incrementNumberForKey((String)hashmap.get("key"));
        }
    }

    public void init()
    {
        l.getAdWebView().loadUrl((new StringBuilder()).append("javascript:MMBridge.init('2.2', 'Android', '").append(x.ANDROID_VERSION).append("', '").append(y.a(y.d())).append("');").toString());
    }

    protected void initOrientation(HashMap hashmap)
    {
        hashmap = t.a();
        hashmap.a(this);
        int i1 = hashmap.getOrientation();
        hashmap = (new StringBuilder()).append("javascript: if (Device.Orientation.callback) Device.Orientation.callback(").append(i1).append(");").toString();
        l.getAdWebView().loadUrl(hashmap);
    }

    protected boolean launchApp(HashMap hashmap)
    {
        Object obj = (String)hashmap.get("appURL");
        hashmap = (String)hashmap.get("alternateID");
        if (obj != null)
        {
            obj = URLDecoder.decode(((String) (obj)));
            if (hashmap != null)
            {
                hashmap = URLDecoder.decode(hashmap);
            } else
            {
                com.medialets.advertising.a.d("alternate url passed to launchApp is null");
            }
            obj = new Intent("android.intent.action.VIEW", Uri.parse(((String) (obj))));
            l.setClicked(true);
            l.showLoadingView();
            try
            {
                c.startActivity(((Intent) (obj)));
            }
            catch (ActivityNotFoundException activitynotfoundexception)
            {
                if (hashmap == null)
                {
                    l.dismissLoadingView();
                    l.setClicked(false);
                    return false;
                }
                com.medialets.advertising.a.d((new StringBuilder()).append("App not found, launching alternative: ").append(hashmap).toString());
                a(hashmap, true);
            }
            l.getAdEvent().incrementNumberForKey("MMAdClickThru_CustomApp");
            return true;
        } else
        {
            return false;
        }
    }

    public void launchYoutube(String s)
    {
        if (s != null)
        {
            l.getAdEvent().incrementNumberForKey("MMAdClickThru_YouTube");
            HashMap hashmap = new HashMap();
            hashmap.put("url", s);
            launchYoutube(hashmap);
        }
    }

    protected void launchYoutube(HashMap hashmap)
    {
        hashmap = URLDecoder.decode((String)hashmap.get("url"));
        Intent intent = new Intent();
        intent.addFlags(0x10000000);
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(hashmap));
        c.startActivity(intent);
    }

    protected void loadViewWithBridge()
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream(8192);
        String s = String.format("%s/%s/%s/mmbridge.js", new Object[] {
            c.getFilesDir(), "medialytics", l.mAdvertisement.d()
        });
        try
        {
            aa.a(new RandomAccessFile(s, "r"), bytearrayoutputstream);
        }
        catch (Exception exception)
        {
            com.medialets.advertising.a.c((new StringBuilder()).append("Exception loading webview: ").append(s).append(": ").append(exception.toString()).toString());
        }
        l.getAdWebView().loadUrl((new StringBuilder()).append("javascript:").append(bytearrayoutputstream.toString()).toString());
    }

    protected void log(HashMap hashmap)
    {
        com.medialets.advertising.a.a(URLDecoder.decode((String)hashmap.get("message")));
    }

    public void onBrowserComplete(String s)
    {
        s = (new StringBuilder()).append("javascript:if (Device.Browser.onComplete) Device.Browser.onComplete.callback('").append(s).append("');").toString();
        l.getAdWebView().loadUrl(s);
    }

    public void onBrowserRequest(String s)
    {
        s = (new StringBuilder()).append("javascript:if (Device.Browser.onRequest) Device.Browser.onRequest.callback('").append(s).append("');").toString();
        l.getAdWebView().loadUrl(s);
    }

    protected void onCollapseComplete()
    {
        l.getAdWebView().loadUrl("javascript: if (Device.AdData.onCollapseComplete) Device.AdData.onCollapseComplete.callback();");
    }

    protected void onCollapseStart()
    {
        l.getAdWebView().loadUrl("javascript: if (Device.AdData.onCollapseStart) Device.AdData.onCollapseStart.callback();");
    }

    protected void onExpandComplete()
    {
        l.getAdWebView().loadUrl("javascript: if (Device.AdData.onExpandComplete) Device.AdData.onExpandComplete.callback();");
    }

    protected void onExpandStart()
    {
        l.getAdWebView().loadUrl("javascript: if (Device.AdData.onExpandStart) Device.AdData.onExpandStart.callback();");
    }

    public void onOrientationChange(int i1)
    {
        String s = (new StringBuilder()).append("javascript: if (Device.Orientation.callback) Device.Orientation.callback(").append(i1).append(");").toString();
        l.getAdWebView().loadUrl(s);
    }

    public void onPageFinished(WebView webview, String s)
    {
        init();
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        loadViewWithBridge();
        init();
    }

    protected void openEmbeddedBrowser(String s)
    {
        if (g)
        {
            return;
        } else
        {
            l.getAdEvent().incrementNumberForKey("MMAdClickThru_Browser");
            com.medialets.advertising.a.a("openEmbeddedBrowser in JSBridge");
            com.medialets.advertising.a.a((new StringBuilder()).append("start time from ad view = ").append(l.mStartTime).toString());
            s = com.medialets.advertising.i.a(l, s);
            s.a(this);
            l.setBrowser(s);
            return;
        }
    }

    protected void openVideoPlayer(String s)
    {
        if (g)
        {
            return;
        }
        l.getAdEvent().incrementNumberForKey("MMAdClickThru_Video");
        String s1 = s;
        if (!s.startsWith("http"))
        {
            s1 = String.format("%s/%s/%s/%s", new Object[] {
                c.getFilesDir(), "medialytics", l.getAdvertisement().d(), s
            });
        }
        s = new Intent();
        s.addFlags(0x10000000);
        s.setAction("android.intent.action.VIEW");
        s.setDataAndType(Uri.parse(s1), "video/mp4");
        c.startActivity(s);
    }

    public void playVideo(String s)
    {
        if (s != null)
        {
            openVideoPlayer(s);
        }
    }

    protected void playVideo(HashMap hashmap)
    {
        l.getAdEvent().incrementNumberForKey("MMAdClickThru_Video");
        Object obj = URLDecoder.decode((String)hashmap.get("videoURL"));
        hashmap = ((HashMap) (obj));
        if (!((String) (obj)).startsWith("http"))
        {
            hashmap = String.format("%s/%s/%s/%s", new Object[] {
                c.getFilesDir(), "medialytics", l.getAdvertisement().d(), obj
            });
        }
        obj = new Intent();
        ((Intent) (obj)).setAction("android.intent.action.VIEW");
        ((Intent) (obj)).addFlags(0x10000000);
        ((Intent) (obj)).setDataAndType(Uri.parse(hashmap), "video/mp4");
        c.startActivity(((Intent) (obj)));
    }

    public void playsound(String s)
    {
        if (s != null)
        {
            HashMap hashmap = new HashMap();
            hashmap.put("file", s);
            playsound(hashmap);
        }
    }

    protected void playsound(HashMap hashmap)
    {
        hashmap = (String)hashmap.get("file");
        if (hashmap == null && a.isPlaying())
        {
            a.stop();
            return;
        }
        if (hashmap.equals("undefined") && a.isPlaying())
        {
            a.stop();
            return;
        }
        if (a.isPlaying())
        {
            a.stop();
        }
        hashmap = String.format("%s/%s/%s/%s", new Object[] {
            c.getFilesDir(), "medialytics", l.getAdvertisement().d(), hashmap
        });
        try
        {
            FileInputStream fileinputstream = new FileInputStream(hashmap);
            a.reset();
            a.setDataSource(fileinputstream.getFD());
            a.prepare();
        }
        catch (FileNotFoundException filenotfoundexception)
        {
            com.medialets.advertising.a.c((new StringBuilder()).append("Could not find audio file: ").append(hashmap).append(": ").append(filenotfoundexception.toString()).toString());
            return;
        }
        catch (IOException ioexception)
        {
            com.medialets.advertising.a.c((new StringBuilder()).append("IOException reading audio file: ").append(hashmap).append(": ").append(ioexception.toString()).toString());
            return;
        }
        a.start();
    }

    protected void recordDuration(HashMap hashmap)
    {
        if (l.getAdEvent() != null)
        {
            l.getAdEvent().setDurationForKey((String)hashmap.get("timedEvent"), Double.valueOf(Double.parseDouble((String)hashmap.get("ms"))));
        }
    }

    protected void setDurationForKey(HashMap hashmap)
    {
        if (l.getAdEvent() != null)
        {
            l.getAdEvent().setDurationForKey((String)hashmap.get("key"), Double.valueOf(Double.parseDouble((String)hashmap.get("val"))));
        }
    }

    protected void setTrackingEventNumber(HashMap hashmap)
    {
        if (l.getAdEvent() != null)
        {
            l.getAdEvent().setNumberForKey((String)hashmap.get("key"), Double.valueOf(Double.parseDouble((String)hashmap.get("val"))));
        }
    }

    protected void setTrackingEventString(HashMap hashmap)
    {
        if (l.getAdEvent() != null)
        {
            l.getAdEvent().setStringForKey((String)hashmap.get("key"), (String)hashmap.get("val"));
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        return a(s, false);
    }

    protected void startTimerForKey(HashMap hashmap)
    {
        if (l.getAdEvent() != null)
        {
            l.getAdEvent().startTimerForKey((String)hashmap.get("key"));
        }
    }

    public void vibrate()
    {
        vibrate(new HashMap());
    }

    protected void vibrate(HashMap hashmap)
    {
        ((Vibrator)c.getSystemService("vibrator")).vibrate(200L);
    }


    // Unreferenced inner class com/medialets/advertising/n
    final class n
        implements Runnable
    {

        private JSBridge a;

        public final void run()
        {
            a.expandAd(new HashMap());
        }

            n()
            {
                a = JSBridge.this;
                super();
            }
    }


    // Unreferenced inner class com/medialets/advertising/o
    final class o
        implements Runnable
    {

        private JSBridge a;

        public final void run()
        {
            a.dismissAd(new HashMap());
        }

            o()
            {
                a = JSBridge.this;
                super();
            }
    }


    // Unreferenced inner class com/medialets/advertising/p
    final class p
        implements Runnable
    {

        private JSBridge a;

        public final void run()
        {
            if (JSBridge.c(a) != null)
            {
                JSBridge.c(a).dismissLoadingView();
                JSBridge.c(a).setClicked(false);
            }
        }

            p()
            {
                a = JSBridge.this;
                super();
            }
    }


    // Unreferenced inner class com/medialets/advertising/q
    final class q
        implements SensorEventListener
    {

        private JSBridge a;

        public final void onAccuracyChanged(Sensor sensor, int i1)
        {
        }

        public final void onSensorChanged(SensorEvent sensorevent)
        {
            sensorevent = sensorevent.values;
            Class class1 = JSBridge.a();
            class1;
            JVM INSTR monitorenter ;
            float f1;
            float f2;
            float f3;
            f1 = sensorevent[0] / 9.81F;
            f2 = sensorevent[1] / 9.81F;
            f3 = sensorevent[2] / 9.81F;
            if (f1 >= 0.0F) goto _L2; else goto _L1
_L1:
            f1 = Math.abs(f1);
_L5:
            if (f2 >= 0.0F) goto _L4; else goto _L3
_L3:
            f2 = Math.abs(f2);
_L6:
            if (f3 >= 0.0F)
            {
                break MISSING_BLOCK_LABEL_475;
            }
            f3 = Math.abs(f3);
_L7:
            float f4;
            JSBridge.a(a, JSBridge.e(a) * f1 + JSBridge.f(a) * (1.0F - JSBridge.e(a)));
            JSBridge.b(a, JSBridge.e(a) * f2 + JSBridge.g(a) * (1.0F - JSBridge.e(a)));
            JSBridge.c(a, JSBridge.e(a) * f3 + JSBridge.h(a) * (1.0F - JSBridge.e(a)));
            f4 = f1 - JSBridge.f(a);
            float f5 = f2 - JSBridge.g(a);
            float f6 = f3 - JSBridge.h(a);
            f4 = (float)Math.sqrt(f4 * f4 + f5 * f5 + f6 * f6);
            sensorevent = "";
            if (f4 <= JSBridge.i(a))
            {
                break MISSING_BLOCK_LABEL_259;
            }
            com.medialets.advertising.a.a("Shake event has been detected...");
            sensorevent = "if (Device.Acceleration.shakeCallback) Device.Acceleration.shakeCallback();";
            String s = String.format("javascript:if (Device.Acceleration._callback) Device.Acceleration._callback('%f', '%f', '%f', '%f','%f', '%f'); %s", new Object[] {
                Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(JSBridge.f(a)), Float.valueOf(JSBridge.g(a)), Float.valueOf(JSBridge.h(a)), sensorevent
            });
            sensorevent = String.format("javascript:if (Device.Acceleration._callback) Device.Acceleration._callback('%f', '%f', '%f', '%f','%f', '%f'); %s", new Object[] {
                Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(JSBridge.f(a)), Float.valueOf(JSBridge.g(a)), Float.valueOf(JSBridge.h(a)), sensorevent
            });
            if (JSBridge.c(a) != null)
            {
                JSBridge.c(a).getAdWebView().loadUrl(s);
                JSBridge.c(a).getAdWebView().loadUrl(sensorevent);
            }
            class1;
            JVM INSTR monitorexit ;
            return;
            sensorevent;
            class1;
            JVM INSTR monitorexit ;
            throw sensorevent;
_L2:
            f1 = -f1;
              goto _L5
_L4:
            f2 = -f2;
              goto _L6
            f3 = -f3;
              goto _L7
        }

            q()
            {
                a = JSBridge.this;
                super();
            }
    }

}
