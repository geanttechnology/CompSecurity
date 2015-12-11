// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.store;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.model.store.interfaces.StoreSummary;
import com.target.ui.analytics.a.ba;
import com.target.ui.fragment.common.BaseDialogFragment;
import com.target.ui.util.al;
import com.target.ui.util.p;
import com.target.ui.view.store.StoreChooserEnableLocationServicesView;
import com.target.ui.view.store.StoreChooserNoLocationServicesView;
import com.target.ui.view.store.StoreChooserSelectionView;

public class StoreChooserDialogFragment extends BaseDialogFragment
{
    private class a
        implements com.target.ui.view.store.StoreChooserEnableLocationServicesView.a
    {

        final StoreChooserDialogFragment this$0;

        public void a()
        {
            Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
            startActivity(intent);
            dismiss();
        }

        public void b()
        {
            StoreChooserDialogFragment.a(StoreChooserDialogFragment.this);
        }

        private a()
        {
            this$0 = StoreChooserDialogFragment.this;
            super();
        }

    }

    private class b
        implements com.target.ui.view.store.StoreChooserNoLocationServicesView.a
    {

        final StoreChooserDialogFragment this$0;

        public void a()
        {
            StoreChooserDialogFragment.b(StoreChooserDialogFragment.this);
        }

        public void b()
        {
            StoreChooserDialogFragment.a(StoreChooserDialogFragment.this);
        }

        private b()
        {
            this$0 = StoreChooserDialogFragment.this;
            super();
        }

    }

    public static interface c
    {

        public abstract void J();

        public abstract void a(StoreIdentifier storeidentifier);

        public abstract void a(StoreSummary storesummary);
    }

    public static final class d extends Enum
    {

        private static final d $VALUES[];
        public static final d FIATS;
        public static final d NEARBY_STORES;
        public static final d WEEKLY_AD;

        public static d valueOf(String s)
        {
            return (d)Enum.valueOf(com/target/ui/fragment/store/StoreChooserDialogFragment$d, s);
        }

        public static d[] values()
        {
            return (d[])$VALUES.clone();
        }

        static 
        {
            NEARBY_STORES = new d("NEARBY_STORES", 0);
            WEEKLY_AD = new d("WEEKLY_AD", 1);
            FIATS = new d("FIATS", 2);
            $VALUES = (new d[] {
                NEARBY_STORES, WEEKLY_AD, FIATS
            });
        }

        private d(String s, int i)
        {
            super(s, i);
        }
    }

    private class e
        implements com.target.ui.view.store.StoreChooserSelectionView.a
    {

        final StoreChooserDialogFragment this$0;

        public void a()
        {
            dismiss();
        }

        public void a(StoreIdentifier storeidentifier)
        {
            dismiss();
            if (StoreChooserDialogFragment.c(StoreChooserDialogFragment.this) != null)
            {
                StoreChooserDialogFragment.c(StoreChooserDialogFragment.this).a(storeidentifier);
            }
        }

        public void a(StoreSummary storesummary)
        {
            dismiss();
            if (StoreChooserDialogFragment.c(StoreChooserDialogFragment.this) != null)
            {
                StoreChooserDialogFragment.c(StoreChooserDialogFragment.this).a(storesummary);
            }
            StoreChooserDialogFragment.a(StoreChooserDialogFragment.this, true);
        }

        public void b()
        {
            if (StoreChooserDialogFragment.d(StoreChooserDialogFragment.this) == null)
            {
                return;
            } else
            {
                al.b(StoreChooserDialogFragment.d(StoreChooserDialogFragment.this).progressContainer);
                return;
            }
        }

        public void c()
        {
            if (StoreChooserDialogFragment.d(StoreChooserDialogFragment.this) == null)
            {
                return;
            } else
            {
                al.c(StoreChooserDialogFragment.d(StoreChooserDialogFragment.this).progressContainer);
                return;
            }
        }

        private e()
        {
            this$0 = StoreChooserDialogFragment.this;
            super();
        }

    }

    private static class f
    {

        public TextView dialogTitle;
        public StoreChooserEnableLocationServicesView enableLocationServicesWrapper;
        public StoreChooserNoLocationServicesView locationServicesOffWrapper;
        public View progressContainer;
        public StoreChooserSelectionView storeListWrapper;

        public f(View view)
        {
            enableLocationServicesWrapper = (StoreChooserEnableLocationServicesView)view.findViewById(0x7f10021c);
            locationServicesOffWrapper = (StoreChooserNoLocationServicesView)view.findViewById(0x7f10021d);
            storeListWrapper = (StoreChooserSelectionView)view.findViewById(0x7f10021e);
            dialogTitle = (TextView)view.findViewById(0x7f10021b);
            progressContainer = view.findViewById(0x7f1001fa);
        }
    }


    public static final String TAG = com/target/ui/fragment/store/StoreChooserDialogFragment.getSimpleName();
    private static final String TYPE_KEY = "type";
    private c mListener;
    private boolean mOpenInLookupMode;
    private boolean mStoreUpdated;
    private d mType;
    private f mViews;

    public StoreChooserDialogFragment()
    {
    }

    public static StoreChooserDialogFragment a(d d1, c c1)
    {
        StoreChooserDialogFragment storechooserdialogfragment = new StoreChooserDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", d1.ordinal());
        storechooserdialogfragment.setArguments(bundle);
        a(((DialogFragment) (storechooserdialogfragment)), c1);
        return storechooserdialogfragment;
    }

    private void a()
    {
        mOpenInLookupMode = p.a(getActivity());
        if (mOpenInLookupMode)
        {
            g();
            return;
        } else
        {
            f();
            return;
        }
    }

    private static void a(DialogFragment dialogfragment, c c1)
        throws IllegalArgumentException
    {
        if (c1 == null)
        {
            throw new IllegalArgumentException("StoreChooserListener cannot be null");
        }
        if (!(c1 instanceof Fragment))
        {
            throw new IllegalArgumentException("StoreChooserListener must be the calling fragment");
        } else
        {
            dialogfragment.setTargetFragment((Fragment)c1, 0);
            return;
        }
    }

    private void a(View view)
    {
        al.a(new View[] {
            mViews.enableLocationServicesWrapper, mViews.locationServicesOffWrapper, mViews.storeListWrapper
        });
        al.b(view);
    }

    static void a(StoreChooserDialogFragment storechooserdialogfragment)
    {
        storechooserdialogfragment.g();
    }

    static boolean a(StoreChooserDialogFragment storechooserdialogfragment, boolean flag)
    {
        storechooserdialogfragment.mStoreUpdated = flag;
        return flag;
    }

    private void b()
    {
        mViews.enableLocationServicesWrapper.setListener(new a());
        mViews.locationServicesOffWrapper.setListener(new b());
        mViews.storeListWrapper.setListener(new e());
    }

    static void b(StoreChooserDialogFragment storechooserdialogfragment)
    {
        storechooserdialogfragment.e();
    }

    static c c(StoreChooserDialogFragment storechooserdialogfragment)
    {
        return storechooserdialogfragment.mListener;
    }

    private void c()
    {
        mViews.locationServicesOffWrapper.setPlaceholderView(mType);
    }

    static f d(StoreChooserDialogFragment storechooserdialogfragment)
    {
        return storechooserdialogfragment.mViews;
    }

    private void d()
    {
        String s;
        if (mType == d.NEARBY_STORES)
        {
            s = getString(0x7f0902fd);
        } else
        {
            s = getString(0x7f090529);
        }
        mViews.dialogTitle.setText(s);
    }

    private void e()
    {
        a(mViews.enableLocationServicesWrapper);
    }

    private void f()
    {
        a(mViews.locationServicesOffWrapper);
    }

    private void g()
    {
        a(mViews.storeListWrapper);
        mViews.storeListWrapper.b();
    }

    public void onAttach(Activity activity)
    {
        try
        {
            mListener = (c)getTargetFragment();
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            throw new ClassCastException("Parent fragment must implement StoreUpdatedListener");
        }
        if (mListener == null)
        {
            throw new IllegalStateException("Cannot set StoreChooserDialogFragment's target fragment to null");
        } else
        {
            super.onAttach(activity);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mType = d.values()[getArguments().getInt("type")];
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030087, viewgroup, true);
        mViews = new f(layoutinflater);
        al.c(mViews.progressContainer);
        d();
        c();
        b();
        a();
        return layoutinflater;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        mViews = null;
    }

    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        super.onDismiss(dialoginterface);
        while (mListener == null || mStoreUpdated) 
        {
            return;
        }
        mListener.J();
    }

    public void onResume()
    {
        super.onResume();
        ba.a(this).e();
    }

}
