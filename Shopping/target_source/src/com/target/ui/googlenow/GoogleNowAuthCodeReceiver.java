// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.googlenow;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.target.ui.util.q;

// Referenced classes of package com.target.ui.googlenow:
//            GoogleNowIntentHandler

public class GoogleNowAuthCodeReceiver extends BroadcastReceiver
{

    public static final String AUTH_CODE_EXTRA = "authCode";
    public static final String REVOKE_TOKEN_EXTRA = "revokeToken";
    private static final String TAG = com/target/ui/googlenow/GoogleNowAuthCodeReceiver.getSimpleName();

    public GoogleNowAuthCodeReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        String s = intent.getStringExtra("authCode");
        intent = intent.getStringExtra("revokeToken");
        if (intent != null)
        {
            GoogleNowIntentHandler.b(context, intent);
            return;
        }
        if (s != null)
        {
            GoogleNowIntentHandler.a(context, s);
            return;
        } else
        {
            q.a(TAG, "Unexpected error occurred while getting the auth code.");
            return;
        }
    }

}
