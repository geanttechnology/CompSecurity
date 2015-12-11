// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.target.ui.view.AisleBadgeView;
import com.target.ui.view.DealsBadgeView;
import com.target.ui.view.QuantitySpinnerView;
import com.target.ui.view.TargetImeEditText;

// Referenced classes of package com.target.ui.view.list:
//            BaseListItemView

protected static class gripper
{

    AisleBadgeView aisleLocationView;
    View blockerView;
    DealsBadgeView dealsBadge;
    TargetImeEditText editTitleText;
    ImageView gripper;
    RelativeLayout layout;
    QuantitySpinnerView quantitySpinner;
    CheckBox selectedCheckBox;
    TextView titleTextView;

    public (View view)
    {
        layout = (RelativeLayout)view.findViewById(0x7f1002a8);
        quantitySpinner = (QuantitySpinnerView)view.findViewById(0x7f1002ac);
        editTitleText = (TargetImeEditText)view.findViewById(0x7f1002ad);
        selectedCheckBox = (CheckBox)view.findViewById(0x7f1002ae);
        titleTextView = (TextView)view.findViewById(0x7f1002aa);
        dealsBadge = (DealsBadgeView)view.findViewById(0x7f1002af);
        aisleLocationView = (AisleBadgeView)view.findViewById(0x7f1002b0);
        blockerView = view.findViewById(0x7f1002b1);
        gripper = (ImageView)view.findViewById(0x7f1002a9);
    }
}
