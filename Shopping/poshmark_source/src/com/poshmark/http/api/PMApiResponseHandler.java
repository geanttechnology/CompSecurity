// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.http.api;

import com.poshmark.http.PMBaseHttpResponseHandler;

// Referenced classes of package com.poshmark.http.api:
//            PMApiResponse

public interface PMApiResponseHandler
    extends PMBaseHttpResponseHandler
{

    public abstract void handleResponse(PMApiResponse pmapiresponse);
}
