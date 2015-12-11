// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ao;

import com.shazam.b.a.e;
import com.shazam.model.chart.FullChartItem;
import com.shazam.model.preview.PreviewViewData;

public final class b
    implements e
{

    private final e a;

    public b(e e1)
    {
        a = e1;
    }

    public final volatile boolean apply(Object obj)
    {
        obj = (FullChartItem)obj;
        if (obj == null || ((FullChartItem) (obj)).previewViewData == null)
        {
            return false;
        } else
        {
            return a.apply(((FullChartItem) (obj)).previewViewData.playlistItem);
        }
    }
}
