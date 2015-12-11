// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.common;

import android.view.View;
import android.widget.Button;

// Referenced classes of package com.target.ui.view.common:
//            TargetBottomButton

private class mCentreDiv
{

    final Button mCentreButton;
    final View mCentreDiv;
    final Button mLeftButton;
    final View mLeftDiv;
    final Button mRightButton;
    final TargetBottomButton this$0;

    public (View view)
    {
        this$0 = TargetBottomButton.this;
        super();
        mLeftButton = (Button)view.findViewById(0x7f1002fd);
        mCentreButton = (Button)view.findViewById(0x7f1002ff);
        mRightButton = (Button)view.findViewById(0x7f100301);
        mLeftDiv = view.findViewById(0x7f1002fe);
        mCentreDiv = view.findViewById(0x7f100300);
    }
}
