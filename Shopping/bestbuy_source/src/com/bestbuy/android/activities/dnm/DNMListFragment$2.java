// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.dnm;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

// Referenced classes of package com.bestbuy.android.activities.dnm:
//            DNMListFragment

class a
    implements android.widget.ctionListener
{

    final DNMListFragment a;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (i == 3)
        {
            ((InputMethodManager)DNMListFragment.j(a).getSystemService("input_method")).hideSoftInputFromWindow(DNMListFragment.k(a).getWindowToken(), 0);
            textview = DNMListFragment.k(a).getText().toString();
            DNMListFragment.k(a).setVisibility(8);
            DNMListFragment.l(a).setVisibility(0);
            if (textview != null && textview.length() > 0)
            {
                DNMListFragment.a(a, textview);
            }
            DNMListFragment.k(a).setText("");
            return true;
        } else
        {
            return false;
        }
    }

    (DNMListFragment dnmlistfragment)
    {
        a = dnmlistfragment;
        super();
    }
}
