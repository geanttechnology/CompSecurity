// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.configuration;


// Referenced classes of package com.amazon.client.metrics.configuration:
//            MetricsConfigurationException

public final class HttpRequestSignerType extends Enum
{

    private static final HttpRequestSignerType $VALUES[];
    public static final HttpRequestSignerType DCP;
    public static final HttpRequestSignerType DCP_OAUTH;
    public static final HttpRequestSignerType OAUTH;
    private final String mName;

    private HttpRequestSignerType(String s, int i, String s1)
    {
        super(s, i);
        mName = s1;
    }

    public static HttpRequestSignerType fromString(String s)
        throws MetricsConfigurationException
    {
        HttpRequestSignerType ahttprequestsignertype[] = values();
        int j = ahttprequestsignertype.length;
        for (int i = 0; i < j; i++)
        {
            HttpRequestSignerType httprequestsignertype = ahttprequestsignertype[i];
            if (httprequestsignertype.getName().equalsIgnoreCase(s))
            {
                return httprequestsignertype;
            }
        }

        throw new MetricsConfigurationException((new StringBuilder()).append(s).append(" is not a valid RequestSignerType").toString());
    }

    public static HttpRequestSignerType valueOf(String s)
    {
        return (HttpRequestSignerType)Enum.valueOf(com/amazon/client/metrics/configuration/HttpRequestSignerType, s);
    }

    public static HttpRequestSignerType[] values()
    {
        return (HttpRequestSignerType[])$VALUES.clone();
    }

    public String getName()
    {
        return mName;
    }

    static 
    {
        DCP = new HttpRequestSignerType("DCP", 0, "Dcp");
        DCP_OAUTH = new HttpRequestSignerType("DCP_OAUTH", 1, "DcpOAuth");
        OAUTH = new HttpRequestSignerType("OAUTH", 2, "OAuth");
        $VALUES = (new HttpRequestSignerType[] {
            DCP, DCP_OAUTH, OAUTH
        });
    }
}
