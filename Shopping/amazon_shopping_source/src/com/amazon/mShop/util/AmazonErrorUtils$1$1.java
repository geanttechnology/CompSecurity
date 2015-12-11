// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import android.view.View;
import android.webkit.WebView;
import com.amazon.mShop.AmazonActivity;

// Referenced classes of package com.amazon.mShop.util:
//            AmazonErrorUtils

class this._cls0
    implements com.amazon.mShop.error.ErrorBoxActionListener
{

    final l.view this$0;

    public void onActionButtonClick(int i)
    {
        view.clearView();
        view.reload();
        view.setVisibility(0);
    }

    l.reportOnView()
    {
        this$0 = this._cls0.this;
        super();
    }

    // Unreferenced inner class com/amazon/mShop/util/AmazonErrorUtils$1

/* anonymous class */
    static final class AmazonErrorUtils._cls1
        implements Runnable
    {

        final AmazonActivity val$amazonActivity;
        final int val$errorCode;
        final View val$reportOnView;
        final WebView val$view;

        public void run()
        {
            AmazonErrorUtils.reportError(amazonActivity, errorCode, new AmazonErrorUtils._cls1._cls1(), reportOnView);
        }

            
            {
                amazonActivity = amazonactivity;
                errorCode = i;
                view = webview;
                reportOnView = view1;
                super();
            }
    }

}
