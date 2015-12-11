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
import java.util.ArrayList;

// Referenced classes of package com.amazon.retailsearch.android.fastBrowse:
//            FastBrowseItem

public class FastBrowseListAdapter extends BaseAdapter
{

    private static final int TXT_NORMAL_SIZE = 15;
    private static final int TXT_SMALL_SIZE = 13;
    private Context context;
    private int currentLayer;
    private ArrayList fastBrowseItems;

    public FastBrowseListAdapter(Context context1, ArrayList arraylist, int i)
    {
        context = context1;
        fastBrowseItems = arraylist;
        currentLayer = i;
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
        View view1 = view;
        if (view == null)
        {
            view1 = LayoutInflater.from(context).inflate(com.amazon.retailsearch.R.layout.rs_right_sliding_menu_items, viewgroup, false);
        }
        view = (ImageView)view1.findViewById(com.amazon.retailsearch.R.id.sliding_menu_icon);
        viewgroup = (TextView)view1.findViewById(com.amazon.retailsearch.R.id.sliding_menu_title);
        View view2 = view1.findViewById(com.amazon.retailsearch.R.id.sliding_menu_gap);
        view.setImageResource(((FastBrowseItem)fastBrowseItems.get(i)).getIcon());
        viewgroup.setText(((FastBrowseItem)fastBrowseItems.get(i)).getTitle());
        if (i < currentLayer)
        {
            view.setVisibility(0);
            view2.setVisibility(8);
        } else
        if (i == currentLayer)
        {
            view.setVisibility(8);
            view2.setVisibility(0);
        } else
        {
            view.setVisibility(4);
            view2.setVisibility(8);
        }
        if (currentLayer == i)
        {
            viewgroup.getPaint().setFakeBoldText(true);
            viewgroup.setTextSize(15F);
            viewgroup.setTextColor(context.getResources().getColorStateList(com.amazon.retailsearch.R.drawable.rs_right_menu_text_selected));
            view1.setClickable(true);
        } else
        {
            viewgroup.getPaint().setFakeBoldText(false);
            viewgroup.setTextSize(13F);
            viewgroup.setTextColor(context.getResources().getColorStateList(com.amazon.retailsearch.R.drawable.rs_right_menu_text_previous));
            view1.setClickable(false);
        }
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            view1.setBackground(context.getResources().getDrawable(com.amazon.retailsearch.R.drawable.rs_list_selector));
            return view1;
        } else
        {
            view1.setBackgroundDrawable(context.getResources().getDrawable(com.amazon.retailsearch.R.drawable.rs_list_selector));
            return view1;
        }
    }

    public void setCurrentLayer(int i)
    {
        currentLayer = i;
    }
}
