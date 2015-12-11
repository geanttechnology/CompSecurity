// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.givingworks;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

// Referenced classes of package com.ebay.mobile.givingworks:
//            GivingWorksFavoritesFragment

class this._cls0
    implements android.widget.
{

    final GivingWorksFavoritesFragment this$0;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (keyevent != null && keyevent.getKeyCode() == 66)
        {
            ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(searchText.getApplicationWindowToken(), 2);
            startKeywordSearch();
        }
        return false;
    }

    ()
    {
        this$0 = GivingWorksFavoritesFragment.this;
        super();
    }
}
