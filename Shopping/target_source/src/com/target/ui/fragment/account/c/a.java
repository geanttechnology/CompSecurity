// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account.c;

import android.graphics.Bitmap;
import android.view.Menu;
import android.view.MenuInflater;
import com.target.mothership.model.common.GiftCardTender;
import com.target.ui.helper.a.b;

public class a
    implements com.target.ui.g.a, com.target.ui.helper.a.b.a
{

    private b mBarcodeHelper;
    private GiftCardTender mGiftCardTender;
    private com.target.ui.fragment.account.b.a mPresentation;

    public a(GiftCardTender giftcardtender, b b1)
    {
        mGiftCardTender = giftcardtender;
        mBarcodeHelper = b1;
    }

    private void e()
    {
        mPresentation.a(mGiftCardTender.c());
        mPresentation.b(com.target.ui.util.d.a.a(mGiftCardTender.d()));
        mBarcodeHelper.a(mGiftCardTender.e(), this);
    }

    public void a(Bitmap bitmap)
    {
        mPresentation.a(bitmap);
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
    }

    public void a(com.target.ui.fragment.account.b.a a1)
    {
        mPresentation = a1;
        e();
    }

    public volatile void a(Object obj)
    {
        a((com.target.ui.fragment.account.b.a)obj);
    }

    public void c()
    {
        mPresentation.a();
    }

    public void d()
    {
        mPresentation.c(mGiftCardTender.e());
    }

    public void v_()
    {
        mBarcodeHelper = null;
        mGiftCardTender = null;
    }

    public void z_()
    {
        mPresentation = null;
    }
}
