// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.wishabi.flipp.app:
//            SearchFragment

final class el
    implements android.view.View.OnTouchListener
{

    final SearchFragment a;

    el(SearchFragment searchfragment)
    {
        a = searchfragment;
        super();
    }

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        SearchFragment.j(a);
        return false;
    }
}
