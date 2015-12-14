// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.content.Context;
import android.content.res.Resources;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.kindle.activity.BasicListActivity;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            ThumbnailSizeLookUp, GridItemViewFactory

public static class thumbnail
    implements ThumbnailSizeLookUp
{

    private final int thumbnail;

    public int getHeight(int i)
    {
        return thumbnail;
    }

    public int getWidth(int i)
    {
        return thumbnail;
    }

    public (Context context)
    {
        Resources resources = context.getResources();
        int i = resources.getInteger(0x7f0d0001);
        int j = resources.getDimensionPixelSize(0x7f0a003d);
        int k = resources.getDimensionPixelSize(0x7f0a003c);
        thumbnail = BasicListActivity.calculateImageWidth(context, i, j, k);
        if (thumbnail == 0)
        {
            GLogger.warnStackTrace(GridItemViewFactory.access$000(), "Invalid thumbnail size of 0! numColumns: %d, sidePadding: %d, horizontalPadding: %d", new Object[] {
                Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k)
            });
        }
    }
}
