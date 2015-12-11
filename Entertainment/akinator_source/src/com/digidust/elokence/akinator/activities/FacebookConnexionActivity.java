// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.digidust.elokence.akinator.factories.AkConfigFactory;
import com.digidust.elokence.akinator.factories.AkGameFactory;
import com.digidust.elokence.akinator.factories.AkLog;
import com.elokence.limuleapi.TraductionFactory;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import java.util.Arrays;
import java.util.Set;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            AkActivity, GameOverActivity, LeaderboardActivity

public class FacebookConnexionActivity extends AkActivity
    implements android.view.View.OnClickListener
{

    private static final String TAG = "FacebookConnexionActivity";
    private ImageView backButtonImage;
    private CallbackManager callbackManager;
    private boolean canContinue;
    private TextView contentTextFacebook;
    protected LoginButton loginButton;

    public FacebookConnexionActivity()
    {
        canContinue = true;
    }

    private void onBack()
    {
        if (AkGameFactory.sharedInstance().comeFrom() == 0)
        {
            goToHome(false);
            return;
        }
        if (AkGameFactory.sharedInstance().comeFrom() == 1)
        {
            startActivity(new Intent(this, com/digidust/elokence/akinator/activities/GameOverActivity));
            finish();
            return;
        } else
        {
            goToHome(false);
            return;
        }
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        callbackManager.onActivityResult(i, j, intent);
    }

    public void onBackPressed()
    {
        onBack();
    }

    public void onClick(View view)
    {
        if (view == backButtonImage)
        {
            onBack();
        } else
        if (view == loginButton)
        {
            disableAdOneTime();
            AkConfigFactory.sharedInstance().setCanSendAnalytics(false);
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030021);
        backButtonImage = (ImageView)findViewById(0x7f0d00ba);
        backButtonImage.setOnClickListener(this);
        loginButton = (LoginButton)findViewById(0x7f0d00e6);
        loginButton.setOnClickListener(this);
        loginButton.clearPermissions();
        loginButton.setReadPermissions(new String[] {
            "user_friends"
        });
        callbackManager = com.facebook.CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback() {

            final FacebookConnexionActivity this$0;

            public void onCancel()
            {
                disableAdOneTime();
                AkLog.d("FacebookConnexionActivity", "Facebook log cancel");
                canContinue = false;
            }

            public void onError(FacebookException facebookexception)
            {
                disableAdOneTime();
                AkLog.d("FacebookConnexionActivity", (new StringBuilder()).append("Facebook log error  : ").append(facebookexception.toString()).toString());
                canContinue = false;
            }

            public void onSuccess(LoginResult loginresult)
            {
                disableAdOneTime();
                AkLog.d("FacebookConnexionActivity", "Facebook log Ok");
                canContinue = true;
                loginresult = new Bundle();
                loginresult.putString("fields", "birthday, gender");
            /* block-local class not found */
            class _cls1 {}

                GraphRequest graphrequest = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new _cls1());
                graphrequest.setParameters(loginresult);
                graphrequest.executeAsync();
            }

            public volatile void onSuccess(Object obj)
            {
                onSuccess((LoginResult)obj);
            }

            
            {
                this$0 = FacebookConnexionActivity.this;
                super();
            }
        });
        contentTextFacebook = (TextView)findViewById(0x7f0d00e5);
        contentTextFacebook.setText(TraductionFactory.sharedInstance().getTraductionFromToken(TraductionFactory.sharedInstance().getTraductionFromToken("CONNECTE_TOI_A_FACEBOOK")));
        contentTextFacebook.setTypeface(tf);
        addTextView(contentTextFacebook);
        updateTextViewsSize();
    }

    public void onResume()
    {
label0:
        {
label1:
            {
label2:
                {
label3:
                    {
                        super.onResume();
                        if (AccessToken.getCurrentAccessToken() != null)
                        {
                            boolean flag = AccessToken.getCurrentAccessToken().getPermissions().contains("user_friends");
                            boolean flag1 = AccessToken.getCurrentAccessToken().getPermissions().contains("publish_actions");
                            if (!canContinue && !flag)
                            {
                                break label0;
                            }
                            if (!flag)
                            {
                                break label1;
                            }
                            if (!canContinue && !flag1)
                            {
                                break label2;
                            }
                            if (!flag1)
                            {
                                break label3;
                            }
                            startActivity(new Intent(this, com/digidust/elokence/akinator/activities/LeaderboardActivity));
                            finish();
                        }
                        return;
                    }
                    LoginManager.getInstance().setDefaultAudience(DefaultAudience.FRIENDS).logInWithPublishPermissions(this, Arrays.asList(new String[] {
                        "publish_actions"
                    }));
                    return;
                }
                Toast.makeText(this, TraductionFactory.sharedInstance().getTraductionFromToken("MERCI_ACCEPTER_AUTORISATION_FACEBOOK"), 1).show();
                onBack();
                return;
            }
            LoginManager.getInstance().setDefaultAudience(DefaultAudience.FRIENDS).logInWithReadPermissions(this, Arrays.asList(new String[] {
                "user_friends"
            }));
            return;
        }
        Toast.makeText(this, TraductionFactory.sharedInstance().getTraductionFromToken("MERCI_ACCEPTER_AUTORISATION_FACEBOOK"), 1).show();
        onBack();
    }


/*
    static boolean access$002(FacebookConnexionActivity facebookconnexionactivity, boolean flag)
    {
        facebookconnexionactivity.canContinue = flag;
        return flag;
    }

*/
}
