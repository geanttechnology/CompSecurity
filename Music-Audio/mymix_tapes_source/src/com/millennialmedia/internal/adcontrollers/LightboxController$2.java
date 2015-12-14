// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.adcontrollers;

import android.view.ViewGroup;
import com.millennialmedia.MMLog;
import com.millennialmedia.internal.utils.ViewUtils;
import com.millennialmedia.internal.video.LightboxView;

// Referenced classes of package com.millennialmedia.internal.adcontrollers:
//            LightboxController

class val.layoutParams
    implements Runnable
{

    final LightboxController this$0;
    final ViewGroup val$container;
    final android.view.s val$layoutParams;

    public void run()
    {
        ViewUtils.attachView(val$container, LightboxController.access$500(LightboxController.this), val$layoutParams);
        if (LightboxController.access$000(LightboxController.this).isPrepared() && LightboxController.access$000(LightboxController.this).getParent() == null)
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(LightboxController.access$200(), "attaching lightbox is attach.");
            }
            LightboxController.access$400(LightboxController.this);
        }
        LightboxController.access$600(LightboxController.this).attachSucceeded();
        LightboxController.access$700(LightboxController.this, LightboxController.access$100(LightboxController.this).inline.trackingEvents);
    }

    line()
    {
        this$0 = final_lightboxcontroller;
        val$container = viewgroup;
        val$layoutParams = android.view.s.this;
        super();
    }
}
