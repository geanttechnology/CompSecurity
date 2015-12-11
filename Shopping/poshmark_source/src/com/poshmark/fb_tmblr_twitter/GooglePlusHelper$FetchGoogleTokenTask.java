// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.fb_tmblr_twitter;

import android.os.AsyncTask;
import android.os.Bundle;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.plus.Account;
import com.google.android.gms.plus.Plus;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.poshmark.data_model.models.PMErrorType;
import com.poshmark.http.api.PMApiError;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.fragments.PMFragment;
import java.io.IOException;

// Referenced classes of package com.poshmark.fb_tmblr_twitter:
//            GooglePlusHelper, ExtServiceUserInfoInterface

class this._cls0 extends AsyncTask
    implements TraceFieldInterface
{

    public Trace _nr_trace;
    GooglePlusHelper helper;
    final GooglePlusHelper this$0;

    public void _nr_setTrace(Trace trace)
    {
        try
        {
            _nr_trace = trace;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Trace trace)
        {
            return;
        }
    }

    protected transient Bundle doInBackground(Void avoid[])
    {
        avoid = new Bundle();
        Object obj;
        String s;
        try
        {
            obj = new Bundle();
            obj = GoogleAuthUtil.getToken(activity.getApplicationContext(), Plus.AccountApi.getAccountName(GooglePlusHelper.access$100(GooglePlusHelper.this)), "oauth2:https://www.googleapis.com/auth/plus.login https://www.googleapis.com/auth/plus.login", ((Bundle) (obj)));
            s = Plus.AccountApi.getAccountName(GooglePlusHelper.access$100(GooglePlusHelper.this));
            avoid.putString("TOKEN", ((String) (obj)));
            avoid.putString("EMAIL", s);
            avoid.putBoolean("GOOGLE_SIGNUP", true);
            if (GooglePlusHelper.access$100(GooglePlusHelper.this) == null || !GooglePlusHelper.access$100(GooglePlusHelper.this).isConnected())
            {
                break MISSING_BLOCK_LABEL_155;
            }
            s = GooglePlusHelper.getInstance().getGooglePlusProfileImageUrl();
        }
        catch (UserRecoverableAuthException userrecoverableauthexception)
        {
            avoid.putBoolean("TOKEN_ERROR", true);
            return avoid;
        }
        catch (IOException ioexception)
        {
            avoid.putBoolean("TOKEN_ERROR", true);
            return avoid;
        }
        catch (GoogleAuthException googleauthexception)
        {
            avoid.putBoolean("TOKEN_ERROR", true);
            return avoid;
        }
        catch (Exception exception)
        {
            avoid.putBoolean("TOKEN_ERROR", true);
            return avoid;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_128;
        }
        avoid.putString("GOOGLE_AVATAAR_URL", s);
        Plus.AccountApi.clearDefaultAccount(GooglePlusHelper.access$100(GooglePlusHelper.this));
        GooglePlusHelper.access$100(GooglePlusHelper.this).disconnect();
        GoogleAuthUtil.invalidateToken(activity.getApplicationContext(), ((String) (obj)));
        return avoid;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        TraceMachine.enterMethod(_nr_trace, "GooglePlusHelper$FetchGoogleTokenTask#doInBackground", null);
_L1:
        aobj = doInBackground((Void[])aobj);
        TraceMachine.exitMethod();
        TraceMachine.unloadTraceContext(this);
        return ((Object) (aobj));
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "GooglePlusHelper$FetchGoogleTokenTask#doInBackground", null);
          goto _L1
    }

    protected void onPostExecute(Bundle bundle)
    {
        if (bundle != null && !bundle.getBoolean("TOKEN_ERROR", false))
        {
            callback.success(bundle);
            return;
        }
        if (fragment != null)
        {
            fragment.hideProgressDialog();
        }
        bundle = new PMApiError(null, null, 200, PMErrorType.GOOGLE_PLUS_LOGIN_ERROR);
        callback.error(bundle);
    }

    protected volatile void onPostExecute(Object obj)
    {
        TraceMachine.enterMethod(_nr_trace, "GooglePlusHelper$FetchGoogleTokenTask#onPostExecute", null);
_L1:
        onPostExecute((Bundle)obj);
        TraceMachine.exitMethod();
        return;
        NoSuchFieldError nosuchfielderror;
        nosuchfielderror;
        TraceMachine.enterMethod(null, "GooglePlusHelper$FetchGoogleTokenTask#onPostExecute", null);
          goto _L1
    }

    public I()
    {
        this$0 = GooglePlusHelper.this;
        super();
    }
}
