// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation.retrofit;

import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import retrofit.client.Client;

// Referenced classes of package com.newrelic.agent.android.instrumentation.retrofit:
//            RestAdapterBuilderExtension

public final class RetrofitInstrumentation
{

    private static final AgentLog log = AgentLogManager.getAgentLog();

    private RetrofitInstrumentation()
    {
    }

    public static retrofit.RestAdapter.Builder setClient(retrofit.RestAdapter.Builder builder, Client client)
    {
        return (new RestAdapterBuilderExtension(builder)).setClient(client);
    }

}
