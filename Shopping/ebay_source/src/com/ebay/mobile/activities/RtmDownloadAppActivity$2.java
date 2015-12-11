// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;

// Referenced classes of package com.ebay.mobile.activities:
//            RtmDownloadAppActivity

class this._cls0
    implements android.view.AppActivity._cls2
{

    final RtmDownloadAppActivity this$0;

    public void onClick(View view)
    {
        if (!TextUtils.isEmpty(RtmDownloadAppActivity.access$100(RtmDownloadAppActivity.this))) goto _L2; else goto _L1
_L1:
        finish();
        return;
_L2:
        if (RtmDownloadAppActivity.access$100(RtmDownloadAppActivity.this).startsWith("http://market.android.com"))
        {
            int i = "http://market.android.com".length();
            if (RtmDownloadAppActivity.access$100(RtmDownloadAppActivity.this).length() > i)
            {
                view = Uri.parse((new StringBuilder()).append("market://").append(RtmDownloadAppActivity.access$100(RtmDownloadAppActivity.this).substring(i + 1)).toString());
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(view);
                startActivity(intent);
            }
        } else
        if (RtmDownloadAppActivity.access$100(RtmDownloadAppActivity.this).startsWith("market://"))
        {
            view = Uri.parse(RtmDownloadAppActivity.access$100(RtmDownloadAppActivity.this));
            Intent intent1 = new Intent("android.intent.action.VIEW");
            intent1.setData(view);
            startActivity(intent1);
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    _cls9()
    {
        this$0 = RtmDownloadAppActivity.this;
        super();
    }
}
