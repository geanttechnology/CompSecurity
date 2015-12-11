// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.view.KeyEvent;
import android.view.View;
import com.target.ui.util.al;

// Referenced classes of package com.target.ui.view.list:
//            ListDetailView

class this._cls0
    implements com.target.ui.view..a
{

    final ListDetailView this$0;

    public boolean a(int i, KeyEvent keyevent)
    {
        if (keyevent.getAction() == 0 && i == 4)
        {
            al.c(ListDetailView.a(ListDetailView.this).listItemSuggestionView);
            ListDetailView.a(ListDetailView.this).mListDetailView.postDelayed(new Runnable() {

                final ListDetailView._cls9 this$1;

                public void run()
                {
                    ListDetailView.a(this$0).mListDetailView.requestFocus();
                }

            
            {
                this$1 = ListDetailView._cls9.this;
                super();
            }
            }, 300L);
        }
        return false;
    }

    _cls1.this._cls1()
    {
        this$0 = ListDetailView.this;
        super();
    }
}
