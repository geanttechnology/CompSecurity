// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.store.location;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.target.ui.e.j;
import com.target.ui.fragment.common.BaseDialogFragment;
import com.target.ui.fragment.store.location.a.a;

public class InStoreLocationOptInDialogFragment extends BaseDialogFragment
    implements a
{
    static class Views extends com.target.ui.view.a
    {

        CheckBox enabledCheckBox;
        Button shopButton;

        protected Views(View view)
        {
            super(view);
        }
    }


    public static final String TAG = "InStoreLocationOptInDialogFragment";
    private com.target.ui.fragment.store.location.b.a mPresenter;
    private Views mViews;

    public InStoreLocationOptInDialogFragment()
    {
    }

    public static InStoreLocationOptInDialogFragment a()
    {
        return new InStoreLocationOptInDialogFragment();
    }

    static com.target.ui.fragment.store.location.b.a a(InStoreLocationOptInDialogFragment instorelocationoptindialogfragment)
    {
        return instorelocationoptindialogfragment.mPresenter;
    }

    public void a(boolean flag)
    {
        mViews.enabledCheckBox.setChecked(flag);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03003b, viewgroup, false);
        mViews = new Views(layoutinflater);
        setCancelable(false);
        try
        {
            viewgroup = (j)getActivity();
        }
        // Misplaced declaration of an exception variable
        catch (LayoutInflater layoutinflater)
        {
            throw new ClassCastException((new StringBuilder()).append("Activity must implement ").append(com/target/ui/e/j.getSimpleName()).toString());
        }
        mPresenter = new com.target.ui.fragment.store.location.b.a(com.target.ui.l.a.a(), viewgroup.o());
        mViews.enabledCheckBox.setOnCheckedChangeListener(new android.widget.CompoundButton.OnCheckedChangeListener() {

            final InStoreLocationOptInDialogFragment this$0;

            public void onCheckedChanged(CompoundButton compoundbutton, boolean flag)
            {
                if (com.target.ui.fragment.store.location.InStoreLocationOptInDialogFragment.a(InStoreLocationOptInDialogFragment.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.fragment.store.location.InStoreLocationOptInDialogFragment.a(InStoreLocationOptInDialogFragment.this).a(flag);
                    return;
                }
            }

            
            {
                this$0 = InStoreLocationOptInDialogFragment.this;
                super();
            }
        });
        mViews.shopButton.setOnClickListener(new android.view.View.OnClickListener() {

            final InStoreLocationOptInDialogFragment this$0;

            public void onClick(View view)
            {
                if (com.target.ui.fragment.store.location.InStoreLocationOptInDialogFragment.a(InStoreLocationOptInDialogFragment.this) == null)
                {
                    return;
                } else
                {
                    com.target.ui.fragment.store.location.InStoreLocationOptInDialogFragment.a(InStoreLocationOptInDialogFragment.this).c();
                    return;
                }
            }

            
            {
                this$0 = InStoreLocationOptInDialogFragment.this;
                super();
            }
        });
        mPresenter.a(this);
        return layoutinflater;
    }
}
