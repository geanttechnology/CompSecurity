// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageButton;

// Referenced classes of package com.helpshift.widget:
//            SimpleSearchView

class a
    implements TextWatcher
{

    final SimpleSearchView a;

    public void afterTextChanged(Editable editable)
    {
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
        if (charsequence.length() > 0)
        {
            SimpleSearchView.b(a).setVisibility(0);
        } else
        {
            SimpleSearchView.b(a).setVisibility(8);
        }
        SimpleSearchView.c(a).(charsequence.toString());
    }

    (SimpleSearchView simplesearchview)
    {
        a = simplesearchview;
        super();
    }
}
