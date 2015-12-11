// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.flyinmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

// Referenced classes of package com.xfinity.playerlib.view.flyinmenu:
//            FlyinMenuOptions

public class FlyinMenuAdapter extends BaseAdapter
{
    private static class Holder
    {

        protected TextView menuImageAndCaption;

        private Holder()
        {
        }

    }


    private Context context;
    private List menuItems;

    public FlyinMenuAdapter(Context context1, List list)
    {
        context = context1;
        menuItems = list;
    }

    public int getCount()
    {
        return menuItems.size();
    }

    public FlyinMenuOptions getItem(int i)
    {
        return (FlyinMenuOptions)menuItems.get(i);
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = ((LayoutInflater)context.getSystemService("layout_inflater")).inflate(com.xfinity.playerlib.R.layout.flyin_menu_list_item, null);
            viewgroup = new Holder();
            viewgroup.menuImageAndCaption = (TextView)view.findViewById(com.xfinity.playerlib.R.id.text1);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (Holder)view.getTag();
        }
        ((Holder) (viewgroup)).menuImageAndCaption.setText(((FlyinMenuOptions)menuItems.get(i)).getCaption(context));
        ((Holder) (viewgroup)).menuImageAndCaption.setCompoundDrawablesWithIntrinsicBounds(((FlyinMenuOptions)menuItems.get(i)).getDrawable(context), null, null, null);
        return view;
    }
}
