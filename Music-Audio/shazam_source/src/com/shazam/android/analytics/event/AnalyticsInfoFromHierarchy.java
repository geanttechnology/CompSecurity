// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event;

import android.view.View;
import com.shazam.model.analytics.AnalyticsInfo;
import com.shazam.o.k;

public class AnalyticsInfoFromHierarchy
{

    public AnalyticsInfoFromHierarchy()
    {
    }

    private static void addAnalyticsInfoFromParentsRecursively(com.shazam.model.analytics.AnalyticsInfo.Builder builder, View view)
    {
        do
        {
            Object obj = view.getTag(0x7f110033);
            if (obj != null)
            {
                obj = ((AnalyticsInfo)obj).eventParameters;
                k.a(builder.eventParameters, ((java.util.Map) (obj)));
            }
            view = view.getParent();
            if (view != null && (view instanceof View))
            {
                view = (View)view;
            } else
            {
                return;
            }
        } while (true);
    }

    public static AnalyticsInfo addAnalyticsInfoFromViewHierarchy(View view)
    {
        com.shazam.model.analytics.AnalyticsInfo.Builder builder = com.shazam.model.analytics.AnalyticsInfo.Builder.a();
        addAnalyticsInfoFromParentsRecursively(builder, view);
        return builder.b();
    }
}
