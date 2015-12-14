// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import com.inmobi.commons.core.network.NetworkError;
import com.inmobi.commons.core.network.c;

// Referenced classes of package com.inmobi.ads:
//            InMobiAdRequestStatus, e

final class f
{

    private c a;
    private InMobiAdRequestStatus b;
    private e c;

    public f(e e1, c c1)
    {
        c = e1;
        a = c1;
        if (a.c() != null)
        {
            e();
        }
    }

    private void e()
    {
        static class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[com.inmobi.commons.core.network.NetworkError.ErrorCode.values().length];
                try
                {
                    a[com.inmobi.commons.core.network.NetworkError.ErrorCode.NETWORK_UNAVAILABLE_ERROR.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    a[com.inmobi.commons.core.network.NetworkError.ErrorCode.HTTP_BAD_REQUEST.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    a[com.inmobi.commons.core.network.NetworkError.ErrorCode.HTTP_GATEWAY_TIMEOUT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    a[com.inmobi.commons.core.network.NetworkError.ErrorCode.HTTP_INTERNAL_SERVER_ERROR.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[com.inmobi.commons.core.network.NetworkError.ErrorCode.HTTP_NOT_IMPLEMENTED.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[com.inmobi.commons.core.network.NetworkError.ErrorCode.HTTP_BAD_GATEWAY.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[com.inmobi.commons.core.network.NetworkError.ErrorCode.HTTP_SERVER_NOT_AVAILABLE.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.inmobi.commons.core.network.NetworkError.ErrorCode.HTTP_VERSION_NOT_SUPPORTED.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[a.c().a().ordinal()])
        {
        default:
            b = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR);
            return;

        case 1: // '\001'
            b = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.NETWORK_UNREACHABLE);
            return;

        case 2: // '\002'
            b = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REQUEST_INVALID);
            return;

        case 3: // '\003'
            b = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REQUEST_TIMED_OUT);
            return;

        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
            b = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.SERVER_ERROR);
            break;
        }
    }

    public InMobiAdRequestStatus a()
    {
        return b;
    }

    public e b()
    {
        return c;
    }

    public String c()
    {
        return a.b();
    }

    public NetworkError d()
    {
        return a.c();
    }
}
