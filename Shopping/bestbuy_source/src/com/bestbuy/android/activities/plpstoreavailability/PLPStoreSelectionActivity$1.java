// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.plpstoreavailability;

import android.view.View;
import android.view.inputmethod.InputMethodManager;

// Referenced classes of package com.bestbuy.android.activities.plpstoreavailability:
//            PLPStoreSelectionActivity

class a
    implements android.widget.er
{

    final PLPStoreSelectionActivity a;

    public boolean onQueryTextChange(String s)
    {
        return false;
    }

    public boolean onQueryTextSubmit(String s)
    {
        InputMethodManager inputmethodmanager = (InputMethodManager)a.getSystemService("input_method");
        if (a.getCurrentFocus() != null && a.getCurrentFocus().getWindowToken() != null)
        {
            inputmethodmanager.hideSoftInputFromWindow(a.getCurrentFocus().getWindowToken(), 0);
        }
        PLPStoreSelectionActivity.a(a, s);
        a.a(s);
        return false;
    }

    (PLPStoreSelectionActivity plpstoreselectionactivity)
    {
        a = plpstoreselectionactivity;
        super();
    }
}
