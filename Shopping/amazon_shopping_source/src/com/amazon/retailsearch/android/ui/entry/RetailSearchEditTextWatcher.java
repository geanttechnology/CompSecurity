// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Filter;
import android.widget.ListView;
import com.amazon.retailsearch.android.api.display.input.listeners.QuerySubmitListener;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.android.api.log.SearchBoxLogger;
import com.amazon.retailsearch.android.api.query.Query;
import com.amazon.retailsearch.android.api.query.RetailSearchQuery;
import com.amazon.retailsearch.android.ui.UIUtils;
import com.amazon.retailsearch.data.ISuggestionDataProvider;
import com.amazon.retailsearch.data.SuggestionDataItem;
import com.amazon.retailsearch.data.SuggestionDataProvider;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.j2me.client.util.RetailSearchAndroidPlatform;
import com.amazon.retailsearch.metrics.IssLogger;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            RetailSearchSuggestionCursorAdapter, RetailSearchEditText, TransientSearchChangeListener, SuggestionsItemListener

public class RetailSearchEditTextWatcher
    implements TextWatcher
{
    public class CursorFilter extends Filter
    {

        private static final String ALIAS_APS = "aps";
        public static final String LOG_COLUMN_LOG_IS_FALLBACK = "suggest_log_is_fallback";
        public static final String LOG_COLUMN_LOG_IS_SPELL_CORRECTED = "suggest_log_is_spell_corrected";
        public static final String LOG_COLUMN_LOG_IS_XCAT = "suggest_log_is_xcat";
        public static final String LOG_COLUMN_LOG_POS = "suggest_log_pos";
        public static final String LOG_COLUMN_LOG_QUERY = "suggest_log_query";
        public static final String LOG_COLUMN_LOG_XCAT_POS = "suggest_log_xcat_pos";
        private final String SUGGESTION_COLUMN[];
        Cursor mCursor;
        private CharSequence mLastConstraint;
        private String mSearchAlias;
        private ISuggestionDataProvider mSearchSuggestionProvider;
        final RetailSearchEditTextWatcher this$0;

        private void appendBarcodeEntries(MatrixCursor matrixcursor)
        {
            int j = 0;
            if (mSearchEditText.voiceEnabled())
            {
                j = false | true;
            }
            int i = j;
            if (mSearchEditText.showBarcodeEntry())
            {
                i = j | 2;
            }
            j = i;
            if (mSearchEditText.isFlowEnabled())
            {
                j = i | 8;
            }
            i = j;
            if (mSearchEditText.hasSnapIt())
            {
                i = j | 4;
            }
            j = i;
            if (mSearchEditText.showVisualScan())
            {
                j = i | 0x10;
            }
            matrixcursor.addRow(new String[] {
                "0", String.valueOf(j), null, null, null, null, null, null, null, null, 
                null, null, null, null
            });
        }

        private void appendSuggestionData(MatrixCursor matrixcursor, List list)
        {
            if (matrixcursor != null && list != null)
            {
                int i = 0;
                list = list.iterator();
                while (list.hasNext()) 
                {
                    matrixcursor.addRow(makeSuggestionRow(i, (SuggestionDataItem)list.next()));
                    i++;
                }
            }
        }

        private Drawable getSearchMagnifierImage()
        {
            return mContext.getResources().getDrawable(com.amazon.retailsearch.R.drawable.rs_search_bar_mag_glass);
        }

        private Cursor getSuggestionsCursor(CharSequence charsequence)
        {
            MatrixCursor matrixcursor = new MatrixCursor(SUGGESTION_COLUMN);
            if (TextUtils.isEmpty(mSearchEditText.getCurrentDepartmentName()) && (charsequence.length() == 0 || isFirstTimeEnter))
            {
                MatrixCursor matrixcursor1 = new MatrixCursor(SUGGESTION_COLUMN);
                appendBarcodeEntries(matrixcursor1);
                android.widget.Filter.FilterResults filterresults = new android.widget.Filter.FilterResults();
                filterresults.values = new FilterResultValue(matrixcursor1, (String)charsequence);
                publishResults(charsequence, filterresults, false);
                appendBarcodeEntries(matrixcursor);
            }
            if (mSearchSuggestionProvider != null)
            {
                List list;
                synchronized (mSuggestionLock)
                {
                    list = mSearchSuggestionProvider.getSuggestions(mSearchAlias, charsequence.toString(), forceUpdatePastSearches);
                    forceUpdatePastSearches = false;
                }
                appendSuggestionData(matrixcursor, list);
            }
            mLastConstraint = charsequence;
            isFirstTimeEnter = false;
            return matrixcursor;
            charsequence;
            obj;
            JVM INSTR monitorexit ;
            throw charsequence;
        }

        private String[] makeSuggestionRow(int i, SuggestionDataItem suggestiondataitem)
        {
            String s2 = suggestiondataitem.getSuggestion();
            String s1 = makeQuery("paramText", s2);
            String s3 = suggestiondataitem.getSearchAlias();
            Object obj;
            String s;
            if ("aps".equals(s3))
            {
                obj = null;
            } else
            {
                obj = suggestiondataitem.getDepartmentName();
            }
            s = s1;
            if (!TextUtils.isEmpty(s3))
            {
                s = s1;
                if (!TextUtils.isEmpty(((CharSequence) (obj))))
                {
                    s = addQueryParam(s1, "paramSuggestionDepartmentName", ((String) (obj)));
                }
            }
            s = addQueryParam(s, "paramSuggestionDepartmentFilter", s3);
            return (new String[] {
                Integer.toString(i), "-1", s2, obj, suggestiondataitem.getDeleteURL(), s, suggestiondataitem.getId(), suggestiondataitem.getType().name(), suggestiondataitem.getQuery(), String.valueOf(suggestiondataitem.getPos()), 
                String.valueOf(suggestiondataitem.getXcatPos()), suggestiondataitem.isSpellCorrected(), suggestiondataitem.isXcat(), suggestiondataitem.isFallback()
            });
        }

        public String addQueryParam(String s, String s1, String s2)
        {
            String s3 = s;
            if (!TextUtils.isEmpty(s1))
            {
                s3 = s;
                if (!TextUtils.isEmpty(s2))
                {
                    s3 = (new StringBuilder()).append(s).append("&").append(s1).append("=").append(Uri.encode(s2)).toString();
                }
            }
            return s3;
        }

        public String makeQuery(String s, String s1)
        {
            if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(s1))
            {
                return (new StringBuilder()).append("?").append(s).append("=").append(Uri.encode(s1)).toString();
            } else
            {
                return "?";
            }
        }

        protected android.widget.Filter.FilterResults performFiltering(CharSequence charsequence)
        {
            if (!mSearchEditText.showBarcodeEntry())
            {
                platform.invokeLater(new Runnable() {

                    final CursorFilter this$1;

                    public void run()
                    {
                        if (mSearchEditText != null && mWorkingSpinner != null)
                        {
                            mSearchEditText.setCompoundDrawablesWithIntrinsicBounds(getSearchMagnifierImage(), null, mWorkingSpinner, null);
                            mWorkingSpinner.setVisible(true, false);
                        }
                    }

            
            {
                this$1 = CursorFilter.this;
                super();
            }
                });
            }
            Cursor cursor = getSuggestionsCursor(charsequence);
            android.widget.Filter.FilterResults filterresults = new android.widget.Filter.FilterResults();
            filterresults.values = new FilterResultValue(cursor, (String)charsequence);
            return filterresults;
        }

        protected void publishResults(CharSequence charsequence, android.widget.Filter.FilterResults filterresults)
        {
            publishResults(charsequence, filterresults, true);
        }

        protected void publishResults(final CharSequence cursor, android.widget.Filter.FilterResults filterresults, final boolean hideSpinner)
        {
            if (filterresults != null && filterresults.values != null)
            {
                cursor = ((FilterResultValue)filterresults.values).mCursor;
                filterresults = ((FilterResultValue)filterresults.values).mSearchTerm;
                if (cursor == null)
                {
                    if (mSearchEditText != null && mWorkingSpinner != null)
                    {
                        mWorkingSpinner.setVisible(false, false);
                        mSearchEditText.setCompoundDrawablesWithIntrinsicBounds(getSearchMagnifierImage(), null, null, null);
                        return;
                    }
                } else
                {
                    platform.invokeLater(filterresults. new Runnable() {

                        final CursorFilter this$1;
                        final Cursor val$cursor;
                        final boolean val$hideSpinner;
                        final String val$searchTerm;

                        public void run()
                        {
                            if (hideSpinner && mSearchEditText != null && mWorkingSpinner != null)
                            {
                                mWorkingSpinner.setVisible(false, false);
                                mSearchEditText.setCompoundDrawablesWithIntrinsicBounds(getSearchMagnifierImage(), null, null, null);
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
                            RetailSearchSuggestionCursorAdapter retailsearchsuggestioncursoradapter = new RetailSearchSuggestionCursorAdapter(mContext, cursor, false, searchTerm, new SuggestionsItemListener() {

                                final CursorFilter._cls2 this$2;

                                public void onA9SuggestionShow()
                                {
                                    synchronized (mISSLatencyLock)
                                    {
                                        if (!isISSLatencyLogged)
                                        {
                                            searchBoxLogger.searchSuggestionsFirstEntryShowed();
                                            isISSLatencyLogged = true;
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
                                    (new Thread(s. new Runnable() {

                                        final CursorFilter._cls2._cls1 this$3;
                                        final String val$deleteURL;
                                        final String val$id;

                                        public void run()
                                        {
                                            synchronized (mSuggestionLock)
                                            {
                                                mSearchSuggestionProvider.deletePastSearches(id, deleteURL);
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
                                    searchBoxLogger.recordRecentSearchCleared();
                                }

                                public void onQueryBuilderClick(String s)
                                {
                                    if (s != null && !s.equals(mSearchEditText.getText().toString()))
                                    {
                                        mSearchEditText.setText((new StringBuilder()).append(s).append(" ").toString());
                                        mSearchEditText.setSelection(s.length() + 1);
                                        searchBoxLogger.recordQueryBuilderUsage();
                                    }
                                }

            
            {
                this$2 = CursorFilter._cls2.this;
                super();
            }
                            }, new QuerySubmitListener() {

                                final CursorFilter._cls2 this$2;

                                public volatile void onQuerySubmit(Query query)
                                {
                                    onQuerySubmit((RetailSearchQuery)query);
                                }

                                public void onQuerySubmit(RetailSearchQuery retailsearchquery)
                                {
                                    if (listener != null)
                                    {
                                        UIUtils.closeSoftKeyboard(mSearchEditText);
                                        listener.onQuerySubmit(retailsearchquery);
                                    }
                                }

            
            {
                this$2 = CursorFilter._cls2.this;
                super();
            }
                            });
                            if (mCursor != null)
                            {
                                mCursor.close();
                                mCursor = null;
                            }
                            mCursor = cursor;
                            mSuggstionsListView.setAdapter(retailsearchsuggestioncursoradapter);
                            mSuggstionsListView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                                final CursorFilter._cls2 this$2;

                                public void onItemClick(AdapterView adapterview, View view, int i, long l)
                                {
                                    processSuggestionItemClick(cursor, i);
                                }

            
            {
                this$2 = CursorFilter._cls2.this;
                super();
            }
                            });
                        }

            
            {
                this$1 = final_cursorfilter;
                hideSpinner = flag;
                cursor = cursor1;
                searchTerm = String.this;
                super();
            }
                    });
                    return;
                }
            }
        }


/*
        static CharSequence access$002(CursorFilter cursorfilter, CharSequence charsequence)
        {
            cursorfilter.mLastConstraint = charsequence;
            return charsequence;
        }

*/



        public CursorFilter(ISuggestionDataProvider isuggestiondataprovider, String s)
        {
            this$0 = RetailSearchEditTextWatcher.this;
            super();
            SUGGESTION_COLUMN = (new String[] {
                "_id", "suggest_icon_1", "suggest_text_1", "suggest_text_2", "suggest_text_2_url", "suggest_intent_data", "intent_extra_data_key", "suggest_intent_extra_data", "suggest_log_query", "suggest_log_pos", 
                "suggest_log_xcat_pos", "suggest_log_is_spell_corrected", "suggest_log_is_xcat", "suggest_log_is_fallback"
            });
            mCursor = null;
            synchronized (mSuggestionLock)
            {
                mSearchSuggestionProvider = ISuggestionDataProvider.this;
            }
            mSearchAlias = s;
            return;
            isuggestiondataprovider;
            RetailSearchEditTextWatcher.this;
            JVM INSTR monitorexit ;
            throw ISuggestionDataProvider.this;
        }
    }

    private class FilterResultValue
    {

        public Cursor mCursor;
        public String mSearchTerm;
        final RetailSearchEditTextWatcher this$0;

        public FilterResultValue(Cursor cursor, String s)
        {
            this$0 = RetailSearchEditTextWatcher.this;
            super();
            mCursor = cursor;
            mSearchTerm = s;
        }
    }


    public static final String AUTHORITY = "com.amazon.mShop.search.SuggestionsProvider";
    public static final String REFMARKER = "REFMARKER";
    public static final String SEARCH_SCAN = "sr_scan";
    public static final String SEARCH_SNAP = "sr_snap";
    public static final String SEARCH_URL_LAST_SEGMENT = "/search_suggest_query/";
    private boolean forceUpdatePastSearches;
    private boolean isFirstTimeEnter;
    private boolean isISSLatencyLogged;
    private QuerySubmitListener listener;
    protected final Context mContext;
    private CursorFilter mCursorFilter;
    protected boolean mFirstPreCheck;
    private final Object mISSLatencyLock = new Object();
    private final String mSearchAlias;
    protected final RetailSearchEditText mSearchEditText;
    private final Object mSuggestionLock = new Object();
    private final ListView mSuggstionsListView;
    private final Drawable mWorkingSpinner;
    RetailSearchAndroidPlatform platform;
    private SearchBoxLogger searchBoxLogger;
    private TransientSearchChangeListener transientSearchChangeListener;

    public RetailSearchEditTextWatcher(Context context, ListView listview, RetailSearchEditText retailsearchedittext, String s)
    {
        mCursorFilter = null;
        mFirstPreCheck = false;
        forceUpdatePastSearches = true;
        isFirstTimeEnter = true;
        isISSLatencyLogged = false;
        searchBoxLogger = RetailSearchLoggingProvider.getInstance().getSearchBoxLogger();
        mContext = context;
        mSuggstionsListView = listview;
        mSearchEditText = retailsearchedittext;
        mSearchAlias = s;
        RetailSearchDaggerGraphController.inject(this);
        if (android.os.Build.VERSION.SDK_INT >= 4)
        {
            mWorkingSpinner = context.getResources().getDrawable(com.amazon.retailsearch.R.drawable.rs_search_spinner);
            return;
        } else
        {
            mWorkingSpinner = null;
            return;
        }
    }

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    protected void closeSearchSuggestionCursor()
    {
        if (mCursorFilter != null && mCursorFilter.mCursor != null)
        {
            mCursorFilter.mCursor.close();
            mCursorFilter.mCursor = null;
        }
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (!isISSLatencyLogged && !TextUtils.isEmpty(charsequence))
        {
            searchBoxLogger.searchSuggestionsFirstKeyStroke();
        }
        updateSuggestions(charsequence, false);
    }

    protected void processSuggestionItemClick(Cursor cursor, int i)
    {
        UIUtils.closeSoftKeyboard(mSearchEditText);
        if (listener != null && !RetailSearchSuggestionCursorAdapter.isActionRow(cursor))
        {
            cursor.moveToPosition(i);
            Object obj = Uri.parse(cursor.getString(cursor.getColumnIndex("suggest_intent_data"))).buildUpon().build();
            String s = ((Uri) (obj)).getQueryParameter("paramText");
            obj = ((Uri) (obj)).getQueryParameter("paramSuggestionDepartmentFilter");
            String s1 = mSearchEditText.getText().toString();
            mSearchEditText.setText(s);
            cursor = IssLogger.createLogData(cursor, i, mSearchAlias, ((String) (obj)), s, s1);
            listener.onQuerySubmit(new RetailSearchQuery(((String) (obj)), s, s1, cursor));
        }
    }

    public void setListener(QuerySubmitListener querysubmitlistener)
    {
        listener = querysubmitlistener;
    }

    public void setListener(TransientSearchChangeListener transientsearchchangelistener)
    {
        transientSearchChangeListener = transientsearchchangelistener;
    }

    protected void updateSuggestions(CharSequence charsequence, boolean flag)
    {
        CharSequence charsequence1 = charsequence;
        if (TextUtils.isEmpty(charsequence.toString().trim()))
        {
            charsequence = "";
            charsequence1 = charsequence;
            if (transientSearchChangeListener != null)
            {
                transientSearchChangeListener.onQueryCleared();
                charsequence1 = charsequence;
            }
        }
        if (mCursorFilter == null)
        {
            mCursorFilter = new CursorFilter(new SuggestionDataProvider(mContext), mSearchAlias);
        }
        if (flag)
        {
            mCursorFilter.mLastConstraint = null;
        }
        mCursorFilter.filter(charsequence1);
    }







/*
    static boolean access$402(RetailSearchEditTextWatcher retailsearchedittextwatcher, boolean flag)
    {
        retailsearchedittextwatcher.isFirstTimeEnter = flag;
        return flag;
    }

*/



/*
    static boolean access$502(RetailSearchEditTextWatcher retailsearchedittextwatcher, boolean flag)
    {
        retailsearchedittextwatcher.forceUpdatePastSearches = flag;
        return flag;
    }

*/





/*
    static boolean access$902(RetailSearchEditTextWatcher retailsearchedittextwatcher, boolean flag)
    {
        retailsearchedittextwatcher.isISSLatencyLogged = flag;
        return flag;
    }

*/
}
