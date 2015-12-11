// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.login.widget;

import android.app.AlertDialog;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.facebook.AccessToken;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.LoginAuthorizationType;
import com.facebook.login.LoginManager;

// Referenced classes of package com.facebook.login.widget:
//            LoginButton

class <init>
    implements android.view.lickListener
{

    final LoginButton this$0;

    public void onClick(View view)
    {
        LoginButton.access$400(LoginButton.this, view);
        Object obj1 = getContext();
        AccessToken accesstoken = AccessToken.getCurrentAccessToken();
        int i;
        if (accesstoken != null)
        {
            if (LoginButton.access$500(LoginButton.this))
            {
                Object obj = getResources().getString(com.facebook._log_out_action);
                String s = getResources().getString(com.facebook._cancel_action);
                view = Profile.getCurrentProfile();
                class _cls1
                    implements android.content.DialogInterface.OnClickListener
                {

                    final LoginButton.LoginClickListener this$1;

                    public void onClick(DialogInterface dialoginterface, int j)
                    {
                        getLoginManager().logOut();
                    }

            _cls1()
            {
                this$1 = LoginButton.LoginClickListener.this;
                super();
            }
                }

                if (view != null && view.getName() != null)
                {
                    view = String.format(getResources().getString(com.facebook._logged_in_as), new Object[] {
                        view.getName()
                    });
                } else
                {
                    view = getResources().getString(com.facebook._logged_in_using_facebook);
                }
                obj1 = new android.app.w_logged_in_using_facebook(((android.content.Context) (obj1)));
                ((android.app.w_logged_in_using_facebook) (obj1)).w_logged_in_using_facebook(view).le(true).Button(((CharSequence) (obj)), new _cls1()).Button(s, null);
                ((android.app.ener) (obj1)).ener().show();
            } else
            {
                getLoginManager().logOut();
            }
        } else
        {
            view = getLoginManager();
            view.setDefaultAudience(getDefaultAudience());
            view.setLoginBehavior(getLoginBehavior());
            if (LoginAuthorizationType.PUBLISH.equals(es.access._mth700(LoginButton.access$600(LoginButton.this))))
            {
                if (getFragment() != null)
                {
                    view.logInWithPublishPermissions(getFragment(), es.access._mth800(LoginButton.access$600(LoginButton.this)));
                } else
                {
                    view.logInWithPublishPermissions(LoginButton.access$900(LoginButton.this), es.access._mth800(LoginButton.access$600(LoginButton.this)));
                }
            } else
            if (getFragment() != null)
            {
                view.logInWithReadPermissions(getFragment(), es.access._mth800(LoginButton.access$600(LoginButton.this)));
            } else
            {
                view.logInWithReadPermissions(LoginButton.access$1000(LoginButton.this), es.access._mth800(LoginButton.access$600(LoginButton.this)));
            }
        }
        view = AppEventsLogger.newLogger(getContext());
        obj = new Bundle();
        if (accesstoken != null)
        {
            i = 0;
        } else
        {
            i = 1;
        }
        ((Bundle) (obj)).putInt("logging_in", i);
        view.logSdkEvent(LoginButton.access$1100(LoginButton.this), null, ((Bundle) (obj)));
    }

    private es()
    {
        this$0 = LoginButton.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
