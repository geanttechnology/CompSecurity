// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.common;


// Referenced classes of package com.amazon.identity.kcpsdk.common:
//            KindleWebserviceErrorType

public class KindleWebserviceError
{

    private final KindleWebserviceErrorType mErrorType;

    public KindleWebserviceError(KindleWebserviceErrorType kindlewebserviceerrortype)
    {
        mErrorType = kindlewebserviceerrortype;
    }

    public KindleWebserviceErrorType getErrorType()
    {
        return mErrorType;
    }
}
