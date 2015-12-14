// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import aad;
import aag;
import aax;
import aay;
import act;
import ade;
import adg;
import adt;
import adx;
import aeb;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import io.fabric.sdk.android.services.common.CommonUtils;
import java.io.File;
import zs;
import zw;

// Referenced classes of package com.crashlytics.android.answers:
//            SessionMetadataCollector, AnswersEventsHandler, AnswersFilesManagerProvider, SessionAnalyticsManager, 
//            AnswersLifecycleCallbacks, AnswersPreferenceManager, AddToCartEvent, ContentViewEvent, 
//            CustomEvent, InviteEvent, LevelEndEvent, LevelStartEvent, 
//            LoginEvent, PurchaseEvent, RatingEvent, SearchEvent, 
//            ShareEvent, SignUpEvent, StartCheckoutEvent

public class Answers extends aad
{

    static final String CRASHLYTICS_API_ENDPOINT = "com.crashlytics.ApiEndpoint";
    static final long FIRST_LAUNCH_INTERVAL_IN_MS = 0x36ee80L;
    static final String PREF_STORE_NAME = "settings";
    public static final String TAG = "Answers";
    SessionAnalyticsManager analyticsManager;
    private long installedAt;
    zs lifecycleManager;
    AnswersPreferenceManager preferenceManager;
    private String versionCode;
    private String versionName;

    public Answers()
    {
    }

    public static Answers getInstance()
    {
        return (Answers)zw.a(com/crashlytics/android/answers/Answers);
    }

    private void initializeSessionAnalytics(Context context)
    {
        try
        {
            SessionMetadataCollector sessionmetadatacollector = new SessionMetadataCollector(context, getIdManager(), versionCode, versionName);
            context = new AnswersEventsHandler(this, context, new AnswersFilesManagerProvider(context, new ade(this)), sessionmetadatacollector, new act(zw.h()));
            context.enable();
            analyticsManager = new SessionAnalyticsManager(context);
            lifecycleManager.a(new AnswersLifecycleCallbacks(analyticsManager));
            if (isFirstLaunch(installedAt))
            {
                zw.h().a("Answers", "New app install detected");
                analyticsManager.onInstall();
                preferenceManager.setAnalyticsLaunched();
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            zw.h().e("Answers", "Failed to initialize", context);
        }
    }

    protected Boolean doInBackground()
    {
        aeb aeb1;
        try
        {
            aeb1 = adx.a().b();
        }
        catch (Exception exception)
        {
            zw.h().e("Answers", "Error dealing with settings", exception);
            return Boolean.valueOf(false);
        }
        if (aeb1 != null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        zw.h().e("Answers", "Failed to retrieve settings");
        return Boolean.valueOf(false);
        if (aeb1.d.d)
        {
            zw.h().a("Answers", "Analytics collection enabled");
            analyticsManager.setAnalyticsSettingsData(aeb1.e, getOverridenSpiEndpoint());
            return Boolean.valueOf(true);
        }
        zw.h().a("Answers", "Analytics collection disabled");
        lifecycleManager.a();
        analyticsManager.disable();
        return Boolean.valueOf(false);
    }

    protected volatile Object doInBackground()
    {
        return doInBackground();
    }

    public String getIdentifier()
    {
        return "com.crashlytics.sdk.android:answers";
    }

    String getOverridenSpiEndpoint()
    {
        return CommonUtils.b(getContext(), "com.crashlytics.ApiEndpoint");
    }

    public String getVersion()
    {
        return "1.3.2.79";
    }

    boolean installedRecently(long l)
    {
        return System.currentTimeMillis() - l < 0x36ee80L;
    }

    boolean isFirstLaunch(long l)
    {
        return !preferenceManager.hasAnalyticsLaunched() && installedRecently(l);
    }

    public void logAddToCart(AddToCartEvent addtocartevent)
    {
        if (addtocartevent == null)
        {
            throw new NullPointerException("event must not be null");
        }
        if (analyticsManager != null)
        {
            analyticsManager.onPredefined(addtocartevent);
        }
    }

    public void logContentView(ContentViewEvent contentviewevent)
    {
        if (contentviewevent == null)
        {
            throw new NullPointerException("event must not be null");
        }
        if (analyticsManager != null)
        {
            analyticsManager.onPredefined(contentviewevent);
        }
    }

    public void logCustom(CustomEvent customevent)
    {
        if (customevent == null)
        {
            throw new NullPointerException("event must not be null");
        }
        if (analyticsManager != null)
        {
            analyticsManager.onCustom(customevent);
        }
    }

    public void logInvite(InviteEvent inviteevent)
    {
        if (inviteevent == null)
        {
            throw new NullPointerException("event must not be null");
        }
        if (analyticsManager != null)
        {
            analyticsManager.onPredefined(inviteevent);
        }
    }

    public void logLevelEnd(LevelEndEvent levelendevent)
    {
        if (levelendevent == null)
        {
            throw new NullPointerException("event must not be null");
        }
        if (analyticsManager != null)
        {
            analyticsManager.onPredefined(levelendevent);
        }
    }

    public void logLevelStart(LevelStartEvent levelstartevent)
    {
        if (levelstartevent == null)
        {
            throw new NullPointerException("event must not be null");
        }
        if (analyticsManager != null)
        {
            analyticsManager.onPredefined(levelstartevent);
        }
    }

    public void logLogin(LoginEvent loginevent)
    {
        if (loginevent == null)
        {
            throw new NullPointerException("event must not be null");
        }
        if (analyticsManager != null)
        {
            analyticsManager.onPredefined(loginevent);
        }
    }

    public void logPurchase(PurchaseEvent purchaseevent)
    {
        if (purchaseevent == null)
        {
            throw new NullPointerException("event must not be null");
        }
        if (analyticsManager != null)
        {
            analyticsManager.onPredefined(purchaseevent);
        }
    }

    public void logRating(RatingEvent ratingevent)
    {
        if (ratingevent == null)
        {
            throw new NullPointerException("event must not be null");
        }
        if (analyticsManager != null)
        {
            analyticsManager.onPredefined(ratingevent);
        }
    }

    public void logSearch(SearchEvent searchevent)
    {
        if (searchevent == null)
        {
            throw new NullPointerException("event must not be null");
        }
        if (analyticsManager != null)
        {
            analyticsManager.onPredefined(searchevent);
        }
    }

    public void logShare(ShareEvent shareevent)
    {
        if (shareevent == null)
        {
            throw new NullPointerException("event must not be null");
        }
        if (analyticsManager != null)
        {
            analyticsManager.onPredefined(shareevent);
        }
    }

    public void logSignUp(SignUpEvent signupevent)
    {
        if (signupevent == null)
        {
            throw new NullPointerException("event must not be null");
        }
        if (analyticsManager != null)
        {
            analyticsManager.onPredefined(signupevent);
        }
    }

    public void logStartCheckout(StartCheckoutEvent startcheckoutevent)
    {
        if (startcheckoutevent == null)
        {
            throw new NullPointerException("event must not be null");
        }
        if (analyticsManager != null)
        {
            analyticsManager.onPredefined(startcheckoutevent);
        }
    }

    public void onException(aax aax1)
    {
        if (analyticsManager != null)
        {
            analyticsManager.onCrash(aax1.a());
        }
    }

    public void onException(aay aay1)
    {
        if (analyticsManager != null)
        {
            analyticsManager.onError(aay1.a());
        }
    }

    protected boolean onPreExecute()
    {
        Context context;
        PackageInfo packageinfo;
        context = getContext();
        preferenceManager = new AnswersPreferenceManager(new adg(context, "settings"));
        lifecycleManager = new zs(context);
        packageinfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        versionCode = Integer.toString(packageinfo.versionCode);
        String s;
        if (packageinfo.versionName == null)
        {
            s = "0.0";
        } else
        {
            try
            {
                s = packageinfo.versionName;
            }
            catch (Exception exception)
            {
                zw.h().e("Answers", "Error retrieving app properties", exception);
                return false;
            }
        }
        versionName = s;
        if (android.os.Build.VERSION.SDK_INT < 9)
        {
            break MISSING_BLOCK_LABEL_109;
        }
        installedAt = packageinfo.firstInstallTime;
_L1:
        initializeSessionAnalytics(context);
        return true;
        installedAt = (new File(context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).sourceDir)).lastModified();
          goto _L1
    }
}
