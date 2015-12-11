// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import com.poshmark.data_model.models.SuggestedSearchItem;
import com.poshmark.utils.PMSearchViewListener;

// Referenced classes of package com.poshmark.ui.customviews:
//            PMSearchView

class this._cls0
    implements android.widget.eryTextListener
{

    final PMSearchView this$0;

    public boolean onQueryTextChange(String s)
    {
        if ((s == null || s.length() == 0) && parentListener != null)
        {
            parentListener.clearSearchString();
        }
        return false;
    }

    public boolean onQueryTextSubmit(String s)
    {
        SuggestedSearchItem suggestedsearchitem = new SuggestedSearchItem();
        suggestedsearchitem.kw = s.trim();
        suggestedsearchitem.type = "kw";
        launchSearch(suggestedsearchitem, true);
        setQuery(null, false);
        return true;
    }

    rchItem()
    {
        this$0 = PMSearchView.this;
        super();
    }
}
