// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;

// Referenced classes of package com.poshmark.ui.fragments:
//            AllPartiesFragment

class this._cls0
    implements android.view.esFragment._cls1
{

    final AllPartiesFragment this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        view.getParent().requestDisallowInterceptTouchEvent(true);
        return false;
    }

    ()
    {
        this$0 = AllPartiesFragment.this;
        super();
    }
}
