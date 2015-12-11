// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.bestbuy.android.api.lib.models.pdp.ContractOption;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import ei;
import java.util.ArrayList;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.pdp:
//            PDPFragment, PDPFragmentContainer

public class PDPOptionsSubFragment extends BBYBaseFragment
{

    private View a;
    private ListView b;
    private ArrayList c;
    private boolean g;

    public PDPOptionsSubFragment()
    {
        g = false;
    }

    public PDPOptionsSubFragment(ArrayList arraylist, boolean flag)
    {
        g = false;
        c = arraylist;
        g = flag;
    }

    static boolean a(PDPOptionsSubFragment pdpoptionssubfragment)
    {
        return pdpoptionssubfragment.g;
    }

    static ArrayList b(PDPOptionsSubFragment pdpoptionssubfragment)
    {
        return pdpoptionssubfragment.c;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        ((BBYBaseFragmentActivity)d).changeActionBarShareVisibility(d, false);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = activity;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (a == null)
        {
            a = layoutinflater.inflate(0x7f030094, viewgroup, false);
            b = (ListView)a.findViewById(0x7f0c0244);
            if (g)
            {
                b.setSelector(0x7f0b004f);
            }
            layoutinflater = new ei(d, 0x7f030095, c, g);
            b.setAdapter(layoutinflater);
            b.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                final PDPOptionsSubFragment a;

                public void onItemClick(AdapterView adapterview, View view, int i, long l)
                {
                    if (!PDPOptionsSubFragment.a(a))
                    {
                        view = (ContractOption)PDPOptionsSubFragment.b(a).get(i);
                        adapterview = a.getParentFragment();
                        view = new PDPFragment(view.getSku(), view.getProductId(), false);
                        ((PDPFragmentContainer)adapterview).e();
                        ((PDPFragmentContainer)adapterview).a(view, false);
                    }
                }

            
            {
                a = PDPOptionsSubFragment.this;
                super();
            }
            });
        } else
        {
            ((ViewGroup)a.getParent()).removeView(a);
        }
        return a;
    }

    public void onDestroy()
    {
        super.onDestroy();
        ((BBYBaseFragmentActivity)d).changeActionBarShareVisibility(d, true);
    }
}
