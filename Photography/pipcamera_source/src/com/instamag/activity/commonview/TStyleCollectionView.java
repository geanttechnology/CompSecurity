// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.commonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

// Referenced classes of package com.instamag.activity.commonview:
//            TabItemView

public class TStyleCollectionView extends LinearLayout
{

    TabItemView btnLandScape;
    TabItemView btnLibrary;
    TabItemView btnPortrait;
    TabItemView btnSquare;
    TabItemView btnStrips;

    public TStyleCollectionView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030051, this, true);
        initTabItems();
    }

    public void initTabItems()
    {
    }
}
