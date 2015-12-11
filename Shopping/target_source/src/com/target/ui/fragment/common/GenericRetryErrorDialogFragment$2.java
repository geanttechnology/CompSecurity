// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.common;

import android.view.View;

// Referenced classes of package com.target.ui.fragment.common:
//            GenericRetryErrorDialogFragment

class this._cls0
    implements android.view.DialogFragment._cls2
{

    final GenericRetryErrorDialogFragment this$0;

    public void onClick(View view)
    {
        if (GenericRetryErrorDialogFragment.a(GenericRetryErrorDialogFragment.this) == null)
        {
            return;
        } else
        {
            GenericRetryErrorDialogFragment.a(GenericRetryErrorDialogFragment.this).a(GenericRetryErrorDialogFragment.b(GenericRetryErrorDialogFragment.this));
            dismiss();
            return;
        }
    }

    ()
    {
        this$0 = GenericRetryErrorDialogFragment.this;
        super();
    }
}
