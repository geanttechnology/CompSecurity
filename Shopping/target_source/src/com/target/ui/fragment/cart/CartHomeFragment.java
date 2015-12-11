// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cart;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.HeaderViewListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.a.a.e;
import com.target.mothership.common.a.f;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.cart.interfaces.AppliedTenders;
import com.target.mothership.model.cart.interfaces.CartDetails;
import com.target.mothership.model.cart.interfaces.CartProduct;
import com.target.mothership.model.cart.interfaces.CartRegistryDetails;
import com.target.mothership.model.cart.interfaces.ExpressOrderReview;
import com.target.mothership.model.cart.interfaces.FreeShippingPromotion;
import com.target.mothership.model.cart.interfaces.GiftProduct;
import com.target.mothership.model.cart.interfaces.UsableShipMode;
import com.target.mothership.model.cart.interfaces.a.w;
import com.target.mothership.model.cart.interfaces.a.y;
import com.target.mothership.model.common.OrderProductImage;
import com.target.mothership.model.common.StorePickUpDetails;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.product.interfaces.Product;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.product.interfaces.ProductImage;
import com.target.mothership.model.product.interfaces.ProductRecommendations;
import com.target.mothership.model.store.interfaces.RelevantStoreSummary;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.services.o;
import com.target.ui.adapter.cart.CartProductAdapter;
import com.target.ui.adapter.product.ProductGridItemAdapter;
import com.target.ui.analytics.a.an;
import com.target.ui.c.d.d;
import com.target.ui.f.b;
import com.target.ui.fragment.account.AuthenticateDialog;
import com.target.ui.fragment.cart.a.a;
import com.target.ui.fragment.checkout.CheckoutHomeFragment;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.fragment.product.pdp.ProductDetailsPageFragment;
import com.target.ui.fragment.registry.RegistryDetailPageFragment;
import com.target.ui.fragment.shop.ShopHomeFragment;
import com.target.ui.fragment.store.StoreDetailFragment;
import com.target.ui.service.k;
import com.target.ui.util.ae;
import com.target.ui.util.al;
import com.target.ui.util.j;
import com.target.ui.util.q;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.cart.CartHeaderView;
import com.target.ui.view.cart.CartProductListView;
import com.target.ui.view.common.TargetErrorView;
import com.target.ui.view.common.c;
import com.target.ui.view.common.h;
import com.target.ui.view.product.PdpRecommendationsView;
import java.net.URL;

// Referenced classes of package com.target.ui.fragment.cart:
//            CartErrorDialogFragment, ShippingMethodDialogFragment, StorePickupDialogFragment, SaveForLaterFragment

public class CartHomeFragment extends BaseNavigationFragment
    implements android.view.View.OnClickListener, com.target.ui.adapter.cart.CartProductAdapter.a, com.target.ui.fragment.account.BaseAccountDialog.a, com.target.ui.fragment.account.BaseAccountDialog.b, ShippingMethodDialogFragment.a, StorePickupDialogFragment.a, com.target.ui.fragment.cart.a.a, c, com.target.ui.view.product.PdpRecommendationsView.a
{
    static class Views extends com.target.ui.view.a
    {

        Button checkoutButton;
        LinearLayout emptyCartContainer;
        TextView emptyCartMessage;
        LinearLayout emptyCartReauthView;
        TargetErrorView errorView;
        CartHeaderView headerView;
        CartProductListView listView;
        PdpRecommendationsView notEmptyRecommendationsView;
        GridView productRecommendationsView;
        View reauthView;

        Views(View view)
        {
            super(view);
            headerView = (CartHeaderView)LayoutInflater.from(view.getContext()).inflate(0x7f03010d, null);
            notEmptyRecommendationsView = (PdpRecommendationsView)LayoutInflater.from(view.getContext()).inflate(0x7f03011a, null);
        }
    }

    private class a
        implements android.widget.AdapterView.OnItemClickListener
    {

        final CartHomeFragment this$0;

        public void onItemClick(AdapterView adapterview, View view, int i1, long l1)
        {
            adapterview = (ProductDetails)adapterview.getItemAtPosition(i1);
            view = (BitmapImageView)view.findViewById(0x7f1004ed);
            com.target.ui.fragment.cart.CartHomeFragment.a(CartHomeFragment.this, view, adapterview);
        }

        private a()
        {
            this$0 = CartHomeFragment.this;
            super();
        }

    }


    public static final String TAG = com/target/ui/fragment/cart/CartHomeFragment.getSimpleName();
    private CartProductAdapter mAdapter;
    private com.target.ui.fragment.cart.b.a mCartDetailsPresenter;
    private com.target.ui.c.d.a mNavigateToPdpDelegate;
    private ProductGridItemAdapter mRecommendationsAdapter;
    private h mSnackBar;
    private Views mViews;

    public CartHomeFragment()
    {
        mNavigateToPdpDelegate = new com.target.ui.c.d.a(this);
    }

    private void A()
    {
        o(false);
        j(getString(0x7f09013e));
        al.a(mViews.errorView, new View[] {
            mViews.emptyCartContainer, mViews.listView, mViews.checkoutButton
        });
    }

    private Store B()
    {
        Store store = null;
        if (com.target.ui.service.k.a().c().b())
        {
            store = (Store)com.target.ui.service.k.a().c().c();
        }
        return store;
    }

    public static CartHomeFragment a()
    {
        return new CartHomeFragment();
    }

    private void a(Product product, Store store)
    {
        m().d(ProductDetailsPageFragment.a(product, null, store));
    }

    static void a(CartHomeFragment carthomefragment, BitmapImageView bitmapimageview, ProductDetails productdetails)
    {
        carthomefragment.b(bitmapimageview, productdetails);
    }

    private final void a(BitmapImageView bitmapimageview, Product product, String s1, Store store)
    {
        product = ProductDetailsPageFragment.a(product, null, store);
        store = product.a();
        bitmapimageview = new com.target.ui.f.a(getActivity(), this, bitmapimageview, store);
        bitmapimageview.a(s1);
        (new b(m())).a(product, bitmapimageview);
    }

    private void b(BitmapImageView bitmapimageview, CartProduct cartproduct)
    {
        if (bitmapimageview == null || cartproduct == null)
        {
            return;
        }
        Store store = h(cartproduct);
        if (com.target.ui.util.j.b())
        {
            int i1 = getResources().getDimensionPixelSize(0x7f0a00de);
            a(bitmapimageview, cartproduct, cartproduct.b().a(i1), store);
            return;
        } else
        {
            a(cartproduct, store);
            return;
        }
    }

    private void b(BitmapImageView bitmapimageview, ProductDetails productdetails)
    {
        if (bitmapimageview == null || productdetails == null)
        {
            return;
        }
        Store store = B();
        if (com.target.ui.util.j.b())
        {
            String s1 = null;
            if (productdetails.r().b())
            {
                s1 = ((ProductImage)productdetails.r().c()).a().toString();
            }
            a(bitmapimageview, productdetails, s1, store);
            return;
        } else
        {
            a(productdetails, store);
            return;
        }
    }

    private void c(CartDetails cartdetails, FreeShippingPromotion freeshippingpromotion)
    {
        if (mViews.listView.getAdapter() == null)
        {
            mViews.listView.setAdapter(mAdapter);
        }
        if (mViews.listView.getAdapter() instanceof HeaderViewListAdapter)
        {
            ((CartProductAdapter)((HeaderViewListAdapter)mViews.listView.getAdapter()).getWrappedAdapter()).a(cartdetails, freeshippingpromotion);
            return;
        } else
        {
            ((CartProductAdapter)mViews.listView.getAdapter()).a(cartdetails, freeshippingpromotion);
            return;
        }
    }

    private void d(int i1)
    {
        o(false);
        if (Z())
        {
            return;
        } else
        {
            com.target.ui.fragment.cart.CartErrorDialogFragment.a(getString(i1)).show(getFragmentManager(), CartErrorDialogFragment.TAG);
            return;
        }
    }

    private Store h(CartProduct cartproduct)
    {
        if (cartproduct.d() == f.StorePickup && cartproduct.k().b())
        {
            cartproduct = ((StorePickUpDetails)cartproduct.k().c()).a().a();
            if (cartproduct != null)
            {
                return ae.a(cartproduct);
            }
        }
        return B();
    }

    private void z()
    {
        mViews.checkoutButton.setOnClickListener(this);
        mViews.reauthView.setOnClickListener(this);
        mViews.errorView.setClickListener(this);
    }

    public void A_()
    {
        mCartDetailsPresenter.g();
    }

    public void a(int i1)
    {
        mSnackBar.c(getString(i1));
    }

    public void a(int i1, String s1)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            StringBuilder stringbuilder = new StringBuilder(getString(0x7f09013e));
            stringbuilder.append("(");
            stringbuilder.append(Integer.toString(i1));
            stringbuilder.append(")");
            stringbuilder.append(" - ");
            stringbuilder.append("$");
            stringbuilder.append(s1);
            j(stringbuilder.toString());
            return;
        }
    }

    public void a(CartDetails cartdetails, FreeShippingPromotion freeshippingpromotion)
    {
        c(cartdetails, freeshippingpromotion);
    }

    public void a(CartProduct cartproduct)
    {
        mCartDetailsPresenter.a(cartproduct);
    }

    public void a(CartProduct cartproduct, int i1)
    {
        mCartDetailsPresenter.a(cartproduct, i1);
    }

    public void a(CartProduct cartproduct, UsableShipMode usableshipmode)
    {
        mCartDetailsPresenter.a(cartproduct, usableshipmode);
    }

    public void a(CartProduct cartproduct, com.target.ui.model.a a1, f f1)
    {
        mCartDetailsPresenter.a(cartproduct, a1, f1);
    }

    public void a(ExpressOrderReview expressorderreview, AppliedTenders appliedtenders)
    {
        a(false);
        if (Z())
        {
            return;
        } else
        {
            expressorderreview = CheckoutHomeFragment.a(expressorderreview, appliedtenders, 0);
            m().d(expressorderreview);
            return;
        }
    }

    public void a(GiftProduct giftproduct)
    {
        mCartDetailsPresenter.a(giftproduct);
    }

    public void a(w w1)
    {
        if (Z())
        {
            return;
        } else
        {
            com.target.ui.fragment.cart.CartErrorDialogFragment.a(getActivity(), w1).show(getFragmentManager(), CartErrorDialogFragment.TAG);
            return;
        }
    }

    public void a(y y1)
    {
        if (Z())
        {
            return;
        } else
        {
            com.target.ui.fragment.cart.CartErrorDialogFragment.a(getActivity(), y1).show(getFragmentManager(), CartErrorDialogFragment.TAG);
            return;
        }
    }

    public void a(Guest guest)
    {
        mCartDetailsPresenter.a(guest);
    }

    public void a(Guest guest, o o1)
    {
        if (guest == null)
        {
            com.target.ui.util.q.d(TAG, "Guest session is null");
        } else
        if (!Z())
        {
            guest = AuthenticateDialog.a(guest, this);
            guest.a(o1);
            guest.show(getFragmentManager(), AuthenticateDialog.TAG);
            return;
        }
    }

    public void a(ProductRecommendations productrecommendations)
    {
        mRecommendationsAdapter = ProductGridItemAdapter.a(getActivity(), productrecommendations.a());
        mViews.productRecommendationsView.setAdapter(mRecommendationsAdapter);
        mViews.productRecommendationsView.setOnItemClickListener(new a());
        al.b(mViews.productRecommendationsView);
    }

    public void a(com.target.ui.model.a a1)
    {
        m().d(StoreDetailFragment.a(a1.a().getStoreId()));
    }

    public void a(BitmapImageView bitmapimageview, CartProduct cartproduct)
    {
        b(bitmapimageview, cartproduct);
    }

    public void a(BitmapImageView bitmapimageview, ProductDetails productdetails)
    {
        productdetails = new d(productdetails);
        productdetails.a(bitmapimageview);
        productdetails.a(B());
        mNavigateToPdpDelegate.a(productdetails);
    }

    public void a(String s1)
    {
        mCartDetailsPresenter.b(s1);
    }

    public void a(boolean flag)
    {
        o(flag);
    }

    public boolean a(com.target.ui.e.e e1)
    {
        mCartDetailsPresenter.e();
        e1.c(false);
        if (Z())
        {
            return true;
        } else
        {
            getFragmentManager().c();
            return true;
        }
    }

    public void b()
    {
        mViews.notEmptyRecommendationsView.setHeader(getString(0x7f090114));
        mViews.notEmptyRecommendationsView.setClickListener(this);
    }

    public void b(int i1)
    {
        mViews.errorView.a("", getString(i1), true);
        A();
    }

    public void b(CartDetails cartdetails, FreeShippingPromotion freeshippingpromotion)
    {
        mViews.listView.a(mViews.headerView, cartdetails, freeshippingpromotion);
    }

    public void b(CartProduct cartproduct)
    {
        mCartDetailsPresenter.b(cartproduct);
    }

    public void b(Guest guest)
    {
        a(guest, ((o) (null)));
    }

    public void b(ProductRecommendations productrecommendations)
    {
        mViews.notEmptyRecommendationsView.setRecommendations(productrecommendations);
        al.b(mViews.notEmptyRecommendationsView);
    }

    public void b(Object obj)
    {
        mCartDetailsPresenter.b(obj);
    }

    public void b(String s1)
    {
        mCartDetailsPresenter.a(s1);
    }

    public void c()
    {
        mCartDetailsPresenter.c();
    }

    public void c(int i1)
    {
        d(i1);
    }

    public void c(CartProduct cartproduct)
    {
        mCartDetailsPresenter.c(cartproduct);
    }

    public void d(CartProduct cartproduct)
    {
        cartproduct = com.target.ui.fragment.cart.ShippingMethodDialogFragment.a(cartproduct);
        cartproduct.setTargetFragment(this, 0);
        cartproduct.show(getFragmentManager(), ShippingMethodDialogFragment.TAG);
    }

    public void e()
    {
        mViews.listView.a(mViews.notEmptyRecommendationsView);
        mViews.listView.a();
    }

    public void e(CartProduct cartproduct)
    {
        cartproduct = com.target.ui.fragment.cart.StorePickupDialogFragment.a(cartproduct);
        cartproduct.setTargetFragment(this, 0);
        cartproduct.show(getFragmentManager(), StorePickupDialogFragment.TAG);
    }

    public void f(CartProduct cartproduct)
    {
        mCartDetailsPresenter.d(cartproduct);
    }

    public void g()
    {
        mViews.listView.a();
    }

    public void g(CartProduct cartproduct)
    {
        CartRegistryDetails cartregistrydetails;
        if (!Z())
        {
            if ((cartregistrydetails = (CartRegistryDetails)cartproduct.l().d()) != null && cartregistrydetails.a() != null)
            {
                cartproduct = h(cartproduct);
                cartproduct = RegistryDetailPageFragment.a(cartregistrydetails.a(), cartproduct);
                m().d(cartproduct);
                return;
            }
        }
    }

    public void h()
    {
        mAdapter.notifyDataSetChanged();
    }

    public void i()
    {
        mAdapter.notifyDataSetChanged();
    }

    public com.target.ui.fragment.account.BaseAccountDialog.a j()
    {
        return this;
    }

    public void k()
    {
        if (mAdapter != null)
        {
            mAdapter.notifyDataSetChanged();
        }
    }

    public com.target.ui.fragment.account.BaseAccountDialog.c l()
    {
        return this;
    }

    public com.target.ui.fragment.account.BaseAccountDialog.e n()
    {
        return j();
    }

    public void n_()
    {
        mCartDetailsPresenter.d();
    }

    public void o()
    {
        al.b(new View[] {
            mViews.listView, mViews.checkoutButton
        });
        al.a(new View[] {
            mViews.emptyCartContainer, mViews.errorView
        });
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        a(mNavigateToPdpDelegate);
    }

    public void onClick(View view)
    {
        if (view != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        switch (view.getId())
        {
        default:
            return;

        case 2131755319: 
            if (mAdapter != null)
            {
                mCartDetailsPresenter.a(mAdapter.a());
                return;
            }
            break;

        case 2131755789: 
            view = (Guest)com.target.ui.service.a.a().c().d();
            if (view == null)
            {
                com.target.ui.util.q.d(TAG, "Guest session is null");
                return;
            } else
            {
                a(view, ((o) (null)));
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mSnackBar = new h(getActivity());
        mCartDetailsPresenter = new com.target.ui.fragment.cart.b.a(new com.target.ui.helper.b.a(), new com.target.ui.service.provider.f(), com.target.ui.j.a.b(), new com.target.ui.helper.b.b(), new com.target.ui.service.provider.d());
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            j(getResources().getString(0x7f0900f1));
            menuinflater.inflate(0x7f120003, menu);
            super.onCreateOptionsMenu(menu, menuinflater);
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03004a, viewgroup, false);
        mViews = new Views(layoutinflater);
        z();
        mAdapter = new CartProductAdapter(getActivity(), this);
        mCartDetailsPresenter.a(this);
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        mSnackBar = null;
        mCartDetailsPresenter.v_();
        mCartDetailsPresenter = null;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        mCartDetailsPresenter.z_();
        mAdapter = null;
        mViews = null;
    }

    public void onDetach()
    {
        super.onDetach();
        mNavigateToPdpDelegate = null;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131756544: 
            m().d(com.target.ui.fragment.cart.SaveForLaterFragment.a());
            break;
        }
        return true;
    }

    public void onPause()
    {
        super.onPause();
        mSnackBar.a();
    }

    public void p()
    {
        al.c(mViews.productRecommendationsView);
    }

    public void q()
    {
        mViews.listView.removeFooterView(mViews.notEmptyRecommendationsView);
        mAdapter.notifyDataSetChanged();
    }

    public void r()
    {
        j(getString(0x7f09013e));
        al.a(mViews.emptyCartContainer, new View[] {
            mViews.listView, mViews.checkoutButton, mViews.errorView
        });
        mViews.emptyCartMessage.setText(getString(0x7f090100));
        al.a(mViews.productRecommendationsView, new View[] {
            mViews.emptyCartReauthView
        });
    }

    public void s()
    {
        al.c(mViews.errorView);
    }

    public void t()
    {
        mViews.errorView.a(com.target.ui.view.common.b.a.ERROR_NO_NETWORK, true);
        A();
    }

    public void u()
    {
        an.a(3).e();
    }

    public void v()
    {
        d(0x7f090278);
    }

    public void w()
    {
        if (Z())
        {
            return;
        } else
        {
            com.target.ui.fragment.cart.CartErrorDialogFragment.a(getString(0x7f09010e)).show(getFragmentManager(), CartErrorDialogFragment.TAG);
            return;
        }
    }

    public void x()
    {
        j(getString(0x7f09013e));
        al.a(mViews.emptyCartContainer, new View[] {
            mViews.listView, mViews.checkoutButton, mViews.errorView
        });
        mViews.emptyCartMessage.setText(getString(0x7f090101));
        al.a(mViews.emptyCartReauthView, new View[] {
            mViews.productRecommendationsView
        });
    }

    public void y()
    {
        if (Z())
        {
            return;
        } else
        {
            ShopHomeFragment shophomefragment = ShopHomeFragment.a();
            m().a(shophomefragment);
            return;
        }
    }

}
