// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Method;
import nativead.WebBrowerActivity;

public class cej extends WebViewClient
{

    boolean a;
    final WebBrowerActivity b;

    public cej(WebBrowerActivity webbroweractivity)
    {
        b = webbroweractivity;
        super();
        a = false;
    }

    public String a(Bitmap bitmap)
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

    public void a(String s, String s1, String s2, String s3, String s4)
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
            s = a((Bitmap)s);
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
            break MISSING_BLOCK_LABEL_224;
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
            (new Handler()).postDelayed(new cek(this, s, s1, s2, s3, webview), 150L);
        }
        return true;
    }
}
