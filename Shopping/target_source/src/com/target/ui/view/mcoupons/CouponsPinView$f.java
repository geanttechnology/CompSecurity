// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.mcoupons;

import android.view.View;
import com.target.ui.view.BackSpaceDetectorEditText;

// Referenced classes of package com.target.ui.view.mcoupons:
//            CouponsPinView

private static class pinFour
{

    BackSpaceDetectorEditText pinFour;
    BackSpaceDetectorEditText pinOne;
    BackSpaceDetectorEditText pinThree;
    BackSpaceDetectorEditText pinTwo;

    public (View view)
    {
        pinOne = (BackSpaceDetectorEditText)view.findViewById(0x7f10041b);
        pinTwo = (BackSpaceDetectorEditText)view.findViewById(0x7f10041c);
        pinThree = (BackSpaceDetectorEditText)view.findViewById(0x7f10041d);
        pinFour = (BackSpaceDetectorEditText)view.findViewById(0x7f10041e);
    }
}
