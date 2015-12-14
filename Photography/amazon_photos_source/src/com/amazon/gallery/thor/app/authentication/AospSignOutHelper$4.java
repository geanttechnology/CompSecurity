// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.authentication;

import android.app.Activity;
import android.content.Intent;
import com.amazon.gallery.thor.app.activity.SignInActivity;
import com.amazon.gallery.thor.widget.AppCompatProgressDialog;

// Referenced classes of package com.amazon.gallery.thor.app.authentication:
//            AospSignOutHelper

class val.activity
    implements Runnable
{

    final AospSignOutHelper this$0;
    final Activity val$activity;

    public void run()
    {
        AospSignOutHelper.access$300(AospSignOutHelper.this).dismiss();
        Intent intent = new Intent(val$activity, com/amazon/gallery/thor/app/activity/SignInActivity);
        val$activity.startActivity(intent);
        val$activity.finish();
    }

    ()
    {
        this$0 = final_aospsignouthelper;
        val$activity = Activity.this;
        super();
    }
}
