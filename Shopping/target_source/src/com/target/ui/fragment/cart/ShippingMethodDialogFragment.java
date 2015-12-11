// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cart;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import com.google.a.a.e;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.target.mothership.common.a.f;
import com.target.mothership.model.cart.interfaces.CartProduct;
import com.target.mothership.model.cart.interfaces.CartProductShippingModeDetails;
import com.target.mothership.model.cart.interfaces.UsableShipMode;
import com.target.mothership.model.cart.interfaces.UsableShippingModeDetails;
import com.target.mothership.model.cart.interfaces.a.k;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.services.o;
import com.target.ui.adapter.cart.CartShippingMethodAdapter;
import com.target.ui.service.a;
import com.target.ui.util.al;
import com.target.ui.util.q;
import com.target.ui.view.common.TargetErrorView;
import com.target.ui.view.common.c;
import java.util.Iterator;
import java.util.List;

public class ShippingMethodDialogFragment extends DialogFragment
    implements android.view.View.OnClickListener, com.target.ui.helper.b.c.a, c, TraceFieldInterface
{
    static class Views extends com.target.ui.view.a
    {

        Button applyButton;
        Button cancelButton;
        View cartShippingMethodsContent;
        TargetErrorView errorContainer;
        View progressContainer;
        ListView shippingMethodListView;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a(CartProduct cartproduct, UsableShipMode usableshipmode);

        public abstract void b(Guest guest);

        public abstract void h();
    }


    private static final String KEY_PRODUCT = "product";
    public static final String TAG = com/target/ui/fragment/cart/ShippingMethodDialogFragment.getSimpleName();
    private CartShippingMethodAdapter mAdapter;
    private CartProduct mCartProduct;
    private com.target.ui.helper.b.c mDataHelper;
    private boolean mIsSelectionMade;
    private a mListener;
    private Views mViews;

    public ShippingMethodDialogFragment()
    {
        mIsSelectionMade = false;
    }

    public static ShippingMethodDialogFragment a(CartProduct cartproduct)
    {
        ShippingMethodDialogFragment shippingmethoddialogfragment = new ShippingMethodDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("product", cartproduct);
        shippingmethoddialogfragment.setArguments(bundle);
        return shippingmethoddialogfragment;
    }

    private void a(List list)
    {
        if (mViews == null || !isAdded())
        {
            return;
        }
        for (list = list.iterator(); list.hasNext();)
        {
            UsableShippingModeDetails usableshippingmodedetails = (UsableShippingModeDetails)list.next();
            f f1 = usableshippingmodedetails.a();
            if (f1 == f.ShipToHome || f1 == f.Special)
            {
                mAdapter = new CartShippingMethodAdapter(getActivity(), usableshippingmodedetails.b(), mCartProduct);
                mViews.shippingMethodListView.setAdapter(mAdapter);
                a(false);
                al.a(mViews.shippingMethodListView, new View[] {
                    mViews.errorContainer
                });
                return;
            }
        }

        q.a(TAG, "We do not have eligible ship modes for STH and Special delivery");
        g();
    }

    private void a(boolean flag)
    {
        if (mViews == null)
        {
            return;
        }
        if (flag)
        {
            al.a(mViews.progressContainer, new View[] {
                mViews.cartShippingMethodsContent
            });
            return;
        } else
        {
            al.a(mViews.cartShippingMethodsContent, new View[] {
                mViews.progressContainer
            });
            return;
        }
    }

    private void b(Guest guest, o o)
    {
        if (guest.isAnonymous())
        {
            mDataHelper.a(guest, o, this);
            return;
        } else
        {
            mListener.b(guest);
            dismiss();
            return;
        }
    }

    private void d()
    {
        Guest guest = e();
        if (guest == null)
        {
            q.a(TAG, "Tried to get eligible shipping methods for a product, but the guest session was null");
            return;
        } else
        {
            a(true);
            mDataHelper.a(guest, mCartProduct, this);
            return;
        }
    }

    private Guest e()
    {
        return (Guest)com.target.ui.service.a.a().c().d();
    }

    private void g()
    {
        if (mViews == null || !isAdded())
        {
            return;
        } else
        {
            a(false);
            mViews.errorContainer.a("", getString(0x7f09012d), true);
            a(false);
            h();
            return;
        }
    }

    private void h()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            al.a(mViews.errorContainer, new View[] {
                mViews.cartShippingMethodsContent
            });
            return;
        }
    }

    private void i()
    {
        mIsSelectionMade = true;
        dismiss();
        com.target.mothership.common.a.b b1 = mAdapter.a().a();
        if (mCartProduct.c() != b1 && mListener != null)
        {
            mListener.a(mCartProduct, mAdapter.a());
        }
    }

    public void A_()
    {
        a(true);
        al.c(mViews.errorContainer);
        d();
    }

    public void a()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            a(false);
            mViews.errorContainer.a(com.target.ui.view.common.b.a.ERROR_NO_NETWORK, true);
            h();
            return;
        }
    }

    public void a(CartProductShippingModeDetails cartproductshippingmodedetails)
    {
        if (mViews == null)
        {
            return;
        }
        if (cartproductshippingmodedetails.a().isEmpty())
        {
            q.a(TAG, "CartProductShippingModeDetails doesn't have any usable ship modes");
            g();
            return;
        } else
        {
            a(cartproductshippingmodedetails.a());
            return;
        }
    }

    public void a(k k)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            g();
            return;
        }
    }

    public void a(Guest guest, o o)
    {
        if (mViews == null)
        {
            return;
        } else
        {
            b(guest, o);
            return;
        }
    }

    public void b()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            g();
            return;
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (getTargetFragment() instanceof a)
        {
            mListener = (a)getTargetFragment();
            return;
        } else
        {
            throw new IllegalStateException("Make sure to implement OnShippingMethodUpdatedListener");
        }
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131755861: 
            i();
            return;

        case 2131755862: 
            mIsSelectionMade = false;
            break;
        }
        dismiss();
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = getActivity();
        View view = getActivity().getLayoutInflater().inflate(0x7f03011f, null);
        mViews = new Views(view);
        mViews.errorContainer.setClickListener(this);
        mDataHelper = new com.target.ui.helper.b.c();
        mCartProduct = (CartProduct)getArguments().getParcelable("product");
        mViews.shippingMethodListView.setChoiceMode(1);
        mViews.applyButton.setOnClickListener(this);
        mViews.cancelButton.setOnClickListener(this);
        d();
        return (new android.app.AlertDialog.Builder(bundle)).setView(view).create();
    }

    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        super.onDismiss(dialoginterface);
        mDataHelper.a();
        if (!mIsSelectionMade && mListener != null)
        {
            mListener.h();
        }
    }

    protected void onStart()
    {
        super.onStart();
        ApplicationStateMonitor.getInstance().activityStarted();
    }

    protected void onStop()
    {
        super.onStop();
        ApplicationStateMonitor.getInstance().activityStopped();
    }

    public void q_()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            a(false);
            mViews.errorContainer.a("", getString(0x7f09027b), true);
            h();
            return;
        }
    }

}
