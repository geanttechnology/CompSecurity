// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation.retrofit;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.util.concurrent.Executor;
import retrofit.Endpoint;
import retrofit.ErrorHandler;
import retrofit.Profiler;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.Client;
import retrofit.converter.Converter;

// Referenced classes of package com.newrelic.agent.android.instrumentation.retrofit:
//            ClientExtension

public class RestAdapterBuilderExtension extends retrofit.RestAdapter.Builder
{

    private static final AgentLog log = AgentLogManager.getAgentLog();
    private retrofit.RestAdapter.Builder impl;

    public RestAdapterBuilderExtension(retrofit.RestAdapter.Builder builder)
    {
        impl = builder;
    }

    public RestAdapter build()
    {
        return impl.build();
    }

    public retrofit.RestAdapter.Builder setClient(retrofit.client.Client.Provider provider)
    {
        return impl.setClient(provider);
    }

    public retrofit.RestAdapter.Builder setClient(Client client)
    {
        log.debug((new StringBuilder()).append("RestAdapterBuilderExtension.setClient() wrapping client ").append(client).append(" with new ClientExtension.").toString());
        return impl.setClient(new ClientExtension(client));
    }

    public retrofit.RestAdapter.Builder setConverter(Converter converter)
    {
        return impl.setConverter(converter);
    }

    public retrofit.RestAdapter.Builder setEndpoint(String s)
    {
        return impl.setEndpoint(s);
    }

    public retrofit.RestAdapter.Builder setEndpoint(Endpoint endpoint)
    {
        return impl.setEndpoint(endpoint);
    }

    public retrofit.RestAdapter.Builder setErrorHandler(ErrorHandler errorhandler)
    {
        return impl.setErrorHandler(errorhandler);
    }

    public retrofit.RestAdapter.Builder setExecutors(Executor executor, Executor executor1)
    {
        return impl.setExecutors(executor, executor1);
    }

    public retrofit.RestAdapter.Builder setLog(retrofit.RestAdapter.Log log1)
    {
        return impl.setLog(log1);
    }

    public retrofit.RestAdapter.Builder setLogLevel(retrofit.RestAdapter.LogLevel loglevel)
    {
        return impl.setLogLevel(loglevel);
    }

    public retrofit.RestAdapter.Builder setProfiler(Profiler profiler)
    {
        return impl.setProfiler(profiler);
    }

    public retrofit.RestAdapter.Builder setRequestInterceptor(RequestInterceptor requestinterceptor)
    {
        return impl.setRequestInterceptor(requestinterceptor);
    }

}
