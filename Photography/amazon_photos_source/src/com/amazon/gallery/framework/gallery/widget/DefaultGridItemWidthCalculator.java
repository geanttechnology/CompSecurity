// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.content.Context;
import com.amazon.gallery.framework.kindle.activity.BasicListActivity;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            CollectionViewItemWidthCalculator

public class DefaultGridItemWidthCalculator
    implements CollectionViewItemWidthCalculator
{

    public DefaultGridItemWidthCalculator()
    {
    }

    public int calculateItemWidth(Context context, int i, int j, int k)
    {
        return BasicListActivity.calculateImageWidth(context, i, j, k);
    }
}
