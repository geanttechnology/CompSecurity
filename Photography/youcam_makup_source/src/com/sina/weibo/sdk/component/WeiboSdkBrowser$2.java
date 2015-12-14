// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.component;

import android.view.View;

// Referenced classes of package com.sina.weibo.sdk.component:
//            WeiboSdkBrowser, BrowserRequestParamBase

class this._cls0
    implements android.view.er
{

    final WeiboSdkBrowser this$0;

    public void onClick(View view)
    {
        if (WeiboSdkBrowser.access$10(WeiboSdkBrowser.this) != null)
        {
            WeiboSdkBrowser.access$10(WeiboSdkBrowser.this).execRequest(WeiboSdkBrowser.this, 3);
        }
        finish();
    }

    mBase()
    {
        this$0 = WeiboSdkBrowser.this;
        super();
    }
}
