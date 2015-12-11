// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import com.groupon.cookies.CookieFactory;
import com.groupon.service.LoginService;
import com.groupon.util.ActionBarUtil;
import com.groupon.util.CacheUtils;
import com.groupon.util.WebViewHelper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import org.restlet.engine.util.InternetUsDateFormat;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.activity:
//            GrouponActivity

public class LogViewer extends GrouponActivity
{

    private CookieFactory cookieFactory;
    private InternetUsDateFormat internetUsDateFormat;
    private LoginService loginService;
    EditText search;
    private File tmpFile;
    private String userAgent;
    WebView webView;

    public LogViewer()
    {
    }

    public void onBack(View view)
    {
        webView.findNext(false);
    }

    public void onCreate(Bundle bundle)
    {
        Object obj1;
        super.onCreate(bundle);
        setContentView(0x7f030157);
        webView.getSettings().setLayoutAlgorithm(android.webkit.WebSettings.LayoutAlgorithm.NORMAL);
        Ln.i("bcookie:        %s", new Object[] {
            cookieFactory.getBrowserCookie()
        });
        Ln.i("user-permalink: %s", new Object[] {
            loginService.getUserId()
        });
        Ln.i("datetime:       %s", new Object[] {
            internetUsDateFormat.format("yyyy-MM-dd HH:mm:ss.SSSZ", new Date())
        });
        Ln.i("user-agent:     %s", new Object[] {
            userAgent
        });
        bundle = null;
        obj1 = null;
        Object obj = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[] {
            "logcat", "-d", "-v", "threadtime"
        }).getInputStream(), "UTF-8"), 32768);
        tmpFile = File.createTempFile("groupon", ".html", CacheUtils.getCacheDir(getApplicationContext()));
        tmpFile.setReadable(true, false);
        obj1 = new OutputStreamWriter(new FileOutputStream(tmpFile, true), "UTF-8");
        ((Writer) (obj1)).write("<html><body><style type='text/css'>div.e { color:red; } div.w {color:orange;} </style>\n<pre>");
_L5:
        String s = ((BufferedReader) (obj)).readLine();
        if (s == null) goto _L2; else goto _L1
_L1:
        StringBuilder stringbuilder;
        int i;
        i = s.indexOf("/COM.GROUPON") - 1;
        stringbuilder = (new StringBuilder()).append("<div class='");
        if (i < 0) goto _L4; else goto _L3
_L3:
        bundle = Character.valueOf(s.charAt(i));
_L6:
        ((Writer) (obj1)).write(stringbuilder.append(bundle).append("'>").append(s).append("</div>\n").toString());
          goto _L5
        obj1;
        bundle = ((Bundle) (obj));
        obj = obj1;
_L8:
        throw new RuntimeException(((Throwable) (obj)));
        obj;
_L7:
        if (bundle != null)
        {
            try
            {
                bundle.close();
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                bundle.printStackTrace();
            }
        }
        throw obj;
_L4:
        bundle = "";
          goto _L6
_L2:
        ((Writer) (obj1)).write("</pre></body></html>\n");
        webView.loadUrl((new StringBuilder()).append("file://").append(tmpFile.getAbsolutePath()).toString());
        if (obj != null)
        {
            try
            {
                ((BufferedReader) (obj)).close();
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                bundle.printStackTrace();
            }
        }
        webView.setWebViewClient(new WebViewClient() {

            final LogViewer this$0;

            public void onPageFinished(WebView webview, String s1)
            {
                webview.post(new Runnable() {

                    final _cls1 this$1;

                    public void run()
                    {
                        if (!webView.pageDown(true))
                        {
                            webView.post(this);
                        }
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
            }

            
            {
                this$0 = LogViewer.this;
                super();
            }
        });
        WebViewHelper.addInAppUserAgent(webView);
        search.addTextChangedListener(new TextWatcher() {

            final LogViewer this$0;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int j, int k, int l)
            {
            }

            public void onTextChanged(CharSequence charsequence, int j, int k, int l)
            {
                if (charsequence.length() >= 3)
                {
                    webView.findAllAsync(search.getText().toString());
                }
            }

            
            {
                this$0 = LogViewer.this;
                super();
            }
        });
        webView.requestFocus();
        return;
        obj1;
        bundle = ((Bundle) (obj));
        obj = obj1;
          goto _L7
        obj;
        bundle = ((Bundle) (obj1));
          goto _L8
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        ActionBarUtil.addShareMenu(getMenuInflater(), menu).setOnMenuItemClickListener(new android.view.MenuItem.OnMenuItemClickListener() {

            final LogViewer this$0;

            public boolean onMenuItemClick(MenuItem menuitem)
            {
                menuitem = new Intent();
                menuitem.setAction("android.intent.action.SEND");
                menuitem.putExtra("android.intent.extra.STREAM", Uri.fromFile(tmpFile));
                menuitem.setType("text/html");
                startActivity(Intent.createChooser(menuitem, "Send to"));
                return false;
            }

            
            {
                this$0 = LogViewer.this;
                super();
            }
        }).setTitle("Share").setShowAsActionFlags(5);
        return true;
    }

    public void onDestroy()
    {
        super.onDestroy();
        tmpFile.delete();
    }

    public void onForward(View view)
    {
        webView.findNext(true);
    }

}
