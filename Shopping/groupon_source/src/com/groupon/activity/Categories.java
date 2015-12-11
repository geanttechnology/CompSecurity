// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.groupon.Channel;
import com.groupon.models.category.Category;
import com.groupon.tracking.mobile.sdk.Logger;
import java.util.List;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.activity:
//            CategoriesBase

public abstract class Categories extends CategoriesBase
{
    protected class CategoriesAdapter extends CategoriesBase.CategoriesBaseAdapter
    {

        final Categories this$0;

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            viewgroup = view;
            if (view == null)
            {
                viewgroup = inflater.inflate(0x7f03005f, null);
            }
            view = (TextView)viewgroup.findViewById(0x7f100188);
            Category category = getItem(i);
            if (category == null)
            {
                view.setText(0x7f08005e);
                return viewgroup;
            } else
            {
                view.setText(category.name);
                return viewgroup;
            }
        }

        public CategoriesAdapter(Context context)
        {
            this$0 = Categories.this;
            super(Categories.this, context);
        }
    }


    private Logger logger;
    private SharedPreferences prefs;

    public Categories()
    {
    }

    protected CategoriesBase.CategoriesBaseAdapter getCategoriesAdapter()
    {
        return new CategoriesAdapter(this);
    }

    protected void onCategoriesSuccess(List list)
    {
        categoriesAdapter.setCategories(list);
        (new Handler()).post(new Runnable() {

            final Categories this$0;

            public void run()
            {
                if (categoriesAdapter != null)
                {
                    categoriesAdapter.notifyDataSetChanged();
                }
            }

            
            {
                this$0 = Categories.this;
                super();
            }
        });
        if (list != null)
        {
            list = Integer.valueOf(list.size());
        } else
        {
            list = "null";
        }
        Ln.d("Categories:%s", new Object[] {
            list
        });
    }

    protected void onCategoryClick(int i)
    {
        setResult(-1);
        setResultToPrefs(i);
        finish();
    }

    protected void removeCategoryFromPrefs()
    {
        prefs.edit().putString(getCategoryModeKey(), com.groupon.models.FilterCategory.Mode.EVERYTHING.toString()).remove(getCategoryNameKey()).remove(getCategoryIdKey()).remove(getCategoryFacetGroupFiltersKey()).apply();
    }

    protected void saveCategoryToPrefs(String s, String s1)
    {
        prefs.edit().putString(getCategoryModeKey(), com.groupon.models.FilterCategory.Mode.SELECTION.toString()).putString(getCategoryNameKey(), s1).putString(getCategoryIdKey(), s).putString(getCategoryFacetGroupFiltersKey(), "").apply();
    }

    protected void setResultToPrefs(int i)
    {
        Category category = categoriesAdapter.getItem(i);
        if (category == null)
        {
            removeCategoryFromPrefs();
            logger.logClick("", "category_click", getChannel().toString(), getResources().getString(0x7f08005e));
            return;
        } else
        {
            String s = category.id;
            saveCategoryToPrefs(s, category.name);
            logger.logClick("", "category_click", getChannel().toString(), s);
            return;
        }
    }
}
