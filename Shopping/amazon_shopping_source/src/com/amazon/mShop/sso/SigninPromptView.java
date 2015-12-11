// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.util.ActivityUtils;

// Referenced classes of package com.amazon.mShop.sso:
//            SSOUtil, IdentityType

public class SigninPromptView extends ScrollView
{

    private AmazonActivity mActivity;
    private Button mNewUser;
    private Button mSigninButton;
    private Button mSkipButton;

    public SigninPromptView(AmazonActivity amazonactivity)
    {
        super(amazonactivity);
        mActivity = amazonactivity;
        amazonactivity = (ViewGroup)LayoutInflater.from(amazonactivity).inflate(com.amazon.mShop.android.lib.R.layout.signin_prompt_view, null);
        mSigninButton = (Button)amazonactivity.findViewById(com.amazon.mShop.android.lib.R.id.sign_in_button);
        mSkipButton = (Button)amazonactivity.findViewById(com.amazon.mShop.android.lib.R.id.skip_sign_in_button);
        mNewUser = (Button)amazonactivity.findViewById(com.amazon.mShop.android.lib.R.id.new_user);
        mSigninButton.setOnClickListener(new android.view.View.OnClickListener() {

            final SigninPromptView this$0;

            public void onClick(View view)
            {
                if (SSOUtil.getCurrentIdentityType() != IdentityType.NON_SSO_TYPE)
                {
                    SSOUtil.getCurrentIdentityType().handleSSOLogin(mActivity, true, false, false, null);
                } else
                {
                    ActivityUtils.startLoginActivityForResult(mActivity, 0, null, false, true, false, null);
                }
                RefMarkerObserver.logRefMarker("sps_sign_in");
            }

            
            {
                this$0 = SigninPromptView.this;
                super();
            }
        });
        mSkipButton.setOnClickListener(new android.view.View.OnClickListener() {

            final SigninPromptView this$0;

            public void onClick(View view)
            {
                mActivity.finish();
                SSOUtil.skipSigin(mActivity);
                RefMarkerObserver.logRefMarker("sps_skip_sign_in");
            }

            
            {
                this$0 = SigninPromptView.this;
                super();
            }
        });
        mNewUser.setOnClickListener(new android.view.View.OnClickListener() {

            final SigninPromptView this$0;

            public void onClick(View view)
            {
                if (SSOUtil.getCurrentIdentityType() != IdentityType.NON_SSO_TYPE)
                {
                    SSOUtil.getCurrentIdentityType().handleSSOLogin(mActivity, true, false, true, null);
                } else
                {
                    ActivityUtils.startLoginActivityForResult(mActivity, 0, null, false, true, true, null);
                }
                RefMarkerObserver.logRefMarker("sps_new_account");
            }

            
            {
                this$0 = SigninPromptView.this;
                super();
            }
        });
        addView(amazonactivity);
    }

}
