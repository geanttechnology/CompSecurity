// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.tauth;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.connect.b.e;
import com.tencent.connect.common.AssistActivity;
import com.tencent.connect.common.a;
import com.tencent.open.a.k;
import com.tencent.open.utils.i;
import com.tencent.open.utils.j;
import com.tencent.open.utils.m;
import org.json.JSONObject;

// Referenced classes of package com.tencent.tauth:
//            b

public class AuthActivity extends Activity
{

    private static int a = 0;

    public AuthActivity()
    {
    }

    private void a(Uri uri)
    {
        Object obj;
        Object obj1;
        if (uri == null || uri.toString() == null || uri.toString().equals(""))
        {
            finish();
            return;
        }
        obj1 = uri.toString();
        uri = m.a(((String) (obj1)).substring(((String) (obj1)).indexOf("#") + 1));
        if (uri == null)
        {
            finish();
            return;
        }
        obj = uri.getString("action");
        k.b("openSDK_LOG.AuthActivity", (new StringBuilder()).append("-->handleActionUri, action: ").append(((String) (obj))).toString());
        if (obj == null)
        {
            a(((Bundle) (uri)), ((String) (obj1)));
            return;
        }
        if (((String) (obj)).equals("shareToQQ") || ((String) (obj)).equals("shareToQzone") || ((String) (obj)).equals("sendToMyComputer") || ((String) (obj)).equals("shareToTroopBar"))
        {
            if (((String) (obj)).equals("shareToQzone") && i.a(this, "com.tencent.mobileqq") != null && i.c(this, "5.2.0") < 0)
            {
                a++;
                if (a == 2)
                {
                    a = 0;
                    finish();
                    return;
                }
            }
            obj = new Intent(this, com/tencent/connect/common/AssistActivity);
            ((Intent) (obj)).putExtras(uri);
            ((Intent) (obj)).setFlags(0x24000000);
            AssistActivity.c = true;
            startActivity(((Intent) (obj)));
            finish();
            return;
        }
        if (((String) (obj)).equals("addToQQFavorites"))
        {
            obj1 = getIntent();
            ((Intent) (obj1)).putExtras(uri);
            ((Intent) (obj1)).putExtra("key_action", "action_share");
            uri = ((Uri) (j.a(((String) (obj)))));
            if (uri != null)
            {
                com.tencent.connect.common.a.a(((Intent) (obj1)), (b)uri);
            }
            finish();
            return;
        }
        if (!((String) (obj)).equals("sharePrize")) goto _L2; else goto _L1
_L1:
        obj1 = getPackageManager().getLaunchIntentForPackage(getPackageName());
        obj = uri.getString("response");
        uri = "";
        obj = m.d(((String) (obj))).getString("activityid");
        uri = ((Uri) (obj));
_L3:
        if (!TextUtils.isEmpty(uri))
        {
            ((Intent) (obj1)).putExtra("sharePrize", true);
            Bundle bundle = new Bundle();
            bundle.putString("activityid", uri);
            ((Intent) (obj1)).putExtras(bundle);
        }
        startActivity(((Intent) (obj1)));
        finish();
        return;
        Exception exception;
        exception;
        k.e("openSDK_LOG.AuthActivity", "sharePrize parseJson has exception.");
        if (true) goto _L3; else goto _L2
_L2:
        a(((Bundle) (uri)), ((String) (obj1)));
        return;
    }

    private void a(Bundle bundle, String s)
    {
        if (bundle == null || s == null)
        {
            finish();
            return;
        }
        com.tencent.connect.b.j j1 = com.tencent.connect.b.j.a();
        String s1 = bundle.getString("serial");
        com.tencent.connect.b.k k1 = j1.a(s1);
        if (k1 != null)
        {
            if (s.indexOf("://cancel") != -1)
            {
                k1.a.a();
                k1.b.dismiss();
            } else
            {
                s = bundle.getString("access_token");
                if (s != null)
                {
                    bundle.putString("access_token", j1.a(s, k1.c));
                }
                bundle = m.a(bundle);
                bundle = m.a(new JSONObject(), bundle);
                s = bundle.optString("cb");
                if (!"".equals(s))
                {
                    k1.b.a(s, bundle.toString());
                } else
                {
                    k1.a.a(bundle);
                    k1.b.dismiss();
                }
            }
            j1.b(s1);
        }
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (getIntent() == null)
        {
            return;
        }
        bundle = null;
        Uri uri = getIntent().getData();
        bundle = uri;
_L2:
        k.b("openSDK_LOG.AuthActivity", (new StringBuilder()).append("-->onCreate, uri: ").append(bundle).toString());
        a(bundle);
        return;
        Exception exception;
        exception;
        k.e("openSDK_LOG.AuthActivity", (new StringBuilder()).append("-->onCreate, getIntent().getData() has exception! ").append(exception.getMessage()).toString());
        if (true) goto _L2; else goto _L1
_L1:
    }

}
