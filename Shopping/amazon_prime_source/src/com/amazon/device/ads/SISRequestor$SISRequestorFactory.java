// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            SISRequestor, SISRequestorCallback, SISRequest

static class 
{

    public transient SISRequestor createSISRequestor(SISRequestorCallback sisrequestorcallback, SISRequest asisrequest[])
    {
        return new SISRequestor(sisrequestorcallback, asisrequest);
    }

    public transient SISRequestor createSISRequestor(SISRequest asisrequest[])
    {
        return createSISRequestor(null, asisrequest);
    }

    ()
    {
    }
}
