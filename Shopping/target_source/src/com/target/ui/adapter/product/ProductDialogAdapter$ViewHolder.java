// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.product;

import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import com.target.mothership.common.a.g;
import com.target.ui.view.a;

// Referenced classes of package com.target.ui.adapter.product:
//            ProductDialogAdapter

static class root extends a
{

    int checkBoxPosition;
    TextView inventoryStatus;
    g pickUpItemType;
    int position;
    RadioButton radioButton;
    final View root;
    TextView storeAddress;
    ImageButton storeInfo;
    TextView storeLabel;
    TextView storeName;

    public (View view)
    {
        super(view);
        position = -1;
        checkBoxPosition = -1;
        root = view;
    }
}
