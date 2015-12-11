// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.utils.ViewUtils;
import java.util.List;

public class MetaItemSpinAdapter extends ArrayAdapter
{

    private Context context;
    private String hintString;
    private boolean showCustomOption;
    private List values;

    public MetaItemSpinAdapter(Context context1, int i, List list, String s, boolean flag)
    {
        super(context1, i, list);
        context = context1;
        values = list;
        hintString = s;
        showCustomOption = flag;
    }

    public int getCount()
    {
        int j = 0;
        if (values != null)
        {
            j = values.size();
        }
        int i = j;
        if (hintString != null)
        {
            i = j + 1;
        }
        j = i;
        if (showCustomOption)
        {
            j = i + 1;
        }
        return j;
    }

    public View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        view = new TextView(context);
        view.setBackgroundColor(getContext().getResources().getColor(0x7f090015));
        view.setTextColor(getContext().getResources().getColor(0x7f090035));
        view.setTextSize(13F);
        int j = (int)ViewUtils.dipToPixels(getContext(), 10F);
        view.setPadding(j, j, j, j);
        j = i;
        int k = j;
        if (hintString != null)
        {
            k = j - 1;
        }
        if (i == 0)
        {
            view.setText("");
            return view;
        }
        if (values != null && k < values.size())
        {
            view.setText(((MetaItem)values.get(k)).getDisplay());
            return view;
        } else
        {
            view.setText("");
            return view;
        }
    }

    public MetaItem getItem(int i)
    {
        int j = i;
        if (hintString != null)
        {
            j = i - 1;
        }
        if (j >= 0 && values != null && j < values.size())
        {
            return (MetaItem)values.get(j);
        } else
        {
            return null;
        }
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        view = new TextView(context);
        view.setBackgroundColor(0);
        view.setTextSize(13F);
        int j = i;
        int k = j;
        if (hintString != null)
        {
            k = j - 1;
        }
        if (hintString != null && i == 0)
        {
            view.setTextColor(getContext().getResources().getColor(0x7f090039));
            view.setText(hintString);
        } else
        {
            view.setTextColor(getContext().getResources().getColor(0x7f090035));
            if (values != null && k < values.size())
            {
                view.setText(((MetaItem)values.get(k)).getDisplay());
                return view;
            }
        }
        return view;
    }
}
