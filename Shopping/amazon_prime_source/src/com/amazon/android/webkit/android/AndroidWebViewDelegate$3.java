// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import android.webkit.WebBackForwardListClient;
import android.webkit.WebHistoryItem;
import com.amazon.android.webkit.AmazonWebBackForwardListClient;
import com.amazon.android.webkit.AmazonWebHistoryItem;

// Referenced classes of package com.amazon.android.webkit.android:
//            AndroidWebViewDelegate

class val.client extends WebBackForwardListClient
{

    final AndroidWebViewDelegate this$0;
    final AmazonWebBackForwardListClient val$client;

    public void onIndexChanged(WebHistoryItem webhistoryitem, int i)
    {
        val$client.onIndexChanged(new AmazonWebHistoryItem(webhistoryitem.getFavicon(), 0, webhistoryitem.getOriginalUrl(), webhistoryitem.getTitle(), webhistoryitem.getUrl(), AndroidWebViewDelegate.access$400(AndroidWebViewDelegate.this, webhistoryitem)), i);
    }

    public void onNewHistoryItem(WebHistoryItem webhistoryitem)
    {
        val$client.onNewHistoryItem(new AmazonWebHistoryItem(webhistoryitem.getFavicon(), 0, webhistoryitem.getOriginalUrl(), webhistoryitem.getTitle(), webhistoryitem.getUrl(), AndroidWebViewDelegate.access$400(AndroidWebViewDelegate.this, webhistoryitem)));
    }

    ()
    {
        this$0 = final_androidwebviewdelegate;
        val$client = AmazonWebBackForwardListClient.this;
        super();
    }
}
