// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import com.tapjoy.internal.ef;
import java.util.Hashtable;
import java.util.Map;

// Referenced classes of package com.tapjoy:
//            TJAwardCurrencyListener, TJConnectListener, TJGetCurrencyBalanceListener, TJEarnedCurrencyListener, 
//            TJViewListener, TJVideoListener, TJOffersListener, TJSpendCurrencyListener

public final class Tapjoy
{

    public static final String INTENT_EXTRA_PUSH_PAYLOAD = "com.tapjoy.PUSH_PAYLOAD";

    public Tapjoy()
    {
    }

    public static void actionComplete(String s)
    {
        ef.a().e(s);
    }

    public static void awardCurrency(int i, TJAwardCurrencyListener tjawardcurrencylistener)
    {
        ef.a().a(i, tjawardcurrencylistener);
    }

    public static boolean connect(Context context, String s)
    {
        return ef.a().a(context, s);
    }

    public static boolean connect(Context context, String s, Hashtable hashtable)
    {
        return ef.a().a(context, s, hashtable, null);
    }

    public static boolean connect(Context context, String s, Hashtable hashtable, TJConnectListener tjconnectlistener)
    {
        com/tapjoy/Tapjoy;
        JVM INSTR monitorenter ;
        boolean flag = ef.a().a(context, s, hashtable, tjconnectlistener);
        com/tapjoy/Tapjoy;
        JVM INSTR monitorexit ;
        return flag;
        context;
        throw context;
    }

    public static void enablePaidAppWithActionID(String s)
    {
        ef.a().d(s);
    }

    public static void endSession()
    {
        ef.a().f();
    }

    public static void getCurrencyBalance(TJGetCurrencyBalanceListener tjgetcurrencybalancelistener)
    {
        ef.a().a(tjgetcurrencybalancelistener);
    }

    public static float getCurrencyMultiplier()
    {
        return ef.a().d();
    }

    public static String getVersion()
    {
        return ef.a().b();
    }

    public static boolean isConnected()
    {
        return ef.a().h();
    }

    public static boolean isPushNotificationDisabled()
    {
        return ef.a().g();
    }

    public static void loadSharedLibrary()
    {
        try
        {
            System.loadLibrary("tapjoy");
            return;
        }
        catch (UnsatisfiedLinkError unsatisfiedlinkerror)
        {
            return;
        }
    }

    public static void onActivityStart(Activity activity)
    {
        ef.a().a(activity);
    }

    public static void onActivityStop(Activity activity)
    {
        ef.a().b(activity);
    }

    public static void setAppDataVersion(String s)
    {
        ef.a().c(s);
    }

    public static void setCurrencyMultiplier(float f)
    {
        ef.a().a(f);
    }

    public static void setDebugEnabled(boolean flag)
    {
        ef.a().a(flag);
    }

    public static void setEarnedCurrencyListener(TJEarnedCurrencyListener tjearnedcurrencylistener)
    {
        ef.a().a(tjearnedcurrencylistener);
    }

    public static void setGLSurfaceView(GLSurfaceView glsurfaceview)
    {
        ef.a().a(glsurfaceview);
    }

    public static void setGcmSender(String s)
    {
        ef.a().f(s);
    }

    public static void setPushNotificationDisabled(boolean flag)
    {
        ef.a().b(flag);
    }

    public static void setTapjoyViewListener(TJViewListener tjviewlistener)
    {
        ef.a().a(tjviewlistener);
    }

    public static void setUserCohortVariable(int i, String s)
    {
        ef.a().a(i, s);
    }

    public static void setUserFriendCount(int i)
    {
        ef.a().b(i);
    }

    public static void setUserID(String s)
    {
        ef.a().b(s);
    }

    public static void setUserLevel(int i)
    {
        ef.a().a(i);
    }

    public static void setVideoListener(TJVideoListener tjvideolistener)
    {
        ef.a().a(tjvideolistener);
    }

    public static void showOffers()
    {
        ef.a().c();
    }

    public static void showOffers(TJOffersListener tjofferslistener)
    {
        ef.a().a(tjofferslistener);
    }

    public static void showOffersWithCurrencyID(String s, boolean flag)
    {
        ef.a().a(s, flag);
    }

    public static void showOffersWithCurrencyID(String s, boolean flag, TJOffersListener tjofferslistener)
    {
        ef.a().a(s, flag, tjofferslistener);
    }

    public static void spendCurrency(int i, TJSpendCurrencyListener tjspendcurrencylistener)
    {
        ef.a().a(i, tjspendcurrencylistener);
    }

    public static void startSession()
    {
        ef.a().e();
    }

    public static void trackEvent(String s)
    {
        ef.a().a(s);
    }

    public static void trackEvent(String s, long l)
    {
        ef.a().a(s, l);
    }

    public static void trackEvent(String s, String s1, long l)
    {
        ef.a().a(s, s1, l);
    }

    public static void trackEvent(String s, String s1, String s2, String s3)
    {
        ef.a().b(s, s1, s2, s3);
    }

    public static void trackEvent(String s, String s1, String s2, String s3, long l)
    {
        ef.a().a(s, s1, s2, s3, l);
    }

    public static void trackEvent(String s, String s1, String s2, String s3, String s4, long l)
    {
        ef.a().a(s, s1, s2, s3, s4, l);
    }

    public static void trackEvent(String s, String s1, String s2, String s3, String s4, long l, String s5, 
            long l1)
    {
        ef.a().a(s, s1, s2, s3, s4, l, s5, l1);
    }

    public static void trackEvent(String s, String s1, String s2, String s3, String s4, long l, String s5, 
            long l1, String s6, long l2)
    {
        ef.a().a(s, s1, s2, s3, s4, l, s5, l1, s6, l2);
    }

    public static void trackEvent(String s, String s1, String s2, String s3, Map map)
    {
        ef.a().a(s, s1, s2, s3, map);
    }

    public static void trackPurchase(String s, String s1)
    {
        ef.a().a(s, s1);
    }

    public static void trackPurchase(String s, String s1, double d, String s2)
    {
        ef.a().a(s, s1, d, s2);
    }

    public static void trackPurchase(String s, String s1, String s2, String s3)
    {
        ef.a().a(s, s1, s2, s3);
    }
}
