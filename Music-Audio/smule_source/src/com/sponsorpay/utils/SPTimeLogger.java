// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.utils;


// Referenced classes of package com.sponsorpay.utils:
//            SponsorPayLogger

public class SPTimeLogger
{

    public SPTimeLogger()
    {
    }

    public static void logEnd(String s, String s1, long l)
    {
        long l1 = System.currentTimeMillis();
        SponsorPayLogger.e(s, (new StringBuilder("=========== ")).append(l1).append(" =========").toString());
        SponsorPayLogger.e(s, (new StringBuilder("=========== ")).append(l1 - l).append(" =========").toString());
        SponsorPayLogger.e(s, (new StringBuilder("======================= ")).append(s1).append(" =======================").toString());
    }

    public static long logStart(String s, String s1)
    {
        SponsorPayLogger.e(s, (new StringBuilder("======================= ")).append(s1).append(" =======================").toString());
        long l = System.currentTimeMillis();
        SponsorPayLogger.e(s, (new StringBuilder("=========== ")).append(l).append(" =========").toString());
        return l;
    }
}
