// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.f;

import android.content.Context;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.view.BitmapImageView;

// Referenced classes of package com.target.ui.f:
//            d

public class a extends d
{

    final BitmapImageView mBitmapImageView;

    public a(Context context, BaseNavigationFragment basenavigationfragment, BitmapImageView bitmapimageview, String s)
    {
        super(context, basenavigationfragment, bitmapimageview, s);
        mBitmapImageView = bitmapimageview;
    }

    public BitmapImageView a()
    {
        return mBitmapImageView;
    }
}
