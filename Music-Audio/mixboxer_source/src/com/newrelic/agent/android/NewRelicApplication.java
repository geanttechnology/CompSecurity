// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android;

import android.app.Application;
import com.newrelic.agent.android.instrumentation.Bootstrap;

public class NewRelicApplication extends Application
{

    public NewRelicApplication()
    {
    }

    public void onCreate()
    {
        Bootstrap.go(this);
    }
}
