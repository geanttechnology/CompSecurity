// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.googlenow;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.e;
import com.google.android.gms.search.GoogleNowAuthState;
import com.google.android.gms.search.a;
import com.google.android.gms.search.b;
import com.target.ui.service.GoogleNowService;
import com.target.ui.util.q;

// Referenced classes of package com.target.ui.googlenow:
//            GoogleNowSendCardHelper, b

public class GoogleNowIntentHandler
{

    private static final String ALARM = "ALARM";
    private static final String ALARM_KEY = "ALARM_KEY";
    public static final String AUTH_CODE_BROADCAST_ACTION = "com.target.ui.googlenow.GOOGLE_NOW_AUTH_CODE_BROADCAST";
    public static final String AUTH_CODE_EXTRA = "authCode";
    private static final String AUTH_KEY = "AUTH_KEY";
    private static final String FETCH_TOKEN = "FETCH_TOKEN";
    private static final String FETCH_TOKEN_KEY = "FETCH_TOKEN_KEY";
    public static final String REVOKE_TOKEN_EXTRA = "revokeToken";
    private static final String REVOKE_TOKEN_KEY = "REVOKE_TOKEN_KEY";
    private static final String TAG = "GoogleNowIntentHandler";
    private Context mContext;

    public GoogleNowIntentHandler(Context context)
    {
        mContext = context.getApplicationContext();
    }

    private void a()
    {
        Object obj;
        Object obj1;
        Object obj2;
        obj = new Intent("com.target.ui.googlenow.GOOGLE_NOW_AUTH_CODE_BROADCAST");
        obj2 = a.c;
        obj1 = (new com.google.android.gms.common.api.d.a(mContext)).a(a.b).b();
        ((d) (obj1)).c();
        obj2 = (com.google.android.gms.search.b.a)((b) (obj2)).a(((d) (obj1)), "962062594339-bl69hjmgrqtl60krj35icco82vl6lga7.apps.googleusercontent.com").b();
        ((d) (obj1)).d();
        obj1 = ((com.google.android.gms.search.b.a) (obj2)).a();
        if (obj1 == null || !((Status) (obj1)).e()) goto _L2; else goto _L1
_L1:
        obj1 = ((com.google.android.gms.search.b.a) (obj2)).b();
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        if (TextUtils.isEmpty(((GoogleNowAuthState) (obj1)).a())) goto _L6; else goto _L5
_L5:
        q.d("GoogleNowIntentHandler", "Got auth code");
        ((Intent) (obj)).putExtra("authCode", ((GoogleNowAuthState) (obj1)).a());
_L9:
        ((Intent) (obj)).setPackage(mContext.getPackageName());
        mContext.sendBroadcast(((Intent) (obj)));
_L4:
        return;
        obj;
        ((d) (obj1)).d();
        throw obj;
_L6:
        if (!TextUtils.isEmpty(((GoogleNowAuthState) (obj1)).b()))
        {
            q.d("GoogleNowIntentHandler", "Got access token");
            ((Intent) (obj)).putExtra("revokeToken", ((GoogleNowAuthState) (obj1)).b());
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (obj1 == null) goto _L4; else goto _L7
_L7:
        q.a("GoogleNowIntentHandler", (new StringBuilder()).append("Failure status: ").append(((Status) (obj1)).c()).toString());
        return;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public static void a(Context context)
    {
        context.startService((new Intent(context, com/target/ui/service/GoogleNowService)).putExtra("FETCH_TOKEN_KEY", "FETCH_TOKEN"));
    }

    public static void a(Context context, String s)
    {
        context.startService((new Intent(context, com/target/ui/service/GoogleNowService)).putExtra("AUTH_KEY", s));
    }

    private void a(String s)
    {
        (new GoogleNowSendCardHelper(mContext.getApplicationContext())).a(s);
    }

    private void b()
    {
        (new GoogleNowSendCardHelper(mContext.getApplicationContext())).a();
    }

    public static void b(Context context, String s)
    {
        context.startService((new Intent(context, com/target/ui/service/GoogleNowService)).putExtra("REVOKE_TOKEN_KEY", s));
    }

    private void b(Intent intent)
    {
        String s = intent.getStringExtra("ALARM_KEY");
        String s1 = intent.getStringExtra("AUTH_KEY");
        intent = intent.getStringExtra("REVOKE_TOKEN_KEY");
        if (s != null && s.equals("ALARM"))
        {
            b();
            com.target.ui.googlenow.b.a(mContext, Boolean.valueOf(false));
        } else
        {
            if (intent != null)
            {
                b(((String) (intent)));
                return;
            }
            if (s1 != null)
            {
                a(s1);
                return;
            }
        }
    }

    private void b(String s)
    {
        (new GoogleNowSendCardHelper(mContext.getApplicationContext())).b(s);
    }

    public void a(Intent intent)
    {
        String s = intent.getStringExtra("FETCH_TOKEN_KEY");
        if (s != null && s.equals("FETCH_TOKEN"))
        {
            a();
            return;
        } else
        {
            b(intent);
            return;
        }
    }
}
