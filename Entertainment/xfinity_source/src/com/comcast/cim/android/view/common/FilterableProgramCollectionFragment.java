// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import com.comcast.cim.android.view.flow.FilterRequestObserver;
import com.comcast.cim.cmasl.android.util.system.InternetConnection;
import com.comcast.cim.cmasl.android.util.view.widget.DefaultLoadingViewDelegate;
import com.comcast.cim.cmasl.android.util.view.widget.EntityGridView;
import com.comcast.cim.cmasl.android.util.view.widget.LoadingIndicator;
import com.comcast.cim.cmasl.utils.CommonUtils;
import com.comcast.cim.container.CALContainer;

// Referenced classes of package com.comcast.cim.android.view.common:
//            SearchableFragment

public abstract class FilterableProgramCollectionFragment extends SearchableFragment
{
    class QuickReturnOnScrollChangedListener
        implements com.comcast.cim.cmasl.android.util.view.widget.EntityGridView.OnScrollChangedListener
    {

        private final View quickReturnView;
        private int quickReturnViewHeight;
        private Rect referenceQuickReturnViewRect;
        final FilterableProgramCollectionFragment this$0;

        public void adjustReferenceRectVerticals(int i)
        {
            quickReturnView.setTranslationY(0.0F);
            Rect rect = referenceQuickReturnViewRect;
            rect.top = rect.top + i;
            rect = referenceQuickReturnViewRect;
            rect.bottom = rect.bottom + i;
        }

        public void onScrollChanged(float f, float f1)
        {
            if (f1 <= 0.001F && f1 >= -1F * 0.001F) goto _L2; else goto _L1
_L1:
            Rect rect;
            rect = new Rect();
            quickReturnView.getGlobalVisibleRect(rect);
            if ((f1 <= 0.0F || rect.bottom <= referenceQuickReturnViewRect.top || rect.top <= referenceQuickReturnViewRect.top - quickReturnViewHeight) && (f1 >= 0.0F || rect.bottom >= referenceQuickReturnViewRect.bottom)) goto _L4; else goto _L3
_L3:
            if (f1 >= 0.0F || (float)rect.bottom - f1 <= (float)referenceQuickReturnViewRect.bottom) goto _L6; else goto _L5
_L5:
            quickReturnView.setTranslationY(0.0F);
_L2:
            return;
_L6:
            f = quickReturnView.getTranslationY();
            quickReturnView.setTranslationY(f - f1);
            return;
_L4:
            if (rect.bottom > referenceQuickReturnViewRect.bottom)
            {
                quickReturnView.setTranslationY(0.0F);
                return;
            }
            if (true) goto _L2; else goto _L7
_L7:
        }




/*
        static int access$102(QuickReturnOnScrollChangedListener quickreturnonscrollchangedlistener, int i)
        {
            quickreturnonscrollchangedlistener.quickReturnViewHeight = i;
            return i;
        }

*/

        public QuickReturnOnScrollChangedListener(View view)
        {
            this.this$0 = FilterableProgramCollectionFragment.this;
            super();
            referenceQuickReturnViewRect = new Rect();
            quickReturnView = view;
            view.getViewTreeObserver().addOnGlobalLayoutListener(view. new _cls1());
        }
    }


    protected ViewGroup bodyContainer;
    protected EntityGridView entityGridView;
    protected View filterButton;
    protected FilterRequestObserver filterRequestObserver;
    private View header;
    private final InternetConnection internetConnection = CALContainer.getInstance().getInternetConnection();
    protected ViewGroup layout;
    DefaultLoadingViewDelegate loadingViewDelegate;
    protected int positionOfLastClickedItem;
    private QuickReturnOnScrollChangedListener quickReturnOnScrollChangedListener;
    protected View sortBar;

    public FilterableProgramCollectionFragment()
    {
    }

    private void buildHeaderView()
    {
        header = new View(getActivity());
        header.setLayoutParams(new android.widget.AbsListView.LayoutParams(-1, getResources().getDimensionPixelSize(com.comcast.cim.android.R.dimen.grid_header_height)));
    }

    private android.widget.AdapterView.OnItemClickListener getOnProgramClickListener()
    {
        return new android.widget.AdapterView.OnItemClickListener() {

            final FilterableProgramCollectionFragment this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                positionOfLastClickedItem = i;
                adapterview = ((AdapterView) (CommonUtils.uncheckedCast(adapterview.getItemAtPosition(i))));
                itemClicked(adapterview);
            }

            
            {
                this$0 = FilterableProgramCollectionFragment.this;
                super();
            }
        };
    }

    private android.widget.AdapterView.OnItemLongClickListener getOnProgramLongClickListener()
    {
        return new android.widget.AdapterView.OnItemLongClickListener() {

            final FilterableProgramCollectionFragment this$0;

            public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = ((AdapterView) (CommonUtils.uncheckedCast(adapterview.getItemAtPosition(i))));
                itemLongClicked(adapterview);
                return true;
            }

            
            {
                this$0 = FilterableProgramCollectionFragment.this;
                super();
            }
        };
    }

    protected void adjustQuickReturnView(int i)
    {
        if (quickReturnOnScrollChangedListener != null)
        {
            quickReturnOnScrollChangedListener.adjustReferenceRectVerticals(i);
        }
    }

    protected abstract void applyFilter();

    protected void enableFilterButton()
    {
label0:
        {
            if (getLoadingViewDelegate().resourcesLoaded())
            {
                if (filterButton == null)
                {
                    break label0;
                }
                filterButton.setEnabled(true);
            }
            return;
        }
        getActivity().invalidateOptionsMenu();
    }

    protected abstract int getBodyContainerId();

    protected abstract int getFilterButtonId();

    protected abstract android.view.View.OnClickListener getFilterButtonOnClickListener();

    protected abstract int getLayoutId();

    protected abstract int getListViewHeaderId();

    protected abstract int getListViewId();

    protected abstract int getLoadingIndicatorId();

    public DefaultLoadingViewDelegate getLoadingViewDelegate()
    {
        return loadingViewDelegate;
    }

    protected abstract BaseAdapter getProgramAdapter(LayoutInflater layoutinflater);

    protected abstract View getQuickReturnView(View view);

    protected abstract int getTopScrollingShadowId();

    protected abstract boolean isSortable();

    protected abstract void itemClicked(Object obj);

    protected abstract void itemLongClicked(Object obj);

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        applyFilter();
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        filterRequestObserver = (FilterRequestObserver)activity;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layout = (ViewGroup)layoutinflater.inflate(getLayoutId(), viewgroup, false);
        filterButton = layout.findViewById(getFilterButtonId());
        if (filterButton != null)
        {
            filterButton.setOnClickListener(getFilterButtonOnClickListener());
        }
        bodyContainer = (ViewGroup)layout.findViewById(getBodyContainerId());
        entityGridView = (EntityGridView)layout.findViewById(getListViewId());
        sortBar = layout.findViewById(getListViewHeaderId());
        viewgroup = layout.findViewById(getTopScrollingShadowId());
        entityGridView.setScrollingShadow(viewgroup);
        if (isSortable())
        {
            buildHeaderView();
            entityGridView.addHeaderView(header);
            quickReturnOnScrollChangedListener = new QuickReturnOnScrollChangedListener(getQuickReturnView(layout));
            entityGridView.setOnScrollChangedListener(quickReturnOnScrollChangedListener);
        }
        entityGridView.initialize(getProgramAdapter(layoutinflater));
        entityGridView.setOnItemClickListener(getOnProgramClickListener());
        entityGridView.setOnItemLongClickListener(getOnProgramLongClickListener());
        layoutinflater = layout.findViewById(0x1020004);
        entityGridView.setEmptyView(layoutinflater);
        layoutinflater = (ViewGroup)layout.findViewById(com.comcast.cim.android.R.id.body_container);
        viewgroup = (LoadingIndicator)layout.findViewById(com.comcast.cim.android.R.id.loading_indicator);
        loadingViewDelegate = new DefaultLoadingViewDelegate(getActivity(), layoutinflater, viewgroup, internetConnection, new com.comcast.cim.cmasl.android.util.view.widget.DefaultLoadingViewDelegate.ReadyListener() {

            final FilterableProgramCollectionFragment this$0;

            public void onReady()
            {
                applyFilter();
            }

            
            {
                this$0 = FilterableProgramCollectionFragment.this;
                super();
            }
        });
        return layout;
    }

    protected void onHideSortBar()
    {
        if (header != null && entityGridView.getHeaderViewCount() > 0)
        {
            entityGridView.removeHeaderView(header);
        }
    }

    public void onResumeInternal()
    {
        super.onResumeInternal();
        if (filterButton != null)
        {
            filterButton.setEnabled(getLoadingViewDelegate().resourcesLoaded());
        }
    }

    protected void onShowSortBar()
    {
        if (header != null && entityGridView.getHeaderViewCount() == 0)
        {
            buildHeaderView();
            entityGridView.addHeaderView(header);
        }
    }

    public void onStartInternal()
    {
        super.onStartInternal();
        loadingViewDelegate.onStart();
    }

    public void onStop()
    {
        super.onStop();
        loadingViewDelegate.onStop();
    }

    // Unreferenced inner class com/comcast/cim/android/view/common/FilterableProgramCollectionFragment$QuickReturnOnScrollChangedListener$1

/* anonymous class */
    class QuickReturnOnScrollChangedListener._cls1
        implements android.view.ViewTreeObserver.OnGlobalLayoutListener
    {

        final QuickReturnOnScrollChangedListener this$1;
        final View val$quickReturnView;
        final FilterableProgramCollectionFragment val$this$0;

        public void onGlobalLayout()
        {
label0:
            {
                quickReturnView.getGlobalVisibleRect(referenceQuickReturnViewRect);
                quickReturnViewHeight = referenceQuickReturnViewRect.bottom - referenceQuickReturnViewRect.top;
                if (quickReturnViewHeight > 0)
                {
                    if (android.os.Build.VERSION.SDK_INT < 16)
                    {
                        break label0;
                    }
                    quickReturnView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                return;
            }
            quickReturnView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }

            
            {
                this$1 = final_quickreturnonscrollchangedlistener;
                this$0 = filterableprogramcollectionfragment;
                quickReturnView = View.this;
                super();
            }
    }

}
