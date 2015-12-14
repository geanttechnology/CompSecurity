// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.configuration;


// Referenced classes of package com.amazon.clouddrive.configuration:
//            Endpoints

public interface EndpointsCache
{

    public abstract boolean cacheHasExpired();

    public abstract Endpoints getEndpoints();

    public abstract void setEndpoints(Endpoints endpoints);
}
