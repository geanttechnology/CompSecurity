// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.adcontrollers;

import com.millennialmedia.MMLog;
import com.millennialmedia.internal.AdContainer;
import com.millennialmedia.internal.utils.ViewUtils;
import com.millennialmedia.internal.video.VASTVideoView;

// Referenced classes of package com.millennialmedia.internal.adcontrollers:
//            VASTVideoController

class val.adContainer
    implements Runnable
{

    final VASTVideoController this$0;
    final AdContainer val$adContainer;

    public void run()
    {
        if (VASTVideoController.access$500(VASTVideoController.this) == null)
        {
            MMLog.e(VASTVideoController.access$200(), "VASTVideoView instance is null, unable to attach");
            VASTVideoController.access$600(VASTVideoController.this).attachFailed();
            return;
        } else
        {
            android.view.  = new android.view.(-1, -1);
            VASTVideoController.access$500(VASTVideoController.this).setLayoutParams();
            ViewUtils.attachView(val$adContainer, VASTVideoController.access$500(VASTVideoController.this));
            VASTVideoController.access$500(VASTVideoController.this).updateLayout();
            VASTVideoController.access$600(VASTVideoController.this).attachSucceeded();
            return;
        }
    }

    STVideoControllerListener()
    {
        this$0 = final_vastvideocontroller;
        val$adContainer = AdContainer.this;
        super();
    }
}
