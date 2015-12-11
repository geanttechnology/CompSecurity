// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import com.comcast.cim.android.accessibility.AccessibilityUtil;
import com.comcast.cim.android.accessibility.TalkDelegate;
import com.comcast.cim.android.accessibility.TalkDelegateFactory;
import com.comcast.cim.android.view.common.CALDialogFragment;
import com.comcast.cim.android.view.common.ErrorDialogFactory;
import com.comcast.cim.android.view.common.OrientationStrategy;
import com.comcast.cim.cmasl.taskexecutor.exceptions.TaskExecutionException;
import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.listener.DefaultTaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import com.comcast.cim.container.CALContainer;
import com.comcast.cim.container.PlayerContainer;
import com.xfinity.playerlib.model.tags.parser.TagsRoot;
import com.xfinity.playerlib.model.user.PlayNowUserManager;
import java.util.HashMap;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            FilterEventListener, BrowseFilterCategoryDetailPanel, DibicProgramFilter, BrowseFilterCategoriesPanel

public abstract class BrowseFilterDialog extends Activity
    implements FilterEventListener
{

    protected static final Logger LOG = LoggerFactory.getLogger(com/xfinity/playerlib/view/browseprograms/BrowseFilterDialog);
    protected final AccessibilityUtil accessibilityUtil = CALContainer.getInstance().getAccessibilityUtil();
    private View backButton;
    private View bodyContainer;
    protected DibicProgramFilter.FilterCategory category;
    private Intent data;
    private final ErrorDialogFactory errorDialogFactory = PlayerContainer.getInstance().getErrorDialogFactory();
    private TextView headerLabel;
    protected boolean isDualPanel;
    private boolean isInitializing;
    private View loadingIndicator;
    android.app.FragmentManager.OnBackStackChangedListener onBackStackChangedListener;
    private OrientationStrategy orientationStrategy;
    private DibicProgramFilter pendingFilter;
    protected View selectedCategory;
    public TagsRoot tagsRoot;
    private TaskExecutor tagsRootTaskExecutor;
    private TaskExecutionListener tagsTaskExecutionListener;
    protected TalkDelegate talkDelegate;
    TalkDelegateFactory talkDelegateFactory;
    protected PlayNowUserManager userManager;

    public BrowseFilterDialog()
    {
        tagsRootTaskExecutor = PlayerContainer.getInstance().getTagsRootTaskExecutor();
        userManager = PlayerContainer.getInstance().getUserManager();
        talkDelegateFactory = PlayerContainer.getInstance().getTalkDelegateFactory();
        orientationStrategy = PlayerContainer.getInstance().getDefaultOrientationStrategy();
        isInitializing = true;
        category = DibicProgramFilter.FilterCategory.GENRE;
        onBackStackChangedListener = new android.app.FragmentManager.OnBackStackChangedListener() {

            final BrowseFilterDialog this$0;

            public void onBackStackChanged()
            {
                BrowseFilterCategoriesPanel browsefiltercategoriespanel = (BrowseFilterCategoriesPanel)getFragmentManager().findFragmentByTag(BrowseFilterCategoriesPanel.TAG);
                if (!isDualPanel)
                {
                    if (browsefiltercategoriespanel != null && browsefiltercategoriespanel.isVisible())
                    {
                        browsefiltercategoriespanel.updateCategoriesList(getPendingFilter());
                        backButton.setVisibility(4);
                        headerLabel.setText(getString(com.xfinity.playerlib.R.string.filter_title));
                        headerLabel.setContentDescription(getString(com.xfinity.playerlib.R.string.filter_title));
                        getPendingFilter().registerOnChangeListener(browsefiltercategoriespanel.getFilterChangeListener());
                    }
                    resetFocus();
                }
            }

            
            {
                this$0 = BrowseFilterDialog.this;
                super();
            }
        };
    }

    private boolean handleBackButton()
    {
        if (isDualPanel || tagsRoot == null)
        {
            return true;
        }
        BrowseFilterCategoryDetailPanel browsefiltercategorydetailpanel = (BrowseFilterCategoryDetailPanel)getFragmentManager().findFragmentByTag(BrowseFilterCategoryDetailPanel.TAG);
        if (browsefiltercategorydetailpanel != null)
        {
            getPendingFilter().unregisterOnChangeListener(browsefiltercategorydetailpanel.getFilterChangeListener());
        }
        getFragmentManager().popBackStack();
        return false;
    }

    private void hideLoading()
    {
        loadingIndicator.setVisibility(8);
        bodyContainer.setVisibility(0);
    }

    private void showLoading()
    {
        loadingIndicator.setVisibility(0);
        bodyContainer.setVisibility(8);
    }

    private void turnOnTalkBackForAccessibility()
    {
        if (accessibilityUtil.isAccessibilityEnabled() && talkDelegate == null)
        {
            talkDelegate = talkDelegateFactory.getTalkDelegate(this, getWindow().getDecorView().findViewById(0x1020002));
        }
    }

    protected BrowseFilterCategoriesPanel createBrowseFilterCategoriesPanel()
    {
        return BrowseFilterCategoriesPanel.newInstance(isDualPanel);
    }

    protected abstract DibicProgramFilter getFilter();

    protected abstract List getGenres(TagsRoot tagsroot);

    public OrientationStrategy getOrientationStrategy()
    {
        return orientationStrategy;
    }

    protected DibicProgramFilter getPendingFilter()
    {
        if (pendingFilter == null)
        {
            pendingFilter = new DibicProgramFilter(getFilter());
        }
        return pendingFilter;
    }

    protected void handleDone()
    {
        setResult(-1, data);
        getFilter().updateWith(pendingFilter);
        finish();
    }

    public void initialize()
    {
        showLoading();
        tagsTaskExecutionListener = tagsRootTaskExecutor.execute(new DefaultTaskExecutionListener() {

            final BrowseFilterDialog this$0;

            public void onError(TaskExecutionException taskexecutionexception)
            {
                taskexecutionexception = errorDialogFactory.createErrorDialogForThrowable(taskexecutionexception, new com.comcast.cim.android.view.common.CALDialogFragment.TryAgainListener() {

                    final _cls5 this$1;

                    public void tryAgain()
                    {
                        initialize();
                    }

            
            {
                this$1 = _cls5.this;
                super();
            }
                });
                taskexecutionexception.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                    final _cls5 this$1;

                    public void onCancel(DialogInterface dialoginterface)
                    {
                        hideLoading();
                    }

            
            {
                this$1 = _cls5.this;
                super();
            }
                });
                taskexecutionexception.show(getFragmentManager(), "caldialogfragment");
            }

            public void onPostExecute(TagsRoot tagsroot)
            {
                tagsRoot = tagsroot;
                DibicProgramFilter dibicprogramfilter = getPendingFilter();
                BrowseFilterCategoriesPanel browsefiltercategoriespanel = (BrowseFilterCategoriesPanel)getFragmentManager().findFragmentByTag(BrowseFilterCategoriesPanel.TAG);
                if (browsefiltercategoriespanel != null)
                {
                    browsefiltercategoriespanel.initializeCategoriesList(tagsroot, dibicprogramfilter, category);
                    browsefiltercategoriespanel.updateDownloadableCheckbox(dibicprogramfilter.isDownloadableOn());
                    browsefiltercategoriespanel.updateHideLockedCheckbox(dibicprogramfilter.isHideLockOn());
                    if (isDualPanel)
                    {
                        dibicprogramfilter.registerOnChangeListener(browsefiltercategoriespanel.getFilterChangeListener());
                    }
                }
                hideLoading();
            }

            public volatile void onPostExecute(Object obj)
            {
                onPostExecute((TagsRoot)obj);
            }

            
            {
                this$0 = BrowseFilterDialog.this;
                super();
            }
        });
    }

    public void onBackPressed()
    {
        if (handleBackButton())
        {
            super.onBackPressed();
        }
    }

    public void onCategoryChanged(DibicProgramFilter.FilterCategory filtercategory)
    {
        Object obj1 = (BrowseFilterCategoryDetailPanel)getFragmentManager().findFragmentByTag(BrowseFilterCategoryDetailPanel.TAG);
        Object obj;
        if (obj1 == null)
        {
            obj1 = getFragmentManager().beginTransaction();
            obj = BrowseFilterCategoryDetailPanel.newInstance(isDualPanel, getGenres(tagsRoot));
            if (isDualPanel)
            {
                ((FragmentTransaction) (obj1)).add(com.xfinity.playerlib.R.id.category_subpanel_fragment_container, ((android.app.Fragment) (obj)), BrowseFilterCategoryDetailPanel.TAG);
                getPendingFilter().registerOnChangeListener(((BrowseFilterCategoryDetailPanel) (obj)).getFilterChangeListener());
            } else
            if (!isInitializing)
            {
                ((FragmentTransaction) (obj1)).setCustomAnimations(com.xfinity.playerlib.R.anim.slide_in_right, com.xfinity.playerlib.R.anim.slide_out_left, com.xfinity.playerlib.R.anim.slide_in_left, com.xfinity.playerlib.R.anim.slide_out_right);
                ((FragmentTransaction) (obj1)).replace(com.xfinity.playerlib.R.id.categories_panel_fragment_container, ((android.app.Fragment) (obj)), BrowseFilterCategoryDetailPanel.TAG);
                ((FragmentTransaction) (obj1)).addToBackStack(null);
                getPendingFilter().registerOnChangeListener(((BrowseFilterCategoryDetailPanel) (obj)).getFilterChangeListener());
                backButton.setVisibility(0);
            }
            ((FragmentTransaction) (obj1)).commit();
        } else
        {
            ((BrowseFilterCategoryDetailPanel) (obj1)).changeCategoryDetailPanel(this, getPendingFilter(), filtercategory, tagsRoot);
            obj = obj1;
            if (isDualPanel)
            {
                obj = obj1;
                if (isInitializing)
                {
                    getPendingFilter().registerOnChangeListener(((BrowseFilterCategoryDetailPanel) (obj1)).getFilterChangeListener());
                    obj = obj1;
                }
            }
        }
        if (isDualPanel || !isInitializing)
        {
            ((BrowseFilterCategoryDetailPanel) (obj)).changeCategoryDetailPanel(this, getPendingFilter(), filtercategory, tagsRoot);
        }
        isInitializing = false;
        category = filtercategory;
    }

    public void onCreate(Bundle bundle)
    {
        boolean flag = true;
        super.onCreate(bundle);
        setRequestedOrientation(getOrientationStrategy().getAppropriateOrientation());
        data = new Intent();
        data.setFlags(0x2000000);
        setContentView(com.xfinity.playerlib.R.layout.filter_dialog);
        if (accessibilityUtil.isAccessibilityEnabled() || getResources().getInteger(com.xfinity.playerlib.R.integer.filter_dialog_panel_two_weight) != 1)
        {
            flag = false;
        }
        isDualPanel = flag;
        if (bundle != null)
        {
            processSavedInstanceState(bundle);
            category = DibicProgramFilter.FilterCategory.int2FilterCategory(bundle.getInt("category"));
            HashMap hashmap = (HashMap)bundle.getSerializable("pendingGenreFilters");
            HashMap hashmap1 = (HashMap)bundle.getSerializable("pendingAlphaFilters");
            bundle = (HashMap)bundle.getSerializable("pendingNetworkFilters");
            pendingFilter = getPendingFilter();
            pendingFilter.clearAllFilters();
            pendingFilter.getCurrentGenreFilters().putAll(hashmap);
            pendingFilter.getCurrentNetworkFilters().putAll(bundle);
            pendingFilter.getCurrentAlphaFilters().putAll(hashmap1);
        }
        loadingIndicator = findViewById(com.xfinity.playerlib.R.id.loading_indicator);
        bodyContainer = findViewById(com.xfinity.playerlib.R.id.body_container);
        headerLabel = (TextView)findViewById(com.xfinity.playerlib.R.id.header_label);
        if (!isDualPanel)
        {
            backButton = findViewById(com.xfinity.playerlib.R.id.back);
            backButton.setOnClickListener(new android.view.View.OnClickListener() {

                final BrowseFilterDialog this$0;

                public void onClick(View view)
                {
                    handleBackButton();
                }

            
            {
                this$0 = BrowseFilterDialog.this;
                super();
            }
            });
        }
        ((Button)findViewById(com.xfinity.playerlib.R.id.apply)).setOnClickListener(new android.view.View.OnClickListener() {

            final BrowseFilterDialog this$0;

            public void onClick(View view)
            {
                handleDone();
            }

            
            {
                this$0 = BrowseFilterDialog.this;
                super();
            }
        });
        ((Button)findViewById(com.xfinity.playerlib.R.id.clearAll)).setOnClickListener(new android.view.View.OnClickListener() {

            final BrowseFilterDialog this$0;

            public void onClick(View view)
            {
                getPendingFilter().clearAllFilters();
                speak(com.xfinity.playerlib.R.string.cleared);
            }

            
            {
                this$0 = BrowseFilterDialog.this;
                super();
            }
        });
        if ((BrowseFilterCategoriesPanel)getFragmentManager().findFragmentByTag(BrowseFilterCategoriesPanel.TAG) == null)
        {
            bundle = createBrowseFilterCategoriesPanel();
            getFragmentManager().beginTransaction().add(com.xfinity.playerlib.R.id.categories_panel_fragment_container, bundle, BrowseFilterCategoriesPanel.TAG).commit();
        }
    }

    public void onDestroy()
    {
        if (talkDelegate != null)
        {
            talkDelegate.onDestroy();
        }
        super.onDestroy();
    }

    public void onDownloadOnlyChanged(boolean flag)
    {
        getPendingFilter().setDownloadableOn(flag);
    }

    public void onFilterItemDeselected(String s, DibicProgramFilter.FilterCategory filtercategory)
    {
        getPendingFilter().removeFromSelectedList(s, filtercategory);
    }

    public void onFilterItemSelected(String s, String s1, DibicProgramFilter.FilterCategory filtercategory)
    {
        getPendingFilter().addToSelectedList(s, s1, filtercategory);
    }

    protected void onPause()
    {
        super.onPause();
        tagsRootTaskExecutor.cancelNotificationsFor(tagsTaskExecutionListener);
        Object obj = (BrowseFilterCategoriesPanel)getFragmentManager().findFragmentByTag(BrowseFilterCategoriesPanel.TAG);
        if (obj != null)
        {
            getPendingFilter().unregisterOnChangeListener(((BrowseFilterCategoriesPanel) (obj)).getFilterChangeListener());
        }
        obj = (BrowseFilterCategoryDetailPanel)getFragmentManager().findFragmentByTag(BrowseFilterCategoryDetailPanel.TAG);
        if (obj != null)
        {
            getPendingFilter().unregisterOnChangeListener(((BrowseFilterCategoryDetailPanel) (obj)).getFilterChangeListener());
        }
        getFragmentManager().removeOnBackStackChangedListener(onBackStackChangedListener);
    }

    public void onResume()
    {
        super.onResume();
        turnOnTalkBackForAccessibility();
        if (tagsRoot == null)
        {
            initialize();
        }
        getFragmentManager().addOnBackStackChangedListener(onBackStackChangedListener);
        Object obj = (BrowseFilterCategoriesPanel)getFragmentManager().findFragmentByTag(BrowseFilterCategoriesPanel.TAG);
        if (obj != null && ((BrowseFilterCategoriesPanel) (obj)).isVisible())
        {
            getPendingFilter().registerOnChangeListener(((BrowseFilterCategoriesPanel) (obj)).getFilterChangeListener());
        }
        obj = (BrowseFilterCategoryDetailPanel)getFragmentManager().findFragmentByTag(BrowseFilterCategoryDetailPanel.TAG);
        if (obj != null && ((BrowseFilterCategoryDetailPanel) (obj)).isVisible())
        {
            getPendingFilter().registerOnChangeListener(((BrowseFilterCategoryDetailPanel) (obj)).getFilterChangeListener());
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("category", category.ordinal());
        bundle.putSerializable("pendingGenreFilters", getPendingFilter().getCurrentGenreFilters());
        bundle.putSerializable("pendingAlphaFilters", getPendingFilter().getCurrentAlphaFilters());
        bundle.putSerializable("pendingNetworkFilters", getPendingFilter().getCurrentNetworkFilters());
    }

    public boolean onSearchRequested()
    {
        return false;
    }

    public void onSubscriptionOnlyChanged(boolean flag)
    {
        getPendingFilter().setHideLockOn(flag);
    }

    protected abstract void processSavedInstanceState(Bundle bundle);

    protected void resetFocus()
    {
        headerLabel.requestFocus();
    }

    protected void setSelectedCategory(View view)
    {
        if (selectedCategory != null)
        {
            selectedCategory.setSelected(false);
        }
        selectedCategory = view;
        if (isDualPanel)
        {
            selectedCategory.setSelected(true);
        }
    }

    protected void speak(int i)
    {
        if (accessibilityUtil.isAccessibilityEnabled() && talkDelegate != null)
        {
            speak(getString(i));
        }
    }

    protected void speak(String s)
    {
        if (talkDelegate != null)
        {
            talkDelegate.speak(s);
        }
    }






}
