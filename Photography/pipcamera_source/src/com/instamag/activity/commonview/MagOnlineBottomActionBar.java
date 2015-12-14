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
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030062, this, true);
        btnPortrait = (TabItemView)findViewById(0x7f0c016a);
        btnSquare = (TabItemView)findViewById(0x7f0c016d);
        btnLandScape = (TabItemView)findViewById(0x7f0c0170);
        initTabItems();
    }

    public void initTabItems()
    {
        btnPortrait.setTextColor(getResources().getColor(0x7f0b0076));
        btnPortrait.setTextSelectedColor(getResources().getColor(0x7f0b0077));
        btnPortrait.setResId(0x7f02008b);
        btnPortrait.setSelectedResId(0x7f02008c);
        btnPortrait.setText(getResources().getString(0x7f0601a2));
        btnPortrait.setSelected(false);
        btnSquare.setTextColor(getResources().getColor(0x7f0b0076));
        btnSquare.setTextSelectedColor(getResources().getColor(0x7f0b0077));
        btnSquare.setResId(0x7f02008d);
        btnSquare.setSelectedResId(0x7f02008e);
        btnSquare.setText(getResources().getString(0x7f06023b));
        btnSquare.setSelected(false);
        btnLandScape.setTextColor(getResources().getColor(0x7f0b0076));
        btnLandScape.setTextSelectedColor(getResources().getColor(0x7f0b0077));
        btnLandScape.setResId(0x7f020087);
        btnLandScape.setSelectedResId(0x7f020088);
        btnLandScape.setText(getResources().getString(0x7f060140));
        btnLandScape.setSelected(false);
    }
}
