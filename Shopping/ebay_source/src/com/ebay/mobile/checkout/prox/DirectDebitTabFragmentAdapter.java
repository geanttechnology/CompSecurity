// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.checkout.prox;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

// Referenced classes of package com.ebay.mobile.checkout.prox:
//            DirectDebitTabFragment

public class DirectDebitTabFragmentAdapter extends FragmentStatePagerAdapter
{

    SparseArray registeredFragments;

    public DirectDebitTabFragmentAdapter(FragmentManager fragmentmanager)
    {
        super(fragmentmanager);
        registeredFragments = new SparseArray();
    }

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        registeredFragments.remove(i);
        super.destroyItem(viewgroup, i, obj);
    }

    public int getCount()
    {
        return 2;
    }

    public Fragment getItem(int i)
    {
        DirectDebitTabFragment directdebittabfragment = new DirectDebitTabFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("com.ebay.mobile.checkout.prox.DirectDebitTabFragment.tabIndex", i);
        directdebittabfragment.setArguments(bundle);
        return directdebittabfragment;
    }

    public Fragment getRegisteredFragment(int i)
    {
        return (Fragment)registeredFragments.get(i);
    }

    public Object instantiateItem(ViewGroup viewgroup, int i)
    {
        viewgroup = (Fragment)super.instantiateItem(viewgroup, i);
        registeredFragments.put(i, viewgroup);
        return viewgroup;
    }
}
