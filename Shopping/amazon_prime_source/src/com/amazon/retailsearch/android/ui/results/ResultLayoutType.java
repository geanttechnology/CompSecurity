// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;

public final class ResultLayoutType extends Enum
{

    private static final ResultLayoutType $VALUES[];
    public static final ResultLayoutType GalleryView;
    public static final ResultLayoutType GridView;
    public static final ResultLayoutType ImmersiveView;
    public static final ResultLayoutType ListView;
    public static final ResultLayoutType SplitView;
    private final int imageHeightId;
    private final int imageWidthId;
    private final String name;

    private ResultLayoutType(String s, int i, String s1, int j, int k)
    {
        super(s, i);
        name = s1;
        imageWidthId = j;
        imageHeightId = k;
    }

    public static ResultLayoutType findByNameIgnoreCase(String s)
    {
        ResultLayoutType aresultlayouttype[] = values();
        int j = aresultlayouttype.length;
        for (int i = 0; i < j; i++)
        {
            ResultLayoutType resultlayouttype = aresultlayouttype[i];
            if (resultlayouttype.getName().equalsIgnoreCase(s))
            {
                return resultlayouttype;
            }
        }

        return null;
    }

    public static ResultLayoutType valueOf(String s)
    {
        return (ResultLayoutType)Enum.valueOf(com/amazon/retailsearch/android/ui/results/ResultLayoutType, s);
    }

    public static ResultLayoutType[] values()
    {
        return (ResultLayoutType[])$VALUES.clone();
    }

    public Point getImageDimensions(Context context)
    {
        int j = 0;
        context = context.getResources();
        if (imageWidthId > 0) goto _L2; else goto _L1
_L1:
        int i = 0;
_L6:
        if (imageHeightId > 0) goto _L4; else goto _L3
_L3:
        return new Point(i, j);
_L2:
        i = (int)((double)(context.getDimension(imageWidthId) / context.getDisplayMetrics().density) + 0.5D);
        continue; /* Loop/switch isn't completed */
_L4:
        float f;
        float f1;
        f = context.getDimension(imageHeightId);
        f1 = context.getDisplayMetrics().density;
        j = (int)((double)(f / f1) + 0.5D);
          goto _L3
        context;
        if (RetailSearchLoggingProvider.getInstance() != null && RetailSearchLoggingProvider.getInstance().getRetailSearchLogger() != null)
        {
            RetailSearchLoggingProvider.getInstance().getRetailSearchLogger().error("Error getting image dimensions ", context);
        }
        return null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public String getName()
    {
        return name;
    }

    static 
    {
        ListView = new ResultLayoutType("ListView", 0, "List", com.amazon.retailsearch.R.dimen.rs_results_image_width_list, com.amazon.retailsearch.R.dimen.rs_results_image_height_list);
        GridView = new ResultLayoutType("GridView", 1, "Grid", com.amazon.retailsearch.R.dimen.rs_results_image_width_grid, com.amazon.retailsearch.R.dimen.rs_results_image_height_grid);
        GalleryView = new ResultLayoutType("GalleryView", 2, "Gallery", com.amazon.retailsearch.R.dimen.rs_results_image_width_gallery, com.amazon.retailsearch.R.dimen.rs_results_image_height_gallery);
        ImmersiveView = new ResultLayoutType("ImmersiveView", 3, "Immersive", 0, 0);
        SplitView = new ResultLayoutType("SplitView", 4, "Split", com.amazon.retailsearch.R.dimen.rs_results_image_width_gallery, com.amazon.retailsearch.R.dimen.rs_results_image_height_gallery);
        $VALUES = (new ResultLayoutType[] {
            ListView, GridView, GalleryView, ImmersiveView, SplitView
        });
    }
}
