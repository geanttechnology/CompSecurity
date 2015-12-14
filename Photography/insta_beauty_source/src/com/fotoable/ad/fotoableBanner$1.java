// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ad;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import com.crashlytics.android.Crashlytics;
import com.flurry.android.FlurryAgent;
import yp;

// Referenced classes of package com.fotoable.ad:
//            fotoableBanner

class this._cls0
    implements android.view.ner
{

    final fotoableBanner this$0;

    public void onClick(View view)
    {
        Log.v(fotoableBanner.access$000(), (new StringBuilder()).append(fotoableBanner.access$000()).append(" default View clicked").toString());
        if (!fotoableBanner.access$200(fotoableBanner.this, fotoableBanner.access$100(fotoableBanner.this)))
        {
            break MISSING_BLOCK_LABEL_110;
        }
        view = fotoableBanner.access$300(fotoableBanner.this).getPackageManager().getLaunchIntentForPackage(fotoableBanner.access$100(fotoableBanner.this));
        view.addFlags(0x10000000);
        fotoableBanner.access$300(fotoableBanner.this).startActivity(view);
        if (yp.a())
        {
            FlurryAgent.logEvent("FBDefaultBannerClicked_Opened_CN");
            return;
        }
        try
        {
            FlurryAgent.logEvent("FBDefaultBannerClicked_Opened_EN");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            Crashlytics.logException(view);
        }
        return;
        if (!yp.a())
        {
            break MISSING_BLOCK_LABEL_223;
        }
        FlurryAgent.logEvent("FBDefaultBannerClicked_CN");
_L1:
        view = new Intent("android.intent.action.VIEW", Uri.parse(fotoableBanner.access$400(fotoableBanner.this, fotoableBanner.access$100(fotoableBanner.this))));
        view.addFlags(0x10000000);
        fotoableBanner.access$300(fotoableBanner.this).startActivity(view);
        return;
        try
        {
            FlurryAgent.logEvent("FBDefaultBannerClicked_EN");
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            try
            {
                fotoableBanner.access$300(fotoableBanner.this).startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("http://play.google.com/store/apps/details?id=").append(fotoableBanner.access$100(fotoableBanner.this)).toString())));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                Crashlytics.logException(view);
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            Crashlytics.logException(view);
            return;
        }
          goto _L1
    }

    xception()
    {
        this$0 = fotoableBanner.this;
        super();
    }
}
