// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.widget.badgechecker;

import android.view.View;
import com.amazon.gallery.framework.gallery.cab.SelectionChecker;
import java.util.EnumSet;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.framework.kindle.widget.badgechecker:
//            ActivePhotoChecker

public class BadgeChecker
{

    ActivePhotoChecker activePhotoChecker;
    SelectionChecker selectionChecker;

    public BadgeChecker()
    {
        selectionChecker = null;
        activePhotoChecker = null;
    }

    public Set getBadgesForView(Object obj, View view)
    {
        view = EnumSet.noneOf(com/amazon/gallery/framework/gallery/widget/GalleryBadgeableCoverView$BadgeType);
        if (selectionChecker != null && selectionChecker.isSelected(obj))
        {
            view.add(com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType.SELECTED);
        }
        if (activePhotoChecker != null && activePhotoChecker.isActive(obj))
        {
            view.add(com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType.ACTIVE);
        }
        return view;
    }

    public void setActivePhotoChecker(ActivePhotoChecker activephotochecker)
    {
        activePhotoChecker = activephotochecker;
    }

    public void setSelectionChecker(SelectionChecker selectionchecker)
    {
        selectionChecker = selectionchecker;
    }
}
