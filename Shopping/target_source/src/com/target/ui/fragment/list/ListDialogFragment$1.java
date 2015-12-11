// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.list;

import android.view.View;

// Referenced classes of package com.target.ui.fragment.list:
//            ListDialogFragment

class val.rootView
    implements android.view.tener
{

    final ListDialogFragment this$0;
    final View val$rootView;

    public void onFocusChange(View view, boolean flag)
    {
        if (!flag)
        {
            ListDialogFragment.a(ListDialogFragment.this, val$rootView);
            return;
        } else
        {
            ListDialogFragment.a(ListDialogFragment.this);
            return;
        }
    }

    ()
    {
        this$0 = final_listdialogfragment;
        val$rootView = View.this;
        super();
    }
}
