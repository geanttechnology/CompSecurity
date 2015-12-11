// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.cbl;

import android.text.TextUtils;

// Referenced classes of package com.amazon.identity.auth.device.cbl:
//            PandaEndpointUtils

public static class mErrorMessage
{

    public final String mErrorCode;
    public final String mErrorMessage;

    (String s, String s1)
    {
        if (TextUtils.isEmpty(s))
        {
            s = "Unrecognized";
        }
        mErrorCode = s;
        if (TextUtils.isEmpty(s1))
        {
            s1 = "Unrecognized";
        }
        mErrorMessage = s1;
    }
}
