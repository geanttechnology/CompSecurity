// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.app.Activity;
import android.content.Intent;

class val.activity
    implements val.activity
{

    final val.activity this$0;
    final Activity val$activity;

    public Activity getActivityContext()
    {
        return val$activity;
    }

    public void startActivityForResult(Intent intent, int i)
    {
        val$activity.startActivityForResult(intent, i);
    }

    ()
    {
        this$0 = final_;
        val$activity = Activity.this;
        super();
    }
}
