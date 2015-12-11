// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.amazon.retailsearch.android.api.query.RetailSearchQuery;
import com.amazon.retailsearch.android.ui.DelayedInitView;
import com.amazon.retailsearch.android.ui.UIUtils;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform;
import com.amazon.retailsearch.metrics.IssLogger;

// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            RetailSearchEditTextWatcher, RetailSearchSuggestionCursorAdapter, SearchEntryViewListener, RetailSearchEntryBar, 
//            RetailSearchEditText

public class RetailSearchEntryView extends LinearLayout
    implements DelayedInitView
{

    public static final String KEY_SEARCH_SELECT_INITIAL_QUERY = "selectInitialQuery";
    public static final String SEARCH_PARAM_TEXT = "paramText";
    public static final String SEARCH_SUGGESTION_DEPARTMENT_FILTER = "paramSuggestionDepartmentFilter";
    public static final String SEARCH_SUGGESTION_DEPARTMENT_NAME = "paramSuggestionDepartmentName";
    private String currentDepartmentName;
    private boolean hasSnapIt;
    private boolean isFlowEnabled;
    private SearchEntryViewListener listener;
    protected RetailSearchEditText mSearchEditText;
    protected ListView mSuggestionListView;
    RetailSearchAndroidPlatform platform;
    private String previousSearchTerm;
    private String searchAlias;
    protected RetailSearchEntryBar searchBar;
    private String searchTerm;
    private String searchUrl;
    private boolean showBarcodeEntry;
    private boolean showVisualScan;
    private RetailSearchEditTextWatcher textWatcher;
    private boolean voiceEnabled;

    public RetailSearchEntryView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        showBarcodeEntry = false;
        hasSnapIt = false;
        isFlowEnabled = false;
        RetailSearchDaggerGraphController.inject(this);
    }

    private void checkForSpecialtyAps()
    {
        if ("APS".equalsIgnoreCase(searchAlias))
        {
            searchUrl = null;
            currentDepartmentName = null;
        }
    }

    private void showSoftKeyBoard()
    {
        ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(mSearchEditText, 0);
    }

    protected RetailSearchEditTextWatcher createSearchTextWatcher()
    {
        return new RetailSearchEditTextWatcher(getContext(), mSuggestionListView, mSearchEditText, null);
    }

    protected void doSearch(String s)
    {
        RetailSearchQuery retailsearchquery;
        if (!TextUtils.isEmpty(searchUrl))
        {
            retailsearchquery = new RetailSearchQuery(s);
            retailsearchquery.setSearchUrl(searchUrl);
        } else
        {
            retailsearchquery = new RetailSearchQuery(s);
        }
        if (mSuggestionListView.getAdapter() != null)
        {
            retailsearchquery.setIssEngagementData(IssLogger.createLogData(((RetailSearchSuggestionCursorAdapter)mSuggestionListView.getAdapter()).getCursor(), searchAlias, s));
        }
        listener.onQuerySubmit(retailsearchquery);
    }

    protected String getCurrentDepartmentName()
    {
        return currentDepartmentName;
    }

    protected String getPreviousSearchTerm()
    {
        return previousSearchTerm;
    }

    public boolean isFlowEnabled()
    {
        return isFlowEnabled;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        searchBar = (RetailSearchEntryBar)findViewById(com.amazon.retailsearch.R.id.rs_search_entry_bar);
        Button button = (Button)searchBar.findViewById(com.amazon.retailsearch.R.id.rs_search_go_btn);
        button.setOnTouchListener(new android.view.View.OnTouchListener() {

            final RetailSearchEntryView this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 0)
                {
                    mSearchEditText.setFocusableInTouchMode(false);
                    mSearchEditText.clearFocus();
                    UIUtils.closeSoftKeyboard(RetailSearchEntryView.this);
                    return false;
                } else
                {
                    mSearchEditText.setFocusableInTouchMode(true);
                    return false;
                }
            }

            
            {
                this$0 = RetailSearchEntryView.this;
                super();
            }
        });
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final RetailSearchEntryView this$0;

            public void onClick(View view)
            {
                view = mSearchEditText.getText().toString().trim();
                doSearch(view);
            }

            
            {
                this$0 = RetailSearchEntryView.this;
                super();
            }
        });
        mSearchEditText = (RetailSearchEditText)searchBar.findViewById(com.amazon.retailsearch.R.id.rs_search_src_text);
        mSuggestionListView = (ListView)findViewById(com.amazon.retailsearch.R.id.rs_search_suggestion_list_view);
        mSearchEditText.enableClearTextButton(true);
        mSearchEditText.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final RetailSearchEntryView this$0;

            public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
            {
                if (i == 2)
                {
                    textview = textview.getText().toString().trim();
                    if (TextUtils.isEmpty(textview))
                    {
                        return true;
                    } else
                    {
                        doSearch(textview.trim());
                        return true;
                    }
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = RetailSearchEntryView.this;
                super();
            }
        });
        searchBar.findViewById(com.amazon.retailsearch.R.id.rs_search_plate).setBackgroundColor(getResources().getColor(com.amazon.retailsearch.R.color.rs_action_bar_end_color));
    }

    public void onPushViewCompleted()
    {
        showSoftKeyBoard();
    }

    public void setCurrentDepartmentName(String s)
    {
        currentDepartmentName = s;
        checkForSpecialtyAps();
    }

    public void setFlowEnabled(boolean flag)
    {
        isFlowEnabled = flag;
    }

    public void setHasSnapIt(boolean flag)
    {
        hasSnapIt = flag;
    }

    public void setListener(SearchEntryViewListener searchentryviewlistener)
    {
        listener = searchentryviewlistener;
        mSearchEditText.setListener(searchentryviewlistener);
        searchBar.setListener(searchentryviewlistener);
    }

    public void setPreviousSearchTerm(String s)
    {
        previousSearchTerm = s;
    }

    public void setSearchAlias(String s)
    {
        searchAlias = s;
        checkForSpecialtyAps();
    }

    public void setSearchTerm(String s)
    {
        searchTerm = s;
    }

    public void setSearchUrl(String s)
    {
        searchUrl = s;
        checkForSpecialtyAps();
    }

    public void setShowBarcodeEntry(boolean flag)
    {
        showBarcodeEntry = flag;
    }

    public void setShowVisualScan(boolean flag)
    {
        showVisualScan = flag;
    }

    public void setVoiceEnabled(boolean flag)
    {
        voiceEnabled = flag;
    }

    public void updateEntryView()
    {
        if (searchTerm == null)
        {
            String s;
            if (mSearchEditText.getText() != null)
            {
                s = mSearchEditText.getText().toString();
            } else
            {
                s = null;
            }
            searchTerm = s;
        }
        if (textWatcher == null)
        {
            textWatcher = new RetailSearchEditTextWatcher(getContext(), mSuggestionListView, mSearchEditText, searchAlias);
            textWatcher.setListener(listener);
            textWatcher.setListener(listener);
            mSearchEditText.removeTextChangedListener(mSearchEditText.getTextChangedListener());
            mSearchEditText.addTextChangedListener(textWatcher);
        }
        mSearchEditText.setVoiceEnabled(voiceEnabled);
        mSearchEditText.setHasSnapIt(hasSnapIt);
        mSearchEditText.setShowBarcodeEntry(showBarcodeEntry);
        mSearchEditText.setCurrentDepartmentName(currentDepartmentName);
        mSearchEditText.setFlowEnabled(isFlowEnabled);
        mSearchEditText.setShowVisualScan(showVisualScan);
        updateSearchEditText(searchTerm);
        platform.invokeLater(new Runnable() {

            final RetailSearchEntryView this$0;

            public void run()
            {
                mSearchEditText.requestFocus();
                mSearchEditText.setSelection(mSearchEditText.getText().length());
            }

            
            {
                this$0 = RetailSearchEntryView.this;
                super();
            }
        });
        if (!TextUtils.isEmpty(currentDepartmentName))
        {
            mSearchEditText.setHint((new StringBuilder()).append(getResources().getString(com.amazon.retailsearch.R.string.rs_search_menu_item)).append(" ").append(getResources().getString(com.amazon.retailsearch.R.string.rs_search_suggestions_department_text, new Object[] {
                currentDepartmentName
            })).toString());
        } else
        {
            mSearchEditText.setHint((new StringBuilder()).append(getResources().getString(com.amazon.retailsearch.R.string.rs_search_menu_item)).append(" ").append(getResources().getString(com.amazon.retailsearch.R.string.rs_search_suggestions_department_text, new Object[] {
                getResources().getString(com.amazon.retailsearch.R.string.rs_search_all_departments)
            })).toString());
        }
        showSoftKeyBoard();
    }

    protected void updateSearchEditText(String s)
    {
        if (TextUtils.isEmpty(mSearchEditText.getText()))
        {
            if (!TextUtils.isEmpty(s))
            {
                mSearchEditText.setText(s);
                return;
            }
            if (TextUtils.isEmpty(currentDepartmentName))
            {
                String s1 = getPreviousSearchTerm();
                RetailSearchEditText retailsearchedittext = mSearchEditText;
                s = s1;
                if (TextUtils.isEmpty(s1))
                {
                    s = "";
                }
                retailsearchedittext.setText(s);
                return;
            }
        }
    }
}
