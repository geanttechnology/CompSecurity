// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.authentication;

import amazon.communication.authentication.SigningException;
import android.content.Context;
import com.amazon.dp.logger.DPLogger;
import org.apache.http.client.methods.HttpRequestBase;

// Referenced classes of package com.amazon.communication.authentication:
//            DcpRequestSigner

public class IgnoreBodyDcpRequestSigner extends DcpRequestSigner
{

    private static final DPLogger log = new DPLogger("TComm.IgnoreBodyDcpRequestSigner");

    public IgnoreBodyDcpRequestSigner(Context context)
    {
        super(context);
    }

    protected byte[] extractBody(HttpRequestBase httprequestbase)
        throws SigningException
    {
        return EMPTY_BODY;
    }

}
