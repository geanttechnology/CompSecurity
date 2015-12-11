// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.cart;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import com.target.mothership.common.a.b;
import com.target.mothership.model.cart.interfaces.CartDetails;
import com.target.mothership.model.cart.interfaces.CartProduct;
import com.target.mothership.model.cart.interfaces.CartRegistryDetails;
import com.target.mothership.model.cart.interfaces.FreeProduct;
import com.target.mothership.model.cart.interfaces.FreeShippingPromotion;
import com.target.mothership.model.cart.interfaces.GiftProduct;
import com.target.mothership.model.cart.interfaces.RewardOptions;
import com.target.mothership.model.common.OrderProductImage;
import com.target.mothership.util.o;
import com.target.ui.adapter.b.c;
import com.target.ui.adapter.b.e;
import com.target.ui.util.al;
import com.target.ui.util.d;
import com.target.ui.util.u;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.cart.CartItemOverflowView;
import com.target.ui.view.cart.CartProductFulfillmentView;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.adapter.cart:
//            a

public class CartProductAdapter extends e
    implements android.view.View.OnClickListener, android.widget.AdapterView.OnItemSelectedListener, android.widget.RadioGroup.OnCheckedChangeListener, com.target.ui.view.cart.CartItemOverflowView.a
{
    static class ViewHolder extends com.target.ui.view.a
    {

        LinearLayout freeItemContainer;
        CartProductFulfillmentView fulfillmentContainer;
        BitmapImageView imageView;
        CartItemOverflowView overflowMenu;
        int position;
        TextView price;
        Spinner quantitySpinner;
        TextView registryName;
        LinearLayout rewardsContainer;
        TextView title;

        ViewHolder(View view)
        {
            super(view);
            position = -1;
        }
    }

    public static interface a
    {

        public abstract void a(CartProduct cartproduct);

        public abstract void a(CartProduct cartproduct, int i);

        public abstract void a(GiftProduct giftproduct);

        public abstract void a(BitmapImageView bitmapimageview, CartProduct cartproduct);

        public abstract void b(CartProduct cartproduct);

        public abstract void c(CartProduct cartproduct);

        public abstract void d(CartProduct cartproduct);

        public abstract void e(CartProduct cartproduct);

        public abstract void f(CartProduct cartproduct);
    }


    private static final String DOLLAR_STRING = "$";
    private static final int FREE_ITEM_DEFAULT_QUANTITY = 1;
    private static final int NULL_INT = -1;
    private a mActionListener;
    private CartDetails mCartDetails;
    private Context mContext;
    private FreeShippingPromotion mFreeShippingPromotion;
    private int mImageSize;
    private LayoutInflater mInflater;
    private List mProducts;

    public CartProductAdapter(Context context, a a1)
    {
        super(context, Collections.emptyList());
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mActionListener = a1;
        mImageSize = context.getResources().getDimensionPixelSize(0x7f0a00de);
    }

    private View a(ViewGroup viewgroup, FreeProduct freeproduct)
    {
        viewgroup = mInflater.inflate(0x7f030109, viewgroup, false);
        ((TextView)viewgroup.findViewById(0x7f10030f)).setText(freeproduct.g());
        a((BitmapImageView)viewgroup.findViewById(0x7f10030e), freeproduct);
        TextView textview = (TextView)viewgroup.findViewById(0x7f100311);
        int i = freeproduct.d();
        if (i > 1)
        {
            al.a(textview, viewgroup.getResources().getString(0x7f090109, new Object[] {
                Integer.valueOf(i)
            }));
            return viewgroup;
        } else
        {
            al.c(textview);
            return viewgroup;
        }
    }

    private View a(ViewGroup viewgroup, RewardOptions rewardoptions)
    {
        Object obj = null;
        View view = obj;
        if (rewardoptions.a() != null)
        {
            view = obj;
            if (rewardoptions.a().size() != 0)
            {
                view = mInflater.inflate(0x7f03011b, viewgroup, false);
                viewgroup = (TextView)view.findViewById(0x7f100343);
                RadioGroup radiogroup = (RadioGroup)view.findViewById(0x7f100344);
                boolean flag1 = a(rewardoptions.a());
                int i = 0;
                while (i < rewardoptions.a().size()) 
                {
                    GiftProduct giftproduct = (GiftProduct)rewardoptions.a().get(i);
                    RadioButton radiobutton = (RadioButton)mInflater.inflate(0x7f030108, radiogroup, false);
                    if (i == 0)
                    {
                        viewgroup.setText((new StringBuilder()).append("$").append(giftproduct.b().intValue()).toString());
                    } else
                    {
                        radiogroup.addView(b());
                    }
                    radiobutton.setText(d.a(mContext, giftproduct));
                    if (flag1)
                    {
                        radiobutton.setChecked(giftproduct.l_());
                    } else
                    {
                        boolean flag;
                        if (giftproduct.c() == b.Email)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        radiobutton.setChecked(flag);
                    }
                    radiobutton.setId(i);
                    radiobutton.setTag(giftproduct);
                    radiogroup.addView(radiobutton);
                    i++;
                }
                radiogroup.setOnCheckedChangeListener(this);
            }
        }
        return view;
    }

    private CartProduct a(ViewHolder viewholder)
    {
        int i;
        if (viewholder != null)
        {
            if ((i = viewholder.position) >= 0 && i < mProducts.size())
            {
                return (CartProduct)mProducts.get(viewholder.position);
            }
        }
        return null;
    }

    private void a(LinearLayout linearlayout, CartProduct cartproduct)
    {
        linearlayout.removeAllViews();
        if (cartproduct.y().isEmpty())
        {
            al.c(linearlayout);
            return;
        }
        for (cartproduct = cartproduct.y().iterator(); cartproduct.hasNext(); linearlayout.addView(a(((ViewGroup) (linearlayout)), (FreeProduct)cartproduct.next()))) { }
        al.b(linearlayout);
    }

    private void a(TextView textview, CartProduct cartproduct)
    {
        if (!cartproduct.l().b())
        {
            al.c(textview);
            return;
        }
        cartproduct = (CartRegistryDetails)cartproduct.l().c();
        if (o.e(cartproduct.b()))
        {
            al.c(textview);
            return;
        } else
        {
            al.a(textview, cartproduct.b());
            textview.setOnClickListener(this);
            return;
        }
    }

    private void a(CartProduct cartproduct, Spinner spinner)
    {
        int i = cartproduct.j_();
        spinner.setSelection(i, true);
        cartproduct = new StringBuilder(spinner.getResources().getString(0x7f09011e));
        cartproduct.append(" ");
        cartproduct.append(i);
        spinner.setContentDescription(cartproduct.toString());
    }

    private void a(BitmapImageView bitmapimageview, CartProduct cartproduct)
    {
        if (bitmapimageview == null)
        {
            return;
        } else
        {
            cartproduct = cartproduct.b().a(mImageSize);
            c.a(mContext, cartproduct, bitmapimageview);
            al.b(bitmapimageview);
            return;
        }
    }

    private void a(BitmapImageView bitmapimageview, FreeProduct freeproduct)
    {
        if (bitmapimageview == null)
        {
            return;
        }
        if (freeproduct.a() == null)
        {
            freeproduct = null;
        } else
        {
            freeproduct = (OrderProductImage)freeproduct.a().get(0);
        }
        if (freeproduct != null)
        {
            freeproduct = freeproduct.a(mImageSize);
            c.a(mContext, freeproduct, bitmapimageview);
            al.b(bitmapimageview);
            return;
        } else
        {
            bitmapimageview.setImageResource(0x7f0201ae);
            al.b(bitmapimageview);
            return;
        }
    }

    private boolean a(List list)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            GiftProduct giftproduct = (GiftProduct)list.next();
            if (giftproduct.l_())
            {
                return true;
            }
            if (giftproduct.c() != b.Email);
        }

        return false;
    }

    private View b()
    {
        android.widget.RadioGroup.LayoutParams layoutparams = new android.widget.RadioGroup.LayoutParams(-1, mContext.getResources().getDimensionPixelSize(0x7f0a00ea));
        View view = new View(mContext);
        view.setLayoutParams(layoutparams);
        view.setBackgroundColor(mContext.getResources().getColor(0x7f0f00e4));
        return view;
    }

    private void b(LinearLayout linearlayout, CartProduct cartproduct)
    {
        linearlayout.removeAllViews();
        if (cartproduct.x() != null && cartproduct.x().size() != 0)
        {
            for (cartproduct = cartproduct.x().iterator(); cartproduct.hasNext(); linearlayout.addView(a(linearlayout, (RewardOptions)cartproduct.next()))) { }
            al.b(linearlayout);
            return;
        } else
        {
            al.c(linearlayout);
            return;
        }
    }

    public CartDetails a()
    {
        return mCartDetails;
    }

    public CartProduct a(int i)
    {
        if (mProducts == null || mProducts.size() == 0)
        {
            return null;
        } else
        {
            return (CartProduct)mProducts.get(i);
        }
    }

    public void a(CartDetails cartdetails, FreeShippingPromotion freeshippingpromotion)
    {
        mCartDetails = cartdetails;
        mFreeShippingPromotion = freeshippingpromotion;
        mProducts = cartdetails.a();
        notifyDataSetChanged();
    }

    public void a(CartItemOverflowView cartitemoverflowview)
    {
        cartitemoverflowview = a((ViewHolder)u.a(cartitemoverflowview.getTag(), com/target/ui/adapter/cart/CartProductAdapter$ViewHolder));
        if (cartitemoverflowview == null)
        {
            return;
        } else
        {
            mActionListener.a(cartitemoverflowview);
            return;
        }
    }

    public void b(CartItemOverflowView cartitemoverflowview)
    {
        cartitemoverflowview = a((ViewHolder)u.a(cartitemoverflowview.getTag(), com/target/ui/adapter/cart/CartProductAdapter$ViewHolder));
        if (cartitemoverflowview == null)
        {
            return;
        } else
        {
            mActionListener.b(cartitemoverflowview);
            return;
        }
    }

    public int getCount()
    {
        if (mProducts == null || mProducts.size() == 0)
        {
            return 0;
        } else
        {
            return mProducts.size();
        }
    }

    public Object getItem(int i)
    {
        return a(i);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        CartProduct cartproduct = a(i);
        if (view == null)
        {
            view = mInflater.inflate(0x7f03010f, null, false);
            viewgroup = new ViewHolder(view);
            view.setTag(viewgroup);
            ((ViewHolder) (viewgroup)).title.setTag(viewgroup);
            ((ViewHolder) (viewgroup)).imageView.setTag(viewgroup);
            ((ViewHolder) (viewgroup)).quantitySpinner.setTag(viewgroup);
            ((ViewHolder) (viewgroup)).overflowMenu.setTag(viewgroup);
            ((ViewHolder) (viewgroup)).registryName.setTag(viewgroup);
        } else
        {
            viewgroup = (ViewHolder)view.getTag();
        }
        viewgroup.position = i;
        ((ViewHolder) (viewgroup)).title.setText(cartproduct.g());
        ((ViewHolder) (viewgroup)).title.setOnClickListener(this);
        a(((ViewHolder) (viewgroup)).registryName, cartproduct);
        a(((ViewHolder) (viewgroup)).imageView, cartproduct);
        ((ViewHolder) (viewgroup)).imageView.setOnClickListener(this);
        a(((ViewHolder) (viewgroup)).freeItemContainer, cartproduct);
        ((ViewHolder) (viewgroup)).price.setText((new StringBuilder()).append("$").append(cartproduct.h_()).toString());
        ((ViewHolder) (viewgroup)).quantitySpinner.setAdapter(new com.target.ui.adapter.cart.a(getContext(), cartproduct));
        ((ViewHolder) (viewgroup)).quantitySpinner.setOnItemSelectedListener(null);
        a(cartproduct, ((ViewHolder) (viewgroup)).quantitySpinner);
        ((ViewHolder) (viewgroup)).quantitySpinner.setOnItemSelectedListener(this);
        ((ViewHolder) (viewgroup)).overflowMenu.setCartItemOverflowListener(this);
        ((ViewHolder) (viewgroup)).fulfillmentContainer.a(cartproduct, mCartDetails, mFreeShippingPromotion, mActionListener);
        b(((ViewHolder) (viewgroup)).rewardsContainer, cartproduct);
        return view;
    }

    public void onCheckedChanged(RadioGroup radiogroup, int i)
    {
        if (i != -1)
        {
            if ((radiogroup = (GiftProduct)u.a(radiogroup.findViewById(i).getTag(), com/target/mothership/model/cart/interfaces/GiftProduct)) != null)
            {
                mActionListener.a(radiogroup);
                return;
            }
        }
    }

    public void onClick(View view)
    {
        ViewHolder viewholder = (ViewHolder)u.a(view.getTag(), com/target/ui/adapter/cart/CartProductAdapter$ViewHolder);
        CartProduct cartproduct;
        if (viewholder != null)
        {
            if ((cartproduct = a(viewholder)) != null)
            {
                switch (view.getId())
                {
                default:
                    return;

                case 2131755824: 
                    mActionListener.f(cartproduct);
                    return;

                case 2131755830: 
                case 2131755831: 
                    mActionListener.a(viewholder.imageView, cartproduct);
                    break;
                }
                return;
            }
        }
    }

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (ViewHolder)u.a(adapterview.getTag(), com/target/ui/adapter/cart/CartProductAdapter$ViewHolder);
        if (adapterview != null)
        {
            int j = ((ViewHolder) (adapterview)).position;
            if (j >= 0 && j < mProducts.size())
            {
                adapterview = (CartProduct)mProducts.get(((ViewHolder) (adapterview)).position);
            } else
            {
                adapterview = null;
            }
            if (adapterview != null)
            {
                view = Integer.valueOf(adapterview.j_());
                if (view == null || view.intValue() != i)
                {
                    if (i == 0)
                    {
                        mActionListener.a(adapterview);
                        return;
                    } else
                    {
                        mActionListener.a(adapterview, i);
                        return;
                    }
                }
            }
        }
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }
}
