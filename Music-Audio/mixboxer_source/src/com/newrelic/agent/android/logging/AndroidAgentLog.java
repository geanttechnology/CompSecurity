// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.logging;

import android.util.Log;

// Referenced classes of package com.newrelic.agent.android.logging:
//            AgentLog

public class AndroidAgentLog
    implements AgentLog
{

    private static final String TAG = "com.newrelic.agent.android";

    public AndroidAgentLog()
    {
    }

    public void debug(String s)
    {
        Log.d("com.newrelic.agent.android", s);
    }

    public void error(String s)
    {
        Log.e("com.newrelic.agent.android", s);
    }

    public void error(String s, Throwable throwable)
    {
        Log.e("com.newrelic.agent.android", s, throwable);
    }

    public void info(String s)
    {
        Log.i("com.newrelic.agent.android", s);
    }

    public void verbose(String s)
    {
        Log.v("com.newrelic.agent.android", s);
    }

    public void warning(String s)
    {
        Log.w("com.newrelic.agent.android", s);
    }
}
