// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.events;

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

// Referenced classes of package com.ebay.mobile.events:
//            EventViewHolder, EventGroupViewHolder, EventGroupViewModel, EventViewModel

public class EventsAdapter extends RecyclerContentAdapter
    implements UssContentsViewAdapter
{

    public static final int VIEW_TYPE_EVENT_HEADER = 2;
    public static final int VIEW_TYPE_EVENT_NORMAL = 0;
    public static final int VIEW_TYPE_EVENT_WIDE = 1;
    public static final int VIEW_TYPE_ROW_DIVIDER = 3;
    private GridLayoutManager gridLayoutManager;
    private android.support.v7.widget.RecyclerView.LayoutManager linearLayoutManager;
    private List positionToGridSpanSize;

    public EventsAdapter(Context context)
    {
        super(context);
        addViewType(0, com/ebay/mobile/events/EventViewHolder, 0x7f030055);
        addViewType(1, com/ebay/mobile/events/EventViewHolder, 0x7f030055);
        addViewType(2, com/ebay/mobile/events/EventGroupViewHolder, 0x7f03002e);
        addViewType(3, com/ebay/mobile/home/cards/DividerViewHolder, 0x7f03004c);
        positionToGridSpanSize = new ArrayList();
    }

    private void addDivider()
    {
        DividerViewModel dividerviewmodel = new DividerViewModel(3, null);
        dataSet.add(dividerviewmodel);
        positionToGridSpanSize.add(Integer.valueOf(getNumSpans()));
    }

    public android.support.v7.widget.RecyclerView.LayoutManager createLayoutManager()
    {
        if (isTablet || isLandscape)
        {
            if (gridLayoutManager == null)
            {
                gridLayoutManager = new GridLayoutManager((Context)contextReference.get(), getNumSpans(), 1, false);
                gridLayoutManager.setSpanSizeLookup(new android.support.v7.widget.GridLayoutManager.SpanSizeLookup() {

                    final EventsAdapter this$0;

                    public int getSpanSize(int i)
                    {
                        return ((Integer)positionToGridSpanSize.get(i)).intValue();
                    }

            
            {
                this$0 = EventsAdapter.this;
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
        int i;
        int j1;
        dataSet.clear();
        positionToGridSpanSize.clear();
        if (contents == null || contents.contentGroups == null || contents.contentGroups.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_487;
        }
        contents = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup)contents.contentGroups.get(0)).contents;
        if (contents == null)
        {
            break MISSING_BLOCK_LABEL_487;
        }
        j1 = contents.size();
        i = 0;
_L7:
        if (i >= j1) goto _L2; else goto _L1
_L1:
        boolean flag;
        boolean flag1;
        int j;
        boolean flag2;
        int k;
        int l;
        boolean flag5;
        int i1;
        boolean flag6;
        com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.RppEventGroup rppeventgroup = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)contents.get(i)).rppEventGroup;
        if (rppeventgroup == null || rppeventgroup.rppEvents.size() <= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        Object obj = new EventGroupViewModel(2, rppeventgroup, null);
        if (EventGroupViewHolder.isValidModel(((com.ebay.mobile.common.view.ViewModel) (obj)), isTablet, isLandscape))
        {
            dataSet.add(obj);
            positionToGridSpanSize.add(Integer.valueOf(getNumSpans()));
        }
        obj = rppeventgroup.rppEvents;
        int k1 = ((List) (obj)).size();
        Object obj1;
        boolean flag3;
        if (k1 % 2 == 1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        j = 0;
        if (j >= k1)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (j == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (j == k1 - 1)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        obj1 = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.RppEvent)((List) (obj)).get(j);
        i1 = 0;
        flag6 = true;
        flag5 = false;
        if (!isTablet || !flag || !flag1) goto _L4; else goto _L3
_L3:
        flag3 = true;
        i1 = getNumSpans();
        k = ((flag3) ? 1 : 0);
        flag = flag5;
        l = i1;
        if (!flag2)
        {
            flag = true;
            l = i1;
            k = ((flag3) ? 1 : 0);
        }
_L6:
        obj1 = new EventViewModel(k, ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.RppEvent) (obj1)), rppeventgroup.groupId, isTablet, getOnClickListener(k));
        dataSet.add(obj1);
        positionToGridSpanSize.add(Integer.valueOf(l));
        if (flag)
        {
            addDivider();
        }
        j++;
        break MISSING_BLOCK_LABEL_190;
_L4:
        boolean flag4;
        if (j % 2 == 0)
        {
            flag4 = true;
        } else
        {
            flag4 = false;
        }
        k = i1;
        flag = flag5;
        l = ((flag6) ? 1 : 0);
        if (flag2)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (isTablet && (!flag1 || !flag4))
        {
            k = i1;
            flag = flag5;
            l = ((flag6) ? 1 : 0);
            if (flag1)
            {
                continue; /* Loop/switch isn't completed */
            }
            k = i1;
            flag = flag5;
            l = ((flag6) ? 1 : 0);
            if (flag4)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        flag = true;
        k = i1;
        l = ((flag6) ? 1 : 0);
        if (true) goto _L6; else goto _L5
_L5:
        i++;
          goto _L7
_L2:
        notifyDataSetChanged();
        return;
    }

}
