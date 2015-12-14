// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.appboy.ui.AppboyFeedbackFragment;
import com.appboy.ui.b;

public class SendFeedbackActivity extends FragmentActivity
{

    public SendFeedbackActivity()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0301c4);
        ((AppboyFeedbackFragment)getSupportFragmentManager().findFragmentById(0x7f100849)).a = new b(this);
    }
}
