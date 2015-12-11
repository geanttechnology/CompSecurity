// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.igexin.sdk;

import android.content.DialogInterface;
import com.igexin.sdk.action.PushMessageAction;
import com.igexin.sdk.bean.ButtonBean;

// Referenced classes of package com.igexin.sdk:
//            SdkActivity

class n
    implements android.content.e.OnClickListener
{

    final SdkActivity this$0;
    final ButtonBean val$button;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        PushMessageAction.getInstance().executePushMessageAction(SdkActivity.access$000(SdkActivity.this), val$button.getDoActionId());
        SdkActivity.access$102(SdkActivity.this, false);
        finish();
    }

    n()
    {
        this$0 = final_sdkactivity;
        val$button = ButtonBean.this;
        super();
    }
}
