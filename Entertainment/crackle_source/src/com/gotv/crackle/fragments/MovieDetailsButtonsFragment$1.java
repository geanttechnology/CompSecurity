// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.fragments;

import android.widget.CompoundButton;

// Referenced classes of package com.gotv.crackle.fragments:
//            MovieDetailsButtonsFragment

class this._cls0
    implements android.widget.Listener
{

    final MovieDetailsButtonsFragment this$0;

    public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
    {
        MovieDetailsButtonsFragment.access$000(MovieDetailsButtonsFragment.this).onMovieAddToWatchlistCheckChanged(flag);
    }

    vieDetailsButtonListener()
    {
        this$0 = MovieDetailsButtonsFragment.this;
        super();
    }
}
