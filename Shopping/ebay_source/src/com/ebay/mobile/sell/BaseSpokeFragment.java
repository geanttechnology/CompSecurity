// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.TextView;
import com.ebay.app.AlertDialogFragment;
import com.ebay.mobile.activities.BaseFragment;
import com.ebay.mobile.activities.CoreActivity;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.widget.PriceView;
import com.ebay.nautilus.domain.data.LdsField;
import com.ebay.nautilus.shell.app.BaseActivity;

public abstract class BaseSpokeFragment extends BaseFragment
{
    private static class ShowHideAnimation extends Animation
    {

        final long animationDuration = 500L;
        int guessedHeight;
        boolean showing;
        View view;
        int visibleHeight;

        protected void applyTransformation(float f, Transformation transformation)
        {
            int i;
            if (showing)
            {
                i = (int)((float)guessedHeight * f);
                if (f >= 1.0F)
                {
                    i = visibleHeight;
                }
            } else
            {
                i = (int)((float)guessedHeight * (1.0F - f));
            }
            view.getLayoutParams().height = i;
            view.requestLayout();
        }

        public boolean willChangeBounds()
        {
            return true;
        }

        public ShowHideAnimation(View view1, int i, int j, boolean flag)
        {
            view = view1;
            visibleHeight = i;
            showing = flag;
            guessedHeight = j;
            setDuration(500L);
        }
    }


    protected static final String EXTRA_FIELD_ERROR_ID = "errorField";
    protected static final String EXTRA_SELECTED_SPECIFICS = "selected_specifics";
    protected static final String TAG = "ListingFragments";
    private boolean viewCreatedCalled;

    public BaseSpokeFragment()
    {
    }

    public static void hideDoneButton(View view)
    {
        if (view == null || view.getContext().getResources().getBoolean(0x7f0b0006))
        {
            return;
        } else
        {
            view = view.getRootView();
            view.findViewById(0x7f1003aa).setVisibility(8);
            view.findViewById(0x7f1003ab).setVisibility(0);
            ((TextView)view.findViewById(0x7f1003a5)).setText(0x7f070b61);
            return;
        }
    }

    public static void showDoneButton(View view, int i, android.view.View.OnClickListener onclicklistener)
    {
        if (view == null || view.getContext().getResources().getBoolean(0x7f0b0006))
        {
            return;
        } else
        {
            view = view.getRootView();
            View view1 = view.findViewById(0x7f1003aa);
            view1.setVisibility(0);
            view1.setOnClickListener(onclicklistener);
            view.findViewById(0x7f1003ab).setVisibility(8);
            ((TextView)view.findViewById(0x7f1003a5)).setText(i);
            return;
        }
    }

    protected static void showOrHideView(View view, boolean flag, int i, int j, boolean flag1)
    {
        if (view.isShown() && flag1)
        {
            view.startAnimation(new ShowHideAnimation(view, i, j, flag));
            return;
        }
        android.view.ViewGroup.LayoutParams layoutparams = view.getLayoutParams();
        if (!flag)
        {
            i = 0;
        }
        layoutparams.height = i;
        view.requestLayout();
    }

    protected static void showOrHideView(View view, boolean flag, int i, boolean flag1)
    {
        showOrHideView(view, flag, i, i, flag1);
    }

    protected static void updateCheckedTextValue(CheckedTextView checkedtextview, LdsField ldsfield)
    {
        String s = ldsfield.getStringValue();
        if (s == null)
        {
            checkedtextview.setChecked(false);
            return;
        } else
        {
            checkedtextview.setChecked(Boolean.valueOf(s).booleanValue());
            checkedtextview.setEnabled(ldsfield.isEnabled());
            return;
        }
    }

    protected static void updatePriceValue(PriceView priceview, LdsField ldsfield, String s)
    {
        ldsfield = EbayCurrencyUtil.parseApiValue(ldsfield.getStringValue());
        priceview.setCurrency(s);
        if (ldsfield == null)
        {
            priceview.clear();
        } else
        if (!ldsfield.equals(priceview.getPriceAsBoxedDouble()))
        {
            priceview.setPrice(ldsfield);
            return;
        }
    }

    protected static void updateTextValue(TextView textview, LdsField ldsfield)
    {
        ldsfield = ldsfield.getStringValue();
        if (ldsfield == null)
        {
            textview.setTextKeepState("");
        } else
        if (!ldsfield.equals(textview.getText().toString()))
        {
            textview.setTextKeepState(ldsfield);
            return;
        }
    }

    protected static void viewEnable(View view, boolean flag)
    {
        if (flag != view.isEnabled())
        {
            view.setEnabled(flag);
            if (view instanceof EditText)
            {
                view.setFocusable(flag);
                view.setFocusableInTouchMode(flag);
            }
        }
    }

    protected static void viewUpdate(View view, LdsField ldsfield)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (ldsfield != null)
        {
            flag = flag1;
            if (ldsfield.isEnabled())
            {
                flag = true;
            }
        }
        if (flag != view.isEnabled())
        {
            view.setEnabled(flag);
            if (view instanceof EditText)
            {
                view.setFocusable(flag);
                view.setFocusableInTouchMode(flag);
            }
        }
    }

    protected final void clearBackStack()
    {
        FragmentManager fragmentmanager = getFragmentManager();
        if (fragmentmanager.getBackStackEntryCount() > 0)
        {
            fragmentmanager.popBackStack(fragmentmanager.getBackStackEntryAt(0).getId(), 1);
        }
        getBaseActivity().setTitle(0x7f070b6a);
        ((CoreActivity)getActivity()).getSupportActionBar().setSubtitle(null);
    }

    protected abstract int getLayoutResource();

    public abstract int getTitleRes();

    protected void handleValidationError(String s)
    {
    }

    public void onBackPressed()
    {
        saveOutstandingChanges(false);
        View view = getView();
        if (view == null)
        {
            return;
        }
        Util.hideSoftInput(view.getContext(), view);
        if (getResources().getBoolean(0x7f0b0006))
        {
            getActivity().finish();
            return;
        } else
        {
            getFragmentManager().popBackStack();
            hideDoneButton(view);
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = (ViewGroup)layoutinflater.inflate(getLayoutResource(), viewgroup, false);
        layoutinflater.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        layoutinflater.setOnTouchListener(new android.view.View.OnTouchListener() {

            final BaseSpokeFragment this$0;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                return true;
            }

            
            {
                this$0 = BaseSpokeFragment.this;
                super();
            }
        });
        return layoutinflater;
    }

    public void onResume()
    {
        super.onResume();
        if (getArguments() != null && getArguments().containsKey("errorField"))
        {
            handleValidationError(getArguments().getString("errorField"));
            getArguments().remove("errorField");
        }
    }

    public void onStart()
    {
        super.onStart();
        if (!viewCreatedCalled)
        {
            Log.e("ListingFragments", "Must call super.onViewCreated");
            getActivity().finish();
        }
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        viewCreatedCalled = true;
        showDoneButton(view, getTitleRes(), new android.view.View.OnClickListener() {

            final BaseSpokeFragment this$0;

            public void onClick(View view1)
            {
                onBackPressed();
            }

            
            {
                this$0 = BaseSpokeFragment.this;
                super();
            }
        });
    }

    protected abstract void saveOutstandingChanges(boolean flag);

    protected final void showDiscardDialogFragment(int i)
    {
        com.ebay.app.AlertDialogFragment.Builder builder = new com.ebay.app.AlertDialogFragment.Builder();
        builder.setMessage(getActivity().getString(0x7f07013b)).setTitle(getActivity().getString(0x7f07013c)).setPositiveButton(0x7f070738).setNegativeButton(0x7f0701cc);
        builder.createFromFragment(i, this).show(getFragmentManager(), "discard");
    }
}
