// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.alertAd;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.FotoCustomReport;
import com.fotoable.adbuttonlib.TWebBrowActivity;
import com.fotoable.fotobeauty.FullscreenActivity;
import hk;
import hn;
import ie;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.fotoable.alertAd:
//            TAlertAdView

public class TAlertAdActivity extends FullscreenActivity
    implements hn
{

    TAlertAdView a;
    hk b;

    public TAlertAdActivity()
    {
    }

    private void a(Context context, String s, String s1)
    {
        if (s1 != null && s1.length() > 0)
        {
            try
            {
                ie.a(context, s1);
                finish();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("http://play.google.com/store/apps/details?id=").append(s1).toString())));
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return;
            }
            finish();
            return;
        }
        if (s != null && s.length() > 0)
        {
            if (s.startsWith("market://"))
            {
                ie.a(context, s);
                return;
            }
            s1 = new Intent(context, com/fotoable/adbuttonlib/TWebBrowActivity);
            s1.putExtra("webUriString", s);
            try
            {
                context.startActivity(s1);
                finish();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                return;
            }
        } else
        {
            finish();
            return;
        }
    }

    public void a()
    {
        a(((Context) (this)), b.d(), b.e());
        a("alertAdClicked");
    }

    protected void a(String s)
    {
        if (b != null)
        {
            HashMap hashmap = new HashMap();
            hashmap.put("adid", (new StringBuilder()).append(b.b()).append("_").append(b.a()).toString());
            FlurryAgent.logEvent(s, hashmap);
            return;
        } else
        {
            FlurryAgent.logEvent(s);
            return;
        }
    }

    public void b()
    {
        finish();
        a("alertAdCanced");
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030017);
        a = (TAlertAdView)findViewById(0x7f0d004c);
        a.setOnClickListener(this);
        bundle = getIntent().getStringExtra("alertItemJson");
        if (bundle == null)
        {
            try
            {
                finish();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Bundle bundle)
            {
                finish();
            }
            break MISSING_BLOCK_LABEL_82;
        }
        bundle = hk.a(new JSONObject(bundle));
        b = bundle;
        a.initWithTAdItem(bundle);
        return;
    }

    protected void onResume()
    {
        super.onResume();
        FotoCustomReport.setLastAlertDisplayedTime(this, (new Date()).getTime());
        FotoCustomReport.addStringToArray(FotoCustomReport.poppedAlertID, (new StringBuilder()).append("").append(b.a()).toString());
        a("alertAdShowed");
    }
}
