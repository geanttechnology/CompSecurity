// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.fastBrowse;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.fastBrowse:
//            FastBrowseItem

public class FastBrowseItemAdapter extends BaseAdapter
{
    private static class ItemHolder
    {

        private View divider;
        private View gap;
        private ImageView imgIcon;
        private TextView txtTitle;



/*
        static ImageView access$102(ItemHolder itemholder, ImageView imageview)
        {
            itemholder.imgIcon = imageview;
            return imageview;
        }

*/



/*
        static TextView access$202(ItemHolder itemholder, TextView textview)
        {
            itemholder.txtTitle = textview;
            return textview;
        }

*/



/*
        static View access$302(ItemHolder itemholder, View view)
        {
            itemholder.gap = view;
            return view;
        }

*/



/*
        static View access$402(ItemHolder itemholder, View view)
        {
            itemholder.divider = view;
            return view;
        }

*/

        private ItemHolder()
        {
        }

    }


    private Context context;
    private int currentLayer;
    private List fastBrowseItems;
    private int normaltextSize;
    private int selectedTextSize;

    public FastBrowseItemAdapter(Context context1, List list, int i)
    {
        context = context1;
        fastBrowseItems = list;
        currentLayer = i;
        normaltextSize = (int)context1.getResources().getDimension(com.amazon.retailsearch.R.dimen.rs_fast_browse_item_text_size);
        selectedTextSize = (int)context1.getResources().getDimension(com.amazon.retailsearch.R.dimen.rs_fast_browse_item_selected_text_size);
    }

    public int getCount()
    {
        return fastBrowseItems.size();
    }

    public int getCurrentLayer()
    {
        return currentLayer;
    }

    public Object getItem(int i)
    {
        return fastBrowseItems.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            ItemHolder itemholder = new ItemHolder();
            view = LayoutInflater.from(context).inflate(com.amazon.retailsearch.R.layout.rs_fast_browse_menu_item, viewgroup, false);
            itemholder.imgIcon = (ImageView)view.findViewById(com.amazon.retailsearch.R.id.sliding_menu_icon);
            itemholder.txtTitle = (TextView)view.findViewById(com.amazon.retailsearch.R.id.sliding_menu_title);
            itemholder.gap = view.findViewById(com.amazon.retailsearch.R.id.sliding_menu_gap);
            itemholder.divider = view.findViewById(com.amazon.retailsearch.R.id.divider);
            view.setTag(itemholder);
            viewgroup = itemholder;
        } else
        {
            viewgroup = (ItemHolder)view.getTag();
        }
        ((ItemHolder) (viewgroup)).txtTitle.setText(((FastBrowseItem)fastBrowseItems.get(i)).getTitle());
        i--;
        if (i < currentLayer)
        {
            ((ItemHolder) (viewgroup)).imgIcon.setVisibility(0);
            ((ItemHolder) (viewgroup)).gap.setVisibility(8);
            ((ItemHolder) (viewgroup)).divider.setVisibility(0);
        } else
        if (i == currentLayer)
        {
            ((ItemHolder) (viewgroup)).imgIcon.setVisibility(8);
            ((ItemHolder) (viewgroup)).gap.setVisibility(0);
            ((ItemHolder) (viewgroup)).divider.setVisibility(8);
        } else
        {
            ((ItemHolder) (viewgroup)).imgIcon.setVisibility(4);
            ((ItemHolder) (viewgroup)).gap.setVisibility(8);
            ((ItemHolder) (viewgroup)).divider.setVisibility(8);
        }
        if (currentLayer == i)
        {
            ((ItemHolder) (viewgroup)).txtTitle.getPaint().setFakeBoldText(true);
            ((ItemHolder) (viewgroup)).txtTitle.setTextSize(0, selectedTextSize);
            ((ItemHolder) (viewgroup)).txtTitle.setTextColor(context.getResources().getColorStateList(com.amazon.retailsearch.R.drawable.rs_right_menu_text_selected));
            view.setClickable(true);
            return view;
        } else
        {
            ((ItemHolder) (viewgroup)).txtTitle.getPaint().setFakeBoldText(false);
            ((ItemHolder) (viewgroup)).txtTitle.setTextSize(0, normaltextSize);
            ((ItemHolder) (viewgroup)).txtTitle.setTextColor(context.getResources().getColorStateList(com.amazon.retailsearch.R.drawable.rs_right_menu_text_previous));
            view.setClickable(false);
            return view;
        }
    }

    public void setCurrentLayer(int i)
    {
        currentLayer = i;
    }
}
