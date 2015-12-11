// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.groupon.Channel;
import com.groupon.abtest.SnapAbTestHelper;
import com.groupon.activity.GlobalSearch;
import com.groupon.models.category.Category;
import com.groupon.models.nst.SnapGroceryGenericMetadata;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.LoggingUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

public class GlobalCategoriesAdapter extends BaseAdapter
{
    private static class CategoryViewHolder
    {

        ImageView categoryExpandImg;
        TextView categoryNameTv;

        private CategoryViewHolder()
        {
        }

    }


    private static final String ACTION_CLOSE = "close";
    private static final String ACTION_EXPAND = "expand";
    private static final String CATEGORY_CLICK = "category_click";
    private static final String CATEGORY_LEVEL_2 = "L2";
    private static final String GROCERY_ID_NAME = "groceries";
    public static final String GROCERY_SEARCH_ALL_IMPRESSION = "groceries_search_all_impression";
    private LinkedList categories;
    private android.view.View.OnClickListener categoriesClickListener;
    private Drawable collapsedArrow;
    private final Map dataOriginal = new HashMap();
    private Drawable expandedArrow;
    private LinkedList expandedCategories;
    private final LayoutInflater inflater;
    private boolean isBrowseByCategory;
    private Logger logger;
    private LoggingUtils loggingUtils;
    private Map parentToDeals;
    private final Resources resources;
    private SnapAbTestHelper snapAbTestHelper;

    public GlobalCategoriesAdapter(Context context)
    {
        inflater = LayoutInflater.from(context);
        resources = context.getResources();
        RoboGuice.getInjector(context).injectMembers(this);
        expandedArrow = context.getResources().getDrawable(0x7f020046);
        collapsedArrow = context.getResources().getDrawable(0x7f020042);
    }

    public void addDataSet(Category category, Category category1, Map map)
    {
        Category category2;
        for (Iterator iterator = map.keySet().iterator(); iterator.hasNext(); dataOriginal.put(category2, map.get(category2)))
        {
            category2 = (Category)iterator.next();
        }

        if (categories == null)
        {
            categories = new LinkedList();
        }
        if (parentToDeals == null)
        {
            parentToDeals = new HashMap();
        }
        if (snapAbTestHelper.isSnapEntryPointSearchEnabled() && Strings.equals(category.id, "local"))
        {
            String s = resources.getString(0x7f0804e1);
            Category category3 = new Category();
            category3.id = "groceries";
            category3.friendlyName = s;
            category3.friendlyNameShort = s;
            category3.name = "groceries";
            categories.add(category3);
        }
        parentToDeals.put(category, category1);
        ArrayList arraylist = new ArrayList();
        map = map.keySet().iterator();
        do
        {
            if (!map.hasNext())
            {
                break;
            }
            Category category4 = (Category)map.next();
            category4.relevanceContext = category1.relevanceContext;
            if (!category4.isSubcategory)
            {
                arraylist.add(category4);
            }
        } while (true);
        if (Strings.equals(category.id, "local"))
        {
            categories.add(0, category);
            categories.add(1, category1);
            categories.addAll(2, arraylist);
            return;
        } else
        {
            categories.add(category);
            categories.add(category1);
            categories.addAll(arraylist);
            return;
        }
    }

    public void addRemoveCategory(Category category)
    {
        if (isExpanded(category))
        {
            collapseCategory(category);
            return;
        } else
        {
            expandCategory(category);
            return;
        }
    }

    protected void addSubcategories(Category category)
    {
        if (!category.isParent() && category.equals(parentToDeals.get(category.parent)) || category.equals(parentToDeals.get(category.parent)))
        {
            reset();
            return;
        }
        Object obj = (List)dataOriginal.get(category);
        if (obj != null && !((List) (obj)).isEmpty())
        {
            category.hasSubcategories = true;
            Category category1;
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); expandedCategories.add(category1))
            {
                category1 = (Category)((Iterator) (obj)).next();
                category1.isSubcategory = true;
                category1.relevanceContext = category.relevanceContext;
            }

        }
        notifyDataSetChanged();
    }

    public void collapseCategory(Category category)
    {
        if (expandedCategories != null && expandedCategories.size() > 2 && !isBrowseByCategory)
        {
            if (!((Category)expandedCategories.pollLast()).equals(category))
            {
                collapseCategory(category);
                return;
            } else
            {
                logger.logClick("", "category_selection_x_click", category.relevanceContext, category.friendlyName);
                addSubcategories((Category)expandedCategories.peekLast());
                return;
            }
        }
        if (isBrowseByCategory)
        {
            String s;
            if (category.relevanceContext.equals("mobile_goods"))
            {
                s = "goods";
            } else
            {
                s = "nearby";
            }
            loggingUtils.logCategoryClick("category_click", s, Channel.GLOBAL_SEARCH.toString(), "L2", "close", category);
        }
        reset();
    }

    public void expandCategory(Category category)
    {
        if (isBrowseByCategory)
        {
            String s;
            if (category.relevanceContext.equals("mobile_goods"))
            {
                s = "goods";
            } else
            {
                s = "nearby";
            }
            loggingUtils.logCategoryClick("category_click", s, Channel.GLOBAL_SEARCH.toString(), "L2", "expand", category);
        } else
        {
            logger.logClick("", "category_expansion_click", category.relevanceContext, category.friendlyName);
        }
        if (expandedCategories == null)
        {
            expandedCategories = new LinkedList();
            if (!category.isParent())
            {
                expandedCategories.add(category.parent);
                expandedCategories.add(parentToDeals.get(category.parent));
            }
        } else
        {
            removeSubcategories(false);
        }
        category.isSubcategory = false;
        category.hasSubcategories = false;
        expandedCategories.add(category);
        addSubcategories(category);
        notifyDataSetChanged();
    }

    public int getCount()
    {
        if (categories == null && expandedCategories == null)
        {
            return 0;
        }
        if (expandedCategories == null)
        {
            return categories.size();
        } else
        {
            return expandedCategories.size();
        }
    }

    public LinkedList getExpandedCategories()
    {
        return expandedCategories;
    }

    public Category getItem(int i)
    {
        if (expandedCategories == null)
        {
            return (Category)categories.get(i);
        } else
        {
            return (Category)expandedCategories.get(i);
        }
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public long getItemId(int i)
    {
        return 0L;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        Category category = getItem(i);
        String s;
        TextView textview;
        StringBuilder stringbuilder;
        if (view == null)
        {
            view = inflater.inflate(0x7f030107, viewgroup, false);
            viewgroup = new CategoryViewHolder();
            viewgroup.categoryNameTv = (TextView)view.findViewById(0x7f100304);
            viewgroup.categoryExpandImg = (ImageView)view.findViewById(0x7f100305);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (CategoryViewHolder)view.getTag();
        }
        if (category.id.equalsIgnoreCase("groceries"))
        {
            logger.logImpression(null, "groceries_search_all_impression", "snap", null, new SnapGroceryGenericMetadata(null, com/groupon/activity/GlobalSearch.getSimpleName(), null, null));
        }
        textview = ((CategoryViewHolder) (viewgroup)).categoryNameTv;
        stringbuilder = (new StringBuilder()).append(category.friendlyName);
        if (category.count > 0)
        {
            s = (new StringBuilder()).append(" (").append(category.count).append(")").toString();
        } else
        {
            s = "";
        }
        textview.setText(stringbuilder.append(s).toString());
        setCategorySpecsByType(viewgroup, category);
        if (isExpanded(category))
        {
            ((CategoryViewHolder) (viewgroup)).categoryExpandImg.setImageDrawable(expandedArrow);
        } else
        {
            ((CategoryViewHolder) (viewgroup)).categoryExpandImg.setImageDrawable(collapsedArrow);
        }
        if (category.hasSubcategories)
        {
            ((CategoryViewHolder) (viewgroup)).categoryExpandImg.setVisibility(0);
            ((CategoryViewHolder) (viewgroup)).categoryExpandImg.setTag(category);
            ((CategoryViewHolder) (viewgroup)).categoryExpandImg.setOnClickListener(new android.view.View.OnClickListener() {

                final GlobalCategoriesAdapter this$0;

                public void onClick(View view1)
                {
                    addRemoveCategory((Category)view1.getTag());
                }

            
            {
                this$0 = GlobalCategoriesAdapter.this;
                super();
            }
            });
        } else
        {
            ((CategoryViewHolder) (viewgroup)).categoryExpandImg.setVisibility(8);
        }
        ((CategoryViewHolder) (viewgroup)).categoryNameTv.setTag(category);
        return view;
    }

    public boolean isEmpty()
    {
        return false;
    }

    public boolean isExpanded(Category category)
    {
label0:
        {
            if (expandedCategories == null)
            {
                break label0;
            }
            Iterator iterator = expandedCategories.iterator();
            Category category1;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                category1 = (Category)iterator.next();
            } while (category1.isSubcategory || !category1.equals(category));
            return true;
        }
        return false;
    }

    protected void removeSubcategories(boolean flag)
    {
        Category category;
        if (flag)
        {
            category = (Category)expandedCategories.pollLast();
        } else
        {
            category = (Category)expandedCategories.peekLast();
        }
        if (expandedCategories != null && !expandedCategories.isEmpty() && category.isSubcategory)
        {
            if (!flag)
            {
                expandedCategories.pollLast();
            }
            removeSubcategories(flag);
        }
    }

    protected void reset()
    {
        expandedCategories = null;
        for (Iterator iterator = categories.iterator(); iterator.hasNext();)
        {
            ((Category)iterator.next()).isSubcategory = false;
        }

        notifyDataSetChanged();
    }

    protected void setCategorySpecs(CategoryViewHolder categoryviewholder, int i, int j, int k, int l)
    {
        categoryviewholder.categoryNameTv.setTextColor(resources.getColor(j));
        categoryviewholder.categoryNameTv.setTextSize(0, resources.getDimension(i));
        categoryviewholder.categoryNameTv.setPadding(l, 0, 0, 0);
        if (k != 0)
        {
            categoryviewholder.categoryNameTv.setBackground(resources.getDrawable(k));
            categoryviewholder.categoryExpandImg.setBackground(resources.getDrawable(k));
        }
    }

    protected void setCategorySpecsByType(CategoryViewHolder categoryviewholder, Category category)
    {
        if (category.id.equals("groceries"))
        {
            setCategorySpecs(categoryviewholder, 0x7f0b00a6, 0x7f0e00d1, 0x7f0200ac, (int)resources.getDimension(0x7f0b00a8));
            categoryviewholder.categoryNameTv.setOnClickListener(categoriesClickListener);
            return;
        }
        if (category.isSubcategory || category.id.equals("groceries"))
        {
            setCategorySpecs(categoryviewholder, 0x7f0b00a6, 0x7f0e00d1, 0x7f020301, (int)resources.getDimension(0x7f0b0203));
            categoryviewholder.categoryNameTv.setOnClickListener(categoriesClickListener);
            return;
        }
        if (category.isParent())
        {
            setCategorySpecs(categoryviewholder, 0x7f0b00a6, 0x7f0e00d7, 0, (int)resources.getDimension(0x7f0b00a8));
            categoryviewholder.categoryNameTv.setBackgroundColor(resources.getColor(0x7f0e00e2));
            categoryviewholder.categoryNameTv.setPadding((int)resources.getDimension(0x7f0b00a8), 0, 0, 0);
            return;
        } else
        {
            setCategorySpecs(categoryviewholder, 0x7f0b00a9, 0x7f0e00d1, 0x7f0200ac, (int)resources.getDimension(0x7f0b00a8));
            categoryviewholder.categoryNameTv.setOnClickListener(categoriesClickListener);
            return;
        }
    }

    public void setIsBrowseByCategory(boolean flag)
    {
        isBrowseByCategory = flag;
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        categoriesClickListener = onclicklistener;
    }
}
