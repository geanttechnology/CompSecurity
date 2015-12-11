// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.comcast.cim.cmasl.android.util.view.common.FilterChangeListener;
import com.xfinity.playerlib.model.tags.parser.TagsRoot;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            DibicProgramFilter, FilterEventListener

public class BrowseFilterCategoriesPanel extends Fragment
{
    private class CategoryOnClickListener
        implements android.view.View.OnClickListener
    {

        final BrowseFilterCategoriesPanel this$0;

        public void onClick(View view)
        {
            if (view.isSelected())
            {
                return;
            } else
            {
                setSelectedCategoryView(view);
                filterEventListener.onCategoryChanged((DibicProgramFilter.FilterCategory)view.getTag());
                return;
            }
        }

        private CategoryOnClickListener()
        {
            this$0 = BrowseFilterCategoriesPanel.this;
            super();
        }

    }


    private static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel);
    public static final String TAG = com/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel.getCanonicalName();
    private ViewGroup categoriesContainer;
    private DibicProgramFilter.FilterCategory category;
    private CheckBox downloadableCheckbox;
    private final FilterChangeListener filterChangeListener = new FilterChangeListener() {

        final BrowseFilterCategoriesPanel this$0;

        public void onFilterChange(DibicProgramFilter dibicprogramfilter)
        {
            updateCategoriesList(dibicprogramfilter);
            updateDownloadableCheckbox(dibicprogramfilter.isDownloadableOn());
            updateHideLockedCheckbox(dibicprogramfilter.isHideLockOn());
        }

        public volatile void onFilterChange(Object obj)
        {
            onFilterChange((DibicProgramFilter)obj);
        }

            
            {
                this$0 = BrowseFilterCategoriesPanel.this;
                super();
            }
    };
    private FilterEventListener filterEventListener;
    private LayoutInflater inflater;
    private boolean isDualPanel;
    private View selectedCategoryView;
    private CheckBox subscriptionOnlyCheckbox;
    private TagsRoot tagsRoot;

    public BrowseFilterCategoriesPanel()
    {
        category = DibicProgramFilter.FilterCategory.GENRE;
    }

    public static BrowseFilterCategoriesPanel newInstance(boolean flag)
    {
        Bundle bundle = new Bundle();
        bundle.putBoolean("isDualPanel", flag);
        BrowseFilterCategoriesPanel browsefiltercategoriespanel = new BrowseFilterCategoriesPanel();
        browsefiltercategoriespanel.setArguments(bundle);
        return browsefiltercategoriespanel;
    }

    private void updateSelectedCount(Map map, View view)
    {
        View view1 = view.findViewById(com.xfinity.playerlib.R.id.filterCountContainer);
        view = (TextView)view.findViewById(com.xfinity.playerlib.R.id.filterCount);
        int i = map.size();
        view.setContentDescription(getResources().getQuantityString(com.xfinity.playerlib.R.plurals.content_description_filter_items_count, i, new Object[] {
            Integer.valueOf(i)
        }));
        if (i > 0)
        {
            view.setText(String.format(Locale.US, "%d", new Object[] {
                Integer.valueOf(i)
            }));
            view1.setVisibility(0);
            return;
        } else
        {
            view1.setVisibility(4);
            return;
        }
    }

    protected void addNetworkCategoryView(DibicProgramFilter dibicprogramfilter)
    {
        List list = tagsRoot.getNetworks();
        if (!list.isEmpty() && list.size() > 1)
        {
            dibicprogramfilter = createCategoryView(DibicProgramFilter.FilterCategory.NETWORK, dibicprogramfilter.getCurrentNetworkFilters(), categoriesContainer, category);
            categoriesContainer.addView(dibicprogramfilter);
        }
    }

    public View createCategoryView(DibicProgramFilter.FilterCategory filtercategory, Map map, ViewGroup viewgroup, DibicProgramFilter.FilterCategory filtercategory1)
    {
        viewgroup = inflater.inflate(com.xfinity.playerlib.R.layout.filter_dialog_category_item, viewgroup, false);
        viewgroup.setTag(filtercategory);
        TextView textview = (TextView)viewgroup.findViewById(com.xfinity.playerlib.R.id.label);
        textview.setText(filtercategory.getLabel(getActivity()));
        textview.setContentDescription(filtercategory.getContentDescription(getActivity()));
        viewgroup.setOnClickListener(new CategoryOnClickListener());
        viewgroup.setTag(filtercategory);
        if (filtercategory1 == filtercategory)
        {
            setSelectedCategoryView(viewgroup);
        }
        updateSelectedCount(map, viewgroup);
        return viewgroup;
    }

    public FilterChangeListener getFilterChangeListener()
    {
        return filterChangeListener;
    }

    public void initializeCategoriesList(TagsRoot tagsroot, DibicProgramFilter dibicprogramfilter, DibicProgramFilter.FilterCategory filtercategory)
    {
        tagsRoot = tagsroot;
        if (selectedCategoryView != null)
        {
            filtercategory = (DibicProgramFilter.FilterCategory)selectedCategoryView.getTag();
        }
        categoriesContainer.removeAllViews();
        tagsroot = createCategoryView(DibicProgramFilter.FilterCategory.GENRE, dibicprogramfilter.getCurrentGenreFilters(), categoriesContainer, filtercategory);
        categoriesContainer.addView(tagsroot);
        addNetworkCategoryView(dibicprogramfilter);
        tagsroot = createCategoryView(DibicProgramFilter.FilterCategory.ALPHA, dibicprogramfilter.getCurrentAlphaFilters(), categoriesContainer, filtercategory);
        categoriesContainer.addView(tagsroot);
        filterEventListener.onCategoryChanged(filtercategory);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        filterEventListener = (FilterEventListener)activity;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null)
        {
            isDualPanel = bundle.getBoolean("isDualPanel");
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        inflater = layoutinflater;
        layoutinflater = layoutinflater.inflate(com.xfinity.playerlib.R.layout.filter_dialog_main, viewgroup, false);
        categoriesContainer = (ViewGroup)layoutinflater.findViewById(com.xfinity.playerlib.R.id.categoriesContainer);
        subscriptionOnlyCheckbox = (CheckBox)layoutinflater.findViewById(com.xfinity.playerlib.R.id.subscription_only_checkbox);
        subscriptionOnlyCheckbox.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final BrowseFilterCategoriesPanel this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                filterEventListener.onSubscriptionOnlyChanged(flag);
            }

            
            {
                this$0 = BrowseFilterCategoriesPanel.this;
                super();
            }
        });
        downloadableCheckbox = (CheckBox)layoutinflater.findViewById(com.xfinity.playerlib.R.id.downloadable_checkbox);
        downloadableCheckbox.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final BrowseFilterCategoriesPanel this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                filterEventListener.onDownloadOnlyChanged(flag);
            }

            
            {
                this$0 = BrowseFilterCategoriesPanel.this;
                super();
            }
        });
        layoutinflater.findViewById(com.xfinity.playerlib.R.id.downloadable_checkbox_container).setOnClickListener(new android.view.View.OnClickListener() {

            final BrowseFilterCategoriesPanel this$0;

            public void onClick(View view)
            {
                downloadableCheckbox.performClick();
            }

            
            {
                this$0 = BrowseFilterCategoriesPanel.this;
                super();
            }
        });
        layoutinflater.findViewById(com.xfinity.playerlib.R.id.subscription_only_checkbox_container).setOnClickListener(new android.view.View.OnClickListener() {

            final BrowseFilterCategoriesPanel this$0;

            public void onClick(View view)
            {
                subscriptionOnlyCheckbox.performClick();
            }

            
            {
                this$0 = BrowseFilterCategoriesPanel.this;
                super();
            }
        });
        return layoutinflater;
    }

    protected void setSelectedCategoryView(View view)
    {
        if (selectedCategoryView != null)
        {
            selectedCategoryView.setSelected(false);
        }
        selectedCategoryView = view;
        if (isDualPanel)
        {
            selectedCategoryView.setSelected(true);
        }
    }

    public void updateCategoriesList(DibicProgramFilter dibicprogramfilter)
    {
        if (selectedCategoryView != null)
        {
            category = (DibicProgramFilter.FilterCategory)selectedCategoryView.getTag();
        }
        categoriesContainer.removeAllViews();
        View view = createCategoryView(DibicProgramFilter.FilterCategory.GENRE, dibicprogramfilter.getCurrentGenreFilters(), categoriesContainer, category);
        categoriesContainer.addView(view);
        addNetworkCategoryView(dibicprogramfilter);
        dibicprogramfilter = createCategoryView(DibicProgramFilter.FilterCategory.ALPHA, dibicprogramfilter.getCurrentAlphaFilters(), categoriesContainer, category);
        categoriesContainer.addView(dibicprogramfilter);
    }

    public void updateDownloadableCheckbox(boolean flag)
    {
        downloadableCheckbox.setChecked(flag);
    }

    public void updateHideLockedCheckbox(boolean flag)
    {
        subscriptionOnlyCheckbox.setChecked(flag);
    }




}
