// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.http.api;

import com.poshmark.http.PMHttpResponse;
import org.apache.http.Header;

// Referenced classes of package com.poshmark.http.api:
//            PMApiError, PMApiRequest

public class PMApiResponse extends PMHttpResponse
{

    public final PMApiError apiError;
    public final PMApiRequest apiRequest;
    public final Object data;
    public final Header headerArray[];

    public PMApiResponse(int i, Header aheader[], String s, Object obj, PMApiRequest pmapirequest, PMApiError pmapierror)
    {
        super(i, aheader, s, pmapirequest, pmapierror);
        data = obj;
        apiRequest = pmapirequest;
        apiError = pmapierror;
        headerArray = aheader;
    }
}
