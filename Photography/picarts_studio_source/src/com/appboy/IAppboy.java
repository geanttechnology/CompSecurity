// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appboy;

import android.app.Activity;
import android.widget.ImageView;
import com.appboy.enums.SocialNetwork;
import java.math.BigDecimal;
import myobfuscated.e.b;
import myobfuscated.h.a;

// Referenced classes of package com.appboy:
//            AppboyUser, IAppboyNavigator

public interface IAppboy
{

    public abstract AppboyUser changeUser(String s);

    public abstract boolean closeSession(Activity activity);

    public abstract void fetchAndRenderImage(String s, ImageView imageview);

    public abstract void fetchAndRenderImage(String s, ImageView imageview, boolean flag);

    public abstract IAppboyNavigator getAppboyNavigator();

    public abstract String getAppboyPushMessageRegistrationId();

    public abstract AppboyUser getCurrentUser();

    public abstract String getInstallTrackingId();

    public abstract boolean logCustomEvent(String s);

    public abstract boolean logCustomEvent(String s, a a);

    public abstract boolean logFeedCardClick(String s);

    public abstract boolean logFeedCardImpression(String s);

    public abstract boolean logFeedDisplayed();

    public abstract boolean logFeedbackDisplayed();

    public abstract boolean logPurchase(String s, int i);

    public abstract boolean logPurchase(String s, String s1, BigDecimal bigdecimal);

    public abstract boolean logPurchase(String s, String s1, BigDecimal bigdecimal, int i);

    public abstract boolean logPurchase(String s, String s1, BigDecimal bigdecimal, int i, a a);

    public abstract boolean logPurchase(String s, String s1, BigDecimal bigdecimal, a a);

    public abstract boolean logPushNotificationActionClicked(String s, String s1);

    public abstract boolean logPushNotificationOpened(String s);

    public abstract boolean logShare(SocialNetwork socialnetwork);

    public abstract boolean openSession(Activity activity);

    public abstract void registerAppboyGcmMessages(String s);

    public abstract void registerAppboyPushMessages(String s);

    public abstract void removeSingleSubscription(b b, Class class1);

    public abstract void requestFeedRefresh();

    public abstract void requestFeedRefreshFromCache();

    public abstract void requestImmediateDataFlush();

    public abstract void requestInAppMessageRefresh();

    public abstract void setAppboyNavigator(IAppboyNavigator iappboynavigator);

    public abstract boolean submitFeedback(String s, String s1, boolean flag);

    public abstract void subscribeToFeedUpdates(b b);

    public abstract void subscribeToFeedbackRequestEvents(b b, b b1);

    public abstract void subscribeToNewInAppMessages(b b);

    public abstract void unregisterAppboyPushMessages();
}
