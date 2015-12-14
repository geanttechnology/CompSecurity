// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import com.flurry.android.FlurryAgent;
import com.fotoable.fotovariant.fotoads.FotoAdBanner;

public class anr
    implements android.view.View.OnClickListener
{

    final FotoAdBanner a;

    public anr(FotoAdBanner fotoadbanner)
    {
        a = fotoadbanner;
        super();
    }

    public void onClick(View view)
    {
        Log.v(FotoAdBanner.access$000(), (new StringBuilder()).append(FotoAdBanner.access$000()).append(" default View clicked").toString());
        if (!FotoAdBanner.access$200(a, FotoAdBanner.access$100(a)))
        {
            break MISSING_BLOCK_LABEL_110;
        }
        view = a.getContext().getPackageManager().getLaunchIntentForPackage(FotoAdBanner.access$100(a));
        view.addFlags(0x10000000);
        a.getContext().startActivity(view);
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
            view.printStackTrace();
        }
        return;
        if (!yp.a())
        {
            break MISSING_BLOCK_LABEL_223;
        }
        FlurryAgent.logEvent("FBDefaultBannerClicked_CN");
_L1:
        view = new Intent("android.intent.action.VIEW", Uri.parse(FotoAdBanner.access$300(a, FotoAdBanner.access$100(a))));
        view.addFlags(0x10000000);
        a.getContext().startActivity(view);
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
                a.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("http://play.google.com/store/apps/details?id=").append(FotoAdBanner.access$100(a)).toString())));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (View view)
            {
                view.printStackTrace();
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            view.printStackTrace();
            return;
        }
          goto _L1
    }
}
