// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.groupon.db.models.mygroupons.MyGrouponItem;
import com.groupon.loader.MyGrouponItemLoaderCallbacks;
import com.groupon.util.ViewUtils;
import com.groupon.util.WebViewHelper;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            RedeemWebview

class this._cls1 extends WebViewClient
{

    final this._cls1 this$1;

    public boolean shouldOverrideUrlLoading(WebView webview, String s)
    {
        return false;
    }

    allbacks()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/groupon/activity/RedeemWebview$2

/* anonymous class */
    class RedeemWebview._cls2 extends MyGrouponItemLoaderCallbacks
    {

        final RedeemWebview this$0;

        public void onDealLoaded(MyGrouponItem mygrouponitem)
        {
            RedeemWebview.access$002(RedeemWebview.this, mygrouponitem);
            if (RedeemWebview.access$000(RedeemWebview.this) == null)
            {
                finish();
                return;
            } else
            {
                mygrouponitem = webview.getSettings();
                mygrouponitem.setJavaScriptEnabled(true);
                mygrouponitem.setUseWideViewPort(true);
                mygrouponitem.setLoadWithOverviewMode(true);
                mygrouponitem.setBuiltInZoomControls(true);
                mygrouponitem.setSupportZoom(true);
                WebViewHelper.addInAppUserAgent(webview);
                webview.setWebViewClient(new RedeemWebview._cls2._cls1());
                webview.setWebChromeClient(new RedeemWebview._cls2._cls2());
                ViewUtils.initWebView(webview);
                grouponId = Strings.toString(RedeemWebview.access$000(RedeemWebview.this).remoteId);
                refresh();
                RedeemWebview.access$100(RedeemWebview.this);
                return;
            }
        }

            
            {
                this$0 = RedeemWebview.this;
                super(context, s);
            }

        // Unreferenced inner class com/groupon/activity/RedeemWebview$2$2

/* anonymous class */
        class RedeemWebview._cls2._cls2 extends WebChromeClient
        {

            final RedeemWebview._cls2 this$1;

            public void onProgressChanged(WebView webview, int i)
            {
                setProgress(i * 100);
            }

                    
                    {
                        this$1 = RedeemWebview._cls2.this;
                        super();
                    }
        }

    }

}
