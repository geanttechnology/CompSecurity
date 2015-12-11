// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.search;

import android.widget.EditText;
import android.widget.PopupWindow;

// Referenced classes of package com.xfinity.playerlib.view.search:
//            SearchResultsFragment

class this._cls0
    implements Runnable
{

    final SearchResultsFragment this$0;

    public void run()
    {
label0:
        {
            if (isAdded())
            {
                if (!SearchResultsFragment.access$1700(SearchResultsFragment.this).isShowing())
                {
                    SearchResultsFragment.access$1700(SearchResultsFragment.this).setInputMethodMode(1);
                }
                SearchResultsFragment.access$1700(SearchResultsFragment.this).setWidth(SearchResultsFragment.access$1800(SearchResultsFragment.this));
                SearchResultsFragment.access$1700(SearchResultsFragment.this).setHeight(SearchResultsFragment.access$1900(SearchResultsFragment.this));
                if (SearchResultsFragment.access$2000(SearchResultsFragment.this).getWindowToken() != null)
                {
                    if (SearchResultsFragment.access$1700(SearchResultsFragment.this).isShowing())
                    {
                        break label0;
                    }
                    SearchResultsFragment.access$1700(SearchResultsFragment.this).showAsDropDown(SearchResultsFragment.access$2000(SearchResultsFragment.this));
                }
            }
            return;
        }
        SearchResultsFragment.access$1700(SearchResultsFragment.this).update(SearchResultsFragment.access$2000(SearchResultsFragment.this), 0, 0, SearchResultsFragment.access$1800(SearchResultsFragment.this), SearchResultsFragment.access$1900(SearchResultsFragment.this));
    }

    ()
    {
        this$0 = SearchResultsFragment.this;
        super();
    }
}
