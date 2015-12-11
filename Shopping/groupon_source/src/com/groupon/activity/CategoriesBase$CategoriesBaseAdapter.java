// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import com.groupon.models.category.Category;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            CategoriesBase

protected abstract class categories extends ArrayAdapter
{

    private List categories;
    protected LayoutInflater inflater;
    final CategoriesBase this$0;

    public int getCount()
    {
        return categories.size() + 1;
    }

    public Category getItem(int i)
    {
        if (i == 0)
        {
            return null;
        } else
        {
            return (Category)categories.get(i - 1);
        }
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public int getItemViewType(int i)
    {
        return 0;
    }

    public int getViewTypeCount()
    {
        return 1;
    }

    public void setCategories(List list)
    {
        categories = list;
    }

    public (Context context)
    {
        this$0 = CategoriesBase.this;
        super(context, 0x1090006);
        inflater = (LayoutInflater)context.getSystemService("layout_inflater");
        categories = new ArrayList();
    }
}
