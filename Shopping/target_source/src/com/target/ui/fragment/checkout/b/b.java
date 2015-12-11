// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.checkout.b;

import android.view.Menu;
import android.view.MenuInflater;
import com.target.mothership.model.coupon_wallets.interfaces.WalletItem;
import com.target.ui.fragment.checkout.d.d;
import com.target.ui.g.a;
import java.util.List;

public class b
    implements a
{

    private d mPresentation;
    private WalletItem mSelectedWalletItem;
    private List mWalletItemList;

    public b(List list)
    {
        mWalletItemList = list;
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
    }

    public void a(WalletItem walletitem)
    {
        mSelectedWalletItem = walletitem;
        walletitem = mPresentation;
        boolean flag;
        if (mSelectedWalletItem != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        walletitem.a(flag);
    }

    public void a(d d1)
    {
        mPresentation = d1;
        d1 = mPresentation;
        boolean flag;
        if (!mWalletItemList.isEmpty() && mSelectedWalletItem != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        d1.a(flag);
        mPresentation.a(mWalletItemList, mSelectedWalletItem);
    }

    public volatile void a(Object obj)
    {
        a((d)obj);
    }

    public void b(WalletItem walletitem)
    {
        mPresentation.c(walletitem);
    }

    public void c()
    {
        if (mSelectedWalletItem != null)
        {
            mPresentation.d(mSelectedWalletItem);
        }
    }

    public void v_()
    {
        mSelectedWalletItem = null;
        mWalletItemList = null;
    }

    public void z_()
    {
        mPresentation = null;
    }
}
