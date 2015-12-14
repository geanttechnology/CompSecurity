// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.view.viewpagerindicator;

import android.view.View;
import java.util.Comparator;

final class i
    implements Comparator
{

    i()
    {
    }

    public final int compare(Object obj, Object obj1)
    {
        obj = (View)obj;
        obj1 = (View)obj1;
        obj = (VerticalViewPager.LayoutParams)((View) (obj)).getLayoutParams();
        obj1 = (VerticalViewPager.LayoutParams)((View) (obj1)).getLayoutParams();
        if (((VerticalViewPager.LayoutParams) (obj)).a != ((VerticalViewPager.LayoutParams) (obj1)).a)
        {
            return !((VerticalViewPager.LayoutParams) (obj)).a ? -1 : 1;
        } else
        {
            return ((VerticalViewPager.LayoutParams) (obj)).e - ((VerticalViewPager.LayoutParams) (obj1)).e;
        }
    }
}
