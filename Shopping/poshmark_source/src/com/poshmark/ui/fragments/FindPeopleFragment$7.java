// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.KeyEvent;
import android.view.View;
import com.poshmark.ui.customviews.PMEditText;

// Referenced classes of package com.poshmark.ui.fragments:
//            FindPeopleFragment

class this._cls0
    implements android.view.leFragment._cls7
{

    final FindPeopleFragment this$0;

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if (keyevent.getAction() == 0 && (i == 84 || i == 66))
        {
            if (FindPeopleFragment.access$400(FindPeopleFragment.this).getText().toString().length() > 0)
            {
                FindPeopleFragment.access$500(FindPeopleFragment.this);
            }
            return true;
        } else
        {
            return false;
        }
    }

    ()
    {
        this$0 = FindPeopleFragment.this;
        super();
    }
}
