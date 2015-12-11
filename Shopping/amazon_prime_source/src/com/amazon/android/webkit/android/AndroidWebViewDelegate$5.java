// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import android.webkit.DownloadListener;
import com.amazon.android.webkit.AmazonDownloadDelegate;

// Referenced classes of package com.amazon.android.webkit.android:
//            AndroidWebViewDelegate

class val.delegate
    implements DownloadListener
{

    final AndroidWebViewDelegate this$0;
    final AmazonDownloadDelegate val$delegate;

    public void onDownloadStart(String s, String s1, String s2, String s3, long l)
    {
        val$delegate.requestHttpGetDownload(s, s1, s2, s3, "", "", l);
    }

    ()
    {
        this$0 = final_androidwebviewdelegate;
        val$delegate = AmazonDownloadDelegate.this;
        super();
    }
}
