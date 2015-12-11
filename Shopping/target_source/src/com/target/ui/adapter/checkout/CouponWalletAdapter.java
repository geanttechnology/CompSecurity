// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.checkout;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.target.mothership.common.a.f;
import com.target.mothership.model.coupon_wallets.interfaces.WalletItem;
import com.target.mothership.model.coupon_wallets.interfaces.a;
import com.target.ui.adapter.b.e;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class CouponWalletAdapter extends e
{
    public static class ViewHolder
    {

        public f fulfillmentType;
        public int position;
        public View root;
        ImageButton walletInfo;
        RadioButton walletItemChoice;
        TextView walletSubTitle;
        TextView walletTitle;

        public ViewHolder(View view)
        {
            position = -1;
            root = view;
            ButterKnife.bind(this, root);
        }
    }

    public static interface a
    {

        public abstract void a(WalletItem walletitem);

        public abstract void b(WalletItem walletitem);
    }


    private static final int NULL_INT = -1;
    private static final String SINGLE_DATE_FORMAT = "MMM d";
    private String EMPTY_SPACE;
    private a mCouponWalletAdapterListener;
    private int mSelectedPosition;
    private WalletItem mSelectedWalletItem;
    private final List mWalletItems;

    public CouponWalletAdapter(Context context, List list, WalletItem walletitem, a a1)
    {
        super(context, list);
        mSelectedPosition = -1;
        EMPTY_SPACE = " ";
        mWalletItems = list;
        mSelectedWalletItem = walletitem;
        mCouponWalletAdapterListener = a1;
        a();
    }

    static a a(CouponWalletAdapter couponwalletadapter)
    {
        return couponwalletadapter.mCouponWalletAdapterListener;
    }

    private void a()
    {
        if (mSelectedWalletItem == null || !mSelectedWalletItem.a().b())
        {
            mSelectedPosition = -1;
        } else
        {
            int i = 0;
            while (i < mWalletItems.size()) 
            {
                WalletItem walletitem = (WalletItem)mWalletItems.get(i);
                if (((String)mSelectedWalletItem.a().c()).equals(walletitem.a().c()))
                {
                    mSelectedPosition = i;
                }
                i++;
            }
        }
    }

    private void a(int i, WalletItem walletitem)
    {
        if (mCouponWalletAdapterListener == null)
        {
            return;
        }
        if (mSelectedPosition == i)
        {
            mSelectedPosition = -1;
            mCouponWalletAdapterListener.a(null);
        } else
        {
            mSelectedPosition = i;
            mCouponWalletAdapterListener.a(walletitem);
        }
        notifyDataSetChanged();
    }

    static void a(CouponWalletAdapter couponwalletadapter, int i, WalletItem walletitem)
    {
        couponwalletadapter.a(i, walletitem);
    }

    public int getCount()
    {
        return mWalletItems.size();
    }

    public View getView(final int position, View view, ViewGroup viewgroup)
    {
        final WalletItem walletItem;
        Object obj1;
        walletItem = (WalletItem)getItem(position);
        com.target.mothership.model.coupon_wallets.interfaces.a a1 = com.target.mothership.model.coupon_wallets.interfaces.a.ACTIVE;
        viewgroup = walletItem.e();
        if (viewgroup.b())
        {
            a1 = (com.target.mothership.model.coupon_wallets.interfaces.a)viewgroup.c();
        }
        boolean flag;
        if (view == null)
        {
            view = mInflater.inflate(0x7f030104, null, false);
            viewgroup = new ViewHolder(view);
            view.setTag(viewgroup);
            if (com.target.mothership.model.coupon_wallets.interfaces.a.ACTIVE.equals(a1))
            {
                view.setOnClickListener(new android.view.View.OnClickListener() {

                    final CouponWalletAdapter this$0;
                    final int val$position;
                    final WalletItem val$walletItem;

                    public void onClick(View view1)
                    {
                        com.target.ui.adapter.checkout.CouponWalletAdapter.a(CouponWalletAdapter.this, position, walletItem);
                    }

            
            {
                this$0 = CouponWalletAdapter.this;
                position = i;
                walletItem = walletitem;
                super();
            }
                });
            }
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        if (position == mSelectedPosition || com.target.mothership.model.coupon_wallets.interfaces.a.APPLIED.equals(a1))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        viewgroup.position = position;
        ((ViewHolder) (viewgroup)).walletItemChoice.setChecked(flag);
        ((ViewHolder) (viewgroup)).walletItemChoice.setTag(viewgroup);
        if (com.target.mothership.model.coupon_wallets.interfaces.a.ACTIVE.equals(a1))
        {
            ((ViewHolder) (viewgroup)).walletItemChoice.setOnClickListener(new android.view.View.OnClickListener() {

                final CouponWalletAdapter this$0;
                final int val$position;
                final WalletItem val$walletItem;

                public void onClick(View view1)
                {
                    com.target.ui.adapter.checkout.CouponWalletAdapter.a(CouponWalletAdapter.this, position, walletItem);
                }

            
            {
                this$0 = CouponWalletAdapter.this;
                position = i;
                walletItem = walletitem;
                super();
            }
            });
        } else
        {
            ((ViewHolder) (viewgroup)).walletItemChoice.setOnClickListener(null);
        }
        obj1 = walletItem.c();
        if (((com.google.a.a.e) (obj1)).b())
        {
            ((ViewHolder) (viewgroup)).walletTitle.setText((CharSequence)((com.google.a.a.e) (obj1)).c());
        }
        obj1 = getContext().getResources();
        if (!com.target.mothership.model.coupon_wallets.interfaces.a.APPLIED.equals(a1)) goto _L2; else goto _L1
_L1:
        ((ViewHolder) (viewgroup)).walletSubTitle.setText(((Resources) (obj1)).getString(0x7f090298));
        ((ViewHolder) (viewgroup)).walletSubTitle.setTextColor(((Resources) (obj1)).getColor(0x7f0f00ec));
_L4:
        ((ViewHolder) (viewgroup)).walletInfo.setTag(viewgroup);
        ((ViewHolder) (viewgroup)).walletInfo.setOnClickListener(new android.view.View.OnClickListener() {

            final CouponWalletAdapter this$0;
            final WalletItem val$walletItem;

            public void onClick(View view1)
            {
                if (com.target.ui.adapter.checkout.CouponWalletAdapter.a(CouponWalletAdapter.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.adapter.checkout.CouponWalletAdapter.a(CouponWalletAdapter.this).b(walletItem);
                    return;
                }
            }

            
            {
                this$0 = CouponWalletAdapter.this;
                walletItem = walletitem;
                super();
            }
        });
        return view;
_L2:
        Object obj = walletItem.d();
        if (((com.google.a.a.e) (obj)).b())
        {
            obj = (new SimpleDateFormat("MMM d", Locale.US)).format((Date)((com.google.a.a.e) (obj)).c());
            String s = ((Resources) (obj1)).getString(0x7f09029a);
            ((ViewHolder) (viewgroup)).walletSubTitle.setText((new StringBuilder()).append(s).append(EMPTY_SPACE).append(((String) (obj))).toString());
            ((ViewHolder) (viewgroup)).walletSubTitle.setTextColor(((Resources) (obj1)).getColor(0x7f0f00f6));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
