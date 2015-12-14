// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import com.socialin.android.d;
import com.socialin.android.picsart.profile.util.m;

// Referenced classes of package com.socialin.android.picsart.profile.fragment:
//            x

public class w extends Fragment
    implements android.widget.RadioGroup.OnCheckedChangeListener
{

    private static final String a = com/socialin/android/picsart/profile/fragment/w.getSimpleName();
    private m b;

    public w()
    {
        setRetainInstance(false);
    }

    private x a(String s, boolean flag)
    {
        Object obj = getActivity();
        Object obj1 = getView();
        if (obj == null || ((Activity) (obj)).isFinishing() || obj1 == null)
        {
            return null;
        }
        obj1 = getActivity().getFragmentManager().beginTransaction();
        obj = getFragmentManager().findFragmentByTag("findFriendsFragmentTag");
        if (obj != null && ((Fragment) (obj)).isAdded() && flag)
        {
            ((FragmentTransaction) (obj1)).show(((Fragment) (obj)));
            s = (x)obj;
            s.k();
        } else
        {
            x x1 = x.g();
            Bundle bundle = new Bundle();
            bundle.putString("friendType", s);
            x1.setArguments(bundle);
            ((FragmentTransaction) (obj1)).replace(0x7f10092f, x1, "findFriendsFragmentTag");
            x1.b(getView().findViewById(0x7f10092e));
            s = x1;
        }
        ((FragmentTransaction) (obj1)).commit();
        return s;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        getView().findViewById(0x7f10017b).setVisibility(8);
        b = new m(getActivity());
        bundle = getView();
        ((RadioGroup)bundle.findViewById(0x7f100927)).setOnCheckedChangeListener(this);
        if (getString(0x7f0808c8).equalsIgnoreCase(getString(0x7f0808cc)))
        {
            bundle.findViewById(0x7f100928).setVisibility(8);
            bundle.findViewById(0x7f100929).setVisibility(8);
            bundle.findViewById(0x7f10092a).setVisibility(8);
        }
        bundle = b.a();
        getActivity().getIntent().putExtra("friendType", bundle);
        a(bundle, false);
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        Fragment fragment;
        try
        {
            fragment = getFragmentManager().findFragmentByTag("findFriendsFragmentTag");
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            d.b(a, "onActivityResult", intent);
            return;
        }
        if (fragment == null)
        {
            break MISSING_BLOCK_LABEL_42;
        }
        if (fragment instanceof x)
        {
            ((x)fragment).onActivityResult(i, j, intent);
        }
    }

    public void onCheckedChanged(RadioGroup radiogroup, int i)
    {
        Object obj;
label0:
        {
            radiogroup = b.a(i);
            if (!TextUtils.isEmpty(radiogroup))
            {
                obj = getActivity();
                if (obj != null && !((Activity) (obj)).isFinishing())
                {
                    break label0;
                }
            }
            return;
        }
        ((Activity) (obj)).getIntent().putExtra("friendType", radiogroup);
        obj = getFragmentManager().findFragmentByTag("findFriendsFragmentTag");
        if (obj != null && ((Fragment) (obj)).isAdded())
        {
            ((x)obj).k();
            return;
        } else
        {
            a(radiogroup, true);
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030202, viewgroup, false);
    }

}
