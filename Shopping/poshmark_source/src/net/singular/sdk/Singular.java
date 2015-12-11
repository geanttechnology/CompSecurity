// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.singular.sdk;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package net.singular.sdk:
//            Controller, SingularLog, NewInjector

public class Singular
{

    protected static Controller controller = null;
    protected static boolean initialized = false;
    protected static SingularLog log;

    public Singular()
    {
    }

    public static void appOpen(Uri uri)
    {
        boolean flag = checkInitialized("appOpen()");
        while (!flag || uri == null) 
        {
            return;
        }
        JSONObject jsonobject = controller.initEvent("DEEP_URL", true);
        jsonobject.put("url", uri.toString());
        controller.postEventDelayed(jsonobject);
        return;
        uri;
        try
        {
            controller.getLogger().e("singular_sdk", "Trying to log deep url open with an invalid intentData argument");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Uri uri)
        {
            logRuntimeError(uri, "appOpen()");
        }
        return;
    }

    private static boolean checkInitialized(String s)
    {
        if (!initialized)
        {
            Log.e("singular_sdk", String.format("Tried calling %s without calling Singular.initialize() first", new Object[] {
                s
            }));
            return false;
        } else
        {
            return true;
        }
    }

    public static String getSingularId()
    {
        if (!checkInitialized("getSingularId()"))
        {
            return null;
        }
        String s;
        try
        {
            s = controller.getSingularId();
        }
        catch (RuntimeException runtimeexception)
        {
            logRuntimeError(runtimeexception, "getSingularId()");
            return null;
        }
        return s;
    }

    static SingularLog getSingularLog()
    {
        return log;
    }

    public static void initialize(Context context)
    {
        initialize(context, false);
    }

    public static void initialize(Context context, boolean flag)
    {
        try
        {
            if (!initialized)
            {
                context = new NewInjector(context, flag);
                controller = context.getController();
                log = context.getSingularLog();
                initialized = true;
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.e("singular_sdk", "Initialization failed!", context);
        }
    }

    private static void logRuntimeError(RuntimeException runtimeexception, String s)
    {
        try
        {
            log.e("singular_sdk", String.format("Singular:%s failed", new Object[] {
                s
            }), runtimeexception);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (RuntimeException runtimeexception)
        {
            return;
        }
    }

    public static void onPause()
    {
        if (!checkInitialized("onPause()"))
        {
            return;
        }
        try
        {
            controller.onPause();
            return;
        }
        catch (RuntimeException runtimeexception)
        {
            logRuntimeError(runtimeexception, "onPause()");
        }
        return;
    }

    public static void onResume()
    {
        if (!checkInitialized("onResume()"))
        {
            return;
        }
        try
        {
            controller.onResume();
            return;
        }
        catch (RuntimeException runtimeexception)
        {
            logRuntimeError(runtimeexception, "onResume()");
        }
        return;
    }

    public static void setCustomUserId(String s)
    {
        if (!checkInitialized("setCustomUserId()"))
        {
            return;
        }
        try
        {
            controller.setTemporalId("user_id", s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logRuntimeError(s, "setCustomUserId()");
        }
        return;
    }

    public static void setDefaultCurrency(String s)
    {
        if (!checkInitialized("setDefaultCurrency()"))
        {
            return;
        }
        try
        {
            controller.setDefaultCurrency(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logRuntimeError(s, "setDefaultCurrency()");
        }
        return;
    }

    public static void setFacebookId(String s)
    {
        if (!checkInitialized("setFacebookId()"))
        {
            return;
        }
        try
        {
            controller.setTemporalId("fb_user_id", s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logRuntimeError(s, "setFacebookId()");
        }
        return;
    }

    public static void setGoogleId(String s)
    {
        if (!checkInitialized("setGoogleId()"))
        {
            return;
        }
        try
        {
            controller.setTemporalId("google_user_id", s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logRuntimeError(s, "setGoogleId()");
        }
        return;
    }

    public static void setTwitterId(String s)
    {
        if (!checkInitialized("setTwitterId()"))
        {
            return;
        }
        try
        {
            controller.setTemporalId("twitter_user_id", s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logRuntimeError(s, "setTwitterId()");
        }
        return;
    }

    public static void trackEvent(String s)
    {
        try
        {
            trackEvent(s, (String)null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logRuntimeError(s, "trackEvent()");
        }
    }

    public static void trackEvent(String s, String s1)
    {
        try
        {
            trackEvent(s, s1, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logRuntimeError(s, "trackEvent()");
        }
    }

    public static void trackEvent(String s, String s1, String s2)
    {
        try
        {
            trackEvent(s, s1, s2, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logRuntimeError(s, "trackEvent()");
        }
    }

    public static void trackEvent(String s, String s1, String s2, String s3)
    {
        try
        {
            trackEvent(s, s1, s2, s3, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logRuntimeError(s, "trackEvent()");
        }
    }

    public static void trackEvent(String s, String s1, String s2, String s3, String s4)
    {
        try
        {
            trackEvent(s, s1, s2, s3, s4, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logRuntimeError(s, "trackEvent()");
        }
    }

    public static void trackEvent(String s, String s1, String s2, String s3, String s4, String s5)
    {
        trackEvent(s, s1, s2, s3, s4, s5, false);
    }

    private static void trackEvent(String s, String s1, String s2, String s3, String s4, String s5, boolean flag)
    {
        boolean flag1 = checkInitialized("trackEvent()");
        while (!flag1 || s == null) 
        {
            return;
        }
        s = controller.initEvent(s, s1, s2, s3, s4, s5, flag);
        controller.postEventDelayed(s);
        return;
        s;
        try
        {
            controller.getLogger().e("singular_sdk", "Trying to log revenue with an invalid amount");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logRuntimeError(s, "trackEvent()");
        }
        return;
    }

    public static void trackEvent(String s, JSONObject jsonobject)
    {
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        if (jsonobject instanceof JSONObject)
        {
            break MISSING_BLOCK_LABEL_22;
        }
        jsonobject = jsonobject.toString();
_L2:
        trackEvent(s, ((String) (jsonobject)));
        return;
        jsonobject = JSONObjectInstrumentation.toString((JSONObject)jsonobject);
        if (true) goto _L2; else goto _L1
_L1:
        try
        {
            trackEvent(s);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logRuntimeError(s, "trackEvent()");
        }
        return;
    }

    static void trackReferralId(String s)
    {
        if (!checkInitialized("trackReferralId()"))
        {
            return;
        }
        try
        {
            controller.setReferralId(s);
            trackEvent("GOT_PLAY_REFERRER", null, null, null, null, null, true);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logRuntimeError(s, "trackReferralId()");
        }
        return;
    }

    public static void trackRevenue(double d)
    {
        if (!checkInitialized("trackRevenue()"))
        {
            return;
        }
        try
        {
            trackRevenue(d, controller.getDefaultCurrency());
            return;
        }
        catch (RuntimeException runtimeexception)
        {
            logRuntimeError(runtimeexception, "trackRevenue()");
        }
        return;
    }

    public static void trackRevenue(double d, String s)
    {
        try
        {
            trackRevenue(d, s, ((String) (null)), null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logRuntimeError(s, "trackRevenue()");
        }
    }

    public static void trackRevenue(double d, String s, String s1)
    {
        if (!checkInitialized("trackRevenue()"))
        {
            return;
        }
        try
        {
            trackRevenue(d, controller.getDefaultCurrency(), s, s1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logRuntimeError(s, "trackRevenue()");
        }
        return;
    }

    public static void trackRevenue(double d, String s, String s1, String s2)
    {
        try
        {
            trackRevenue(null, 1, d, s, s1, s2);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logRuntimeError(s, "trackRevenue()");
        }
    }

    public static void trackRevenue(String s, int i, double d)
    {
        if (!checkInitialized("trackRevenue()"))
        {
            return;
        }
        try
        {
            trackRevenue(s, i, d, controller.getDefaultCurrency());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logRuntimeError(s, "trackRevenue()");
        }
        return;
    }

    public static void trackRevenue(String s, int i, double d, String s1)
    {
        try
        {
            trackRevenue(s, i, d, s1, null, null);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logRuntimeError(s, "trackRevenue()");
        }
    }

    public static void trackRevenue(String s, int i, double d, String s1, String s2, String s3)
    {
        boolean flag = checkInitialized("trackRevenue()");
        if (!flag)
        {
            return;
        }
        JSONObject jsonobject = controller.initEvent("REVENUE", true);
        jsonobject.put("product_id", s);
        jsonobject.put("quantity", i);
        jsonobject.put("revenue", d);
        jsonobject.put("currency", s1);
        jsonobject.put("purchase_receipt", s2);
        jsonobject.put("purchase_receipt_signature", s3);
        controller.postEventDelayed(jsonobject);
        return;
        s;
        try
        {
            controller.getLogger().e("singular_sdk", "Trying to log revenue with an invalid price");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            logRuntimeError(s, "trackRevenue()");
        }
        return;
    }

    public static void unsetAllUserIds()
    {
        if (!checkInitialized("unsetAllUserIds()"))
        {
            return;
        }
        try
        {
            controller.clearTemporalIds();
            return;
        }
        catch (RuntimeException runtimeexception)
        {
            logRuntimeError(runtimeexception, "unsetAllUserIds()");
        }
        return;
    }

    public static void unsetCustomUserId()
    {
        if (!checkInitialized("unsetCustomUserId()"))
        {
            return;
        }
        try
        {
            controller.unsetTemporalId("user_id");
            return;
        }
        catch (RuntimeException runtimeexception)
        {
            logRuntimeError(runtimeexception, "unsetCustomUserId()");
        }
        return;
    }

    public static void unsetFacebookId()
    {
        if (!checkInitialized("unsetFacebookId()"))
        {
            return;
        }
        try
        {
            controller.unsetTemporalId("fb_user_id");
            return;
        }
        catch (RuntimeException runtimeexception)
        {
            logRuntimeError(runtimeexception, "unsetFacebookId()");
        }
        return;
    }

    public static void unsetGoogleId()
    {
        if (!checkInitialized("unsetGoogleId()"))
        {
            return;
        }
        try
        {
            controller.unsetTemporalId("google_user_id");
            return;
        }
        catch (RuntimeException runtimeexception)
        {
            logRuntimeError(runtimeexception, "unsetGoogleId()");
        }
        return;
    }

    public static void unsetTwitterId()
    {
        if (!checkInitialized("unsetTwitterId()"))
        {
            return;
        }
        try
        {
            controller.unsetTemporalId("twitter_user_id");
            return;
        }
        catch (RuntimeException runtimeexception)
        {
            logRuntimeError(runtimeexception, "unsetTwitterId()");
        }
        return;
    }

}
