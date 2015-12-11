// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.dialog;

import android.app.Dialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import com.target.ui.fragment.common.BaseDialogFragment;

public class UnknownAisleDialogFragment extends BaseDialogFragment
{
    static class Views extends com.target.ui.view.a
    {

        Button continueButton;

        public Views(View view)
        {
            super(view);
        }
    }

    private class a
        implements android.view.View.OnClickListener
    {

        final UnknownAisleDialogFragment this$0;

        public void onClick(View view)
        {
            getDialog().dismiss();
        }

        private a()
        {
            this$0 = UnknownAisleDialogFragment.this;
            super();
        }

    }


    public static final String TAG = com/target/ui/fragment/product/dialog/UnknownAisleDialogFragment.getSimpleName();
    private Views mViews;

    public UnknownAisleDialogFragment()
    {
    }

    public static UnknownAisleDialogFragment a()
    {
        return new UnknownAisleDialogFragment();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030073, viewgroup, false);
        mViews = new Views(layoutinflater);
        mViews.continueButton.setOnClickListener(new a());
        return layoutinflater;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        mViews = null;
    }

    public void onStart()
    {
        super.onStart();
        if (getDialog() == null)
        {
            return;
        } else
        {
            int i = getResources().getDimensionPixelSize(0x7f0a0254);
            getDialog().getWindow().setLayout(-1, i);
            return;
        }
    }

}
