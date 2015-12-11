// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import com.ebay.nautilus.kernel.net.IResponseDataHandler;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.StreamUtil;
import java.io.InputStream;

public class DataResponse extends Response
    implements IResponseDataHandler
{

    private byte data[];

    public DataResponse()
    {
        data = null;
    }

    public final byte[] getByteArray()
    {
        return data;
    }

    public IResponseDataHandler getDataHandler()
    {
        if (hasSuccessResponseCode())
        {
            return this;
        } else
        {
            return null;
        }
    }

    public final String getText()
    {
        if (data != null)
        {
            return new String(data);
        } else
        {
            return null;
        }
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        data = StreamUtil.streamToBytesForParse(inputstream);
    }
}
