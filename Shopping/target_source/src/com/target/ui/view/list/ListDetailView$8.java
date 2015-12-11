// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.view.View;
import com.target.ui.view.TargetImeEditText;

// Referenced classes of package com.target.ui.view.list:
//            ListDetailView

class this._cls0
    implements android.view.eListener
{

    final ListDetailView this$0;

    public void onFocusChange(View view, boolean flag)
    {
        if (flag)
        {
            ListDetailView.e(ListDetailView.this);
            return;
        } else
        {
            ListDetailView.a(ListDetailView.this).addItemEditText.setText("");
            ListDetailView.f(ListDetailView.this);
            return;
        }
    }

    ews()
    {
        this$0 = ListDetailView.this;
        super();
    }
}
