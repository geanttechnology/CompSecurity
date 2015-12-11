// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shipping;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.target.mothership.model.cart.interfaces.InitiatedCheckout;
import com.target.mothership.model.cart.interfaces.OrderReview;
import com.target.mothership.model.common.GuestAddress;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.services.o;
import com.target.ui.fragment.account.AuthenticateDialog;
import com.target.ui.fragment.checkout.CheckoutHomeFragment;
import com.target.ui.fragment.common.BaseNavigationFragment;
import com.target.ui.fragment.common.ErrorDialogFragment;
import com.target.ui.fragment.shipping.a.g;
import com.target.ui.fragment.shipping.b.a;
import com.target.ui.fragment.shop.ShopHomeFragment;
import com.target.ui.helper.c.e;
import com.target.ui.helper.c.i;
import com.target.ui.service.provider.d;
import com.target.ui.service.provider.f;
import com.target.ui.util.ai;
import com.target.ui.util.al;
import com.target.ui.view.account.AddressSetAsPrimaryView;
import com.target.ui.view.account.b;
import com.target.ui.view.checkout.AddressFormView;
import com.target.ui.view.common.TargetErrorView;
import com.target.ui.view.common.c;
import java.util.ArrayList;

// Referenced classes of package com.target.ui.fragment.shipping:
//            ShippingAddressDeleteDialog, ShippingAddressListFragment

public class ShippingAddressDetailsFragment extends BaseNavigationFragment
    implements android.view.View.OnClickListener, com.target.ui.fragment.account.BaseAccountDialog.a, com.target.ui.fragment.account.BaseAccountDialog.b, ShippingAddressDeleteDialog.a, com.target.ui.fragment.shipping.b.a, com.target.ui.view.account.AddressSetAsPrimaryView.a, b, com.target.ui.view.checkout.a, c
{
    static class Views extends com.target.ui.view.a
    {

        Button actionDoneButton;
        AddressFormView addressFormView;
        AddressSetAsPrimaryView addressSetAsPrimaryView;
        TargetErrorView errorView;
        ImageView shippingImageView;
        View specialDeliveryLegalCopy;

        Views(View view)
        {
            super(view);
        }
    }

    public final class a
        implements com.target.ui.view.checkout.AddressFormView.a
    {

        public String addressLine;
        public String apartment;
        public String city;
        public String firstName;
        boolean isValid;
        public String lastName;
        public String phoneNumber;
        public String state;
        final ShippingAddressDetailsFragment this$0;
        public String zipCode;

        public void a()
        {
            isValid = false;
        }

        public void a(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
                String s7)
        {
            firstName = s;
            lastName = s1;
            addressLine = s2;
            apartment = s3;
            city = s4;
            state = s6;
            zipCode = s5;
            phoneNumber = s7;
            isValid = true;
        }

        public a()
        {
            this$0 = ShippingAddressDetailsFragment.this;
            super();
        }
    }


    private static final String KEY_ADDRESS = "address";
    private static final String KEY_EDIT_MODE = "isEditMode";
    private static final String KEY_EXPRESS_ORDER_REVIEW = "expressOrderReview";
    private static final String KEY_NEEDS_ADDRESS_UPDATE = "needsShippingAddressUpdate";
    private static final String KEY_NEW_GUEST_ADDRESS = "newGuestAddress";
    private static final String KEY_PRODUCT_LIST = "productList";
    private static final String SHIPPING_INFO_MODE = "mode";
    private static final String TAG = com/target/ui/fragment/shipping/ShippingAddressDetailsFragment.getSimpleName();
    private com.target.ui.fragment.shipping.a.e mPresenter;
    private Views mViews;

    public ShippingAddressDetailsFragment()
    {
    }

    public static ShippingAddressDetailsFragment a(boolean flag, InitiatedCheckout initiatedcheckout, ArrayList arraylist, GuestAddress guestaddress, boolean flag1, GuestAddress guestaddress1, com.target.ui.fragment.shipping.a.e.a a1)
    {
        ShippingAddressDetailsFragment shippingaddressdetailsfragment = new ShippingAddressDetailsFragment();
        if (a1 == null || !(a1 instanceof Fragment))
        {
            throw new IllegalArgumentException("DeliveryActionListener must be an instance of Fragment");
        } else
        {
            shippingaddressdetailsfragment.setTargetFragment((Fragment)a1, 0);
            a1 = new Bundle();
            a1.putBoolean("isEditMode", flag);
            a1.putParcelable("expressOrderReview", initiatedcheckout);
            a1.putParcelableArrayList("productList", arraylist);
            a1.putParcelable("address", guestaddress);
            a1.putBoolean("needsShippingAddressUpdate", flag1);
            a1.putParcelable("newGuestAddress", guestaddress1);
            a1.putInt("mode", g.CHECKOUT.ordinal());
            shippingaddressdetailsfragment.setArguments(a1);
            return shippingaddressdetailsfragment;
        }
    }

    public static ShippingAddressDetailsFragment a(boolean flag, GuestAddress guestaddress, boolean flag1, GuestAddress guestaddress1, com.target.ui.fragment.shipping.a.e.a a1)
    {
        ShippingAddressDetailsFragment shippingaddressdetailsfragment = new ShippingAddressDetailsFragment();
        if (a1 == null || !(a1 instanceof Fragment))
        {
            throw new IllegalArgumentException("DeliveryActionListener must be an instance of Fragment");
        } else
        {
            shippingaddressdetailsfragment.setTargetFragment((Fragment)a1, 0);
            a1 = new Bundle();
            a1.putBoolean("isEditMode", flag);
            a1.putParcelable("address", guestaddress);
            a1.putBoolean("needsShippingAddressUpdate", flag1);
            a1.putParcelable("newGuestAddress", guestaddress1);
            a1.putInt("mode", g.ACCOUNT.ordinal());
            shippingaddressdetailsfragment.setArguments(a1);
            return shippingaddressdetailsfragment;
        }
    }

    private com.target.ui.fragment.shipping.a.e a(Bundle bundle)
    {
        boolean flag = bundle.getBoolean("isEditMode");
        OrderReview orderreview = (OrderReview)bundle.getParcelable("expressOrderReview");
        ArrayList arraylist = bundle.getParcelableArrayList("productList");
        GuestAddress guestaddress = (GuestAddress)bundle.getParcelable("address");
        boolean flag1 = bundle.getBoolean("needsShippingAddressUpdate");
        GuestAddress guestaddress1 = (GuestAddress)bundle.getParcelable("newGuestAddress");
        bundle = com.target.ui.fragment.shipping.a.g.values()[bundle.getInt("mode")];
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$fragment$shipping$presenter$ShippingInfoMode[];

            static 
            {
                $SwitchMap$com$target$ui$fragment$shipping$presenter$ShippingInfoMode = new int[com.target.ui.fragment.shipping.a.g.values().length];
                try
                {
                    $SwitchMap$com$target$ui$fragment$shipping$presenter$ShippingInfoMode[g.CHECKOUT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$fragment$shipping$presenter$ShippingInfoMode[g.ACCOUNT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.ui.fragment.shipping.presenter.ShippingInfoMode[bundle.ordinal()])
        {
        default:
            throw new IllegalStateException((new StringBuilder()).append("Invalid ShippingInfoMode: ").append(bundle).toString());

        case 1: // '\001'
            return new com.target.ui.fragment.shipping.a.c(new e(arraylist, orderreview), new f(), new i(orderreview, arraylist), guestaddress, guestaddress1, flag, flag1, new d());

        case 2: // '\002'
            return new com.target.ui.fragment.shipping.a.a(new com.target.ui.helper.c.a(), new f(), guestaddress, guestaddress1, flag, flag1, new d());
        }
    }

    private void q()
    {
        o(false);
        al.a(mViews.errorView, new View[] {
            mViews.addressFormView, mViews.actionDoneButton, mViews.specialDeliveryLegalCopy, mViews.shippingImageView
        });
    }

    public void A_()
    {
        mPresenter.e();
    }

    public void a()
    {
        mPresenter.l();
    }

    public void a(int i1)
    {
        o(false);
        if (Z())
        {
            return;
        } else
        {
            ErrorDialogFragment.a(getString(i1)).show(getFragmentManager(), ErrorDialogFragment.TAG);
            return;
        }
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
        j(getResources().getString(0x7f0901d6));
    }

    public void a(View view, boolean flag)
    {
        mPresenter.b(flag);
    }

    public void a(com.target.mothership.model.c.c.a a1)
    {
        mViews.addressFormView.setGeoCodeDetails(a1);
    }

    public void a(GuestAddress guestaddress)
    {
        mViews.addressFormView.a(guestaddress);
        al.b(new View[] {
            mViews.addressFormView, mViews.actionDoneButton, mViews.shippingImageView
        });
        al.c(mViews.errorView);
    }

    public void a(Guest guest)
    {
        mPresenter.a(guest);
    }

    public void a(Guest guest, o o1)
    {
        if (Z())
        {
            return;
        } else
        {
            guest = AuthenticateDialog.a(guest, this);
            guest.a(o1);
            guest.show(getFragmentManager(), AuthenticateDialog.TAG);
            return;
        }
    }

    public void a(String s)
    {
        k();
    }

    public void a(boolean flag)
    {
        mViews.actionDoneButton.setText(0x7f090283);
        mViews.actionDoneButton.setEnabled(flag);
    }

    public void a(boolean flag, boolean flag1)
    {
        if (flag)
        {
            mViews.addressSetAsPrimaryView.setVisibility(0);
            mViews.addressSetAsPrimaryView.a(flag1);
            return;
        } else
        {
            mViews.addressSetAsPrimaryView.setVisibility(8);
            return;
        }
    }

    public boolean a(com.target.ui.e.e e1)
    {
        ai.a(this, 0x7f090219);
        return true;
    }

    public void b()
    {
        if (Z())
        {
            return;
        } else
        {
            com.target.ui.fragment.shipping.ShippingAddressDeleteDialog.a(this).show(getFragmentManager(), ShippingAddressDeleteDialog.TAG);
            return;
        }
    }

    public void b(Menu menu, MenuInflater menuinflater)
    {
        menuinflater.inflate(0x7f120007, menu);
    }

    public void b(Object obj)
    {
        mPresenter.b(obj);
    }

    public void b(String s)
    {
        mPresenter.b(s);
    }

    public void c()
    {
        mPresenter.c();
    }

    public void c(Menu menu, MenuInflater menuinflater)
    {
        j(getResources().getString(0x7f0901bf));
    }

    public void c(String s)
    {
        mPresenter.c(s);
    }

    public void c(boolean flag)
    {
        mViews.actionDoneButton.setText(0x7f0901bf);
        mViews.actionDoneButton.setEnabled(flag);
    }

    public void d(boolean flag)
    {
        if (flag)
        {
            al.b(mViews.specialDeliveryLegalCopy);
            return;
        } else
        {
            al.c(mViews.specialDeliveryLegalCopy);
            return;
        }
    }

    public void e()
    {
        al.b(new View[] {
            mViews.addressFormView, mViews.actionDoneButton, mViews.shippingImageView
        });
        al.c(mViews.errorView);
    }

    public void e(boolean flag)
    {
        mViews.errorView.a(com.target.ui.view.common.b.a.ERROR_DEFAULT, true);
        q();
    }

    public void f(boolean flag)
    {
        o(flag);
    }

    public void g()
    {
        com.target.ui.f.c c1;
        if (!Z())
        {
            if ((c1 = m()) != null)
            {
                c1.a(ShippingAddressListFragment.TAG);
                return;
            }
        }
    }

    public void g(boolean flag)
    {
        mPresenter.a(flag);
    }

    public void h()
    {
        com.target.ui.f.c c1;
        if (!Z())
        {
            if ((c1 = m()) != null)
            {
                c1.a(CheckoutHomeFragment.TAG);
                return;
            }
        }
    }

    public void i()
    {
        mViews.errorView.a(com.target.ui.view.common.b.a.ERROR_NO_NETWORK, true);
        q();
    }

    public void j()
    {
        o(false);
        if (Z())
        {
            return;
        } else
        {
            ErrorDialogFragment.a(getString(0x7f090278)).show(getFragmentManager(), ErrorDialogFragment.TAG);
            return;
        }
    }

    public void k()
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

    public com.target.ui.fragment.account.BaseAccountDialog.c l()
    {
        return this;
    }

    public com.target.ui.fragment.account.BaseAccountDialog.e n()
    {
        return p();
    }

    public void n_()
    {
        mPresenter.n_();
    }

    public boolean o()
    {
        a a1 = new a();
        mViews.addressFormView.a(a1);
        return a1.isValid;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        com.target.ui.util.e.a.a(this);
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131755540: 
            view = new a();
            break;
        }
        mViews.addressFormView.a(view);
        mPresenter.e(view);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mPresenter = a(getArguments());
        bundle = getTargetFragment();
        if (bundle != null && (bundle instanceof com.target.ui.fragment.shipping.a.e.a))
        {
            bundle = (com.target.ui.fragment.shipping.a.e.a)bundle;
            mPresenter.a(bundle);
            return;
        } else
        {
            throw new IllegalStateException("Make sure to implement ShippingActionListener");
        }
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
        layoutinflater = layoutinflater.inflate(0x7f030082, viewgroup, false);
        mViews = new Views(layoutinflater);
        mViews.addressFormView.setInputValidationListener(this);
        mViews.addressFormView.setCheckoutAddressFormListener(this);
        mViews.addressSetAsPrimaryView.setAddressSetAsDefaultListener(this);
        mViews.errorView.setClickListener(this);
        mViews.actionDoneButton.setOnClickListener(this);
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
        mPresenter.z_();
        mViews = null;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        switch (menuitem.getItemId())
        {
        default:
            return super.onOptionsItemSelected(menuitem);

        case 2131756548: 
            mPresenter.k();
            break;
        }
        return true;
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        o(false);
    }

    public com.target.ui.fragment.account.BaseAccountDialog.a p()
    {
        return this;
    }

}
