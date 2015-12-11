// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.widget.Toast;

// Referenced classes of package com.ebay.mobile.activities:
//            ShowWebViewActivity

class this._cls0
    implements DownloadListener
{

    final ShowWebViewActivity this$0;

    public void onDownloadStart(String s, String s1, String s2, String s3, long l)
    {
        if (s != null)
        {
            if ("true".equals((s1 = Uri.parse(s)).getQueryParameter("printable")))
            {
                s = CookieManager.getInstance().getCookie(s);
                s1 = new android.app.t(s1);
                s1.addRequestHeader("cookie", s);
                s1.allowScanningByMediaScanner();
                s1.setNotificationVisibility(1);
                s1.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "ValetLabel.pdf");
                ((DownloadManager)getSystemService("download")).enqueue(s1);
                s = new Intent("android.intent.action.OPEN_DOCUMENT");
                s.addCategory("android.intent.category.OPENABLE");
                s.setType("*/*");
                Toast.makeText(getApplicationContext(), 0x7f070b9d, 1).show();
                return;
            }
        }
    }

    ()
    {
        this$0 = ShowWebViewActivity.this;
        super();
    }
}
