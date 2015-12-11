// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.resultheader;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.android.ui.StyledSpannableString;
import com.amazon.retailsearch.android.ui.refinements.RefinementMenu;
import com.amazon.retailsearch.android.ui.results.ViewSelector;
import com.amazon.retailsearch.android.ui.results.ViewType;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.experiment.DisplaySettingsUtil;
import com.amazon.retailsearch.popup.PopupDialogFragment;
import com.amazon.retailsearch.popup.PopupDialogFragmentV4;
import com.amazon.retailsearch.popup.Position;
import com.amazon.retailsearch.userpreferences.UserPreferenceManager;
import com.amazon.searchapp.retailsearch.model.Breadcrumb;
import com.amazon.searchapp.retailsearch.model.Refinements;
import com.amazon.searchapp.retailsearch.model.ResultsMetadata;
import com.amazon.searchapp.retailsearch.model.Sort;
import com.amazon.searchapp.retailsearch.model.TrackingInfo;

// Referenced classes of package com.amazon.retailsearch.android.ui.resultheader:
//            ResultsInfoBarContentListener, IHeaderContentListener

public class ResultsInfoBar extends LinearLayout
{
    private class HeaderSearchTaskListener extends com.amazon.retailsearch.data.SearchTask.SearchTaskListener
    {

        final ResultsInfoBar this$0;

        public void breadcrumb(Breadcrumb breadcrumb1)
        {
            setBreadcrumb(breadcrumb1);
        }

        public void refinements(Refinements refinements1)
        {
            setRefinements(refinements1);
        }

        public void resultMetadata(ResultsMetadata resultsmetadata)
        {
            if (resultsmetadata != null && !hasMetadata)
            {
                setCountAndLabel(resultsmetadata.getTotalResults(), resultsmetadata.getResultsLabel());
                hasMetadata = true;
            }
        }

        public void sort(Sort sort1)
        {
            setSort(sort1);
        }

        public void startResult()
        {
            clearAll();
        }

        public void trackingInfo(TrackingInfo trackinginfo)
        {
            setDepartment(trackinginfo.getSearchAliasDisplayName());
        }

        private HeaderSearchTaskListener()
        {
            this$0 = ResultsInfoBar.this;
            super();
        }

    }


    private Breadcrumb breadcrumb;
    private long count;
    private TextView countView;
    private String department;
    private TextView departmentView;
    FeatureConfiguration featureConfig;
    private TextView filterView;
    private long filtersCount;
    private boolean hasMetadata;
    private boolean hasRefinements;
    View headerBarView;
    private IHeaderContentListener listener;
    UserPreferenceManager preferencesManager;
    private RefinementMenu refinementMenu;
    private String resultsCountLabel;
    private RetailSearchLogger retailSearchLogger;
    private HeaderSearchTaskListener searchTaskListener;
    private boolean showDepartment;
    private ViewSelector viewSelector;

    public ResultsInfoBar(Context context)
    {
        super(context);
        retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
        init();
    }

    public ResultsInfoBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
        init();
    }

    private void buildDepartmentLabel(View view)
    {
        if (!showDepartment || TextUtils.isEmpty(department))
        {
            departmentView.setVisibility(8);
            return;
        } else
        {
            departmentView.setText(department);
            departmentView.setVisibility(0);
            return;
        }
    }

    private void buildFilterLabel(View view)
    {
        StyledSpannableString styledspannablestring = new StyledSpannableString(view.getContext());
        styledspannablestring.append(view.getContext().getResources().getString(com.amazon.retailsearch.R.string.refine_filter), com.amazon.retailsearch.R.style.Rs_Header_Filter);
        if (filtersCount > 0L)
        {
            styledspannablestring.append(" (", com.amazon.retailsearch.R.style.Rs_Header_Filter);
            styledspannablestring.append(String.valueOf(filtersCount), com.amazon.retailsearch.R.style.Rs_Header_Filter_Count);
            styledspannablestring.append(")", com.amazon.retailsearch.R.style.Rs_Header_Filter);
        }
        filterView.setText(styledspannablestring);
    }

    private void buildRefinements(View view)
    {
        filterView.setOnClickListener(new android.view.View.OnClickListener() {

            final ResultsInfoBar this$0;

            public void onClick(View view1)
            {
                if (!(filterView.getContext() instanceof FragmentActivity)) goto _L2; else goto _L1
_L1:
                FragmentManager fragmentmanager;
                view1 = (FragmentActivity)filterView.getContext();
                fragmentmanager = view1.getSupportFragmentManager();
                if (fragmentmanager == null || fragmentmanager.findFragmentByTag("popup_dialog_fragment") == null) goto _L4; else goto _L3
_L3:
                return;
_L4:
                showRefinementDialog(view1, new PopupDialogFragmentV4());
                return;
_L2:
                view1 = (Activity)filterView.getContext();
                android.app.FragmentManager fragmentmanager1 = view1.getFragmentManager();
                if (fragmentmanager1 == null || fragmentmanager1.findFragmentByTag("popup_dialog_fragment") == null)
                {
                    showRefinementDialog(view1, new PopupDialogFragment());
                    return;
                }
                if (true) goto _L3; else goto _L5
_L5:
            }

            
            {
                this$0 = ResultsInfoBar.this;
                super();
            }
        });
    }

    private void buildResultCountLabel(View view)
    {
        if (count > 0L && !TextUtils.isEmpty(resultsCountLabel))
        {
            countView.setText(resultsCountLabel);
            countView.setSingleLine(true);
            countView.setEllipsize(android.text.TextUtils.TruncateAt.END);
            countView.setVisibility(0);
            return;
        } else
        {
            countView.setVisibility(8);
            return;
        }
    }

    private void init()
    {
        RetailSearchDaggerGraphController.inject(this);
        listener = new ResultsInfoBarContentListener();
        searchTaskListener = new HeaderSearchTaskListener();
        refinementMenu = (RefinementMenu)LayoutInflater.from(getContext()).inflate(com.amazon.retailsearch.R.layout.refinements_menu, this, false);
        refinementMenu.setListener(listener);
    }

    private void showRefinementDialog(Activity activity, PopupDialogFragment popupdialogfragment)
    {
        int i = activity.getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_refinement_menu_popup_shadow_padding_left);
        int j = activity.getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_refinement_menu_popup_width);
        popupdialogfragment.show(activity.getFragmentManager(), com.amazon.retailsearch.R.id.rs_filter_header_label, refinementMenu, Position.BELOW_LEFT, filterView.getPaddingLeft() - i, 0, j, refinementMenu.getDialogHeight());
        popupdialogfragment.setOnCloseListener(new com.amazon.retailsearch.popup.PopupDialogFragment.OnCloseListener() {

            final ResultsInfoBar this$0;

            public void onClose()
            {
                retailSearchLogger.filterMenuClosed();
            }

            
            {
                this$0 = ResultsInfoBar.this;
                super();
            }
        });
        activity = preferencesManager.getViewType();
        if (activity == null)
        {
            return;
        } else
        {
            retailSearchLogger.filterMenuInvoked(activity.name());
            return;
        }
    }

    private void showRefinementDialog(FragmentActivity fragmentactivity, PopupDialogFragmentV4 popupdialogfragmentv4)
    {
        int i = fragmentactivity.getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_refinement_menu_popup_shadow_padding_left);
        int j = fragmentactivity.getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_refinement_menu_popup_width);
        popupdialogfragmentv4.show(fragmentactivity.getSupportFragmentManager(), com.amazon.retailsearch.R.id.rs_filter_header_label, refinementMenu, Position.BELOW_LEFT, filterView.getPaddingLeft() - i, 0, j, -1);
        popupdialogfragmentv4.setOnCloseListener(new com.amazon.retailsearch.popup.PopupDialogFragmentV4.OnCloseListener() {

            final ResultsInfoBar this$0;

            public void onClose()
            {
                retailSearchLogger.filterMenuClosed();
            }

            
            {
                this$0 = ResultsInfoBar.this;
                super();
            }
        });
        fragmentactivity = preferencesManager.getViewType();
        if (fragmentactivity == null)
        {
            return;
        } else
        {
            retailSearchLogger.filterMenuInvoked(fragmentactivity.name());
            return;
        }
    }

    public void clearAll()
    {
        count = 0L;
        resultsCountLabel = null;
        hasMetadata = false;
        filtersCount = 0L;
        breadcrumb = null;
        department = null;
        hasRefinements = false;
        buildResultCountLabel(this);
        buildFilterLabel(this);
        buildDepartmentLabel(this);
        if (viewSelector != null && DisplaySettingsUtil.displaySettingsEnabled(getResources(), featureConfig))
        {
            viewSelector.updateView(null);
        }
    }

    public Breadcrumb getBreadcrumb()
    {
        return breadcrumb;
    }

    public long getCount()
    {
        return count;
    }

    public String getDepartment()
    {
        return department;
    }

    public com.amazon.retailsearch.data.SearchTask.SearchTaskListener getSearchTaskListener()
    {
        return searchTaskListener;
    }

    public ViewSelector getViewSelector()
    {
        return viewSelector;
    }

    public void notifyRefinementsChanged()
    {
        refinementMenu.notifyRefinementsChanged();
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        departmentView = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_department_label);
        boolean flag;
        if (departmentView.getVisibility() != 8)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        showDepartment = flag;
        countView = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_result_count_label);
        viewSelector = (ViewSelector)findViewById(com.amazon.retailsearch.R.id.rs_view_selector);
        filterView = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_filter_header_label);
        buildDepartmentLabel(this);
        buildResultCountLabel(this);
        buildRefinements(this);
        buildFilterLabel(this);
    }

    public void setBreadcrumb(Breadcrumb breadcrumb1)
    {
        breadcrumb = breadcrumb1;
        buildResultCountLabel(this);
    }

    public void setCountAndLabel(long l, String s)
    {
        count = l;
        resultsCountLabel = s;
        buildResultCountLabel(this);
    }

    public void setDepartment(String s)
    {
        department = s;
        buildDepartmentLabel(this);
    }

    public void setRefinements(Refinements refinements)
    {
        if (hasRefinements)
        {
            return;
        }
        if (refinements == null)
        {
            filterView.setVisibility(8);
        } else
        {
            refinementMenu.setRefinements(refinements);
            filtersCount = refinementMenu.getFiltersCount();
            buildRefinements(this);
            buildFilterLabel(this);
            notifyRefinementsChanged();
            filterView.setVisibility(0);
        }
        hasRefinements = true;
    }

    public void setSort(Sort sort)
    {
        refinementMenu.setSort(sort);
    }







/*
    static boolean access$502(ResultsInfoBar resultsinfobar, boolean flag)
    {
        resultsinfobar.hasMetadata = flag;
        return flag;
    }

*/
}
