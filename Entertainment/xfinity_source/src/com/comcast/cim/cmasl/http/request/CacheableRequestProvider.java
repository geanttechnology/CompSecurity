// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.http.request;


// Referenced classes of package com.comcast.cim.cmasl.http.request:
//            RequestProvider

public interface CacheableRequestProvider
    extends RequestProvider
{

    public abstract String getCacheKey();
}
