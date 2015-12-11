// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common;

import com.ebay.nautilus.kernel.net.IResponseDataHandler;
import com.ebay.nautilus.kernel.net.Response;
import com.ebay.nautilus.kernel.util.StreamUtil;
import java.io.InputStream;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class SsoResponse extends Response
    implements IResponseDataHandler
{

    public SsoResponse()
    {
    }

    public IResponseDataHandler getDataHandler()
    {
        return this;
    }

    public final void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        try
        {
            parse(StreamUtil.jsonObjectFromStream(inputstream));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException.create(inputstream);
        }
    }

    protected abstract void parse(JSONObject jsonobject)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException;
}
