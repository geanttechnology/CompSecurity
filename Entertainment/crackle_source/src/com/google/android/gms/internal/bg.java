// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.a;
import java.util.Date;
import java.util.HashSet;

// Referenced classes of package com.google.android.gms.internal:
//            x, v

public final class bg
{

    public static int a(com.google.ads.AdRequest.ErrorCode errorcode)
    {
        static class _cls1
        {

            static final int gl[];
            static final int gm[];

            static 
            {
                gm = new int[com.google.ads.AdRequest.ErrorCode.values().length];
                try
                {
                    gm[com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    gm[com.google.ads.AdRequest.ErrorCode.INVALID_REQUEST.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    gm[com.google.ads.AdRequest.ErrorCode.NETWORK_ERROR.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    gm[com.google.ads.AdRequest.ErrorCode.NO_FILL.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                gl = new int[com.google.ads.AdRequest.Gender.values().length];
                try
                {
                    gl[com.google.ads.AdRequest.Gender.FEMALE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    gl[com.google.ads.AdRequest.Gender.MALE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    gl[com.google.ads.AdRequest.Gender.UNKNOWN.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.gm[errorcode.ordinal()])
        {
        default:
            return 0;

        case 2: // '\002'
            return 1;

        case 3: // '\003'
            return 2;

        case 4: // '\004'
            return 3;
        }
    }

    public static int a(com.google.ads.AdRequest.Gender gender)
    {
        switch (_cls1.gl[gender.ordinal()])
        {
        default:
            return 0;

        case 1: // '\001'
            return 2;

        case 2: // '\002'
            return 1;
        }
    }

    public static AdSize b(x x1)
    {
        return new AdSize(com.google.android.gms.ads.a.a(x1.width, x1.height, x1.eF));
    }

    public static MediationAdRequest e(v v1)
    {
        HashSet hashset;
        if (v1.ez != null)
        {
            hashset = new HashSet(v1.ez);
        } else
        {
            hashset = null;
        }
        return new MediationAdRequest(new Date(v1.ex), g(v1.ey), hashset, v1.eA);
    }

    public static com.google.ads.AdRequest.Gender g(int i)
    {
        switch (i)
        {
        default:
            return com.google.ads.AdRequest.Gender.UNKNOWN;

        case 2: // '\002'
            return com.google.ads.AdRequest.Gender.FEMALE;

        case 1: // '\001'
            return com.google.ads.AdRequest.Gender.MALE;
        }
    }

    public static final com.google.ads.AdRequest.ErrorCode h(int i)
    {
        switch (i)
        {
        default:
            return com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR;

        case 1: // '\001'
            return com.google.ads.AdRequest.ErrorCode.INVALID_REQUEST;

        case 2: // '\002'
            return com.google.ads.AdRequest.ErrorCode.NETWORK_ERROR;

        case 3: // '\003'
            return com.google.ads.AdRequest.ErrorCode.NO_FILL;
        }
    }
}
