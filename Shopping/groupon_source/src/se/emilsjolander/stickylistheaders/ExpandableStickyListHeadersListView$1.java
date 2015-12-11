// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package se.emilsjolander.stickylistheaders;

import android.view.View;

// Referenced classes of package se.emilsjolander.stickylistheaders:
//            ExpandableStickyListHeadersListView

class this._cls0
    implements nimationExecutor
{

    final ExpandableStickyListHeadersListView this$0;

    public void executeAnim(View view, int i)
    {
        if (i == 0)
        {
            view.setVisibility(0);
        } else
        if (i == 1)
        {
            view.setVisibility(8);
            return;
        }
    }

    nimationExecutor()
    {
        this$0 = ExpandableStickyListHeadersListView.this;
        super();
    }
}
