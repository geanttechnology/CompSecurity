// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.os.Bundle;
import co.vine.android.service.VineServiceResponder;

// Referenced classes of package co.vine.android:
//            AuthenticatorActivity

class nder extends VineServiceResponder
{

    final AuthenticatorActivity this$0;

    public void onServiceResponse(int i, int j, String s, Bundle bundle)
    {
        removeDialog(1);
        if (j == 200)
        {
            s = bundle.getString("s_key");
            if (!mConfirmCredentials.booleanValue())
            {
                finishLogin(s);
                return;
            } else
            {
                finishConfirmCredentials(s, true);
                return;
            }
        } else
        {
            throw new UnsupportedOperationException("handle bad password scenario");
        }
    }

    nder()
    {
        this$0 = AuthenticatorActivity.this;
        super();
    }
}
