// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.callout;

import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

// Referenced classes of package com.socialin.android.photo.callout:
//            SelectCalloutActivity

final class a
    implements android.widget.istener
{

    private SelectCalloutActivity a;

    public final boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (i == 6 || i == 5 || keyevent.getAction() == 0 && keyevent.getKeyCode() == 66)
        {
            if (a.getCurrentFocus() != null)
            {
                ((InputMethodManager)a.getSystemService("input_method")).hideSoftInputFromWindow(a.getCurrentFocus().getWindowToken(), 2);
            } else
            {
                SelectCalloutActivity.g(a);
            }
            return true;
        } else
        {
            return false;
        }
    }

    (SelectCalloutActivity selectcalloutactivity)
    {
        a = selectcalloutactivity;
        super();
    }
}
