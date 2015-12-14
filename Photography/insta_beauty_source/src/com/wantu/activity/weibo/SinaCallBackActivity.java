// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.activity.weibo;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;
import bri;
import brt;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.ApplicationState;
import com.fotoable.fotobeauty.SettingActivity;
import com.fotoable.fotobeauty.ShareEditActivity;
import com.wantu.weibo.other.sina.WeiboException;

public class SinaCallBackActivity extends Activity
{

    brt a;

    public SinaCallBackActivity()
    {
        a = brt.a();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300c6);
        Object obj = getIntent();
        bundle = ((Intent) (obj)).getStringExtra("com.wantu.android.source");
        obj = ((Intent) (obj)).getData().getQueryParameter("oauth_verifier");
        a.a(((String) (obj)));
        bri bri1 = a.a(this, null);
        android.content.SharedPreferences.Editor editor = getSharedPreferences("com.wantu.android.WantuSetting", 0).edit();
        editor.putInt("com.wantu.android.weibo.sina_status", 1);
        editor.putString("com.wantu.android.weibo.sina_token", bri1.a());
        editor.putString("com.wantu.android.weibo.sina_secret", bri1.c());
        editor.commit();
        if (bundle.compareTo("share") != 0)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        startActivity(new Intent(this, com/fotoable/fotobeauty/ShareEditActivity));
_L1:
        finish();
        return;
        try
        {
            startActivity(new Intent(this, com/fotoable/fotobeauty/SettingActivity));
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            bundle.printStackTrace();
            Toast.makeText(this, String.format("Conneted to Sina :%s", new Object[] {
                bundle.getMessage()
            }), 1);
            return;
        }
          goto _L1
    }

    protected void onDestroy()
    {
        super.onDestroy();
        FlurryAgent.onEndSession(this);
        ApplicationState.checkAppStateAfterOnStop();
    }

    protected void onStop()
    {
        super.onStop();
        FlurryAgent.onStartSession(this, "J3DP5Q6Y48C3GPJXV4X3");
        ApplicationState.checkAppStateAfterOnStart();
    }
}
