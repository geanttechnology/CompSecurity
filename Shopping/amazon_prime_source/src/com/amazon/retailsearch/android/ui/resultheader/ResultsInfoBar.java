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
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.retailsearch.android.api.display.results.ResultsInfoBarWidgetType;
import com.amazon.retailsearch.android.api.experimentation.FeatureConfiguration;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.android.ui.StyledSpannableString;
import com.amazon.retailsearch.android.ui.UIUtils;
import com.amazon.retailsearch.android.ui.refinements.RefinementMenu;
import com.amazon.retailsearch.android.ui.results.ResultLayoutType;
import com.amazon.retailsearch.android.ui.results.RetailSearchResultStyles;
import com.amazon.retailsearch.android.ui.results.ViewSelector;
import com.amazon.retailsearch.android.ui.results.layout.view.ResultsCountView;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.experiment.DisplaySettingsUtil;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;
import com.amazon.retailsearch.popup.PopupDialogFragment;
import com.amazon.retailsearch.popup.PopupDialogFragmentV4;
import com.amazon.retailsearch.popup.Position;
import com.amazon.retailsearch.userpreferences.UserPreferenceManager;
import com.amazon.searchapp.retailsearch.model.Breadcrumb;
import com.amazon.searchapp.retailsearch.model.Department;
import com.amazon.searchapp.retailsearch.model.Refinements;
import com.amazon.searchapp.retailsearch.model.ResultsMetadata;
import com.amazon.searchapp.retailsearch.model.Sort;
import com.amazon.searchapp.retailsearch.model.StyledText;
import com.amazon.searchapp.retailsearch.model.TrackingInfo;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.resultheader:
//            ResultsInfoBarContentListener, IHeaderContentListener

public class ResultsInfoBar extends LinearLayout
{
    private static interface DismissMenuListener
    {

        public abstract void dismiss();
    }

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
            Object obj;
            if (hasMetadata || resultsmetadata == null || widgetType != ResultsInfoBarWidgetType.DEFAULT_WIDGET && widgetType != ResultsInfoBarWidgetType.STYLED_LABEL)
            {
                return;
            }
            UIUtils.setVisibility(defaultWidget, 8);
            UIUtils.setVisibility(textWidget, 8);
            obj = resultsmetadata.getResultsInfoStyledLabel();
            if (textWidget == null || obj == null || ((List) (obj)).size() <= 0) goto _L2; else goto _L1
_L1:
            resultsmetadata = new StyledSpannableString(getContext());
            for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
            {
                StyledText styledtext = (StyledText)((Iterator) (obj)).next();
                if (RetailSearchResultStyles.STYLE_HIGHLIGHT.equals(styledtext.getStyle()))
                {
                    resultsmetadata.append(styledtext, com.amazon.retailsearch.R.style.Rs_Header_TextWidget_Highlight);
                } else
                {
                    resultsmetadata.append(styledtext, com.amazon.retailsearch.R.style.Rs);
                }
            }

            textWidget.setText(resultsmetadata);
            UIUtils.setVisibility(textWidget, 0);
_L4:
            hasMetadata = true;
            return;
_L2:
            if (resultsCount != null)
            {
                resultsCount.build(resultsmetadata);
                UIUtils.setVisibility(defaultWidget, 0);
            }
            if (true) goto _L4; else goto _L3
_L3:
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
            ResultsInfoBar resultsinfobar = ResultsInfoBar.this;
            boolean flag;
            if (!TextUtils.isEmpty(trackinginfo.getSearchKeywords()))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            resultsinfobar.setHasKeywords(flag);
        }

        private HeaderSearchTaskListener()
        {
            this$0 = ResultsInfoBar.this;
            super();
        }

    }

    public static interface InfoBarVisibilityListener
    {

        public abstract void onVisibilityChanged(boolean flag);
    }


    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar);
    private Breadcrumb breadcrumb;
    private LinearLayout defaultWidget;
    private String department;
    private TextView departmentView;
    private DismissMenuListener dismissMenuListener;
    private View divider;
    FeatureConfiguration featureConfig;
    private TextView filterView;
    private long filtersCount;
    private boolean hasMetadata;
    private boolean hasRefinements;
    private IHeaderContentListener listener;
    UserPreferenceManager preferencesManager;
    private RefinementMenu refinementMenu;
    private ResultsCountView resultsCount;
    private RetailSearchLogger retailSearchLogger;
    private HeaderSearchTaskListener searchTaskListener;
    private TextView textWidget;
    private ViewSelector viewSelector;
    private InfoBarVisibilityListener visibilityListener;
    private ViewGroup widgetContainer;
    private ResultsInfoBarWidgetType widgetType;

    public ResultsInfoBar(Context context)
    {
        super(context);
        retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
        widgetType = ResultsInfoBarWidgetType.DEFAULT_WIDGET;
        init();
    }

    public ResultsInfoBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
        widgetType = ResultsInfoBarWidgetType.DEFAULT_WIDGET;
        init();
    }

    private void buildDepartmentLabel()
    {
        if (departmentView == null || widgetType != ResultsInfoBarWidgetType.DEFAULT_WIDGET)
        {
            return;
        }
        if (TextUtils.isEmpty(department))
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

    private void buildFilterLabel()
    {
        StyledSpannableString styledspannablestring = new StyledSpannableString(getContext());
        styledspannablestring.append(getContext().getResources().getString(com.amazon.retailsearch.R.string.refine_filter), com.amazon.retailsearch.R.style.Rs_Header_Filter);
        if (filtersCount > 0L)
        {
            styledspannablestring.append(" (", com.amazon.retailsearch.R.style.Rs_Header_Filter);
            styledspannablestring.append(String.valueOf(filtersCount), com.amazon.retailsearch.R.style.Rs_Header_Filter_Count);
            styledspannablestring.append(")", com.amazon.retailsearch.R.style.Rs_Header_Filter);
        }
        filterView.setText(styledspannablestring);
    }

    private void buildRefinements()
    {
        filterView.setOnClickListener(new android.view.View.OnClickListener() {

            final ResultsInfoBar this$0;

            public void onClick(View view)
            {
                openRefinementMenu();
            }

            
            {
                this$0 = ResultsInfoBar.this;
                super();
            }
        });
    }

    private void init()
    {
        RetailSearchDaggerGraphController.inject(this);
        listener = new ResultsInfoBarContentListener();
        searchTaskListener = new HeaderSearchTaskListener();
        refinementMenu = (RefinementMenu)LayoutInflater.from(getContext()).inflate(com.amazon.retailsearch.R.layout.refinements_menu, this, false);
        refinementMenu.setListener(listener);
    }

    private boolean isRefinementEmpty(Refinements refinements)
    {
        if (refinements != null)
        {
            if (refinements.getDepartments() != null)
            {
                Department department1 = refinements.getDepartments();
                if (department1.getAncestry() != null && department1.getAncestry().size() > 0 || department1.getCategories() != null && department1.getCategories().size() > 0)
                {
                    return false;
                }
            }
            if (refinements.getFilters() != null && !refinements.getFilters().isEmpty())
            {
                return false;
            }
        }
        return true;
    }

    private void openRefinementMenu()
    {
        if (!(filterView.getContext() instanceof FragmentActivity)) goto _L2; else goto _L1
_L1:
        FragmentActivity fragmentactivity;
        FragmentManager fragmentmanager;
        fragmentactivity = (FragmentActivity)filterView.getContext();
        fragmentmanager = fragmentactivity.getSupportFragmentManager();
        if (fragmentmanager == null || fragmentmanager.findFragmentByTag("popup_dialog_fragment") == null) goto _L4; else goto _L3
_L3:
        return;
_L4:
        showRefinementDialog(fragmentactivity, new PopupDialogFragmentV4());
        return;
_L2:
        Activity activity = (Activity)filterView.getContext();
        android.app.FragmentManager fragmentmanager1 = activity.getFragmentManager();
        if (fragmentmanager1 == null || fragmentmanager1.findFragmentByTag("popup_dialog_fragment") == null)
        {
            showRefinementDialog(activity, new PopupDialogFragment());
            return;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    private void showRefinementDialog(Activity activity, final PopupDialogFragment dialog)
    {
        int i = activity.getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_refinement_menu_popup_shadow_padding_left);
        int j = activity.getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_refinement_menu_popup_width);
        dialog.show(activity.getFragmentManager(), com.amazon.retailsearch.R.id.rs_filter_header_label, refinementMenu, Position.BELOW_LEFT, filterView.getPaddingLeft() - i, 0, j, refinementMenu.getDialogHeight());
        dialog.setOnCloseListener(new com.amazon.retailsearch.popup.PopupDialogFragment.OnCloseListener() {

            final ResultsInfoBar this$0;

            public void onClose()
            {
                retailSearchLogger.filterMenuClosed();
                dismissMenuListener = null;
            }

            
            {
                this$0 = ResultsInfoBar.this;
                super();
            }
        });
        dismissMenuListener = new DismissMenuListener() {

            final ResultsInfoBar this$0;
            final PopupDialogFragment val$dialog;

            public void dismiss()
            {
                try
                {
                    dialog.dismiss();
                    return;
                }
                catch (Exception exception)
                {
                    retailSearchLogger.error("Could not dismiss dialog", exception);
                }
            }

            
            {
                this$0 = ResultsInfoBar.this;
                dialog = popupdialogfragment;
                super();
            }
        };
        activity = preferencesManager.getResultLayoutType();
        if (activity == null)
        {
            return;
        } else
        {
            retailSearchLogger.filterMenuInvoked(activity.name());
            return;
        }
    }

    private void showRefinementDialog(FragmentActivity fragmentactivity, final PopupDialogFragmentV4 dialog)
    {
        int i = fragmentactivity.getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_refinement_menu_popup_shadow_padding_left);
        int j = fragmentactivity.getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_refinement_menu_popup_width);
        dialog.show(fragmentactivity.getSupportFragmentManager(), com.amazon.retailsearch.R.id.rs_filter_header_label, refinementMenu, Position.BELOW_LEFT, filterView.getPaddingLeft() - i, 0, j, -1);
        dialog.setOnCloseListener(new com.amazon.retailsearch.popup.PopupDialogFragmentV4.OnCloseListener() {

            final ResultsInfoBar this$0;

            public void onClose()
            {
                retailSearchLogger.filterMenuClosed();
                dismissMenuListener = null;
            }

            
            {
                this$0 = ResultsInfoBar.this;
                super();
            }
        });
        dismissMenuListener = new DismissMenuListener() {

            final ResultsInfoBar this$0;
            final PopupDialogFragmentV4 val$dialog;

            public void dismiss()
            {
                try
                {
                    dialog.dismiss();
                    return;
                }
                catch (Exception exception)
                {
                    retailSearchLogger.error("Could not dismiss dialog", exception);
                }
            }

            
            {
                this$0 = ResultsInfoBar.this;
                dialog = popupdialogfragmentv4;
                super();
            }
        };
        fragmentactivity = preferencesManager.getResultLayoutType();
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
        if (resultsCount != null)
        {
            resultsCount.setVisibility(8);
        }
        hasMetadata = false;
        filtersCount = 0L;
        breadcrumb = null;
        department = null;
        hasRefinements = false;
        buildFilterLabel();
        buildDepartmentLabel();
        if (viewSelector != null && DisplaySettingsUtil.displaySettingsEnabled(getResources(), featureConfig))
        {
            viewSelector.updateView(null);
        }
    }

    public Breadcrumb getBreadcrumb()
    {
        return breadcrumb;
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
        defaultWidget = (LinearLayout)findViewById(com.amazon.retailsearch.R.id.rs_info_bar_default_widget);
        departmentView = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_department_label);
        resultsCount = (ResultsCountView)findViewById(com.amazon.retailsearch.R.id.rs_results_count);
        viewSelector = (ViewSelector)findViewById(com.amazon.retailsearch.R.id.rs_view_selector);
        filterView = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_filter_header_label);
        widgetContainer = (ViewGroup)findViewById(com.amazon.retailsearch.R.id.rs_info_bar_widget_container);
        textWidget = (TextView)findViewById(com.amazon.retailsearch.R.id.rs_info_bar_text_widget);
        divider = findViewById(com.amazon.retailsearch.R.id.rs_info_bar_divider);
        buildDepartmentLabel();
        buildRefinements();
        buildFilterLabel();
    }

    public void openFilter(String s, boolean flag)
    {
        openRefinementMenu();
        refinementMenu.openFilter(s, flag);
    }

    public void setBreadcrumb(Breadcrumb breadcrumb1)
    {
        breadcrumb = breadcrumb1;
    }

    public void setDepartment(String s)
    {
        department = s;
        buildDepartmentLabel();
    }

    public void setHasKeywords(boolean flag)
    {
        refinementMenu.setHasKeywords(flag);
    }

    public void setRefinements(Refinements refinements)
    {
        if (hasRefinements)
        {
            return;
        }
        byte byte0;
        if (isRefinementEmpty(refinements))
        {
            byte byte1 = 8;
            byte0 = byte1;
            if (dismissMenuListener != null)
            {
                dismissMenuListener.dismiss();
                byte0 = byte1;
            }
        } else
        {
            refinementMenu.setRefinements(refinements);
            filtersCount = refinementMenu.getFiltersCount();
            buildRefinements();
            buildFilterLabel();
            notifyRefinementsChanged();
            byte0 = 0;
        }
        filterView.setVisibility(byte0);
        divider.setVisibility(byte0);
        if (widgetContainer != null && visibilityListener != null)
        {
            refinements = visibilityListener;
            boolean flag;
            if (byte0 == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            refinements.onVisibilityChanged(flag);
        }
        hasRefinements = true;
    }

    public void setSort(Sort sort)
    {
        refinementMenu.setSort(sort);
    }

    public void setVisibilityListener(InfoBarVisibilityListener infobarvisibilitylistener)
    {
        visibilityListener = infobarvisibilitylistener;
    }

    public void setWidgetType(ResultsInfoBarWidgetType resultsinfobarwidgettype, View view)
    {
        widgetType = resultsinfobarwidgettype;
        if (widgetType == ResultsInfoBarWidgetType.CUSTOM_VIEW)
        {
            if (view != null && widgetContainer != null && widgetContainer.getChildCount() == 0 && view.getParent() == null)
            {
                try
                {
                    widgetContainer.addView(view);
                }
                // Misplaced declaration of an exception variable
                catch (ResultsInfoBarWidgetType resultsinfobarwidgettype)
                {
                    retailSearchLogger.error("Unable to add app-provided view", resultsinfobarwidgettype);
                }
            } else
            {
                widgetType = ResultsInfoBarWidgetType.DEFAULT_WIDGET;
                log.error("Unable to set the Result Info Bar's widget type to CUSTOM_VIEW! Reset to default widget");
            }
        }
        if (widgetType == ResultsInfoBarWidgetType.STYLED_LABEL)
        {
            UIUtils.setVisibility(defaultWidget, 8);
            UIUtils.setVisibility(widgetContainer, 8);
            UIUtils.setVisibility(textWidget, 0);
            return;
        }
        if (widgetType == ResultsInfoBarWidgetType.CUSTOM_VIEW)
        {
            UIUtils.setVisibility(defaultWidget, 8);
            UIUtils.setVisibility(widgetContainer, 0);
            UIUtils.setVisibility(textWidget, 8);
            return;
        } else
        {
            UIUtils.setVisibility(defaultWidget, 0);
            UIUtils.setVisibility(widgetContainer, 8);
            UIUtils.setVisibility(textWidget, 8);
            return;
        }
    }





/*
    static DismissMenuListener access$302(ResultsInfoBar resultsinfobar, DismissMenuListener dismissmenulistener)
    {
        resultsinfobar.dismissMenuListener = dismissmenulistener;
        return dismissmenulistener;
    }

*/



/*
    static boolean access$402(ResultsInfoBar resultsinfobar, boolean flag)
    {
        resultsinfobar.hasMetadata = flag;
        return flag;
    }

*/




}
