// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.framework.gallery.widget:
//            GalleryBadgeableCoverView

public abstract class AbstractBadgeableCoverView
    implements GalleryBadgeableCoverView
{

    private Map badgeToLayoutMap;
    protected Map badgeToggleTimeMap;
    protected View coverView;
    protected Set enabledBadges;
    protected Map foundViews;

    public AbstractBadgeableCoverView()
    {
        enabledBadges = EnumSet.noneOf(com/amazon/gallery/framework/gallery/widget/GalleryBadgeableCoverView$BadgeType);
        badgeToggleTimeMap = new HashMap();
        foundViews = new HashMap();
    }

    public Set getEnabledBadges()
    {
        return enabledBadges;
    }

    public boolean isBadgeEnabled(GalleryBadgeableCoverView.BadgeType badgetype)
    {
        return enabledBadges.contains(badgetype);
    }

    public void setAdditionalBadgeLayoutMap(Map map)
    {
        badgeToLayoutMap = map;
    }

    public void setBadgeToggleTime(GalleryBadgeableCoverView.BadgeType badgetype, long l)
    {
        badgeToggleTimeMap.put(badgetype, Long.valueOf(l));
    }

    protected void setBadgeVisible(GalleryBadgeableCoverView.BadgeType badgetype, int i, boolean flag)
    {
        boolean flag1 = false;
        if (!foundViews.containsKey(Integer.valueOf(i))) goto _L2; else goto _L1
_L1:
        View view = (View)foundViews.get(Integer.valueOf(i));
_L9:
        if (view != null) goto _L4; else goto _L3
_L3:
        return;
_L2:
        if (flag)
        {
            if (badgeToLayoutMap.containsKey(badgetype))
            {
                view = LayoutInflater.from(coverView.getContext()).inflate(((Integer)badgeToLayoutMap.get(badgetype)).intValue(), (ViewGroup)coverView);
            } else
            {
                view = coverView.findViewById(i);
            }
            flag1 = true;
            continue; /* Loop/switch isn't completed */
        }
        if (true) goto _L3; else goto _L4
_L4:
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (badgetype != null && !getEnabledBadges().add(badgetype)) goto _L3; else goto _L5
_L5:
        view.setVisibility(0);
        if (!flag1) goto _L3; else goto _L6
_L6:
        foundViews.put(Integer.valueOf(i), coverView.findViewById(i));
        return;
        if (badgetype != null && !getEnabledBadges().remove(badgetype)) goto _L3; else goto _L7
_L7:
        view.setVisibility(8);
        return;
        if (true) goto _L9; else goto _L8
_L8:
    }

    protected void setBadgeVisible(GalleryBadgeableCoverView.BadgeType badgetype, boolean flag)
    {
        if (flag)
        {
            getEnabledBadges().add(badgetype);
            return;
        } else
        {
            getEnabledBadges().remove(badgetype);
            return;
        }
    }

    public void toggleBadge(GalleryBadgeableCoverView.BadgeType badgetype, boolean flag)
    {
        setBadgeVisible(badgetype, badgetype.viewId, flag);
    }
}
