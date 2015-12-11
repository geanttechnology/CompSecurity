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

// Referenced classes of package com.target.ui.fragment.common:
//            BaseDialogFragment

public class SimpleDialogFragment extends BaseDialogFragment
{
    private class a
    {

        Button button;
        TextView content;
        final SimpleDialogFragment this$0;
        TextView title;

        public a(View view)
        {
            this$0 = SimpleDialogFragment.this;
            super();
            button = (Button)view.findViewById(0x7f100069);
            content = (TextView)view.findViewById(0x7f10021a);
            title = (TextView)view.findViewById(0x7f100080);
        }
    }


    private static final String ARG_BUTTON_TEXT = "button_text";
    private static final String ARG_CONTENT = "content";
    private static final String ARG_TITLE = "title";
    public static final String TAG = com/target/ui/fragment/common/SimpleDialogFragment.getSimpleName();
    private String mButtonText;
    private String mContent;
    private String mTitle;
    private a mViews;

    public SimpleDialogFragment()
    {
    }

    public static SimpleDialogFragment a(String s, String s1)
    {
        return a(s, s1, null);
    }

    public static SimpleDialogFragment a(String s, String s1, String s2)
    {
        SimpleDialogFragment simpledialogfragment = new SimpleDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("button_text", s2);
        bundle.putString("content", s1);
        bundle.putString("title", s);
        simpledialogfragment.setArguments(bundle);
        return simpledialogfragment;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mButtonText = getArguments().getString("button_text");
        mContent = getArguments().getString("content");
        mTitle = getArguments().getString("title");
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030085, viewgroup, false);
        mViews = new a(layoutinflater);
        mViews.title.setText(mTitle);
        mViews.content.setText(mContent);
        if (mButtonText != null)
        {
            mViews.button.setText(mButtonText);
        }
        mViews.button.setOnClickListener(new android.view.View.OnClickListener() {

            final SimpleDialogFragment this$0;

            public void onClick(View view)
            {
                dismiss();
            }

            
            {
                this$0 = SimpleDialogFragment.this;
                super();
            }
        });
        return layoutinflater;
    }

}
