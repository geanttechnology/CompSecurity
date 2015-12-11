// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.service;

import android.app.IntentService;
import android.content.Intent;
import com.target.ui.googlenow.GoogleNowIntentHandler;

public class GoogleNowService extends IntentService
{

    public GoogleNowService()
    {
        super("GoogleNowAuthService");
    }

    protected void onHandleIntent(Intent intent)
    {
        (new GoogleNowIntentHandler(this)).a(intent);
    }
}
