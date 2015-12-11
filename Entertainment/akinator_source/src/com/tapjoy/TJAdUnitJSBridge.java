// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.tapjoy.internal.cw;
import com.tapjoy.mraid.view.MraidView;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.tapjoy:
//            TapjoyLog, TJWebViewJSInterface, TJAdUnit, TapjoyCache, 
//            TJAdUnitActivity, TJPlacementData, TapjoyConnectCore, TJPlacementManager, 
//            TJVideoListener, TJWebViewJSInterfaceListener, TapjoyUtil

public class TJAdUnitJSBridge
{
    public static interface AdUnitAsyncTaskListner
    {

        public abstract void onComplete(boolean flag);
    }

    final class a extends AsyncTask
    {

        WebView a;
        final TJAdUnitJSBridge b;

        protected final volatile Object doInBackground(Object aobj[])
        {
            return (Boolean[])aobj;
        }

        protected final void onPostExecute(Object obj)
        {
            obj = (Boolean[])obj;
            boolean flag = obj[0].booleanValue();
            boolean flag1 = obj[1].booleanValue();
            if (TJAdUnitJSBridge.d(b) instanceof Activity)
            {
                ((Activity)TJAdUnitJSBridge.d(b)).runOnUiThread(new Runnable(this, flag, flag1) {

                    final boolean a;
                    final boolean b;
                    final a c;

                    public final void run()
                    {
                        if (!a) goto _L2; else goto _L1
_L1:
                        c.a.setVisibility(0);
                        if (!b) goto _L4; else goto _L3
_L3:
                        if (c.a.getParent() instanceof RelativeLayout)
                        {
                            ((RelativeLayout)c.a.getParent()).getBackground().setAlpha(0);
                            ((RelativeLayout)c.a.getParent()).setBackgroundColor(0);
                        }
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            c.a.setLayerType(1, null);
                        }
_L6:
                        return;
_L4:
                        if (c.a.getParent() instanceof RelativeLayout)
                        {
                            ((RelativeLayout)c.a.getParent()).getBackground().setAlpha(255);
                            ((RelativeLayout)c.a.getParent()).setBackgroundColor(-1);
                        }
                        if (android.os.Build.VERSION.SDK_INT >= 11)
                        {
                            c.a.setLayerType(0, null);
                            return;
                        }
                        continue; /* Loop/switch isn't completed */
_L2:
                        c.a.setVisibility(4);
                        if (c.a.getParent() instanceof RelativeLayout)
                        {
                            ((RelativeLayout)c.a.getParent()).getBackground().setAlpha(0);
                            ((RelativeLayout)c.a.getParent()).setBackgroundColor(0);
                            return;
                        }
                        if (true) goto _L6; else goto _L5
_L5:
                    }

            
            {
                c = a1;
                a = flag;
                b = flag1;
                super();
            }
                });
                return;
            } else
            {
                TapjoyLog.e("TJAdUnitJSBridge", "Unable to present offerwall. No Activity context provided.");
                return;
            }
        }

        public a(WebView webview)
        {
            b = TJAdUnitJSBridge.this;
            super();
            a = webview;
        }
    }


    private TJWebViewJSInterface a;
    public boolean allowRedirect;
    private TJAdUnitJSBridge b;
    private Context c;
    public boolean closeRequested;
    public boolean customClose;
    private TJAdUnit d;
    public boolean didLaunchOtherActivity;
    private WebView e;
    private ProgressDialog f;
    private LocationManager g;
    private LocationListener h;
    private View i;
    private boolean j;
    public String otherActivityCallbackID;

    public TJAdUnitJSBridge(Context context, WebView webview)
    {
        i = null;
        didLaunchOtherActivity = false;
        allowRedirect = true;
        otherActivityCallbackID = null;
        customClose = false;
        closeRequested = false;
        TapjoyLog.i("TJAdUnitJSBridge", "creating AdUnit/JS Bridge");
        c = context;
        e = webview;
        b = this;
        if (e == null)
        {
            TapjoyLog.e("TJAdUnitJSBridge", "Error: webView is NULL");
            return;
        } else
        {
            a = new TJWebViewJSInterface(e, new TJWebViewJSInterfaceListener() {

                final TJAdUnitJSBridge a;

                public final void onDispatchMethod(String s, JSONObject jsonobject)
                {
                    Object obj;
                    if (!TJAdUnitJSBridge.a(a))
                    {
                        break MISSING_BLOCK_LABEL_67;
                    }
                    try
                    {
                        obj = jsonobject.getString("callbackId");
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        obj = null;
                    }
                    jsonobject = jsonobject.getJSONObject("data");
                    com/tapjoy/TJAdUnitJSBridge.getMethod(s, new Class[] {
                        org/json/JSONObject, java/lang/String
                    }).invoke(TJAdUnitJSBridge.b(a), new Object[] {
                        jsonobject, obj
                    });
                    return;
                    s;
                    s.printStackTrace();
                    a.invokeJSCallback(((String) (obj)), new Object[] {
                        Boolean.FALSE
                    });
                    return;
                }

            
            {
                a = TJAdUnitJSBridge.this;
                super();
            }
            });
            e.addJavascriptInterface(a, "AndroidJavascriptInterface");
            j = true;
            return;
        }
    }

    public TJAdUnitJSBridge(Context context, TJAdUnit tjadunit)
    {
        this(context, ((WebView) (tjadunit.getWebView())));
        d = tjadunit;
    }

    static View a(TJAdUnitJSBridge tjadunitjsbridge, View view)
    {
        tjadunitjsbridge.i = view;
        return view;
    }

    private File a(String s)
    {
        String s1 = s.substring(s.lastIndexOf('.'));
        java.io.FileOutputStream fileoutputstream;
        byte abyte0[];
        s = (new URL(s)).openStream();
        fileoutputstream = c.openFileOutput((new StringBuilder("share_temp")).append(s1).toString(), 1);
        abyte0 = new byte[4096];
_L3:
        int k = s.read(abyte0, 0, abyte0.length);
        if (k < 0) goto _L2; else goto _L1
_L1:
        fileoutputstream.write(abyte0, 0, k);
          goto _L3
        s;
        s.printStackTrace();
_L5:
        return new File(c.getFilesDir(), (new StringBuilder("share_temp")).append(s1).toString());
_L2:
        try
        {
            fileoutputstream.close();
            s.close();
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        if (true) goto _L5; else goto _L4
_L4:
    }

    static boolean a(TJAdUnitJSBridge tjadunitjsbridge)
    {
        return tjadunitjsbridge.j;
    }

    static TJAdUnitJSBridge b(TJAdUnitJSBridge tjadunitjsbridge)
    {
        return tjadunitjsbridge.b;
    }

    static View c(TJAdUnitJSBridge tjadunitjsbridge)
    {
        return tjadunitjsbridge.i;
    }

    static Context d(TJAdUnitJSBridge tjadunitjsbridge)
    {
        return tjadunitjsbridge.c;
    }

    static WebView e(TJAdUnitJSBridge tjadunitjsbridge)
    {
        return tjadunitjsbridge.e;
    }

    static LocationManager f(TJAdUnitJSBridge tjadunitjsbridge)
    {
        return tjadunitjsbridge.g;
    }

    static LocationListener g(TJAdUnitJSBridge tjadunitjsbridge)
    {
        return tjadunitjsbridge.h;
    }

    public void alert(JSONObject jsonobject, String s)
    {
        Object obj1;
        TapjoyLog.i("TJAdUnitJSBridge", (new StringBuilder("alert_method: ")).append(jsonobject).toString());
        obj1 = "";
        Object obj = jsonobject.getString("title");
        obj1 = obj;
        String s1 = jsonobject.getString("message");
        obj1 = s1;
        jsonobject = jsonobject.getJSONArray("buttons");
_L2:
        obj = (new android.app.AlertDialog.Builder(c)).setTitle(((CharSequence) (obj))).setMessage(((CharSequence) (obj1))).create();
        if (jsonobject == null || jsonobject.length() == 0)
        {
            invokeJSCallback(s, new Object[] {
                Boolean.FALSE
            });
            return;
        }
        break; /* Loop/switch isn't completed */
        jsonobject;
        String s2 = "";
        obj = obj1;
        obj1 = s2;
_L8:
        invokeJSCallback(s, new Object[] {
            Boolean.FALSE
        });
        jsonobject.printStackTrace();
        jsonobject = null;
        if (true) goto _L2; else goto _L1
_L1:
        int k;
        obj1 = new ArrayList();
        k = 0;
_L6:
        if (k >= jsonobject.length())
        {
            break MISSING_BLOCK_LABEL_261;
        }
        k;
        JVM INSTR tableswitch 0 1: default 188
    //                   0 237
    //                   1 244;
           goto _L3 _L4 _L5
_L3:
        byte byte0 = -1;
_L7:
        try
        {
            ((ArrayList) (obj1)).add(jsonobject.getString(k));
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        ((AlertDialog) (obj)).setButton(byte0, (CharSequence)((ArrayList) (obj1)).get(k), new android.content.DialogInterface.OnClickListener(s) {

            final String a;
            final TJAdUnitJSBridge b;

            public final void onClick(DialogInterface dialoginterface, int l)
            {
                int i1;
                boolean flag;
                flag = false;
                i1 = ((flag) ? 1 : 0);
                l;
                JVM INSTR tableswitch -3 -1: default 32
            //                           -3 58
            //                           -2 35
            //                           -1 63;
                   goto _L1 _L2 _L3 _L4
_L4:
                break MISSING_BLOCK_LABEL_63;
_L3:
                break; /* Loop/switch isn't completed */
_L1:
                i1 = ((flag) ? 1 : 0);
_L5:
                try
                {
                    b.invokeJSCallback(a, new Object[] {
                        Integer.valueOf(i1)
                    });
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (DialogInterface dialoginterface)
                {
                    dialoginterface.printStackTrace();
                }
                break MISSING_BLOCK_LABEL_73;
_L2:
                i1 = 1;
                  goto _L5
                i1 = 2;
                  goto _L5
            }

            
            {
                b = TJAdUnitJSBridge.this;
                a = s;
                super();
            }
        });
        k++;
        if (true) goto _L6; else goto _L4
_L4:
        byte0 = -2;
          goto _L7
_L5:
        byte0 = -3;
          goto _L7
        ((AlertDialog) (obj)).setCancelable(false);
        ((AlertDialog) (obj)).setCanceledOnTouchOutside(false);
        ((AlertDialog) (obj)).show();
        return;
        jsonobject;
          goto _L8
    }

    public void cacheAsset(JSONObject jsonobject, String s)
    {
        Long long1;
        String s1 = "";
        long1 = Long.valueOf(0L);
        String s2;
        String s3;
        long l;
        try
        {
            s3 = jsonobject.getString("url");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            TapjoyLog.w("TJAdUnitJSBridge", "Unable to cache video. Invalid parameters.");
            invokeJSCallback(s, new Object[] {
                Boolean.FALSE
            });
            return;
        }
        s2 = jsonobject.getString("offerId");
        s1 = s2;
_L4:
        l = jsonobject.getLong("timeToLive");
        jsonobject = Long.valueOf(l);
_L2:
        if (TapjoyCache.getInstance() != null)
        {
            invokeJSCallback(s, new Object[] {
                TapjoyCache.getInstance().cacheAssetFromURL(s3, s1, jsonobject.longValue())
            });
            return;
        } else
        {
            invokeJSCallback(s, new Object[] {
                Boolean.FALSE
            });
            return;
        }
        jsonobject;
        jsonobject = long1;
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void cachePathForURL(JSONObject jsonobject, String s)
    {
        try
        {
            jsonobject = jsonobject.getString("url");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            invokeJSCallback(s, new Object[] {
                ""
            });
            return;
        }
        if (TapjoyCache.getInstance() != null)
        {
            invokeJSCallback(s, new Object[] {
                TapjoyCache.getInstance().getPathOfCachedURL(jsonobject)
            });
            return;
        } else
        {
            invokeJSCallback(s, new Object[] {
                ""
            });
            return;
        }
    }

    public void checkAppInstalled(JSONObject jsonobject, String s)
    {
label0:
        {
            Object obj = "";
            try
            {
                jsonobject = jsonobject.getString("bundle");
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                jsonobject.printStackTrace();
                jsonobject = ((JSONObject) (obj));
            }
            if (jsonobject == null || jsonobject.length() <= 0)
            {
                break label0;
            }
            obj = c.getPackageManager().getInstalledApplications(0).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break label0;
                }
            } while (!((ApplicationInfo)((Iterator) (obj)).next()).packageName.equals(jsonobject));
            invokeJSCallback(s, new Object[] {
                Boolean.TRUE
            });
            return;
        }
        invokeJSCallback(s, new Object[] {
            Boolean.FALSE
        });
    }

    public void clearCache(JSONObject jsonobject, String s)
    {
        if (TapjoyCache.getInstance() != null)
        {
            TapjoyCache.getInstance().clearTapjoyCache();
            invokeJSCallback(s, new Object[] {
                Boolean.TRUE
            });
            return;
        } else
        {
            invokeJSCallback(s, new Object[] {
                Boolean.FALSE
            });
            return;
        }
    }

    public void clearVideo(JSONObject jsonobject, String s)
    {
        if (d != null)
        {
            d.clearVideo(new AdUnitAsyncTaskListner(s) {

                final String a;
                final TJAdUnitJSBridge b;

                public final void onComplete(boolean flag)
                {
                    b.invokeJSCallback(a, new Object[] {
                        Boolean.valueOf(flag)
                    });
                }

            
            {
                b = TJAdUnitJSBridge.this;
                a = s;
                super();
            }
            });
        }
    }

    public void closeRequested()
    {
        closeRequested = true;
        invokeJSAdunitMethod("closeRequested", new Object[0]);
    }

    public void contentReady(JSONObject jsonobject, String s)
    {
        if (d != null)
        {
            d.fireContentReady();
            invokeJSCallback(s, new Object[] {
                Boolean.valueOf(true)
            });
            return;
        } else
        {
            invokeJSCallback(s, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        }
    }

    public void destroy()
    {
        if (h != null && g != null)
        {
            g.removeUpdates(h);
            g = null;
            h = null;
        }
    }

    public void disable()
    {
        j = false;
    }

    public void dismiss(JSONObject jsonobject, String s)
    {
        if (c instanceof TJAdUnitActivity)
        {
            invokeJSCallback(s, new Object[] {
                Boolean.valueOf(true)
            });
            ((Activity)c).finish();
            return;
        } else
        {
            invokeJSCallback(s, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        }
    }

    public void display()
    {
        invokeJSAdunitMethod("display", new Object[0]);
    }

    public void displayRichMedia(JSONObject jsonobject, String s)
    {
        Object obj;
        boolean flag;
        try
        {
            flag = jsonobject.getBoolean("inline");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            flag = false;
        }
        try
        {
            obj = jsonobject.getString("html");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((Exception) (obj)).printStackTrace();
            obj = null;
        }
        if (obj == null)
        {
            invokeJSCallback(s, new Object[] {
                Boolean.FALSE
            });
            return;
        }
        if (flag)
        {
            ((Activity)c).runOnUiThread(new Runnable(jsonobject) {

                final JSONObject a;
                final TJAdUnitJSBridge b;

                public final void run()
                {
                    String s1;
                    MraidView mraidview;
                    int k;
                    try
                    {
                        s1 = a.getString("html");
                    }
                    catch (Exception exception)
                    {
                        exception.printStackTrace();
                        exception = null;
                    }
                    if (TJAdUnitJSBridge.c(b) != null && TJAdUnitJSBridge.c(b).getParent() != null)
                    {
                        ((ViewGroup)TJAdUnitJSBridge.c(b).getParent()).removeView(TJAdUnitJSBridge.c(b));
                    }
                    mraidview = new MraidView(TJAdUnitJSBridge.d(b));
                    TJAdUnitJSBridge.e(b).getSettings().setJavaScriptEnabled(true);
                    mraidview.setPlacementType(com.tapjoy.mraid.view.MraidView.PLACEMENT_TYPE.INLINE);
                    mraidview.setLayoutParams(new android.view.ViewGroup.LayoutParams(640, 100));
                    mraidview.setInitialScale(100);
                    mraidview.setBackgroundColor(0);
                    mraidview.loadDataWithBaseURL(null, s1, "text/html", "utf-8", null);
                    k = ((WindowManager)((Activity)TJAdUnitJSBridge.d(b)).getSystemService("window")).getDefaultDisplay().getWidth();
                    TJAdUnitJSBridge.a(b, TapjoyUtil.scaleDisplayAd(mraidview, k));
                    ((Activity)TJAdUnitJSBridge.d(b)).addContentView(TJAdUnitJSBridge.c(b), new android.view.ViewGroup.LayoutParams(k, (int)(100D * ((double)k / 640D))));
                }

            
            {
                b = TJAdUnitJSBridge.this;
                a = jsonobject;
                super();
            }
            });
            return;
        } else
        {
            jsonobject = new TJPlacementData(TapjoyConnectCore.getHostURL(), ((String) (obj)));
            jsonobject.setViewType(2);
            s = new Intent(c, com/tapjoy/TJAdUnitActivity);
            s.putExtra("placement_data", jsonobject);
            s.setFlags(0x10000000);
            ((Activity)c).startActivity(s);
            return;
        }
    }

    public void displayStoreURL(JSONObject jsonobject, String s)
    {
        displayURL(jsonobject, s);
    }

    public void displayURL(JSONObject jsonobject, String s)
    {
        try
        {
            jsonobject = jsonobject.getString("url");
            didLaunchOtherActivity = true;
            otherActivityCallbackID = s;
            jsonobject = new Intent("android.intent.action.VIEW", Uri.parse(jsonobject));
            ((Activity)c).startActivity(jsonobject);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            invokeJSCallback(s, new Object[] {
                Boolean.TRUE
            });
        }
        jsonobject.printStackTrace();
    }

    public void displayVideo(JSONObject jsonobject, String s)
    {
        jsonobject = jsonobject.getString("url");
        if (jsonobject.length() > 0 && jsonobject != "")
        {
            try
            {
                d.loadVideoUrl(jsonobject, new AdUnitAsyncTaskListner(s) {

                    final String a;
                    final TJAdUnitJSBridge b;

                    public final void onComplete(boolean flag)
                    {
                        b.invokeJSCallback(a, new Object[] {
                            Boolean.valueOf(flag)
                        });
                    }

            
            {
                b = TJAdUnitJSBridge.this;
                a = s;
                super();
            }
                });
                return;
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                invokeJSCallback(s, new Object[] {
                    Boolean.FALSE
                });
            }
            break MISSING_BLOCK_LABEL_71;
        }
        invokeJSCallback(s, new Object[] {
            Boolean.FALSE
        });
        return;
        jsonobject.printStackTrace();
        return;
    }

    public void flushMessageQueue()
    {
        a.flushMessageQueue();
    }

    public void getCachedAssets(JSONObject jsonobject, String s)
    {
        if (TapjoyCache.getInstance() != null)
        {
            invokeJSCallback(s, new Object[] {
                TapjoyCache.getInstance().cachedAssetsToJSON()
            });
            return;
        } else
        {
            invokeJSCallback(s, new Object[] {
                ""
            });
            return;
        }
    }

    public void getInstalledAppData(JSONObject jsonobject, String s)
    {
        JSONArray jsonarray;
        Object obj;
        jsonobject = c.getPackageManager();
        obj = jsonobject.getInstalledApplications(0);
        jsonarray = new JSONArray();
        obj = ((List) (obj)).iterator();
_L2:
        HashMap hashmap;
        String s1;
        if (!((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_210;
        }
        ApplicationInfo applicationinfo = (ApplicationInfo)((Iterator) (obj)).next();
        if ((applicationinfo.flags & 1) == 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        hashmap = new HashMap();
        s1 = applicationinfo.packageName;
        hashmap.put("packageName", s1);
        hashmap.put("targetSdk", Integer.valueOf(applicationinfo.targetSdkVersion));
        PackageInfo packageinfo = jsonobject.getPackageInfo(s1, 4096);
        hashmap.put("installTime", new Date(packageinfo.firstInstallTime));
        hashmap.put("updateTime", new Date(packageinfo.lastUpdateTime));
        hashmap.put("versionName", packageinfo.versionName);
        hashmap.put("versionCode", Integer.valueOf(packageinfo.versionCode));
        jsonarray.put(new JSONObject(hashmap));
        continue; /* Loop/switch isn't completed */
        invokeJSCallback(s, new Object[] {
            jsonarray
        });
        return;
        Exception exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void getLocation(JSONObject jsonobject, String s)
    {
        float f1 = 100F;
        float f2 = Float.valueOf(jsonobject.getString("gpsAccuracy")).floatValue();
        f1 = f2;
_L8:
        boolean flag;
        try
        {
            flag = Boolean.valueOf(jsonobject.getString("enabled")).booleanValue();
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject.printStackTrace();
            flag = false;
        }
        g = (LocationManager)c.getSystemService("location");
        jsonobject = new Criteria();
        jsonobject = g.getBestProvider(jsonobject, false);
        if (h == null)
        {
            h = new LocationListener() {

                final TJAdUnitJSBridge a;

                public final void onLocationChanged(Location location)
                {
                    if (TJAdUnitJSBridge.d(a) == null || TJAdUnitJSBridge.e(a) == null)
                    {
                        if (TJAdUnitJSBridge.f(a) != null && TJAdUnitJSBridge.g(a) != null)
                        {
                            TapjoyLog.i("TJAdUnitJSBridge", "stopping updates");
                            TJAdUnitJSBridge.f(a).removeUpdates(TJAdUnitJSBridge.g(a));
                        }
                    } else
                    if (location != null)
                    {
                        HashMap hashmap = new HashMap();
                        hashmap.put("lat", Double.valueOf(location.getLatitude()));
                        hashmap.put("long", Double.valueOf(location.getLongitude()));
                        hashmap.put("altitude", Double.valueOf(location.getAltitude()));
                        hashmap.put("timestamp", Long.valueOf(location.getTime()));
                        hashmap.put("speed", Float.valueOf(location.getSpeed()));
                        hashmap.put("course", Float.valueOf(location.getBearing()));
                        a.invokeJSAdunitMethod("locationUpdated", hashmap);
                        return;
                    }
                }

                public final void onProviderDisabled(String s1)
                {
                }

                public final void onProviderEnabled(String s1)
                {
                }

                public final void onStatusChanged(String s1, int k, Bundle bundle)
                {
                }

            
            {
                a = TJAdUnitJSBridge.this;
                super();
            }
            };
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        if (jsonobject == null) goto _L4; else goto _L3
_L3:
        g.requestLocationUpdates(jsonobject, 0L, f1, h);
_L6:
        invokeJSCallback(s, new Object[] {
            Boolean.TRUE
        });
        return;
_L4:
        invokeJSCallback(s, new Object[] {
            Boolean.FALSE
        });
        return;
_L2:
        if (g != null && h != null)
        {
            g.removeUpdates(h);
        }
        if (true) goto _L6; else goto _L5
_L5:
        Exception exception;
        exception;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public void invokeJSAdunitMethod(String s, Map map)
    {
        a.callback(map, s, null);
    }

    public transient void invokeJSAdunitMethod(String s, Object aobj[])
    {
        aobj = new ArrayList(Arrays.asList(aobj));
        a.callback(((ArrayList) (aobj)), s, null);
    }

    public void invokeJSCallback(String s, Map map)
    {
        a.callback(map, "", s);
    }

    public transient void invokeJSCallback(String s, Object aobj[])
    {
        if (cw.c(s))
        {
            TapjoyLog.i("TJAdUnitJSBridge", "No callbackID provided");
            return;
        } else
        {
            aobj = new ArrayList(Arrays.asList(aobj));
            a.callback(((ArrayList) (aobj)), "", s);
            return;
        }
    }

    public void log(JSONObject jsonobject, String s)
    {
        try
        {
            TapjoyLog.i("TJAdUnitJSBridge", jsonobject.getString("message"));
            invokeJSCallback(s, new Object[] {
                Boolean.TRUE
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            invokeJSCallback(s, new Object[] {
                Boolean.FALSE
            });
        }
        jsonobject.printStackTrace();
    }

    public void nativeEval(JSONObject jsonobject, String s)
    {
        ((Activity)c).runOnUiThread(new Runnable(jsonobject, s) {

            final JSONObject a;
            final String b;
            final TJAdUnitJSBridge c;

            public final void run()
            {
                if (android.os.Build.VERSION.SDK_INT < 19)
                {
                    break MISSING_BLOCK_LABEL_50;
                }
                TJAdUnitJSBridge.e(c).evaluateJavascript(a.getString("command"), null);
_L1:
                c.invokeJSCallback(b, new Object[] {
                    Boolean.TRUE
                });
                return;
                try
                {
                    TJAdUnitJSBridge.e(c).loadUrl((new StringBuilder("javascript:")).append(a.getString("command")).toString());
                }
                catch (Exception exception)
                {
                    c.invokeJSCallback(b, new Object[] {
                        Boolean.FALSE
                    });
                    return;
                }
                  goto _L1
            }

            
            {
                c = TJAdUnitJSBridge.this;
                a = jsonobject;
                b = s;
                super();
            }
        });
    }

    public void onVideoCompletion()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("videoEventName", "videoComplete");
        invokeJSAdunitMethod("videoEvent", hashmap);
    }

    public void onVideoError(String s)
    {
        s = new HashMap();
        s.put("videoEventName", "videoError");
        invokeJSAdunitMethod("videoEvent", s);
    }

    public void onVideoInfo(String s)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("videoEventName", "videoInfo");
        hashmap.put("info", s);
        invokeJSAdunitMethod("videoEvent", hashmap);
    }

    public void onVideoPaused(int k)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("videoEventName", "videoPause");
        hashmap.put("currentTime", Integer.valueOf(k));
        invokeJSAdunitMethod("videoEvent", hashmap);
    }

    public void onVideoProgress(int k)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("videoEventName", "videoProgress");
        hashmap.put("currentTime", Integer.valueOf(k));
        invokeJSAdunitMethod("videoEvent", hashmap);
    }

    public void onVideoReady(int k, int l, int i1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("videoEventName", "videoReady");
        hashmap.put("videoDuration", Integer.valueOf(k));
        hashmap.put("videoWidth", Integer.valueOf(l));
        hashmap.put("videoHeight", Integer.valueOf(i1));
        invokeJSAdunitMethod("videoEvent", hashmap);
    }

    public void onVideoStarted(int k)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("videoEventName", "videoStart");
        hashmap.put("currentTime", Integer.valueOf(k));
        invokeJSAdunitMethod("videoEvent", hashmap);
    }

    public void openApp(JSONObject jsonobject, String s)
    {
        try
        {
            jsonobject = jsonobject.getString("bundle");
            jsonobject = c.getPackageManager().getLaunchIntentForPackage(jsonobject);
            c.startActivity(jsonobject);
            invokeJSCallback(s, new Object[] {
                Boolean.TRUE
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            invokeJSCallback(s, new Object[] {
                Boolean.FALSE
            });
        }
        jsonobject.printStackTrace();
    }

    public void pauseVideo(JSONObject jsonobject, String s)
    {
        if (d != null)
        {
            invokeJSCallback(s, new Object[] {
                Boolean.valueOf(d.pauseVideo())
            });
        }
    }

    public void playVideo(JSONObject jsonobject, String s)
    {
        if (d != null)
        {
            invokeJSCallback(s, new Object[] {
                Boolean.valueOf(d.playVideo())
            });
        }
    }

    public void present(JSONObject jsonobject, String s)
    {
        Boolean boolean1;
        Boolean boolean3;
        boolean1 = Boolean.valueOf(false);
        boolean3 = Boolean.valueOf(jsonobject.getString("visible"));
        Boolean boolean2 = Boolean.valueOf(jsonobject.getString("transparent"));
        boolean1 = boolean2;
_L2:
        try
        {
            customClose = Boolean.valueOf(jsonobject.getString("customClose")).booleanValue();
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject) { }
        try
        {
            (new a(e)).execute(new Boolean[] {
                boolean3, boolean1
            });
            invokeJSCallback(s, new Object[] {
                Boolean.TRUE
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            invokeJSCallback(s, new Object[] {
                Boolean.FALSE
            });
        }
        jsonobject.printStackTrace();
        return;
        Exception exception;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void removeAssetFromCache(JSONObject jsonobject, String s)
    {
        try
        {
            jsonobject = jsonobject.getString("url");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            TapjoyLog.w("TJAdUnitJSBridge", "Unable to cache video. Invalid parameters.");
            invokeJSCallback(s, new Object[] {
                Boolean.FALSE
            });
            return;
        }
        if (TapjoyCache.getInstance() != null)
        {
            invokeJSCallback(s, new Object[] {
                Boolean.valueOf(TapjoyCache.getInstance().removeAssetFromCache(jsonobject))
            });
            return;
        } else
        {
            invokeJSCallback(s, new Object[] {
                Boolean.FALSE
            });
            return;
        }
    }

    public void setAllowRedirect(JSONObject jsonobject, String s)
    {
        boolean flag;
        try
        {
            flag = jsonobject.getBoolean("enabled");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            flag = true;
        }
        allowRedirect = flag;
        invokeJSCallback(s, new Object[] {
            Boolean.TRUE
        });
    }

    public void setBackgroundColor(JSONObject jsonobject, String s)
    {
        try
        {
            jsonobject = jsonobject.getString("backgroundColor");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            TapjoyLog.w("TJAdUnitJSBridge", "Unable to set background color. Invalid parameters.");
            invokeJSCallback(s, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        }
        if (d != null)
        {
            d.setBackgroundColor(jsonobject, new AdUnitAsyncTaskListner(s) {

                final String a;
                final TJAdUnitJSBridge b;

                public final void onComplete(boolean flag)
                {
                    b.invokeJSCallback(a, new Object[] {
                        Boolean.valueOf(flag)
                    });
                }

            
            {
                b = TJAdUnitJSBridge.this;
                a = s;
                super();
            }
            });
            return;
        } else
        {
            invokeJSCallback(s, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        }
    }

    public void setBackgroundWebViewContent(JSONObject jsonobject, String s)
    {
        TapjoyLog.i("TJAdUnitJSBridge", "setBackgroundWebViewContent");
        try
        {
            jsonobject = jsonobject.getString("backgroundContent");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            TapjoyLog.w("TJAdUnitJSBridge", "Unable to set background content. Invalid parameters.");
            invokeJSCallback(s, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        }
        if (d != null)
        {
            d.setBackgroundContent(jsonobject, new AdUnitAsyncTaskListner(s) {

                final String a;
                final TJAdUnitJSBridge b;

                public final void onComplete(boolean flag)
                {
                    b.invokeJSCallback(a, new Object[] {
                        Boolean.valueOf(flag)
                    });
                }

            
            {
                b = TJAdUnitJSBridge.this;
                a = s;
                super();
            }
            });
            return;
        } else
        {
            invokeJSCallback(s, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        }
    }

    public void setCloseButtonVisible(JSONObject jsonobject, String s)
    {
        if (!(c instanceof TJAdUnitActivity))
        {
            TapjoyLog.i("TJAdUnitJSBridge", "Not a TJAdUnitActivity");
            invokeJSCallback(s, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        }
        try
        {
            boolean flag = jsonobject.getBoolean("visible");
            ((Activity)c).runOnUiThread(new Runnable(flag) {

                final boolean a;
                final TJAdUnitJSBridge b;

                public final void run()
                {
                    ((TJAdUnitActivity)TJAdUnitJSBridge.d(b)).setCloseButtonVisibility(a);
                }

            
            {
                b = TJAdUnitJSBridge.this;
                a = flag;
                super();
            }
            });
            invokeJSCallback(s, new Object[] {
                Boolean.valueOf(true)
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            invokeJSCallback(s, new Object[] {
                Boolean.valueOf(false)
            });
        }
        jsonobject.printStackTrace();
    }

    public void setContext(Context context)
    {
        c = context;
    }

    public void setEventPreloadLimit(JSONObject jsonobject, String s)
    {
        if (TapjoyCache.getInstance() != null)
        {
            int k;
            try
            {
                k = jsonobject.getInt("eventPreloadLimit");
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                TapjoyLog.w("TJAdUnitJSBridge", "Unable to set Tapjoy cache's event preload limit. Invalid parameters.");
                invokeJSCallback(s, new Object[] {
                    Boolean.FALSE
                });
                return;
            }
            TJPlacementManager.setCachedPlacementLimit(k);
            invokeJSCallback(s, new Object[] {
                Boolean.TRUE
            });
            return;
        } else
        {
            invokeJSCallback(s, new Object[] {
                Boolean.FALSE
            });
            return;
        }
    }

    public void setOrientation(JSONObject jsonobject, String s)
    {
        if (d == null)
        {
            TapjoyLog.i("TJAdUnitJSBridge", "No ad unit provided");
            invokeJSCallback(s, new Object[] {
                Boolean.valueOf(false)
            });
            return;
        }
        jsonobject = jsonobject.getString("orientation");
        if (!jsonobject.equals("landscape") && !jsonobject.equals("landscapeLeft")) goto _L2; else goto _L1
_L4:
        byte byte0;
        try
        {
            d.setOrientation(byte0);
            invokeJSCallback(s, new Object[] {
                Boolean.valueOf(true)
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            invokeJSCallback(s, new Object[] {
                Boolean.valueOf(false)
            });
        }
        return;
_L2:
        boolean flag = jsonobject.equals("landscapeRight");
        if (flag)
        {
            byte0 = 8;
        } else
        {
            byte0 = 1;
        }
        continue; /* Loop/switch isn't completed */
_L1:
        byte0 = 0;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setPrerenderLimit(JSONObject jsonobject, String s)
    {
        int k;
        try
        {
            k = jsonobject.getInt("prerenderLimit");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            TapjoyLog.w("TJAdUnitJSBridge", "Unable to set Tapjoy placement pre-render limit. Invalid parameters.");
            invokeJSCallback(s, new Object[] {
                Boolean.FALSE
            });
            return;
        }
        TJPlacementManager.setPreRenderedPlacementLimit(k);
        invokeJSCallback(s, new Object[] {
            Boolean.TRUE
        });
    }

    public void setSpinnerVisible(JSONObject jsonobject, String s)
    {
        String s1;
        String s2;
        s1 = "Loading...";
        boolean flag;
        try
        {
            flag = jsonobject.getBoolean("visible");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            invokeJSCallback(s, new Object[] {
                Boolean.FALSE
            });
            jsonobject.printStackTrace();
            return;
        }
        s2 = jsonobject.getString("title");
        s1 = s2;
        try
        {
            jsonobject = jsonobject.getString("message");
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            jsonobject = "";
            s2 = s1;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        f = ProgressDialog.show(c, s2, jsonobject);
_L4:
        invokeJSCallback(s, new Object[] {
            Boolean.TRUE
        });
        return;
_L2:
        if (f != null)
        {
            f.dismiss();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void share(JSONObject jsonobject, String s)
    {
        String s2 = null;
        String s3;
        String s4;
        Intent intent;
        s4 = jsonobject.getString("network");
        s3 = jsonobject.getString("message");
        intent = new Intent("android.intent.action.SEND");
        Object obj = jsonobject.getString("imageURL");
_L5:
        jsonobject = jsonobject.getString("linkURL");
_L6:
        String s1;
        s1 = s2;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        File file = a(((String) (obj)));
        s1 = s2;
        if (file == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        s1 = (new StringBuilder("file://")).append(file.getAbsolutePath()).toString();
        s2 = s3;
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        s2 = (new StringBuilder()).append(s3).append("\n").append(jsonobject).toString();
        intent.putExtra("android.intent.extra.TEXT", s2);
        if (!s4.equals("facebook")) goto _L2; else goto _L1
_L1:
        if (obj == null || s1 == null) goto _L4; else goto _L3
_L3:
        intent.setType("image/*");
        intent.putExtra("android.intent.extra.STREAM", Uri.parse(s1));
_L7:
        jsonobject = c.getPackageManager().queryIntentActivities(intent, 0).iterator();
        do
        {
            if (!jsonobject.hasNext())
            {
                break MISSING_BLOCK_LABEL_439;
            }
            obj = (ResolveInfo)jsonobject.next();
        } while (!((ResolveInfo) (obj)).activityInfo.packageName.toLowerCase(Locale.ENGLISH).contains(s4) && !((ResolveInfo) (obj)).activityInfo.name.toLowerCase(Locale.ENGLISH).contains(s4));
        intent.setPackage(((ResolveInfo) (obj)).activityInfo.packageName);
        for (boolean flag = true; !flag; flag = false)
        {
            try
            {
                invokeJSCallback(s, new Object[] {
                    Boolean.FALSE
                });
                return;
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                invokeJSCallback(s, new Object[] {
                    Boolean.FALSE
                });
            }
            jsonobject.printStackTrace();
            return;
        }

        break MISSING_BLOCK_LABEL_408;
        obj;
        TapjoyLog.i("TJAdUnitJSBridge", "no imageURL");
        obj = null;
          goto _L5
        jsonobject;
        TapjoyLog.i("TJAdUnitJSBridge", "no linkURL");
        jsonobject = null;
          goto _L6
_L4:
        intent.setType("text/plain");
          goto _L7
_L2:
        if (!s4.equals("twitter")) goto _L7; else goto _L8
_L8:
        intent.setType("*/*");
        if (obj == null || s1 == null) goto _L7; else goto _L9
_L9:
        intent.putExtra("android.intent.extra.STREAM", Uri.parse(s1));
          goto _L7
        didLaunchOtherActivity = true;
        otherActivityCallbackID = s;
        jsonobject = Intent.createChooser(intent, "Select");
        ((Activity)c).startActivity(jsonobject);
        return;
          goto _L5
    }

    public void shouldClose(JSONObject jsonobject, String s)
    {
        try
        {
            if (Boolean.valueOf(jsonobject.getString("close")).booleanValue() && (c instanceof Activity))
            {
                ((Activity)c).finish();
            }
            invokeJSCallback(s, new Object[] {
                Boolean.TRUE
            });
        }
        // Misplaced declaration of an exception variable
        catch (JSONObject jsonobject)
        {
            invokeJSCallback(s, new Object[] {
                Boolean.FALSE
            });
            ((Activity)c).finish();
            jsonobject.printStackTrace();
        }
        closeRequested = false;
    }

    public void triggerEvent(JSONObject jsonobject, String s)
    {
        if (d != null)
        {
            try
            {
                jsonobject = jsonobject.getString("eventName");
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                TapjoyLog.w("TJAdUnitJSBridge", "Unable to triggerEvent. No event name.");
                return;
            }
            if (jsonobject.equals("start"))
            {
                d.getPublisherVideoListener().onVideoStart();
            } else
            {
                if (jsonobject.equals("complete"))
                {
                    d.getPublisherVideoListener().onVideoComplete();
                    return;
                }
                if (jsonobject.equals("error"))
                {
                    d.getPublisherVideoListener().onVideoError(3);
                    return;
                }
            }
        }
    }
}
