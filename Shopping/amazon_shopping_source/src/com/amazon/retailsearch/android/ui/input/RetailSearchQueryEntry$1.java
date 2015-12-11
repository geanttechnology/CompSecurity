// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.input;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;
import com.amazon.retailsearch.android.api.display.input.listeners.QuerySubmitListener;
import com.amazon.retailsearch.android.api.query.QuerySource;
import com.amazon.retailsearch.android.api.query.RetailSearchQuery;
import com.amazon.retailsearch.android.ui.ClearableAutoCompleteTextView;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.android.ui.input:
//            RetailSearchQueryEntry

class this._cls0
    implements android.widget.stener
{

    final RetailSearchQueryEntry this$0;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if ((i == 3 || keyevent == null || keyevent.getKeyCode() == 66) && RetailSearchQueryEntry.access$000(RetailSearchQueryEntry.this).getText() != null)
        {
            if (!TextUtils.isEmpty(textview = RetailSearchQueryEntry.access$000(RetailSearchQueryEntry.this).getText().toString()))
            {
                if (textview.matches("^(\\*|\\s)*$"))
                {
                    RetailSearchQueryEntry.access$000(RetailSearchQueryEntry.this).setText("");
                    return false;
                }
                textview = RetailSearchQueryEntry.access$000(RetailSearchQueryEntry.this).getText().toString();
                QuerySubmitListener querysubmitlistener;
                RetailSearchQuery retailsearchquery;
                for (keyevent = RetailSearchQueryEntry.access$100(RetailSearchQueryEntry.this).iterator(); keyevent.hasNext(); querysubmitlistener.onQuerySubmit(retailsearchquery))
                {
                    querysubmitlistener = (QuerySubmitListener)keyevent.next();
                    retailsearchquery = new RetailSearchQuery(textview);
                    retailsearchquery.setRawUserInput(textview);
                    retailsearchquery.setSource(QuerySource.NAV_BAR_INPUT);
                }

                return true;
            }
        }
        return false;
    }

    ubmitListener()
    {
        this$0 = RetailSearchQueryEntry.this;
        super();
    }
}
