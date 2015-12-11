// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import com.ebay.common.model.search.EbayCategoryHistogram;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.activities:
//            CoreActivity

public class FoundItemsCategoriesActivity extends CoreActivity
    implements android.widget.ExpandableListView.OnChildClickListener, android.widget.ExpandableListView.OnGroupClickListener
{
    private class FoundItemsCategoriesListAdapter extends BaseExpandableListAdapter
    {

        private final ArrayList categoryNodeList;
        private final int childLayoutResource;
        private final int groupLayoutResource;
        private final LayoutInflater inflater;
        final FoundItemsCategoriesActivity this$0;

        public com.ebay.common.model.search.EbayCategoryHistogram.Category getChild(int i, int j)
        {
            Object obj = getGroup(i);
            if (obj != null)
            {
                if ((obj = ((com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory) (obj)).children) != null && j < ((ArrayList) (obj)).size())
                {
                    return (com.ebay.common.model.search.EbayCategoryHistogram.Category)((ArrayList) (obj)).get(j);
                }
            }
            return null;
        }

        public volatile Object getChild(int i, int j)
        {
            return getChild(i, j);
        }

        public long getChildId(int i, int j)
        {
            com.ebay.common.model.search.EbayCategoryHistogram.Category category = getChild(i, j);
            if (category != null)
            {
                return category.id;
            } else
            {
                return 0L;
            }
        }

        public View getChildView(int i, int j, boolean flag, View view, ViewGroup viewgroup)
        {
            boolean flag1 = false;
            View view1 = view;
            view = view1;
            if (view1 == null)
            {
                view = inflater.inflate(childLayoutResource, viewgroup, false);
            }
            viewgroup = getChild(i, j);
            if (viewgroup == null)
            {
                return null;
            }
            ((TextView)view.findViewById(0x7f1001c5)).setText(((com.ebay.common.model.search.EbayCategoryHistogram.Category) (viewgroup)).name);
            ((TextView)view.findViewById(0x7f1001c6)).setText((new StringBuilder()).append("(").append(((com.ebay.common.model.search.EbayCategoryHistogram.Category) (viewgroup)).count).append(")").toString());
            view1 = view.findViewById(0x7f1001c7);
            if (categoryId == ((com.ebay.common.model.search.EbayCategoryHistogram.Category) (viewgroup)).id)
            {
                i = ((flag1) ? 1 : 0);
            } else
            {
                i = 4;
            }
            view1.setVisibility(i);
            return view;
        }

        public int getChildrenCount(int i)
        {
            Object obj = getGroup(i);
            if (obj != null)
            {
                if ((obj = ((com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory) (obj)).children) != null)
                {
                    return ((List) (obj)).size();
                }
            }
            return 0;
        }

        public com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory getGroup(int i)
        {
            if (i < categoryNodeList.size())
            {
                return (com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory)categoryNodeList.get(i);
            } else
            {
                return null;
            }
        }

        public volatile Object getGroup(int i)
        {
            return getGroup(i);
        }

        public int getGroupCount()
        {
            return categoryNodeList.size();
        }

        public long getGroupId(int i)
        {
            com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory parentcategory = getGroup(i);
            if (parentcategory != null)
            {
                return parentcategory.id;
            } else
            {
                return 0L;
            }
        }

        public View getGroupView(int i, boolean flag, View view, ViewGroup viewgroup)
        {
            Object obj1 = null;
            Object obj = view;
            view = ((View) (obj));
            if (obj == null)
            {
                view = inflater.inflate(groupLayoutResource, viewgroup, false);
            }
            obj = getGroup(i);
            if (obj == null)
            {
                return null;
            }
            ((TextView)view.findViewById(0x7f1001c5)).setText(((com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory) (obj)).name);
            TextView textview = (TextView)view.findViewById(0x7f1001c6);
            viewgroup = obj1;
            if (((com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory) (obj)).count > 0)
            {
                viewgroup = (new StringBuilder()).append("(").append(((com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory) (obj)).count).append(")").toString();
            }
            textview.setText(viewgroup);
            viewgroup = view.findViewById(0x7f1001c7);
            if (categoryId == ((com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory) (obj)).id)
            {
                i = 0;
            } else
            {
                i = 4;
            }
            viewgroup.setVisibility(i);
            return view;
        }

        public boolean hasStableIds()
        {
            return false;
        }

        public boolean isChildSelectable(int i, int j)
        {
            return true;
        }

        public FoundItemsCategoriesListAdapter(FoundItemsCategoriesActivity founditemscategoriesactivity1, int i, int j, ArrayList arraylist)
        {
            this$0 = FoundItemsCategoriesActivity.this;
            super();
            inflater = (LayoutInflater)founditemscategoriesactivity1.getSystemService("layout_inflater");
            categoryNodeList = arraylist;
            groupLayoutResource = i;
            childLayoutResource = j;
        }
    }


    public static final String EXTRA_CATEGORY_HISTOGRAM = "category_histogray";
    public static final String EXTRA_CATEGORY_ID = "category_id";
    public static final String EXTRA_CATEGORY_NAME = "category_name";
    private FoundItemsCategoriesListAdapter adapter;
    private EbayCategoryHistogram categoryHistogram;
    private long categoryId;
    private ExpandableListView list;

    public FoundItemsCategoriesActivity()
    {
    }

    public static void StartActivity(Activity activity, EbayCategoryHistogram ebaycategoryhistogram, long l)
    {
        Intent intent = new Intent(activity, com/ebay/mobile/activities/FoundItemsCategoriesActivity);
        intent.putExtra("category_histogray", ebaycategoryhistogram);
        intent.putExtra("category_id", l);
        activity.startActivityForResult(intent, 56);
    }

    private void selectCategory(com.ebay.common.model.search.EbayCategoryHistogram.Category category)
    {
        Intent intent = getIntent();
        intent.putExtra("category_id", category.id);
        intent.putExtra("category_name", category.name);
        setResult(-1, intent);
        finish();
    }

    public boolean onChildClick(ExpandableListView expandablelistview, View view, int i, int j, long l)
    {
        selectCategory(adapter.getChild(i, j));
        return true;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300b1);
        list = (ExpandableListView)findViewById(0x7f1001c8);
        list.setOnGroupClickListener(this);
        list.setOnChildClickListener(this);
        bundle = getIntent();
        categoryHistogram = (EbayCategoryHistogram)bundle.getParcelableExtra("category_histogray");
        categoryId = bundle.getLongExtra("category_id", 0L);
        if (categoryHistogram == null)
        {
            list.setVisibility(8);
        } else
        {
            bundle = new ArrayList(categoryHistogram.categories);
            com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory parentcategory = new com.ebay.common.model.search.EbayCategoryHistogram.ParentCategory();
            parentcategory.name = getString(0x7f07002d);
            bundle.add(0, parentcategory);
            list.setVisibility(0);
            adapter = new FoundItemsCategoriesListAdapter(this, 0x7f0300af, 0x7f0300b0, bundle);
            list.setAdapter(adapter);
            list.setChoiceMode(1);
            int i = 0;
            while (i < adapter.getGroupCount()) 
            {
                list.expandGroup(i);
                i++;
            }
        }
    }

    public boolean onGroupClick(ExpandableListView expandablelistview, View view, int i, long l)
    {
        selectCategory(adapter.getGroup(i));
        return true;
    }

}
