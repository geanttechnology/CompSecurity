// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import amazon.communication.Message;
import java.io.IOException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

// Referenced classes of package com.amazon.communication:
//            ProtocolException

public interface HttpRequestResponseConverter
{

    public abstract HttpRequestBase convertMessageToRequest(Message message)
        throws ProtocolException;

    public abstract HttpResponse convertMessageToResponse(Message message)
        throws ProtocolException;

    public abstract Message convertRequestToMessage(HttpRequest httprequest)
        throws IOException;

    public abstract Message convertResponseToMessage(HttpResponse httpresponse)
        throws ProtocolException;
}
