// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.ui.widgets;

import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.livemixtapes.ui.widgets:
//            SearchView

class this._cls0
    implements android.view.istener
{

    final SearchView this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (!SearchView.access$2(SearchView.this))
        {
            SearchView.access$3(SearchView.this, true);
            SearchView.access$4(SearchView.this, SearchView.access$2(SearchView.this));
        }
        return false;
    }

    ()
    {
        this$0 = SearchView.this;
        super();
    }
}
