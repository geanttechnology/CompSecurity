// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.h;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.google.a.a.e;
import com.target.mothership.model.common.OrderProductImage;
import com.target.mothership.model.guest.interfaces.AppliedPayPalDetails;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.guest.interfaces.OrderDetailsProduct;
import com.target.mothership.model.guest.interfaces.OrderSummary;
import com.target.mothership.model.product.interfaces.Product;
import com.target.mothership.model.store.interfaces.Store;
import com.target.mothership.services.o;
import com.target.ui.analytics.a.ap;
import com.target.ui.f.a;
import com.target.ui.fragment.account.b.b;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.fragment.product.pdp.ProductDetailsPageFragment;
import com.target.ui.fragment.shop.ShopHomeFragment;
import com.target.ui.service.k;
import com.target.ui.service.provider.d;
import com.target.ui.service.provider.f;
import com.target.ui.util.al;
import com.target.ui.util.j;
import com.target.ui.util.q;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.account.AccountOrderDetailsDeliveryView;
import com.target.ui.view.account.AccountOrderDetailsPaymentView;
import com.target.ui.view.account.AccountOrderDetailsProductListView;
import com.target.ui.view.common.TargetErrorView;
import com.target.ui.view.common.c;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.account:
//            AuthenticateDialog

public class AccountOrderDetailsFragment extends BaseNavigationFragment
    implements BaseAccountDialog.a, BaseAccountDialog.b, b, com.target.ui.view.account.AccountOrderDetailsProductDetailsView.a, c
{
    static class Views
    {

        TargetErrorView errorView;
        AccountOrderDetailsDeliveryView orderDetailsDeliveryView;
        AccountOrderDetailsPaymentView orderDetailsPaymentView;
        AccountOrderDetailsProductListView orderDetailsProductListView;
        View orderDetailsScrollContent;
        TextView orderPlacedDate;

        Views(View view)
        {
            ButterKnife.bind(this, view);
        }
    }


    private static final String ARG_ORDER_SUMMARY = "order_summary";
    public static final String TAG = com/target/ui/fragment/account/AccountOrderDetailsFragment.getSimpleName();
    private final int IMAGE_INDEX = 0;
    private com.target.ui.fragment.account.c.b mPresenter;
    private Views mViews;

    public AccountOrderDetailsFragment()
    {
    }

    public static AccountOrderDetailsFragment a(OrderSummary ordersummary)
    {
        AccountOrderDetailsFragment accountorderdetailsfragment = new AccountOrderDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("order_summary", ordersummary);
        accountorderdetailsfragment.setArguments(bundle);
        return accountorderdetailsfragment;
    }

    private void a(Product product, Store store)
    {
        m().d(ProductDetailsPageFragment.a(product, null, store));
    }

    private void a(BitmapImageView bitmapimageview, OrderDetailsProduct orderdetailsproduct)
    {
        if (bitmapimageview == null || orderdetailsproduct == null)
        {
            return;
        }
        Store store = q();
        if (com.target.ui.util.j.b())
        {
            int i1 = getResources().getDimensionPixelSize(0x7f0a00ac);
            Object obj;
            if (orderdetailsproduct.a() == null)
            {
                obj = null;
            } else
            {
                obj = (OrderProductImage)orderdetailsproduct.a().get(0);
            }
            if (obj != null)
            {
                obj = ((OrderProductImage) (obj)).a(i1);
            } else
            {
                obj = null;
            }
            a(bitmapimageview, ((Product) (orderdetailsproduct)), ((String) (obj)), store);
            return;
        } else
        {
            a(((Product) (orderdetailsproduct)), store);
            return;
        }
    }

    private final void a(BitmapImageView bitmapimageview, Product product, String s, Store store)
    {
        product = ProductDetailsPageFragment.a(product, null, store);
        store = product.a();
        bitmapimageview = new a(getActivity(), this, bitmapimageview, store);
        bitmapimageview.a(s);
        (new com.target.ui.f.b(m())).a(product, bitmapimageview);
    }

    private com.target.ui.fragment.account.c.b b(OrderSummary ordersummary)
    {
        return new com.target.ui.fragment.account.c.b(ordersummary, new com.target.ui.helper.a.a(), new f(), new d());
    }

    private OrderSummary j()
    {
        return (OrderSummary)getArguments().getParcelable("order_summary");
    }

    private void k()
    {
        mViews.errorView.setClickListener(this);
    }

    private void o()
    {
        mViews.errorView.setClickListener(null);
    }

    private void p()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            j(getString(0x7f0900a1));
            al.a(mViews.errorView, new View[] {
                mViews.orderDetailsScrollContent
            });
            return;
        }
    }

    private Store q()
    {
        Store store = null;
        if (com.target.ui.service.k.a().c().b())
        {
            store = (Store)com.target.ui.service.k.a().c().c();
        }
        return store;
    }

    public void A_()
    {
        mPresenter.g();
    }

    public void a()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            al.a(mViews.orderDetailsScrollContent, new View[] {
                mViews.errorView
            });
            return;
        }
    }

    public void a(int i1)
    {
        j(getResources().getString(i1));
    }

    public void a(Menu menu, MenuInflater menuinflater, int i1)
    {
        menuinflater.inflate(i1, menu);
    }

    public void a(AppliedPayPalDetails appliedpaypaldetails, String s)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.orderDetailsPaymentView.a(appliedpaypaldetails, s);
            return;
        }
    }

    public void a(Guest guest)
    {
        mPresenter.a(guest);
    }

    public void a(Guest guest, o o1)
    {
        if (mViews != null)
        {
            if (guest == null)
            {
                com.target.ui.util.q.d(TAG, "Guest session is null");
                return;
            }
            if (!Z())
            {
                guest = com.target.ui.fragment.account.AuthenticateDialog.a(guest, this);
                guest.a(o1);
                guest.show(getFragmentManager(), AuthenticateDialog.TAG);
                return;
            }
        }
    }

    public void a(OrderDetailsProduct orderdetailsproduct, BitmapImageView bitmapimageview)
    {
        mPresenter.a(orderdetailsproduct, bitmapimageview);
    }

    public void a(String s)
    {
        mPresenter.b(s);
    }

    public void a(List list)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.orderDetailsProductListView.a(list, this);
            return;
        }
    }

    public void a(List list, String s)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.orderDetailsPaymentView.a(list, s);
            return;
        }
    }

    public void a(boolean flag)
    {
        o(flag);
    }

    public boolean a(com.target.ui.e.e e1)
    {
        mPresenter.f();
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
        if (mViews == null)
        {
            return;
        } else
        {
            al.c(mViews.errorView);
            return;
        }
    }

    public void b(int i1)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            String s = getString(i1);
            mViews.errorView.a("", s, true);
            p();
            return;
        }
    }

    public void b(OrderDetailsProduct orderdetailsproduct, BitmapImageView bitmapimageview)
    {
        if (Z())
        {
            return;
        } else
        {
            a(bitmapimageview, orderdetailsproduct);
            return;
        }
    }

    public void b(Object obj)
    {
        mPresenter.b(obj);
    }

    public void b(String s)
    {
        mPresenter.a(s);
    }

    public void c()
    {
        mPresenter.d();
    }

    public void c(String s)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            j(getString(0x7f0900a5, new Object[] {
                s
            }));
            return;
        }
    }

    public void d(String s)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.orderDetailsDeliveryView.a(s);
            return;
        }
    }

    public void e()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            String s = getString(0x7f0900a0);
            mViews.errorView.a("", s, true);
            p();
            return;
        }
    }

    public void e(String s)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.orderDetailsDeliveryView.b(s);
            return;
        }
    }

    public void f(String s)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.orderDetailsDeliveryView.c(s);
            return;
        }
    }

    public void g()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.errorView.a(com.target.ui.view.common.b.a.ERROR_NO_NETWORK, true);
            p();
            return;
        }
    }

    public void g(String s)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.orderDetailsDeliveryView.d(s);
            return;
        }
    }

    public BaseAccountDialog.a h()
    {
        return this;
    }

    public void h(String s)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            mViews.orderPlacedDate.setText(getString(0x7f0900a2, new Object[] {
                s
            }));
            return;
        }
    }

    public void i()
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

    public BaseAccountDialog.c l()
    {
        return this;
    }

    public BaseAccountDialog.e n()
    {
        return h();
    }

    public void n_()
    {
        mPresenter.e();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mPresenter = b(j());
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            mPresenter.a(menu, menuinflater);
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030046, viewgroup, false);
        mViews = new Views(layoutinflater);
        k();
        mPresenter.a(this);
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        mPresenter.v_();
        mPresenter = null;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        o();
        mPresenter.z_();
        mViews = null;
    }

    public void onResume()
    {
        super.onResume();
        ap.j().e();
    }

}
