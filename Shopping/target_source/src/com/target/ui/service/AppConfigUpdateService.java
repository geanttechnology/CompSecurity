// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.service;

import android.app.IntentService;
import android.content.Intent;
import com.target.ui.b.a;

public class AppConfigUpdateService extends IntentService
{

    public AppConfigUpdateService()
    {
        super("AppConfigUpdateService");
    }

    protected void onHandleIntent(Intent intent)
    {
        (new a(getApplicationContext(), com.target.mothership.a.a.a())).b();
    }
}
