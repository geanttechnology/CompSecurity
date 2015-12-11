// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WelcomeDialogFragment extends DialogFragment
{
    public static interface DialogFragmentActivity
    {

        public abstract void onDismiss(DialogInterface dialoginterface);
    }


    static final boolean $assertionsDisabled;

    public WelcomeDialogFragment()
    {
    }

    private int getThemeForVersion()
    {
        return 0x1030133;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setStyle(1, getThemeForVersion());
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03006b, viewgroup, false);
        if (!$assertionsDisabled && layoutinflater == null)
        {
            throw new AssertionError();
        } else
        {
            layoutinflater.findViewById(0x7f0b0108).setOnClickListener(new android.view.View.OnClickListener() {

                final WelcomeDialogFragment this$0;

                public void onClick(View view)
                {
                    dismiss();
                }

            
            {
                this$0 = WelcomeDialogFragment.this;
                super();
            }
            });
            return layoutinflater;
        }
    }

    public void onDismiss(DialogInterface dialoginterface)
    {
        super.onDismiss(dialoginterface);
        DialogFragmentActivity dialogfragmentactivity = (DialogFragmentActivity)getActivity();
        if (dialogfragmentactivity != null)
        {
            dialogfragmentactivity.onDismiss(dialoginterface);
        }
    }

    static 
    {
        boolean flag;
        if (!com/bitstrips/imoji/ui/WelcomeDialogFragment.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }
}
