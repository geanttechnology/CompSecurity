// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.bestbuy.android.activities.registry.BuyerRegistryAndWishListFragment;
import com.bestbuy.android.activities.registry.WishListWithProductsFragment;
import com.bestbuy.android.api.lib.models.registry.Entities;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.ButtonState;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.PriceBlock;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.bbyobjects.BBYTextView;

public class mo
{

    private int a;
    private jb b;

    public mo()
    {
        a = 0;
        b = null;
    }

    static int a(mo mo1, int i)
    {
        mo1.a = i;
        return i;
    }

    public static View a(Context context, BBYBaseFragment bbybasefragment, BBYProduct bbyproduct, Entities entities, int i, boolean flag, LinearLayout linearlayout, RegistryWishList registrywishlist)
    {
        mp mp1 = new mp();
        Object obj = new mo();
        LayoutInflater layoutinflater = LayoutInflater.from(context);
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            linearlayout = layoutinflater.inflate(0x7f0300d2, null);
            a(context, bbybasefragment, bbyproduct, entities, mp1, ((View) (linearlayout)), flag);
            return linearlayout;

        case 2: // '\002'
            obj = layoutinflater.inflate(0x7f0300cd, null);
            a(context, bbybasefragment, bbyproduct, entities, mp1, ((View) (obj)), linearlayout, registrywishlist, flag);
            return ((View) (obj));

        case 3: // '\003'
            return layoutinflater.inflate(0x7f0300cf, null);

        case 4: // '\004'
            linearlayout = layoutinflater.inflate(0x7f0300d0, null);
            ((mo) (obj)).a(context, bbybasefragment, bbyproduct, entities, mp1, ((View) (linearlayout)));
            return linearlayout;

        case 5: // '\005'
            bbybasefragment = layoutinflater.inflate(0x7f0300d1, null);
            a(context, bbyproduct, mp1, ((View) (bbybasefragment)));
            return bbybasefragment;

        case 6: // '\006'
            return layoutinflater.inflate(0x7f0300ce, null);
        }
    }

    static jb a(mo mo1)
    {
        return mo1.b;
    }

    static jb a(mo mo1, jb jb)
    {
        mo1.b = jb;
        return jb;
    }

    private static void a(Context context, BBYProduct bbyproduct, mp mp1, View view)
    {
        mp1.c = (ImageView)view.findViewById(0x7f0c034a);
        mp1.d = (ImageView)view.findViewById(0x7f0c0348);
        mp1.e = (BBYTextView)view.findViewById(0x7f0c0349);
        mp1.e.setText("1");
    }

    private void a(Context context, BBYBaseFragment bbybasefragment, BBYProduct bbyproduct, Entities entities, mp mp1, View view)
    {
        mp.a(mp1, view.findViewById(0x7f0c0064));
        mp.b(mp1, (LinearLayout)view.findViewById(0x7f0c0344));
        mp1.c = (ImageView)view.findViewById(0x7f0c034a);
        mp1.d = (ImageView)view.findViewById(0x7f0c0348);
        mp1.e = (BBYTextView)view.findViewById(0x7f0c0349);
        mp1.e.setText(Integer.toString(entities.getRequiredQuantity()));
        a = entities.getRequiredQuantity();
        if (a > 1)
        {
            mp1.d.setImageResource(0x7f020115);
        }
        if (a != 10) goto _L2; else goto _L1
_L1:
        mp1.c.setImageResource(0x7f020007);
_L4:
        mp.f(mp1).setOnClickListener(new android.view.View.OnClickListener(view, context, bbybasefragment, entities) {

            final View a;
            final Context b;
            final BBYBaseFragment c;
            final Entities d;
            final mo e;

            public void onClick(View view1)
            {
                if (mo.a(e) != null && (mo.a(e).getStatus() == android.os.AsyncTask.Status.RUNNING || mo.a(e).getStatus() == android.os.AsyncTask.Status.PENDING))
                {
                    return;
                }
                RelativeLayout relativelayout = (RelativeLayout)a.getParent().getParent().getParent().getParent().getParent();
                view1 = null;
                if (relativelayout != null)
                {
                    view1 = (ProgressBar)relativelayout.findViewById(0x7f0c0230);
                }
                mo.a(e, new jb((Activity)b, c, d.getParentType(), d.getParentUuid(), d.getUuid(), view1));
                mo.a(e).executeOnExecutor(nb.g, new Void[0]);
            }

            
            {
                e = mo.this;
                a = view;
                b = context;
                c = bbybasefragment;
                d = entities;
                super();
            }
        });
        mp1.d.setOnClickListener(new android.view.View.OnClickListener(mp1, view, context, bbybasefragment, entities) {

            final mp a;
            final View b;
            final Context c;
            final BBYBaseFragment d;
            final Entities e;
            final mo f;

            public void onClick(View view1)
            {
                if (mo.b(f) > 1)
                {
                    a.c.setImageResource(0x7f020006);
                    mo.a(f, mo.b(f) - 1);
                    RelativeLayout relativelayout = (RelativeLayout)b.getParent().getParent().getParent().getParent().getParent();
                    view1 = null;
                    if (relativelayout != null)
                    {
                        view1 = (ProgressBar)relativelayout.findViewById(0x7f0c0230);
                    }
                    (new jw((Activity)c, d, e.getParentUuid(), e.getUuid(), e.getParentType(), mo.b(f), view1, a)).executeOnExecutor(nb.g, new Void[0]);
                }
                if (mo.b(f) == 1)
                {
                    a.d.setImageResource(0x7f020116);
                }
            }

            
            {
                f = mo.this;
                a = mp1;
                b = view;
                c = context;
                d = bbybasefragment;
                e = entities;
                super();
            }
        });
        mp1.c.setOnClickListener(new android.view.View.OnClickListener(view, context, bbybasefragment, entities, mp1) {

            final View a;
            final Context b;
            final BBYBaseFragment c;
            final Entities d;
            final mp e;
            final mo f;

            public void onClick(View view1)
            {
                if (mo.b(f) < 10)
                {
                    mo.a(f, mo.b(f) + 1);
                    RelativeLayout relativelayout = (RelativeLayout)a.getParent().getParent().getParent().getParent().getParent();
                    view1 = null;
                    if (relativelayout != null)
                    {
                        view1 = (ProgressBar)relativelayout.findViewById(0x7f0c0230);
                    }
                    (new jw((Activity)b, c, d.getParentUuid(), d.getUuid(), d.getParentType(), mo.b(f), view1, e)).executeOnExecutor(nb.g, new Void[0]);
                }
                if (mo.b(f) == 10)
                {
                    e.c.setImageResource(0x7f020007);
                }
            }

            
            {
                f = mo.this;
                a = view;
                b = context;
                c = bbybasefragment;
                d = entities;
                e = mp1;
                super();
            }
        });
        return;
_L2:
        if (a == 1)
        {
            mp1.d.setImageResource(0x7f020116);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private static void a(Context context, BBYBaseFragment bbybasefragment, BBYProduct bbyproduct, Entities entities, mp mp1, View view, LinearLayout linearlayout, RegistryWishList registrywishlist, 
            boolean flag)
    {
        mp1.a = (ImageView)view.findViewById(0x7f0c033b);
        mp1.b = (BBYTextView)view.findViewById(0x7f0c033c);
        mp.a(mp1, (BBYTextView)view.findViewById(0x7f0c033f));
        mp.b(mp1, (BBYTextView)view.findViewById(0x7f0c0340));
        if (bbyproduct.getPriceBlock() != null)
        {
            mp.b(mp1, (RelativeLayout)view.findViewById(0x7f0c0341));
            mp.c(mp1).setVisibility(0);
            if (bbyproduct.getPriceBlock().getButtonState().isCommerceUnavailable())
            {
                mp.c(mp1).setBackgroundResource(0x7f020009);
            }
            mp.c(mp1).setOnClickListener(new android.view.View.OnClickListener(bbyproduct, bbybasefragment, context, registrywishlist, entities) {

                final BBYProduct a;
                final BBYBaseFragment b;
                final Context c;
                final RegistryWishList d;
                final Entities e;

                public void onClick(View view1)
                {
                    if (a.getPriceBlock().getButtonState().isCommerceUnavailable())
                    {
                        if ((b instanceof BuyerRegistryAndWishListFragment) && b.isAdded())
                        {
                            ((BuyerRegistryAndWishListFragment)b).b(((Activity)c).getString(0x7f08009f));
                        }
                        return;
                    }
                    view1 = ((BuyerRegistryAndWishListFragment)b).c();
                    if (view1 != null)
                    {
                        view1.bringToFront();
                    }
                    String s = nk.a(d.getType());
                    (new in((Activity)c, b, view1, a.getSkuId(), d.getUuid(), e.getUuid(), s)).execute(new Void[0]);
                }

            
            {
                a = bbyproduct;
                b = bbybasefragment;
                c = context;
                d = registrywishlist;
                e = entities;
                super();
            }
            });
        } else
        {
            mp.b(mp1, (RelativeLayout)view.findViewById(0x7f0c0341));
            mp.c(mp1).setVisibility(8);
        }
        mp.a(mp1).setText((new StringBuilder()).append("Want: ").append(entities.getRequiredQuantity()).toString());
        mp.b(mp1).setText((new StringBuilder()).append("Have: ").append(entities.getPurchaseQuantity()).toString());
        if (entities.isFavorite() && !flag)
        {
            mp1.a.setVisibility(0);
            mp1.b.setVisibility(0);
            mp1.a.setImageResource(0x7f0200c9);
            mp1.b.setText("Our Favorite");
            return;
        }
        if (entities.isFavorite() && flag)
        {
            mp1.a.setVisibility(0);
            mp1.b.setVisibility(0);
            mp1.a.setImageResource(0x7f0200c9);
            mp1.b.setText("My Favorite");
            return;
        } else
        {
            mp1.a.setVisibility(8);
            mp1.b.setVisibility(8);
            return;
        }
    }

    private static void a(Context context, BBYBaseFragment bbybasefragment, BBYProduct bbyproduct, Entities entities, mp mp1, View view, boolean flag)
    {
        mp.a(mp1, view.findViewById(0x7f0c0064));
        mp.a(mp1, (LinearLayout)view.findViewById(0x7f0c033a));
        mp1.a = (ImageView)view.findViewById(0x7f0c033b);
        mp1.b = (BBYTextView)view.findViewById(0x7f0c033c);
        mp.a(mp1, (BBYTextView)view.findViewById(0x7f0c033f));
        mp.b(mp1, (BBYTextView)view.findViewById(0x7f0c0340));
        mp.a(mp1, (RelativeLayout)view.findViewById(0x7f0c0343));
        mp.a(mp1).setText((new StringBuilder()).append("Want: ").append(entities.getRequiredQuantity()).toString());
        mp.b(mp1).setText((new StringBuilder()).append("Have: ").append(entities.getPurchaseQuantity()).toString());
        if (bbyproduct.getPriceBlock() != null)
        {
            mp.b(mp1, (RelativeLayout)view.findViewById(0x7f0c0341));
            mp.c(mp1).setVisibility(0);
            if (bbyproduct.getPriceBlock().getButtonState().isCommerceUnavailable())
            {
                mp.c(mp1).setBackgroundResource(0x7f020009);
            }
            mp.c(mp1).setOnClickListener(new android.view.View.OnClickListener(bbyproduct, bbybasefragment, context, entities) {

                final BBYProduct a;
                final BBYBaseFragment b;
                final Context c;
                final Entities d;

                public void onClick(View view1)
                {
                    if (a.getPriceBlock().getButtonState().isCommerceUnavailable())
                    {
                        if ((b instanceof WishListWithProductsFragment) && b.isAdded())
                        {
                            ((WishListWithProductsFragment)b).c(((Activity)c).getString(0x7f08009f));
                        }
                        return;
                    }
                    view1 = ((WishListWithProductsFragment)b).e();
                    if (view1 != null)
                    {
                        view1.bringToFront();
                    }
                    String s = nk.a(d.getType());
                    (new in((Activity)c, b, view1, a.getSkuId(), d.getUuid(), d.getUuid(), s)).execute(new Void[0]);
                }

            
            {
                a = bbyproduct;
                b = bbybasefragment;
                c = context;
                d = entities;
                super();
            }
            });
        }
        if (entities.isFavorite() && flag)
        {
            mp1.a.setImageResource(0x7f0200c9);
            mp1.b.setText("Our Favorite");
            mp1.a.setTag("Our Favorite");
        } else
        if (entities.isFavorite() && !flag)
        {
            mp1.a.setImageResource(0x7f0200c9);
            mp1.b.setText("My Favorite");
            mp1.a.setTag("My Favorite");
        } else
        {
            mp1.a.setImageResource(0x7f0200cc);
            mp1.b.setText("Favorite this");
            mp1.a.setTag("Favorite this");
        }
        mp.d(mp1).setOnClickListener(new android.view.View.OnClickListener(view, mp1, flag, context, bbybasefragment, entities) {

            final View a;
            final mp b;
            final boolean c;
            final Context d;
            final BBYBaseFragment e;
            final Entities f;

            public void onClick(View view1)
            {
                RelativeLayout relativelayout = (RelativeLayout)a.getParent().getParent().getParent().getParent().getParent();
                view1 = null;
                if (relativelayout != null)
                {
                    view1 = (ProgressBar)relativelayout.findViewById(0x7f0c0230);
                }
                if (!b.a.getTag().equals("Favorite this")) goto _L2; else goto _L1
_L1:
                if (!c) goto _L4; else goto _L3
_L3:
                (new jv((Activity)d, e, f.getParentUuid(), f.getUuid(), f.getParentType(), true, view1, b)).executeOnExecutor(nb.g, new Void[0]);
_L6:
                return;
_L4:
                (new jv((Activity)d, e, f.getParentUuid(), f.getUuid(), f.getParentType(), true, view1, b)).executeOnExecutor(nb.g, new Void[0]);
                return;
_L2:
                if (b.a.getTag().equals("My Favorite"))
                {
                    (new jv((Activity)d, e, f.getParentUuid(), f.getUuid(), f.getParentType(), false, view1, b)).executeOnExecutor(nb.g, new Void[0]);
                    return;
                }
                if (b.a.getTag().equals("Our Favorite"))
                {
                    (new jv((Activity)d, e, f.getParentUuid(), f.getUuid(), f.getParentType(), false, view1, b)).executeOnExecutor(nb.g, new Void[0]);
                    return;
                }
                if (true) goto _L6; else goto _L5
_L5:
            }

            
            {
                a = view;
                b = mp1;
                c = flag;
                d = context;
                e = bbybasefragment;
                f = entities;
                super();
            }
        });
        mp.e(mp1).setVisibility(0);
        mp.e(mp1).setOnClickListener(new android.view.View.OnClickListener(bbybasefragment, bbyproduct) {

            final BBYBaseFragment a;
            final BBYProduct b;

            public void onClick(View view1)
            {
                if (a instanceof WishListWithProductsFragment)
                {
                    ((WishListWithProductsFragment)a).a(b.getSkuId());
                }
            }

            
            {
                a = bbybasefragment;
                b = bbyproduct;
                super();
            }
        });
    }

    static int b(mo mo1)
    {
        return mo1.a;
    }
}
