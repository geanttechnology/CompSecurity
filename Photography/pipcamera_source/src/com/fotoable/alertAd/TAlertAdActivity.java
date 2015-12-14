// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.alertAd;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import com.fotoable.ad.FotoCustomReport;
import com.fotoable.adbuttonlib.TWebBrowActivity;
import com.pipcamera.activity.FullscreenActivity;
import eh;
import ei;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

// Referenced classes of package com.fotoable.alertAd:
//            TAlertAdView

public class TAlertAdActivity extends FullscreenActivity
    implements ei
{

    TAlertAdView a;
    eh b;

    public TAlertAdActivity()
    {
    }

    private void a(Context context, String s, String s1)
    {
        if (s1 != null && s1.length() > 0)
        {
            try
            {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("market://details?id=").append(s1).toString())));
                finish();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("http://play.google.com/store/apps/details?id=").append(s1).toString())));
                Crashlytics.logException(s);
                finish();
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Crashlytics.logException(context);
            }
            return;
        }
        if (s != null && s.length() > 0)
        {
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
                Crashlytics.logException(context);
            }
            return;
        } else
        {
            finish();
            return;
        }
    }

    public void a()
    {
        a(((Context) (this)), b.d(), b.e());
        FotoCustomReport.addStringToArray(FotoCustomReport.clickedAlertID, (new StringBuilder()).append("").append(b.a()).toString());
        a("alertAdClicked");
    }

    protected void a(String s)
    {
        if (b != null)
        {
            HashMap hashmap = new HashMap();
            hashmap.put("adid", (new StringBuilder()).append("").append(b.a()).toString());
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
        a("alertAdCanced");
        finish();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030017);
        a = (TAlertAdView)findViewById(0x7f0c0045);
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
                Crashlytics.logException(bundle);
            }
            break MISSING_BLOCK_LABEL_82;
        }
        bundle = eh.a(new JSONObject(bundle));
        b = bundle;
        a.initWithTAdItem(bundle);
        return;
        finish();
        return;
    }

    protected void onResume()
    {
        super.onResume();
        FotoCustomReport.setLastAlertDisplayedTime(this, (new Date()).getTime());
        FotoCustomReport.addStringToArray(FotoCustomReport.poppedAlertID, (new StringBuilder()).append("").append(b.a()).toString());
        a("alertAdShowed");
    }

    protected void onStart()
    {
        super.onStart();
    }

    protected void onStop()
    {
        super.onStop();
    }
}
