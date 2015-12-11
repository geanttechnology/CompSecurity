// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import com.bestbuy.android.api.lib.models.registry.WeddingRegistryData;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import nb;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            RegistryAdditionalOptions

public class FindRegistry extends BBYBaseFragment
{

    private Button a;
    private CheckBox b;
    private WeddingRegistryData c;

    public FindRegistry()
    {
    }

    static WeddingRegistryData a(FindRegistry findregistry)
    {
        return findregistry.c;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = (FragmentActivity)activity;
        Bundle bundle = getArguments();
        if (bundle != null)
        {
            c = (WeddingRegistryData)bundle.getSerializable("data");
        }
        nb.a().i(((BBYBaseFragmentActivity)activity).getCurrentActionBarTitle());
        ((BBYBaseFragmentActivity)activity).updateActionBarTitle(getString(0x7f08033d));
        ((BBYBaseFragmentActivity)activity).hideActionBarHomeAndSearchBox(activity);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03003d, viewgroup, false);
        b = (CheckBox)layoutinflater.findViewById(0x7f0c0101);
        b.setOnClickListener(new android.view.View.OnClickListener() {

            final FindRegistry a;

            public void onClick(View view)
            {
                if (!((CheckBox)view).isChecked());
            }

            
            {
                a = FindRegistry.this;
                super();
            }
        });
        a = (Button)layoutinflater.findViewById(0x7f0c0105);
        a.setOnClickListener(new android.view.View.OnClickListener() {

            final FindRegistry a;

            public void onClick(View view)
            {
                view = new RegistryAdditionalOptions();
                Bundle bundle1 = new Bundle();
                bundle1.putSerializable("data", FindRegistry.a(a));
                FragmentManager fragmentmanager = ((BBYBaseFragmentActivity)a.d).getSupportFragmentManager();
                view.setArguments(bundle1);
                fragmentmanager.beginTransaction().replace(0x7f0c0033, view).commit();
            }

            
            {
                a = FindRegistry.this;
                super();
            }
        });
        return layoutinflater;
    }
}
