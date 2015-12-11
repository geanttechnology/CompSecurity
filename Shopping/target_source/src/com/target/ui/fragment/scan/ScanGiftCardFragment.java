// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.scan;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.f;
import android.support.v4.app.h;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.target.mothership.util.o;
import com.target.ui.util.e.a;

// Referenced classes of package com.target.ui.fragment.scan:
//            BaseScanFragment

public class ScanGiftCardFragment extends BaseScanFragment
{
    public static interface a
    {

        public abstract void c(String s);
    }


    private final int GIFT_CARD_FULL_LENGTH = 15;
    private final int GIFT_CARD_START_INDEX = 0;
    private a mScanResultListener;

    public ScanGiftCardFragment()
    {
    }

    public static ScanGiftCardFragment a(a a1)
    {
        if (a1 == null)
        {
            throw new IllegalArgumentException("ScanResultListener must not be null");
        }
        if (!(a1 instanceof Fragment))
        {
            throw new IllegalArgumentException("ScanResultListener must be an instance of android.support.v4.app.Fragment");
        } else
        {
            ScanGiftCardFragment scangiftcardfragment = new ScanGiftCardFragment();
            scangiftcardfragment.setTargetFragment((Fragment)a1, 0);
            return scangiftcardfragment;
        }
    }

    private String b(String s)
    {
        if (!o.g(s) || s.length() < 15)
        {
            return null;
        } else
        {
            return s.substring(0, 15);
        }
    }

    public void a(String s)
    {
        s = b(s);
        mScanResultListener.c(s);
        getActivity().f().c();
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        com.target.ui.util.e.a.a(this);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            mScanResultListener = (a)getTargetFragment();
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            throw new ClassCastException("Parent fragment must implement ScanResultListener.onScanResult");
        }
        if (mScanResultListener == null)
        {
            throw new IllegalStateException("Cannot set ScanFragment's target fragment to null");
        } else
        {
            return;
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            j(getResources().getString(0x7f090302));
            super.onCreateOptionsMenu(menu, menuinflater);
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03005e, viewgroup, false);
        ((RelativeLayout)layoutinflater.findViewById(0x7f100180)).addView(b());
        a(new b.a.a.b.a[] {
            b.a.a.b.a.f, b.a.a.b.a.g, b.a.a.b.a.q
        });
        return layoutinflater;
    }

    public void onDetach()
    {
        super.onDetach();
        mScanResultListener = null;
    }
}
