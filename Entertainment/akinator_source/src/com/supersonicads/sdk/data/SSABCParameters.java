// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.data;


// Referenced classes of package com.supersonicads.sdk.data:
//            SSAObj

public class SSABCParameters extends SSAObj
{

    private String CONNECTION_RETRIES;
    private String mConnectionRetries;

    public SSABCParameters()
    {
        CONNECTION_RETRIES = "connectionRetries";
    }

    public SSABCParameters(String s)
    {
        super(s);
        CONNECTION_RETRIES = "connectionRetries";
        if (containsKey(CONNECTION_RETRIES))
        {
            setConnectionRetries(getString(CONNECTION_RETRIES));
        }
    }

    public String getConnectionRetries()
    {
        return mConnectionRetries;
    }

    public void setConnectionRetries(String s)
    {
        mConnectionRetries = s;
    }
}
