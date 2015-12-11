// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.common;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import butterknife.ButterKnife;

// Referenced classes of package com.target.ui.fragment.common:
//            BaseDialogFragment

public class SimpleThankYouDialogFragment extends BaseDialogFragment
{
    protected class Views
    {

        Button button;
        TextView message;
        final SimpleThankYouDialogFragment this$0;

        public Views(View view)
        {
            this$0 = SimpleThankYouDialogFragment.this;
            super();
            ButterKnife.bind(this, view);
        }
    }


    private static final String ARG_MESSAGE = "message";
    public static final String TAG = com/target/ui/fragment/common/SimpleThankYouDialogFragment.getSimpleName();
    private String mMessage;
    private Views mViews;

    public SimpleThankYouDialogFragment()
    {
    }

    public static SimpleThankYouDialogFragment a(String s)
    {
        SimpleThankYouDialogFragment simplethankyoudialogfragment = new SimpleThankYouDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("message", s);
        simplethankyoudialogfragment.setArguments(bundle);
        return simplethankyoudialogfragment;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mMessage = getArguments().getString("message");
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030086, viewgroup, false);
        mViews = new Views(layoutinflater);
        mViews.message.setText(mMessage);
        mViews.button.setOnClickListener(new android.view.View.OnClickListener() {

            final SimpleThankYouDialogFragment this$0;

            public void onClick(View view)
            {
                dismiss();
            }

            
            {
                this$0 = SimpleThankYouDialogFragment.this;
                super();
            }
        });
        return layoutinflater;
    }

}
