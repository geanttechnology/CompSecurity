// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;
import my.googlemusic.play.application.App;
import my.googlemusic.play.interfaces.Server;
import my.googlemusic.play.internet.Connection;
import my.googlemusic.play.internet.Response;
import my.googlemusic.play.model.User;
import my.googlemusic.play.utils.CompatibilityUtil;
import my.googlemusic.play.utils.animations.AnimationBackgroundView;
import my.googlemusic.play.utils.dialog.DialogGooglePlusError;
import my.googlemusic.play.utils.toast.Toast;
import my.googlemusic.play.utils.toast.ToastCreator;

// Referenced classes of package my.googlemusic.play.activities:
//            ManagerActivity, ForgotPasswordActivity, CreateAccountStepOneActivity

public class LoginActivity extends ActionBarActivity
    implements android.view.View.OnClickListener, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener, android.view.View.OnFocusChangeListener
{
    static class ViewHolder
    {

        View background;
        View backgroundTransition;
        View container;
        TextView createAccount;
        TextView forgotPassword;
        ProgressBar loading;
        ProgressBar loadingGoogle;
        TextView loadingMessage;
        EditText login;
        EditText password;
        TextView progress;
        LinearLayout recover;
        View selectorEmail;
        View selectorPassword;
        Button sign;
        Button signInGoogle;
        View skip;

        ViewHolder()
        {
        }
    }


    static final boolean $assertionsDisabled;
    public static final String EXTRA_REGISTER = "register";
    public static final String EXTRA_WEB_LINK = "web_link";
    private static final int SIGN_IN_REQUIRED = 4;
    private AnimationBackgroundView animationBackgroundView;
    private ConnectionResult mConnectionResult;
    private GoogleApiClient mGoogleApiClient;
    private ViewHolder mHolder;
    private boolean mIntentInProgress;
    private Server mServer;
    private boolean mSignInClicked;
    private String mWeblink;
    private long pushIdAlbum;
    private long pushIdTarget;
    private int pushType;

    public LoginActivity()
    {
    }

    private void initApplication()
    {
        if (mServer.isLogged())
        {
            initManager();
            return;
        } else
        {
            mSignInClicked = false;
            onConnected(null);
            return;
        }
    }

    private void initData()
    {
        Object obj = getIntent();
        if ("android.intent.action.VIEW".equals(((Intent) (obj)).getAction()))
        {
            mWeblink = (new StringBuilder()).append(((Intent) (obj)).getData().getScheme()).append(":").append(((Intent) (obj)).getData().getSchemeSpecificPart()).toString();
        } else
        {
            mWeblink = null;
        }
        mGoogleApiClient = (new com.google.android.gms.common.api.GoogleApiClient.Builder(this)).addConnectionCallbacks(this).addOnConnectionFailedListener(this).addApi(Plus.API).addScope(Plus.SCOPE_PLUS_LOGIN).build();
        obj = getIntent().getExtras();
        if (obj != null)
        {
            pushType = getIntent().getExtras().getInt("push_type", -1);
            pushIdAlbum = getIntent().getExtras().getLong("push_id_album", -2L);
            pushIdTarget = getIntent().getExtras().getLong("push_id_target", -3L);
            if (((Bundle) (obj)).getBoolean("register"))
            {
                initRegister();
            }
        }
        mServer = ((App)getApplication()).getServer();
        if (CompatibilityUtil.getSdkVersion() > 15)
        {
            animationBackgroundView = new AnimationBackgroundView(mHolder.background, mHolder.backgroundTransition);
        }
    }

    private void initManager()
    {
        startActivity((new Intent(this, my/googlemusic/play/activities/ManagerActivity)).setData(getIntent().getData()).putExtra("web_link", mWeblink).putExtra("push_type", pushType).putExtra("push_id_album", pushIdAlbum).putExtra("push_id_target", pushIdTarget));
        finish();
    }

    private void initRecover()
    {
        startActivity(new Intent(this, my/googlemusic/play/activities/ForgotPasswordActivity));
    }

    private void initRegister()
    {
        startActivity(new Intent(this, my/googlemusic/play/activities/CreateAccountStepOneActivity));
    }

    private void initView()
    {
        if (CompatibilityUtil.getSdkVersion() >= 19)
        {
            getWindow().setFlags(0x4000000, 0x4000000);
        }
        mHolder.container = findViewById(0x7f0d0240);
        mHolder.progress = (TextView)findViewById(0x7f0d0243);
        mHolder.sign = (Button)findViewById(0x7f0d0248);
        mHolder.loading = (ProgressBar)findViewById(0x7f0d0241);
        mHolder.loadingGoogle = (ProgressBar)findViewById(0x7f0d024a);
        mHolder.signInGoogle = (Button)findViewById(0x7f0d0249);
        mHolder.createAccount = (TextView)findViewById(0x7f0d024c);
        mHolder.login = (EditText)findViewById(0x7f0d0244);
        mHolder.loadingMessage = (TextView)findViewById(0x7f0d0242);
        mHolder.forgotPassword = (TextView)findViewById(0x7f0d024e);
        mHolder.recover = (LinearLayout)findViewById(0x7f0d024d);
        mHolder.password = (EditText)findViewById(0x7f0d0246);
        mHolder.skip = findViewById(0x7f0d00ee);
        mHolder.selectorEmail = findViewById(0x7f0d0245);
        mHolder.selectorPassword = findViewById(0x7f0d0247);
        mHolder.background = findViewById(0x7f0d00ec);
        mHolder.backgroundTransition = findViewById(0x7f0d00ed);
        mHolder.login.setOnFocusChangeListener(this);
        mHolder.password.setOnFocusChangeListener(this);
        mHolder.skip.setOnClickListener(this);
        mHolder.sign.setOnClickListener(this);
        mHolder.recover.setOnClickListener(this);
        mHolder.signInGoogle.setOnClickListener(this);
        mHolder.createAccount.setOnClickListener(this);
        mHolder.forgotPassword.setOnClickListener(this);
    }

    private void resolveSignInError()
    {
        if (mConnectionResult == null || !mConnectionResult.hasResolution())
        {
            break MISSING_BLOCK_LABEL_31;
        }
        mIntentInProgress = true;
        mConnectionResult.startResolutionForResult(this, 4);
        return;
        android.content.IntentSender.SendIntentException sendintentexception;
        sendintentexception;
        mIntentInProgress = false;
        mGoogleApiClient.connect();
        return;
    }

    private void setButtonEnabled(boolean flag)
    {
        Object obj;
        int i;
        if (flag)
        {
            obj = "Login";
        } else
        {
            obj = "Sign in";
        }
        mHolder.sign.setText(((CharSequence) (obj)));
        mHolder.sign.setEnabled(flag);
        obj = mHolder.sign;
        if (flag)
        {
            i = getResources().getColor(0x7f0c0020);
        } else
        {
            i = getResources().getColor(0x7f0c0025);
        }
        ((Button) (obj)).setTextColor(i);
    }

    private void signInAccount()
    {
        if (!Connection.with(this).isConnected())
        {
            Toast.with(this).message("No connection.").show();
            return;
        }
        android.text.Editable editable = mHolder.login.getText();
        android.text.Editable editable1 = mHolder.password.getText();
        if (!$assertionsDisabled && editable == null)
        {
            throw new AssertionError();
        }
        if (!$assertionsDisabled && editable1 == null)
        {
            throw new AssertionError();
        }
        if (editable.toString().isEmpty() || editable1.toString().isEmpty())
        {
            Toast.with(this).message("Invalid username / password. ").show();
            return;
        }
        if (editable.toString().contains("#") || editable1.toString().contains("#"))
        {
            Toast.with(this).message("Invalid username / password. ").show();
            return;
        }
        if (editable.toString().contains("&") || editable1.toString().contains("&"))
        {
            Toast.with(this).message("Invalid username / password. ").show();
            return;
        }
        if (editable.toString().contains("/") || editable1.toString().contains("/"))
        {
            Toast.with(this).message("Invalid username / password. ").show();
            return;
        }
        if (editable.toString().contains("$") || editable1.toString().contains("$"))
        {
            Toast.with(this).message("Invalid username / password. ").show();
            return;
        }
        if (editable.toString().contains("%") || editable1.toString().contains("%"))
        {
            Toast.with(this).message("Invalid username / password. ").show();
            return;
        }
        if (editable.toString().contains("?") || editable1.toString().contains("?"))
        {
            Toast.with(this).message("Invalid username / password. ").show();
            return;
        } else
        {
            setButtonEnabled(false);
            mServer.login(editable.toString(), editable1.toString(), new my.googlemusic.play.interfaces.Server.Callback() {

                final LoginActivity this$0;

                public void onFailure(Response response)
                {
                    if (response.getStatus() == 7)
                    {
                        Toast.with(LoginActivity.this).message(response.getContent()).show();
                    }
                    setButtonEnabled(true);
                }

                public void onProgress(int i)
                {
                }

                public void onSuccess(Object obj)
                {
                    if (obj instanceof User)
                    {
                        initManager();
                    }
                }

            
            {
                this$0 = LoginActivity.this;
                super();
            }
            });
            return;
        }
    }

    private void signSkip()
    {
        mServer.loginSkip();
        initManager();
    }

    public void dismissKeyboard(EditText edittext)
    {
        ((InputMethodManager)getSystemService("input_method")).hideSoftInputFromWindow(edittext.getWindowToken(), 0);
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 4)
        {
            mIntentInProgress = false;
            if (mGoogleApiClient != null && !mGoogleApiClient.isConnecting())
            {
                mGoogleApiClient.connect();
            }
        }
    }

    public void onClick(View view)
    {
        if (view.getId() != mHolder.signInGoogle.getId()) goto _L2; else goto _L1
_L1:
        if (mGoogleApiClient == null || mGoogleApiClient.isConnecting()) goto _L4; else goto _L3
_L3:
        mSignInClicked = true;
        resolveSignInError();
_L6:
        return;
_L4:
        openGooglePlus();
        return;
_L2:
        if (view.getId() == mHolder.sign.getId())
        {
            dismissKeyboard(mHolder.password);
            signInAccount();
            return;
        }
        if (view.getId() == mHolder.skip.getId())
        {
            signSkip();
            return;
        }
        if (view.getId() == mHolder.forgotPassword.getId())
        {
            initRecover();
            return;
        }
        if (view.getId() == mHolder.createAccount.getId())
        {
            initRegister();
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onConnected(Bundle bundle)
    {
        if (mGoogleApiClient != null && mSignInClicked && mGoogleApiClient.isConnected())
        {
            bundle = Plus.PeopleApi.getCurrentPerson(mGoogleApiClient);
            if (bundle != null)
            {
                mServer.loginGoogle(bundle.getId(), Plus.AccountApi.getAccountName(mGoogleApiClient), bundle.getDisplayName(), bundle.getName().getFamilyName(), bundle.getNickname(), String.valueOf(bundle.getGender()), bundle.getBirthday(), bundle.getLanguage(), bundle.getImage().toString(), new my.googlemusic.play.interfaces.Server.Callback() {

                    final LoginActivity this$0;

                    public void onFailure(Response response)
                    {
                        if (response.getStatus() == 7)
                        {
                            Toast.with(LoginActivity.this).message("An error has occurred on our server, try again later").show();
                        }
                    }

                    public void onProgress(int i)
                    {
                    }

                    public void onSuccess(Object obj)
                    {
                        if (obj instanceof User)
                        {
                            initManager();
                            Toast.with(LoginActivity.this).message((new StringBuilder()).append("welcome ").append(((User)obj).getName()).toString()).show();
                        }
                    }

            
            {
                this$0 = LoginActivity.this;
                super();
            }
                });
            }
        }
    }

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        if (!mIntentInProgress)
        {
            mConnectionResult = connectionresult;
            if (mSignInClicked)
            {
                resolveSignInError();
            }
        }
    }

    public void onConnectionSuspended(int i)
    {
        mGoogleApiClient.connect();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        getSupportActionBar().hide();
        setContentView(0x7f03002c);
        mHolder = new ViewHolder();
        initView();
        initData();
        initApplication();
    }

    public void onFocusChange(View view, boolean flag)
    {
        if (view.getId() == mHolder.login.getId())
        {
            mHolder.selectorEmail.setBackgroundColor(getResources().getColor(0x7f0c003c));
            mHolder.selectorPassword.setBackgroundColor(getResources().getColor(0x7f0c003d));
        } else
        if (view.getId() == mHolder.password.getId())
        {
            mHolder.selectorEmail.setBackgroundColor(getResources().getColor(0x7f0c003d));
            mHolder.selectorPassword.setBackgroundColor(getResources().getColor(0x7f0c003c));
            return;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        return i == 82 || super.onKeyDown(i, keyevent);
    }

    protected void onPause()
    {
        super.onPause();
        if (CompatibilityUtil.getSdkVersion() > 15)
        {
            animationBackgroundView.setAnimationActive(Boolean.valueOf(false));
        }
    }

    protected void onResume()
    {
        super.onResume();
        if (CompatibilityUtil.getSdkVersion() > 15)
        {
            animationBackgroundView.setAnimationActive(Boolean.valueOf(true));
            animationBackgroundView.animatedBackground(1, 0);
        }
    }

    protected void onStart()
    {
        super.onStart();
        if (mGoogleApiClient != null)
        {
            mGoogleApiClient.connect();
        }
    }

    protected void onStop()
    {
        super.onStop();
        if (mGoogleApiClient != null && mGoogleApiClient.isConnected())
        {
            mGoogleApiClient.disconnect();
        }
    }

    public void openGooglePlus()
    {
        (new DialogGooglePlusError()).show(getSupportFragmentManager(), null);
    }

    static 
    {
        boolean flag;
        if (!my/googlemusic/play/activities/LoginActivity.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }


}
