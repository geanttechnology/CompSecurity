// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.models.api;

import java.io.Serializable;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.models.api:
//            ErrorData, UplynkData

public class ResponseMessage
    implements Serializable
{

    private ErrorData errors;
    private UplynkData uplynkData;

    public ResponseMessage()
    {
    }

    public ErrorData getErrors()
    {
        return errors;
    }

    public UplynkData getUplynkData()
    {
        return uplynkData;
    }
}
