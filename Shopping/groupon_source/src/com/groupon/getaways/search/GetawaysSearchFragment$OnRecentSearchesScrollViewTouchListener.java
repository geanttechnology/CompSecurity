// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.search;

import android.view.MotionEvent;
import android.view.View;
import com.groupon.util.ViewUtils;

// Referenced classes of package com.groupon.getaways.search:
//            GetawaysSearchFragment

private class <init>
    implements android.view.wTouchListener
{

    final GetawaysSearchFragment this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        ViewUtils.setSoftKeyboardState(getActivity(), true, recentSearchesScrollView);
        return false;
    }

    private ()
    {
        this$0 = GetawaysSearchFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
