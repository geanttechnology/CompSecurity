// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.arellomobile.android.push.BasePushMessageReceiver;
import com.arellomobile.android.push.PushManager;
import com.arellomobile.android.push.utils.RegisterBroadcastReceiver;
import com.bitstrips.imoji.InjectorApplication;
import com.bitstrips.imoji.analytics.Action;
import com.bitstrips.imoji.analytics.AnalyticsService;
import com.bitstrips.imoji.analytics.Category;
import com.bitstrips.imoji.api.BitstripsService;
import com.bitstrips.imoji.auth.FacebookService;
import com.bitstrips.imoji.manager.TemplatesManager;
import com.bitstrips.imoji.models.AvatarInfo;
import com.bitstrips.imoji.models.OutfitBuilderCatalogs;
import com.bitstrips.imoji.models.Templates;
import com.bitstrips.imoji.services.B4MService;
import com.bitstrips.imoji.services.OutfitSaverService;
import com.bitstrips.imoji.util.PreferenceUtils;
import com.bitstrips.outfitbuilder.services.OBAssetsPreloaderIntentService;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import java.util.Arrays;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

// Referenced classes of package com.bitstrips.imoji.ui:
//            BSLoginActivity, SignUpActivity, IntentCreatorService

public class LoginActivity extends AppCompatActivity
{

    public static final int LOGIN_REQUEST_CODE = 2;
    public static final int RETRIEVE_AVATAR_REQUEST_CODE = 3;
    public static final int SIGN_UP_REQUEST_CODE = 1;
    private static final String TAG = "LoginActivity";
    AnalyticsService analytics;
    B4MService b4MService;
    BitstripsService bitstripsService;
    FacebookService facebookService;
    IntentCreatorService intentCreatorService;
    private boolean isPaused;
    BroadcastReceiver mBroadcastReceiver;
    private BroadcastReceiver mReceiver;
    PreferenceUtils preferenceUtils;
    TemplatesManager templatesManager;

    public LoginActivity()
    {
        isPaused = false;
        mBroadcastReceiver = new RegisterBroadcastReceiver() {

            final LoginActivity this$0;

            public void onRegisterActionReceive(Context context, Intent intent)
            {
                checkMessage(intent);
            }

            
            {
                this$0 = LoginActivity.this;
                super();
            }
        };
        mReceiver = new BasePushMessageReceiver() {

            final LoginActivity this$0;

            protected void onMessageReceive(Intent intent)
            {
                logMessage((new StringBuilder()).append("push message is ").append(intent.getExtras().getString("pw_data_json_string")).toString());
            }

            
            {
                this$0 = LoginActivity.this;
                super();
            }
        };
    }

    private void checkMessage(Intent intent)
    {
        if (intent == null) goto _L2; else goto _L1
_L1:
        if (!intent.hasExtra("PUSH_RECEIVE_EVENT")) goto _L4; else goto _L3
_L3:
        logMessage((new StringBuilder()).append("push message is ").append(intent.getExtras().getString("PUSH_RECEIVE_EVENT")).toString());
_L6:
        resetIntentValues();
_L2:
        return;
_L4:
        if (intent.hasExtra("REGISTER_EVENT"))
        {
            logMessage("register");
        } else
        if (intent.hasExtra("UNREGISTER_EVENT"))
        {
            logMessage("unregister");
        } else
        if (intent.hasExtra("REGISTER_ERROR_EVENT"))
        {
            logMessage("register error");
        } else
        if (intent.hasExtra("UNREGISTER_ERROR_EVENT"))
        {
            logMessage("unregister error");
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void displayErrorDialog(boolean flag, android.content.DialogInterface.OnClickListener onclicklistener)
    {
        if (isPaused || isFinishing())
        {
            return;
        }
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle(getString(0x7f06006d)).setMessage(0x7f06006c).setPositiveButton(0x7f060079, onclicklistener);
        if (flag)
        {
            builder.setNegativeButton(0x1040000, null);
        } else
        {
            builder.setCancelable(false);
        }
        builder.show();
    }

    private void getAvatarInfo()
    {
        String s = facebookService.getToken();
        String s1 = preferenceUtils.getString(0x7f06003a, null);
        String s2 = getString(0x7f060017);
        bitstripsService.getAvatarInfo(s, s1, s2, new Callback() {

            final LoginActivity this$0;

            public void failure(RetrofitError retrofiterror)
            {
                displayErrorDialog(true, new android.content.DialogInterface.OnClickListener() {

                    final _cls4 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        getAvatarInfo();
                    }

            
            {
                this$1 = _cls4.this;
                super();
            }
                });
            }

            public void success(AvatarInfo avatarinfo, Response response)
            {
                preferenceUtils.putString(0x7f06002a, avatarinfo.getId());
                preferenceUtils.putBoolean(0x7f06008a, avatarinfo.hasBSAuthAccount());
                resolveNextActivityForUser();
            }

            public volatile void success(Object obj, Response response)
            {
                success((AvatarInfo)obj, response);
            }

            
            {
                this$0 = LoginActivity.this;
                super();
            }
        });
    }

    private boolean hasAvatar()
    {
        return !TextUtils.isEmpty(preferenceUtils.getString(0x7f06002a, null));
    }

    private boolean hasBSAuth()
    {
        return preferenceUtils.getBoolean(0x7f06008a, false);
    }

    private void initOutfitSaverService()
    {
        startService(new Intent(this, com/bitstrips/imoji/services/OutfitSaverService));
    }

    private void initPushManager()
    {
        registerReceivers();
        PushManager pushmanager = PushManager.getInstance(this);
        try
        {
            pushmanager.onStartup(this);
        }
        catch (Exception exception) { }
        pushmanager.registerForPushNotifications();
        checkMessage(getIntent());
    }

    private void initTemplates()
    {
        com.bitstrips.imoji.manager.TemplatesManager.SuccessCallback successcallback = new com.bitstrips.imoji.manager.TemplatesManager.SuccessCallback() {

            final LoginActivity this$0;

            public void success(Templates templates, Response response)
            {
                onTemplatesReady();
                OBAssetsPreloaderIntentService.startActionFetchCatalogAssets(getApplicationContext(), templates.getOutfitBuilderData().getMaleCatalog(), templates.getOutfitBuilderData().getFemaleCatalog());
            }

            public volatile void success(Object obj, Response response)
            {
                success((Templates)obj, response);
            }

            
            {
                this$0 = LoginActivity.this;
                super();
            }
        };
        com.bitstrips.imoji.manager.TemplatesManager.FailureCallback failurecallback = new com.bitstrips.imoji.manager.TemplatesManager.FailureCallback() {

            final LoginActivity this$0;

            public void failure(RetrofitError retrofiterror)
            {
                displayErrorDialog(false, new android.content.DialogInterface.OnClickListener() {

                    final _cls2 this$1;

                    public void onClick(DialogInterface dialoginterface, int i)
                    {
                        initTemplates();
                    }

            
            {
                this$1 = _cls2.this;
                super();
            }
                });
            }

            
            {
                this$0 = LoginActivity.this;
                super();
            }
        };
        templatesManager.initTemplates(successcallback, failurecallback);
    }

    private boolean isFreshBSAuthSignup()
    {
        return preferenceUtils.getBoolean(0x7f06009e, false);
    }

    private void logMessage(String s)
    {
        Log.d("LoginActivity", s);
    }

    private void onTemplatesReady()
    {
        resolveNextActivityForUser();
    }

    private void resetIntentValues()
    {
        Intent intent = getIntent();
        if (!intent.hasExtra("PUSH_RECEIVE_EVENT")) goto _L2; else goto _L1
_L1:
        intent.removeExtra("PUSH_RECEIVE_EVENT");
_L4:
        setIntent(intent);
        return;
_L2:
        if (intent.hasExtra("REGISTER_EVENT"))
        {
            intent.removeExtra("REGISTER_EVENT");
        } else
        if (intent.hasExtra("UNREGISTER_EVENT"))
        {
            intent.removeExtra("UNREGISTER_EVENT");
        } else
        if (intent.hasExtra("REGISTER_ERROR_EVENT"))
        {
            intent.removeExtra("REGISTER_ERROR_EVENT");
        } else
        if (intent.hasExtra("UNREGISTER_ERROR_EVENT"))
        {
            intent.removeExtra("UNREGISTER_ERROR_EVENT");
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void sendAvatarNotFoundEvent()
    {
        if (!preferenceUtils.getBoolean(0x7f06002b, false))
        {
            analytics.sendEvent(Category.AUTH, Action.AVATAR_NOT_FOUND, null);
            preferenceUtils.putBoolean(0x7f06002b, true);
        }
    }

    public boolean hasFacebook()
    {
        return !TextUtils.isEmpty(facebookService.getToken());
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (i == 1 || i == 2 || i == 3)
        {
            if (j == -1)
            {
                resolveNextActivityForUser();
                return;
            } else
            {
                resolveNextActivityForUser();
                return;
            }
        } else
        {
            facebookService.onActivityResult(i, j, intent);
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Fabric.with(this, new Kit[] {
            new Crashlytics()
        });
        ((InjectorApplication)getApplication()).inject(this);
        initPushManager();
        if ("b4m".equals("production"))
        {
            b4MService.configureWithIntent(getIntent());
        }
        setContentView(0x7f030044);
        findViewById(0x7f0b00d6).setVisibility(4);
        findViewById(0x7f0b00d7).setVisibility(4);
        findViewById(0x7f0b00d8).setVisibility(4);
        initTemplates();
        initOutfitSaverService();
    }

    protected void onDestroy()
    {
        super.onDestroy();
        unregisterReceivers();
    }

    public void onFacebookLoginClicked(View view)
    {
        facebookService.openActiveSession(this, true, new com.bitstrips.imoji.auth.FacebookService.SessionOpenCallback() {

            final LoginActivity this$0;

            public void onOpened()
            {
                analytics.sendEvent(Category.AUTH, Action.LOGIN, "Facebook login");
                getAvatarInfo();
            }

            
            {
                this$0 = LoginActivity.this;
                super();
            }
        }, Arrays.asList(new String[] {
            "email"
        }));
    }

    public void onLoginClicked(View view)
    {
        startActivityForResult(new Intent(this, com/bitstrips/imoji/ui/BSLoginActivity), 2);
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        setIntent(intent);
        checkMessage(intent);
    }

    protected void onPause()
    {
        super.onPause();
        isPaused = true;
        unregisterReceivers();
        facebookService.logDeactivate(this);
    }

    protected void onResume()
    {
        super.onResume();
        isPaused = false;
        registerReceivers();
        facebookService.logActivate(this);
    }

    public void onSignUpClicked(View view)
    {
        startActivityForResult(new Intent(this, com/bitstrips/imoji/ui/SignUpActivity), 1);
    }

    protected void onStart()
    {
        super.onStart();
        analytics.reportStart(this);
        if ("b4m".equals("production"))
        {
            intentCreatorService.displayUpgradeDialog(this);
        }
    }

    protected void onStop()
    {
        super.onStop();
        analytics.reportStop(this);
    }

    public void registerReceivers()
    {
        IntentFilter intentfilter = new IntentFilter((new StringBuilder()).append(getPackageName()).append(".action.PUSH_MESSAGE_RECEIVE").toString());
        registerReceiver(mReceiver, intentfilter);
        registerReceiver(mBroadcastReceiver, new IntentFilter((new StringBuilder()).append(getPackageName()).append(".").append("com.arellomobile.android.push.REGISTER_BROAD_CAST_ACTION").toString()));
    }

    public void resolveNextActivityForUser()
    {
        boolean flag = hasBSAuth();
        boolean flag1 = hasAvatar();
        boolean flag2 = hasFacebook();
        boolean flag3 = isFreshBSAuthSignup();
        findViewById(0x7f0b00d8).setVisibility(0);
        if (flag && flag1)
        {
            intentCreatorService.goToImojiBrowser(this);
        } else
        {
            if (!flag && flag1)
            {
                intentCreatorService.sendFacebookUserToSignup(this);
                return;
            }
            if (flag && !flag1 && flag3)
            {
                preferenceUtils.putBoolean(0x7f06009e, false);
                intentCreatorService.goToRetrieveAvatar(this);
                return;
            }
            if (flag && !flag1)
            {
                intentCreatorService.goToAvatarBuilderDesign(this);
                sendAvatarNotFoundEvent();
                finish();
                return;
            }
            if (!flag && !flag1 && flag2)
            {
                intentCreatorService.sendFacebookUserToSignup(this);
                return;
            }
            if (!flag2)
            {
                findViewById(0x7f0b00d6).setVisibility(0);
                findViewById(0x7f0b00d8).setVisibility(0);
                if (!"b4m".equals("production"))
                {
                    findViewById(0x7f0b00d7).setVisibility(0);
                    return;
                }
            }
        }
    }

    public void unregisterReceivers()
    {
        try
        {
            unregisterReceiver(mReceiver);
        }
        catch (Exception exception1) { }
        try
        {
            unregisterReceiver(mBroadcastReceiver);
            return;
        }
        catch (Exception exception)
        {
            return;
        }
    }






}
