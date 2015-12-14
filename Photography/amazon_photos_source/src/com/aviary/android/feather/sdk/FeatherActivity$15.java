// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk;

import android.app.Dialog;
import android.view.View;

// Referenced classes of package com.aviary.android.feather.sdk:
//            FeatherActivity

class val.dialog
    implements android.view.r
{

    final FeatherActivity this$0;
    final android.view.r val$button1Listener;
    final Dialog val$dialog;

    public void onClick(View view)
    {
        if (val$button1Listener != null)
        {
            val$button1Listener.onClick(view);
        }
        val$dialog.dismiss();
    }

    ()
    {
        this$0 = final_featheractivity;
        val$button1Listener = r;
        val$dialog = Dialog.this;
        super();
    }
}
