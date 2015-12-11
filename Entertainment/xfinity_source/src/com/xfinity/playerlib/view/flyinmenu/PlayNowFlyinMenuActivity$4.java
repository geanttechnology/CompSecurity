// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.flyinmenu;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

// Referenced classes of package com.xfinity.playerlib.view.flyinmenu:
//            PlayNowFlyinMenuActivity

class this._cls0
    implements TextWatcher
{

    final PlayNowFlyinMenuActivity this$0;

    public void afterTextChanged(Editable editable)
    {
        View view = PlayNowFlyinMenuActivity.access$200(PlayNowFlyinMenuActivity.this);
        int i;
        if (!editable.toString().isEmpty())
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    ()
    {
        this$0 = PlayNowFlyinMenuActivity.this;
        super();
    }
}
