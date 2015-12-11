// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.apls;

import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.domain.net.EbayResponse;
import java.util.Date;

public final class AplsReportInfo
{

    public final transient long epochSessionStart;
    public final String level;
    public final String name;
    public final String packageEnd;
    public final String packageStart;
    public final String sessionEnd;
    public final String sessionStart;

    public AplsReportInfo(String s, String s1, long l, long l1, long l2, long l3)
    {
        name = s;
        level = s1;
        epochSessionStart = l;
        sessionStart = formatHostDate(epochSessionStart);
        sessionEnd = formatHostDate(l1);
        packageStart = formatHostDate(l2);
        packageEnd = formatHostDate(l3);
    }

    private String formatHostDate(long l)
    {
        if (l == 0L)
        {
            return null;
        } else
        {
            return EbayDateUtils.format(new Date(EbayResponse.getHostTime(l)));
        }
    }
}
