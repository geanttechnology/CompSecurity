// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;


// Referenced classes of package com.inmobi.ads:
//            InMobiAdRequestStatus

static class atusCode
{

    static final int a[];

    static 
    {
        a = new int[atusCode.values().length];
        try
        {
            a[atusCode.INTERNAL_ERROR.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            a[atusCode.NETWORK_UNREACHABLE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            a[atusCode.REQUEST_INVALID.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            a[atusCode.REQUEST_PENDING.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            a[atusCode.REQUEST_TIMED_OUT.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            a[atusCode.SERVER_ERROR.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[atusCode.NO_FILL.ordinal()] = 7;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[atusCode.AD_ACTIVE.ordinal()] = 8;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[atusCode.EARLY_REFRESH_REQUEST.ordinal()] = 9;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
