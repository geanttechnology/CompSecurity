// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import co.vine.android.client.AppController;
import co.vine.android.client.AppSessionListener;
import co.vine.android.util.Util;

// Referenced classes of package co.vine.android:
//            BaseControllerFragment, ConfirmationFlowActivity, FindFriendsNUXActivity

public class ConfirmationFlowVerificationFragment extends BaseControllerFragment
    implements android.view.View.OnClickListener
{
    private class ConfirmationSessionListener extends AppSessionListener
    {

        final ConfirmationFlowVerificationFragment this$0;

        public void onRequestPhoneVerificationComplete(String s, int i, String s1, String s2)
        {
            s = getActivity();
            mHandler.postDelayed(mSendAgainRunnable, 10000L);
            if (i == 200 && mSentAgain)
            {
                Util.showCenteredToast(s, getString(0x7f0e0085, new Object[] {
                    s2
                }));
            } else
            if (!TextUtils.isEmpty(s1))
            {
                Util.showCenteredToast(s, s1);
                return;
            }
        }

        public void onVerifyPhoneNumberComplete(String s, int i, String s1)
        {
            s = getActivity();
            showProgressBar(false);
            toggleDoneAction(true);
            if (i == 200)
            {
                Util.showCenteredToast(s, 0x7f0e008b);
                getActivity().setResult(1527);
                getActivity().finish();
                return;
            }
            toggleErrorMessage(true);
            if (!TextUtils.isEmpty(s1))
            {
                mErrorMessage.setText(s1);
                return;
            } else
            {
                mErrorMessage.setText(0x7f0e0087);
                return;
            }
        }

        private ConfirmationSessionListener()
        {
            this$0 = ConfirmationFlowVerificationFragment.this;
            super();
        }

    }


    public static final String ARG_FROM_SIGNUP = "from_sign_up";
    public static final String ARG_PHONE_NUMBER = "phone_number";
    private static final long SEND_AGAIN_DELAY_MS = 10000L;
    private static final long TRANSITION_DELAY_MS = 500L;
    private EditText mConfirmationBox;
    private MenuItem mDone;
    private TextView mErrorMessage;
    private Animation mFadeInAnimation;
    private android.view.animation.Animation.AnimationListener mFadeListener;
    private Animation mFadeOutAnimation;
    private View mFadingIn;
    private View mFadingOut;
    private boolean mFromSignup;
    private Handler mHandler;
    private TextView mMessage;
    private String mPhone;
    private ProgressBar mProgressBar;
    private View mSendAgain;
    private Runnable mSendAgainRunnable;
    private boolean mSentAgain;
    private Runnable mShowMessageRunnable;

    public ConfirmationFlowVerificationFragment()
    {
        mShowMessageRunnable = new Runnable() {

            final ConfirmationFlowVerificationFragment this$0;

            public void run()
            {
                toggleErrorMessage(false);
            }

            
            {
                this$0 = ConfirmationFlowVerificationFragment.this;
                super();
            }
        };
        mSendAgainRunnable = new Runnable() {

            final ConfirmationFlowVerificationFragment this$0;

            public void run()
            {
                mSendAgain.setOnClickListener(ConfirmationFlowVerificationFragment.this);
            }

            
            {
                this$0 = ConfirmationFlowVerificationFragment.this;
                super();
            }
        };
        mFadeListener = new android.view.animation.Animation.AnimationListener() {

            final ConfirmationFlowVerificationFragment this$0;

            public void onAnimationEnd(Animation animation)
            {
                if (mFadingIn != null)
                {
                    mFadingIn.setVisibility(0);
                }
                if (mFadingOut != null)
                {
                    mFadingOut.setVisibility(4);
                }
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                this$0 = ConfirmationFlowVerificationFragment.this;
                super();
            }
        };
    }

    private void clearTextViewAnimations()
    {
        mMessage.clearAnimation();
        mErrorMessage.clearAnimation();
    }

    private void showProgressBar(boolean flag)
    {
        if (mProgressBar != null)
        {
            ProgressBar progressbar = mProgressBar;
            int i;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            progressbar.setVisibility(i);
        }
    }

    private void toggleDoneAction(boolean flag)
    {
        if (mDone != null)
        {
            mDone.setEnabled(flag);
        }
    }

    private void toggleErrorMessage(boolean flag)
    {
        if (mMessage != null && mErrorMessage != null)
        {
            clearTextViewAnimations();
            if (flag && mErrorMessage.getVisibility() != 0)
            {
                mMessage.startAnimation(mFadeOutAnimation);
                mErrorMessage.startAnimation(mFadeInAnimation);
                mFadingIn = mErrorMessage;
                mFadingOut = mMessage;
                return;
            }
            if (!flag && mMessage.getVisibility() != 0)
            {
                mMessage.startAnimation(mFadeInAnimation);
                mErrorMessage.startAnimation(mFadeOutAnimation);
                mFadingIn = mMessage;
                mFadingOut = mErrorMessage;
                return;
            }
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (!mFromSignup && !TextUtils.isEmpty(mPhone))
        {
            ConfirmationFlowActivity.requestPhoneVerification(mAppController, mPhone);
        }
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131361929: 
            mSentAgain = true;
            ConfirmationFlowActivity.requestPhoneVerification(mAppController, mPhone);
            mHandler.postDelayed(mShowMessageRunnable, 500L);
            mSendAgain.setOnClickListener(null);
            return;

        case 2131361930: 
            FindFriendsNUXActivity.start(getActivity());
            break;
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mAppSessionListener = new ConfirmationSessionListener();
        setHasOptionsMenu(true);
        mHandler = new Handler(Looper.getMainLooper());
        mFadeOutAnimation = AnimationUtils.loadAnimation(getActivity(), 0x7f040010);
        mFadeOutAnimation.setAnimationListener(mFadeListener);
        mFadeInAnimation = AnimationUtils.loadAnimation(getActivity(), 0x7f04000e);
        mFadeInAnimation.setAnimationListener(mFadeListener);
        bundle = getArguments();
        if (bundle != null)
        {
            mPhone = bundle.getString("phone_number", "");
            mFromSignup = bundle.getBoolean("from_sign_up", false);
        }
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        menuinflater.inflate(0x7f100004, menu);
        mDone = menu.findItem(0x7f0a0245);
        super.onCreateOptionsMenu(menu, menuinflater);
    }

    public View onCreateView(LayoutInflater layoutinflater, final ViewGroup confirmationBox, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030028, confirmationBox, false);
        if (layoutinflater == null)
        {
            return null;
        }
        ((TextView)layoutinflater.findViewById(0x7f0a0086)).setText(getString(0x7f0e0088, new Object[] {
            mPhone
        }));
        if (mFromSignup)
        {
            confirmationBox = layoutinflater.findViewById(0x7f0a008a);
            confirmationBox.setVisibility(0);
            confirmationBox.setOnClickListener(this);
        }
        confirmationBox = (EditText)layoutinflater.findViewById(0x7f0a0085);
        confirmationBox.addTextChangedListener(new TextWatcher() {

            final ConfirmationFlowVerificationFragment this$0;
            final EditText val$confirmationBox;

            public void afterTextChanged(Editable editable)
            {
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
                if (!TextUtils.isEmpty(confirmationBox.getText()))
                {
                    toggleDoneAction(true);
                    return;
                } else
                {
                    toggleDoneAction(false);
                    return;
                }
            }

            
            {
                this$0 = ConfirmationFlowVerificationFragment.this;
                confirmationBox = edittext;
                super();
            }
        });
        mConfirmationBox = confirmationBox;
        mMessage = (TextView)layoutinflater.findViewById(0x7f0a0086);
        mErrorMessage = (TextView)layoutinflater.findViewById(0x7f0a0087);
        mSendAgain = layoutinflater.findViewById(0x7f0a0089);
        mProgressBar = (ProgressBar)layoutinflater.findViewById(0x7f0a0088);
        return layoutinflater;
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        boolean flag = false;
        menuitem.getItemId();
        JVM INSTR tableswitch 2131362373 2131362373: default 28
    //                   2131362373 36;
           goto _L1 _L2
_L1:
        flag = super.onOptionsItemSelected(menuitem);
_L4:
        return flag;
_L2:
        Editable editable = mConfirmationBox.getText();
        if (editable != null)
        {
            showProgressBar(true);
            menuitem.setEnabled(false);
            mAppController.verifyPhoneNumber(mAppController.getActiveSession(), editable.toString());
            return true;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onPause()
    {
        super.onPause();
        mHandler.removeCallbacks(mShowMessageRunnable);
        mHandler.removeCallbacks(mSendAgainRunnable);
        Util.setSoftKeyboardVisibility(getActivity(), mConfirmationBox, false);
    }

    public void onResume()
    {
        super.onResume();
        mSendAgain.setOnClickListener(this);
    }










}
