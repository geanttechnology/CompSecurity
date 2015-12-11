// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.givingworks;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.ebay.mobile.givingworks:
//            GivingWorksSearchFragment

public final class infoButton
{

    public final ImageView chevron;
    public final ImageView image;
    public final ImageButton infoButton;
    public final View infoDivider;
    public final View selectButton;
    public final TextView text;
    final infoButton this$1;

    public (View view)
    {
        this$1 = this._cls1.this;
        super();
        image = (ImageView)view.findViewById(0x7f1001d5);
        text = (TextView)view.findViewById(0x7f1001d7);
        selectButton = view.findViewById(0x7f1001d4);
        infoDivider = view.findViewById(0x7f1001d9);
        chevron = (ImageView)view.findViewById(0x7f1001da);
        infoButton = (ImageButton)view.findViewById(0x7f1001db);
    }
}
