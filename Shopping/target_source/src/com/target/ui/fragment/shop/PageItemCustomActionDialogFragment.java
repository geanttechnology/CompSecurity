// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shop;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.f;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.a.a.e;
import com.h.c.u;
import com.h.c.y;
import com.target.mothership.model.page_item.interfaces.Action;
import com.target.mothership.model.page_item.interfaces.CustomAction;
import com.target.mothership.model.page_item.interfaces.ImageInfo;
import com.target.ui.analytics.a.ba;
import com.target.ui.fragment.common.BaseDialogFragment;

public class PageItemCustomActionDialogFragment extends BaseDialogFragment
{
    static class Views extends com.target.ui.view.a
    {

        ImageView imageView;
        Button primaryActionButton;
        Button secondaryActionButton;
        Button singleActionButton;
        TextView textView;
        LinearLayout twoButtonLayout;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a(Action action);
    }


    private static final float DIALOG_SCREEN_WIDTH_FRACTION = 0.75F;
    private static final String KEY_CUSTOM_ACTION = "customAction";
    public static final String TAG = com/target/ui/fragment/shop/PageItemCustomActionDialogFragment.getSimpleName();
    private CustomAction mAction;
    private a mListener;
    private Views mViews;

    public PageItemCustomActionDialogFragment()
    {
    }

    static a a(PageItemCustomActionDialogFragment pageitemcustomactiondialogfragment)
    {
        return pageitemcustomactiondialogfragment.mListener;
    }

    public static PageItemCustomActionDialogFragment a(CustomAction customaction)
    {
        PageItemCustomActionDialogFragment pageitemcustomactiondialogfragment = new PageItemCustomActionDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("customAction", customaction);
        pageitemcustomactiondialogfragment.setArguments(bundle);
        return pageitemcustomactiondialogfragment;
    }

    private void a()
    {
        String s = null;
        if (mAction.b().b())
        {
            s = ((ImageInfo)mAction.b().c()).b();
        } else
        if (mAction.c().b())
        {
            s = (String)mAction.c().c();
        }
        if (s != null)
        {
            DisplayMetrics displaymetrics = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
            android.view.ViewGroup.LayoutParams layoutparams = mViews.imageView.getLayoutParams();
            int i = (int)Math.min((float)displaymetrics.widthPixels * 0.75F, (float)displaymetrics.heightPixels * 0.75F);
            layoutparams.height = i;
            layoutparams.width = i;
            u.a(getActivity()).a(s).a(mViews.imageView);
            return;
        } else
        {
            mViews.imageView.setVisibility(8);
            return;
        }
    }

    private void b()
    {
        if (mAction.d().b())
        {
            Button button;
            String s;
            final Action primaryAction;
            if (mAction.e().b())
            {
                mViews.twoButtonLayout.setVisibility(0);
                button = mViews.primaryActionButton;
            } else
            {
                mViews.singleActionButton.setVisibility(0);
                button = mViews.singleActionButton;
            }
            primaryAction = (Action)mAction.d().c();
            if (primaryAction.c().b())
            {
                s = (String)primaryAction.c().c();
            } else
            {
                s = getString(0x7f0903f2);
            }
            button.setText(s);
            button.setOnClickListener(new android.view.View.OnClickListener() {

                final PageItemCustomActionDialogFragment this$0;
                final Action val$primaryAction;

                public void onClick(View view)
                {
                    PageItemCustomActionDialogFragment.a(PageItemCustomActionDialogFragment.this).a(primaryAction);
                    dismiss();
                }

            
            {
                this$0 = PageItemCustomActionDialogFragment.this;
                primaryAction = action;
                super();
            }
            });
        }
    }

    private void c()
    {
        if (mAction.e().b())
        {
            final Action secondaryAction = (Action)mAction.e().c();
            Button button = mViews.secondaryActionButton;
            String s;
            if (secondaryAction.c().b())
            {
                s = (String)secondaryAction.c().c();
            } else
            {
                s = getString(0x7f0903f4);
            }
            button.setText(s);
            mViews.secondaryActionButton.setOnClickListener(new android.view.View.OnClickListener() {

                final PageItemCustomActionDialogFragment this$0;
                final Action val$secondaryAction;

                public void onClick(View view)
                {
                    PageItemCustomActionDialogFragment.a(PageItemCustomActionDialogFragment.this).a(secondaryAction);
                    dismiss();
                }

            
            {
                this$0 = PageItemCustomActionDialogFragment.this;
                secondaryAction = action;
                super();
            }
            });
        }
    }

    public void onAttach(Activity activity)
    {
        try
        {
            mListener = (a)getTargetFragment();
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            throw new ClassCastException("Parent fragment must implement CustomActionListener");
        }
        if (mListener == null)
        {
            throw new IllegalStateException("Cannot set CustomActionDialogFragment's target fragment to null");
        } else
        {
            super.onAttach(activity);
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030058, viewgroup, false);
        mViews = new Views(layoutinflater);
        mAction = (CustomAction)getArguments().getParcelable("customAction");
        mViews.textView.setText(mAction.a());
        a();
        b();
        c();
        return layoutinflater;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        mViews = null;
    }

    public void onResume()
    {
        super.onResume();
        ba.a(this).e();
    }

}
