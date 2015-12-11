// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.target.ui.view.TargetImeEditText;

// Referenced classes of package com.target.ui.view.list:
//            ListCollectionItemView

private static class mGripper
{

    private TargetImeEditText mEditTitleText;
    private ImageView mGripper;
    private View mLayoutView;
    private TextView mMetadataView;
    private TextView mTitleView;

    static View a(mGripper mgripper)
    {
        return mgripper.mLayoutView;
    }

    static TextView b(mLayoutView mlayoutview)
    {
        return mlayoutview.mTitleView;
    }

    static TextView c(mTitleView mtitleview)
    {
        return mtitleview.mMetadataView;
    }

    static TargetImeEditText d(mMetadataView mmetadataview)
    {
        return mmetadataview.mEditTitleText;
    }

    static ImageView e(mEditTitleText medittitletext)
    {
        return medittitletext.mGripper;
    }

    public (View view)
    {
        mLayoutView = view.findViewById(0x7f1002a8);
        mTitleView = (TextView)view.findViewById(0x7f1002aa);
        mMetadataView = (TextView)view.findViewById(0x7f1002ab);
        mEditTitleText = (TargetImeEditText)view.findViewById(0x7f1000e8);
        mGripper = (ImageView)view.findViewById(0x7f1002a9);
    }
}
