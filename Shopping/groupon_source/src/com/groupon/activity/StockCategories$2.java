// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.groupon.db.models.StockCategory;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            StockCategories

class this._cls0 extends ArrayAdapter
{

    final StockCategories this$0;

    public View getDropDownView(int i, View view, ViewGroup viewgroup)
    {
        StockCategory stockcategory = (StockCategory)getItem(i);
        viewgroup = view;
        if (view == null)
        {
            viewgroup = StockCategories.access$300(StockCategories.this).inflate(0x7f030207, null, false);
        }
        view = (TextView)viewgroup;
        view.setText(stockcategory.name);
        return view;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        StockCategory stockcategory = (StockCategory)getItem(i);
        viewgroup = view;
        if (view == null)
        {
            viewgroup = StockCategories.access$300(StockCategories.this).inflate(0x7f03020a, null, false);
        }
        view = (TextView)viewgroup;
        view.setText(stockcategory.name);
        return view;
    }

    (Context context, int i, List list)
    {
        this$0 = StockCategories.this;
        super(context, i, list);
    }
}
