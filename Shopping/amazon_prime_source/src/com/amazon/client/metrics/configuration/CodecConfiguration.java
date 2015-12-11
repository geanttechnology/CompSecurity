// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.configuration;


// Referenced classes of package com.amazon.client.metrics.configuration:
//            MetricsConfigurationException, CodecType

public class CodecConfiguration
{

    final CodecType mCodecType;
    final String mCodecVersion;

    public CodecConfiguration(CodecType codectype, String s)
        throws MetricsConfigurationException
    {
        if (codectype == null)
        {
            throw new MetricsConfigurationException("CodecType is null in configuration");
        }
        if (s == null || s.equals(""))
        {
            throw new MetricsConfigurationException("Codec version is null in configuration");
        } else
        {
            mCodecType = codectype;
            mCodecVersion = s;
            return;
        }
    }

    public CodecType getCodecType()
    {
        return mCodecType;
    }

    public String getCodecVersion()
    {
        return mCodecVersion;
    }
}
