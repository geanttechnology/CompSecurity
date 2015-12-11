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

class this._cls2
    implements android.widget.tWatcher.CursorFilter._cls2._cls3
{

    final l.cursor this$2;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        processSuggestionItemClick(cursor, i);
    }

    l.searchTerm()
    {
        this$2 = this._cls2.this;
        super();
    }

    // Unreferenced inner class com/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2

/* anonymous class */
    class RetailSearchEditTextWatcher.CursorFilter._cls2
        implements Runnable
    {

        final RetailSearchEditTextWatcher.CursorFilter this$1;
        final Cursor val$cursor;
        final boolean val$hideSpinner;
        final String val$searchTerm;

        public void run()
        {
            if (hideSpinner && mSearchEditText != null && RetailSearchEditTextWatcher.access$200(this$0) != null)
            {
                RetailSearchEditTextWatcher.access$200(this$0).setVisible(false, false);
                mSearchEditText.setCompoundDrawablesWithIntrinsicBounds(RetailSearchEditTextWatcher.CursorFilter.access$300(RetailSearchEditTextWatcher.CursorFilter.this), null, null, null);
            }
            cursor.moveToFirst();
            if (cursor.getCount() > 0)
            {
                String s = mSearchEditText.getText().toString();
                if (s.length() > 0 && searchTerm.length() > 0 && !s.startsWith(searchTerm) && !searchTerm.startsWith(s))
                {
                    return;
                }
            }
            RetailSearchSuggestionCursorAdapter retailsearchsuggestioncursoradapter = new RetailSearchSuggestionCursorAdapter(mContext, cursor, false, searchTerm, new RetailSearchEditTextWatcher.CursorFilter._cls2._cls1(), new RetailSearchEditTextWatcher.CursorFilter._cls2._cls2());
            if (mCursor != null)
            {
                mCursor.close();
                mCursor = null;
            }
            mCursor = cursor;
            RetailSearchEditTextWatcher.access$1100(this$0).setAdapter(retailsearchsuggestioncursoradapter);
            RetailSearchEditTextWatcher.access$1100(this$0).setOnItemClickListener(new RetailSearchEditTextWatcher.CursorFilter._cls2._cls3());
        }

            
            {
                this$1 = final_cursorfilter;
                hideSpinner = flag;
                cursor = cursor1;
                searchTerm = String.this;
                super();
            }

        // Unreferenced inner class com/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2$1

/* anonymous class */
        class RetailSearchEditTextWatcher.CursorFilter._cls2._cls1
            implements SuggestionsItemListener
        {

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

            public void onDeletePastSearchesClick(final String id, String s)
            {
                (new Thread(s. new RetailSearchEditTextWatcher.CursorFilter._cls2._cls1._cls1())).start();
                RetailSearchEditTextWatcher.access$600(this$0).recordRecentSearchCleared();
            }

            public void onQueryBuilderClick(String s)
            {
                if (s != null && !s.equals(mSearchEditText.getText().toString()))
                {
                    mSearchEditText.setText((new StringBuilder()).append(s).append(" ").toString());
                    mSearchEditText.setSelection(s.length() + 1);
                    RetailSearchEditTextWatcher.access$600(this$0).recordQueryBuilderUsage();
                }
            }

                    
                    {
                        this$2 = RetailSearchEditTextWatcher.CursorFilter._cls2.this;
                        super();
                    }
        }


        // Unreferenced inner class com/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2$1$1

/* anonymous class */
        class RetailSearchEditTextWatcher.CursorFilter._cls2._cls1._cls1
            implements Runnable
        {

            final RetailSearchEditTextWatcher.CursorFilter._cls2._cls1 this$3;
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
        }


        // Unreferenced inner class com/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2$2

/* anonymous class */
        class RetailSearchEditTextWatcher.CursorFilter._cls2._cls2
            implements QuerySubmitListener
        {

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
        }

    }

}
