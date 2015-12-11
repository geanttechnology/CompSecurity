// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui.adapters;

import android.view.View;
import butterknife.ButterKnife;
import com.bitstrips.imoji.ui.views.ImojiWithBadgeView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

// Referenced classes of package com.bitstrips.imoji.ui.adapters:
//            PolyAdapter

public static class A extends android.support.v7.widget.older
    implements A
{

    ImojiWithBadgeView mImojiWithBadgeView;
    mItem mItem;

    public void setBackground(String s)
    {
    }

    public void setImage(String s)
    {
        mImojiWithBadgeView.setScaleType(android.widget.NSIDE);
        Picasso.with(mImojiWithBadgeView.getContext()).load(s).placeholder(0x7f0200a9).fit().centerInside().into(mImojiWithBadgeView);
    }

    public void setItem(mImojiWithBadgeView mimojiwithbadgeview)
    {
        mItem = mimojiwithbadgeview;
    }

    public void setTitle(String s)
    {
    }

    public A(View view)
    {
        super(view);
        ButterKnife.bind(this, view);
    }
}
