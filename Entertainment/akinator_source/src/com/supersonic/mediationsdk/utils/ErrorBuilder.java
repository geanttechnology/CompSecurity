// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk.utils;

import com.supersonic.mediationsdk.logger.SupersonicError;

// Referenced classes of package com.supersonic.mediationsdk.utils:
//            SupersonicUtils

public class ErrorBuilder
{

    public ErrorBuilder()
    {
    }

    public static SupersonicError buildAdapterInitFailedError(String s)
    {
        if (SupersonicUtils.isEmpty(s))
        {
            return getGenericErrorForMissingParams();
        } else
        {
            return new SupersonicError(508, (new StringBuilder()).append("Init failed - ").append(s).toString());
        }
    }

    public static SupersonicError buildAppKeyIncorrectError()
    {
        return new SupersonicError(504, "Mediation - App key incorrect");
    }

    public static SupersonicError buildAppKeyNotSetError()
    {
        return new SupersonicError(503, "Mediation - App key wasn't set");
    }

    public static SupersonicError buildGenericError(String s)
    {
        String s1 = s;
        if (SupersonicUtils.isEmpty(s))
        {
            s1 = "An error occurred";
        }
        return new SupersonicError(510, s1);
    }

    public static SupersonicError buildInvalidKeyValueError(String s, String s1, String s2)
    {
        if (SupersonicUtils.isEmpty(s) || SupersonicUtils.isEmpty(s1))
        {
            return getGenericErrorForMissingParams();
        }
        s1 = (new StringBuilder()).append("Mediation - ").append(s).append(" value is not valid for ").append(s1);
        if (!SupersonicUtils.isEmpty(s2))
        {
            s = (new StringBuilder()).append(" - ").append(s2).toString();
        } else
        {
            s = "";
        }
        return new SupersonicError(506, s1.append(s).toString());
    }

    public static SupersonicError buildKeyNotSetForProviderError(String s, String s1)
    {
        if (SupersonicUtils.isEmpty(s) || SupersonicUtils.isEmpty(s1))
        {
            return getGenericErrorForMissingParams();
        } else
        {
            return new SupersonicError(505, (new StringBuilder()).append("Mediation - ").append(s).append(" is not set for ").append(s1).toString());
        }
    }

    public static SupersonicError buildNoConfigurationAvailableError()
    {
        return new SupersonicError(501, "Mediation - Unable to retrieve configurations from Supersonic server");
    }

    public static SupersonicError buildShowVideoFailedError(String s)
    {
        if (SupersonicUtils.isEmpty(s))
        {
            return getGenericErrorForMissingParams();
        } else
        {
            return new SupersonicError(509, (new StringBuilder()).append("Show video failed - ").append(s).toString());
        }
    }

    public static SupersonicError buildUnsupportedSdkVersion(String s, String s1)
    {
        if (SupersonicUtils.isEmpty(s1))
        {
            return getGenericErrorForMissingParams();
        }
        String s2 = s;
        if (s == null)
        {
            s2 = "";
        }
        return new SupersonicError(507, (new StringBuilder()).append("Mediation - Unsupported SDK version ").append(s2).append(" for ").append(s1).toString());
    }

    public static SupersonicError buildUsingCachedConfigurationError(String s, String s1)
    {
        return new SupersonicError(502, (new StringBuilder()).append("Mediation - Unable to retrieve configurations from Supersonic server, using cached configurations with appKey:").append(s).append(" and userId:").append(s1).toString());
    }

    private static SupersonicError getGenericErrorForMissingParams()
    {
        return buildGenericError("Mediation - wrong configuration");
    }
}
