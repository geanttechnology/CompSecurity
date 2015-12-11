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
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.android.api.query.RetailSearchQuery;
import com.amazon.retailsearch.android.ui.DelayedInitView;
import com.amazon.retailsearch.android.ui.UIUtils;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform;
import com.amazon.retailsearch.metrics.IssLogger;

// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            RetailSearchSuggestionAdapter, SearchEntryViewListener, RetailSearchEditTextWatcher, RetailSearchEntryBar, 
//            RetailSearchEditText, RetailSearchEntryContext

public class RetailSearchEntryView extends LinearLayout
    implements DelayedInitView
{

    private String currentDepartmentName;
    private boolean customHintText;
    private boolean hasSnapIt;
    private boolean isFlowEnabled;
    private SearchEntryViewListener listener;
    protected RetailSearchEditText mSearchEditText;
    protected ListView mSuggestionListView;
    RetailSearchAndroidPlatform platform;
    private String previousSearchTerm;
    private RetailSearchLogger retailSearchLogger;
    private String searchAlias;
    protected RetailSearchEntryBar searchBar;
    private String searchTerm;
    private String searchUrl;
    private boolean showBarcodeEntry;
    private boolean showBarcodeIconForFlow;
    private boolean skipDepartmentResultsFromISS;
    private RetailSearchEditTextWatcher textWatcher;
    private boolean voiceEnabled;

    public RetailSearchEntryView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        showBarcodeEntry = false;
        hasSnapIt = false;
        isFlowEnabled = false;
        customHintText = false;
        skipDepartmentResultsFromISS = false;
        retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
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

    private boolean isInvalidatedKeywords(String s)
    {
        return TextUtils.isEmpty(s) || s.matches("^(\\*|\\s)*$");
    }

    private void showSoftKeyBoard()
    {
        ((InputMethodManager)getContext().getSystemService("input_method")).showSoftInput(mSearchEditText, 0);
    }

    protected void doSearch(String s)
    {
        java.util.List list = null;
        if (mSuggestionListView.getAdapter() != null)
        {
            list = ((RetailSearchSuggestionAdapter)mSuggestionListView.getAdapter()).getSuggestionRows();
        }
        RetailSearchQuery retailsearchquery;
        if (!TextUtils.isEmpty(searchUrl))
        {
            retailsearchquery = new RetailSearchQuery(s);
            retailsearchquery.setSearchUrl(searchUrl);
        } else
        {
            retailsearchquery = new RetailSearchQuery(s);
            try
            {
                retailsearchquery.setRefTag(IssLogger.computeSubmitQueryRefTag(list, s));
            }
            catch (Exception exception)
            {
                retailSearchLogger.error("exception occured while calculating the search box ref-tag", exception);
            }
        }
        if (list != null)
        {
            retailsearchquery.setIssEngagementData(IssLogger.createLogData(list, searchAlias, s));
        }
        listener.onQuerySubmit(retailsearchquery);
        UIUtils.closeSoftKeyboard(this);
        textWatcher.setForceUpdatePastSearches(true);
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

    public boolean isVoiceEnabled()
    {
        return voiceEnabled;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        searchBar = (RetailSearchEntryBar)findViewById(com.amazon.retailsearch.R.id.rs_search_entry_bar);
        mSearchEditText = (RetailSearchEditText)searchBar.findViewById(com.amazon.retailsearch.R.id.rs_search_src_text);
        mSuggestionListView = (ListView)findViewById(com.amazon.retailsearch.R.id.rs_search_suggestion_list_view);
        mSearchEditText.enableClearTextButton(true);
        mSearchEditText.setOnEditorActionListener(new android.widget.TextView.OnEditorActionListener() {

            final RetailSearchEntryView this$0;

            public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
            {
                if (i == 2)
                {
                    keyevent = textview.getText().toString().trim();
                    if (isInvalidatedKeywords(keyevent))
                    {
                        textview.setText("");
                        return true;
                    } else
                    {
                        doSearch(keyevent.trim());
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
        mSearchEditText.setDoSearchListener(new RetailSearchEditText.DoSearchListener() {

            final RetailSearchEntryView this$0;

            public void doSearch(String s)
            {
                RetailSearchEntryView.this.doSearch(s);
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

    public void setCustomHintText(boolean flag)
    {
        customHintText = flag;
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

    public void setShowBarcodeIconForFlow(boolean flag)
    {
        showBarcodeIconForFlow = flag;
    }

    public void setSkipDepartmentResultsFromISS(boolean flag)
    {
        skipDepartmentResultsFromISS = flag;
    }

    public void setVoiceEnabled(boolean flag)
    {
        voiceEnabled = flag;
    }

    public void updateEntryView()
    {
        if (searchTerm == null)
        {
            Object obj;
            if (mSearchEditText.getText() != null)
            {
                obj = mSearchEditText.getText().toString();
            } else
            {
                obj = null;
            }
            searchTerm = ((String) (obj));
        }
        if (textWatcher == null)
        {
            obj = new RetailSearchEntryContext();
            ((RetailSearchEntryContext) (obj)).setCurrentDepartmentName(currentDepartmentName);
            ((RetailSearchEntryContext) (obj)).setShowBarcodeEntry(showBarcodeEntry);
            ((RetailSearchEntryContext) (obj)).setFlowEnabled(isFlowEnabled);
            ((RetailSearchEntryContext) (obj)).setHasSnapIt(hasSnapIt);
            ((RetailSearchEntryContext) (obj)).setVoiceEnabled(voiceEnabled);
            ((RetailSearchEntryContext) (obj)).setShowBarcodeIconForFlow(showBarcodeIconForFlow);
            textWatcher = new RetailSearchEditTextWatcher(getContext(), mSuggestionListView, ((RetailSearchEntryContext) (obj)), mSearchEditText, searchAlias, skipDepartmentResultsFromISS);
            textWatcher.setListener(listener);
            textWatcher.setListener(listener);
            textWatcher.setListener(listener);
            mSearchEditText.removeTextChangedListener(mSearchEditText.getTextChangedListener());
            mSearchEditText.addTextChangedListener(textWatcher);
        } else
        {
            textWatcher.updateCurrentDepartmentName(currentDepartmentName);
        }
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
        if (customHintText)
        {
            mSearchEditText.setHint(getResources().getString(com.amazon.retailsearch.R.string.rs_custom_hint_text));
        } else
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
