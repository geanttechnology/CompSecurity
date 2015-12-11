// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;

import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.amazon.retailsearch.android.api.display.input.listeners.QuerySubmitListener;
import com.amazon.retailsearch.android.api.log.SearchBoxLogger;
import com.amazon.retailsearch.android.api.query.Query;
import com.amazon.retailsearch.android.api.query.RetailSearchQuery;
import com.amazon.retailsearch.android.ui.UIUtils;
import com.amazon.retailsearch.data.ISuggestionDataProvider;

// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            RetailSearchEditTextWatcher, RetailSearchEditText, RetailSearchSuggestionCursorAdapter, SuggestionsItemListener

class val.searchTerm
    implements Runnable
{

    final val.cursor this$1;
    final Cursor val$cursor;
    final boolean val$hideSpinner;
    final String val$searchTerm;

    public void run()
    {
        if (val$hideSpinner && mSearchEditText != null && RetailSearchEditTextWatcher.access$200(_fld0) != null)
        {
            RetailSearchEditTextWatcher.access$200(_fld0).setVisible(false, false);
            mSearchEditText.setCompoundDrawablesWithIntrinsicBounds(cess._mth300(this._cls1.this), null, null, null);
        }
        val$cursor.moveToFirst();
        if (val$cursor.getCount() > 0)
        {
            String s = mSearchEditText.getText().toString();
            if (s.length() > 0 && val$searchTerm.length() > 0 && !s.startsWith(val$searchTerm) && !val$searchTerm.startsWith(s))
            {
                return;
            }
        }
        RetailSearchSuggestionCursorAdapter retailsearchsuggestioncursoradapter = new RetailSearchSuggestionCursorAdapter(mContext, val$cursor, false, val$searchTerm, new SuggestionsItemListener() {

            final RetailSearchEditTextWatcher.CursorFilter._cls2 this$2;

            public void onA9SuggestionShow()
            {
                synchronized (RetailSearchEditTextWatcher.access$800(this$0))
                {
                    if (!RetailSearchEditTextWatcher.access$900(this$0))
                    {
                        RetailSearchEditTextWatcher.access$600(this$0).searchSuggestionsFirstEntryShowed();
                        RetailSearchEditTextWatcher.access$902(this$0, true);
                    }
                }
                return;
                exception;
                obj;
                JVM INSTR monitorexit ;
                throw exception;
            }

            public void onDeletePastSearchesClick(final String id, String s1)
            {
                (new Thread(s1. new Runnable() {

                    final _cls1 this$3;
                    final String val$deleteURL;
                    final String val$id;

                    public void run()
                    {
                        synchronized (RetailSearchEditTextWatcher.access$100(this$0))
                        {
                            RetailSearchEditTextWatcher.CursorFilter.access$700(this$1).deletePastSearches(id, deleteURL);
                        }
                        updateSuggestions(mSearchEditText.getText(), true);
                        return;
                        exception;
                        obj;
                        JVM INSTR monitorexit ;
                        throw exception;
                    }

            
            {
                this$3 = final__pcls1;
                id = s;
                deleteURL = String.this;
                super();
            }
                })).start();
                RetailSearchEditTextWatcher.access$600(this$0).recordRecentSearchCleared();
            }

            public void onQueryBuilderClick(String s1)
            {
                if (s1 != null && !s1.equals(mSearchEditText.getText().toString()))
                {
                    mSearchEditText.setText((new StringBuilder()).append(s1).append(" ").toString());
                    mSearchEditText.setSelection(s1.length() + 1);
                    RetailSearchEditTextWatcher.access$600(this$0).recordQueryBuilderUsage();
                }
            }

            
            {
                this$2 = RetailSearchEditTextWatcher.CursorFilter._cls2.this;
                super();
            }
        }, new QuerySubmitListener() {

            final RetailSearchEditTextWatcher.CursorFilter._cls2 this$2;

            public volatile void onQuerySubmit(Query query)
            {
                onQuerySubmit((RetailSearchQuery)query);
            }

            public void onQuerySubmit(RetailSearchQuery retailsearchquery)
            {
                if (RetailSearchEditTextWatcher.access$1000(this$0) != null)
                {
                    UIUtils.closeSoftKeyboard(mSearchEditText);
                    RetailSearchEditTextWatcher.access$1000(this$0).onQuerySubmit(retailsearchquery);
                }
            }

            
            {
                this$2 = RetailSearchEditTextWatcher.CursorFilter._cls2.this;
                super();
            }
        });
        if (ursor != null)
        {
            ursor.close();
            ursor = null;
        }
        ursor = val$cursor;
        RetailSearchEditTextWatcher.access$1100(_fld0).setAdapter(retailsearchsuggestioncursoradapter);
        RetailSearchEditTextWatcher.access$1100(_fld0).setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final RetailSearchEditTextWatcher.CursorFilter._cls2 this$2;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                processSuggestionItemClick(cursor, i);
            }

            
            {
                this$2 = RetailSearchEditTextWatcher.CursorFilter._cls2.this;
                super();
            }
        });
    }

    _cls3.this._cls2()
    {
        this$1 = final__pcls2;
        val$hideSpinner = flag;
        val$cursor = cursor1;
        val$searchTerm = String.this;
        super();
    }
}
