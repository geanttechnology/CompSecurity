// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.experimentation;

import com.ebay.nautilus.domain.net.EbayCosResponse;
import java.io.InputStream;

// Referenced classes of package com.ebay.nautilus.domain.net.api.experimentation:
//            Qualification

public class GetTreatmentsResponse extends EbayCosResponse
{

    public Qualification qualification;

    public GetTreatmentsResponse()
    {
        super(true);
        qualification = new Qualification();
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        qualification = (Qualification)readJsonStream(inputstream, com/ebay/nautilus/domain/net/api/experimentation/Qualification);
    }
}
