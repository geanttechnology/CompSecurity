// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import android.os.Build;
import android.support.v4.e.a;
import android.text.Html;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.b.a.a.g;
import com.b.a.a.j;
import com.offerup.android.activities.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.utils:
//            au, n, at

public class as
{

    private static Map a;
    private j b;
    private Context c;

    public as(j j1, Context context)
    {
        b = j1;
        c = context;
    }

    public static Address a(Context context, double d, double d1)
    {
        if (android.os.Build.VERSION.SDK_INT >= 9 && !Geocoder.isPresent()) goto _L2; else goto _L1
_L1:
        Object obj = (new Geocoder(context, Locale.getDefault())).getFromLocation(d, d1, 1);
        if (obj == null) goto _L2; else goto _L3
_L3:
        if (((List) (obj)).size() <= 0) goto _L2; else goto _L4
_L4:
        obj = (Address)((List) (obj)).get(0);
_L6:
        Object obj1 = obj;
        if (obj == null)
        {
            if (android.support.v4.e.a.b(context))
            {
                obj = android.support.v4.e.a.a(Double.valueOf(d), Double.valueOf(d1));
            }
            obj1 = obj;
            if (obj == null)
            {
                obj1 = new Address(Locale.getDefault());
                ((Address) (obj1)).setLongitude(d1);
                ((Address) (obj1)).setLatitude(d);
            }
        }
        return ((Address) (obj1));
        obj;
        g.a("OfferUpUtils", ((Throwable) (obj)));
_L2:
        obj = null;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static Address a(Context context, String s)
    {
        Object obj = (new Geocoder(context)).getFromLocationName(s, 3);
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (((List) (obj)).isEmpty()) goto _L2; else goto _L3
_L3:
        Iterator iterator = ((List) (obj)).iterator();
_L6:
        if (!iterator.hasNext()) goto _L2; else goto _L4
_L4:
        Address address = (Address)iterator.next();
        if (!address.hasLatitude()) goto _L6; else goto _L5
_L5:
        obj = address;
        boolean flag;
        if ("us".equalsIgnoreCase(address.getCountryCode()))
        {
            break MISSING_BLOCK_LABEL_95;
        }
        flag = "usa".equalsIgnoreCase(address.getCountryCode());
        if (!flag) goto _L6; else goto _L7
_L7:
        obj = address;
_L9:
        Address address1 = ((Address) (obj));
        if (obj == null)
        {
            if (android.support.v4.e.a.b(context))
            {
                obj = android.support.v4.e.a.b(s);
            }
            address1 = ((Address) (obj));
            if (obj == null)
            {
                g.a("OfferUpUtils", new com.offerup.android.i.g((new StringBuilder("Could not find zipcode: ")).append(s).toString()));
                address1 = new Address(Locale.getDefault());
                address1.setPostalCode(s);
            }
        }
        return address1;
_L2:
        obj = null;
        continue; /* Loop/switch isn't completed */
        Throwable throwable;
        throwable;
        g.a("OfferUpUtils", throwable);
        throwable = null;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public static Uri a(String s)
    {
        try
        {
            s = Uri.parse(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            g.a(com/offerup/android/utils/as, s);
            return null;
        }
        return s;
    }

    public static Uri a(String s, String s1)
    {
        try
        {
            s = Uri.parse(s).buildUpon().appendQueryParameter("flavour", "app").appendQueryParameter("token", s1).build();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            g.a(com/offerup/android/utils/as, s);
            return null;
        }
        return s;
    }

    public static Uri a(String s, Map map)
    {
        try
        {
            s = Uri.parse(s).buildUpon();
            if (map.size() > 0)
            {
                java.util.Map.Entry entry;
                for (map = map.entrySet().iterator(); map.hasNext(); s.appendQueryParameter((String)entry.getKey(), (String)entry.getValue()))
                {
                    entry = (java.util.Map.Entry)map.next();
                }

            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            g.a(com/offerup/android/utils/as, s);
            return null;
        }
        s = s.build();
        return s;
    }

    public static void a(Context context)
    {
        ((InputMethodManager)context.getSystemService("input_method")).toggleSoftInput(2, 0);
    }

    public static void a(Context context, View view)
    {
        ((InputMethodManager)context.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void a(EditText edittext)
    {
        edittext.addTextChangedListener(new au(edittext));
    }

    public static void a(EditText edittext, String s)
    {
        edittext.setError(Html.fromHtml(String.format("<font color='red'>%s</font>", new Object[] {
            s
        })));
        edittext.requestFocus();
    }

    public static void a(String s, k k)
    {
        k = n.c(k);
        k.setNeutralButton("OK", new at());
        k.setMessage(s);
        com.offerup.android.utils.n.a(k);
    }

    public static Uri b(String s)
    {
        return b(s, null);
    }

    public static Uri b(String s, String s1)
    {
        try
        {
            s = Uri.parse("https://offerupnow.com/").buildUpon().appendPath(s).appendQueryParameter("flavour", "app").fragment(s1).build();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            g.a(com/offerup/android/utils/as, s);
            return null;
        }
        return s;
    }

    public static String b()
    {
        return j.a().f();
    }

    public static String c(String s)
    {
        if (a == null)
        {
            HashMap hashmap = new HashMap();
            a = hashmap;
            hashmap.put("alabama", "AL");
            a.put("alaska", "AK");
            a.put("alberta", "AB");
            a.put("american samoa", "AS");
            a.put("arizona", "AZ");
            a.put("arkansas", "AR");
            a.put("armed forces (ae)", "AE");
            a.put("armed forces americas", "AA");
            a.put("armed forces pacific", "AP");
            a.put("british columbia", "BC");
            a.put("california", "CA");
            a.put("colorado", "CO");
            a.put("connecticut", "CT");
            a.put("delaware", "DE");
            a.put("district of columbia", "DC");
            a.put("florida", "FL");
            a.put("georgia", "GA");
            a.put("guam", "GU");
            a.put("hawaii", "HI");
            a.put("idaho", "ID");
            a.put("illinois", "IL");
            a.put("indiana", "IN");
            a.put("iowa", "IA");
            a.put("kansas", "KS");
            a.put("kentucky", "KY");
            a.put("louisiana", "LA");
            a.put("maine", "ME");
            a.put("manitoba", "MB");
            a.put("maryland", "MD");
            a.put("massachusetts", "MA");
            a.put("michigan", "MI");
            a.put("minnesota", "MN");
            a.put("mississippi", "MS");
            a.put("missouri", "MO");
            a.put("montana", "MT");
            a.put("nebraska", "NE");
            a.put("nevada", "NV");
            a.put("new brunswick", "NB");
            a.put("new hampshire", "NH");
            a.put("new jersey", "NJ");
            a.put("new mexico", "NM");
            a.put("new york", "NY");
            a.put("newfoundland", "NF");
            a.put("north carolina", "NC");
            a.put("north dakota", "ND");
            a.put("northwest territories", "NT");
            a.put("nova scotia", "NS");
            a.put("nunavut", "NU");
            a.put("ohio", "OH");
            a.put("oklahoma", "OK");
            a.put("ontario", "ON");
            a.put("oregon", "OR");
            a.put("pennsylvania", "PA");
            a.put("prince edward island", "PE");
            a.put("puerto rico", "PR");
            a.put("quebec", "PQ");
            a.put("rhode Island", "RI");
            a.put("saskatchewan", "SK");
            a.put("south carolina", "SC");
            a.put("south dakota", "SD");
            a.put("tennessee", "TN");
            a.put("texas", "TX");
            a.put("utah", "UT");
            a.put("vermont", "VT");
            a.put("virgin islands", "VI");
            a.put("virginia", "VA");
            a.put("washington", "WA");
            a.put("west virginia", "WV");
            a.put("wisconsin", "WI");
            a.put("wyoming", "WY");
            a.put("yukon territory", "YT");
        }
        String s1 = s;
        if (StringUtils.isNotEmpty(s))
        {
            String s2 = s.toLowerCase();
            s1 = s;
            if (a.containsKey(s2))
            {
                s1 = (String)a.get(s2);
            }
        }
        return s1;
    }

    public final void a()
    {
        String s = "Android";
        String s1;
        s1 = c.getResources().getString(0x7f0900c4);
        Object obj = c.getPackageManager().getPackageInfo(c.getPackageName(), 0);
        String s2 = ((PackageInfo) (obj)).versionName;
        obj = (new StringBuilder()).append(((PackageInfo) (obj)).versionCode).toString();
        String s3 = android.os.Build.VERSION.RELEASE;
        String s4 = Build.MODEL;
        String s5 = Build.MANUFACTURER;
        String s6 = Build.ID;
        String s7 = Locale.getDefault().toString();
        s1 = (new StringBuilder()).append(s1).append("/").append(s2).append(" (build: ").append(((String) (obj))).append("; ").append(s5).append(" ").append(s4).append(" ").append(s6).append("; Android ").append(s3).append("; ").append(s7).append(")").toString();
        s = s1;
_L2:
        b.c(s);
        return;
        Exception exception;
        exception;
        g.a("OfferUpUtils", exception);
        if (true) goto _L2; else goto _L1
_L1:
    }
}
