// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.shop;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.google.a.a.e;
import com.target.mothership.model.dvm.interfaces.DvmDataResponse;
import com.target.ui.adapter.b.c;
import com.target.ui.util.al;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.a;

// Referenced classes of package com.target.ui.view.shop:
//            BasePageItemView

public class ShopDvmView extends BasePageItemView
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

    public ShopDvmView(Context context)
    {
        super(context);
        c();
    }

    public ShopDvmView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        c();
    }

    public ShopDvmView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        c();
    }

    private void a(Context context, BitmapImageView bitmapimageview, DvmDataResponse dvmdataresponse)
    {
        if (bitmapimageview == null || dvmdataresponse == null)
        {
            return;
        } else
        {
            com.target.ui.adapter.b.c.a(context, dvmdataresponse.a(), bitmapimageview);
            al.b(bitmapimageview);
            return;
        }
    }

    private void c()
    {
        inflate(getContext(), 0x7f0301f3, this);
        mViews = new Views(this);
    }

    protected void a()
    {
    }

    public boolean b()
    {
        return getPageItem() != null;
    }

    public e getDvmContent()
    {
        return e.c(mDvmDataResponse);
    }

    public void setDvmContent(DvmDataResponse dvmdataresponse)
    {
        mDvmDataResponse = dvmdataresponse;
        a(getContext(), mViews.imageView, dvmdataresponse);
    }
}
