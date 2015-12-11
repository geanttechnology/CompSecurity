// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.authentication;

import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.comcast.cim.android.view.common.ErrorDialogFactory;
import com.comcast.cim.cmasl.android.util.system.InternetConnection;
import com.comcast.cim.cmasl.android.util.system.SoftKeyboard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.android.authentication:
//            AuthenticationActivity, AuthenticationAsyncTask, AuthenticationClient

public class SignInListener
    implements android.view.View.OnClickListener, android.widget.TextView.OnEditorActionListener
{

    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/android/authentication/SignInListener);
    protected final AuthenticationClient authenticationClient;
    private final ErrorDialogFactory errorDialogFactory;
    protected final InternetConnection internetConnection;
    private final SoftKeyboard softKeyboard;

    public SignInListener(AuthenticationClient authenticationclient, SoftKeyboard softkeyboard, InternetConnection internetconnection, ErrorDialogFactory errordialogfactory)
    {
        authenticationClient = authenticationclient;
        softKeyboard = softkeyboard;
        internetConnection = internetconnection;
        errorDialogFactory = errordialogfactory;
    }

    private void submitLogin(AuthenticationActivity authenticationactivity)
    {
        String s = authenticationactivity.getUsername();
        String s1 = authenticationactivity.getPassword();
        LOG.debug((new StringBuilder()).append("signing in as ").append(s).toString());
        if (s.length() == 0 || s1.length() == 0)
        {
            authenticationactivity.showZeroLengthDialog();
            return;
        } else
        {
            authenticationactivity.showSigningInSpinner();
            getAuthenticationTask(authenticationactivity).execute(new String[] {
                s, s1
            });
            return;
        }
    }

    protected AuthenticationAsyncTask getAuthenticationTask(AuthenticationActivity authenticationactivity)
    {
        return new AuthenticationAsyncTask(authenticationactivity, authenticationClient, internetConnection, errorDialogFactory);
    }

    public void onClick(View view)
    {
        submitLogin((AuthenticationActivity)view.getContext());
    }

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (i != 6)
        {
            return false;
        } else
        {
            keyevent = (AuthenticationActivity)textview.getContext();
            softKeyboard.hide(textview);
            submitLogin(keyevent);
            return true;
        }
    }

}
