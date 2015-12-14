// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.widget;

import java.util.EnumSet;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.framework.kindle.widget:
//            BadgeableItemViewFactory

private static class <init> extends ThreadLocal
{

    public volatile Object get()
    {
        return get();
    }

    public Set get()
    {
        Set set = (Set)super.get();
        set.clear();
        return set;
    }

    protected volatile Object initialValue()
    {
        return initialValue();
    }

    protected Set initialValue()
    {
        return EnumSet.noneOf(com/amazon/gallery/framework/gallery/widget/GalleryBadgeableCoverView$BadgeType);
    }

    private ()
    {
    }

    ( )
    {
        this();
    }
}
