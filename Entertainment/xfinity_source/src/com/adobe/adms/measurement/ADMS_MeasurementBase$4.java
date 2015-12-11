// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.adms.measurement;

import java.util.HashSet;

// Referenced classes of package com.adobe.adms.measurement:
//            ADMS_MeasurementBase

static final class add extends HashSet
{

    ()
    {
        add("ce");
        add("ns");
        add("cookieDomainPeriods");
        add("cookieLifetime");
        add("mtp");
        add("mtss");
        add("mti");
        add("mtsd");
        add("ts");
        for (int i = 1; i <= 75; i++)
        {
            add((new StringBuilder()).append("c").append(i).toString());
        }

        for (int j = 1; j <= 75; j++)
        {
            add((new StringBuilder()).append("v").append(j).toString());
        }

    }
}
