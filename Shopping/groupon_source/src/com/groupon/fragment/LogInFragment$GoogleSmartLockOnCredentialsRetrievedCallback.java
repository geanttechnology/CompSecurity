// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import com.google.android.gms.auth.api.credentials.Credential;
import com.groupon.models.nst.GoogleSmartLockExtraInfo;
import com.groupon.tracking.mobile.sdk.Logger;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            LogInFragment

private class <init>
    implements com.groupon.service.googlesmartlock._10_w_CC__08_
{

    final LogInFragment this$0;

    public void onCredentialResolutionRequired()
    {
        LogInFragment.access$702(LogInFragment.this, true);
        logger.logImpression("", "google_smartlock_multiple_pwd_modal", LogInFragment.access$800(LogInFragment.this), "", new GoogleSmartLockExtraInfo(getClass().getSimpleName(), trigger));
    }

    public void onCredentialsRetrieveFailed()
    {
        if (LogInFragment.access$500(LogInFragment.this) != null)
        {
            LogInFragment.access$500(LogInFragment.this).dismiss();
        }
        if (email != null)
        {
            LogInFragment.access$900(LogInFragment.this);
            if (Strings.isEmpty(email.getText().toString()))
            {
                email.requestFocus();
            }
        }
    }

    public void onCredentialsRetrieved(Credential credential)
    {
        LogInFragment.access$500(LogInFragment.this).dismiss();
        email.setText(credential.getId());
        password.setText(credential.getPassword());
        if (!LogInFragment.access$600(LogInFragment.this).getBoolean(GOOGLE_SMARTLOCK_AUTOMATICALLY_LOGIN_ALREADY_PERFORMED_EXTRA_KEY, false))
        {
            credential = LogInFragment.access$600(LogInFragment.this).edit();
            credential._mth0(GOOGLE_SMARTLOCK_AUTOMATICALLY_LOGIN_ALREADY_PERFORMED_EXTRA_KEY, true);
            credential.ADY_PERFORMED_EXTRA_KEY();
            LogInFragment.access$300(LogInFragment.this);
        }
        if (!LogInFragment.access$700(LogInFragment.this))
        {
            logger.logImpression("", "google_smartlock_pwd_modal", LogInFragment.access$800(LogInFragment.this), "", new GoogleSmartLockExtraInfo(getClass().getSimpleName(), trigger));
        }
    }

    private Callback()
    {
        this$0 = LogInFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
