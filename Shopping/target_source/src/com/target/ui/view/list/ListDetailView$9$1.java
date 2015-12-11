// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.view.KeyEvent;
import android.view.View;
import com.target.ui.util.al;

// Referenced classes of package com.target.ui.view.list:
//            ListDetailView

class this._cls1
    implements Runnable
{

    final s.mListDetailView this$1;

    public void run()
    {
        ListDetailView.a(_fld0).mListDetailView.requestFocus();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/target/ui/view/list/ListDetailView$9

/* anonymous class */
    class ListDetailView._cls9
        implements com.target.ui.view.TargetImeEditText.a
    {

        final ListDetailView this$0;

        public boolean a(int i, KeyEvent keyevent)
        {
            if (keyevent.getAction() == 0 && i == 4)
            {
                al.c(ListDetailView.a(ListDetailView.this).listItemSuggestionView);
                ListDetailView.a(ListDetailView.this).mListDetailView.postDelayed(new ListDetailView._cls9._cls1(), 300L);
            }
            return false;
        }

            
            {
                this$0 = ListDetailView.this;
                super();
            }
    }

}
