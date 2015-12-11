// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import cg;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.home.HomeTabContainer;
import com.bestbuy.android.api.lib.models.registry.WeddingRegistryData;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import dc;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import lu;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            WeddingAddressFragment, RegistryFragmentContainer

public class WeddingDateFragment extends BBYBaseFragment
    implements android.view.View.OnClickListener, cg
{

    private EditText a;
    private WeddingRegistryData b;
    private android.app.DatePickerDialog.OnDateSetListener c;
    private Calendar g;
    private boolean h;
    private boolean i;
    private LinearLayout j;
    private LinearLayout k;
    private String l;

    public WeddingDateFragment()
    {
        h = false;
        i = false;
    }

    public WeddingDateFragment(String s)
    {
        h = false;
        i = false;
        l = s;
    }

    static Calendar a(WeddingDateFragment weddingdatefragment)
    {
        return weddingdatefragment.g;
    }

    public static boolean a(WeddingDateFragment weddingdatefragment, boolean flag)
    {
        weddingdatefragment.h = flag;
        return flag;
    }

    static EditText b(WeddingDateFragment weddingdatefragment)
    {
        return weddingdatefragment.a;
    }

    public static boolean b(WeddingDateFragment weddingdatefragment, boolean flag)
    {
        weddingdatefragment.i = flag;
        return flag;
    }

    public static boolean c(WeddingDateFragment weddingdatefragment)
    {
        return weddingdatefragment.h;
    }

    public void g()
    {
        if (i)
        {
            Bundle bundle = new Bundle();
            Object obj = a.getText().toString();
            b.eventDate = ((String) (obj));
            android.support.v4.app.Fragment fragment;
            if (l != null && !l.isEmpty())
            {
                obj = new WeddingAddressFragment(b, l);
            } else
            {
                obj = new WeddingAddressFragment(b);
            }
            bundle.putSerializable("data", b);
            fragment = getParentFragment();
            ((WeddingAddressFragment) (obj)).setArguments(bundle);
            if (fragment instanceof RegistryFragmentContainer)
            {
                ((BaseFragmentContainer)fragment).a(((android.support.v4.app.Fragment) (obj)), true, "WeddingAddressFragment");
            }
            if (fragment instanceof HomeTabContainer)
            {
                ((HomeTabContainer)fragment).a(((android.support.v4.app.Fragment) (obj)), true);
            }
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = (FragmentActivity)activity;
        Bundle bundle = getArguments();
        if (bundle != null)
        {
            b = (WeddingRegistryData)bundle.getSerializable("data");
        }
        ((BBYBaseFragmentActivity)activity).updateActionBarTitle(getString(0x7f08033a));
        ((BBYBaseFragmentActivity)activity).hideActionBarHomeAndSearchBox(activity);
        lu.a(lu.av);
    }

    public void onClick(View view)
    {
        if (view == a)
        {
            DatePickerDialog datepickerdialog = new DatePickerDialog(getActivity(), c, g.get(1), g.get(2), g.get(5));
            datepickerdialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000L);
            Calendar calendar = Calendar.getInstance();
            calendar.add(2, 18);
            datepickerdialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());
            datepickerdialog.show();
        }
        if (view != j);
        if (view != k);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030113, viewgroup, false);
        j = (LinearLayout)layoutinflater.findViewById(0x7f0c03f3);
        k = (LinearLayout)layoutinflater.findViewById(0x7f0c0076);
        a = (EditText)layoutinflater.findViewById(0x7f0c03f4);
        a.addTextChangedListener(new dc(this, a));
        g = Calendar.getInstance();
        c = new android.app.DatePickerDialog.OnDateSetListener() {

            final WeddingDateFragment a;

            private void a()
            {
                SimpleDateFormat simpledateformat = new SimpleDateFormat("MM/dd/yyyy", Locale.US);
                WeddingDateFragment.b(a).setText(simpledateformat.format(WeddingDateFragment.a(a).getTime()));
            }

            public void onDateSet(DatePicker datepicker, int i1, int j1, int k1)
            {
                WeddingDateFragment.a(a).set(1, i1);
                WeddingDateFragment.a(a).set(2, j1);
                WeddingDateFragment.a(a).set(5, k1);
                a();
            }

            
            {
                a = WeddingDateFragment.this;
                super();
            }
        };
        a.setOnClickListener(this);
        j.setOnClickListener(this);
        k.setOnClickListener(this);
        return layoutinflater;
    }

    public void onResume()
    {
        super.onResume();
        ((BBYBaseFragmentActivity)d).updateActionBarTitle(getString(0x7f08033a));
        ((HomeActivity)d).setOnLifeEventsTopNavigationListener(this, getString(0x7f08026a), true);
    }
}
