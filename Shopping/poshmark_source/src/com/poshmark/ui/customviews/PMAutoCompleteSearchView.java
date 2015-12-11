// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.BitmapDrawable;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.AutoCompleteTextView;
import android.widget.FilterQueryProvider;
import android.widget.ListAdapter;
import com.poshmark.data_model.adapters.SearchSuggestionsAdapter;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.PMData;
import com.poshmark.data_model.models.SearchSuggestionsManager;
import com.poshmark.utils.PMSearchBoxTimer;

// Referenced classes of package com.poshmark.ui.customviews:
//            PMCustomSearchWidget

public class PMAutoCompleteSearchView extends AutoCompleteTextView
{

    SearchSuggestionsAdapter adapter;
    boolean bShowRecentsByDefault;
    BitmapDrawable clearButton;
    String currentSearchString;
    PMCustomSearchWidget parentWidget;
    SearchSuggestionsManager suggestionsData;

    public PMAutoCompleteSearchView(Context context)
    {
        super(context);
        bShowRecentsByDefault = true;
    }

    public PMAutoCompleteSearchView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        bShowRecentsByDefault = true;
        setup();
    }

    public PMAutoCompleteSearchView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        bShowRecentsByDefault = true;
    }

    private void setup()
    {
        clearButton = (BitmapDrawable)getResources().getDrawable(0x7f020089);
        adapter = new SearchSuggestionsAdapter(getContext(), null, 0x80000000, null);
        suggestionsData = new SearchSuggestionsManager();
        suggestionsData.setListAdapter(adapter);
        setAdapter(adapter);
        setThreshold(1);
        adapter.setFilterQueryProvider(new FilterQueryProvider() {

            final PMAutoCompleteSearchView this$0;

            public Cursor runQuery(CharSequence charsequence)
            {
                charsequence = adapter.getCursor();
                String s = getText().toString();
                if (s != null)
                {
                    s = s.toString().trim();
                    if (s.length() > 0)
                    {
                        currentSearchString = s;
                        new PMSearchBoxTimer(50, true, s, s. new com.poshmark.utils.PMSearchBoxTimer.PMSearchTimerTaskCallback() {

                            final _cls1 this$1;
                            final String val$newText;

                            public void timerCallback(String s)
                            {
                                if (currentSearchString.equals(s))
                                {
                                    suggestionsData.fillFilteredCursor(newText);
                                }
                            }

            
            {
                this$1 = final__pcls1;
                newText = String.this;
                super();
            }
                        });
                        return charsequence;
                    }
                    if (bShowRecentsByDefault)
                    {
                        return suggestionsData.fillCursorWithRecents();
                    }
                    if (charsequence != null)
                    {
                        charsequence.close();
                    }
                    return new CustomMatrixCursor(new String[] {
                        PMData.ID_COL, PMData.DATA_COL
                    });
                }
                if (bShowRecentsByDefault)
                {
                    return suggestionsData.fillCursorWithRecents();
                }
                if (charsequence != null)
                {
                    charsequence.close();
                }
                return new CustomMatrixCursor(new String[] {
                    PMData.ID_COL, PMData.DATA_COL
                });
            }

            
            {
                this$0 = PMAutoCompleteSearchView.this;
                super();
            }
        });
    }

    public boolean enoughToFilter()
    {
        while (bShowRecentsByDefault || getText().length() >= getThreshold()) 
        {
            return true;
        }
        return false;
    }

    public volatile ListAdapter getAdapter()
    {
        return getAdapter();
    }

    public SearchSuggestionsAdapter getAdapter()
    {
        return adapter;
    }

    public Cursor getCursor()
    {
        return adapter.getCursor();
    }

    public boolean onKeyPreIme(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            if (keyevent.getAction() == 0 && keyevent.getRepeatCount() == 0)
            {
                android.view.KeyEvent.DispatcherState dispatcherstate = getKeyDispatcherState();
                if (dispatcherstate != null)
                {
                    dispatcherstate.startTracking(keyevent, this);
                }
                return true;
            }
            if (keyevent.getAction() == 1)
            {
                android.view.KeyEvent.DispatcherState dispatcherstate1 = getKeyDispatcherState();
                if (dispatcherstate1 != null)
                {
                    dispatcherstate1.handleUpEvent(keyevent);
                }
                if (keyevent.isTracking() && !keyevent.isCanceled())
                {
                    clearFocus();
                    parentWidget.setImeVisibility(false);
                    return true;
                }
            }
        }
        return super.onKeyPreIme(i, keyevent);
    }

    public void setParentWidget(PMCustomSearchWidget pmcustomsearchwidget)
    {
        parentWidget = pmcustomsearchwidget;
    }

    public void setSilentText(String s)
    {
        clearFocus();
        setText(s);
        setAdapter(adapter);
    }

    public void showRecentsAsDefault(boolean flag)
    {
        bShowRecentsByDefault = flag;
    }
}
