// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.view.common;

import android.view.View;

// Referenced classes of package com.comcast.cim.android.view.common:
//            CALDialogFragment

class this._cls0
    implements android.view.n.CALDialogFragment._cls11
{

    final CALDialogFragment this$0;

    public void onClick(View view)
    {
        CALDialogFragment.access$300(CALDialogFragment.this).tryAgain();
        dismiss();
    }

    AgainListener()
    {
        this$0 = CALDialogFragment.this;
        super();
    }
}
