// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.pipcamera.activity.photoselector.SinglePhotoSelectorActivity;
import com.pipcamera.activity.pip.Pip2FragmentActivity;
import com.pipcamera.activity.pip.PipFreeStyleActivity;
import com.pipcamera.activity.pip.PipStyleActivity;
import com.pipcamera.application.PIPCameraApplication;
import com.wantu.piprender.ESceneMode;
import ev;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import of;
import org.json.JSONException;
import org.json.JSONObject;
import pb;
import rd;
import so;
import uu;

public class TWebBrowActivity extends Activity
{

    private static final int PHOTO_PICKED_WITH_DATA = 3021;
    private static final int PHOTO_PICKED_WITH_SINGLE_DATA = 3022;
    private static final String TAG = "TWebBrowActivity";
    static final int THUMB_SIZE = 100;
    public static final String webUriString = "webUriString";
    so cropTask;
    int currSelectedInex;
    ESceneMode currentMode;
    boolean isActivityAlive;
    private ProgressDialog mDialog;
    private WebView mWebView;
    RelativeLayout navBar;
    private ProgressBar progressIndictor;
    TextView title;
    private String urlString;
    String webGetBitmapString;

    public TWebBrowActivity()
    {
        urlString = null;
        currentMode = ESceneMode.SCENE_MODE1;
        currSelectedInex = 0;
        isActivityAlive = true;
        webGetBitmapString = null;
    }

    private void appWillAppear()
    {
        try
        {
            mWebView.loadUrl(String.format("javascript:%s()", new Object[] {
                "appWillAppear"
            }));
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    private void closeProgressDialog()
    {
        if (mDialog == null)
        {
            break MISSING_BLOCK_LABEL_19;
        }
        mDialog.dismiss();
        mDialog = null;
        return;
        Exception exception;
        exception;
        Crashlytics.logException(exception);
        return;
    }

    private void finishedChoosePhoto(Uri uri)
    {
        if (currentMode == ESceneMode.SCENE_MODE1)
        {
            FlurryAgent.logEvent("pipmodel1BtnClicked");
            Intent intent = new Intent(this, com/pipcamera/activity/pip/PipStyleActivity);
            intent.putExtra("SelectedImageUri", uri.toString());
            intent.putExtra("defaultIndex", currSelectedInex);
            startActivity(intent);
            finish();
        } else
        {
            if (currentMode == ESceneMode.SCENE_MODE2)
            {
                FlurryAgent.logEvent("pipmodel2BtnClicked");
                Intent intent1 = new Intent(this, com/pipcamera/activity/pip/Pip2FragmentActivity);
                intent1.putExtra("SelectedImageUri", uri.toString());
                intent1.putExtra("defaultIndex", currSelectedInex);
                startActivity(intent1);
                finish();
                return;
            }
            if (currentMode == ESceneMode.SCENE_MODE3)
            {
                FlurryAgent.logEvent("pipmodel3BtnClicked");
                Intent intent2 = new Intent(this, com/pipcamera/activity/pip/PipFreeStyleActivity);
                intent2.putExtra("SelectedImageUri", uri.toString());
                startActivity(intent2);
                return;
            }
        }
    }

    private void finishedPickPhotoToWeb(final Uri imageUri)
    {
        if (imageUri == null)
        {
            return;
        } else
        {
            showProgressDialog();
            (new Thread(new Runnable() {

                final TWebBrowActivity this$0;
                final Uri val$imageUri;

                public void run()
                {
                    int i = getTotalRAM();
                    Bitmap bitmap;
                    if (i < 900)
                    {
                        i = 640;
                    } else
                    if (i > 1200)
                    {
                        i = 1280;
                    } else
                    {
                        i = 960;
                    }
                    try
                    {
                        bitmap = CropItemImage(imageUri, i);
                    }
                    catch (FileNotFoundException filenotfoundexception)
                    {
                        filenotfoundexception.printStackTrace();
                        filenotfoundexception = null;
                    }
                    catch (Exception exception)
                    {
                        exception.printStackTrace();
                        exception = null;
                    }
                    if (bitmap != null)
                    {
                        webGetBitmapString = bitmaptoString(bitmap);
                    }
                    runOnUiThread(new Runnable() {

                        final _cls3 this$1;

                        public void run()
                        {
                            closeProgressDialog();
                            if (webGetBitmapString != null)
                            {
                                mWebView.loadUrl(String.format("javascript:%s('%s')", new Object[] {
                                    "showBase64Image", webGetBitmapString
                                }));
                            }
                        }

            
            {
                this$1 = _cls3.this;
                super();
            }
                    });
                }

            
            {
                this$0 = TWebBrowActivity.this;
                imageUri = uri;
                super();
            }
            })).start();
            return;
        }
    }

    private String getMIMEType(File file)
    {
        file = file.getName();
        file = file.substring(file.lastIndexOf(".") + 1, file.length()).toLowerCase();
        if (file.equals("pdf"))
        {
            return "application/pdf";
        }
        if (file.equals("m4a") || file.equals("mp3") || file.equals("mid") || file.equals("xmf") || file.equals("ogg") || file.equals("wav"))
        {
            return "audio/*";
        }
        if (file.equals("3gp") || file.equals("mp4"))
        {
            return "video/*";
        }
        if (file.equals("jpg") || file.equals("gif") || file.equals("png") || file.equals("jpeg") || file.equals("bmp"))
        {
            return "image/*";
        }
        if (file.equals("apk"))
        {
            return "application/vnd.android.package-archive";
        } else
        {
            return "*/*";
        }
    }

    protected static int getOrientation(Context context, Uri uri)
    {
        context = context.getContentResolver().query(uri, new String[] {
            "orientation"
        }, null, null, null);
        if (context != null) goto _L2; else goto _L1
_L1:
        int i;
        if (context != null)
        {
            context.close();
        }
        i = -1;
_L4:
        return i;
_L2:
        int j;
        if (!context.moveToFirst())
        {
            break; /* Loop/switch isn't completed */
        }
        j = context.getInt(0);
        i = j;
        if (context != null)
        {
            context.close();
            return j;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (context != null)
        {
            context.close();
        }
        return -1;
        uri;
        context = null;
_L6:
        if (context != null)
        {
            context.close();
        }
        throw uri;
        uri;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private int getTotalRAM()
    {
        int i;
        try
        {
            RandomAccessFile randomaccessfile = new RandomAccessFile("/proc/meminfo", "r");
            String s = randomaccessfile.readLine();
            randomaccessfile.close();
            i = Integer.parseInt(s.split(":")[1].split("k")[0].replace(" ", ""));
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            return 1024;
        }
        return (int)((double)i / 1024D);
    }

    private void hideOcNavBar(boolean flag)
    {
        if (flag)
        {
            navBar.setVisibility(8);
            return;
        } else
        {
            navBar.setVisibility(0);
            return;
        }
    }

    private void openPackage(String s)
    {
        try
        {
            s = getPackageManager().getLaunchIntentForPackage(s);
            s.addFlags(0x10000000);
            startActivity(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Crashlytics.logException(s);
        }
    }

    private void sendToWechatByUrl(final String urlString, final uu shareinfo, final of wechatAssistant, final boolean scene)
    {
        (new Thread(new Runnable() {

            final TWebBrowActivity this$0;
            final boolean val$scene;
            final uu val$shareinfo;
            final String val$urlString;
            final of val$wechatAssistant;

            public void run()
            {
                Object obj;
                obj = (HttpURLConnection)(new URL(urlString)).openConnection();
                ((HttpURLConnection) (obj)).setConnectTimeout(8000);
                ((HttpURLConnection) (obj)).setRequestMethod("GET");
                if (((HttpURLConnection) (obj)).getResponseCode() != 200) goto _L2; else goto _L1
_L1:
                obj = ((HttpURLConnection) (obj)).getInputStream();
                  goto _L3
_L5:
                try
                {
                    obj = BitmapFactory.decodeStream(((InputStream) (obj)));
                    Bitmap bitmap = Bitmap.createScaledBitmap(((Bitmap) (obj)), 100, 100, true);
                    if (shareinfo != null)
                    {
                        wechatAssistant.a(shareinfo, bitmap, scene);
                        return;
                    }
                }
                catch (Exception exception)
                {
                    return;
                }
                wechatAssistant.a(((Bitmap) (obj)), scene);
                return;
_L2:
                obj = null;
_L3:
                if (obj != null) goto _L5; else goto _L4
_L4:
            }

            
            {
                this$0 = TWebBrowActivity.this;
                urlString = s;
                shareinfo = uu1;
                wechatAssistant = of1;
                scene = flag;
                super();
            }
        })).start();
    }

    private void showProgressDialog()
    {
        while (!isActivityAlive || mDialog != null || isFinishing()) 
        {
            return;
        }
        try
        {
            mDialog = new ProgressDialog(getParent());
            mDialog.setProgressStyle(0);
            mDialog.setMessage("\u6B63\u5728\u52A0\u8F7D \uFF0C\u8BF7\u7B49\u5F85...");
            mDialog.setIndeterminate(false);
            mDialog.setCancelable(true);
            mDialog.setCanceledOnTouchOutside(false);
            mDialog.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() {

                final TWebBrowActivity this$0;

                public void onDismiss(DialogInterface dialoginterface)
                {
                    mDialog = null;
                }

            
            {
                this$0 = TWebBrowActivity.this;
                super();
            }
            });
            mDialog.show();
            return;
        }
        catch (Exception exception)
        {
            Crashlytics.logException(exception);
        }
    }

    private void viewWillDisappear()
    {
        try
        {
            mWebView.loadUrl(String.format("javascript:%s()", new Object[] {
                "viewWillDisappear"
            }));
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    public Bitmap CropItemImage(Uri uri, int i)
    {
        Object obj;
        obj = uri.getScheme();
        Log.v("TWebBrowActivity", (new StringBuilder()).append("TWebBrowActivity targetScheme:").append(((String) (obj))).toString());
        if (!((String) (obj)).equalsIgnoreCase("file")) goto _L2; else goto _L1
_L1:
        float f = so.c((new ExifInterface(uri.getPath())).getAttributeInt("Orientation", 1));
        int j = (int)f;
_L5:
        Log.v("url", uri.toString());
        Log.v("orientation", (new StringBuilder()).append("Orientation : ").append(j).toString());
        obj = ev.a(PIPCameraApplication.b().c().getContentResolver().openInputStream(uri), PIPCameraApplication.b().c().getContentResolver().openInputStream(uri), i, i);
        if (obj == null)
        {
            FlurryAgent.onError("TWebBrowActivity012", "unexpected", "012");
            return null;
        }
          goto _L3
        obj;
        Crashlytics.logException(((Throwable) (obj)));
        ((Exception) (obj)).printStackTrace();
        j = -1;
          goto _L4
_L2:
        if (((String) (obj)).equalsIgnoreCase("content"))
        {
            j = getOrientation(PIPCameraApplication.b().c(), uri);
        } else
        {
            j = -1;
        }
_L4:
        if (true) goto _L5; else goto _L3
_L3:
label0:
        {
            uri = ((Uri) (obj));
            int k;
            int l;
            int i1;
            if (j != -1)
            {
                uri = ((Uri) (obj));
                if (j != 0)
                {
                    uri = new Matrix();
                    uri.setRotate(j, ((Bitmap) (obj)).getWidth(), ((Bitmap) (obj)).getHeight());
                    try
                    {
                        uri = Bitmap.createBitmap(((Bitmap) (obj)), 0, 0, ((Bitmap) (obj)).getWidth(), ((Bitmap) (obj)).getHeight(), uri, true);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Uri uri)
                    {
                        Crashlytics.logException(uri);
                        uri.printStackTrace();
                        return null;
                    }
                    if (obj == uri);
                }
            }
            l = uri.getWidth();
            i1 = uri.getHeight();
            j = l;
            k = i1;
            if (uri != null)
            {
                j = l;
                k = i1;
                if (Math.max(uri.getWidth(), uri.getHeight()) > i)
                {
                    float f1 = (float)uri.getWidth() / (float)uri.getHeight();
                    if (f1 > 1.0F)
                    {
                        if (l <= i)
                        {
                            i = l;
                        }
                        k = (int)((float)i / f1);
                        j = i;
                    } else
                    {
                        if (i1 <= i)
                        {
                            i = i1;
                        }
                        j = (int)((float)i * f1);
                        k = i;
                    }
                }
            }
            if (j % 2 == 0)
            {
                l = j;
                i1 = k;
                if (k % 2 == 0)
                {
                    break label0;
                }
            }
            i = j;
            if (j % 2 != 0)
            {
                i = j - 1;
            }
            l = i;
            i1 = k;
            if (k % 2 != 0)
            {
                i1 = k - 1;
                l = i;
            }
        }
        obj = Bitmap.createScaledBitmap(uri, l, i1, true);
        if (obj == uri);
        Log.v("TWebBrowActivity", (new StringBuilder()).append("cropWidth:").append(l).append("cropHeight:").append(i1).toString());
        return ((Bitmap) (obj));
    }

    public void backBtnClicked(View view)
    {
        isActivityAlive = false;
        finish();
    }

    public String bitmaptoString(Bitmap bitmap)
    {
        StringBuffer stringbuffer = new StringBuffer();
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        try
        {
            bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, bytearrayoutputstream);
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

    protected void doPickPhotoFromGalleryByRequestCode(int i)
    {
        try
        {
            startActivityForResult(getPhotoPickIntent(), i);
            return;
        }
        catch (ActivityNotFoundException activitynotfoundexception)
        {
            return;
        }
    }

    public Intent getFileIntent(File file)
    {
        Uri uri = Uri.fromFile(file);
        file = getMIMEType(file);
        Log.i("tag", (new StringBuilder()).append("type=").append(file).toString());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(0x10000000);
        intent.setDataAndType(uri, file);
        return intent;
    }

    public Intent getPhotoPickIntent()
    {
        return new Intent(this, com/pipcamera/activity/photoselector/SinglePhotoSelectorActivity);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (j != -1)
        {
            return;
        }
        Log.v("resultCode", String.valueOf(j));
        Log.v("requestCode", String.valueOf(i));
        switch (i)
        {
        default:
            return;

        case 3021: 
            if (intent == null)
            {
                Toast.makeText(this, "Load photo from gallery failed", 1).show();
                return;
            } else
            {
                intent = intent.getData();
                Log.v("url", intent.toString());
                finishedChoosePhoto(intent);
                return;
            }

        case 3022: 
            break;
        }
        if (intent == null)
        {
            Toast.makeText(this, "Load photo from gallery failed", 1).show();
            return;
        } else
        {
            finishedPickPhotoToWeb(intent.getData());
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        try
        {
            requestWindowFeature(1);
            getWindow().setSoftInputMode(18);
            setContentView(0x7f03002d);
            title = (TextView)findViewById(0x7f0c002d);
            navBar = (RelativeLayout)findViewById(0x7f0c007e);
            mWebView = (WebView)findViewById(0x7f0c00e3);
            progressIndictor = (ProgressBar)findViewById(0x7f0c00e2);
            bundle = mWebView.getSettings();
            bundle.setJavaScriptEnabled(true);
            bundle.setJavaScriptCanOpenWindowsAutomatically(true);
            bundle.setUseWideViewPort(true);
            bundle.setLoadWithOverviewMode(true);
            bundle.setAllowFileAccess(true);
            bundle.setBuiltInZoomControls(false);
            bundle.setSupportZoom(false);
            mWebView.requestFocus(130);
            mWebView.setWebViewClient(new TWebViewClient());
            mWebView.setWebChromeClient(new WebChromeClient() {

                final TWebBrowActivity this$0;

                public void onReceivedTitle(WebView webview, String s)
                {
                    super.onReceivedTitle(webview, s);
                    s = webview.getTitle();
                    if (s != null)
                    {
                        float f = pb.a(TWebBrowActivity.this) - 150;
                        f = pb.a(TWebBrowActivity.this, f);
                        int i = (int)((float)pb.b(TWebBrowActivity.this, f) / 20F);
                        webview = s;
                        if (s.length() > i)
                        {
                            webview = (new StringBuilder()).append(s.substring(0, i - 1)).append("...").toString();
                        }
                        title.setText(webview);
                    }
                }

            
            {
                this$0 = TWebBrowActivity.this;
                super();
            }
            });
            mWebView.clearCache(true);
            bundle = getIntent();
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
            Crashlytics.logException(bundle);
            return;
        }
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_194;
        }
        urlString = bundle.getStringExtra("webUriString");
        mWebView.loadUrl(urlString);
        mWebView.setDownloadListener(new MyWebViewDownLoadListener());
        return;
    }

    protected void onDestroy()
    {
        super.onDestroy();
        closeProgressDialog();
        isActivityAlive = false;
        if (cropTask != null)
        {
            cropTask.a(null);
        }
        super.onDestroy();
    }

    protected void onPause()
    {
        try
        {
            if (mWebView != null)
            {
                viewWillDisappear();
                if (android.os.Build.VERSION.SDK_INT >= 11 && android.os.Build.VERSION.SDK_INT != 16)
                {
                    mWebView.onPause();
                }
            }
        }
        catch (Exception exception) { }
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
        try
        {
            if (mWebView != null)
            {
                if (android.os.Build.VERSION.SDK_INT >= 11 && android.os.Build.VERSION.SDK_INT != 16)
                {
                    mWebView.onResume();
                }
                appWillAppear();
            }
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    protected void onStart()
    {
        super.onStart();
        FlurryAgent.onStartSession(this, PIPCameraApplication.h);
    }

    protected void onStop()
    {
        super.onStop();
        FlurryAgent.onEndSession(this);
    }

    public void saveBitmap(final Bitmap bitmap)
    {
        if (bitmap == null)
        {
            return;
        } else
        {
            Log.i("TWebBrowActivity", (new StringBuilder()).append("saveBitmap ").append(bitmap.getHeight()).toString());
            final File file = rd.a(bitmap);
            rd.a(file.getAbsolutePath(), getApplicationContext());
            runOnUiThread(new Runnable() {

                final TWebBrowActivity this$0;
                final Bitmap val$bitmap;
                final File val$file;

                public void run()
                {
                    if (bitmap != null && !bitmap.isRecycled())
                    {
                        bitmap.recycle();
                    }
                    if (file != null)
                    {
                        mWebView.loadUrl(String.format("javascript:%s(%b,'%s')", new Object[] {
                            "showSaveTip", Boolean.valueOf(true), file.getAbsolutePath()
                        }));
                        return;
                    } else
                    {
                        mWebView.loadUrl(String.format("javascr+ipt:%s(%b,'%s')", new Object[] {
                            "showSaveTip", Boolean.valueOf(false), "error"
                        }));
                        return;
                    }
                }

            
            {
                this$0 = TWebBrowActivity.this;
                bitmap = bitmap1;
                file = file1;
                super();
            }
            });
            return;
        }
    }

    public void shareAllToWeChat(String s)
    {
        Object obj;
        String s2;
        boolean flag;
        boolean flag4;
        boolean flag5;
        boolean flag6;
        flag = false;
        flag5 = true;
        flag6 = true;
        flag4 = true;
        obj = "";
        s2 = "";
        uu uu1;
        JSONObject jsonobject;
        jsonobject = new JSONObject(s);
        uu1 = new uu();
        String s1;
        Object obj1;
        obj1 = s2;
        s1 = ((String) (obj));
        if (!jsonobject.has("imageUrl"))
        {
            break MISSING_BLOCK_LABEL_76;
        }
        obj1 = s2;
        s1 = ((String) (obj));
        uu1.e = jsonobject.getString("imageUrl");
        obj1 = s2;
        s1 = ((String) (obj));
        if (!jsonobject.has("thumbUrl"))
        {
            break MISSING_BLOCK_LABEL_112;
        }
        obj1 = s2;
        s1 = ((String) (obj));
        uu1.c = jsonobject.getString("thumbUrl");
        obj1 = s2;
        s1 = ((String) (obj));
        if (!jsonobject.has("title"))
        {
            break MISSING_BLOCK_LABEL_148;
        }
        obj1 = s2;
        s1 = ((String) (obj));
        uu1.a = jsonobject.getString("title");
        obj1 = s2;
        s1 = ((String) (obj));
        if (!jsonobject.has("description"))
        {
            break MISSING_BLOCK_LABEL_184;
        }
        obj1 = s2;
        s1 = ((String) (obj));
        uu1.b = jsonobject.getString("description");
        obj1 = s2;
        s1 = ((String) (obj));
        if (!jsonobject.has("weburl"))
        {
            break MISSING_BLOCK_LABEL_220;
        }
        obj1 = s2;
        s1 = ((String) (obj));
        uu1.d = jsonobject.getString("weburl");
        obj1 = s2;
        s1 = ((String) (obj));
        if (!jsonobject.has("message"))
        {
            break MISSING_BLOCK_LABEL_256;
        }
        obj1 = s2;
        s1 = ((String) (obj));
        uu1.f = jsonobject.getString("message");
        s = ((String) (obj));
        obj1 = s2;
        s1 = ((String) (obj));
        if (!jsonobject.has("imageStr"))
        {
            break MISSING_BLOCK_LABEL_290;
        }
        obj1 = s2;
        s1 = ((String) (obj));
        s = jsonobject.getString("imageStr");
        obj = s2;
        obj1 = s2;
        s1 = s;
        if (!jsonobject.has("thumbStr"))
        {
            break MISSING_BLOCK_LABEL_325;
        }
        obj1 = s2;
        s1 = s;
        obj = jsonobject.getString("thumbStr");
        obj1 = obj;
        s1 = s;
        if (!jsonobject.has("scene")) goto _L2; else goto _L1
_L1:
        obj1 = obj;
        s1 = s;
        int i = jsonobject.getInt("scene");
_L15:
        s1 = s;
        s = uu1;
_L9:
        obj1 = new of(getApplicationContext());
        if (!((of) (obj1)).b() || s == null) goto _L4; else goto _L3
_L3:
        if (((uu) (s)).d == null || ((uu) (s)).d.length() <= 3) goto _L6; else goto _L5
_L5:
        if (((String) (obj)).length() <= 1) goto _L8; else goto _L7
_L7:
        obj = stringtoBitmap(((String) (obj)));
        if (obj != null)
        {
            if (i == 1)
            {
                flag = true;
            }
            ((of) (obj1)).a(s, ((Bitmap) (obj)), flag);
        }
_L4:
        return;
        obj1;
        obj = "";
        s1 = "";
        s = null;
_L13:
        ((JSONException) (obj1)).printStackTrace();
        Crashlytics.logException(((Throwable) (obj1)));
        i = 0;
          goto _L9
_L8:
        if (((uu) (s)).c == null || ((uu) (s)).c.length() <= 3) goto _L4; else goto _L10
_L10:
        obj = ((uu) (s)).c;
        boolean flag1;
        if (i == 1)
        {
            flag1 = flag4;
        } else
        {
            flag1 = false;
        }
        sendToWechatByUrl(((String) (obj)), s, ((of) (obj1)), flag1);
        return;
_L6:
        if ((s1 == null || s1.length() <= 3) && (((uu) (s)).e == null || ((uu) (s)).e.length() <= 3))
        {
            break MISSING_BLOCK_LABEL_636;
        }
        if (s1.length() <= 3)
        {
            continue; /* Loop/switch isn't completed */
        }
        s = stringtoBitmap(s1);
        if (s == null) goto _L4; else goto _L11
_L11:
        boolean flag2;
        if (i == 1)
        {
            flag2 = flag5;
        } else
        {
            flag2 = false;
        }
        ((of) (obj1)).a(s, flag2);
        return;
        if (((uu) (s)).e.length() <= 3) goto _L4; else goto _L12
_L12:
        s = ((uu) (s)).e;
        boolean flag3;
        if (i == 1)
        {
            flag3 = flag6;
        } else
        {
            flag3 = false;
        }
        sendToWechatByUrl(s, null, ((of) (obj1)), flag3);
        return;
        if (i == 0)
        {
            ((of) (obj1)).a(((uu) (s)).f);
            return;
        } else
        {
            ((of) (obj1)).b(((uu) (s)).f);
            return;
        }
        JSONException jsonexception;
        jsonexception;
        s = uu1;
        obj = obj1;
        obj1 = jsonexception;
          goto _L13
_L2:
        i = 0;
        if (true) goto _L15; else goto _L14
_L14:
    }

    public Bitmap stringtoBitmap(String s)
    {
        s.replace(' ', '+');
        Log.i("TWebBrowActivity", (new StringBuilder()).append("stringToBitmap ").append(s).toString());
        try
        {
            s = Base64.decode(s, 2);
            Log.i("TWebBrowActivity", (new StringBuilder()).append("bitmapArray ").append(s.length).toString());
            s = BitmapFactory.decodeByteArray(s, 0, s.length);
            Log.i("TWebBrowActivity", (new StringBuilder()).append("toBitmap ").append(s.getHeight()).toString());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            Crashlytics.logException(s);
            return null;
        }
        return s;
    }

    public void writeToSDCard(String s, InputStream inputstream)
    {
        if (!Environment.getExternalStorageState().equals("mounted"))
        {
            break MISSING_BLOCK_LABEL_92;
        }
        s = new File(Environment.getExternalStorageDirectory(), s);
        byte abyte0[];
        s = new FileOutputStream(s);
        abyte0 = new byte[2048];
_L1:
        int i = inputstream.read(abyte0);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        s.write(abyte0, 0, i);
          goto _L1
        try
        {
            s.flush();
            s.close();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            Crashlytics.logException(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
        Crashlytics.logException(s);
        return;
        Log.i("tag", "NO SDCard.");
        return;
    }


/*
    static ProgressDialog access$102(TWebBrowActivity twebbrowactivity, ProgressDialog progressdialog)
    {
        twebbrowactivity.mDialog = progressdialog;
        return progressdialog;
    }

*/









    private class TWebViewClient extends WebViewClient
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
                bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, bytearrayoutputstream);
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
                mWebView.loadUrl(String.format("javascript:%s('%s,%s')", new Object[] {
                    s2, s, s3
                }));
                return;
            } else
            {
                mWebView.loadUrl(String.format("javascript:%s('%s')", new Object[] {
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
                obj = android.provider.MediaStore.Images.Media.getBitmap(getContentResolver(), ((Uri) (obj)));
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
            hideOcNavBar(flag);
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
            progressIndictor.setVisibility(8);
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
                mWebView.loadUrl(urlString);
                return;
            }
            try
            {
                if (s1.startsWith("fotoable://", 0))
                {
                    mWebView.loadUrl(urlString);
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
                openPackage(s);
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

                    final TWebViewClient this$1;
                    final String val$bitmapString;

                    public void run()
                    {
                        Log.i("TWebBrowActivity", (new StringBuilder()).append("saveWebPhoto ").append(bitmapString).toString());
                        Bitmap bitmap = stringtoBitmap(bitmapString);
                        saveBitmap(bitmap);
                    }

                
                {
                    this$1 = TWebViewClient.this;
                    bitmapString = s;
                    super();
                }
                })).start();
                return;
            }
        }

        public void setDeviceTest(String s)
        {
            android.content.SharedPreferences.Editor editor = PIPCameraApplication.a.getSharedPreferences("DeviceTestSharedPreferences", 0).edit();
            if (s.compareToIgnoreCase("1") == 0)
            {
                editor.putBoolean("DeviceTestSharedPreferencesTag", true);
            } else
            {
                editor.putBoolean("DeviceTestSharedPreferencesTag", false);
            }
            editor.apply();
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
                    showProgressDialog();
                    (new Handler()).postDelayed(new Runnable() {

                        final TWebViewClient this$1;
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
                                    closeProgressDialog();
                                }

                
                {
                    this$2 = _cls1.this;
                    super();
                }
                            });
                        }

                
                {
                    this$1 = TWebViewClient.this;
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
            return mWebView.canGoBack();
        }

        public boolean webCanGoForword()
        {
            return mWebView.canGoForward();
        }

        public boolean webGoBack()
        {
            if (webCanGoBack())
            {
                mWebView.goBack();
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
                mWebView.goForward();
                return true;
            } else
            {
                return false;
            }
        }

        TWebViewClient()
        {
            this$0 = TWebBrowActivity.this;
            super();
            isPipLoadTwice = false;
        }
    }


    private class MyWebViewDownLoadListener
        implements DownloadListener
    {

        final TWebBrowActivity this$0;

        public void onDownloadStart(String s, String s1, String s2, String s3, long l)
        {
            if (!Environment.getExternalStorageState().equals("mounted"))
            {
                s = Toast.makeText(TWebBrowActivity.this, "\u9700\u8981SD\u5361\u3002", 1);
                s.setGravity(17, 0, 0);
                s.show();
                return;
            } else
            {
                (new DownloaderTask()).execute(new String[] {
                    s
                });
                return;
            }
        }

        private MyWebViewDownLoadListener()
        {
            this$0 = TWebBrowActivity.this;
            super();
        }


        private class DownloaderTask extends AsyncTask
        {

            final TWebBrowActivity this$0;

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((String[])aobj);
            }

            protected transient String doInBackground(String as[])
            {
label0:
                {
                    Object obj = as[0];
                    as = URLDecoder.decode(((String) (obj)).substring(((String) (obj)).lastIndexOf("/") + 1));
                    Log.i("tag", (new StringBuilder()).append("fileName=").append(as).toString());
                    if ((new File(Environment.getExternalStorageDirectory(), as)).exists())
                    {
                        Log.i("tag", "The file has already exists.");
                        return as;
                    }
                    try
                    {
                        obj = (new DefaultHttpClient()).execute(new HttpGet(((String) (obj))));
                        if (200 != ((HttpResponse) (obj)).getStatusLine().getStatusCode())
                        {
                            break label0;
                        }
                        obj = ((HttpResponse) (obj)).getEntity().getContent();
                        writeToSDCard(as, ((InputStream) (obj)));
                        ((InputStream) (obj)).close();
                    }
                    // Misplaced declaration of an exception variable
                    catch (String as[])
                    {
                        as.printStackTrace();
                        Crashlytics.logException(as);
                        return null;
                    }
                    return as;
                }
                return null;
            }

            protected void onCancelled()
            {
                super.onCancelled();
            }

            protected volatile void onPostExecute(Object obj)
            {
                onPostExecute((String)obj);
            }

            protected void onPostExecute(String s)
            {
                super.onPostExecute(s);
                closeProgressDialog();
                if (s == null)
                {
                    s = Toast.makeText(TWebBrowActivity.this, "\u8FDE\u63A5\u9519\u8BEF\uFF01\u8BF7\u7A0D\u540E\u518D\u8BD5\uFF01", 1);
                    s.setGravity(17, 0, 0);
                    s.show();
                    return;
                } else
                {
                    s = new File(Environment.getExternalStorageDirectory(), s);
                    Log.i("tag", (new StringBuilder()).append("Path=").append(s.getAbsolutePath()).toString());
                    s = getFileIntent(s);
                    startActivity(s);
                    return;
                }
            }

            protected void onPreExecute()
            {
                super.onPreExecute();
                showProgressDialog();
            }

            protected volatile void onProgressUpdate(Object aobj[])
            {
                onProgressUpdate((Void[])aobj);
            }

            protected transient void onProgressUpdate(Void avoid[])
            {
                super.onProgressUpdate(avoid);
            }

            public DownloaderTask()
            {
                this$0 = TWebBrowActivity.this;
                super();
            }
        }

    }

}
