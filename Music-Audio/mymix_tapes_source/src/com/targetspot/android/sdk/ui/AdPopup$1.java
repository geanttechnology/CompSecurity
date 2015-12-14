// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.targetspot.android.sdk.service.AdLink;
import com.targetspot.android.sdk.service.AdManager;
import com.targetspot.android.sdk.service.AdSegment;
import com.targetspot.android.sdk.service.LoggingManager;

// Referenced classes of package com.targetspot.android.sdk.ui:
//            AdPopup

class this._cls0
    implements android.view.ckListener
{

    final AdPopup this$0;

    public void onClick(View view)
    {
        AdPopup.access$002(AdPopup.this, 4);
        dismissPopup();
        view = AdPopup.access$100(AdPopup.this).segment.getClickThrough();
        if (view != null)
        {
            view = view.getLinkUrl();
            AdPopup.access$200(AdPopup.this).startActivity(new Intent("android.intent.action.VIEW", Uri.parse(view)));
            AdManager.getInstance().getLogger().logImpression(AdPopup.access$100(AdPopup.this).segment.getClickThrough());
        }
    }

    ngManager()
    {
        this$0 = AdPopup.this;
        super();
    }
}
