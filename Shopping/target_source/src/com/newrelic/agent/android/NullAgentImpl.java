// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android;

import com.newrelic.agent.android.api.common.TransactionData;
import com.newrelic.agent.android.harvest.ApplicationInformation;
import com.newrelic.agent.android.harvest.DeviceInformation;
import com.newrelic.agent.android.harvest.EnvironmentInformation;
import com.newrelic.agent.android.util.Encoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.newrelic.agent.android:
//            AgentImpl, AgentConfiguration

public class NullAgentImpl
    implements AgentImpl
{

    public static final NullAgentImpl instance = new NullAgentImpl();
    private final AgentConfiguration agentConfiguration = new AgentConfiguration();
    private final ReentrantLock lock = new ReentrantLock();
    private int responseBodyLimit;
    private long sessionStartTimeMillis;

    public NullAgentImpl()
    {
        sessionStartTimeMillis = 0L;
    }

    public void addTransactionData(TransactionData transactiondata)
    {
    }

    public void disable()
    {
    }

    public List getAndClearTransactionData()
    {
        return new ArrayList();
    }

    public ApplicationInformation getApplicationInformation()
    {
        return new ApplicationInformation("null", "0.0", "null", "0");
    }

    public String getCrossProcessId()
    {
        return null;
    }

    public DeviceInformation getDeviceInformation()
    {
        DeviceInformation deviceinformation = new DeviceInformation();
        deviceinformation.setOsName("Android");
        deviceinformation.setOsVersion("2.3");
        deviceinformation.setOsBuild("a.b.c");
        deviceinformation.setManufacturer("Fake");
        deviceinformation.setModel("NullAgent");
        deviceinformation.setAgentName("AndroidAgent");
        deviceinformation.setAgentVersion("2.123");
        deviceinformation.setDeviceId("389C9738-A761-44DE-8A66-1668CFD67DA1");
        deviceinformation.setArchitecture("Fake Arch");
        deviceinformation.setRunTime("1.7.0");
        deviceinformation.setSize("Fake Size");
        return deviceinformation;
    }

    public Encoder getEncoder()
    {
        return new Encoder() {

            final NullAgentImpl this$0;

            public String encode(byte abyte0[])
            {
                return new String(abyte0);
            }

            
            {
                this$0 = NullAgentImpl.this;
                super();
            }
        };
    }

    public EnvironmentInformation getEnvironmentInformation()
    {
        return new EnvironmentInformation(0L, 1, "none", "none", new long[] {
            0L, 0L
        });
    }

    public String getNetworkCarrier()
    {
        return "unknown";
    }

    public String getNetworkWanType()
    {
        return "unknown";
    }

    public int getResponseBodyLimit()
    {
        return responseBodyLimit;
    }

    public long getSessionDurationMillis()
    {
        return sessionStartTimeMillis;
    }

    public int getStackTraceLimit()
    {
        return 0;
    }

    public boolean isDisabled()
    {
        return true;
    }

    public void mergeTransactionData(List list)
    {
    }

    public void setLocation(String s, String s1)
    {
    }

    public void setResponseBodyLimit(int i)
    {
        responseBodyLimit = i;
    }

    public void start()
    {
    }

    public void stop()
    {
    }

    public boolean updateSavedConnectInformation()
    {
        return false;
    }

}
