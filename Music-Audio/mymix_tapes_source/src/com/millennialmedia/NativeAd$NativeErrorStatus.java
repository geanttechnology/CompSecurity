// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;

import com.millennialmedia.internal.ErrorStatus;
import java.util.Map;

// Referenced classes of package com.millennialmedia:
//            NativeAd

public static class  extends ErrorStatus
{

    public static final int EXPIRED = 301;

    static 
    {
        errorCodes.put(Integer.valueOf(301), "EXPIRED");
    }

    public (int i)
    {
        super(i);
    }

    public (int i, String s, Throwable throwable)
    {
        super(i, s, throwable);
    }
}
