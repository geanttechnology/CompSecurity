// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;

// Referenced classes of package com.amazon.retailsearch.android.ui.results:
//            MultiViewToggle, ViewType

private static class <init>
{

    private ImageView image;
    private int imageId;
    private int selectedImageId;
    private ViewType viewType;





    private stener(MultiViewToggle multiviewtoggle, ViewType viewtype, int i, int j, int k)
    {
        image = new ImageView(multiviewtoggle.getContext());
        int l = multiviewtoggle.getContext().getResources().getDimensionPixelSize(com.amazon.retailsearch.Size);
        image.setPadding(l, l, l, l);
        image.setOnClickListener(new stener(multiviewtoggle, viewtype, null));
        image.setContentDescription(multiviewtoggle.getResources().getString(k));
        viewType = viewtype;
        imageId = i;
        selectedImageId = j;
    }

    selectedImageId(MultiViewToggle multiviewtoggle, ViewType viewtype, int i, int j, int k, selectedImageId selectedimageid)
    {
        this(multiviewtoggle, viewtype, i, j, k);
    }
}
