// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.configuration;


// Referenced classes of package com.amazon.client.metrics.configuration:
//            MetricsConfiguration

public static final class mName extends Enum
{

    private static final PROD $VALUES[];
    public static final PROD DEVO;
    public static final PROD MASTER;
    public static final PROD PROD;
    private String mName;

    public static mName valueOf(String s)
    {
        return (mName)Enum.valueOf(com/amazon/client/metrics/configuration/MetricsConfiguration$Domain, s);
    }

    public static mName[] values()
    {
        return (mName[])$VALUES.clone();
    }

    public String getName()
    {
        return mName;
    }

    static 
    {
        DEVO = new <init>("DEVO", 0, "devo");
        MASTER = new <init>("MASTER", 1, "master");
        PROD = new <init>("PROD", 2, "prod");
        $VALUES = (new .VALUES[] {
            DEVO, MASTER, PROD
        });
    }

    private I(String s, int i, String s1)
    {
        super(s, i);
        mName = s1;
    }
}
