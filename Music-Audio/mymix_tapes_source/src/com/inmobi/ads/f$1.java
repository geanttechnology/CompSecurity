// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;


// Referenced classes of package com.inmobi.ads:
//            f

static class ldError
{

    static final int a[];

    static 
    {
        a = new int[com.inmobi.commons.core.network.orkError.ErrorCode.values().length];
        try
        {
            a[com.inmobi.commons.core.network.orkError.ErrorCode.NETWORK_UNAVAILABLE_ERROR.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            a[com.inmobi.commons.core.network.orkError.ErrorCode.HTTP_BAD_REQUEST.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            a[com.inmobi.commons.core.network.orkError.ErrorCode.HTTP_GATEWAY_TIMEOUT.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            a[com.inmobi.commons.core.network.orkError.ErrorCode.HTTP_INTERNAL_SERVER_ERROR.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            a[com.inmobi.commons.core.network.orkError.ErrorCode.HTTP_NOT_IMPLEMENTED.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[com.inmobi.commons.core.network.orkError.ErrorCode.HTTP_BAD_GATEWAY.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[com.inmobi.commons.core.network.orkError.ErrorCode.HTTP_SERVER_NOT_AVAILABLE.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[com.inmobi.commons.core.network.orkError.ErrorCode.HTTP_VERSION_NOT_SUPPORTED.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
