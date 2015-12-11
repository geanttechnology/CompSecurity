// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.mcoupons;

import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.target.ui.fragment.mcoupons:
//            CouponsErrorDialogFragment

private class dialogMsg
{

    TextView dialogMsg;
    TextView dialogTitle;
    final CouponsErrorDialogFragment this$0;

    (View view)
    {
        this$0 = CouponsErrorDialogFragment.this;
        super();
        dialogTitle = (TextView)view.findViewById(0x7f1000d0);
        dialogMsg = (TextView)view.findViewById(0x7f1000d1);
    }
}
