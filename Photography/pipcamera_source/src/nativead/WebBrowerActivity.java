// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package nativead;

import ahk;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class WebBrowerActivity extends Activity
{

    int a;
    TextView b;
    private WebView c;
    private ProgressBar d;
    private String e;
    private ProgressDialog f;

    public WebBrowerActivity()
    {
        e = null;
        a = 0;
    }

    static ProgressDialog a(WebBrowerActivity webbroweractivity, ProgressDialog progressdialog)
    {
        webbroweractivity.f = progressdialog;
        return progressdialog;
    }

    static String a(WebBrowerActivity webbroweractivity)
    {
        return webbroweractivity.e;
    }

    private void a()
    {
        if (f == null)
        {
            f = new ProgressDialog(this);
            f.setProgressStyle(0);
            f.setMessage("\u6B63\u5728\u52A0\u8F7D \uFF0C\u8BF7\u7B49\u5F85...");
            f.setIndeterminate(false);
            f.setCancelable(true);
            f.setCanceledOnTouchOutside(false);
            f.setOnDismissListener(new android.content.DialogInterface.OnDismissListener() {

                final WebBrowerActivity a;

                public void onDismiss(DialogInterface dialoginterface)
                {
                    WebBrowerActivity.a(a, null);
                }

            
            {
                a = WebBrowerActivity.this;
                super();
            }
            });
            f.show();
        }
    }

    static WebView b(WebBrowerActivity webbroweractivity)
    {
        return webbroweractivity.c;
    }

    private String b(File file)
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

    private void b()
    {
        try
        {
            if (f != null)
            {
                f.dismiss();
                f = null;
            }
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }

    static ProgressBar c(WebBrowerActivity webbroweractivity)
    {
        return webbroweractivity.d;
    }

    public static void d(WebBrowerActivity webbroweractivity)
    {
        webbroweractivity.a();
    }

    public static void e(WebBrowerActivity webbroweractivity)
    {
        webbroweractivity.b();
    }

    public Intent a(File file)
    {
        Uri uri = Uri.fromFile(file);
        file = b(file);
        Log.i("tag", (new StringBuilder()).append("type=").append(file).toString());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(0x10000000);
        intent.setDataAndType(uri, file);
        return intent;
    }

    public void a(String s, InputStream inputstream)
    {
        if (!Environment.getExternalStorageState().equals("mounted"))
        {
            break MISSING_BLOCK_LABEL_83;
        }
        s = new File(Environment.getExternalStorageDirectory(), s);
        byte abyte0[];
        s = new FileOutputStream(s);
        abyte0 = new byte[2048];
_L1:
        int i = inputstream.read(abyte0);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_68;
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

    public void backBtnClicked(View view)
    {
        finish();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        try
        {
            requestWindowFeature(1);
            getWindow().setSoftInputMode(18);
            setContentView(com.fotoable.fotoadpackage.R.layout.activity_web_brower);
            b = (TextView)findViewById(com.fotoable.fotoadpackage.R.id.title);
            c = (WebView)findViewById(com.fotoable.fotoadpackage.R.id.web_brower);
            d = (ProgressBar)findViewById(com.fotoable.fotoadpackage.R.id.downloadProgressbar);
            bundle = c.getSettings();
            bundle.setJavaScriptEnabled(true);
            bundle.setJavaScriptCanOpenWindowsAutomatically(true);
            bundle.setUseWideViewPort(true);
            bundle.setLoadWithOverviewMode(true);
            bundle.setAllowFileAccess(true);
            bundle.setBuiltInZoomControls(false);
            bundle.setSupportZoom(false);
            c.setWebViewClient(new TWebViewClient());
            c.clearCache(true);
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
            break MISSING_BLOCK_LABEL_155;
        }
        e = bundle.getStringExtra("webUriString");
        c.loadUrl(e);
        c.setDownloadListener(new ahk(this));
        return;
    }

    protected void onStart()
    {
        super.onStart();
    }

    protected void onStop()
    {
        super.onStop();
    }

    private class TWebViewClient extends WebViewClient
    {

        boolean a;
        final WebBrowerActivity b;

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
                WebBrowerActivity.b(b).loadUrl(String.format("javascript:%s('%s,%s')", new Object[] {
                    s2, s, s3
                }));
                return;
            } else
            {
                WebBrowerActivity.b(b).loadUrl(String.format("javascript:%s('%s')", new Object[] {
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

        public void onPageFinished(WebView webview, String s)
        {
            super.onPageFinished(webview, s);
            WebBrowerActivity.c(b).setVisibility(8);
            webview = webview.getTitle();
            if (webview != null)
            {
                b.b.setText(webview);
            }
            Log.v("TWebBrowActivity", (new StringBuilder()).append("TWebBrowActivity: onPageFinished").append(s).toString());
        }

        public void onPageStarted(WebView webview, String s, Bitmap bitmap)
        {
            super.onPageStarted(webview, s, bitmap);
            if (s.startsWith("wantu://", 0))
            {
                if (!a)
                {
                    a = true;
                    return;
                } else
                {
                    a = false;
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
            bitmap = bitmap.resolveActivity(b.getPackageManager());
            if (bitmap != null) goto _L4; else goto _L3
_L3:
            bitmap = null;
_L5:
            intent = new Intent("android.intent.action.VIEW", Uri.parse(s));
            if (bitmap == null)
            {
                break MISSING_BLOCK_LABEL_231;
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
                WebBrowerActivity.b(b).loadUrl(WebBrowerActivity.a(b));
                return;
            }
            if (s1.startsWith("fotoable://", 0))
            {
                WebBrowerActivity.b(b).loadUrl(WebBrowerActivity.a(b));
                return;
            } else
            {
                super.onReceivedError(webview, i, s, s1);
                return;
            }
        }

        public void openInSafari(String s)
        {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(s));
            s = Intent.createChooser(intent, null);
            b.startActivity(s);
        }

        public void openInSafariWidthCloseSelf(String s)
        {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(s));
            s = Intent.createChooser(intent, null);
            b.startActivity(s);
            b.finish();
        }

        public boolean shouldOverrideUrlLoading(WebView webview, String s)
        {
            boolean flag;
            flag = false;
            Log.v("TWebBrowActivity", (new StringBuilder()).append("TWebBrowActivity: shouldOverrideUrlLoading : ").append(s).toString());
            if (!s.contains("type=MAG_MASK_INFO") && !s.contains("type=PIP_SCENE")) goto _L2; else goto _L1
_L1:
            flag = true;
_L4:
            return flag;
_L2:
            if (!s.startsWith("fotoable://", 0)) goto _L4; else goto _L3
_L3:
            webview = Uri.parse(s);
            s = webview.getQueryParameter("type");
            break MISSING_BLOCK_LABEL_79;
            if (s.compareTo("share") != 0 && s.compareTo("callOCFuc") == 0)
            {
                Log.i("callocfuc", "\u8C03\u7528\u5BA2\u6237\u7AEF\u65B9\u6CD5");
                s = webview.getQueryParameter("fucName");
                String s1 = webview.getQueryParameter("params");
                String s2 = webview.getQueryParameter("callBack");
                String s3 = webview.getQueryParameter("backParams");
                webview = webview.getQueryParameter("errBack");
                Log.i("callocfuc", s);
                WebBrowerActivity.d(b);
                (new Handler()).postDelayed(new Runnable(s, s1, s2, s3, webview) {

                    final String a;
                    final String b;
                    final String c;
                    final String d;
                    final String e;
                    final TWebViewClient f;

                    public void run()
                    {
                        try
                        {
                            f.callOcFuc(a, b, c, d, e);
                        }
                        catch (Exception exception)
                        {
                            exception.printStackTrace();
                        }
                        f.b.runOnUiThread(new Runnable(this) {

                            final _cls1 a;

                            public void run()
                            {
                                WebBrowerActivity.e(a.f.b);
                            }

                
                {
                    a = _pcls1;
                    super();
                }
                        });
                    }

                
                {
                    f = TWebViewClient.this;
                    a = s;
                    b = s1;
                    c = s2;
                    d = s3;
                    e = s4;
                    super();
                }
                }, 150L);
            }
            return true;
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

        TWebViewClient()
        {
            b = WebBrowerActivity.this;
            super();
            a = false;
        }
    }

}
