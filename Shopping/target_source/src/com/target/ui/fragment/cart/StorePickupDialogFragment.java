// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.cart;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.f;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.background.ApplicationStateMonitor;
import com.target.mothership.model.cart.interfaces.CartProduct;
import com.target.mothership.services.x;
import com.target.mothership.util.b;
import com.target.mothership.util.o;
import com.target.ui.adapter.cart.CartPickupStoreAdapter;
import com.target.ui.model.a;
import com.target.ui.service.k;
import com.target.ui.util.al;
import com.target.ui.view.ZipCodeChooserView;
import com.target.ui.view.common.TargetErrorView;
import com.target.ui.view.common.c;
import java.util.List;

public class StorePickupDialogFragment extends DialogFragment
    implements com.target.ui.adapter.cart.CartPickupStoreAdapter.a, com.target.ui.view.ZipCodeChooserView.d, c, TraceFieldInterface
{
    public static interface a
    {

        public abstract void a(CartProduct cartproduct, com.target.ui.model.a a1, com.target.mothership.common.a.f f1);

        public abstract void a(com.target.ui.model.a a1);

        public abstract void i();
    }

    private static class b
    {

        private TargetErrorView errorContainer;
        private ListView listView;
        private View noStoresContainer;
        private View progressContainer;
        private ZipCodeChooserView zipCodeChooserView;

        static ZipCodeChooserView a(b b1)
        {
            return b1.zipCodeChooserView;
        }

        static TargetErrorView b(b b1)
        {
            return b1.errorContainer;
        }

        static View c(b b1)
        {
            return b1.noStoresContainer;
        }

        static View d(b b1)
        {
            return b1.progressContainer;
        }

        static ListView e(b b1)
        {
            return b1.listView;
        }

        public b(View view)
        {
            progressContainer = view.findViewById(0x7f1001fa);
            noStoresContainer = view.findViewById(0x7f10031e);
            errorContainer = (TargetErrorView)view.findViewById(0x7f10031f);
            listView = (ListView)view.findViewById(0x7f100320);
            zipCodeChooserView = (ZipCodeChooserView)view.findViewById(0x7f100321);
        }
    }


    private static final String KEY_PRODUCT = "product";
    public static final String TAG = com/target/ui/fragment/cart/StorePickupDialogFragment.getSimpleName();
    private CartPickupStoreAdapter mAdapter;
    private CartProduct mCartProduct;
    private String mEnteredZipCode;
    private boolean mIsDialogOptionSelected;
    private a mListener;
    private b mViews;

    public StorePickupDialogFragment()
    {
        mIsDialogOptionSelected = false;
    }

    static b a(StorePickupDialogFragment storepickupdialogfragment)
    {
        return storepickupdialogfragment.mViews;
    }

    public static StorePickupDialogFragment a(CartProduct cartproduct)
    {
        StorePickupDialogFragment storepickupdialogfragment = new StorePickupDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("product", cartproduct);
        storepickupdialogfragment.setArguments(bundle);
        return storepickupdialogfragment;
    }

    static void a(StorePickupDialogFragment storepickupdialogfragment, List list, boolean flag)
    {
        storepickupdialogfragment.a(list, flag);
    }

    static void a(StorePickupDialogFragment storepickupdialogfragment, boolean flag)
    {
        storepickupdialogfragment.a(flag);
    }

    private void a(List list, boolean flag)
    {
        b(false);
        if (list != null && !list.isEmpty())
        {
            mAdapter = new CartPickupStoreAdapter(getActivity(), list, mCartProduct, this);
            b.e(mViews).setAdapter(mAdapter);
            return;
        } else
        {
            a(flag);
            return;
        }
    }

    private void a(boolean flag)
    {
        if (flag)
        {
            com.target.ui.fragment.cart.b.b(mViews).a("", getString(0x7f090439), false);
            al.a(com.target.ui.fragment.cart.b.b(mViews), new View[] {
                com.target.ui.fragment.cart.b.c(mViews), b.d(mViews), b.e(mViews)
            });
            return;
        } else
        {
            al.a(com.target.ui.fragment.cart.b.c(mViews), new View[] {
                com.target.ui.fragment.cart.b.b(mViews), b.d(mViews), b.e(mViews)
            });
            return;
        }
    }

    private void b()
    {
        if (!com.target.mothership.util.b.a().b())
        {
            c();
            return;
        } else
        {
            b(true);
            k.a().a(mCartProduct, mCartProduct.j_(), new com.target.ui.service.k.b() {

                final StorePickupDialogFragment this$0;

                public void a(com.target.ui.service.k.a a1, x x)
                {
                    if (com.target.ui.fragment.cart.StorePickupDialogFragment.a(StorePickupDialogFragment.this) == null)
                    {
                        return;
                    } else
                    {
                        com.target.ui.fragment.cart.StorePickupDialogFragment.a(StorePickupDialogFragment.this, false);
                        return;
                    }
                }

                public void a(List list)
                {
                    if (com.target.ui.fragment.cart.StorePickupDialogFragment.a(StorePickupDialogFragment.this) == null)
                    {
                        return;
                    } else
                    {
                        com.target.ui.fragment.cart.StorePickupDialogFragment.a(StorePickupDialogFragment.this, list, false);
                        return;
                    }
                }

                public void onResult(Object obj)
                {
                    a((List)obj);
                }

            
            {
                this$0 = StorePickupDialogFragment.this;
                super();
            }
            });
            return;
        }
    }

    private void b(String s)
    {
        if (!com.target.mothership.util.b.a().b())
        {
            c();
            return;
        } else
        {
            b(true);
            k.a().a(mCartProduct, mCartProduct.j_(), s, new com.target.ui.service.k.b() {

                final StorePickupDialogFragment this$0;

                public void a(com.target.ui.service.k.a a1, x x)
                {
                    if (com.target.ui.fragment.cart.StorePickupDialogFragment.a(StorePickupDialogFragment.this) == null)
                    {
                        return;
                    } else
                    {
                        com.target.ui.fragment.cart.StorePickupDialogFragment.a(StorePickupDialogFragment.this, true);
                        return;
                    }
                }

                public void a(List list)
                {
                    if (com.target.ui.fragment.cart.StorePickupDialogFragment.a(StorePickupDialogFragment.this) == null)
                    {
                        return;
                    } else
                    {
                        com.target.ui.fragment.cart.StorePickupDialogFragment.a(StorePickupDialogFragment.this, list, true);
                        return;
                    }
                }

                public void onResult(Object obj)
                {
                    a((List)obj);
                }

            
            {
                this$0 = StorePickupDialogFragment.this;
                super();
            }
            });
            return;
        }
    }

    private void b(boolean flag)
    {
        if (flag)
        {
            al.a(b.d(mViews), new View[] {
                com.target.ui.fragment.cart.b.c(mViews), com.target.ui.fragment.cart.b.b(mViews)
            });
            return;
        } else
        {
            al.a(b.e(mViews), new View[] {
                b.d(mViews), com.target.ui.fragment.cart.b.c(mViews), com.target.ui.fragment.cart.b.b(mViews)
            });
            return;
        }
    }

    private void c()
    {
        if (mViews == null)
        {
            return;
        } else
        {
            com.target.ui.fragment.cart.b.b(mViews).a(com.target.ui.view.common.b.a.ERROR_NO_NETWORK, true);
            al.a(com.target.ui.fragment.cart.b.b(mViews), new View[] {
                com.target.ui.fragment.cart.b.c(mViews), b.d(mViews), b.e(mViews)
            });
            return;
        }
    }

    public void A_()
    {
        if (!com.target.mothership.util.b.a().b())
        {
            c();
            return;
        }
        al.c(com.target.ui.fragment.cart.b.b(mViews));
        if (o.g(mEnteredZipCode))
        {
            b(mEnteredZipCode);
            return;
        } else
        {
            b();
            return;
        }
    }

    public void a()
    {
        mIsDialogOptionSelected = true;
        dismiss();
        if (mListener != null)
        {
            mListener.i();
        }
    }

    public void a(CartProduct cartproduct, com.target.ui.model.a a1, com.target.mothership.common.a.f f1)
    {
        mIsDialogOptionSelected = true;
        dismiss();
        if (mListener != null)
        {
            mListener.a(cartproduct, a1, f1);
        }
    }

    public void a(com.target.ui.model.a a1)
    {
        mIsDialogOptionSelected = true;
        dismiss();
        if (mListener != null)
        {
            mListener.a(a1);
        }
    }

    public void a(String s)
    {
        mEnteredZipCode = s;
        b(s);
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
            throw new IllegalStateException("Make sure to implement OnPickupStoreUpdateListener");
        }
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = getActivity();
        View view = getActivity().getLayoutInflater().inflate(0x7f030112, null);
        mViews = new b(view);
        mCartProduct = (CartProduct)getArguments().getParcelable("product");
        com.target.ui.fragment.cart.b.a(mViews).setZipCodeListener(this);
        com.target.ui.fragment.cart.b.b(mViews).setClickListener(this);
        b();
        return (new android.app.AlertDialog.Builder(bundle)).setView(view).create();
    }

    public void onDetach()
    {
        super.onDetach();
        mListener = null;
        mViews = null;
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        super.onDismiss(dialoginterface);
        if (!mIsDialogOptionSelected && mListener != null)
        {
            mListener.i();
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

}
