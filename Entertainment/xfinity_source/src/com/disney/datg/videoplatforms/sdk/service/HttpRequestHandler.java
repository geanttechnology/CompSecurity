// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.service;

import org.springframework.http.ResponseEntity;

// Referenced classes of package com.disney.datg.videoplatforms.sdk.service:
//            Request

public interface HttpRequestHandler
{

    public abstract void onError(Request request, Exception exception);

    public abstract void onRequest(Request request);

    public abstract void onResponse(Request request, ResponseEntity responseentity);
}
