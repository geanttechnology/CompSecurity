// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal;

import com.facebook.ads.AdError;
import com.facebook.ads.internal.util.r;

// Referenced classes of package com.facebook.ads.internal:
//            AdErrorType

public class b
{

    private final AdErrorType a;
    private final String b;

    public b(AdErrorType aderrortype, String s)
    {
        String s1 = s;
        if (r.a(s))
        {
            s1 = aderrortype.getDefaultErrorMessage();
        }
        a = aderrortype;
        b = s1;
    }

    public AdErrorType a()
    {
        return a;
    }

    public AdError b()
    {
        if (a.a())
        {
            return new AdError(a.getErrorCode(), b);
        } else
        {
            return new AdError(AdErrorType.UNKNOWN_ERROR.getErrorCode(), AdErrorType.UNKNOWN_ERROR.getDefaultErrorMessage());
        }
    }
}
