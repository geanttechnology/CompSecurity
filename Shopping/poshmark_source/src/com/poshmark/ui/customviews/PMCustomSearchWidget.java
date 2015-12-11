// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.poshmark.controllers.GlobalDbController;
import com.poshmark.controllers.UserStateSummaryController;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.PMData;
import com.poshmark.data_model.models.SuggestedSearchItem;
import com.poshmark.data_model.models.UserStateSummary;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.utils.FBDPAHelper;
import com.poshmark.utils.PMSearchViewListener;
import com.poshmark.utils.SearchFilterModel;

// Referenced classes of package com.poshmark.ui.customviews:
//            PMAutoCompleteSearchView

public class PMCustomSearchWidget extends FrameLayout
{

    PMContainerActivity activity;
    ImageView clearButton;
    private Runnable mShowImeRunnable;
    PMSearchViewListener parentListener;
    PMAutoCompleteSearchView searchView;

    public PMCustomSearchWidget(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mShowImeRunnable = new Runnable() {

            final PMCustomSearchWidget this$0;

            public void run()
            {
                InputMethodManager inputmethodmanager = (InputMethodManager)getContext().getSystemService("input_method");
                if (inputmethodmanager != null)
                {
                    inputmethodmanager.showSoftInput(searchView, 0);
                }
            }

            
            {
                this$0 = PMCustomSearchWidget.this;
                super();
            }
        };
        activity = (PMContainerActivity)context;
        LayoutInflater.from(getContext()).inflate(0x7f030036, this, true);
        setup();
        setFocusable(true);
    }

    private void setup()
    {
        searchView = (PMAutoCompleteSearchView)findViewById(0x7f0c00ec);
        searchView.setHintTextColor(getResources().getColor(0x7f090039));
        searchView.setParentWidget(this);
        searchView.addTextChangedListener(new TextWatcher() {

            final PMCustomSearchWidget this$0;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
                if (charsequence.length() > 0)
                {
                    clearButton.setVisibility(0);
                } else
                {
                    clearButton.setVisibility(4);
                    if ((charsequence == null || charsequence.length() == 0) && parentListener != null)
                    {
                        parentListener.clearSearchString();
                        return;
                    }
                }
            }

            
            {
                this$0 = PMCustomSearchWidget.this;
                super();
            }
        });
        searchView.setOnTouchListener(new android.view.View.OnTouchListener() {

            final PMCustomSearchWidget this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 1)
                {
                    searchView.setText(searchView.getText());
                }
                return false;
            }

            
            {
                this$0 = PMCustomSearchWidget.this;
                super();
            }
        });
        searchView.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final PMCustomSearchWidget this$0;

            public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
            {
                if (i == 3)
                {
                    textview = textview.getText().toString();
                    keyevent = new SuggestedSearchItem();
                    keyevent.kw = textview.trim();
                    keyevent.type = "kw";
                    launchSearch(keyevent, true);
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = PMCustomSearchWidget.this;
                super();
            }
        });
        searchView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final PMCustomSearchWidget this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = (CustomMatrixCursor)searchView.getCursor();
                if (adapterview.moveToPosition(i))
                {
                    adapterview = (SuggestedSearchItem)adapterview.get(adapterview.getColumnIndex(PMData.DATA_COL));
                    searchView.setText(null);
                    launchSearch(adapterview, false);
                }
            }

            
            {
                this$0 = PMCustomSearchWidget.this;
                super();
            }
        });
        searchView.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

            final PMCustomSearchWidget this$0;

            public void onFocusChange(View view, boolean flag)
            {
                setImeVisibility(flag);
                if (flag)
                {
                    searchView.setText(searchView.getText());
                }
            }

            
            {
                this$0 = PMCustomSearchWidget.this;
                super();
            }
        });
        clearButton = (ImageView)findViewById(0x7f0c00ed);
        clearButton.setOnClickListener(new android.view.View.OnClickListener() {

            final PMCustomSearchWidget this$0;

            public void onClick(View view)
            {
                searchView.setText("");
                clearButton.setVisibility(4);
            }

            
            {
                this$0 = PMCustomSearchWidget.this;
                super();
            }
        });
    }

    public void clearFocus()
    {
        searchView.clearFocus();
    }

    public String getUserInput()
    {
        return searchView.getText().toString();
    }

    public void launchSearch(SuggestedSearchItem suggestedsearchitem, boolean flag)
    {
        boolean flag1 = false;
        Object obj = searchView.getCursor();
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        boolean flag2 = GlobalDbController.getGlobalDbController().isKeywordInSavedSearches(suggestedsearchitem.kw);
        GlobalDbController.getGlobalDbController().addNewSearchToSavedSearches(suggestedsearchitem.kw);
        obj = new SearchFilterModel();
        ((SearchFilterModel) (obj)).setAvailability("available");
        Object obj1 = UserStateSummaryController.getGlobalInteractionsController().getUserStateSummary();
        if (obj1 != null && ((UserStateSummary) (obj1)).user_info.isMySizeAvailable())
        {
            ((SearchFilterModel) (obj)).enableMySizeFilter(true);
        }
        obj1 = new Bundle();
        if (suggestedsearchitem.type != null && suggestedsearchitem.type.equalsIgnoreCase("brand"))
        {
            ((SearchFilterModel) (obj)).setSearchTrigger("br");
            flag1 = true;
            ((Bundle) (obj1)).putString("ID", GlobalDbController.getGlobalDbController().getBrandCanonicalName(suggestedsearchitem.kw));
        } else
        {
            ((SearchFilterModel) (obj)).setQueryText(suggestedsearchitem.kw);
            ((SearchFilterModel) (obj)).setSearchTrigger("sl");
        }
        ((SearchFilterModel) (obj)).setFacet("category_v2");
        ((SearchFilterModel) (obj)).setFacet("brand");
        ((SearchFilterModel) (obj)).setFacet("size");
        ((SearchFilterModel) (obj)).setFacet("color");
        ((SearchFilterModel) (obj)).setFacet("category_feature");
        ((Bundle) (obj1)).putString("SEARCH_TRIGGER", "sl");
        if (flag)
        {
            ((Bundle) (obj1)).putString("KEYWORD_SOURCE", "dir");
        } else
        if (flag2)
        {
            ((Bundle) (obj1)).putString("KEYWORD_SOURCE", "hst");
        } else
        {
            ((Bundle) (obj1)).putString("KEYWORD_SOURCE", "ac");
        }
        if (parentListener != null)
        {
            FBDPAHelper.trackSearch(suggestedsearchitem.kw);
            parentListener.fireKeywordSearch(((Bundle) (obj1)), ((SearchFilterModel) (obj)), flag1);
        }
    }

    public void setImeVisibility(boolean flag)
    {
        if (flag)
        {
            post(mShowImeRunnable);
        } else
        {
            removeCallbacks(mShowImeRunnable);
            InputMethodManager inputmethodmanager = (InputMethodManager)getContext().getSystemService("input_method");
            if (inputmethodmanager != null)
            {
                inputmethodmanager.hideSoftInputFromWindow(getWindowToken(), 0);
                return;
            }
        }
    }

    public void setParentListener(PMSearchViewListener pmsearchviewlistener)
    {
        parentListener = pmsearchviewlistener;
    }

    public void setSilentText(String s)
    {
        searchView.setSilentText(s);
    }

    public void setText(String s)
    {
        searchView.setText(s);
        activity.getWindow().setSoftInputMode(4);
    }

    public void showRecentsAsDefaults(boolean flag)
    {
        if (searchView != null)
        {
            searchView.showRecentsAsDefault(flag);
            searchView.requestFocus();
            searchView.setText("");
            searchView.dispatchKeyEvent(new KeyEvent(0, 67));
        }
    }
}
