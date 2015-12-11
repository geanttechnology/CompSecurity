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
        add("vid");
        add("ce");
        add("ns");
        add("pageName");
        add("g");
        add("r");
        add("cc");
        add("pe");
        add("ts");
        add("t");
        add("purchaseID");
        add("ch");
        add("server");
        add("pageType");
        add("xact");
        add("v0");
        add("state");
        add("zip");
        add("events");
        add("products");
        add("mtsr");
        for (int i = 1; i <= 75; i++)
        {
            add((new StringBuilder()).append("c").append(i).toString());
        }

        for (int j = 1; j <= 75; j++)
        {
            add((new StringBuilder()).append("v").append(j).toString());
        }

        for (int k = 1; k <= 5; k++)
        {
            add((new StringBuilder()).append("h").append(k).toString());
        }

        for (int l = 1; l <= 3; l++)
        {
            add((new StringBuilder()).append("l").append(l).toString());
        }

        for (int i1 = 1; i1 <= 3; i1++)
        {
            add((new StringBuilder()).append("pev").append(i1).toString());
        }

        add("c");
        add("mtsd");
    }
}
