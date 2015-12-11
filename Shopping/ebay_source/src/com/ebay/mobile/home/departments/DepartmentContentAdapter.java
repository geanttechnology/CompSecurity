// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.departments;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import com.ebay.mobile.common.view.RecyclerContentAdapter;
import com.ebay.mobile.deals.DealsContentViewHolder;
import com.ebay.mobile.home.UssContentsViewAdapter;
import com.ebay.mobile.home.cards.CategoriesViewHolder;
import com.ebay.mobile.home.cards.CategoriesViewModel;
import com.ebay.mobile.home.cards.CollectionContentGroupViewHolder;
import com.ebay.mobile.home.cards.DepartmentTitleViewHolder;
import com.ebay.mobile.home.cards.DepartmentTitleViewModel;
import com.ebay.mobile.home.cards.EventContentGroupViewHolder;
import com.ebay.mobile.home.cards.FeaturedCategoriesViewHolder;
import com.ebay.mobile.home.cards.FeaturedCategoriesViewModel;
import com.ebay.mobile.home.cards.ListOfCollectionsViewModel;
import com.ebay.mobile.home.cards.ListOfEventGroupsViewModel;
import com.ebay.mobile.home.cards.ListOfListingsViewModel;
import com.ebay.mobile.home.cards.ListOfTrendingViewModel;
import com.ebay.mobile.home.cards.NativeAdsViewHolder;
import com.ebay.mobile.home.cards.NativeAdsViewModel;
import com.ebay.mobile.home.cards.RTMViewHolder;
import com.ebay.mobile.home.cards.RTMViewModel;
import com.ebay.mobile.home.cards.TrendingViewHolder;
import com.ebay.nautilus.domain.data.UnifiedStream.Category;
import com.ebay.nautilus.domain.data.UnifiedStream.CategoryHistogram;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentSourceEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentTypeEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.Contents;
import com.ebay.nautilus.domain.data.cos.base.Text;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DepartmentContentAdapter extends RecyclerContentAdapter
    implements UssContentsViewAdapter
{

    private static final int SCREEN_WIDTH_WIDE = 768;
    public static final int VIEW_TYPE_BROWSE_CATEGORIES = 8;
    public static final int VIEW_TYPE_COLLECTIONS = 4;
    public static final int VIEW_TYPE_COLLECTIONS_MORE = 7;
    public static final int VIEW_TYPE_COLLECTIONS_TABLET = 13;
    public static final int VIEW_TYPE_DEPARTMENT_DEALS_DETAILS = 12;
    public static final int VIEW_TYPE_DEPARTMENT_DEALS_MORE = 5;
    public static final int VIEW_TYPE_DEPARTMENT_DEALS_PHONE = 2;
    public static final int VIEW_TYPE_DEPARTMENT_DEALS_TABLET = 14;
    public static final int VIEW_TYPE_DEPARTMENT_EVENTS = 3;
    public static final int VIEW_TYPE_DEPARTMENT_EVENTS_MORE = 6;
    public static final int VIEW_TYPE_DEPARTMENT_TITLE = 0;
    public static final int VIEW_TYPE_FEATURED_CATEGORIES = 1;
    public static final int VIEW_TYPE_NATIVE_AD = 9;
    public static final int VIEW_TYPE_RTM_PROMO = 10;
    public static final int VIEW_TYPE_RTM_PROMO_SLIM = 11;
    public static final int VIEW_TYPE_TRENDING = 15;
    public static final int VIEW_TYPE_TRENDING_MORE = 16;
    private boolean hasDealsTaxonomy;
    public boolean isDepartment;
    public boolean isSubDepartment;
    public final ChannelCardDecoration itemDecorator = new ChannelCardDecoration();
    private final Resources resources;
    private final String title;

    public DepartmentContentAdapter(Context context, String s)
    {
        RecyclerContentAdapter(context);
        hasDealsTaxonomy = false;
        title = s;
        resources = context.getResources();
        isDepartment = false;
        isSubDepartment = false;
        addViewType(0, com/ebay/mobile/home/cards/DepartmentTitleViewHolder, 0x7f0300e9);
        addViewType(1, com/ebay/mobile/home/cards/FeaturedCategoriesViewHolder, 0x7f0300f2);
        addViewType(2, com/ebay/mobile/deals/DealsContentViewHolder, 0x7f030045);
        addViewType(14, com/ebay/mobile/deals/DealsContentViewHolder, 0x7f0300e6);
        addViewType(3, com/ebay/mobile/home/cards/EventContentGroupViewHolder, 0x7f0300d9);
        addViewType(8, com/ebay/mobile/home/cards/CategoriesViewHolder, 0x7f0300d5);
        addViewType(4, com/ebay/mobile/home/cards/CollectionContentGroupViewHolder, 0x7f0300d7);
        addViewType(13, com/ebay/mobile/home/cards/CollectionContentGroupViewHolder, 0x7f0300d8);
        addViewType(9, com/ebay/mobile/home/cards/NativeAdsViewHolder, 0x7f0300fc);
        addViewType(10, com/ebay/mobile/home/cards/RTMViewHolder, 0x7f0300ed);
        addViewType(11, com/ebay/mobile/home/cards/RTMViewHolder, 0x7f0300ee);
        addViewType(15, com/ebay/mobile/home/cards/TrendingViewHolder, 0x7f03011a);
        dataSet.clear();
        dataSet.add(new DepartmentTitleViewModel(0, s, getOnClickListener(0)));
    }

    private void resetDepartment()
    {
        dataSet.clear();
        dataSet.add(new DepartmentTitleViewModel(0, title, getOnClickListener(0)));
    }

    public void setContents(Contents contents)
    {
        DeviceConfiguration deviceconfiguration;
        int i;
        if (!hasDealsTaxonomy)
        {
            resetDepartment();
        }
        deviceconfiguration = DeviceConfiguration.getAsync();
        DisplayMetrics displaymetrics = resources.getDisplayMetrics();
        i = (int)((float)displaymetrics.widthPixels / displaymetrics.density);
        if (contents == null || contents.contentGroups == null) goto _L2; else goto _L1
_L1:
        Iterator iterator = contents.contentGroups.iterator();
_L7:
        Object obj;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup)iterator.next();
        if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)).contentSource == ContentSourceEnum.FEATURED_CATEGORY)
        {
            dataSet.add(new FeaturedCategoriesViewModel(1, ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)), getOnClickListener(1)));
            continue; /* Loop/switch isn't completed */
        }
        if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)).contentSource == ContentSourceEnum.BROWSE_CATEGORY)
        {
            dataSet.add(new CategoriesViewModel(8, title, ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)), getOnClickListener(8)));
            continue; /* Loop/switch isn't completed */
        }
        if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)).contentSource == ContentSourceEnum.DEALS || ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)).contents != null && ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)).contents.size() > 0 && ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)).contents.get(0)).source == ContentSourceEnum.DEALS)
        {
            contents = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)).contents;
            if (contents != null)
            {
                obj = new ArrayList();
                Iterator iterator1 = contents.iterator();
                do
                {
                    if (!iterator1.hasNext())
                    {
                        break;
                    }
                    com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord contentrecord2 = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)iterator1.next();
                    if (contentrecord2 != null)
                    {
                        contents = contentrecord2.type;
                        if (contents != null && contents == ContentTypeEnum.DEALS_CATEGORY && deviceconfiguration.get(com.ebay.mobile.dcs.Dcs.Verticals.B.deals))
                        {
                            com.ebay.mobile.common.view.ViewModel.OnClickListener onclicklistener;
                            byte byte0;
                            byte byte2;
                            if (!isDepartment)
                            {
                                if (title.equals(resources.getString(0x7f070229)))
                                {
                                    contents = contentrecord2.title;
                                } else
                                {
                                    contents = resources.getString(0x7f0701d8);
                                }
                            } else
                            {
                                contents = resources.getString(0x7f070229);
                            }
                            if (i < 768)
                            {
                                byte0 = 2;
                            } else
                            {
                                byte0 = 14;
                            }
                            if (isSubDepartment)
                            {
                                byte2 = 12;
                            } else
                            {
                                byte2 = 5;
                            }
                            onclicklistener = getOnClickListener(byte2);
                            contents = ListOfListingsViewModel.createFromContentRecordListings(byte0, contents, contentrecord2.id, contentrecord2.listings, contentrecord2.hasMoreListings, getOnClickListener(byte0), onclicklistener);
                            if (DealsContentViewHolder.isValidModel(contents, isTablet, isLandscape))
                            {
                                ((List) (obj)).add(contents);
                            }
                        }
                    }
                } while (true);
                if (!((List) (obj)).isEmpty())
                {
                    dataSet.addAll(((java.util.Collection) (obj)));
                }
            }
            continue; /* Loop/switch isn't completed */
        }
        if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)).contentSource == ContentSourceEnum.RPP_EVENT && deviceconfiguration.get(com.ebay.mobile.dcs.Dcs.Verticals.B.events))
        {
            if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)).contents != null && ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)).contents.size() > 0)
            {
                if (!isDepartment)
                {
                    contents = resources.getString(0x7f0703de);
                } else
                {
                    contents = resources.getString(0x7f0703dd);
                }
                contents = ListOfEventGroupsViewModel.createEventGroup(3, contents, ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)), getOnClickListener(3), getOnClickListener(6), isTablet);
                if (EventContentGroupViewHolder.isValidModel(contents, isTablet, isLandscape))
                {
                    dataSet.addAll(contents);
                }
            }
            continue; /* Loop/switch isn't completed */
        }
        if ((((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)).contentSource == ContentSourceEnum.EBAY_TODAY || ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)).contentSource == ContentSourceEnum.TRENDING_COLLECTION) && deviceconfiguration.get(com.ebay.mobile.dcs.Dcs.Verticals.B.collections))
        {
            contents = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)).contents;
            if (contents != null)
            {
                obj = new ArrayList();
                contents = contents.iterator();
                do
                {
                    if (!contents.hasNext())
                    {
                        break;
                    }
                    com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord contentrecord = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)contents.next();
                    if (contentrecord.type == ContentTypeEnum.COLLECTION)
                    {
                        ((List) (obj)).add(contentrecord.collection);
                    }
                } while (true);
                byte byte1;
                if (!isDepartment)
                {
                    contents = resources.getString(0x7f070244);
                } else
                {
                    contents = resources.getString(0x7f070243);
                }
                if (i < 768)
                {
                    byte1 = 4;
                } else
                {
                    byte1 = 13;
                }
                contents = ListOfCollectionsViewModel.createFromCollectionList(byte1, contents, ((List) (obj)), isSubDepartment, getOnClickListener(byte1), getOnClickListener(7));
                if (CollectionContentGroupViewHolder.isValidModel(contents, isTablet, isLandscape))
                {
                    dataSet.add(contents);
                }
            }
            continue; /* Loop/switch isn't completed */
        }
        if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)).contentSource == ContentSourceEnum.RTM2)
        {
            dataSet.add(new NativeAdsViewModel(9, ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)), getOnClickListener(9)));
            continue; /* Loop/switch isn't completed */
        }
        if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)).contentSource != ContentSourceEnum.RTM)
        {
            break MISSING_BLOCK_LABEL_1013;
        }
        obj = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)).contents.iterator();
_L4:
        com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord contentrecord1;
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            contentrecord1 = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)((Iterator) (obj)).next();
        } while (contentrecord1.type != ContentTypeEnum.RTM_CAMPAIGN);
        contents = null;
        if (contentrecord1.rtm.cardStyle != 0 && deviceconfiguration.get(com.ebay.mobile.dcs.Dcs.Verticals.B.rtmCardStyle))
        {
            break; /* Loop/switch isn't completed */
        }
        contents = new RTMViewModel(10, contentrecord1.rtm, getOnClickListener(10));
_L6:
        if (contents != null && RTMViewHolder.isValidModel(contents))
        {
            dataSet.add(contents);
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (contentrecord1.rtm.cardStyle != 1) goto _L6; else goto _L5
_L5:
        contents = new RTMViewModel(11, contentrecord1.rtm, getOnClickListener(10));
          goto _L6
        if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)).contentSource == ContentSourceEnum.TRENDING_TOPIC && deviceconfiguration.get(com.ebay.mobile.dcs.Dcs.Verticals.B.trendingTopics))
        {
            contents = ListOfTrendingViewModel.createFromTrendingTopics(15, ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)), getOnClickListener(15), getOnClickListener(16));
            dataSet.add(contents);
        }
        if (true) goto _L7; else goto _L2
_L2:
        notifyDataSetChanged();
        return;
    }

    public void setDealsTaxonomy(List list)
    {
        resetDepartment();
        hasDealsTaxonomy = true;
        if (list == null)
        {
            return;
        }
        com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup contentgroup = new ContentGroup();
        contentgroup.contents = new ArrayList();
        contentgroup.contentSource = ContentSourceEnum.FEATURED_CATEGORY;
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            CategoryHistogram categoryhistogram = (CategoryHistogram)list.next();
            if (categoryhistogram.category != null && categoryhistogram.category.id != null && categoryhistogram.category.name != null && categoryhistogram.category.name.content != null)
            {
                com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord contentrecord = new ContentRecord();
                contentrecord.type = ContentTypeEnum.CATEGORY;
                contentrecord.id = categoryhistogram.category.id;
                contentrecord.title = categoryhistogram.category.name.content;
                contentrecord.category = categoryhistogram.category;
                contentgroup.contents.add(contentrecord);
            }
        } while (true);
        dataSet.add(new FeaturedCategoriesViewModel(1, contentgroup, getOnClickListener(5)));
    }


}
