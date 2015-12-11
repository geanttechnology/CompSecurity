// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.target.mothership.model.dvm.interfaces.DvmDataResponse;
import com.target.ui.adapter.b.c;
import com.target.ui.util.al;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.a;
import com.target.ui.view.shop.PageItemView;

public class PlpDvmView extends PageItemView
{
    static class Views extends a
    {

        BitmapImageView imageView;

        public Views(View view)
        {
            super(view);
        }
    }


    private DvmDataResponse mDvmDataResponse;
    private Views mViews;

    public PlpDvmView(Context context)
    {
        super(context);
        b();
    }

    public PlpDvmView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        b();
    }

    public PlpDvmView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        b();
    }

    private void a(Context context, BitmapImageView bitmapimageview, DvmDataResponse dvmdataresponse)
    {
        if (bitmapimageview == null || dvmdataresponse == null)
        {
            return;
        } else
        {
            c.a(context, dvmdataresponse.a(), bitmapimageview);
            al.b(bitmapimageview);
            return;
        }
    }

    private void b()
    {
        inflate(getContext(), 0x7f03019a, this);
        mViews = new Views(this);
    }

    public BitmapImageView getDvmBitMapImageView()
    {
        return mViews.imageView;
    }

    public DvmDataResponse getDvmContent()
    {
        return mDvmDataResponse;
    }

    public void setDvmContent(DvmDataResponse dvmdataresponse)
    {
        mDvmDataResponse = dvmdataresponse;
        a(getContext(), mViews.imageView, dvmdataresponse);
    }
}
