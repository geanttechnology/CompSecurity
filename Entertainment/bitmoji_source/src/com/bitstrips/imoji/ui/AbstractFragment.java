// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bitstrips.imoji.InjectorApplication;

public abstract class AbstractFragment extends Fragment
{

    static final boolean $assertionsDisabled;

    public AbstractFragment()
    {
    }

    protected abstract int getLayout();

    protected abstract void initArgs(Bundle bundle);

    protected abstract void initSubViews(View view);

    protected boolean isActivityValid()
    {
        return getActivity() != null && !getActivity().isFinishing();
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        ((InjectorApplication)getActivity().getApplication()).inject(this);
        populateContentView();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle == null)
        {
            throw new IllegalArgumentException("No arguments were passed");
        } else
        {
            initArgs(bundle);
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(getLayout(), viewgroup, false);
        if (!$assertionsDisabled && layoutinflater == null)
        {
            throw new AssertionError();
        } else
        {
            initSubViews(layoutinflater);
            return layoutinflater;
        }
    }

    protected abstract void populateContentView();

    static 
    {
        boolean flag;
        if (!com/bitstrips/imoji/ui/AbstractFragment.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }
}
