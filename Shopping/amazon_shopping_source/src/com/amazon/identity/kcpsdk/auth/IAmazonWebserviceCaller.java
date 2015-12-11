// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import com.amazon.identity.kcpsdk.common.IWebResponseParser;
import com.amazon.identity.kcpsdk.common.WebRequest;
import com.amazon.identity.kcpsdk.common.WebResponseParser;
import java.io.IOException;

// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            ParseErrorException, AmazonWebserviceCallResponseParser, IAmazonWebserviceCallListener, IAmazonWebServiceCallback, 
//            IAmazonWebserviceCall

public interface IAmazonWebserviceCaller
{

    public abstract Object call(WebRequest webrequest, AmazonWebserviceCallResponseParser amazonwebservicecallresponseparser, IAmazonWebserviceCallListener iamazonwebservicecalllistener)
        throws IOException, ParseErrorException;

    public abstract IAmazonWebserviceCall createCall(WebRequest webrequest, IAmazonWebServiceCallback iamazonwebservicecallback);

    public abstract IAmazonWebserviceCall createCall(WebRequest webrequest, IWebResponseParser iwebresponseparser, IAmazonWebserviceCallListener iamazonwebservicecalllistener);

    public abstract IAmazonWebserviceCall createCall(WebRequest webrequest, WebResponseParser webresponseparser, IAmazonWebserviceCallListener iamazonwebservicecalllistener);
}
