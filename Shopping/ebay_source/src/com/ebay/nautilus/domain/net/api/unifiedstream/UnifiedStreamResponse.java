// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.unifiedstream;

import com.ebay.nautilus.domain.data.UnifiedStream.Contents;
import com.ebay.nautilus.domain.net.EbayCosResponse;
import java.io.InputStream;

public class UnifiedStreamResponse extends EbayCosResponse
{

    public Contents streamContents;

    protected UnifiedStreamResponse()
    {
        super(true);
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        streamContents = (Contents)readJsonStream(inputstream, com/ebay/nautilus/domain/data/UnifiedStream/Contents);
    }
}
