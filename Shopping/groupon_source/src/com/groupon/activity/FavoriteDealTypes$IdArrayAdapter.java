// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.groupon.service.DealTypeService;
import com.groupon.view.FavoriteDealTypeItem;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            FavoriteDealTypes

private class names extends ArrayAdapter
{

    private final List allIds;
    private final List names;
    final FavoriteDealTypes this$0;

    public int getCount()
    {
        return allIds.size();
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public String getItem(int i)
    {
        return (String)allIds.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view instanceof FavoriteDealTypeItem)
        {
            view = (FavoriteDealTypeItem)view;
        } else
        {
            view = new FavoriteDealTypeItem(getContext());
        }
        viewgroup = getItem(i);
        view.setClickable(false);
        view.setTypeId(viewgroup);
        view.setTypeName((CharSequence)names.get(i));
        view.setHostPageValue(2);
        view.setTextColor(Color.rgb(51, 51, 51));
        view.setTooltipPaddingX(6);
        if (FavoriteDealTypes.access$200(FavoriteDealTypes.this).doesUserHaveDealTypeInFavoriteList(viewgroup))
        {
            viewgroup = com.groupon.view.n;
        } else
        {
            viewgroup = com.groupon.view.ff;
        }
        view.setState(viewgroup);
        return view;
    }

    public (List list, List list1)
    {
        this$0 = FavoriteDealTypes.this;
        super(FavoriteDealTypes.this, 0x7f0300db, 0x7f100284, list);
        allIds = list;
        names = list1;
    }
}
