// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell.lists;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ebay.mobile.widget.CompositeArrayRecyclerAdapter;
import java.util.List;

// Referenced classes of package com.ebay.mobile.sell.lists:
//            SellListBaseViewHolder, ListingDraftViewHolder, ActiveListViewHolder, SoldListViewHolder, 
//            UnsoldListViewHolder, ScheduledListViewHolder

public class SellListAdapter extends CompositeArrayRecyclerAdapter
    implements SellListBaseViewHolder.OnViewHolderClickListener
{
    public static interface OnItemClickListener
    {

        public abstract void onItemClicked(int i);
    }

    static class SellHeaderViewHolder extends com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.HeaderViewHolder
    {

        protected void onBindView(int i, CharSequence charsequence)
        {
            super.onBindView(i, charsequence);
            if (!TextUtils.isEmpty(charsequence))
            {
                textView.setVisibility(0);
                itemView.findViewById(0x7f1001a6).setVisibility(0);
                return;
            } else
            {
                textView.setVisibility(8);
                itemView.findViewById(0x7f1001a6).setVisibility(8);
                return;
            }
        }

        public SellHeaderViewHolder(View view)
        {
            super(view);
        }
    }


    private final LayoutInflater inflater;
    private final OnItemClickListener itemClickListener;
    private com.ebay.mobile.common.ListSelector.ListItemSelector itemSelector;
    private final SellingListActivity.ListType listType;
    private final int resourceId;

    public SellListAdapter(Context context, int i, int j, OnItemClickListener onitemclicklistener, SellingListActivity.ListType listtype)
    {
        super(context, i, j);
        resourceId = i;
        inflater = (LayoutInflater)context.getSystemService("layout_inflater");
        itemClickListener = onitemclicklistener;
        listType = listtype;
    }

    protected boolean isSelected(Object obj)
    {
        if (itemSelector == null || obj == null)
        {
            return false;
        } else
        {
            return itemSelector.isSelected(obj);
        }
    }

    protected boolean isSelectionEnabled()
    {
        if (itemSelector == null)
        {
            return false;
        } else
        {
            return itemSelector.getIsSelectionEnabled();
        }
    }

    public volatile void onBindViewHolder(android.support.v7.widget.RecyclerView.ViewHolder viewholder, int i)
    {
        onBindViewHolder((com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.BaseViewHolder)viewholder, i);
    }

    public void onBindViewHolder(com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.BaseViewHolder baseviewholder, int i)
    {
        super.onBindViewHolder(baseviewholder, i);
        if (!(baseviewholder instanceof SellListBaseViewHolder)) goto _L2; else goto _L1
_L1:
        Object obj;
        com.ebay.nautilus.shell.widget.CompositeArrayAdapter.Section section;
        int j;
        obj = getItem(i);
        j = 0x7f020268;
        section = getSectionFromItemPosition(i);
        ((SellListBaseViewHolder)baseviewholder).setSelected(isSelectionEnabled(), isSelected(obj));
        if (section == null || section.loadedItems <= 0) goto _L2; else goto _L3
_L3:
        if (section.totalItems != 1) goto _L5; else goto _L4
_L4:
        i = 0x7f020266;
_L7:
        ((SellListBaseViewHolder)baseviewholder).setBackground(getContext().getResources().getDrawable(i));
_L2:
        return;
_L5:
        if (obj == section.list.get(0))
        {
            i = 0x7f020269;
        } else
        {
            i = j;
            if (obj == section.list.get(section.loadedItems - 1))
            {
                i = 0x7f020267;
            }
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    public com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.HeaderViewHolder onCreateHeaderViewHolder(ViewGroup viewgroup)
    {
        return new SellHeaderViewHolder(inflater.inflate(0x7f03020d, viewgroup, false));
    }

    public com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.ItemViewHolder onCreateItemViewHolder(ViewGroup viewgroup)
    {
        viewgroup = inflater.inflate(resourceId, viewgroup, false);
        static class _cls2
        {

            static final int $SwitchMap$com$ebay$mobile$sell$lists$SellingListActivity$ListType[];

            static 
            {
                $SwitchMap$com$ebay$mobile$sell$lists$SellingListActivity$ListType = new int[SellingListActivity.ListType.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$sell$lists$SellingListActivity$ListType[SellingListActivity.ListType.ACTIVE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$sell$lists$SellingListActivity$ListType[SellingListActivity.ListType.SOLD.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$sell$lists$SellingListActivity$ListType[SellingListActivity.ListType.UNSOLD.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$sell$lists$SellingListActivity$ListType[SellingListActivity.ListType.SCHEDULED.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$sell$lists$SellingListActivity$ListType[SellingListActivity.ListType.DRAFT.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls2..SwitchMap.com.ebay.mobile.sell.lists.SellingListActivity.ListType[listType.ordinal()])
        {
        default:
            return new ListingDraftViewHolder(viewgroup, this);

        case 1: // '\001'
            return new ActiveListViewHolder(viewgroup, this);

        case 2: // '\002'
            return new SoldListViewHolder(viewgroup, this);

        case 3: // '\003'
            return new UnsoldListViewHolder(viewgroup, this);

        case 4: // '\004'
            return new ScheduledListViewHolder(viewgroup, this);

        case 5: // '\005'
            return new ListingDraftViewHolder(viewgroup, this);
        }
    }

    public void onViewHolderClick(int i)
    {
        if (isSelectionEnabled())
        {
            toggleSelection(getItem(i));
            notifyItemChanged(i);
            return;
        } else
        {
            itemClickListener.onItemClicked(i);
            return;
        }
    }

    public void setItemSelector(com.ebay.mobile.common.ListSelector.ListItemSelector listitemselector)
    {
        if (listitemselector == null)
        {
            return;
        } else
        {
            itemSelector = listitemselector;
            itemSelector.setOnSelectionModeChangeListener(new com.ebay.mobile.common.ListSelector.OnSelectionModeChangeListener() {

                final SellListAdapter this$0;

                public void onSelectionModeChanged(boolean flag)
                {
                    for (int i = 0; i < getItemCount(); i++)
                    {
                        notifyItemChanged(i);
                    }

                }

            
            {
                this$0 = SellListAdapter.this;
                super();
            }
            });
            return;
        }
    }

    protected void toggleSelection(Object obj)
    {
        if (itemSelector == null || obj == null)
        {
            return;
        } else
        {
            itemSelector.toggleSelection(obj);
            return;
        }
    }
}
