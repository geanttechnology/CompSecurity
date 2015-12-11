// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;

// Referenced classes of package com.amazon.retailsearch.android.ui:
//            UIUtils

public class SearchEntryAutocompleteTextView extends AutoCompleteTextView
{

    public SearchEntryAutocompleteTextView(Context context)
    {
        super(context);
    }

    public SearchEntryAutocompleteTextView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    public SearchEntryAutocompleteTextView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
    }

    public boolean enoughToFilter()
    {
        return true;
    }

    protected void onFocusChanged(boolean flag, int i, Rect rect)
    {
        super.onFocusChanged(flag, i, rect);
        if (flag && getAdapter() != null)
        {
            try
            {
                performFiltering(getText(), 0);
                showDropDown();
            }
            // Misplaced declaration of an exception variable
            catch (Rect rect)
            {
                RetailSearchLoggingProvider.getInstance().getRetailSearchLogger().error("Could not display ISS dropdown", rect);
            }
        }
        if (!flag)
        {
            UIUtils.closeSoftKeyboard(this);
        }
    }
}
