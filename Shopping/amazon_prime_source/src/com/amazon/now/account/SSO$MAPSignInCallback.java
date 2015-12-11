// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.account;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.now.platform.AndroidPlatform;
import com.amazon.now.util.DataStore;

// Referenced classes of package com.amazon.now.account:
//            SSO

private static class mCallback
    implements Callback
{

    private Activity mActivity;
    private mActivity mCallback;

    public void onError(Bundle bundle)
    {
        Log.e(SSO.access$000(), "Register via MAPR5 was a failure");
        if (mCallback != null)
        {
            mCallback.lure();
        }
    }

    public void onSuccess(Bundle bundle)
    {
        bundle = bundle.getString("com.amazon.dcp.sso.property.account.acctId");
        long _tmp = SSO.access$302(SystemClock.elapsedRealtime());
        DataStore.putLong("lastAuthentication", SSO.access$300());
        SSO.notifyUserSignedIn(bundle, null);
        if (mCallback != null)
        {
            mCallback.cess(mActivity);
            return;
        } else
        {
            AndroidPlatform.getInstance().invokeLater(new Runnable() {

                final SSO.MAPSignInCallback this$0;

                public void run()
                {
                    mActivity.recreate();
                }

            
            {
                this$0 = SSO.MAPSignInCallback.this;
                super();
            }
            });
            return;
        }
    }


    public _cls1.this._cls0(Activity activity, _cls1.this._cls0 _pcls0)
    {
        mActivity = activity;
        mCallback = _pcls0;
    }
}
