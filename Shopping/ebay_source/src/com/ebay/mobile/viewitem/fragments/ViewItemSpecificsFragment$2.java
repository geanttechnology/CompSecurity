// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem.fragments;

import android.text.Layout;
import android.view.ViewTreeObserver;
import android.widget.TextView;

// Referenced classes of package com.ebay.mobile.viewitem.fragments:
//            ViewItemSpecificsFragment

class val.sellerNotes
    implements android.view.outListener
{

    final ViewItemSpecificsFragment this$0;
    final TextView val$sellerNotes;

    public void onGlobalLayout()
    {
        Layout layout = val$sellerNotes.getLayout();
        if (layout != null)
        {
            int i = layout.getLineCount();
            if (i > 0 && layout.getEllipsisCount(i - 1) > 0)
            {
                ViewItemSpecificsFragment.access$002(ViewItemSpecificsFragment.this, true);
                render(item, viewData);
            }
        }
        val$sellerNotes.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }

    ()
    {
        this$0 = final_viewitemspecificsfragment;
        val$sellerNotes = TextView.this;
        super();
    }
}
