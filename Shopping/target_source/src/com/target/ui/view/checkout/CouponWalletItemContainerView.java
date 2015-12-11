// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.google.a.a.e;
import com.target.mothership.model.coupon_wallets.interfaces.WalletItem;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.target.ui.view.checkout:
//            CouponWalletItemRedeemedView

public class CouponWalletItemContainerView extends LinearLayout
{

    private static final String EMPTY_SPACE = " ";
    private static final String SINGLE_DATE_FORMAT = "MMM d";

    public CouponWalletItemContainerView(Context context)
    {
        super(context);
        a(context);
    }

    public CouponWalletItemContainerView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public CouponWalletItemContainerView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context);
    }

    private CouponWalletItemRedeemedView a()
    {
        return (CouponWalletItemRedeemedView)((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f03012e, this, false);
    }

    private void a(Context context)
    {
        inflate(context, 0x7f03012c, this);
    }

    public void a(List list)
    {
        removeAllViews();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Object obj = (WalletItem)list.next();
            CouponWalletItemRedeemedView couponwalletitemredeemedview = a();
            addView(couponwalletitemredeemedview);
            e e1 = ((WalletItem) (obj)).c();
            if (e1.b())
            {
                couponwalletitemredeemedview.a((String)e1.c());
            }
            obj = ((WalletItem) (obj)).d();
            if (((e) (obj)).b())
            {
                obj = (new SimpleDateFormat("MMM d", Locale.US)).format((Date)((e) (obj)).c());
                String s = getContext().getResources().getString(0x7f09029a);
                couponwalletitemredeemedview.b((new StringBuilder()).append(s).append(" ").append(((String) (obj))).toString());
            }
        } while (true);
        invalidate();
    }
}
