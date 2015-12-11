// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile;

import com.groupon.tracking.mobile.events.ABTest;
import com.groupon.tracking.mobile.events.APITransaction;
import com.groupon.tracking.mobile.events.AdTracking;
import com.groupon.tracking.mobile.events.AppStartup;
import com.groupon.tracking.mobile.events.AppStartupAttempt;
import com.groupon.tracking.mobile.events.CalendarView;
import com.groupon.tracking.mobile.events.CardScanStatus;
import com.groupon.tracking.mobile.events.CartStatus;
import com.groupon.tracking.mobile.events.Click;
import com.groupon.tracking.mobile.events.DealConfirmationView;
import com.groupon.tracking.mobile.events.DealImpression;
import com.groupon.tracking.mobile.events.DealPurchaseConfirmation;
import com.groupon.tracking.mobile.events.DealPurchaseInitiation;
import com.groupon.tracking.mobile.events.DealSearch;
import com.groupon.tracking.mobile.events.DealView;
import com.groupon.tracking.mobile.events.DeepLinking;
import com.groupon.tracking.mobile.events.FirstLaunchAfterDownload;
import com.groupon.tracking.mobile.events.GeneralEvent;
import com.groupon.tracking.mobile.events.GiftFinderCategory;
import com.groupon.tracking.mobile.events.Impression;
import com.groupon.tracking.mobile.events.InAppMessage;
import com.groupon.tracking.mobile.events.LocationTracking;
import com.groupon.tracking.mobile.events.Login;
import com.groupon.tracking.mobile.events.MobileEvent;
import com.groupon.tracking.mobile.events.MobileFunnelEvent;
import com.groupon.tracking.mobile.events.MultiOption;
import com.groupon.tracking.mobile.events.Onboard;
import com.groupon.tracking.mobile.events.PageLoad;
import com.groupon.tracking.mobile.events.PageView;
import com.groupon.tracking.mobile.events.PassbookInteraction;
import com.groupon.tracking.mobile.events.PushNotification;
import com.groupon.tracking.mobile.events.Redemption;
import com.groupon.tracking.mobile.events.ServerError;
import com.groupon.tracking.mobile.events.Share;
import com.groupon.tracking.mobile.events.SignUp;
import com.groupon.tracking.mobile.events.Spinner;
import com.groupon.tracking.mobile.events.SubscriptionSignUp;
import com.groupon.tracking.mobile.events.SubscriptionUnsubscribe;
import com.groupon.tracking.mobile.events.TextSearch;
import com.groupon.tracking.mobile.events.TravellerDetailView;
import com.groupon.tracking.mobile.events.UserInteraction;

// Referenced classes of package com.groupon.tracking.mobile:
//            EncodedNSTField

public abstract class MobileTrackingLogger
{

    public MobileTrackingLogger()
    {
    }

    public abstract void info(String s);

    public abstract void log(MobileEvent mobileevent);

    public abstract void log(Exception exception);

    public void logABTest(String s, String s1, String s2, String s3, String s4, EncodedNSTField encodednstfield)
    {
        try
        {
            log(new ABTest(s, s1, s2, s3, s4, encodednstfield));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logAPITransaction(String s, String s1, String s2, int i, long l, long l1, int j, String s3, EncodedNSTField encodednstfield)
    {
        try
        {
            log(new APITransaction(s, s1, s2, i, l, l1, j, s3, encodednstfield));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logAdTracking(String s, EncodedNSTField encodednstfield, EncodedNSTField encodednstfield1)
    {
        try
        {
            log(new AdTracking(s, encodednstfield, encodednstfield1));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logAppStartup(String s, long l, int i, EncodedNSTField encodednstfield)
    {
        try
        {
            log(new AppStartup(s, l, i, encodednstfield));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logAppStartupAttempt(String s, long l, EncodedNSTField encodednstfield)
    {
        try
        {
            log(new AppStartupAttempt(s, l, encodednstfield));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logCalendarView(String s, String s1, String s2, EncodedNSTField encodednstfield)
    {
        try
        {
            log(new CalendarView(s, s1, s2, encodednstfield));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logCardScanStatus(String s, String s1, String s2, EncodedNSTField encodednstfield)
    {
        try
        {
            log(new CardScanStatus(s, s1, s2, encodednstfield));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logCartStatus(String s, String s1, String s2, int i, float f, EncodedNSTField encodednstfield)
    {
        try
        {
            log(new CartStatus(s, s1, s2, i, f, encodednstfield));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logClick(String s, String s1, String s2, EncodedNSTField encodednstfield)
    {
        logClick(s, s1, s2, encodednstfield, null);
    }

    public void logClick(String s, String s1, String s2, EncodedNSTField encodednstfield, EncodedNSTField encodednstfield1)
    {
        if (encodednstfield == null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        encodednstfield = encodednstfield.toEncodedString();
_L1:
        log(new Click(s, s1, s2, encodednstfield, encodednstfield1));
        return;
        encodednstfield = "";
          goto _L1
        s;
        log(s);
        return;
    }

    public void logClick(String s, String s1, String s2, String s3)
    {
        try
        {
            log(new Click(s, s1, s2, s3, null));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logDealConfirmationView(String s, String s1, String s2, String s3, String s4, String s5, EncodedNSTField encodednstfield)
    {
        try
        {
            log(new DealConfirmationView(s, s1, s2, s3, s4, s5, encodednstfield));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logDealImpression(String s, String s1, String s2, String s3, int i, float f, String s4, 
            EncodedNSTField encodednstfield)
    {
        try
        {
            log(new DealImpression(s, s1, s2, s3, i, f, s4, encodednstfield));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logDealPurchaseConfirmation(String s, String s1, String s2, int i, String s3, String s4, String s5, 
            String s6, String s7, long l, String s8, String s9, String s10, 
            String s11, String s12, String s13, EncodedNSTField encodednstfield)
    {
        try
        {
            log(new DealPurchaseConfirmation(s, s1, s2, i, s3, s4, s5, s6, s7, l, s8, s9, s10, s11, s12, s13, encodednstfield));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logDealPurchaseInitiation(String s, String s1, String s2, int i, float f, String s3, String s4, 
            String s5, String s6, String s7, long l, String s8, String s9, 
            String s10, String s11, String s12, EncodedNSTField encodednstfield)
    {
        try
        {
            log(new DealPurchaseInitiation(s, s1, s2, i, f, s3, s4, s5, s6, s7, l, s8, s9, s10, s11, s12, encodednstfield));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logDealSearch(String s, String s1, String s2, String s3, String s4, float f, float f1, 
            String s5, int i, EncodedNSTField encodednstfield)
    {
        try
        {
            log(new DealSearch(s, s1, s2, s3, s4, f, f1, s5, i, encodednstfield));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logDealView(String s, String s1, String s2, String s3, EncodedNSTField encodednstfield)
    {
        try
        {
            log(new DealView(s, s1, s2, s3, encodednstfield));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logDeepLinking(String s, String s1, String s2, String s3, String s4, String s5)
    {
        try
        {
            log(new DeepLinking(s, s1, s2, s3, s4, s5));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logFirstLaunchAfterDownload(String s, String s1, String s2, String s3, String s4, EncodedNSTField encodednstfield)
    {
        try
        {
            log(new FirstLaunchAfterDownload(s, s1, s2, s3, s4, encodednstfield));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logGeneralEvent(String s, String s1, String s2, int i, EncodedNSTField encodednstfield)
    {
        try
        {
            log(new GeneralEvent(s, s1, s2, i, encodednstfield));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logGiftFinderCategory(String s, int i, EncodedNSTField encodednstfield)
    {
        try
        {
            log(new GiftFinderCategory(s, i, encodednstfield));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logImpression(String s, String s1, String s2, String s3, EncodedNSTField encodednstfield)
    {
        try
        {
            log(new Impression(s, s1, s2, s3, encodednstfield));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logInAppMessage(String s, String s1, String s2, String s3, EncodedNSTField encodednstfield)
    {
        try
        {
            log(new InAppMessage(s, s1, s2, s3, encodednstfield));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logLocationTracking(String s, float f, float f1, int i, long l, EncodedNSTField encodednstfield)
    {
        try
        {
            log(new LocationTracking(s, f, f1, i, l, encodednstfield));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logLogin(String s, String s1, String s2, EncodedNSTField encodednstfield)
    {
        try
        {
            log(new Login(s, s1, s2, encodednstfield));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logMobileFunnelEvent(String s, String s1)
    {
        try
        {
            log(new MobileFunnelEvent(s, s1));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logMultiOption(String s, String s1, String s2, int i, int j, String s3)
    {
        try
        {
            log(new MultiOption(s, s1, s2, i, j, s3));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logOnboard(String s, String s1, String s2, String s3, String s4, EncodedNSTField encodednstfield)
    {
        try
        {
            log(new Onboard(s, s1, s2, s3, s4, encodednstfield));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logPageLoad(String s, String s1, int i, long l, int j, EncodedNSTField encodednstfield)
    {
        try
        {
            log(new PageLoad(s, s1, i, l, j, encodednstfield));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logPageView(String s, String s1, EncodedNSTField encodednstfield)
    {
        try
        {
            log(new PageView(s, s1, encodednstfield));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logPassbookInteraction(String s, String s1, String s2, EncodedNSTField encodednstfield)
    {
        try
        {
            log(new PassbookInteraction(s, s1, s2, encodednstfield));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logPushNotification(String s, String s1, String s2, String s3, long l, EncodedNSTField encodednstfield)
    {
        try
        {
            log(new PushNotification(s, s1, s2, s3, l, encodednstfield));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logRedemption(String s, String s1, EncodedNSTField encodednstfield)
    {
        try
        {
            log(new Redemption(s, s1, encodednstfield));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logServerError(String s, String s1, long l, String s2, String s3, int i, 
            String s4, String s5, String s6, String s7)
    {
        try
        {
            log(new ServerError(s, s1, l, s2, s3, i, s4, s5, s6, s7));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logShare(String s, String s1, EncodedNSTField encodednstfield)
    {
        try
        {
            log(new Share(s, s1, encodednstfield));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logSignUp(String s, String s1, String s2, String s3, long l, String s4, 
            String s5, EncodedNSTField encodednstfield)
    {
        try
        {
            log(new SignUp(s, s1, s2, s3, l, s4, s5, encodednstfield));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logSpinner(String s, String s1, long l, String s2, EncodedNSTField encodednstfield)
    {
        try
        {
            log(new Spinner(s, s1, l, s2, encodednstfield));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logSubscriptionSignUp(String s, String s1, String s2, String s3, String s4, String s5, long l, String s6, String s7, EncodedNSTField encodednstfield)
    {
        try
        {
            log(new SubscriptionSignUp(s, s1, s2, s3, s4, s5, l, s6, s7, encodednstfield));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logSubscriptionUnsubscribe(String s, String s1, String s2, String s3, String s4, String s5, long l, String s6, String s7, EncodedNSTField encodednstfield)
    {
        try
        {
            log(new SubscriptionUnsubscribe(s, s1, s2, s3, s4, s5, l, s6, s7, encodednstfield));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logTextSearch(String s, String s1, String s2, int i, EncodedNSTField encodednstfield)
    {
        try
        {
            log(new TextSearch(s, s1, s2, i, encodednstfield));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logTravellerDetailView(String s, String s1, EncodedNSTField encodednstfield)
    {
        try
        {
            log(new TravellerDetailView(s, s1, encodednstfield));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }

    public void logUserInteraction(String s, String s1, String s2, String s3, EncodedNSTField encodednstfield)
    {
        try
        {
            log(new UserInteraction(s, s1, s2, s3, encodednstfield));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log(s);
        }
    }
}
