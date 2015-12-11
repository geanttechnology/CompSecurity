// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;

// Referenced classes of package com.amazon.retailsearch.android.ui.results:
//            MultiViewToggle, ResultLayoutType

private static class <init>
{

    private String description;
    private ImageView image;
    private int imageId;
    private ResultLayoutType resultLayoutType;
    private int selectedImageId;






    private stener(MultiViewToggle multiviewtoggle, ResultLayoutType resultlayouttype, int i, int j, int k)
    {
        image = new ImageView(multiviewtoggle.getContext());
        description = multiviewtoggle.getResources().getString(k);
        k = multiviewtoggle.getContext().getResources().getDimensionPixelSize(com.amazon.retailsearch.Size);
        image.setPadding(k, k, k, k);
        image.setOnClickListener(new stener(multiviewtoggle, resultlayouttype, null));
        image.setContentDescription(description);
        resultLayoutType = resultlayouttype;
        imageId = i;
        selectedImageId = j;
    }

    selectedImageId(MultiViewToggle multiviewtoggle, ResultLayoutType resultlayouttype, int i, int j, int k, selectedImageId selectedimageid)
    {
        this(multiviewtoggle, resultlayouttype, i, j, k);
    }
}
