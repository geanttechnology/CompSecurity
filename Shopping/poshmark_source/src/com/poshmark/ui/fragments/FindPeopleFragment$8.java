// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import com.poshmark.ui.customviews.PMEditText;

// Referenced classes of package com.poshmark.ui.fragments:
//            FindPeopleFragment

class this._cls0
    implements android.view.leFragment._cls8
{

    final FindPeopleFragment this$0;

    public void onClick(View view)
    {
        if (FindPeopleFragment.access$400(FindPeopleFragment.this).getText().toString().length() == 0)
        {
            FindPeopleFragment.access$400(FindPeopleFragment.this).requestFocus();
            showKeyboard();
            return;
        } else
        {
            hideKeyboard();
            FindPeopleFragment.access$500(FindPeopleFragment.this);
            return;
        }
    }

    ()
    {
        this$0 = FindPeopleFragment.this;
        super();
    }
}
