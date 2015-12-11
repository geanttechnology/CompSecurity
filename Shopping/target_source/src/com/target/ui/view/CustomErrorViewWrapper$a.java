// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.target.ui.view:
//            CustomErrorViewWrapper

private class error
{

    TextView error;
    View inputView;
    final CustomErrorViewWrapper this$0;

    public (View view)
    {
        this$0 = CustomErrorViewWrapper.this;
        super();
        inputView = view.findViewById(CustomErrorViewWrapper.a(CustomErrorViewWrapper.this));
        error = (TextView)view.findViewById(0x7f10042a);
    }
}
