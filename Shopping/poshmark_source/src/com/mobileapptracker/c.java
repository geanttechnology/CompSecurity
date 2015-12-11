// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobileapptracker;

import android.content.Context;
import android.os.Bundle;
import java.lang.reflect.Method;
import java.util.Locale;

// Referenced classes of package com.mobileapptracker:
//            MATEvent, MATParameters

final class c
{

    private static Object a;
    private static boolean b = false;

    public static void a(Context context, boolean flag)
    {
        Class aclass[] = new Class[1];
        aclass[0] = android/content/Context;
        Class class1;
        Method method;
        Object aobj[];
        class1 = Boolean.TYPE;
        method = Class.forName("com.facebook.AppEventsLogger").getMethod("activateApp", aclass);
        aobj = new Object[1];
        aobj[0] = context;
        try
        {
            method.invoke(null, aobj);
            b = true;
            Class.forName("com.facebook.Settings").getMethod("setLimitEventAndDataUsage", new Class[] {
                android/content/Context, class1
            }).invoke(null, new Object[] {
                context, Boolean.valueOf(flag)
            });
            a = Class.forName("com.facebook.AppEventsLogger").getMethod("newLogger", aclass).invoke(null, aobj);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            context.printStackTrace();
        }
        return;
    }

    private static void a(Bundle bundle, String s, String s1)
    {
        if (s1 != null)
        {
            bundle.putString(s, s1);
        }
    }

    public static void a(MATEvent matevent)
    {
        if (a == null) goto _L2; else goto _L1
_L1:
        double d1;
        Object obj;
        Method method;
        MATParameters matparameters;
        Object obj1;
        obj = Double.TYPE;
        method = a.getClass().getMethod("logEvent", new Class[] {
            java/lang/String, obj, android/os/Bundle
        });
        obj = matevent.getEventName();
        d1 = matevent.getRevenue();
        matparameters = MATParameters.getInstance();
        obj1 = matevent.getEventName().toLowerCase(Locale.US);
        if (!((String) (obj1)).contains("session")) goto _L4; else goto _L3
_L3:
        if (b)
        {
            return;
        }
          goto _L5
_L7:
        double d;
        try
        {
            obj1 = new Bundle();
            a(((Bundle) (obj1)), "fb_currency", matevent.getCurrencyCode());
            a(((Bundle) (obj1)), "fb_content_id", matparameters.getEventContentId());
            a(((Bundle) (obj1)), "fb_content_type", matparameters.getEventContentType());
            a(((Bundle) (obj1)), "fb_search_string", matparameters.getEventSearchString());
            a(((Bundle) (obj1)), "fb_num_items", matparameters.getEventQuantity());
            a(((Bundle) (obj1)), "fb_level", matparameters.getEventLevel());
            a(((Bundle) (obj1)), "tune_referral_source", matparameters.getReferralSource());
            a(((Bundle) (obj1)), "tune_source_sdk", "TUNE-MAT");
            method.invoke(a, new Object[] {
                obj, Double.valueOf(d), obj1
            });
            b = false;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MATEvent matevent)
        {
            matevent.printStackTrace();
        }
        return;
_L4:
        if (((String) (obj1)).contains("registration"))
        {
            obj = "fb_mobile_complete_registration";
            d = d1;
            continue; /* Loop/switch isn't completed */
        }
        if (((String) (obj1)).contains("content_view"))
        {
            obj = "fb_mobile_content_view";
            d = d1;
            continue; /* Loop/switch isn't completed */
        }
        if (((String) (obj1)).contains("search"))
        {
            obj = "fb_mobile_search";
            d = d1;
            continue; /* Loop/switch isn't completed */
        }
        if (((String) (obj1)).contains("rated"))
        {
            obj = "fb_mobile_rate";
            Exception exception;
            try
            {
                d = Double.parseDouble(matparameters.getEventRating());
            }
            catch (Exception exception1)
            {
                d = d1;
            }
            continue; /* Loop/switch isn't completed */
        }
        if (((String) (obj1)).contains("tutorial_complete"))
        {
            obj = "fb_mobile_tutorial_completion";
            d = d1;
            continue; /* Loop/switch isn't completed */
        }
        if (((String) (obj1)).contains("add_to_cart"))
        {
            obj = "fb_mobile_add_to_cart";
            d = d1;
            continue; /* Loop/switch isn't completed */
        }
        if (((String) (obj1)).contains("add_to_wishlist"))
        {
            obj = "fb_mobile_add_to_wishlist";
            d = d1;
            continue; /* Loop/switch isn't completed */
        }
        if (((String) (obj1)).contains("checkout_initiated"))
        {
            obj = "fb_mobile_initiated_checkout";
            d = d1;
            continue; /* Loop/switch isn't completed */
        }
        if (((String) (obj1)).contains("added_payment_info"))
        {
            obj = "fb_mobile_add_payment_info";
            d = d1;
            continue; /* Loop/switch isn't completed */
        }
        if (((String) (obj1)).contains("purchase"))
        {
            obj = "fb_mobile_purchase";
            d = d1;
            continue; /* Loop/switch isn't completed */
        }
        if (((String) (obj1)).contains("level_achieved"))
        {
            obj = "fb_mobile_level_achieved";
            d = d1;
            continue; /* Loop/switch isn't completed */
        }
        if (((String) (obj1)).contains("achievement_unlocked"))
        {
            obj = "fb_mobile_achievement_unlocked";
            d = d1;
            continue; /* Loop/switch isn't completed */
        }
        d = d1;
        if (((String) (obj1)).contains("spent_credits"))
        {
            obj = "fb_mobile_spent_credits";
            try
            {
                d = Double.parseDouble(matparameters.getEventQuantity());
            }
            // Misplaced declaration of an exception variable
            catch (Exception exception)
            {
                d = d1;
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        return;
_L5:
        obj = "fb_mobile_activate_app";
        d = d1;
        if (true) goto _L7; else goto _L6
_L6:
    }

}
