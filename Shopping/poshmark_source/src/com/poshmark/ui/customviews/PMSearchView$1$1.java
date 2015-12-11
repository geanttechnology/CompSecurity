// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.database.Cursor;
import android.widget.FilterQueryProvider;
import com.poshmark.data_model.adapters.SearchSuggestionsAdapter;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.PMData;
import com.poshmark.data_model.models.SearchSuggestionsManager;
import com.poshmark.utils.PMSearchBoxTimer;

// Referenced classes of package com.poshmark.ui.customviews:
//            PMSearchView

class val.newText
    implements com.poshmark.utils.PMSearchTimerTaskCallback
{

    final val.newText this$1;
    final String val$newText;

    public void timerCallback(String s)
    {
        if (currentSearchString.equals(s))
        {
            suggestionsData.fillFilteredCursor(val$newText);
        }
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$newText = String.this;
        super();
    }

    // Unreferenced inner class com/poshmark/ui/customviews/PMSearchView$1

/* anonymous class */
    class PMSearchView._cls1
        implements FilterQueryProvider
    {

        final PMSearchView this$0;

        public Cursor runQuery(CharSequence charsequence)
        {
            charsequence = adapter.getCursor();
            String s = getQuery().toString();
            if (s != null)
            {
                s = s.toString().trim();
                if (s.length() > 0)
                {
                    currentSearchString = s;
                    new PMSearchBoxTimer(50, true, s, s. new PMSearchView._cls1._cls1());
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
                this$0 = PMSearchView.this;
                super();
            }
    }

}
