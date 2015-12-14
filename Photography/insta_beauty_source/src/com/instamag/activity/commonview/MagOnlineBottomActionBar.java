// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.commonview;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

// Referenced classes of package com.instamag.activity.commonview:
//            TabItemView

public class MagOnlineBottomActionBar extends LinearLayout
{

    TabItemView btnLandScape;
    TabItemView btnPortrait;
    TabItemView btnSquare;

    public MagOnlineBottomActionBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300ac, this, true);
        btnPortrait = (TabItemView)findViewById(0x7f0d0290);
        btnSquare = (TabItemView)findViewById(0x7f0d0293);
        btnLandScape = (TabItemView)findViewById(0x7f0d0296);
        initTabItems();
    }

    public void initTabItems()
    {
        btnPortrait.setTextColor(getResources().getColor(0x7f0c009d));
        btnPortrait.setTextSelectedColor(getResources().getColor(0x7f0c007c));
        btnPortrait.setResId(0x7f020125);
        btnPortrait.setSelectedResId(0x7f020126);
        btnPortrait.setText(getResources().getString(0x7f0601c2));
        btnPortrait.setSelected(false);
        btnSquare.setTextColor(getResources().getColor(0x7f0c009d));
        btnSquare.setTextSelectedColor(getResources().getColor(0x7f0c007c));
        btnSquare.setResId(0x7f020127);
        btnSquare.setSelectedResId(0x7f020128);
        btnSquare.setText(getResources().getString(0x7f060270));
        btnSquare.setSelected(false);
        btnLandScape.setTextColor(getResources().getColor(0x7f0c009d));
        btnLandScape.setTextSelectedColor(getResources().getColor(0x7f0c007c));
        btnLandScape.setResId(0x7f020121);
        btnLandScape.setSelectedResId(0x7f020122);
        btnLandScape.setText(getResources().getString(0x7f060155));
        btnLandScape.setSelected(false);
    }
}
