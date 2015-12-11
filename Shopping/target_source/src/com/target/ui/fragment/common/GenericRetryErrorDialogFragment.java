// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.common;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

// Referenced classes of package com.target.ui.fragment.common:
//            BaseDialogFragment

public class GenericRetryErrorDialogFragment extends BaseDialogFragment
{
    static class Views extends com.target.ui.view.a
    {

        View dismissButton;
        TextView message;
        View retryButton;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a(Bundle bundle);
    }


    private static final String ARG_DATA_BUNDLE = "arg_data_bundle";
    private static final String ARG_MESSAGE = "arg_message";
    public static final String TAG = com/target/ui/fragment/common/GenericRetryErrorDialogFragment.getSimpleName();
    private Bundle mDataBundle;
    private a mListener;
    private String mMessage;
    private Views mViews;

    public GenericRetryErrorDialogFragment()
    {
    }

    static a a(GenericRetryErrorDialogFragment genericretryerrordialogfragment)
    {
        return genericretryerrordialogfragment.mListener;
    }

    public static GenericRetryErrorDialogFragment a(String s, Bundle bundle, Fragment fragment)
    {
        GenericRetryErrorDialogFragment genericretryerrordialogfragment = new GenericRetryErrorDialogFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putBundle("arg_data_bundle", bundle);
        bundle1.putString("arg_message", s);
        genericretryerrordialogfragment.setArguments(bundle1);
        genericretryerrordialogfragment.setTargetFragment(fragment, 0);
        return genericretryerrordialogfragment;
    }

    static Bundle b(GenericRetryErrorDialogFragment genericretryerrordialogfragment)
    {
        return genericretryerrordialogfragment.mDataBundle;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        mListener = (a)getTargetFragment();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mDataBundle = getArguments().getBundle("arg_data_bundle");
        mMessage = getArguments().getString("arg_message");
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03005f, viewgroup, true);
        mViews = new Views(layoutinflater);
        mViews.message.setText(mMessage);
        mViews.dismissButton.setOnClickListener(new android.view.View.OnClickListener() {

            final GenericRetryErrorDialogFragment this$0;

            public void onClick(View view)
            {
                dismiss();
            }

            
            {
                this$0 = GenericRetryErrorDialogFragment.this;
                super();
            }
        });
        mViews.retryButton.setOnClickListener(new android.view.View.OnClickListener() {

            final GenericRetryErrorDialogFragment this$0;

            public void onClick(View view)
            {
                if (GenericRetryErrorDialogFragment.a(GenericRetryErrorDialogFragment.this) == null)
                {
                    return;
                } else
                {
                    GenericRetryErrorDialogFragment.a(GenericRetryErrorDialogFragment.this).a(GenericRetryErrorDialogFragment.b(GenericRetryErrorDialogFragment.this));
                    dismiss();
                    return;
                }
            }

            
            {
                this$0 = GenericRetryErrorDialogFragment.this;
                super();
            }
        });
        return layoutinflater;
    }

    public void onDetach()
    {
        super.onDetach();
        mListener = null;
    }

}
