// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.widget.badgechecker;

import android.view.View;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.framework.kindle.widget.badgechecker:
//            BadgeChecker

public class TagBadgeChecker extends BadgeChecker
{

    private NetworkConnectivity networkConnectivity;

    public TagBadgeChecker(NetworkConnectivity networkconnectivity)
    {
        networkConnectivity = networkconnectivity;
    }

    public Set getBadgesForView(Tag tag, View view)
    {
        view = super.getBadgesForView(tag, view);
        if (tag.getType() != TagType.ALBUM && tag.hasProperty(TagProperty.NEW_CONTENT))
        {
            view.add(com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType.NEW_CONTENT);
        } else
        {
            if (tag.hasProperty(TagProperty.NOT_UPLOADED))
            {
                if (networkConnectivity.isNetworkConnected())
                {
                    view.add(com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType.NOT_UPLOADED);
                    return view;
                } else
                {
                    view.add(com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType.NO_NETWORK);
                    return view;
                }
            }
            if (tag.hasProperty(TagProperty.UPLOADING))
            {
                view.add(com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType.UPLOADING);
                return view;
            }
            if (tag.hasProperty(TagProperty.UPLOADED))
            {
                view.add(com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType.UPLOADED);
                return view;
            }
        }
        return view;
    }

    public volatile Set getBadgesForView(Object obj, View view)
    {
        return getBadgesForView((Tag)obj, view);
    }
}
