// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.app.AlertDialog;

// Referenced classes of package com.gotv.crackle:
//            FacebookHelperActivity

class val.builder
    implements Runnable
{

    final FacebookHelperActivity this$0;
    final android.app.ty val$builder;

    public void run()
    {
        FacebookHelperActivity.access$402(FacebookHelperActivity.this, val$builder.e());
        FacebookHelperActivity.access$400(FacebookHelperActivity.this).setCancelable(false);
        FacebookHelperActivity.access$400(FacebookHelperActivity.this).setCanceledOnTouchOutside(false);
        FacebookHelperActivity.access$400(FacebookHelperActivity.this).show();
    }

    ()
    {
        this$0 = final_facebookhelperactivity;
        val$builder = android.app.ty._cls7.val.builder.this;
        super();
    }
}
