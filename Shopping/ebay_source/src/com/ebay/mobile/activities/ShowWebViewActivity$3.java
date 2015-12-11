// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.Intent;
import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import java.io.File;
import java.io.IOException;

// Referenced classes of package com.ebay.mobile.activities:
//            ShowWebViewActivity

class this._cls0 extends WebChromeClient
{

    final ShowWebViewActivity this$0;

    public void onProgressChanged(WebView webview, int i)
    {
        boolean flag1 = true;
        boolean flag = true;
        if (useLessProgressSpinner)
        {
            webview = ShowWebViewActivity.this;
            if (i > 30)
            {
                flag = false;
            }
            webview.showProgress(flag);
            return;
        }
        webview = ShowWebViewActivity.this;
        if (i <= 99)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        webview.showProgress(flag);
    }

    public boolean onShowFileChooser(WebView webview, ValueCallback valuecallback, android.webkit.ooserParams ooserparams)
    {
        if (filePathCallback != null)
        {
            filePathCallback.onReceiveValue(null);
        }
        filePathCallback = valuecallback;
        ooserparams = new Intent("android.media.action.IMAGE_CAPTURE");
        webview = ooserparams;
        if (ooserparams.resolveActivity(getPackageManager()) == null) goto _L2; else goto _L1
_L1:
        webview = null;
        valuecallback = createImageFile();
        webview = valuecallback;
        ooserparams.putExtra("PhotoPath", cameraPhotoPath);
        webview = valuecallback;
_L3:
        if (webview != null)
        {
            cameraPhotoPath = (new StringBuilder()).append("file:").append(webview.getAbsolutePath()).toString();
            ooserparams.putExtra("output", Uri.fromFile(webview));
            webview = ooserparams;
        } else
        {
            webview = null;
        }
_L2:
        ooserparams = new Intent("android.intent.action.GET_CONTENT");
        ooserparams.addCategory("android.intent.category.OPENABLE");
        ooserparams.setType("image/*");
        if (webview != null)
        {
            valuecallback = new Intent[1];
            valuecallback[0] = webview;
            webview = valuecallback;
        } else
        {
            webview = new Intent[0];
        }
        valuecallback = new Intent("android.intent.action.CHOOSER");
        valuecallback.putExtra("android.intent.extra.INTENT", ooserparams);
        valuecallback.putExtra("android.intent.extra.TITLE", "Image Chooser");
        valuecallback.putExtra("android.intent.extra.INITIAL_INTENTS", webview);
        startActivityForResult(valuecallback, 2);
        return true;
        valuecallback;
        ShowWebViewActivity.log.or("Unable to create Image File", valuecallback);
          goto _L3
    }

    public void openFileChooser(ValueCallback valuecallback, String s)
    {
        filePathCallback = valuecallback;
        valuecallback = new Intent("android.intent.action.GET_CONTENT");
        valuecallback.addCategory("android.intent.category.OPENABLE");
        valuecallback.setType("*/*");
        startActivityForResult(Intent.createChooser(valuecallback, "File Browser"), 2);
    }

    public void openFileChooser(ValueCallback valuecallback, String s, String s1)
    {
        valuecallback = new Intent("android.intent.action.GET_CONTENT");
        valuecallback.addCategory("android.intent.category.OPENABLE");
        valuecallback.setType("image/*");
        startActivityForResult(Intent.createChooser(valuecallback, "File Chooser"), 2);
    }

    ()
    {
        this$0 = ShowWebViewActivity.this;
        super();
    }
}
