// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewDescriptionActivity, ItemViewCommonProgressAndError

class this._cls0 extends WebChromeClient
{

    final ItemViewDescriptionActivity this$0;

    public void onProgressChanged(WebView webview, int i)
    {
        if (99 < i)
        {
            ItemViewCommonProgressAndError.showLayouts(ItemViewDescriptionActivity.this, .LayoutState.NORMAL);
        }
    }

    ()
    {
        this$0 = ItemViewDescriptionActivity.this;
        super();
    }
}
