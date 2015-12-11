// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import cg;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import nb;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            WeddingRegistrySettings, RegistryFragmentContainer

public class UpdateRegistryAddress extends BBYBaseFragment
    implements cg
{

    private EditText a;
    private EditText b;
    private EditText c;
    private EditText g;
    private EditText h;
    private Spinner i;
    private EditText j;
    private EditText k;
    private View l;
    private Bundle m;

    public UpdateRegistryAddress()
    {
    }

    private void b()
    {
        Object obj = a.getText().toString();
        Object obj1 = b.getText().toString();
        String s = c.getText().toString();
        String s1 = g.getText().toString();
        String s2 = h.getText().toString();
        String s3 = i.getSelectedItem().toString();
        String s4 = j.getText().toString();
        String s5 = k.getText().toString().replaceAll("\\D", "");
        m.putString("newFirstName", ((String) (obj)));
        m.putString("newLastName", ((String) (obj1)));
        m.putString("newAddressLine1", s);
        m.putString("newAddressLine2", s1);
        m.putString("newZip", s2);
        m.putString("newState", s3);
        m.putString("newCity", s4);
        m.putString("newPhoneNumber", s5);
        obj = new WeddingRegistrySettings();
        ((Fragment) (obj)).setArguments(m);
        obj1 = getParentFragment();
        if (obj1 instanceof RegistryFragmentContainer)
        {
            ((BaseFragmentContainer)obj1).a(((Fragment) (obj)), true);
        }
    }

    public void g()
    {
        b();
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        bundle = ((BBYBaseFragmentActivity)d).getCurrentActionBarTitle();
        f.i(bundle);
        ((BBYBaseFragmentActivity)d).hideActionBarHomeAndSearchBox(d);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = (FragmentActivity)activity;
        ((HomeActivity)activity).setOnLifeEventsTopNavigationListener(this, getString(0x7f0802e5), true);
        nb.a().i(((BBYBaseFragmentActivity)activity).getCurrentActionBarTitle());
        ((BBYBaseFragmentActivity)activity).updateActionBarTitle("Change Address");
        ((BBYBaseFragmentActivity)activity).hideActionBarHomeAndSearchBox(activity);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03010f, viewgroup, false);
        l = layoutinflater.findViewById(0x7f0c0064);
        a = (EditText)layoutinflater.findViewById(0x7f0c00a7);
        b = (EditText)layoutinflater.findViewById(0x7f0c00a8);
        c = (EditText)layoutinflater.findViewById(0x7f0c03e8);
        g = (EditText)layoutinflater.findViewById(0x7f0c03e9);
        h = (EditText)layoutinflater.findViewById(0x7f0c03ea);
        i = (Spinner)layoutinflater.findViewById(0x7f0c0377);
        j = (EditText)layoutinflater.findViewById(0x7f0c0374);
        k = (EditText)layoutinflater.findViewById(0x7f0c03eb);
        k.setInputType(3);
        k.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        return layoutinflater;
    }

    public void onResume()
    {
        super.onResume();
    }
}
