// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.groupon.Channel;
import com.groupon.models.category.Category;
import com.groupon.util.CategoriesUtil;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            GrouponListActivity

public abstract class CategoriesBase extends GrouponListActivity
{
    protected abstract class CategoriesBaseAdapter extends ArrayAdapter
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

        public CategoriesBaseAdapter(Context context)
        {
            this$0 = CategoriesBase.this;
            super(context, 0x1090006);
            inflater = (LayoutInflater)context.getSystemService("layout_inflater");
            categories = new ArrayList();
        }
    }


    public static final int REQUEST_CODE = 10101;
    protected CategoriesBaseAdapter categoriesAdapter;
    protected CategoriesUtil categoriesUtil;
    ListView listView;
    ProgressBar progress;

    public CategoriesBase()
    {
    }

    protected String getActionBarTitle()
    {
        return getString(0x7f0800a4);
    }

    protected abstract CategoriesBaseAdapter getCategoriesAdapter();

    protected String getCategoryFacetGroupFiltersKey()
    {
        return (new StringBuilder()).append(getChannel()).append("categoryFacetGroupFilters").toString();
    }

    protected String getCategoryIdKey()
    {
        return (new StringBuilder()).append(getChannel()).append("categoryId").toString();
    }

    protected String getCategoryModeKey()
    {
        return (new StringBuilder()).append(getChannel()).append("categoryMode").toString();
    }

    protected String getCategoryNameKey()
    {
        return (new StringBuilder()).append(getChannel()).append("categoryName").toString();
    }

    protected abstract Channel getChannel();

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setToolbarTitle(getActionBarTitle());
    }

    protected abstract void onCategoryClick(int i);

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03005d);
        setup();
    }

    protected abstract void setUpCategories();

    protected void setup()
    {
        listView.setEmptyView(progress);
        categoriesAdapter = getCategoriesAdapter();
        setUpCategories();
        listView.setAdapter(categoriesAdapter);
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final CategoriesBase this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                onCategoryClick(i);
            }

            
            {
                this$0 = CategoriesBase.this;
                super();
            }
        });
    }
}
