// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.search;

import android.text.Editable;
import com.target.ui.k.b;

// Referenced classes of package com.target.ui.view.search:
//            SearchOverlayView

class this._cls0 extends b
{

    final SearchOverlayView this$0;

    public void a(Editable editable)
    {
        editable = editable.toString();
        SearchOverlayView searchoverlayview = SearchOverlayView.this;
        boolean flag;
        if (editable.length() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        SearchOverlayView.a(searchoverlayview, flag);
        if (SearchOverlayView.a(SearchOverlayView.this) != null)
        {
            SearchOverlayView.a(SearchOverlayView.this).b_(editable);
        }
    }

    public void a(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void b(CharSequence charsequence, int i, int j, int k)
    {
    }

    ()
    {
        this$0 = SearchOverlayView.this;
        super();
    }
}
