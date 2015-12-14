// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.adbuttonlib;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import apq;
import atz;
import bjd;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.fotobeauty.FullscreenActivity;
import com.instabeauty.application.InstaBeautyApplication;
import com.wantu.ResourceOnlineLibrary.compose.TPhotoMagComposeManager;
import com.wantu.model.res.WXDLShareInfo;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import sm;
import yo;

public class TWebBrowActivity extends FullscreenActivity
{

    private static final int PHOTO_PICKED_WITH_DATA = 3021;
    private static final int PHOTO_PICKED_WITH_SINGLE_DATA = 3022;
    private static final String TAG = "TWebBrowActivity";
    static final int THUMB_SIZE = 100;
    public static final String webUriString = "webUriString";
    bjd cropTask;
    boolean isActivityAlive;
    private ProgressDialog mDialog;
    private WebView mWebView;
    private TPhotoMagComposeManager magComposeManager;
    FrameLayout navBar;
    private ProgressBar progressIndictor;
    TextView title;
    private String urlString;
    String webGetBitmapString;

    public TWebBrowActivity()
    {
        urlString = null;
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
        try
        {
            if (mDialog != null)
            {
                mDialog.dismiss();
                mDialog = null;
            }
            return;
        }
        catch (Exception exception)
        {
            return;
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
            (new Thread(new _cls3())).start();
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

    private TPhotoMagComposeManager getMagComposeManager()
    {
        if (magComposeManager == null)
        {
            magComposeManager = apq.c().d();
        }
        return magComposeManager;
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

    private void sendToWechatByUrl(final String urlString, final WXDLShareInfo shareinfo, final atz wechatAssistant, final boolean scene)
    {
        (new Thread(new _cls5())).start();
    }

    private void showProgressDialog()
    {
        if (isActivityAlive) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (mDialog != null) goto _L1; else goto _L3
_L3:
        mDialog = new ProgressDialog(this);
        mDialog.setProgressStyle(0);
        mDialog.setMessage("\u6B63\u5728\u52A0\u8F7D \uFF0C\u8BF7\u7B49\u5F85...");
        mDialog.setIndeterminate(false);
        mDialog.setCancelable(true);
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.setOnDismissListener(new _cls2());
        mDialog.show();
        return;
        Exception exception;
        exception;
        Crashlytics.logException(exception);
        return;
    }

    private void startCrop(ArrayList arraylist)
    {
        char c = '\u03C0';
        showProgressDialog();
        cropTask = new bjd();
        cropTask.a(arraylist);
        if (getSharedPreferences("SP", 0).getInt("setting_func_img_quality", 0) != 0) goto _L2; else goto _L1
_L1:
        if (!InstaBeautyApplication.b)
        {
            c = '\u0500';
        }
        cropTask.b(c);
_L4:
        cropTask.d(new ArrayList[] {
            arraylist
        });
        return;
_L2:
        if (InstaBeautyApplication.b)
        {
            c = '\u0280';
        }
        cropTask.b(c);
        if (true) goto _L4; else goto _L3
_L3:
        arraylist;
        arraylist.printStackTrace();
        Crashlytics.logException(arraylist);
        return;
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
        float f = bjd.c((new ExifInterface(uri.getPath())).getAttributeInt("Orientation", 1));
        int j = (int)f;
_L5:
        Log.v("url", uri.toString());
        Log.v("orientation", (new StringBuilder()).append("Orientation : ").append(j).toString());
        obj = yo.a(InstaBeautyApplication.a().b().getContentResolver().openInputStream(uri), InstaBeautyApplication.a().b().getContentResolver().openInputStream(uri), i, i);
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
            j = getOrientation(InstaBeautyApplication.a().b(), uri);
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

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (j != -1)
        {
            return;
        }
        switch (i)
        {
        default:
            return;

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
            setContentView(0x7f030040);
            navBar = (FrameLayout)findViewById(0x7f0d0109);
            title = (TextView)findViewById(0x7f0d0034);
            mWebView = (WebView)findViewById(0x7f0d018f);
            progressIndictor = (ProgressBar)findViewById(0x7f0d018e);
            bundle = mWebView.getSettings();
            bundle.setJavaScriptEnabled(true);
            bundle.setJavaScriptCanOpenWindowsAutomatically(true);
            bundle.setUseWideViewPort(true);
            bundle.setLoadWithOverviewMode(true);
            bundle.setAllowFileAccess(true);
            bundle.setBuiltInZoomControls(false);
            bundle.setSupportZoom(false);
            mWebView.setWebViewClient(new TWebViewClient());
            mWebView.setWebChromeClient(new _cls1());
            mWebView.clearCache(true);
            bundle = getIntent();
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
            return;
        }
        if (bundle == null)
        {
            break MISSING_BLOCK_LABEL_183;
        }
        urlString = bundle.getStringExtra("webUriString");
        mWebView.loadUrl(urlString);
        mWebView.setDownloadListener(new MyWebViewDownLoadListener(null));
        return;
    }

    protected void onDestroy()
    {
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
    }

    protected void onStop()
    {
        super.onStop();
    }

    public void saveBitmap(final Bitmap bitmap)
    {
        if (bitmap == null)
        {
            return;
        } else
        {
            Log.i("TWebBrowActivity", (new StringBuilder()).append("saveBitmap ").append(bitmap.getHeight()).toString());
            final File file = sm.a(bitmap);
            sm.a(file.getAbsolutePath(), getApplicationContext());
            runOnUiThread(new _cls4());
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
        WXDLShareInfo wxdlshareinfo;
        JSONObject jsonobject;
        jsonobject = new JSONObject(s);
        wxdlshareinfo = new WXDLShareInfo();
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
        wxdlshareinfo.imageUrl = jsonobject.getString("imageUrl");
        obj1 = s2;
        s1 = ((String) (obj));
        if (!jsonobject.has("thumbUrl"))
        {
            break MISSING_BLOCK_LABEL_112;
        }
        obj1 = s2;
        s1 = ((String) (obj));
        wxdlshareinfo.thumbUrl = jsonobject.getString("thumbUrl");
        obj1 = s2;
        s1 = ((String) (obj));
        if (!jsonobject.has("title"))
        {
            break MISSING_BLOCK_LABEL_148;
        }
        obj1 = s2;
        s1 = ((String) (obj));
        wxdlshareinfo.title = jsonobject.getString("title");
        obj1 = s2;
        s1 = ((String) (obj));
        if (!jsonobject.has("description"))
        {
            break MISSING_BLOCK_LABEL_184;
        }
        obj1 = s2;
        s1 = ((String) (obj));
        wxdlshareinfo.description = jsonobject.getString("description");
        obj1 = s2;
        s1 = ((String) (obj));
        if (!jsonobject.has("weburl"))
        {
            break MISSING_BLOCK_LABEL_220;
        }
        obj1 = s2;
        s1 = ((String) (obj));
        wxdlshareinfo.webpageUrl = jsonobject.getString("weburl");
        obj1 = s2;
        s1 = ((String) (obj));
        if (!jsonobject.has("message"))
        {
            break MISSING_BLOCK_LABEL_256;
        }
        obj1 = s2;
        s1 = ((String) (obj));
        wxdlshareinfo.message = jsonobject.getString("message");
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
        s = wxdlshareinfo;
_L9:
        obj1 = new atz(getApplicationContext());
        if (!((atz) (obj1)).b() || s == null) goto _L4; else goto _L3
_L3:
        if (((WXDLShareInfo) (s)).webpageUrl == null || ((WXDLShareInfo) (s)).webpageUrl.length() <= 3) goto _L6; else goto _L5
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
            ((atz) (obj1)).a(s, ((Bitmap) (obj)), flag);
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
        if (((WXDLShareInfo) (s)).thumbUrl == null || ((WXDLShareInfo) (s)).thumbUrl.length() <= 3) goto _L4; else goto _L10
_L10:
        obj = ((WXDLShareInfo) (s)).thumbUrl;
        boolean flag1;
        if (i == 1)
        {
            flag1 = flag4;
        } else
        {
            flag1 = false;
        }
        sendToWechatByUrl(((String) (obj)), s, ((atz) (obj1)), flag1);
        return;
_L6:
        if ((s1 == null || s1.length() <= 3) && (((WXDLShareInfo) (s)).imageUrl == null || ((WXDLShareInfo) (s)).imageUrl.length() <= 3))
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
        ((atz) (obj1)).a(s, flag2);
        return;
        if (((WXDLShareInfo) (s)).imageUrl.length() <= 3) goto _L4; else goto _L12
_L12:
        s = ((WXDLShareInfo) (s)).imageUrl;
        boolean flag3;
        if (i == 1)
        {
            flag3 = flag6;
        } else
        {
            flag3 = false;
        }
        sendToWechatByUrl(s, null, ((atz) (obj1)), flag3);
        return;
        if (i == 0)
        {
            ((atz) (obj1)).a(((WXDLShareInfo) (s)).message);
            return;
        } else
        {
            ((atz) (obj1)).b(((WXDLShareInfo) (s)).message);
            return;
        }
        JSONException jsonexception;
        jsonexception;
        s = wxdlshareinfo;
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
            break MISSING_BLOCK_LABEL_84;
        }
        s = new File(Environment.getExternalStorageDirectory(), s);
        byte abyte0[];
        s = new FileOutputStream(s);
        abyte0 = new byte[2048];
_L1:
        int i = inputstream.read(abyte0);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_69;
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
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
        }
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









    private class _cls3
        implements Runnable
    {

        final TWebBrowActivity this$0;
        final Uri val$imageUri;

        public void run()
        {
            int i = getTotalRAM();
            class _cls1
                implements Runnable
            {

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

                _cls1()
                {
                    this$1 = _cls3.this;
                    super();
                }
            }

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
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
                ioexception = null;
            }
            if (bitmap != null)
            {
                webGetBitmapString = bitmaptoString(bitmap);
            }
            runOnUiThread(new _cls1());
        }

        _cls3()
        {
            this$0 = TWebBrowActivity.this;
            imageUri = uri;
            super();
        }
    }


    private class _cls5
        implements Runnable
    {

        final TWebBrowActivity this$0;
        final boolean val$scene;
        final WXDLShareInfo val$shareinfo;
        final String val$urlString;
        final atz val$wechatAssistant;

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

        _cls5()
        {
            this$0 = TWebBrowActivity.this;
            urlString = s;
            shareinfo = wxdlshareinfo;
            wechatAssistant = atz1;
            scene = flag;
            super();
        }
    }


    private class _cls2
        implements android.content.DialogInterface.OnDismissListener
    {

        final TWebBrowActivity this$0;

        public void onDismiss(DialogInterface dialoginterface)
        {
            mDialog = null;
        }

        _cls2()
        {
            this$0 = TWebBrowActivity.this;
            super();
        }
    }


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
            if (s != null && (s instanceof Bitmap))
            {
                s = bitmaptoString((Bitmap)s);
            } else
            {
                s = "";
            }
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
                    if (getMagComposeManager().isExistedByResId(j))
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
            progressIndictor.setVisibility(8);
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
            if (apq.a(getApplicationContext(), s))
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

                    final TWebViewClient this$1;
                    final String val$bitmapString;

                    public void run()
                    {
                        Log.i("TWebBrowActivity", (new StringBuilder()).append("saveWebPhoto ").append(bitmapString).toString());
                        Bitmap bitmap = stringtoBitmap(bitmapString);
                        saveBitmap(bitmap);
                    }

                _cls2()
                {
                    this$1 = TWebViewClient.this;
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
            android.content.SharedPreferences.Editor editor = InstaBeautyApplication.a.getSharedPreferences("DeviceTestSharedPreferences", 0).edit();
            if (s.compareToIgnoreCase("1") == 0)
            {
                editor.putBoolean("DeviceTestSharedPreferencesTag", true);
            } else
            {
                editor.putBoolean("DeviceTestSharedPreferencesTag", false);
            }
            editor.apply();
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
                showProgressDialog();
                class _cls1
                    implements Runnable
                {

                    final TWebViewClient this$1;
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
                                closeProgressDialog();
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
                    this$1 = TWebViewClient.this;
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


    private class _cls1 extends WebChromeClient
    {

        final TWebBrowActivity this$0;

        public void onReceivedTitle(WebView webview, String s)
        {
            super.onReceivedTitle(webview, s);
            s = webview.getTitle();
            if (s != null)
            {
                float f = yp.a(TWebBrowActivity.this) - 150;
                f = yp.a(TWebBrowActivity.this, f);
                int i = (int)((float)yp.b(TWebBrowActivity.this, f) / 20F);
                webview = s;
                if (s.length() > i)
                {
                    webview = (new StringBuilder()).append(s.substring(0, i - 1)).append("...").toString();
                }
                title.setText(webview);
            }
        }

        _cls1()
        {
            this$0 = TWebBrowActivity.this;
            super();
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

        MyWebViewDownLoadListener(_cls1 _pcls1)
        {
            this();
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
                Object obj = as[0];
                as = URLDecoder.decode(((String) (obj)).substring(((String) (obj)).lastIndexOf("/") + 1));
                Log.i("tag", (new StringBuilder()).append("fileName=").append(as).toString());
                if (!(new File(Environment.getExternalStorageDirectory(), as)).exists())
                {
                    break MISSING_BLOCK_LABEL_72;
                }
                Log.i("tag", "The file has already exists.");
                return as;
label0:
                {
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
                    try
                    {
                        s = Toast.makeText(TWebBrowActivity.this, "\u8FDE\u63A5\u9519\u8BEF\uFF01\u8BF7\u7A0D\u540E\u518D\u8BD5\uFF01", 1);
                        s.setGravity(17, 0, 0);
                        s.show();
                        return;
                    }
                    // Misplaced declaration of an exception variable
                    catch (String s)
                    {
                        s.printStackTrace();
                    }
                    break MISSING_BLOCK_LABEL_103;
                }
                s = new File(Environment.getExternalStorageDirectory(), s);
                Log.i("tag", (new StringBuilder()).append("Path=").append(s.getAbsolutePath()).toString());
                s = getFileIntent(s);
                startActivity(s);
                return;
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


    private class _cls4
        implements Runnable
    {

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

        _cls4()
        {
            this$0 = TWebBrowActivity.this;
            bitmap = bitmap1;
            file = file1;
            super();
        }
    }

}
