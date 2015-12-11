// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;
import com.amazon.retailsearch.android.api.display.input.listeners.QuerySubmitListener;
import com.amazon.retailsearch.android.api.query.QuerySource;
import com.amazon.retailsearch.android.api.query.RetailSearchQuery;
import com.amazon.retailsearch.android.ui.entry.RetailSearchSuggestionAdapter;
import com.amazon.retailsearch.metrics.IssLogger;
import com.amazon.retailsearch.util.UrlUtils;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.ui:
//            ClearableAutocompleteSearchEntry, SearchEntryAutocompleteTextView

class this._cls0
    implements android.widget.mpleteSearchEntry._cls1
{

    final ClearableAutocompleteSearchEntry this$0;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if ((i == 3 || keyevent == null || keyevent.getKeyCode() == 66) && ClearableAutocompleteSearchEntry.access$000(ClearableAutocompleteSearchEntry.this).getText() != null)
        {
            if (!TextUtils.isEmpty(keyevent = ClearableAutocompleteSearchEntry.access$000(ClearableAutocompleteSearchEntry.this).getText().toString().trim()))
            {
                if (keyevent.matches("^(\\*|\\s)*$"))
                {
                    ClearableAutocompleteSearchEntry.access$000(ClearableAutocompleteSearchEntry.this).setText("");
                    return false;
                }
                textview = new RetailSearchQuery(keyevent);
                if (ClearableAutocompleteSearchEntry.access$100(ClearableAutocompleteSearchEntry.this) != null)
                {
                    try
                    {
                        textview.setSearchUrl(UrlUtils.getSearchUrl(ClearableAutocompleteSearchEntry.access$100(ClearableAutocompleteSearchEntry.this), keyevent));
                    }
                    catch (UnsupportedEncodingException unsupportedencodingexception) { }
                }
                textview.setRawUserInput(keyevent);
                textview.setSource(QuerySource.NAV_BAR_INPUT);
                textview.setRefTag(IssLogger.computeSubmitQueryRefTag(ClearableAutocompleteSearchEntry.access$200(ClearableAutocompleteSearchEntry.this).getSuggestionRows(), keyevent));
                for (keyevent = ClearableAutocompleteSearchEntry.access$300(ClearableAutocompleteSearchEntry.this).iterator(); keyevent.hasNext(); ((QuerySubmitListener)keyevent.next()).onQuerySubmit(textview)) { }
                ClearableAutocompleteSearchEntry.access$102(ClearableAutocompleteSearchEntry.this, null);
                return true;
            }
        }
        return false;
    }

    tListener()
    {
        this$0 = ClearableAutocompleteSearchEntry.this;
        super();
    }
}
