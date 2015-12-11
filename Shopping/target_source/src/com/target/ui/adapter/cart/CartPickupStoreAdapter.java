// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.cart;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import com.target.mothership.common.a.f;
import com.target.mothership.common.product.i;
import com.target.mothership.common.product.o;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.cart.interfaces.CartProduct;
import com.target.mothership.model.common.StorePickUpDetails;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.ui.adapter.b.e;
import com.target.ui.model.a;
import com.target.ui.util.al;
import com.target.ui.util.u;
import java.util.Iterator;
import java.util.List;

public class CartPickupStoreAdapter extends e
    implements android.view.View.OnClickListener
{
    static class ViewHolder extends com.target.ui.view.a
    {

        f fulfillmentType;
        RadioButton pickupStoreChoice;
        int position;
        View root;
        TextView stockStatus;
        ImageButton storeInfo;
        TextView storeName;

        ViewHolder(View view)
        {
            super(view);
            position = -1;
        }
    }

    public static interface a
    {

        public abstract void a();

        public abstract void a(CartProduct cartproduct, com.target.ui.model.a a1, f f1);

        public abstract void a(com.target.ui.model.a a1);
    }


    private static final int NULL_INT = -1;
    private final CartProduct mCartProduct;
    private a mListener;
    private final List mRelevantStores;
    private int mSelectedPosition;
    private final String mShipToStoreDeliveryDateString = b(0x7f090128);

    public CartPickupStoreAdapter(Context context, List list, CartProduct cartproduct, a a1)
    {
        super(context, list);
        mSelectedPosition = -1;
        mRelevantStores = list;
        mCartProduct = cartproduct;
        mListener = a1;
        a();
    }

    private int a(int j)
    {
        return getContext().getResources().getColor(j);
    }

    private int a(com.target.ui.model.a a1)
    {
        if (c(a1))
        {
            return a1.b() != i.LimitedStock ? 1 : 0;
        } else
        {
            return 2;
        }
    }

    private transient String a(int j, Object aobj[])
    {
        return getContext().getResources().getString(j, aobj);
    }

    private void a()
    {
        mSelectedPosition = -1;
        break MISSING_BLOCK_LABEL_5;
        if ((mCartProduct.d() == f.StorePickup || mCartProduct.d() == f.ShipToStore) && mCartProduct.k().b())
        {
            StoreIdentifier storeidentifier = ((StorePickUpDetails)mCartProduct.k().c()).a();
            int j = 0;
            while (j < mRelevantStores.size()) 
            {
                if (storeidentifier.equals(((com.target.ui.model.a)mRelevantStores.get(j)).a().getStoreId()))
                {
                    mSelectedPosition = j;
                    return;
                }
                j++;
            }
        }
        return;
    }

    private void a(ViewHolder viewholder, com.target.ui.model.a a1, CartProduct cartproduct)
    {
        boolean flag1 = d(a1);
        boolean flag2 = a(a1, cartproduct);
        boolean flag;
        if (flag1 || flag2)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            a(flag1, flag2, viewholder);
            return;
        } else
        {
            a(a1, viewholder);
            return;
        }
    }

    private void a(com.target.ui.model.a a1, ViewHolder viewholder)
    {
        a(a1);
        JVM INSTR tableswitch 0 1: default 28
    //                   0 75
    //                   1 123;
           goto _L1 _L2 _L3
_L1:
        int j;
        a1 = b(0x7f090282);
        j = a(0x7f0f00f6);
_L5:
        viewholder.root.setEnabled(false);
        viewholder.pickupStoreChoice.setEnabled(false);
        viewholder.stockStatus.setTextColor(j);
        al.a(viewholder.stockStatus, a1);
        return;
_L2:
        if (a1.c() > 0)
        {
            a1 = a(0x7f09027c, new Object[] {
                Integer.valueOf(a1.c())
            });
        } else
        {
            a1 = b(0x7f09027f);
        }
        j = a(0x7f0f00e9);
        continue; /* Loop/switch isn't completed */
_L3:
        a1 = b(0x7f09027d);
        j = a(0x7f0f00f6);
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void a(boolean flag, boolean flag1, ViewHolder viewholder)
    {
        String s = null;
        if (!flag) goto _L2; else goto _L1
_L1:
        viewholder.fulfillmentType = f.StorePickup;
        s = b(0x7f09013c);
_L4:
        viewholder.root.setEnabled(true);
        viewholder.pickupStoreChoice.setEnabled(true);
        viewholder.stockStatus.setTextColor(a(0x7f0f00ec));
        al.a(viewholder.stockStatus, s);
        return;
_L2:
        if (flag1)
        {
            viewholder.fulfillmentType = f.ShipToStore;
            s = mShipToStoreDeliveryDateString;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private boolean a(com.target.ui.model.a a1, CartProduct cartproduct)
    {
        return cartproduct.t() && b(a1);
    }

    private String b(int j)
    {
        return getContext().getResources().getString(j);
    }

    private boolean b(com.target.ui.model.a a1)
    {
        if (a1.d().isEmpty())
        {
            return false;
        }
        for (a1 = a1.d().iterator(); a1.hasNext();)
        {
            if ((o)a1.next() == o.SHIP_TO_STORE)
            {
                return true;
            }
        }

        return false;
    }

    private boolean c(com.target.ui.model.a a1)
    {
        if (a1.d().isEmpty())
        {
            return false;
        }
        for (a1 = a1.d().iterator(); a1.hasNext();)
        {
            if ((o)a1.next() == o.PICKUP_IN_STORE)
            {
                return true;
            }
        }

        return false;
    }

    private boolean d(com.target.ui.model.a a1)
    {
        return c(a1) && a1.b() == i.InStock;
    }

    public int getCount()
    {
        return mRelevantStores.size();
    }

    public View getView(int j, View view, ViewGroup viewgroup)
    {
        boolean flag = false;
        com.target.ui.model.a a1 = (com.target.ui.model.a)getItem(j);
        RadioButton radiobutton;
        if (view == null)
        {
            view = mInflater.inflate(0x7f030113, null, false);
            viewgroup = new ViewHolder(view);
            view.setTag(viewgroup);
            view.setOnClickListener(this);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        viewgroup.position = j;
        radiobutton = ((ViewHolder) (viewgroup)).pickupStoreChoice;
        if (j == mSelectedPosition)
        {
            flag = true;
        }
        radiobutton.setChecked(flag);
        ((ViewHolder) (viewgroup)).pickupStoreChoice.setTag(viewgroup);
        ((ViewHolder) (viewgroup)).pickupStoreChoice.setOnClickListener(this);
        ((ViewHolder) (viewgroup)).storeName.setText(a1.a().getName());
        ((ViewHolder) (viewgroup)).storeInfo.setTag(viewgroup);
        ((ViewHolder) (viewgroup)).storeInfo.setOnClickListener(this);
        a(viewgroup, a1, mCartProduct);
        return view;
    }

    public void onClick(View view)
    {
        ViewHolder viewholder = (ViewHolder)u.a(view.getTag(), com/target/ui/adapter/cart/CartPickupStoreAdapter$ViewHolder);
        if (viewholder == null)
        {
            mListener.a();
            return;
        }
        Object obj = null;
        int j = viewholder.position;
        com.target.ui.model.a a1 = obj;
        if (j >= 0)
        {
            a1 = obj;
            if (j < mRelevantStores.size())
            {
                a1 = (com.target.ui.model.a)mRelevantStores.get(viewholder.position);
            }
        }
        if (a1 == null)
        {
            mListener.a();
            return;
        }
        if (view.getId() == 0x7f100327)
        {
            mListener.a(a1);
            return;
        }
        if (mSelectedPosition != j)
        {
            mSelectedPosition = j;
            notifyDataSetInvalidated();
            mListener.a(mCartProduct, a1, viewholder.fulfillmentType);
            return;
        } else
        {
            mListener.a();
            return;
        }
    }
}
