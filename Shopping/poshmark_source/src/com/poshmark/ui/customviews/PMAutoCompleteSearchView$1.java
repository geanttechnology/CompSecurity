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
//            PMAutoCompleteSearchView

class this._cls0
    implements FilterQueryProvider
{

    final PMAutoCompleteSearchView this$0;

    public Cursor runQuery(CharSequence charsequence)
    {
        charsequence = adapter.getCursor();
        final String newText = getText().toString();
        if (newText != null)
        {
            newText = newText.toString().trim();
            if (newText.length() > 0)
            {
                currentSearchString = newText;
                new PMSearchBoxTimer(50, true, newText, new com.poshmark.utils.PMSearchBoxTimer.PMSearchTimerTaskCallback() {

                    final PMAutoCompleteSearchView._cls1 this$1;
                    final String val$newText;

                    public void timerCallback(String s)
                    {
                        if (currentSearchString.equals(s))
                        {
                            suggestionsData.fillFilteredCursor(newText);
                        }
                    }

            
            {
                this$1 = PMAutoCompleteSearchView._cls1.this;
                newText = s;
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

    _cls1.val.newText()
    {
        this$0 = PMAutoCompleteSearchView.this;
        super();
    }
}
