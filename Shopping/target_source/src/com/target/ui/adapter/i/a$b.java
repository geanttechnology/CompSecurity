// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.i;

import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;

// Referenced classes of package com.target.ui.adapter.i:
//            a

public static class Id
{

    public int position;
    public View root;
    public TextView storeAddress;
    public RadioButton storeChoice;
    public ImageButton storeInfo;
    public TextView storeLabels;
    public TextView storeName;

    public (View view)
    {
        position = -1;
        root = view;
        storeName = (TextView)view.findViewById(0x7f100323);
        storeAddress = (TextView)view.findViewById(0x7f100324);
        storeLabels = (TextView)view.findViewById(0x7f100325);
        storeInfo = (ImageButton)view.findViewById(0x7f100327);
        storeChoice = (RadioButton)view.findViewById(0x7f100322);
    }
}
