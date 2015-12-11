// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.widget;

import android.view.inputmethod.InputMethodManager;

// Referenced classes of package com.helpshift.widget:
//            SimpleSearchView

class a
    implements Runnable
{

    final SimpleSearchView a;

    public void run()
    {
        SimpleSearchView.f(a).showSoftInput(SimpleSearchView.d(a), 0);
    }

    ger(SimpleSearchView simplesearchview)
    {
        a = simplesearchview;
        super();
    }
}
