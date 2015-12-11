// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import android.webkit.DownloadListener;
import com.amazon.android.webkit.AmazonDownloadListener;

// Referenced classes of package com.amazon.android.webkit.android:
//            AndroidWebViewDelegate

class val.listener
    implements DownloadListener
{

    final AndroidWebViewDelegate this$0;
    final AmazonDownloadListener val$listener;

    public void onDownloadStart(String s, String s1, String s2, String s3, long l)
    {
        val$listener.onDownloadStart(s, s1, s2, s3, l);
    }

    ()
    {
        this$0 = final_androidwebviewdelegate;
        val$listener = AmazonDownloadListener.this;
        super();
    }
}
