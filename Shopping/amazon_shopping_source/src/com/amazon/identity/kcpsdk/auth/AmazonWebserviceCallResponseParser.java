// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import com.amazon.identity.kcpsdk.common.WebResponseHeaders;
import java.io.IOException;
import java.net.HttpURLConnection;

// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            ParseErrorException

public interface AmazonWebserviceCallResponseParser
{

    public abstract String getErrorCode(HttpURLConnection httpurlconnection);

    public abstract Object parse(WebResponseHeaders webresponseheaders, byte abyte0[])
        throws ParseErrorException, IOException;
}
