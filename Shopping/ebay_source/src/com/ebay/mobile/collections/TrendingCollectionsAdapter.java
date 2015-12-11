// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.collections;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import com.ebay.mobile.common.view.RecyclerContentAdapter;
import com.ebay.mobile.home.UssContentsViewAdapter;
import com.ebay.mobile.home.cards.DividerViewHolder;
import com.ebay.mobile.home.cards.DividerViewModel;
import com.ebay.nautilus.domain.data.UnifiedStream.Contents;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.collections:
//            CollectionViewHolder, CollectionViewModel

public class TrendingCollectionsAdapter extends RecyclerContentAdapter
    implements UssContentsViewAdapter
{

    public static final int SINGLE_COLUMN = 1;
    public static final int VIEW_TYPE_COLLECTION_LEFT_COLUMN = 1;
    public static final int VIEW_TYPE_COLLECTION_RIGHT_COLUMN = 2;
    public static final int VIEW_TYPE_COLLECTION_SINGLE_COLUMN = 0;
    public static final int VIEW_TYPE_ROW_DIVIDER = 3;
    private GridLayoutManager gridLayoutManager;
    private final Boolean isSubDepartment;
    private android.support.v7.widget.RecyclerView.LayoutManager linearLayoutManager;
    private List positionToGridSpanSize;

    public TrendingCollectionsAdapter(Context context, Boolean boolean1)
    {
        super(context);
        addViewType(0, com/ebay/mobile/collections/CollectionViewHolder, 0x7f0300d6);
        addViewType(1, com/ebay/mobile/collections/CollectionViewHolder, 0x7f0300d6);
        addViewType(2, com/ebay/mobile/collections/CollectionViewHolder, 0x7f0300d6);
        addViewType(3, com/ebay/mobile/home/cards/DividerViewHolder, 0x7f03004c);
        isSubDepartment = boolean1;
        positionToGridSpanSize = new ArrayList();
    }

    public android.support.v7.widget.RecyclerView.LayoutManager createLayoutManager()
    {
        if (isTablet || isLandscape)
        {
            if (gridLayoutManager == null)
            {
                gridLayoutManager = new GridLayoutManager((Context)contextReference.get(), getNumSpans(), 1, false);
                gridLayoutManager.setSpanSizeLookup(new android.support.v7.widget.GridLayoutManager.SpanSizeLookup() {

                    final TrendingCollectionsAdapter this$0;

                    public int getSpanSize(int i)
                    {
                        return ((Integer)positionToGridSpanSize.get(i)).intValue();
                    }

            
            {
                this$0 = TrendingCollectionsAdapter.this;
                super();
            }
                });
            }
            return gridLayoutManager;
        }
        if (linearLayoutManager == null)
        {
            linearLayoutManager = new LinearLayoutManager((Context)contextReference.get());
        }
        return linearLayoutManager;
    }

    public int getNumSpans()
    {
        return !isTablet && !isLandscape ? 1 : 2;
    }

    public void setContents(Contents contents)
    {
        dataSet.clear();
        positionToGridSpanSize.clear();
        if (contents != null && contents.contentGroups != null && contents.contentGroups.size() > 0)
        {
            contents = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup)contents.contentGroups.get(0)).contents;
            if (contents != null)
            {
                int k = contents.size();
                int j = 0;
                while (j < k) 
                {
                    Object obj;
                    int i;
                    boolean flag;
                    if (j == k - 1)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    obj = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)contents.get(j)).collection;
                    if (isTablet)
                    {
                        if (j % 2 == 0)
                        {
                            i = 1;
                        } else
                        {
                            i = 2;
                        }
                    } else
                    {
                        i = 0;
                    }
                    obj = new CollectionViewModel(i, ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Collection) (obj)), getOnClickListener(i));
                    obj.isCollectionOwnerShown = isSubDepartment.booleanValue();
                    if (!CollectionViewHolder.isValidModel(((com.ebay.mobile.common.view.ViewModel) (obj)), isTablet, isLandscape))
                    {
                        continue;
                    }
                    dataSet.add(obj);
                    positionToGridSpanSize.add(Integer.valueOf(1));
                    if (!flag && !isTablet || i == 2)
                    {
                        DividerViewModel dividerviewmodel = new DividerViewModel(3, null);
                        dataSet.add(dividerviewmodel);
                        positionToGridSpanSize.add(Integer.valueOf(getNumSpans()));
                    }
                    j++;
                }
            }
        }
        notifyDataSetChanged();
    }

}
