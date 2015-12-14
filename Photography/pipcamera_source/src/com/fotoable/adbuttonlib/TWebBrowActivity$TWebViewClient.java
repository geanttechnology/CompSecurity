// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.pipcamera.activity.ExternReceiverActivity;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.ResourceOnlineLibrary.activity.MainResourceActivity;
import com.wantu.model.res.pip.TDFSceneInfo;
import com.wantu.piprender.ESceneCatalog;
import com.wantu.piprender.ESceneMode;
import es;
import gb;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kf;
import oe;
import of;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import uc;
import yf;

// Referenced classes of package com.fotoable.adbuttonlib:
//            TWebBrowActivity

class isPipLoadTwice extends WebViewClient
{

    boolean isPipLoadTwice;
    final TWebBrowActivity this$0;

    private Map getParamsMap(String s)
    {
        s = s.split("&");
        HashMap hashmap = new HashMap(s.length);
        int j = s.length;
        for (int i = 0; i < j; i++)
        {
            String as[] = s[i].split("=");
            if (as.length > 1)
            {
                hashmap.put(as[0], as[1]);
            }
        }

        return hashmap;
    }

    public String bitmaptoString(Bitmap bitmap)
    {
        StringBuffer stringbuffer = new StringBuffer();
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        try
        {
            bitmap.compress(android.graphics.wClient, 100, bytearrayoutputstream);
            bytearrayoutputstream.flush();
            bytearrayoutputstream.close();
            stringbuffer.append(Base64.encodeToString(bytearrayoutputstream.toByteArray(), 2));
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            bitmap.printStackTrace();
        }
        System.out.println((new StringBuilder()).append("string..").append(stringbuffer.length()).toString());
        return stringbuffer.toString();
    }

    public void callOcFuc(String s, String s1, String s2, String s3, String s4)
    {
        if (s == null || s.length() <= 0)
        {
            return;
        }
        if (s1 == null || s1.length() <= 0) goto _L2; else goto _L1
_L1:
        s = getClass().getDeclaredMethod(s, new Class[] {
            java/lang/String
        });
        if (s2 == null) goto _L4; else goto _L3
_L3:
        if (s2.length() <= 0) goto _L4; else goto _L5
_L5:
        s = ((String) (s.invoke(this, new Object[] {
            s1
        })));
_L6:
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_305;
        }
        if (s instanceof Bitmap)
        {
            s = bitmaptoString((Bitmap)s);
        } else
        if (s instanceof String)
        {
            s = (String)s;
        } else
        if (s instanceof JSONObject)
        {
            s = ((JSONObject)s).toString();
        } else
        {
            if (!(s instanceof Boolean))
            {
                break MISSING_BLOCK_LABEL_305;
            }
            if (((Boolean)s).booleanValue())
            {
                s = "1";
            } else
            {
                s = "0";
            }
        }
_L7:
        if (s3 != null && s3.length() > 0)
        {
            TWebBrowActivity.access$300(TWebBrowActivity.this).loadUrl(String.format("javascript:%s('%s,%s')", new Object[] {
                s2, s, s3
            }));
            return;
        } else
        {
            TWebBrowActivity.access$300(TWebBrowActivity.this).loadUrl(String.format("javascript:%s('%s')", new Object[] {
                s2, s
            }));
            return;
        }
_L4:
        try
        {
            s.invoke(this, new Object[] {
                s1
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        Crashlytics.logException(s);
        return;
_L2:
        s = getClass().getDeclaredMethod(s, new Class[0]);
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_194;
        }
        if (s2.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_194;
        }
        s = ((String) (s.invoke(this, new Object[0])));
          goto _L6
        try
        {
            s.invoke(this, new Object[0]);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        Crashlytics.logException(s);
        return;
        s = "";
          goto _L7
    }

    public void doFotoableShareActionByUrl(String s)
    {
        boolean flag1;
        boolean flag2;
        boolean flag3;
        flag3 = true;
        flag1 = true;
        flag2 = false;
        Object obj;
        obj = Uri.parse(s);
        ((Uri) (obj)).getQueryParameter("type");
        obj = ((Uri) (obj)).getQueryParameter("shareway");
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (((String) (obj)).compareTo("all") != 0) goto _L2; else goto _L3
_L3:
        boolean flag4;
        boolean flag5;
        boolean flag6;
        boolean flag7;
        flag4 = oe.a(TWebBrowActivity.this);
        flag5 = oe.b(TWebBrowActivity.this);
        flag6 = oe.d(TWebBrowActivity.this);
        flag7 = oe.c(TWebBrowActivity.this);
        obj = new of(TWebBrowActivity.this);
        boolean flag;
        if (((of) (obj)).b() && ((of) (obj)).a())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag = flag3;
        if (flag4)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        flag = flag3;
        if (flag5)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        flag = flag3;
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        flag = flag3;
        if (flag6)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        flag = flag3;
        if (flag7)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        Toast.makeText(TWebBrowActivity.this, getString(0x7f060205), 0).show();
        flag = flag2;
_L5:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_420;
        }
        try
        {
            obj = new Intent(TWebBrowActivity.this, com/pipcamera/activity/ExternReceiverActivity);
            ((Intent) (obj)).putExtra("url", s);
            ((Intent) (obj)).putExtra("prefix", "fotoable");
            startActivity(((Intent) (obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
        }
        break MISSING_BLOCK_LABEL_410;
_L2:
        flag = flag1;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_272;
        }
        flag = flag1;
        if (((String) (obj)).compareTo("sina") != 0)
        {
            break MISSING_BLOCK_LABEL_272;
        }
        flag = flag1;
        if (oe.a(TWebBrowActivity.this))
        {
            break MISSING_BLOCK_LABEL_272;
        }
        Toast.makeText(TWebBrowActivity.this, getString(0x7f060205), 0).show();
        flag = false;
        flag1 = flag;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_329;
        }
        flag1 = flag;
        if (((String) (obj)).compareTo("qqWeibo") != 0)
        {
            break MISSING_BLOCK_LABEL_329;
        }
        flag1 = flag;
        if (oe.b(TWebBrowActivity.this))
        {
            break MISSING_BLOCK_LABEL_329;
        }
        Toast.makeText(TWebBrowActivity.this, getString(0x7f060203), 0).show();
        flag1 = false;
        flag = flag1;
        if (obj == null) goto _L5; else goto _L4
_L4:
        flag = flag1;
        if (((String) (obj)).compareTo("moment") != 0) goto _L5; else goto _L6
_L6:
        obj = new of(TWebBrowActivity.this);
        if (!((of) (obj)).b()) goto _L8; else goto _L7
_L7:
        flag = flag1;
        if (((of) (obj)).a()) goto _L5; else goto _L8
_L8:
        Toast.makeText(TWebBrowActivity.this, getString(0x7f060201), 0).show();
        flag = flag2;
          goto _L5
        return;
    }

    public void doLocalActionByUrl(String s)
    {
        int i = s.indexOf('?');
        if (i != -1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s1;
        Object obj;
        obj = getParamsMap(s.substring(i + 1, s.length()));
        s = getParameterByMap(((Map) (obj)), "type");
        s1 = getParameterByMap(((Map) (obj)), "name");
        obj = getParameterByMap(((Map) (obj)), "previewUrl");
        if (!s.equalsIgnoreCase("PIP_SCENE") && !s.equalsIgnoreCase("PIP_SCENE2") || s1 == null || s1.length() <= 0) goto _L1; else goto _L3
_L3:
        int j;
        yf yf1 = new yf();
        TDFSceneInfo tdfsceneinfo = new TDFSceneInfo();
        tdfsceneinfo.setName(s1);
        i = yf1.b(tdfsceneinfo, ESceneCatalog.SCENE_RECTANGLE_SHAPE, ESceneMode.SCENE_MODE1);
        j = yf1.b(tdfsceneinfo, ESceneCatalog.SCENE_RECTANGLE_SHAPE, ESceneMode.SCENE_MODE2);
        if (i == -1 && j == -1) goto _L5; else goto _L4
_L4:
        if (i < 0) goto _L7; else goto _L6
_L6:
        currentMode = ESceneMode.SCENE_MODE1;
        currSelectedInex = i;
_L8:
        s = new Intent();
        s.setType("image/*");
        s.setAction("android.intent.action.GET_CONTENT");
        startActivityForResult(s, 3021);
        return;
_L7:
        if (j >= 0)
        {
            currentMode = ESceneMode.SCENE_MODE2;
            currSelectedInex = j;
        }
        if (true) goto _L8; else goto _L5
_L5:
        Intent intent;
        intent = new Intent(TWebBrowActivity.this, com/wantu/ResourceOnlineLibrary/activity/MainResourceActivity);
        intent.putExtra("name", s1);
        if (!s.equalsIgnoreCase("PIP_SCENE")) goto _L10; else goto _L9
_L9:
        intent.putExtra("scene_mode", MainResourceActivity.a);
_L12:
        intent.putExtra("previewUrl", ((String) (obj)));
        startActivity(intent);
        finish();
        return;
_L10:
        if (s.equalsIgnoreCase("PIP_SCENE2"))
        {
            intent.putExtra("scene_mode", MainResourceActivity.b);
        }
        if (true) goto _L12; else goto _L11
_L11:
    }

    public String getDeviceInfosDictionary()
    {
        return uc.b();
    }

    public String getParameterByMap(Map map, String s)
    {
        map = (String)map.get(s);
        if (map != null && map.length() > 0)
        {
            return map;
        } else
        {
            return null;
        }
    }

    public Bitmap getSavePhoto()
    {
        Object obj = getSharedPreferences("savephotoImageString", 0).getString("imageString", "");
        if (((String) (obj)).compareToIgnoreCase("") == 0)
        {
            return null;
        }
        obj = Uri.parse(((String) (obj)));
        try
        {
            obj = android.provider.p(getContentResolver(), ((Uri) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((FileNotFoundException) (obj)).printStackTrace();
            Crashlytics.logException(((Throwable) (obj)));
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IOException) (obj)).printStackTrace();
            Crashlytics.logException(((Throwable) (obj)));
            return null;
        }
        if (obj == null)
        {
            obj = null;
        }
        return ((Bitmap) (obj));
    }

    public void hideNavBar(String s)
    {
        boolean flag;
        if (s.compareToIgnoreCase("1") == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        TWebBrowActivity.access$700(TWebBrowActivity.this, flag);
    }

    public String isAppExist(String s)
    {
        if (kf.a(getApplicationContext(), s))
        {
            return "1";
        } else
        {
            return "0";
        }
    }

    public String isAppsExist(String s)
    {
        JSONObject jsonobject;
        try
        {
            s = new JSONObject(s);
            jsonobject = new JSONObject();
            String s1;
            for (Iterator iterator = s.keys(); iterator.hasNext(); jsonobject.put(s1, isAppExist(s.getString(s1))))
            {
                s1 = (String)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return "";
        }
        s = jsonobject.toString();
        return s;
    }

    public boolean isGoogleApk()
    {
        return kf.a();
    }

    public String isrespondsToFucForJS(String s)
    {
        if (kf.a(getClass(), s))
        {
            return "1";
        } else
        {
            return "0";
        }
    }

    public String isrespondsToFucsForJS(String s)
    {
        JSONObject jsonobject;
        String s1;
        int i;
        try
        {
            s = (new JSONObject(s)).getJSONArray("fucNames");
            jsonobject = new JSONObject();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return "";
        }
        i = 0;
        if (i >= s.length())
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = (String)s.get(i);
        jsonobject.put(s1, isrespondsToFucForJS(s1));
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_26;
_L1:
        s = jsonobject.toString();
        return s;
    }

    public void onPageFinished(WebView webview, String s)
    {
        super.onPageFinished(webview, s);
        TWebBrowActivity.access$400(TWebBrowActivity.this).setVisibility(8);
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        super.onPageStarted(webview, s, bitmap);
        if (s.startsWith("market://", 0))
        {
            webview.stopLoading();
            try
            {
                es.a(TWebBrowActivity.this, s);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (WebView webview)
            {
                Crashlytics.logException(webview);
            }
            return;
        } else
        {
            super.onPageStarted(webview, s, bitmap);
            return;
        }
    }

    public void onReceivedError(WebView webview, int i, String s, String s1)
    {
        if (s1.startsWith("wantu://", 0))
        {
            TWebBrowActivity.access$300(TWebBrowActivity.this).loadUrl(TWebBrowActivity.access$200(TWebBrowActivity.this));
            return;
        }
        try
        {
            if (s1.startsWith("fotoable://", 0))
            {
                TWebBrowActivity.access$300(TWebBrowActivity.this).loadUrl(TWebBrowActivity.access$200(TWebBrowActivity.this));
                return;
            }
        }
        catch (Exception exception) { }
        super.onReceivedError(webview, i, s, s1);
        return;
    }

    public void openAppPackage(String s)
    {
        if (kf.a(getApplicationContext(), s))
        {
            TWebBrowActivity.access$800(TWebBrowActivity.this, s);
        }
    }

    public void openInSafari(String s)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(s));
        s = Intent.createChooser(intent, null);
        startActivity(s);
    }

    public void openInSafariWidthCloseSelf(String s)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(s));
        s = Intent.createChooser(intent, null);
        startActivity(s);
        finish();
    }

    public void pickPhoto()
    {
        if (!gb.h())
        {
            Toast.makeText(getApplicationContext(), 0x7f0600e5, 0).show();
            return;
        }
        try
        {
            doPickPhotoFromGalleryByRequestCode(3022);
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            return;
        }
    }

    public void saveWebPhoto(final String bitmapString)
    {
        if (bitmapString == null || bitmapString.length() <= 0)
        {
            return;
        } else
        {
            (new Thread(new Runnable() {

                final TWebBrowActivity.TWebViewClient this$1;
                final String val$bitmapString;

                public void run()
                {
                    Log.i("TWebBrowActivity", (new StringBuilder()).append("saveWebPhoto ").append(bitmapString).toString());
                    Bitmap bitmap = stringtoBitmap(bitmapString);
                    saveBitmap(bitmap);
                }

            
            {
                this$1 = TWebBrowActivity.TWebViewClient.this;
                bitmapString = s;
                super();
            }
            })).start();
            return;
        }
    }

    public void setDeviceTest(String s)
    {
        android.content.ewClient ewclient = PIPCameraApplication.a.getSharedPreferences("DeviceTestSharedPreferences", 0).edit();
        if (s.compareToIgnoreCase("1") == 0)
        {
            ewclient.ean("DeviceTestSharedPreferencesTag", true);
        } else
        {
            ewclient.ean("DeviceTestSharedPreferencesTag", false);
        }
        ewclient.ean();
    }

    public void shareActionByUrl(String s)
    {
        boolean flag1;
        boolean flag2;
        boolean flag3;
        flag3 = true;
        flag1 = true;
        flag2 = false;
        Object obj;
        obj = Uri.parse(s);
        ((Uri) (obj)).getQueryParameter("type");
        obj = ((Uri) (obj)).getQueryParameter("shareway");
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (((String) (obj)).compareTo("all") != 0) goto _L2; else goto _L3
_L3:
        boolean flag4;
        boolean flag5;
        boolean flag6;
        boolean flag7;
        flag4 = oe.a(TWebBrowActivity.this);
        flag5 = oe.b(TWebBrowActivity.this);
        flag6 = oe.d(TWebBrowActivity.this);
        flag7 = oe.c(TWebBrowActivity.this);
        obj = new of(TWebBrowActivity.this);
        boolean flag;
        if (((of) (obj)).b() && ((of) (obj)).a())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag = flag3;
        if (flag4)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        flag = flag3;
        if (flag5)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        flag = flag3;
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        flag = flag3;
        if (flag6)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        flag = flag3;
        if (flag7)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        Toast.makeText(TWebBrowActivity.this, getString(0x7f060205), 0).show();
        flag = flag2;
_L5:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_409;
        }
        try
        {
            obj = new Intent(TWebBrowActivity.this, com/pipcamera/activity/ExternReceiverActivity);
            ((Intent) (obj)).putExtra("url", s);
            startActivity(((Intent) (obj)));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
        }
        break MISSING_BLOCK_LABEL_399;
_L2:
        flag = flag1;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_261;
        }
        flag = flag1;
        if (((String) (obj)).compareTo("sina") != 0)
        {
            break MISSING_BLOCK_LABEL_261;
        }
        flag = flag1;
        if (oe.a(TWebBrowActivity.this))
        {
            break MISSING_BLOCK_LABEL_261;
        }
        Toast.makeText(TWebBrowActivity.this, getString(0x7f060205), 0).show();
        flag = false;
        flag1 = flag;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_318;
        }
        flag1 = flag;
        if (((String) (obj)).compareTo("qqWeibo") != 0)
        {
            break MISSING_BLOCK_LABEL_318;
        }
        flag1 = flag;
        if (oe.b(TWebBrowActivity.this))
        {
            break MISSING_BLOCK_LABEL_318;
        }
        Toast.makeText(TWebBrowActivity.this, getString(0x7f060203), 0).show();
        flag1 = false;
        flag = flag1;
        if (obj == null) goto _L5; else goto _L4
_L4:
        flag = flag1;
        if (((String) (obj)).compareTo("moment") != 0) goto _L5; else goto _L6
_L6:
        obj = new of(TWebBrowActivity.this);
        if (!((of) (obj)).b()) goto _L8; else goto _L7
_L7:
        flag = flag1;
        if (((of) (obj)).a()) goto _L5; else goto _L8
_L8:
        Toast.makeText(TWebBrowActivity.this, getString(0x7f060201), 0).show();
        flag = flag2;
          goto _L5
        return;
    }

    public void shareToWeChat(String s)
    {
        shareAllToWeChat(s);
    }

    public boolean shouldOverrideUrlLoading(final WebView funName, final String param)
    {
        boolean flag = false;
        Log.v("TWebBrowActivity", (new StringBuilder()).append("TWebBrowActivity: shouldOverrideUrlLoading : ").append(param).toString());
        if (param.startsWith("fotoable://", 0))
        {
            final String errCallBack = Uri.parse(param);
            if (errCallBack.getQueryParameter("type").compareTo("callOCFuc") == 0)
            {
                Log.i("callocfuc", "\u8C03\u7528\u5BA2\u6237\u7AEF\u65B9\u6CD5");
                funName = errCallBack.getQueryParameter("fucName");
                param = errCallBack.getQueryParameter("params");
                final String callBackFuc = errCallBack.getQueryParameter("callBack");
                final String callParam = errCallBack.getQueryParameter("backParams");
                errCallBack = errCallBack.getQueryParameter("errBack");
                Log.i("callocfuc", funName);
                TWebBrowActivity.access$500(TWebBrowActivity.this);
                (new Handler()).postDelayed(new Runnable() {

                    final TWebBrowActivity.TWebViewClient this$1;
                    final String val$callBackFuc;
                    final String val$callParam;
                    final String val$errCallBack;
                    final String val$funName;
                    final String val$param;

                    public void run()
                    {
                        try
                        {
                            callOcFuc(funName, param, callBackFuc, callParam, errCallBack);
                        }
                        catch (Exception exception)
                        {
                            exception.printStackTrace();
                        }
                        runOnUiThread(new Runnable() {

                            final _cls1 this$2;

                            public void run()
                            {
                                TWebBrowActivity.access$600(this$0);
                            }

            
            {
                this$2 = _cls1.this;
                super();
            }
                        });
                    }

            
            {
                this$1 = TWebBrowActivity.TWebViewClient.this;
                funName = s;
                param = s1;
                callBackFuc = s2;
                callParam = s3;
                errCallBack = s4;
                super();
            }
                }, 150L);
            }
            flag = true;
        }
        return flag;
    }

    public boolean webCanGoBack()
    {
        return TWebBrowActivity.access$300(TWebBrowActivity.this).canGoBack();
    }

    public boolean webCanGoForword()
    {
        return TWebBrowActivity.access$300(TWebBrowActivity.this).canGoForward();
    }

    public boolean webGoBack()
    {
        if (webCanGoBack())
        {
            TWebBrowActivity.access$300(TWebBrowActivity.this).goBack();
            return true;
        } else
        {
            return false;
        }
    }

    public boolean webGoForword()
    {
        if (webCanGoForword())
        {
            TWebBrowActivity.access$300(TWebBrowActivity.this).goForward();
            return true;
        } else
        {
            return false;
        }
    }

    _cls2.val.bitmapString()
    {
        this$0 = TWebBrowActivity.this;
        super();
        isPipLoadTwice = false;
    }
}
