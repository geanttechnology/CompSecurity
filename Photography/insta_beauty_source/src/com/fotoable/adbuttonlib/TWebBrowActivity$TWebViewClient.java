// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;

import aaj;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import apq;
import aty;
import atz;
import bgx;
import com.crashlytics.android.Crashlytics;
import com.fotoable.fotobeauty.ExternReceiverActivity;
import com.instabeauty.application.InstaBeautyApplication;
import com.instamag.activity.library.activity.MainDownloadActivity;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoComposeInfo;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import com.wantu.activity.photoselector.InstaPhotoSelectorActivity;
import com.wantu.activity.photoselector.SinglePhotoSelectorActivity;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
        if (s != null && (s instanceof Bitmap))
        {
            s = bitmaptoString((Bitmap)s);
        } else
        {
            s = "";
        }
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
        return;
_L2:
        s = getClass().getDeclaredMethod(s, new Class[0]);
        if (s2 == null)
        {
            break MISSING_BLOCK_LABEL_190;
        }
        if (s2.length() <= 0)
        {
            break MISSING_BLOCK_LABEL_190;
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
        return;
    }

    public void doFotoableShareActionByUrl(String s)
    {
        boolean flag1;
        boolean flag3 = true;
        flag1 = true;
        boolean flag2 = false;
        Object obj;
        boolean flag;
        boolean flag4;
        boolean flag5;
        boolean flag6;
        boolean flag7;
        try
        {
            obj = Uri.parse(s);
            ((Uri) (obj)).getQueryParameter("type");
            obj = ((Uri) (obj)).getQueryParameter("shareway");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (((String) (obj)).compareTo("all") != 0) goto _L2; else goto _L3
_L3:
        flag4 = aty.a(TWebBrowActivity.this);
        flag5 = aty.b(TWebBrowActivity.this);
        flag6 = aty.d(TWebBrowActivity.this);
        flag7 = aty.c(TWebBrowActivity.this);
        obj = new atz(TWebBrowActivity.this);
        if (((atz) (obj)).b() && ((atz) (obj)).a())
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
        Toast.makeText(TWebBrowActivity.this, getString(0x7f06022b), 0).show();
        flag = flag2;
_L5:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = new Intent(TWebBrowActivity.this, com/fotoable/fotobeauty/ExternReceiverActivity);
        ((Intent) (obj)).putExtra("url", s);
        ((Intent) (obj)).putExtra("prefix", "fotoable");
        startActivity(((Intent) (obj)));
        return;
_L2:
        flag = flag1;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_267;
        }
        flag = flag1;
        if (((String) (obj)).compareTo("sina") != 0)
        {
            break MISSING_BLOCK_LABEL_267;
        }
        flag = flag1;
        if (aty.a(TWebBrowActivity.this))
        {
            break MISSING_BLOCK_LABEL_267;
        }
        Toast.makeText(TWebBrowActivity.this, getString(0x7f06022b), 0).show();
        flag = false;
        flag1 = flag;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_322;
        }
        flag1 = flag;
        if (((String) (obj)).compareTo("qqWeibo") != 0)
        {
            break MISSING_BLOCK_LABEL_322;
        }
        flag1 = flag;
        if (aty.b(TWebBrowActivity.this))
        {
            break MISSING_BLOCK_LABEL_322;
        }
        Toast.makeText(TWebBrowActivity.this, getString(0x7f060229), 0).show();
        flag1 = false;
        flag = flag1;
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (((String) (obj)).compareTo("moment") != 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = new atz(TWebBrowActivity.this);
        if (!((atz) (obj)).b())
        {
            break MISSING_BLOCK_LABEL_371;
        }
        flag = flag1;
        if (((atz) (obj)).a())
        {
            continue; /* Loop/switch isn't completed */
        }
        Toast.makeText(TWebBrowActivity.this, getString(0x7f060227), 0).show();
        flag = flag2;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void doLocalActionByUrl(String s)
    {
        int i = s.indexOf('?');
        if (i != -1)
        {
            s = s.substring(i + 1, s.length());
            Log.v("TWebBrowActivity", (new StringBuilder()).append("TWebBrowActivity paraMetersString: ").append(s.toString()).toString());
            Object obj = getParamsMap(s);
            Log.v("TWebBrowActivity", (new StringBuilder()).append("TWebBrowActivity parametersMap: ").append(obj.toString()).toString());
            s = getParameterByMap(((Map) (obj)), "type");
            String s1 = getParameterByMap(((Map) (obj)), "rid");
            String s4 = getParameterByMap(((Map) (obj)), "imageCount");
            String s2 = getParameterByMap(((Map) (obj)), "name");
            String s3 = getParameterByMap(((Map) (obj)), "previewUrl");
            if (!s.equalsIgnoreCase("PIP_SCENE"))
            {
                if (!s.equalsIgnoreCase("PIP_SCENE2"));
            }
            if (s.equalsIgnoreCase("MAG_MASK_INFO") && s1 != null && s1.length() > 0)
            {
                int j = Integer.valueOf(s1).intValue();
                int k = Integer.valueOf(s4).intValue();
                if (TWebBrowActivity.access$900(TWebBrowActivity.this).isExistedByResId(j))
                {
                    s = new Intent(TWebBrowActivity.this, com/wantu/activity/photoselector/InstaPhotoSelectorActivity);
                    s.putExtra("SelectedComposeInfoResId", j);
                    s.putExtra("SelectedComposeInfoImageCount", k);
                    startActivity(s);
                    finish();
                    return;
                }
                s1 = getParameterByMap(((Map) (obj)), "version");
                s = s1;
                if (s1 != null)
                {
                    s = s1;
                    if (s1.length() > 0)
                    {
                        s = s1;
                        if ((double)Float.valueOf(s1).floatValue() > 3.2999999999999998D)
                        {
                            s = "3.3";
                        }
                    }
                }
                s1 = getParameterByMap(((Map) (obj)), "otherAppStoreId");
                obj = getParameterByMap(((Map) (obj)), "icon");
                InstaBeautyApplication.e.resId = j;
                InstaBeautyApplication.e.version = s;
                InstaBeautyApplication.e.name = s2;
                InstaBeautyApplication.e.icon = ((String) (obj));
                InstaBeautyApplication.e.previewUrl = s3;
                InstaBeautyApplication.e.imageCount = k;
                InstaBeautyApplication.e.otherAppStoreId = s1;
                s = new Intent(TWebBrowActivity.this, com/instamag/activity/library/activity/MainDownloadActivity);
                s.putExtra("SelectedComposeInfoResId", j);
                startActivity(s);
                finish();
                return;
            }
        }
    }

    protected void doPickPhotoFromGalleryByRequestCode(int i)
    {
        try
        {
            Intent intent = getPhotoPickIntent();
            startActivityForResult(intent, i);
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            return;
        }
    }

    public void doShareActionByUrl(String s)
    {
        boolean flag1;
        boolean flag3 = true;
        flag1 = true;
        boolean flag2 = false;
        Object obj;
        boolean flag;
        boolean flag4;
        boolean flag5;
        boolean flag6;
        boolean flag7;
        try
        {
            obj = Uri.parse(s);
            ((Uri) (obj)).getQueryParameter("type");
            obj = ((Uri) (obj)).getQueryParameter("shareway");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return;
        }
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (((String) (obj)).compareTo("all") != 0) goto _L2; else goto _L3
_L3:
        flag4 = aty.a(TWebBrowActivity.this);
        flag5 = aty.b(TWebBrowActivity.this);
        flag6 = aty.d(TWebBrowActivity.this);
        flag7 = aty.c(TWebBrowActivity.this);
        obj = new atz(TWebBrowActivity.this);
        if (((atz) (obj)).b() && ((atz) (obj)).a())
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
        Toast.makeText(TWebBrowActivity.this, getString(0x7f06022b), 0).show();
        flag = flag2;
_L5:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = new Intent(TWebBrowActivity.this, com/fotoable/fotobeauty/ExternReceiverActivity);
        ((Intent) (obj)).putExtra("url", s);
        startActivity(((Intent) (obj)));
        return;
_L2:
        flag = flag1;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_258;
        }
        flag = flag1;
        if (((String) (obj)).compareTo("sina") != 0)
        {
            break MISSING_BLOCK_LABEL_258;
        }
        flag = flag1;
        if (aty.a(TWebBrowActivity.this))
        {
            break MISSING_BLOCK_LABEL_258;
        }
        Toast.makeText(TWebBrowActivity.this, getString(0x7f06022b), 0).show();
        flag = false;
        flag1 = flag;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_313;
        }
        flag1 = flag;
        if (((String) (obj)).compareTo("qqWeibo") != 0)
        {
            break MISSING_BLOCK_LABEL_313;
        }
        flag1 = flag;
        if (aty.b(TWebBrowActivity.this))
        {
            break MISSING_BLOCK_LABEL_313;
        }
        Toast.makeText(TWebBrowActivity.this, getString(0x7f060229), 0).show();
        flag1 = false;
        flag = flag1;
        if (obj == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (((String) (obj)).compareTo("moment") != 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = new atz(TWebBrowActivity.this);
        if (!((atz) (obj)).b())
        {
            break MISSING_BLOCK_LABEL_362;
        }
        flag = flag1;
        if (((atz) (obj)).a())
        {
            continue; /* Loop/switch isn't completed */
        }
        Toast.makeText(TWebBrowActivity.this, getString(0x7f060227), 0).show();
        flag = flag2;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public String getDeviceInfosDictionary()
    {
        return bgx.b();
    }

    public ArrayList getFileImageUrlsWithJson(JSONObject jsonobject)
    {
        Object obj;
        ArrayList arraylist;
        arraylist = new ArrayList();
        obj = arraylist;
        if (jsonobject.isNull("data")) goto _L2; else goto _L1
_L1:
        jsonobject = jsonobject.getJSONObject("data");
        obj = arraylist;
        if (jsonobject.isNull("imageRes")) goto _L2; else goto _L3
_L3:
        jsonobject = jsonobject.getJSONArray("imageRes");
        obj = arraylist;
        if (jsonobject == null) goto _L2; else goto _L4
_L4:
        int i = 0;
_L5:
        obj = arraylist;
        if (i >= jsonobject.length())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = jsonobject.getJSONObject(i);
        if (!((JSONObject) (obj)).isNull("url"))
        {
            arraylist.add(((JSONObject) (obj)).getString("url"));
        }
        i++;
        if (true) goto _L5; else goto _L2
        jsonobject;
        obj = null;
        jsonobject.printStackTrace();
_L2:
        return ((ArrayList) (obj));
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

    public Intent getPhotoPickIntent()
    {
        return new Intent(TWebBrowActivity.this, com/wantu/activity/photoselector/SinglePhotoSelectorActivity);
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
        if (apq.a(getApplicationContext(), s))
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
        return apq.a();
    }

    public String isrespondsToFucForJS(String s)
    {
        if (apq.a(getClass(), s))
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
        webview = webview.getTitle();
        if (webview != null)
        {
            title.setText(webview);
        }
        Log.v("TWebBrowActivity", (new StringBuilder()).append("TWebBrowActivity: onPageFinished").append(s).toString());
    }

    public void onPageStarted(WebView webview, String s, Bitmap bitmap)
    {
        super.onPageStarted(webview, s, bitmap);
        if (s.startsWith("wantu://", 0))
        {
            if (!isPipLoadTwice)
            {
                isPipLoadTwice = true;
                return;
            } else
            {
                doShareActionByUrl(s);
                isPipLoadTwice = false;
                return;
            }
        }
        if (!s.startsWith("market://", 0)) goto _L2; else goto _L1
_L1:
        webview.stopLoading();
        Intent intent;
        try
        {
            if (!webview.getContext().getPackageManager().getApplicationInfo("com.android.vending", 0).packageName.equals("com.android.vending"))
            {
                webview.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
                webview.loadUrl("about:blank");
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (Bitmap bitmap)
        {
            try
            {
                webview.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(s)));
                webview.loadUrl("about:blank");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (WebView webview)
            {
                webview.printStackTrace();
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (WebView webview)
        {
            return;
        }
        bitmap = new Intent("android.intent.action.MAIN");
        bitmap.setPackage("com.android.vending");
        bitmap.addCategory("android.intent.category.LAUNCHER");
        bitmap = bitmap.resolveActivity(getPackageManager());
        if (bitmap != null) goto _L4; else goto _L3
_L3:
        bitmap = null;
_L5:
        intent = new Intent("android.intent.action.VIEW", Uri.parse(s));
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_242;
        }
        if (!bitmap.equals("") && !bitmap.equals("null"))
        {
            intent.setClassName("com.android.vending", bitmap);
        }
        webview.getContext().startActivity(intent);
        webview.loadUrl("about:blank");
        return;
_L4:
        bitmap = bitmap.getClassName();
        if (true) goto _L5; else goto _L2
_L2:
        super.onPageStarted(webview, s, bitmap);
        return;
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
        if (apq.a(getApplicationContext(), s))
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
        if (!aaj.i())
        {
            Toast.makeText(getApplicationContext(), 0x7f0600f6, 0).show();
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
            class _cls2
                implements Runnable
            {

                final TWebBrowActivity.TWebViewClient this$1;
                final String val$bitmapString;

                public void run()
                {
                    Log.i("TWebBrowActivity", (new StringBuilder()).append("saveWebPhoto ").append(bitmapString).toString());
                    Bitmap bitmap = stringtoBitmap(bitmapString);
                    saveBitmap(bitmap);
                }

            _cls2()
            {
                this$1 = TWebBrowActivity.TWebViewClient.this;
                bitmapString = s;
                super();
            }
            }

            (new Thread(new _cls2())).start();
            return;
        }
    }

    public void setDeviceTest(String s)
    {
        android.content.ewClient ewclient = InstaBeautyApplication.a.getSharedPreferences("DeviceTestSharedPreferences", 0).edit();
        if (s.compareToIgnoreCase("1") == 0)
        {
            ewclient.ean("DeviceTestSharedPreferencesTag", true);
        } else
        {
            ewclient.ean("DeviceTestSharedPreferencesTag", false);
        }
        ewclient.ean();
    }

    public void shareToWeChat(String s)
    {
        shareAllToWeChat(s);
    }

    public boolean shouldOverrideUrlLoading(final WebView errCallBack, final String funName)
    {
        boolean flag;
        flag = false;
        Log.v("TWebBrowActivity", (new StringBuilder()).append("TWebBrowActivity: shouldOverrideUrlLoading : ").append(funName).toString());
        if (!funName.contains("type=MAG_MASK_INFO") && !funName.contains("type=PIP_SCENE")) goto _L2; else goto _L1
_L1:
        doLocalActionByUrl(funName);
        flag = true;
_L4:
        return flag;
_L2:
        if (!funName.startsWith("fotoable://", 0)) goto _L4; else goto _L3
_L3:
        String s;
        errCallBack = Uri.parse(funName);
        s = errCallBack.getQueryParameter("type");
        if (s.compareTo("share") != 0) goto _L6; else goto _L5
_L5:
        doFotoableShareActionByUrl(funName);
_L8:
        return true;
_L6:
        if (s.compareTo("callOCFuc") == 0)
        {
            Log.i("callocfuc", "\u8C03\u7528\u5BA2\u6237\u7AEF\u65B9\u6CD5");
            funName = errCallBack.getQueryParameter("fucName");
            final String param = errCallBack.getQueryParameter("params");
            final String callBackFuc = errCallBack.getQueryParameter("callBack");
            final String callParam = errCallBack.getQueryParameter("backParams");
            errCallBack = errCallBack.getQueryParameter("errBack");
            Log.i("callocfuc", funName);
            TWebBrowActivity.access$500(TWebBrowActivity.this);
            class _cls1
                implements Runnable
            {

                final TWebBrowActivity.TWebViewClient this$1;
                final String val$callBackFuc;
                final String val$callParam;
                final String val$errCallBack;
                final String val$funName;
                final String val$param;

                public void run()
                {
                    class _cls1
                        implements Runnable
                    {

                        final _cls1 this$2;

                        public void run()
                        {
                            TWebBrowActivity.access$600(this$0);
                        }

                            _cls1()
                            {
                                this$2 = _cls1.this;
                                super();
                            }
                    }

                    try
                    {
                        callOcFuc(funName, param, callBackFuc, callParam, errCallBack);
                    }
                    catch (Exception exception)
                    {
                        exception.printStackTrace();
                    }
                    runOnUiThread(new _cls1());
                }

            _cls1()
            {
                this$1 = TWebBrowActivity.TWebViewClient.this;
                funName = s;
                param = s1;
                callBackFuc = s2;
                callParam = s3;
                errCallBack = s4;
                super();
            }
            }

            (new Handler()).postDelayed(new _cls1(), 150L);
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    public Bitmap stringtoBitmap(String s)
    {
        try
        {
            s = Base64.decode(s, 0);
            s = BitmapFactory.decodeByteArray(s, 0, s.length);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return s;
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

    _cls1()
    {
        this$0 = TWebBrowActivity.this;
        super();
        isPipLoadTwice = false;
    }
}
