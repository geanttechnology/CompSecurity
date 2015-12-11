// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.SharedPreferences;
import com.abtnprojects.ambatana.models.CurrentUserLocation;
import com.abtnprojects.ambatana.models.SearchParameters;
import java.util.Locale;

// Referenced classes of package android.support.v7:
//            iq, aqo

public class is
{

    public static SearchParameters a(Context context)
    {
        SearchParameters searchparameters = SearchParameters.fromJSON(b(context, null, iq.b));
        context = searchparameters;
        if (searchparameters == null)
        {
            context = new SearchParameters();
        }
        return context;
    }

    public static String a(Context context, Locale locale)
    {
        String s1 = "km";
        String s = s1;
        if (locale != null)
        {
            s = s1;
            if (a(locale))
            {
                s = "mi";
            }
        }
        locale = b(context, s, "distance_type");
        if ("ML".equals(locale))
        {
            s = "mi";
            a(context, "mi");
        } else
        {
            if ("KM".equals(locale))
            {
                a(context, "km");
                return "km";
            }
            if ("mi".equals(locale))
            {
                return "mi";
            }
            if ("km".equals(locale))
            {
                return "km";
            }
        }
        return s;
    }

    public static void a(Context context, int i1)
    {
        context = context.getSharedPreferences(iq.a, 0).edit();
        context.putInt("target_version", i1);
        context.commit();
    }

    public static void a(Context context, long l1)
    {
        context = context.getSharedPreferences(iq.a, 0).edit();
        context.putLong("rating_dialog_timestamp", l1);
        context.apply();
    }

    public static void a(Context context, CurrentUserLocation currentuserlocation)
    {
        context = context.getSharedPreferences(iq.a, 0).edit();
        context.putString("location_when_set_to_manual", currentuserlocation.toJSON());
        context.apply();
    }

    public static void a(Context context, SearchParameters searchparameters)
    {
        a(context, searchparameters.toJSON(), iq.b);
    }

    public static void a(Context context, String s)
    {
        a(context, s, "distance_type");
    }

    public static void a(Context context, String s, String s1)
    {
        context = context.getSharedPreferences(iq.a, 0).edit();
        context.putString(s1, s);
        context.commit();
    }

    public static void a(Context context, boolean flag)
    {
        context = context.getSharedPreferences(iq.a, 0).edit();
        context.putBoolean("force_update_pref", flag);
        context.commit();
    }

    protected static boolean a(Locale locale)
    {
        locale = locale.getCountry();
        return "US".equals(locale) || "LR".equals(locale) || "MM".equals(locale);
    }

    public static String b(Context context, String s, String s1)
    {
        return context.getSharedPreferences(iq.a, 0).getString(s1, s);
    }

    public static void b(Context context)
    {
        context = context.getSharedPreferences(iq.a, 0).edit();
        context.remove(iq.b);
        context.commit();
    }

    public static void b(Context context, int i1)
    {
        context = context.getSharedPreferences(iq.a, 0).edit();
        context.putInt("last_safety_tip_viewed", i1);
        context.apply();
    }

    public static void b(Context context, String s)
    {
        a(context, s, "update_url_pref");
    }

    public static void b(Context context, boolean flag)
    {
        context = context.getSharedPreferences(iq.a, 0).edit();
        context.putBoolean("approximate_address", flag);
        context.commit();
    }

    public static void c(Context context, boolean flag)
    {
        context = context.getSharedPreferences(iq.a, 0).edit();
        context.putBoolean("location_modified", flag);
        context.commit();
    }

    public static boolean c(Context context)
    {
        context = context.getSharedPreferences(iq.a, 0);
        int i1 = context.getInt("target_version", -1);
        aqo.a("SharedPrefInt %d", new Object[] {
            Integer.valueOf(i1)
        });
        return context.getBoolean("force_update_pref", false) && 175 < i1;
    }

    public static String d(Context context)
    {
        return b(context, null, "update_url_pref");
    }

    public static void d(Context context, boolean flag)
    {
        context = context.getSharedPreferences(iq.a, 0).edit();
        context.putBoolean("location_set_manually", flag);
        context.commit();
    }

    public static boolean e(Context context)
    {
        return context.getSharedPreferences(iq.a, 0).getBoolean("approximate_address", true);
    }

    public static boolean f(Context context)
    {
        return context.getSharedPreferences(iq.a, 0).getBoolean("location_modified", false);
    }

    public static boolean g(Context context)
    {
        return context.getSharedPreferences(iq.a, 0).getBoolean("location_set_manually", false);
    }

    public static void h(Context context)
    {
        context = context.getSharedPreferences(iq.a, 0).edit();
        context.remove("location_when_set_to_manual");
        context.apply();
    }

    public static void i(Context context)
    {
        context = context.getSharedPreferences(iq.a, 0).edit();
        context.remove("location_when_set_to_manual");
        context.remove("location_set_manually");
        context.remove("location_modified");
        context.remove("approximate_address");
        context.commit();
    }

    public static boolean j(Context context)
    {
        boolean flag = false;
        if (context.getSharedPreferences(iq.a, 0).getLong("rating_dialog_timestamp", 0L) != 0L)
        {
            flag = true;
        }
        return flag;
    }

    public static void k(Context context)
    {
        context = context.getSharedPreferences(iq.a, 0);
        android.content.SharedPreferences.Editor editor = context.edit();
        if (context.contains("rating_dialog_timestamp"))
        {
            editor.remove("rating_dialog_timestamp");
            editor.apply();
        }
    }

    public static int l(Context context)
    {
        return context.getSharedPreferences(iq.a, 0).getInt("last_safety_tip_viewed", -1);
    }

    public static void m(Context context)
    {
        context = context.getSharedPreferences(iq.a, 0);
        android.content.SharedPreferences.Editor editor = context.edit();
        if (context.contains("last_safety_tip_viewed"))
        {
            editor.remove("last_safety_tip_viewed");
            editor.apply();
        }
    }
}
