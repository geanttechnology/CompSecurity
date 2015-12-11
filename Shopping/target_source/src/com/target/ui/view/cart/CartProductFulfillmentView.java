// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.cart;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.a.a.e;
import com.target.mothership.common.a.b;
import com.target.mothership.common.a.f;
import com.target.mothership.common.product.i;
import com.target.mothership.model.cart.interfaces.CartDetails;
import com.target.mothership.model.cart.interfaces.CartProduct;
import com.target.mothership.model.cart.interfaces.FreeShippingPromotion;
import com.target.mothership.model.cart.interfaces.LimitedQuantityDetails;
import com.target.mothership.model.common.StorePickUpDetails;
import com.target.ui.util.al;
import com.target.ui.util.d;
import com.target.ui.view.a;
import java.util.Date;

public class CartProductFulfillmentView extends LinearLayout
    implements android.view.View.OnClickListener
{
    static class Views extends a
    {

        View cartSeparator;
        View digitalDownloadFulfillmentView;
        ImageButton editPuisStoreButton;
        ImageButton editShipFulfillmentMethodButton;
        View giftCardFulfillmentView;
        View pickupDetailsView;
        View pickupFulfillmentView;
        View preOrderFulfillmentView;
        ImageButton selectPuisFulfillmentMethodButton;
        ImageButton selectShipFulfillmentMethodButton;
        View shipHomeFulfillmentView;
        View shipMethodDetailsView;
        View standardFulfillmentView;

        Views(View view)
        {
            super(view);
        }
    }


    private CartDetails mCartDetails;
    private CartProduct mCartProduct;
    private FreeShippingPromotion mFreeShippingPromotion;
    private com.target.ui.adapter.cart.CartProductAdapter.a mListener;
    private Views mViews;

    public CartProductFulfillmentView(Context context)
    {
        super(context);
        a(context);
    }

    public CartProductFulfillmentView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public CartProductFulfillmentView(Context context, AttributeSet attributeset, int j)
    {
        super(context, attributeset, j);
        a(context);
    }

    private transient String a(int j, Object aobj[])
    {
        return getContext().getString(j, aobj);
    }

    private void a()
    {
        al.a(mViews.digitalDownloadFulfillmentView, new View[] {
            mViews.preOrderFulfillmentView, mViews.giftCardFulfillmentView, mViews.standardFulfillmentView
        });
    }

    private void a(Context context)
    {
        setOrientation(1);
        inflate(context, 0x7f03010a, this);
        mViews = new Views(this);
    }

    private void a(View view, CartProduct cartproduct)
    {
        view = (TextView)view.findViewById(0x7f10034b);
        if (cartproduct.j().b())
        {
            cartproduct = (LimitedQuantityDetails)cartproduct.j().c();
            if (cartproduct.a())
            {
                al.a(view, a(0x7f0903ec, new Object[] {
                    Integer.valueOf(cartproduct.b())
                }));
                return;
            }
        }
        al.c(view);
    }

    private void a(TextView textview, TextView textview1)
    {
        if (mCartProduct.c() == b.PickupInStore)
        {
            if (mCartProduct.k().b())
            {
                al.a(textview, ((StorePickUpDetails)mCartProduct.k().c()).b());
                al.c(textview1);
            }
            return;
        }
        if (mCartProduct.c() == b.ShipToStore)
        {
            if (mCartProduct.k().b())
            {
                al.a(textview, ((StorePickUpDetails)mCartProduct.k().c()).b());
            }
            al.a(textview1, a(0x7f090119, new Object[] {
                getExpectedDeliveryDate()
            }));
            return;
        } else
        {
            al.a(new View[] {
                textview, textview1
            });
            return;
        }
    }

    private void a(TextView textview, boolean flag)
    {
        if (flag)
        {
            al.b(textview);
            return;
        } else
        {
            al.c(textview);
            return;
        }
    }

    private void a(boolean flag)
    {
        TextView textview = (TextView)mViews.pickupFulfillmentView.findViewById(0x7f10033e);
        TextView textview1 = (TextView)mViews.pickupFulfillmentView.findViewById(0x7f10033d);
        mViews.editPuisStoreButton.setOnClickListener(this);
        mViews.selectPuisFulfillmentMethodButton.setImageResource(d(flag));
        a(textview, textview1);
        if (flag)
        {
            al.a(mViews.pickupFulfillmentView, new View[] {
                mViews.cartSeparator, mViews.shipHomeFulfillmentView
            });
            al.a(null, new View[] {
                mViews.selectPuisFulfillmentMethodButton, mViews.pickupDetailsView
            });
        } else
        {
            al.b(new View[] {
                mViews.pickupFulfillmentView, mViews.cartSeparator, mViews.shipHomeFulfillmentView
            });
            al.a(this, new View[] {
                mViews.selectPuisFulfillmentMethodButton, mViews.pickupDetailsView
            });
        }
        al.a(mViews.standardFulfillmentView, new View[] {
            mViews.giftCardFulfillmentView, mViews.preOrderFulfillmentView, mViews.digitalDownloadFulfillmentView
        });
    }

    private void b()
    {
        ((TextView)mViews.preOrderFulfillmentView.findViewById(0x7f10032a)).setText(com.target.ui.util.d.a(getContext(), mFreeShippingPromotion, mCartDetails, mCartProduct));
        a((TextView)mViews.preOrderFulfillmentView.findViewById(0x7f10032c), mCartProduct.w());
        ((ImageButton)mViews.preOrderFulfillmentView.findViewById(0x7f10032e)).setOnClickListener(this);
        TextView textview = (TextView)mViews.preOrderFulfillmentView.findViewById(0x7f10032d);
        if (mCartProduct.p() != null)
        {
            textview.setText(getExpectedDeliveryDate());
        } else
        {
            textview.setText(a(0x7f090122, new Object[0]));
        }
        al.a(mViews.preOrderFulfillmentView, new View[] {
            mViews.digitalDownloadFulfillmentView, mViews.giftCardFulfillmentView, mViews.standardFulfillmentView
        });
    }

    private void b(boolean flag)
    {
        TextView textview = (TextView)mViews.shipHomeFulfillmentView.findViewById(0x7f10032d);
        ((TextView)mViews.shipHomeFulfillmentView.findViewById(0x7f100349)).setText(com.target.ui.util.d.a(getContext(), mFreeShippingPromotion, mCartDetails, mCartProduct));
        a((TextView)mViews.shipHomeFulfillmentView.findViewById(0x7f10032c), mCartProduct.w());
        if ((mCartProduct.d() == f.ShipToHome || mCartProduct.d() == f.Special) && mCartProduct.c() != b.Rush)
        {
            textview.setText(getExpectedDeliveryDate());
        } else
        {
            textview.setText(a(0x7f090127, new Object[0]));
        }
        textview = (TextView)mViews.shipHomeFulfillmentView.findViewById(0x7f10034a);
        if (mCartProduct.q())
        {
            al.a(textview, a(0x7f0900f6, new Object[0]));
        } else
        {
            al.c(textview);
        }
        a(mViews.shipHomeFulfillmentView, mCartProduct);
        mViews.editShipFulfillmentMethodButton.setOnClickListener(this);
        mViews.selectShipFulfillmentMethodButton.setImageResource(c(flag));
        if (flag)
        {
            al.a(mViews.shipHomeFulfillmentView, new View[] {
                mViews.cartSeparator, mViews.pickupFulfillmentView
            });
            al.a(null, new View[] {
                mViews.selectShipFulfillmentMethodButton, mViews.shipMethodDetailsView
            });
        } else
        {
            al.b(new View[] {
                mViews.pickupFulfillmentView, mViews.cartSeparator, mViews.standardFulfillmentView
            });
            al.a(this, new View[] {
                mViews.selectShipFulfillmentMethodButton, mViews.shipMethodDetailsView
            });
        }
        al.a(mViews.standardFulfillmentView, new View[] {
            mViews.giftCardFulfillmentView, mViews.preOrderFulfillmentView, mViews.digitalDownloadFulfillmentView
        });
    }

    private int c(boolean flag)
    {
label0:
        {
label1:
            {
                int j = 0x7f0201ed;
                if (mCartProduct.d() == f.ShipToHome || mCartProduct.d() == f.Special)
                {
                    if (!flag)
                    {
                        break label0;
                    }
                    if (mCartProduct.g_() != i.InStock)
                    {
                        break label1;
                    }
                    j = 0x7f0201e6;
                }
                return j;
            }
            return 0x7f0201e5;
        }
        return mCartProduct.g_() != i.InStock && !mCartProduct.q() ? 0x7f0201ef : 0x7f0201ee;
    }

    private void c()
    {
        if (mCartProduct.c() != b.Email && mCartProduct.c() != b.Mobile)
        {
            b(e());
            return;
        }
        TextView textview = (TextView)mViews.giftCardFulfillmentView.findViewById(0x7f100317);
        ImageView imageview = (ImageView)mViews.giftCardFulfillmentView.findViewById(0x7f100316);
        if (mCartProduct.c() == b.Email)
        {
            textview.setText(a(0x7f0900fe, new Object[0]));
            imageview.setImageResource(0x7f0201e0);
        } else
        {
            textview.setText(a(0x7f09013a, new Object[0]));
            imageview.setImageResource(0x7f0201e8);
        }
        al.a(mViews.giftCardFulfillmentView, new View[] {
            mViews.preOrderFulfillmentView, mViews.digitalDownloadFulfillmentView, mViews.standardFulfillmentView
        });
    }

    private int d(boolean flag)
    {
label0:
        {
            int j = 0x7f0201ed;
            if (mCartProduct.c() == b.PickupInStore || mCartProduct.c() == b.ShipToStore)
            {
                if (!flag)
                {
                    break label0;
                }
                j = 0x7f0201ea;
            }
            return j;
        }
        return 0x7f0201ee;
    }

    private void d()
    {
        boolean flag = e();
        if (mCartProduct.s() || mCartProduct.t())
        {
            a(flag);
        }
        if (mCartProduct.r())
        {
            b(flag);
        }
        al.a(mViews.standardFulfillmentView, new View[] {
            mViews.giftCardFulfillmentView, mViews.preOrderFulfillmentView, mViews.digitalDownloadFulfillmentView
        });
    }

    private void e(boolean flag)
    {
        if (mCartProduct.d() == f.ShipToHome || mCartProduct.d() == f.Special)
        {
            return;
        } else
        {
            g(flag);
            mListener.c(mCartProduct);
            return;
        }
    }

    private boolean e()
    {
        boolean flag1 = mCartProduct.r();
        boolean flag;
        if (mCartProduct.s() || mCartProduct.t())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag ^ flag1;
    }

    private void f(boolean flag)
    {
        if (flag)
        {
            return;
        } else
        {
            mViews.selectPuisFulfillmentMethodButton.setImageResource(0x7f0201ee);
            mViews.selectShipFulfillmentMethodButton.setImageResource(0x7f0201ed);
            return;
        }
    }

    private void g(boolean flag)
    {
        if (flag)
        {
            return;
        } else
        {
            mViews.selectShipFulfillmentMethodButton.setImageResource(0x7f0201ee);
            mViews.selectPuisFulfillmentMethodButton.setImageResource(0x7f0201ed);
            return;
        }
    }

    private String getExpectedDeliveryDate()
    {
        Date date;
        Date date1;
        if (mCartProduct.v().b())
        {
            date = (Date)mCartProduct.v().c();
        } else
        {
            date = null;
        }
        if (mCartProduct.u().b())
        {
            date1 = (Date)mCartProduct.u().c();
        } else
        {
            date1 = null;
        }
        return com.target.ui.util.d.a(getContext(), date, date1);
    }

    public void a(CartProduct cartproduct, CartDetails cartdetails, FreeShippingPromotion freeshippingpromotion, com.target.ui.adapter.cart.CartProductAdapter.a a1)
    {
        mCartProduct = cartproduct;
        mCartDetails = cartdetails;
        mFreeShippingPromotion = freeshippingpromotion;
        mListener = a1;
        if (cartproduct.m())
        {
            a();
            return;
        }
        if (cartproduct.o())
        {
            b();
            return;
        }
        if (cartproduct.n())
        {
            c();
            return;
        } else
        {
            d();
            return;
        }
    }

    public void onClick(View view)
    {
        if (mListener == null || mCartProduct == null)
        {
            return;
        }
        switch (view.getId())
        {
        default:
            return;

        case 2131755822: 
        case 2131755848: 
            g(e());
            mListener.d(mCartProduct);
            return;

        case 2131755833: 
        case 2131755834: 
        case 2131755835: 
            f(e());
            mListener.e(mCartProduct);
            return;

        case 2131755846: 
        case 2131755847: 
            e(e());
            break;
        }
    }
}
