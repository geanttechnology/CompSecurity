// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.groupon.models.search.domain.SortMethod;
import com.groupon.models.search.domain.SortMethodWrapper;
import java.util.ArrayList;
import java.util.List;
import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

// Referenced classes of package com.groupon.adapter:
//            OnFilterSheetItemClickListener

public class SortMethodAdapter extends BaseAdapter
    implements StickyListHeadersAdapter
{
    private static class SortMethodHeaderViewHolder
    {

        TextView headerText;

        private SortMethodHeaderViewHolder()
        {
        }

    }

    private static class SortMethodValueViewHolder
    {

        final CompoundButton radioButton;

        public SortMethodValueViewHolder(View view)
        {
            radioButton = (CompoundButton)view.findViewById(0x7f100296);
        }
    }


    private final LayoutInflater inflater;
    private OnFilterSheetItemClickListener onFilterSheetItemClickListener;
    private List sortMethods;

    public SortMethodAdapter(Context context, List list, OnFilterSheetItemClickListener onfiltersheetitemclicklistener)
    {
        sortMethods = new ArrayList();
        sortMethods = list;
        onFilterSheetItemClickListener = onfiltersheetitemclicklistener;
        inflater = LayoutInflater.from(context);
    }

    private String getStringResourceForSortMethod(Context context, SortMethod sortmethod)
    {
        if (sortmethod == com.groupon.models.search.domain.SortMethod.Methods.RELEVANCE)
        {
            return context.getString(0x7f0801c1);
        }
        if (sortmethod == com.groupon.models.search.domain.SortMethod.Methods.DISTANCE)
        {
            return context.getString(0x7f0801bd);
        }
        if (sortmethod == com.groupon.models.search.domain.SortMethod.Methods.PRICE_ASC)
        {
            return context.getString(0x7f0801bf);
        }
        if (sortmethod == com.groupon.models.search.domain.SortMethod.Methods.PRICE_DESC)
        {
            return context.getString(0x7f0801c0);
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unknown sort method '").append(sortmethod.id).append("'").toString());
        }
    }

    public int getCount()
    {
        return sortMethods.size();
    }

    public long getHeaderId(int i)
    {
        return 0L;
    }

    public View getHeaderView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = inflater.inflate(0x7f0300e3, viewgroup, false);
            viewgroup = new SortMethodHeaderViewHolder();
            viewgroup.headerText = (TextView)view.findViewById(0x7f100292);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (SortMethodHeaderViewHolder)view.getTag();
        }
        ((SortMethodHeaderViewHolder) (viewgroup)).headerText.setText(view.getContext().getString(0x7f0801be));
        return view;
    }

    public Object getItem(int i)
    {
        return sortMethods.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        final SortMethodWrapper sortMethodWrapper = (SortMethodWrapper)sortMethods.get(i);
        View view1 = view;
        if (view == null)
        {
            view1 = inflater.inflate(0x7f0300e5, viewgroup, false);
            view1.setTag(new SortMethodValueViewHolder(view1));
        }
        view = (SortMethodValueViewHolder)view1.getTag();
        ((SortMethodValueViewHolder) (view)).radioButton.setText(getStringResourceForSortMethod(view1.getContext(), sortMethodWrapper.sortMethod));
        ((SortMethodValueViewHolder) (view)).radioButton.setOnCheckedChangeListener(null);
        ((SortMethodValueViewHolder) (view)).radioButton.setChecked(sortMethodWrapper.isSelected);
        ((SortMethodValueViewHolder) (view)).radioButton.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final SortMethodAdapter this$0;
            final SortMethodWrapper val$sortMethodWrapper;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (onFilterSheetItemClickListener != null)
                {
                    onFilterSheetItemClickListener.onSortMethodSelected(sortMethodWrapper);
                }
            }

            
            {
                this$0 = SortMethodAdapter.this;
                sortMethodWrapper = sortmethodwrapper;
                super();
            }
        });
        return view1;
    }

    public void setSortMethods(List list)
    {
        sortMethods = list;
    }

}
