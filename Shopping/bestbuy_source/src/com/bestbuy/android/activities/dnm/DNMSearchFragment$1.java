// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.dnm;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

// Referenced classes of package com.bestbuy.android.activities.dnm:
//            DNMSearchFragment

class a
    implements android.widget.ionListener
{

    final DNMSearchFragment a;

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (i == 3)
        {
            ((InputMethodManager)DNMSearchFragment.a(a).getSystemService("input_method")).hideSoftInputFromWindow(DNMSearchFragment.b(a).getWindowToken(), 0);
            textview = DNMSearchFragment.b(a).getText().toString();
            if (textview != null && !textview.isEmpty())
            {
                DNMSearchFragment.a(a, textview);
            }
            return true;
        } else
        {
            return false;
        }
    }

    (DNMSearchFragment dnmsearchfragment)
    {
        a = dnmsearchfragment;
        super();
    }
}
