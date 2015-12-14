// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.amazon.gallery.framework.gallery.cab.SelectionChecker;
import com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView;
import com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverViewProvider;
import com.amazon.gallery.framework.gallery.widget.ItemViewFactory;
import com.amazon.gallery.framework.gallery.widget.ViewFactory;
import com.amazon.gallery.framework.gallery.widget.holder.ItemViewHolder;
import com.amazon.gallery.framework.kindle.amazon.KindleFrameworkDependencyInjector;
import com.amazon.gallery.framework.kindle.widget.badgechecker.ActivePhotoChecker;
import com.amazon.gallery.framework.kindle.widget.badgechecker.BadgeChecker;
import com.amazon.gallery.framework.model.Persistable;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class BadgeableItemViewFactory
    implements ViewFactory
{
    private static class ThreadLocalBadgeEnum extends ThreadLocal
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

        private ThreadLocalBadgeEnum()
        {
        }

    }

    private static class ThreadLocalBadgeTypeList extends ThreadLocal
    {

        protected volatile Object initialValue()
        {
            return initialValue();
        }

        protected ArrayList initialValue()
        {
            return new ArrayList();
        }

        private ThreadLocalBadgeTypeList()
        {
        }

    }


    private static ThreadLocal TEMP_NEW_BADGE = new ThreadLocalBadgeEnum(null);
    private static ThreadLocal TEMP_REMOVED_BADGE = new ThreadLocalBadgeEnum(null);
    private BadgeChecker badgeChecker;
    private int badgeLayout;
    private final ThreadLocal badgeProcessingList = new ThreadLocalBadgeTypeList(null);
    private Map badgeToLayoutMap;
    private GalleryBadgeableCoverViewProvider badgeViewProvider;
    private final ItemViewFactory baseFactory;
    private Context context;

    public BadgeableItemViewFactory(ItemViewFactory itemviewfactory, BadgeChecker badgechecker)
    {
        badgeLayout = 0x7f030073;
        baseFactory = itemviewfactory;
        KindleFrameworkDependencyInjector.inject(this);
        badgeChecker = badgechecker;
        badgeToLayoutMap = new EnumMap(com/amazon/gallery/framework/gallery/widget/GalleryBadgeableCoverView$BadgeType);
        badgeToLayoutMap.put(com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType.HIDDEN, Integer.valueOf(0x7f03009b));
        badgeToLayoutMap.put(com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType.DEVICE, Integer.valueOf(0x7f030084));
        badgeToLayoutMap.put(com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType.UPLOADING_NO_PROGRESS, Integer.valueOf(0x7f0300ef));
        badgeToLayoutMap.put(com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType.NEW_CONTENT, Integer.valueOf(0x7f0300b0));
        badgeToLayoutMap.put(com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType.NOT_UPLOADED, Integer.valueOf(0x7f03008a));
        badgeToLayoutMap.put(com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType.LENTICULAR, Integer.valueOf(0x7f0300a8));
        badgeToLayoutMap.put(com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType.REWIND, Integer.valueOf(0x7f0300ce));
        badgeToLayoutMap.put(com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType.UPLOADED, Integer.valueOf(0x7f030088));
        badgeToLayoutMap.put(com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType.HIGHLIGHT, Integer.valueOf(0x7f03009c));
        badgeToLayoutMap.put(com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType.SELECTED, Integer.valueOf(0x7f0300d2));
        badgeToLayoutMap.put(com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType.QUEUED, Integer.valueOf(0x7f0300cc));
        badgeToLayoutMap.put(com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType.SHARED, Integer.valueOf(0x7f0300d3));
    }

    private void disableBadgeGroup(com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType badgetype, GalleryBadgeableCoverView gallerybadgeablecoverview)
    {
        if (!gallerybadgeablecoverview.getEnabledBadges().isEmpty())
        {
            Object obj = (ArrayList)badgeProcessingList.get();
            ((ArrayList) (obj)).clear();
            ((ArrayList) (obj)).addAll(gallerybadgeablecoverview.getEnabledBadges());
            obj = ((ArrayList) (obj)).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType badgetype1 = (com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType)((Iterator) (obj)).next();
                if (badgetype1.category == badgetype.category)
                {
                    toggleBadge(gallerybadgeablecoverview, badgetype1, false);
                }
            }
        }
    }

    private int toggleBadge(GalleryBadgeableCoverView gallerybadgeablecoverview, com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType badgetype, boolean flag)
    {
        Set set;
        set = gallerybadgeablecoverview.getEnabledBadges();
        if (set == null)
        {
            return 0;
        }
        if (badgetype == null)
        {
            return set.size();
        }
        if (flag == set.contains(badgetype))
        {
            return set.size();
        }
        if (flag)
        {
            disableBadgeGroup(badgetype, gallerybadgeablecoverview);
        }
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$gallery$framework$gallery$widget$GalleryBadgeableCoverView$BadgeType[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$gallery$widget$GalleryBadgeableCoverView$BadgeType = new int[com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$widget$GalleryBadgeableCoverView$BadgeType[com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType.SELECTED.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$widget$GalleryBadgeableCoverView$BadgeType[com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType.ACTIVE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$widget$GalleryBadgeableCoverView$BadgeType[com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType.UPLOADING.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType[badgetype.ordinal()];
        JVM INSTR tableswitch 1 3: default 92
    //                   1 108
    //                   2 118
    //                   3 128;
           goto _L1 _L2 _L3 _L4
_L1:
        gallerybadgeablecoverview.toggleBadge(badgetype, flag);
_L6:
        return set.size();
_L2:
        gallerybadgeablecoverview.setSelectedBadgeVisible(flag);
        continue; /* Loop/switch isn't completed */
_L3:
        gallerybadgeablecoverview.setActiveBadgeVisible(flag);
        continue; /* Loop/switch isn't completed */
_L4:
        if (!flag)
        {
            gallerybadgeablecoverview.setProgress(null, flag, 0, 0);
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public View createView(Persistable persistable)
    {
        return baseFactory.createView(persistable);
    }

    public volatile View createView(Object obj)
    {
        return createView((Persistable)obj);
    }

    public void enableBadges(View view, Set set)
    {
        Object obj = (ItemViewHolder)view.getTag();
        if (obj != null)
        {
            if (((ItemViewHolder) (obj)).badges == null)
            {
                wrapAsBadgeable((ViewGroup)view, ((ItemViewHolder) (obj)));
            }
            view = ((ItemViewHolder) (obj)).badges;
            Set set1 = view.getEnabledBadges();
            Set set2 = (Set)TEMP_NEW_BADGE.get();
            set2.addAll(set);
            set2.removeAll(set1);
            obj = (Set)TEMP_REMOVED_BADGE.get();
            ((Set) (obj)).addAll(set1);
            ((Set) (obj)).removeAll(set);
            for (set = set2.iterator(); set.hasNext(); toggleBadge(view, (com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType)set.next(), true)) { }
            set = ((Set) (obj)).iterator();
            while (set.hasNext()) 
            {
                toggleBadge(view, (com.amazon.gallery.framework.gallery.widget.GalleryBadgeableCoverView.BadgeType)set.next(), false);
            }
        }
    }

    public ItemViewFactory getBaseFactory()
    {
        return baseFactory;
    }

    public View getView(int i, Persistable persistable, View view)
    {
        view = baseFactory.getView(i, persistable, view);
        ItemViewHolder itemviewholder = (ItemViewHolder)view.getTag();
        persistable = badgeChecker.getBadgesForView(persistable, view);
        if (itemviewholder != null && itemviewholder.badges == null && !persistable.isEmpty())
        {
            wrapAsBadgeable((ViewGroup)view, itemviewholder);
        }
        enableBadges(view, persistable);
        return view;
    }

    public volatile View getView(int i, Object obj, View view)
    {
        return getView(i, (Persistable)obj, view);
    }

    public void onViewDestroy(View view)
    {
        baseFactory.onViewDestroy(view);
    }

    public void reset()
    {
        baseFactory.reset();
    }

    public void setActivePhotoChecker(ActivePhotoChecker activephotochecker)
    {
        badgeChecker.setActivePhotoChecker(activephotochecker);
    }

    public void setBadgeViewProvider(GalleryBadgeableCoverViewProvider gallerybadgeablecoverviewprovider)
    {
        badgeViewProvider = gallerybadgeablecoverviewprovider;
    }

    public void setBoundingSize(int i, int j)
    {
        baseFactory.setBoundingSize(i, j);
    }

    public void setContext(Context context1)
    {
        context = context1;
        baseFactory.setContext(context1);
    }

    public void setEqualityCheck(com.amazon.gallery.framework.gallery.widget.ViewFactory.VisibleEqualityCheck visibleequalitycheck)
    {
        baseFactory.setEqualityCheck(visibleequalitycheck);
    }

    public void setSelectionChecker(SelectionChecker selectionchecker)
    {
        badgeChecker.setSelectionChecker(selectionchecker);
    }

    public View wrapAsBadgeable(ViewGroup viewgroup, ItemViewHolder itemviewholder)
    {
        View view = View.inflate(context, badgeLayout, viewgroup).findViewById(0x7f0c010f);
        itemviewholder.badges = badgeViewProvider.buildBadgeableCoverView(view);
        itemviewholder.badges.setAdditionalBadgeLayoutMap(badgeToLayoutMap);
        return viewgroup;
    }

}
