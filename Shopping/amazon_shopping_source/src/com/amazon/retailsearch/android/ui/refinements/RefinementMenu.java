// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.refinements;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.interaction.SearchDataSource;
import com.amazon.retailsearch.popup.DialogSizeChangedListener;
import com.amazon.retailsearch.popup.PopupDialog;
import com.amazon.searchapp.retailsearch.model.Department;
import com.amazon.searchapp.retailsearch.model.RefinementFilter;
import com.amazon.searchapp.retailsearch.model.Refinements;
import com.amazon.searchapp.retailsearch.model.Sort;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.refinements:
//            SpinnerHiderRelativeLayout, RefinementsListView, IRefinementsMenuListener

public class RefinementMenu extends RelativeLayout
    implements PopupDialog
{
    private class RefinementsMenuListener
        implements IRefinementsMenuListener
    {

        final RefinementMenu this$0;

        public void OnClearAllClick()
        {
        }

        public void onHide()
        {
            if (listener != null)
            {
                listener.onHide();
            }
        }

        public void onRefinementClick(String s)
        {
            getSpinner().show();
            if (listener != null)
            {
                listener.onRefinementClick(s);
            }
        }

        public void onUpdate(Refinements refinements)
        {
            updateDialogHeight();
            if (listener != null)
            {
                listener.onUpdate(refinements);
            }
            getSpinner().hide();
        }

        public void onViewSizeChanged()
        {
            updateDialogHeight();
            if (listener != null)
            {
                listener.onViewSizeChanged();
            }
        }

        private RefinementsMenuListener()
        {
            this$0 = RefinementMenu.this;
            super();
        }

    }


    SearchDataSource dataSource;
    private int dialogHeight;
    private DialogSizeChangedListener dialogSizeChangedListener;
    private int filtersCount;
    private IRefinementsMenuListener listener;
    private TextView mClearAll;
    private View mContent;
    private Context mContext;
    private View mPopupBackground;
    private int mPopupBackgroundPaddingTop;
    private int mPopupHeaderHeight;
    private RefinementsListView refinementListView;
    private SpinnerHiderRelativeLayout spinner;

    public RefinementMenu(Context context)
    {
        super(context);
        init(context);
    }

    public RefinementMenu(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init(context);
    }

    public RefinementMenu(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init(context);
    }

    private int getFiltersCount(Refinements refinements)
    {
        int j = 0;
        if (refinements == null)
        {
            return 0;
        }
        int i = j;
        if (refinements.getDepartments() != null)
        {
            i = j;
            if (refinements.getDepartments().getAncestry() != null)
            {
                i = j;
                if (refinements.getDepartments().getAncestry().size() > 1)
                {
                    i = 0 + 1;
                }
            }
        }
        j = i;
        if (refinements.getFilters() != null)
        {
            refinements = refinements.getFilters().iterator();
            do
            {
                j = i;
                if (!refinements.hasNext())
                {
                    break;
                }
                if (((RefinementFilter)refinements.next()).getClearLink() != null)
                {
                    i++;
                }
            } while (true);
        }
        return j;
    }

    private SpinnerHiderRelativeLayout getSpinner()
    {
        if (spinner == null)
        {
            spinner = (SpinnerHiderRelativeLayout)findViewById(com.amazon.retailsearch.R.id.refinements_menu_spinner);
        }
        return spinner;
    }

    private void init(Context context)
    {
        RetailSearchDaggerGraphController.inject(this);
        mContext = context;
        mPopupHeaderHeight = context.getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_refinement_menu_popup_header_height);
        mPopupBackgroundPaddingTop = context.getResources().getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_refinement_menu_popup_background_padding_top);
    }

    private void setClearAllEnable(boolean flag)
    {
        if (flag)
        {
            mClearAll.setVisibility(0);
            return;
        } else
        {
            mClearAll.setVisibility(8);
            return;
        }
    }

    public int getDialogHeight()
    {
        return dialogHeight;
    }

    public int getFiltersCount()
    {
        return filtersCount;
    }

    public void notifyRefinementsChanged()
    {
        refinementListView.refresh();
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        updateDialogHeight();
    }

    public void onFinishInflate()
    {
        super.onFinishInflate();
        mPopupBackground = findViewById(com.amazon.retailsearch.R.id.refinements_menu_popup_background);
        mContent = findViewById(com.amazon.retailsearch.R.id.refinements_menu_content);
        mClearAll = (TextView)findViewById(com.amazon.retailsearch.R.id.refinements_menu_clear_all);
        refinementListView = (RefinementsListView)findViewById(com.amazon.retailsearch.R.id.refinements_menu_list_view);
        refinementListView.setListener(new RefinementsMenuListener());
        mClearAll.setOnClickListener(new android.view.View.OnClickListener() {

            final RefinementMenu this$0;

            public void onClick(View view)
            {
                if (listener != null)
                {
                    getSpinner().show();
                    refinementListView.clearAll();
                    listener.OnClearAllClick();
                }
            }

            
            {
                this$0 = RefinementMenu.this;
                super();
            }
        });
    }

    public void setListener(IRefinementsMenuListener irefinementsmenulistener)
    {
        listener = irefinementsmenulistener;
    }

    public void setRefinements(Refinements refinements)
    {
        refinementListView.setRefinements(refinements);
        filtersCount = getFiltersCount(refinements);
        setClearAllEnable(dataSource.isQueryChangedAfterStaged());
    }

    public void setSizeChangeListener(DialogSizeChangedListener dialogsizechangedlistener)
    {
        dialogSizeChangedListener = dialogsizechangedlistener;
    }

    public void setSort(Sort sort)
    {
        refinementListView.setSort(sort);
    }

    public void updateDialogHeight()
    {
        android.view.ViewGroup.LayoutParams layoutparams = mPopupBackground.getLayoutParams();
        int i = mContext.getResources().getDisplayMetrics().heightPixels;
        dialogHeight = refinementListView.getItemsHeight(i) + mContent.getPaddingTop() + mContent.getPaddingBottom() + mPopupHeaderHeight + mPopupBackgroundPaddingTop;
        layoutparams.height = dialogHeight;
        mPopupBackground.setLayoutParams(layoutparams);
        if (dialogSizeChangedListener != null)
        {
            dialogSizeChangedListener.onHeightChanged(dialogHeight);
        }
    }



}
