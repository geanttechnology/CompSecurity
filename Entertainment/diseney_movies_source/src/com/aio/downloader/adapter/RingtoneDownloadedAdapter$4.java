// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.adapter;

import android.app.Activity;
import android.view.Window;

// Referenced classes of package com.aio.downloader.adapter:
//            RingtoneDownloadedAdapter

class this._cls0
    implements android.widget.r
{

    final RingtoneDownloadedAdapter this$0;

    public void onDismiss()
    {
        android.view.adedAdapter._cls4 _lcls4 = ((Activity)ctx).getWindow().getAttributes();
        _lcls4.lpha = 1.0F;
        ((Activity)ctx).getWindow().setAttributes(_lcls4);
    }

    ()
    {
        this$0 = RingtoneDownloadedAdapter.this;
        super();
    }
}
