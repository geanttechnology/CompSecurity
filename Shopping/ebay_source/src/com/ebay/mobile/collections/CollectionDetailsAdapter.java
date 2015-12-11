// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.collections;

import android.content.Context;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import com.ebay.mobile.common.view.RecyclerContentAdapter;
import com.ebay.mobile.common.view.ViewHolder;
import com.ebay.mobile.common.view.ViewModel;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.collections:
//            CollectionDescriptionViewHolder, CollectionItemViewHolder, CollectionDetailsPageHeaderViewHolder, CollectionDescriptionViewModel, 
//            CollectionItemViewModel, CollectionDetailsPageHeaderViewModel

public class CollectionDetailsAdapter extends RecyclerContentAdapter
{

    public static final int VIEW_TYPE_DESCRIPTION = 6;
    public static final int VIEW_TYPE_PAGE_HEADER = 7;
    public static final int VIEW_TYPE_PHONE_LARGE = 5;
    public static final int VIEW_TYPE_PHONE_LEFT = 3;
    public static final int VIEW_TYPE_PHONE_RIGHT = 4;
    private static final int VIEW_TYPE_TABLET_3_SMALL = 2;
    private static final int VIEW_TYPE_TABLET_LEFT = 0;
    private static final int VIEW_TYPE_TABLET_RIGHT = 1;
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo log = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("CollectionDetails", 3, "CollectionDetailsAdapter");
    private int afterBigIndex;
    private boolean descriptionChecked;
    private boolean followed;
    private boolean isHeaderAdded;
    private int overallTotal;

    public CollectionDetailsAdapter(Context context)
    {
        super(context);
        afterBigIndex = 0;
        overallTotal = 0;
        addViewType(6, com/ebay/mobile/collections/CollectionDescriptionViewHolder, 0x7f030065);
        addViewType(0, com/ebay/mobile/collections/CollectionItemViewHolder, 0x7f0302d7);
        addViewType(1, com/ebay/mobile/collections/CollectionItemViewHolder, 0x7f0302d8);
        addViewType(2, com/ebay/mobile/collections/CollectionItemViewHolder, 0x7f03006f);
        addViewType(4, com/ebay/mobile/collections/CollectionItemViewHolder, 0x7f03006c);
        addViewType(3, com/ebay/mobile/collections/CollectionItemViewHolder, 0x7f03006c);
        addViewType(5, com/ebay/mobile/collections/CollectionItemViewHolder, 0x7f03006c);
        addViewType(7, com/ebay/mobile/collections/CollectionDetailsPageHeaderViewHolder, 0x7f030073);
    }

    private void addLandscapeTabletViews(com.ebay.nautilus.domain.data.CollectionDetail.Collection collection)
    {
        Object obj;
        List list;
        boolean flag;
        int i;
        int j;
        boolean flag1;
        int i1;
        list = collection.entries;
        i1 = 1;
        flag1 = true;
        j = list.size();
        obj = list;
        i = j;
        flag = i1;
        if (collection.description == null) goto _L2; else goto _L1
_L1:
        obj = list;
        i = j;
        flag = i1;
        if (descriptionChecked) goto _L2; else goto _L3
_L3:
        i1 = Math.min(2, j - 1);
        if (i1 != 0) goto _L5; else goto _L4
_L4:
        return;
_L5:
        obj = new CollectionDescriptionViewModel(6, list.subList(0, i1), collection.description, collection.headline, getOnClickListener(6));
        collection = list;
        i = j;
        flag = flag1;
        if (CollectionDescriptionViewHolder.isValidModel(((ViewModel) (obj)), isTablet, isLandscape))
        {
            dataSet.add(obj);
            collection = list.subList(i1, j);
            i = j - i1;
            overallTotal = overallTotal + i1;
            flag = false;
        }
        descriptionChecked = true;
        obj = collection;
_L2:
        int k = 0;
        while (k < i) 
        {
            boolean flag2 = false;
            if (k + 4 >= i)
            {
                flag2 = true;
            }
            CollectionItemViewModel collectionitemviewmodel;
            int l;
            if (flag2)
            {
                collection = ((List) (obj)).subList(k, i);
            } else
            {
                collection = ((List) (obj)).subList(k, k + 5);
            }
            if (flag)
            {
                l = 0;
            } else
            {
                l = 1;
            }
            collectionitemviewmodel = new CollectionItemViewModel(l, collection, getOnClickListener(l));
            if (CollectionItemViewHolder.isValidModel(collectionitemviewmodel, isTablet, isLandscape))
            {
                dataSet.add(collectionitemviewmodel);
            }
            overallTotal = overallTotal + collection.size();
            if (!flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            k = k + 4 + 1;
        }
        if (true) goto _L4; else goto _L6
_L6:
    }

    private void addPortraitTabletViews(com.ebay.nautilus.domain.data.CollectionDetail.Collection collection)
    {
        Object obj;
        int j;
        int l;
        List list = collection.entries;
        int i1 = list.size();
        obj = list;
        l = i1;
        if (collection.description != null)
        {
            obj = list;
            l = i1;
            if (!descriptionChecked)
            {
                obj = new CollectionDescriptionViewModel(6, list.subList(0, 1), collection.description, collection.headline, getOnClickListener(6));
                collection = list;
                int i = i1;
                if (CollectionDescriptionViewHolder.isValidModel(((ViewModel) (obj)), isTablet, isLandscape))
                {
                    dataSet.add(obj);
                    overallTotal = overallTotal + 1;
                    collection = list.subList(1, i1);
                    i = i1 - 1;
                }
                descriptionChecked = true;
                l = i;
                obj = collection;
            }
        }
        j = 0;
_L4:
        if (j >= l) goto _L2; else goto _L1
_L1:
        int j1;
        int k1;
        k1 = 0;
        j1 = j;
_L5:
        j = j1;
        if (k1 >= 4) goto _L4; else goto _L3
_L3:
        if (j1 < l)
        {
            break MISSING_BLOCK_LABEL_173;
        }
_L2:
        return;
        int l1 = Math.min(3, l - j1);
        collection = ((List) (obj)).subList(j1, j1 + l1);
        int k;
        if (k1 == 0)
        {
            k = 0;
        } else
        if (k1 == 1 || k1 == 3)
        {
            k = 2;
        } else
        {
            k = 1;
        }
        collection = new CollectionItemViewModel(k, collection, getOnClickListener(k));
        if (CollectionItemViewHolder.isValidModel(collection, isTablet, isLandscape))
        {
            dataSet.add(collection);
            overallTotal = overallTotal + l1;
        }
        j1 += l1;
        k1++;
          goto _L5
    }

    public void appendToCollection(com.ebay.nautilus.domain.data.CollectionDetail.Collection collection)
    {
        if (collection == null) goto _L2; else goto _L1
_L1:
        List list = collection.entries;
        if (list == null) goto _L4; else goto _L3
_L3:
        int i = list.size();
        if (i == 0) goto _L4; else goto _L5
_L5:
        if (!isHeaderAdded)
        {
            CollectionDetailsPageHeaderViewModel collectiondetailspageheaderviewmodel = new CollectionDetailsPageHeaderViewModel(7, getOnClickListener(7), collection);
            collectiondetailspageheaderviewmodel.isCollectionFollowed = followed;
            dataSet.add(collectiondetailspageheaderviewmodel);
            isHeaderAdded = true;
            descriptionChecked = true;
        }
        if (!isTablet || !isLandscape) goto _L7; else goto _L6
_L6:
        addLandscapeTabletViews(collection);
_L4:
        notifyDataSetChanged();
        if (log.isLoggable)
        {
            log.log((new StringBuilder()).append("Overall total items: ").append(overallTotal).toString());
        }
        return;
_L7:
        int j;
        int k;
        if (isTablet)
        {
            addPortraitTabletViews(collection);
            continue; /* Loop/switch isn't completed */
        }
        k = getItemCount();
        j = i;
        if (i > 0)
        {
            j = i;
            if (k > 0)
            {
                j = i;
                if (((ViewModel)dataSet.get(k - 1)).viewType == 3)
                {
                    collection = new ArrayList();
                    collection.add(list.remove(0));
                    collection = new CollectionItemViewModel(4, collection, getOnClickListener(4));
                    if (CollectionItemViewHolder.isValidModel(collection, isTablet, isLandscape))
                    {
                        dataSet.add(collection);
                    }
                    j = i - 1;
                }
            }
        }
        k = 0;
_L9:
        if (k >= j)
        {
            continue; /* Loop/switch isn't completed */
        }
        i = 3;
        collection = new ArrayList();
        collection.add(list.get(k));
        if (afterBigIndex != 4)
        {
            break; /* Loop/switch isn't completed */
        }
        i = 5;
        afterBigIndex = 0;
_L10:
        collection = new CollectionItemViewModel(i, collection, getOnClickListener(i));
        if (CollectionItemViewHolder.isValidModel(collection, isTablet, isLandscape))
        {
            dataSet.add(collection);
        }
        k++;
        if (true) goto _L9; else goto _L8
_L8:
        afterBigIndex = afterBigIndex + 1;
        if (afterBigIndex % 2 == 0)
        {
            i = 4;
        }
          goto _L10
        if (true) goto _L9; else goto _L2
_L2:
        dataSet.clear();
        overallTotal = 0;
        if (true) goto _L4; else goto _L11
_L11:
    }

    public android.support.v7.widget.RecyclerView.LayoutManager createLayoutManager()
    {
        return new StaggeredGridLayoutManager(getNumSpans(), 1);
    }

    public int getNumSpans()
    {
        if (isTablet)
        {
            return 1;
        }
        return !isLandscape ? 2 : 3;
    }

    public volatile void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        onBindViewHolder((ViewHolder)viewholder, i);
    }

    public final void onBindViewHolder(ViewHolder viewholder, int i)
    {
        if (!isTablet && !isLandscape && i == 0 && (viewholder instanceof CollectionDescriptionViewHolder))
        {
            ((android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams)viewholder.itemView.getLayoutParams()).setFullSpan(true);
        }
        super.onBindViewHolder(viewholder, i);
    }

    public void updateHeaderFollowedInfo(boolean flag, int i)
    {
        followed = flag;
        if (isHeaderAdded)
        {
            CollectionDetailsPageHeaderViewModel collectiondetailspageheaderviewmodel = (CollectionDetailsPageHeaderViewModel)dataSet.remove(0);
            collectiondetailspageheaderviewmodel.isCollectionFollowed = followed;
            collectiondetailspageheaderviewmodel.followerCount = i;
            dataSet.add(0, collectiondetailspageheaderviewmodel);
            notifyDataSetChanged();
        }
    }

}
