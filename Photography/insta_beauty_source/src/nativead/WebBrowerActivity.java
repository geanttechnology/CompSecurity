// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package nativead;

import aar;
import aas;
import android.app.Activity;
import android.app.ProgressDialog;
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
import ceg;
import cei;
import cej;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class WebBrowerActivity extends Activity
{

    int a;
    public TextView b;
    private WebView c;
    private ProgressBar d;
    private String e;
    private ProgressDialog f;

    public WebBrowerActivity()
    {
        e = null;
        a = 0;
    }

    public static ProgressDialog a(WebBrowerActivity webbroweractivity, ProgressDialog progressdialog)
    {
        webbroweractivity.f = progressdialog;
        return progressdialog;
    }

    public static String a(WebBrowerActivity webbroweractivity)
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
            f.setOnDismissListener(new ceg(this));
            f.show();
        }
    }

    public static WebView b(WebBrowerActivity webbroweractivity)
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

    public static ProgressBar c(WebBrowerActivity webbroweractivity)
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
            setContentView(aas.activity_web_brower);
            b = (TextView)findViewById(aar.title);
            c = (WebView)findViewById(aar.web_brower);
            d = (ProgressBar)findViewById(aar.downloadProgressbar);
            bundle = c.getSettings();
            bundle.setJavaScriptEnabled(true);
            bundle.setJavaScriptCanOpenWindowsAutomatically(true);
            bundle.setUseWideViewPort(true);
            bundle.setLoadWithOverviewMode(true);
            bundle.setAllowFileAccess(true);
            bundle.setBuiltInZoomControls(false);
            bundle.setSupportZoom(false);
            c.setWebViewClient(new cej(this));
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
        c.setDownloadListener(new cei(this, null));
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
}
