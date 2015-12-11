// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.fragments;

import android.widget.CompoundButton;

// Referenced classes of package com.gotv.crackle.fragments:
//            ShowDetailsButtonsFragment

class this._cls0
    implements android.widget.eListener
{

    final ShowDetailsButtonsFragment this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        ShowDetailsButtonsFragment.access$000(ShowDetailsButtonsFragment.this).onShowDetailsAddToWatchlistCheckChanged(flag);
    }

    owDetailsButtonListener()
    {
        this$0 = ShowDetailsButtonsFragment.this;
        super();
    }
}
