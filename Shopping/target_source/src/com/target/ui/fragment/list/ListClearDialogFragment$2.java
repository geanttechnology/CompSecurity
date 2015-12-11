// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.list;

import android.view.View;

// Referenced classes of package com.target.ui.fragment.list:
//            ListClearDialogFragment

class this._cls0
    implements android.view.alogFragment._cls2
{

    final ListClearDialogFragment this$0;

    public void onClick(View view)
    {
        if (ListClearDialogFragment.a(ListClearDialogFragment.this) != null)
        {
            ListClearDialogFragment.a(ListClearDialogFragment.this).a(ListClearDialogFragment.b(ListClearDialogFragment.this));
        }
        dismiss();
    }

    ()
    {
        this$0 = ListClearDialogFragment.this;
        super();
    }
}
