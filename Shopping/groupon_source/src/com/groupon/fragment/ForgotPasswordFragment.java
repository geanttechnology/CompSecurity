// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.groupon.activity.Login;
import com.groupon.foundations.dialog.BaseDialogFragment;
import com.groupon.http.Http;
import com.groupon.models.country.Country;
import com.groupon.models.passwordreset.PasswordResetContainer;
import com.groupon.network.HttpResponseException;
import com.groupon.service.core.UserManager;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.view.SpinnerButton;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import roboguice.util.Strings;

public class ForgotPasswordFragment extends BaseDialogFragment
{
    protected class EndpointHttp extends Http
    {

        final ForgotPasswordFragment this$0;

        protected void onException(Exception exception)
        {
            reset.stopSpinning();
            int i;
            if (exception instanceof HttpResponseException)
            {
                i = ((HttpResponseException)exception).getStatusCode();
            } else
            {
                i = 900;
            }
            if (i == 404)
            {
                email.setError(getString(0x7f0801a0));
                return;
            }
            if (i == 401)
            {
                email.setError(getString(0x7f080163));
                return;
            } else
            {
                super.onException(exception);
                return;
            }
        }

        protected void onSuccess(PasswordResetContainer passwordresetcontainer)
            throws Exception
        {
            awaitingResetResponse = true;
            reset.stopSpinning();
            dismissKeyboard();
            passwordresetcontainer = new AlphaAnimation(1.0F, 0.0F);
            passwordresetcontainer.setDuration(duration);
            passwordresetcontainer.setAnimationListener(new ShowSecondAnimationOnAnimationEndListener());
            cancel.startAnimation(passwordresetcontainer);
            email.startAnimation(passwordresetcontainer);
            messageHint.startAnimation(passwordresetcontainer);
            title.startAnimation(passwordresetcontainer);
        }

        protected volatile void onSuccess(Object obj)
            throws Exception
        {
            onSuccess((PasswordResetContainer)obj);
        }

        public EndpointHttp(String s, String s1)
        {
            this$0 = ForgotPasswordFragment.this;
            super(getActivity(), com/groupon/models/passwordreset/PasswordResetContainer, s, new Object[] {
                "email_address", Strings.toString(email.getText()).trim(), "lang", s1
            });
        }
    }

    protected class EndpointHttp.ShowSecondAnimationOnAnimationEndListener
        implements android.view.animation.Animation.AnimationListener
    {

        final EndpointHttp this$1;

        public void onAnimationEnd(Animation animation)
        {
            secondAnimationSet();
        }

        public void onAnimationRepeat(Animation animation)
        {
        }

        public void onAnimationStart(Animation animation)
        {
        }

        protected EndpointHttp.ShowSecondAnimationOnAnimationEndListener()
        {
            this$1 = EndpointHttp.this;
            super();
        }
    }

    protected class ResetPasswordClickListener
        implements android.view.View.OnClickListener
    {

        protected final String lang;
        final ForgotPasswordFragment this$0;

        private String getEndpoint(boolean flag)
        {
            if (flag)
            {
                return "https:/password_reset?";
            } else
            {
                return "https:/users/password_reset?";
            }
        }

        public void onClick(View view)
        {
            view = email.getText().toString().trim();
            if (Strings.isEmpty(view) || !com.groupon.Constants.RegularExpressions.EMAIL_ADDRESS.matcher(view).matches())
            {
                email.setError(getString(0x7f08015f));
                return;
            }
            reset.startSpinning();
            view = currentCountryManager.getCurrentCountry();
            ForgotPasswordFragment forgotpasswordfragment = ForgotPasswordFragment.this;
            boolean flag;
            if (view.isUSACompatible() || view.isJapan())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            (forgotpasswordfragment. new EndpointHttp(getEndpoint(flag), lang)).method("POST").execute();
        }

        public ResetPasswordClickListener(String s)
        {
            this$0 = ForgotPasswordFragment.this;
            super();
            lang = s;
        }
    }


    private static final String AWAITING_RESET_RESPONSE_KEY = "awaitingResetResponse";
    private boolean awaitingResetResponse;
    Button cancel;
    private CurrentCountryManager currentCountryManager;
    private DeviceInfoUtil deviceInfoUtil;
    private int duration;
    AutoCompleteTextView email;
    private Logger logger;
    TextView messageHint;
    TextView messageThanks;
    LinearLayout options;
    SpinnerButton reset;
    TextView title;
    private UserManager userManager;
    private int widthPx;

    public ForgotPasswordFragment()
    {
        duration = 400;
        awaitingResetResponse = false;
    }

    private void dismissKeyboard()
    {
        ((InputMethodManager)getActivity().getSystemService("input_method")).hideSoftInputFromWindow(email.getWindowToken(), 0);
    }

    private void expandWidth(View view)
    {
        int i = getView().getWidth();
        int j = options.getPaddingLeft();
        int k = options.getPaddingRight();
        view.setVisibility(0);
        Animation animation = new Animation() {

            final ForgotPasswordFragment this$0;
            final int val$newTargetWidth;
            final View val$view;

            protected void applyTransformation(float f, Transformation transformation)
            {
                int l;
                int i1;
                if (f == 1.0F)
                {
                    l = newTargetWidth;
                } else
                {
                    l = (int)((float)newTargetWidth * f) + widthPx;
                }
                i1 = l;
                if (l > newTargetWidth)
                {
                    i1 = newTargetWidth;
                }
                view.getLayoutParams().width = i1;
                view.requestLayout();
            }

            public boolean willChangeBounds()
            {
                return true;
            }

            
            {
                this$0 = ForgotPasswordFragment.this;
                newTargetWidth = i;
                view = view1;
                super();
            }
        };
        animation.setDuration(duration);
        view.startAnimation(animation);
    }

    private void secondAnimationSet()
    {
        title.setText(0x7f080334);
        reset.setText(0x7f0804fe);
        cancel.setVisibility(4);
        reset.setOnClickListener(new android.view.View.OnClickListener() {

            final ForgotPasswordFragment this$0;

            public void onClick(View view)
            {
                dismiss();
            }

            
            {
                this$0 = ForgotPasswordFragment.this;
                super();
            }
        });
        AlphaAnimation alphaanimation = new AlphaAnimation(0.0F, 1.0F);
        alphaanimation.setDuration(duration);
        title.startAnimation(alphaanimation);
        widthPx = reset.getWidth();
        android.widget.LinearLayout.LayoutParams layoutparams = (android.widget.LinearLayout.LayoutParams)reset.getLayoutParams();
        layoutparams.weight = 0.0F;
        reset.setLayoutParams(layoutparams);
        reset.setWidth(widthPx);
        reset.setVisibility(0);
        cancel.setVisibility(8);
        expandWidth(reset);
        email.setVisibility(8);
        messageHint.setVisibility(8);
        messageThanks.setVisibility(0);
        messageThanks.startAnimation(alphaanimation);
    }

    protected Login getLoginRedesign()
    {
        return (Login)getActivity();
    }

    public void onActivityCreated(final Bundle v)
    {
        super.onActivityCreated(v);
        if (v != null)
        {
            awaitingResetResponse = v.getBoolean("awaitingResetResponse");
        }
        v = getView();
        if (v != null)
        {
            v.addOnLayoutChangeListener(new android.view.View.OnLayoutChangeListener() {

                final ForgotPasswordFragment this$0;
                final View val$v;

                public void onLayoutChange(View view, int i, int j, int k, int l, int i1, int j1, 
                        int k1, int l1)
                {
                    v.removeOnLayoutChangeListener(this);
                    if (awaitingResetResponse)
                    {
                        secondAnimationSet();
                    }
                }

            
            {
                this$0 = ForgotPasswordFragment.this;
                v = view;
                super();
            }
            });
        }
        email.setAdapter(new ArrayAdapter(getActivity(), 0x109000a, userManager.getDeviceEmailAccounts()));
        v = getLoginRedesign().getIsComingFromCheckout();
        String s = getLoginRedesign().getDealId();
        if (v != null && v.booleanValue())
        {
            logger.logClick("", "forgot_password_click", "checkout", s);
        } else
        {
            logger.logClick("", "forgot_password_click", "organic", "");
        }
        v = deviceInfoUtil.getLanguageFromLocale();
        reset.setOnClickListener(new ResetPasswordClickListener(v));
        cancel.setOnClickListener(new android.view.View.OnClickListener() {

            final ForgotPasswordFragment this$0;

            public void onClick(View view)
            {
                dismissKeyboard();
                dismiss();
            }

            
            {
                this$0 = ForgotPasswordFragment.this;
                super();
            }
        });
        getDialog().getWindow().setSoftInputMode(4);
    }

    public Dialog onCreateDialog(Bundle bundle)
    {
        bundle = super.onCreateDialog(bundle);
        bundle.getWindow().requestFeature(1);
        return bundle;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f0300e9, viewgroup, false);
        ButterKnife.bind(this, layoutinflater);
        return layoutinflater;
    }

    public void onDestroyView()
    {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("awaitingResetResponse", awaitingResetResponse);
    }



/*
    static boolean access$002(ForgotPasswordFragment forgotpasswordfragment, boolean flag)
    {
        forgotpasswordfragment.awaitingResetResponse = flag;
        return flag;
    }

*/





}
