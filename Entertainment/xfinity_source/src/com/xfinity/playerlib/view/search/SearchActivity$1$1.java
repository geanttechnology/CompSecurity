// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.search;

import android.content.Intent;
import android.os.Handler;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

// Referenced classes of package com.xfinity.playerlib.view.search:
//            SearchActivity, SearchResultsFragment

class this._cls1
    implements Runnable
{

    final tInput this$1;

    public void run()
    {
        if (!SearchActivity.access$000(_fld0))
        {
            SearchActivity.access$100(_fld0).toggleSoftInput(2, 0);
        }
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/xfinity/playerlib/view/search/SearchActivity$1

/* anonymous class */
    class SearchActivity._cls1
        implements android.view.MenuItem.OnActionExpandListener
    {

        final SearchActivity this$0;

        public boolean onMenuItemActionCollapse(MenuItem menuitem)
        {
            SearchActivity.access$100(SearchActivity.this).hideSoftInputFromWindow(SearchActivity.access$400(SearchActivity.this).getWindowToken(), 0);
            SearchActivity.access$300(SearchActivity.this).onMenuItemActionCollapse(menuitem);
            setResult(-1);
            finish();
            return true;
        }

        public boolean onMenuItemActionExpand(MenuItem menuitem)
        {
            if (getIntent().getBooleanExtra("KEY_SHOW_KEYBOARD_ON_START", false))
            {
                SearchActivity.access$200(SearchActivity.this).postDelayed(new SearchActivity._cls1._cls1(), 200L);
            }
            SearchActivity.access$300(SearchActivity.this).onMenuItemActionExpand(menuitem);
            return true;
        }

            
            {
                this$0 = SearchActivity.this;
                super();
            }
    }

}
