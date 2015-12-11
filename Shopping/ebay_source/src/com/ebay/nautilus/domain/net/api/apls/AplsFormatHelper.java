// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.apls;

import java.util.Locale;

public final class AplsFormatHelper
{

    public AplsFormatHelper()
    {
    }

    public static String perfIntervalFormat(long l)
    {
        return String.format(Locale.US, "%.3f", new Object[] {
            Float.valueOf((float)l / 1000F)
        });
    }
}
