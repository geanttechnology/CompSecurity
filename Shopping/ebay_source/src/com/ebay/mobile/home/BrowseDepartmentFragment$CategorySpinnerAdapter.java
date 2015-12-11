// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.ebay.mobile.util.ThemeUtil;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home:
//            BrowseDepartmentFragment

protected static class textColorPrimary extends ArrayAdapter
{

    private final int dropDownResource;
    private final LayoutInflater inflater;
    private final int textColorPrimary;

    public View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        View view1 = view;
        if (view == null)
        {
            view1 = inflater.inflate(dropDownResource, viewgroup, false);
        }
        view = (rtmentFragment.SpinnerSelection)getItem(i);
        viewgroup = (TextView)view1.findViewById(0x1020014);
        viewgroup.setText(view.toString());
        if (((rtmentFragment.SpinnerSelection) (view)).isSelected)
        {
            viewgroup.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0x7f0201c3, 0);
            viewgroup.setTextAppearance(getContext(), 0x7f0a0154);
            viewgroup.setTextColor(textColorPrimary);
            return view1;
        } else
        {
            viewgroup.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            viewgroup.setTextAppearance(getContext(), 0x7f0a013f);
            viewgroup.setTextColor(textColorPrimary);
            return view1;
        }
    }

    public (Context context, int i, int j, int k, List list)
    {
        super(context, i, j, list);
        setDropDownViewResource(k);
        inflater = LayoutInflater.from(context);
        dropDownResource = k;
        textColorPrimary = ThemeUtil.resolveThemeColor(context.getResources(), context.getTheme(), 0x1010036);
    }
}
