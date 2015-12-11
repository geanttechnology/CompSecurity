// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop;

import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import com.amazon.mShop.util.Util;

// Referenced classes of package com.amazon.mShop:
//            SearchBar

class this._cls0
    implements android.view.stener
{

    final SearchBar this$0;

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        boolean flag = false;
        if (66 == i || 23 == i)
        {
            if (1 == keyevent.getAction())
            {
                view = SearchBar.access$200(SearchBar.this).getEditableText().toString();
                if (!Util.isEmpty(view) && 66 == i)
                {
                    startSearch();
                } else
                {
                    goToSearchEntry(view, true);
                }
                logRefMarker();
                SearchBar.access$300(SearchBar.this).setPressed(false);
                SearchBar.access$002(SearchBar.this, true);
            } else
            {
                SearchBar.access$300(SearchBar.this).setPressed(true);
            }
            flag = true;
        }
        return flag;
    }

    er()
    {
        this$0 = SearchBar.this;
        super();
    }
}
