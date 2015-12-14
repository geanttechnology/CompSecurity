// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.content.Context;
import android.content.res.Resources;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            TagCardCoverViewFactory, DefaultGridItemWidthCalculator, CollectionViewItemWidthCalculator, CoverViewInterface

public class DefaultGalleryTagCoverHelper
{

    private final CollectionViewItemWidthCalculator itemWidthCalculator = new DefaultGridItemWidthCalculator();
    private final CoverViewInterface tagCoverViewFactory;

    public DefaultGalleryTagCoverHelper(BeanAwareActivity beanawareactivity)
    {
        tagCoverViewFactory = new TagCardCoverViewFactory(beanawareactivity);
    }

    public int getBottomOffsetForBadges(Context context)
    {
        return context.getResources().getDimensionPixelSize(0x7f0a012d);
    }

    public CoverViewInterface getTagCoverViewFactory()
    {
        return tagCoverViewFactory;
    }

    public CollectionViewItemWidthCalculator getTagItemWidthCalculator()
    {
        return itemWidthCalculator;
    }

    public boolean isItemShadowRequired()
    {
        return false;
    }
}
