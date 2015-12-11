// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.common;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.target.ui.view.common:
//            TargetErrorView

private class tryAgainBtn
{

    final TextView errorSubTitle;
    final TextView errorTitle;
    final ImageView noNetwork;
    final TargetErrorView this$0;
    final Button tryAgainBtn;
    final ImageView warningIcon;

    public (View view)
    {
        this$0 = TargetErrorView.this;
        super();
        noNetwork = (ImageView)view.findViewById(0x7f1005d2);
        warningIcon = (ImageView)view.findViewById(0x7f1005d3);
        errorTitle = (TextView)view.findViewById(0x7f1005d4);
        errorSubTitle = (TextView)view.findViewById(0x7f1005d5);
        tryAgainBtn = (Button)view.findViewById(0x7f1005d6);
    }
}
