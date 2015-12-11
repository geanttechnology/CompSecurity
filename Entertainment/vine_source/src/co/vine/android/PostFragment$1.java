// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.app.Activity;
import android.content.Intent;

// Referenced classes of package co.vine.android:
//            PostFragment, SonyLaunchActivity

class val.activity
    implements Runnable
{

    final PostFragment this$0;
    final Activity val$activity;

    public void run()
    {
        val$activity.startActivity(new Intent(val$activity, co/vine/android/SonyLaunchActivity));
        val$activity.setResult(32);
        val$activity.finish();
    }

    ity()
    {
        this$0 = final_postfragment;
        val$activity = Activity.this;
        super();
    }
}
