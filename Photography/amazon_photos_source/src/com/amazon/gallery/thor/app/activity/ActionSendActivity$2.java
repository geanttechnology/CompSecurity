// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;

import android.widget.Toast;

// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            ActionSendActivity

class val.resId
    implements Runnable
{

    final ActionSendActivity this$0;
    final int val$resId;

    public void run()
    {
        Toast.makeText(ActionSendActivity.this, val$resId, 0).show();
    }

    ()
    {
        this$0 = final_actionsendactivity;
        val$resId = I.this;
        super();
    }
}
