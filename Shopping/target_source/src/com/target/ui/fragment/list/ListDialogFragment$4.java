// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.list;

import android.view.View;
import com.target.ui.helper.j.a;

// Referenced classes of package com.target.ui.fragment.list:
//            ListDialogFragment

class this._cls0
    implements android.view.alogFragment._cls4
{

    final ListDialogFragment this$0;

    public void onClick(View view)
    {
        if (!com.target.ui.fragment.list.ListDialogFragment.a(ListDialogFragment.this, view))
        {
            return;
        }
        view = new a();
        switch (.SwitchMap.com.target.ui.fragment.list.ListDialogFragment.Action[ListDialogFragment.c(ListDialogFragment.this).ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            com.target.ui.fragment.list.ListDialogFragment.a(ListDialogFragment.this, view);
            return;

        case 2: // '\002'
            ListDialogFragment.b(ListDialogFragment.this, view);
            break;
        }
    }

    ()
    {
        this$0 = ListDialogFragment.this;
        super();
    }
}
