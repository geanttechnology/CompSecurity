// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

// Referenced classes of package com.paypal.android.sdk:
//            t, da, db

public class cz extends t
{

    public cz()
    {
    }

    public static Intent a(String s, da da1, db db1, String s1)
    {
        Intent intent = a("com.paypal.android.p2pmobile.Sdk", "com.paypal.android.lib.authenticator.activity.SdkActivity");
        Bundle bundle = new Bundle();
        bundle.putString("target_client_id", s);
        if (da1 != null)
        {
            bundle.putString("token_request_type", da1.toString());
        }
        if (db1 != null)
        {
            bundle.putString("response_type", db1.toString());
        }
        bundle.putString("app_guid", s1);
        (new StringBuilder("launching authenticator with bundle:")).append(bundle);
        intent.putExtras(bundle);
        return intent;
    }

    public final boolean a(Context context, boolean flag)
    {
        boolean flag1 = a(context, "com.paypal.android.p2pmobile.Sdk", "com.paypal.android.lib.authenticator.activity.SdkActivity");
        return b(context, flag) && flag1;
    }

    static 
    {
        com/paypal/android/sdk/cz.getSimpleName();
    }
}
