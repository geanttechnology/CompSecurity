// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.sdk;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.AnnotatedConstantBindingBuilder;
import com.google.inject.binder.ConstantBindingBuilder;
import com.google.inject.binder.ScopedBindingBuilder;
import com.google.inject.name.Names;
import com.groupon.tracking.mobile.internal.LogFileSpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

// Referenced classes of package com.groupon.tracking.mobile.sdk:
//            LoggerClientListener

public class LoggingModule extends AbstractModule
{

    public static final String LOGGING_CLIENT_ID = "LOGGING_CLIENT_ID";
    public static final String LOGGING_CLIENT_VERSION_ID = "LOGGING_CLIENT_VERSION_ID";
    public static final String LOGGING_ENDPOINT = "LOGGING_ENDPOINT";
    public static final String LOGGING_SDK_VERSION_ID = "LOGGING_SDK_VERSION_ID";
    public static final int LOGGING_SDK_VERSION_NUMBER = 2;

    public LoggingModule()
    {
    }

    protected void configure()
    {
        bindConstant().annotatedWith(Names.named("LOGGING_SDK_VERSION_ID")).to(2);
        bind(com/groupon/tracking/mobile/internal/LogFileSpec).toInstance(new LogFileSpec("mobile-event", "log"));
        bind(com/groupon/tracking/mobile/internal/LogClient$ClientListener).to(com/groupon/tracking/mobile/sdk/LoggerClientListener).in(com/google/inject/Singleton);
    }

    public String provideLoggingUrl(String s, String s1)
    {
        try
        {
            s = String.format("https://logging.groupon.com/v2/mobile/logs?client_id=%s&client_version_id=%s", new Object[] {
                URLEncoder.encode(s, "utf-8"), URLEncoder.encode(s1, "utf-8")
            });
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        return s;
    }
}
