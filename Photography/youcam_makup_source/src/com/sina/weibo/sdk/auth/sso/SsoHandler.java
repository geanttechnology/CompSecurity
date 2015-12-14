// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.auth.sso;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.sina.sso.RemoteSSO;
import com.sina.weibo.sdk.WeiboAppManager;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.auth.Oauth2AccessToken;
import com.sina.weibo.sdk.auth.WeiboAuthListener;
import com.sina.weibo.sdk.cmd.WbAppActivator;
import com.sina.weibo.sdk.exception.WeiboDialogException;
import com.sina.weibo.sdk.exception.WeiboException;
import com.sina.weibo.sdk.register.mobile.MobileRegisterActivity;
import com.sina.weibo.sdk.utils.AidTask;
import com.sina.weibo.sdk.utils.LogUtil;
import com.sina.weibo.sdk.utils.SecurityHelper;
import com.sina.weibo.sdk.utils.Utility;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.sina.weibo.sdk.auth.sso:
//            WebAuthHandler

public class SsoHandler
{

    public static final String AUTH_FAILED_MSG = "auth failed!!!!!";
    public static final String AUTH_FAILED_NOT_INSTALL_MSG = "not install weibo client!!!!!";
    private static final String DEFAULT_WEIBO_REMOTE_SSO_SERVICE_NAME = "com.sina.weibo.remotessoservice";
    private static final int REQUEST_CODE_MOBILE_REGISTER = 40000;
    private static final int REQUEST_CODE_SSO_AUTH = 32973;
    private static final String TAG = "Weibo_SSO_login";
    private Activity mAuthActivity;
    private AuthInfo mAuthInfo;
    private WeiboAuthListener mAuthListener;
    private ServiceConnection mConnection;
    private int mSSOAuthRequestCode;
    private WebAuthHandler mWebAuthHandler;
    private com.sina.weibo.sdk.WeiboAppManager.WeiboInfo mWeiboInfo;

    public SsoHandler(Activity activity, AuthInfo authinfo)
    {
        mConnection = new ServiceConnection() {

            final SsoHandler this$0;

            public void onServiceConnected(ComponentName componentname, IBinder ibinder)
            {
                ibinder = com.sina.sso.RemoteSSO.Stub.asInterface(ibinder);
                try
                {
                    componentname = ibinder.getPackageName();
                    ibinder = ibinder.getActivityName();
                    mAuthActivity.getApplicationContext().unbindService(mConnection);
                    if (!startSingleSignOn(componentname, ibinder))
                    {
                        mWebAuthHandler.anthorize(mAuthListener);
                    }
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (ComponentName componentname)
                {
                    componentname.printStackTrace();
                }
            }

            public void onServiceDisconnected(ComponentName componentname)
            {
                mWebAuthHandler.anthorize(mAuthListener);
            }

            
            {
                this$0 = SsoHandler.this;
                super();
            }
        };
        mAuthActivity = activity;
        mAuthInfo = authinfo;
        mWebAuthHandler = new WebAuthHandler(activity, authinfo);
        mWeiboInfo = WeiboAppManager.getInstance(activity).getWeiboInfo();
        AidTask.getInstance(mAuthActivity).aidTaskInit(authinfo.getAppKey());
    }

    private void authorize(int i, WeiboAuthListener weiboauthlistener, AuthType authtype)
    {
        mSSOAuthRequestCode = i;
        mAuthListener = weiboauthlistener;
        i = 0;
        if (authtype == AuthType.SsoOnly)
        {
            i = 1;
        }
        if (authtype == AuthType.WebOnly)
        {
            if (weiboauthlistener != null)
            {
                mWebAuthHandler.anthorize(weiboauthlistener);
            }
        } else
        if (!bindRemoteSSOService(mAuthActivity.getApplicationContext()))
        {
            if (i != 0)
            {
                if (mAuthListener != null)
                {
                    mAuthListener.onWeiboException(new WeiboException("not install weibo client!!!!!"));
                    return;
                }
            } else
            {
                mWebAuthHandler.anthorize(mAuthListener);
                return;
            }
        }
    }

    private boolean bindRemoteSSOService(Context context)
    {
        if (!isWeiboAppInstalled())
        {
            return false;
        } else
        {
            String s = mWeiboInfo.getPackageName();
            Intent intent = new Intent("com.sina.weibo.remotessoservice");
            intent.setPackage(s);
            return context.bindService(intent, mConnection, 1);
        }
    }

    public static ComponentName isServiceExisted(Context context, String s)
    {
        context = ((ActivityManager)context.getSystemService("activity")).getRunningServices(0x7fffffff).iterator();
        ComponentName componentname;
        do
        {
            if (!context.hasNext())
            {
                return null;
            }
            componentname = ((android.app.ActivityManager.RunningServiceInfo)context.next()).service;
        } while (!componentname.getPackageName().equals(s) || !componentname.getClassName().equals((new StringBuilder(String.valueOf(s))).append(".business.RemoteSSOService").toString()));
        return componentname;
    }

    private boolean startSingleSignOn(String s, String s1)
    {
        boolean flag = true;
        Intent intent = new Intent();
        intent.setClassName(s, s1);
        intent.putExtras(mWebAuthHandler.getAuthInfo().getAuthBundle());
        intent.putExtra("_weibo_command_type", 3);
        intent.putExtra("_weibo_transaction", String.valueOf(System.currentTimeMillis()));
        intent.putExtra("aid", Utility.getAid(mAuthActivity, mAuthInfo.getAppKey()));
        if (!SecurityHelper.validateAppSignatureForIntent(mAuthActivity, intent))
        {
            return false;
        }
        s = Utility.getAid(mAuthActivity, mAuthInfo.getAppKey());
        if (!TextUtils.isEmpty(s))
        {
            intent.putExtra("aid", s);
        }
        try
        {
            mAuthActivity.startActivityForResult(intent, mSSOAuthRequestCode);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            flag = false;
        }
        return flag;
    }

    public void authorize(WeiboAuthListener weiboauthlistener)
    {
        authorize(32973, weiboauthlistener, AuthType.ALL);
        WbAppActivator.getInstance(mAuthActivity, mAuthInfo.getAppKey()).activateApp();
    }

    public void authorizeCallBack(int i, int j, Intent intent)
    {
        LogUtil.d("Weibo_SSO_login", (new StringBuilder("requestCode: ")).append(i).append(", resultCode: ").append(j).append(", data: ").append(intent).toString());
        if (i != mSSOAuthRequestCode) goto _L2; else goto _L1
_L1:
        if (j != -1) goto _L4; else goto _L3
_L3:
        if (SecurityHelper.checkResponseAppLegal(mAuthActivity, mWeiboInfo, intent)) goto _L6; else goto _L5
_L5:
        return;
_L6:
        String s1 = intent.getStringExtra("error");
        Object obj = s1;
        if (s1 == null)
        {
            obj = intent.getStringExtra("error_type");
        }
        if (obj != null)
        {
            if (((String) (obj)).equals("access_denied") || ((String) (obj)).equals("OAuthAccessDeniedException"))
            {
                LogUtil.d("Weibo_SSO_login", "Login canceled by user.");
                mAuthListener.onCancel();
                return;
            }
            String s2 = intent.getStringExtra("error_description");
            intent = ((Intent) (obj));
            if (s2 != null)
            {
                intent = (new StringBuilder(String.valueOf(obj))).append(":").append(s2).toString();
            }
            LogUtil.d("Weibo_SSO_login", (new StringBuilder("Login failed: ")).append(intent).toString());
            mAuthListener.onWeiboException(new WeiboDialogException(intent, j, s2));
            return;
        }
        intent = intent.getExtras();
        obj = Oauth2AccessToken.parseAccessToken(intent);
        if (obj != null && ((Oauth2AccessToken) (obj)).isSessionValid())
        {
            LogUtil.d("Weibo_SSO_login", (new StringBuilder("Login Success! ")).append(((Oauth2AccessToken) (obj)).toString()).toString());
            mAuthListener.onComplete(intent);
            return;
        } else
        {
            LogUtil.d("Weibo_SSO_login", "Failed to receive access token by SSO");
            mWebAuthHandler.anthorize(mAuthListener);
            return;
        }
_L4:
        if (j == 0)
        {
            if (intent != null)
            {
                LogUtil.d("Weibo_SSO_login", (new StringBuilder("Login failed: ")).append(intent.getStringExtra("error")).toString());
                mAuthListener.onWeiboException(new WeiboDialogException(intent.getStringExtra("error"), intent.getIntExtra("error_code", -1), intent.getStringExtra("failing_url")));
                return;
            } else
            {
                LogUtil.d("Weibo_SSO_login", "Login canceled by user.");
                mAuthListener.onCancel();
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (i == 40000)
        {
            if (j != -1)
            {
                continue; /* Loop/switch isn't completed */
            }
            intent = intent.getExtras();
            Oauth2AccessToken oauth2accesstoken = Oauth2AccessToken.parseAccessToken(intent);
            if (oauth2accesstoken != null && oauth2accesstoken.isSessionValid())
            {
                LogUtil.d("Weibo_SSO_login", (new StringBuilder("Login Success! ")).append(oauth2accesstoken.toString()).toString());
                mAuthListener.onComplete(intent);
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
        if (j != 0) goto _L5; else goto _L7
_L7:
        if (intent != null)
        {
            LogUtil.d("Weibo_SSO_login", (new StringBuilder("Login failed: ")).append(intent.getStringExtra("error")).toString());
            String s3 = intent.getStringExtra("error");
            String s = s3;
            if (s3 == null)
            {
                s = intent.getStringExtra("error_type");
            }
            if (s != null)
            {
                mAuthListener.onWeiboException(new WeiboDialogException(intent.getStringExtra("error"), intent.getIntExtra("error_code", -1), intent.getStringExtra("error_description")));
                return;
            }
        } else
        {
            LogUtil.d("Weibo_SSO_login", "Login canceled by user.");
            mAuthListener.onCancel();
            return;
        }
        if (true) goto _L5; else goto _L8
_L8:
    }

    public void authorizeClientSso(WeiboAuthListener weiboauthlistener)
    {
        authorize(32973, weiboauthlistener, AuthType.SsoOnly);
        WbAppActivator.getInstance(mAuthActivity, mAuthInfo.getAppKey()).activateApp();
    }

    public void authorizeWeb(WeiboAuthListener weiboauthlistener)
    {
        authorize(32973, weiboauthlistener, AuthType.WebOnly);
        WbAppActivator.getInstance(mAuthActivity, mAuthInfo.getAppKey()).activateApp();
    }

    public boolean isWeiboAppInstalled()
    {
        return mWeiboInfo != null && mWeiboInfo.isLegal();
    }

    public void registerOrLoginByMobile(String s, WeiboAuthListener weiboauthlistener)
    {
        mAuthListener = weiboauthlistener;
        weiboauthlistener = new Intent(mAuthActivity, com/sina/weibo/sdk/register/mobile/MobileRegisterActivity);
        Bundle bundle = mAuthInfo.getAuthBundle();
        bundle.putString("register_title", s);
        weiboauthlistener.putExtras(bundle);
        mAuthActivity.startActivityForResult(weiboauthlistener, 40000);
    }






    private class AuthType extends Enum
    {

        public static final AuthType ALL;
        private static final AuthType ENUM$VALUES[];
        public static final AuthType SsoOnly;
        public static final AuthType WebOnly;

        public static AuthType valueOf(String s)
        {
            return (AuthType)Enum.valueOf(com/sina/weibo/sdk/auth/sso/SsoHandler$AuthType, s);
        }

        public static AuthType[] values()
        {
            AuthType aauthtype[] = ENUM$VALUES;
            int i = aauthtype.length;
            AuthType aauthtype1[] = new AuthType[i];
            System.arraycopy(aauthtype, 0, aauthtype1, 0, i);
            return aauthtype1;
        }

        static 
        {
            ALL = new AuthType("ALL", 0);
            SsoOnly = new AuthType("SsoOnly", 1);
            WebOnly = new AuthType("WebOnly", 2);
            ENUM$VALUES = (new AuthType[] {
                ALL, SsoOnly, WebOnly
            });
        }

        private AuthType(String s, int i)
        {
            super(s, i);
        }
    }

}
