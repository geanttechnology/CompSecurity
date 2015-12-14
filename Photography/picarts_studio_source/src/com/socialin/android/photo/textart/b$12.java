// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.textart;

import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

// Referenced classes of package com.socialin.android.photo.textart:
//            b, TextPreview

final class a
    implements android.widget.iew.OnEditorActionListener
{

    private b a;

    public final boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        textview = (InputMethodManager)a.getActivity().getSystemService("input_method");
        if ("".equals(b.a(a).getText().toString()) && textview.isAcceptingText() && a.getActivity().getWindow().getCurrentFocus() != null)
        {
            textview.hideSoftInputFromWindow(a.getActivity().getWindow().getCurrentFocus().getWindowToken(), 0);
            b.a(a).clearFocus();
        }
        return false;
    }

    review(b b1)
    {
        a = b1;
        super();
    }
}
