// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.ad;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.crashlytics.android.Crashlytics;
import ew;
import java.lang.ref.WeakReference;

// Referenced classes of package com.fotoable.ad:
//            HomeWallFactory, StaticFlurryEvent

final class val.appToShow
    implements android.view.er
{

    final String val$appToShow;

    public void onClick(View view)
    {
_L2:
        return;
        if (HomeWallFactory.access$500() == null || HomeWallFactory.access$700() == null || HomeWallFactory.access$500().get() == null || HomeWallFactory.access$700().get() == null) goto _L2; else goto _L1
_L1:
        Activity activity = (Activity)HomeWallFactory.access$500().get();
        if (ew.a())
        {
            view = "CN";
        } else
        {
            view = "EN";
        }
        try
        {
            StaticFlurryEvent.logFotoableADEvent(StaticFlurryEvent.key_ad_wall_click, (new StringBuilder()).append(view).append("_default").toString());
            if (HomeWallFactory.access$700() != null)
            {
                ((meWallClickListener)HomeWallFactory.access$700().get()).onHomeWallClicked(HomeWallFactory.access$800(val$appToShow, activity.getPackageName()));
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            try
            {
                activity.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((new StringBuilder()).append("http://play.google.com/store/apps/details?id=").append(val$appToShow).toString())));
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
        if (true) goto _L2; else goto _L3
_L3:
    }

    ception()
    {
        val$appToShow = s;
        super();
    }
}
