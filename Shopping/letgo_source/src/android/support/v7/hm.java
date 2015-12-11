// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.kahuna.sdk.b;
import com.kahuna.sdk.i;
import com.kahuna.sdk.j;
import com.kahuna.sdk.k;
import com.parse.ParseGeoPoint;
import com.parse.ParseUser;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            gi, at, aqo

public class hm
    implements gi
{

    public hm()
    {
    }

    private void a(Map map)
    {
        at at1 = new at(2);
        if (map.containsKey("product-id"))
        {
            at1.put("sell_complete_product_id", String.valueOf(map.get("product-id")));
        }
        if (map.containsKey("category-id"))
        {
            at1.put("sell_complete_category_id", String.valueOf(map.get("category-id")));
        }
        k.i().a(at1);
        k.i().a("product_sell_complete");
    }

    private void b(ParseUser parseuser)
    {
        at at1 = new at(1);
        at1.put("last_login_type", "login_fb");
        k.i().a(at1);
        k.i().a("login_fb");
        e(parseuser);
    }

    private void c()
    {
        k.i().a("product_sell_start");
    }

    private void c(ParseUser parseuser)
    {
        at at1 = new at(1);
        at1.put("last_login_type", "login_email");
        k.i().a(at1);
        k.i().a("login_email");
        e(parseuser);
    }

    private void d(ParseUser parseuser)
    {
        at at1 = new at(1);
        at1.put("last_login_type", "signup_email");
        k.i().a(at1);
        k.i().a("signup_email");
        e(parseuser);
    }

    private void e(ParseUser parseuser)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("public_username", parseuser.getString("username_public"));
        hashmap.put("city", parseuser.getString("city"));
        hashmap.put("country_code", parseuser.getString("country_code"));
        ParseGeoPoint parsegeopoint = parseuser.getParseGeoPoint("gpscoords");
        if (parsegeopoint != null)
        {
            hashmap.put("latitude", (new StringBuilder()).append("").append(parsegeopoint.getLatitude()).toString());
            hashmap.put("longitude", (new StringBuilder()).append("").append(parsegeopoint.getLongitude()).toString());
        }
        hashmap.put("language", Locale.getDefault().toString());
        hashmap.put("app_version", "1.3.2");
        hashmap.put("zipcode", parseuser.getString("zipcode"));
        hashmap.put("last_sign_in_date", (new SimpleDateFormat("yyyy-MM-dd", Locale.US)).format(new Date()));
        k.i().a(hashmap);
        k.i().a("sign_in");
    }

    public void a()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("last_session_end_date", (new SimpleDateFormat("yyyy-MM-dd", Locale.US)).format(new Date()));
        k.i().a(hashmap);
        k.i().a("session_end");
    }

    public void a(Activity activity)
    {
    }

    public void a(Application application)
    {
    }

    public void a(Context context, String s, Map map, ParseUser parseuser)
    {
        byte byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 4: default 48
    //                   212950072: 111
    //                   486764790: 81
    //                   1992203943: 126
    //                   2022711712: 96;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L4:
        break MISSING_BLOCK_LABEL_126;
_L6:
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
            a(map);
            return;

        case 1: // '\001'
            b(parseuser);
            return;

        case 2: // '\002'
            c(parseuser);
            return;

        case 3: // '\003'
            d(parseuser);
            break;
        }
        break MISSING_BLOCK_LABEL_167;
_L3:
        if (s.equals("product-sell-complete"))
        {
            byte0 = 0;
        }
          goto _L6
_L5:
        if (s.equals("login-fb"))
        {
            byte0 = 1;
        }
          goto _L6
_L2:
        if (s.equals("login-email"))
        {
            byte0 = 2;
        }
          goto _L6
        if (s.equals("signup-email"))
        {
            byte0 = 3;
        }
          goto _L6
    }

    public void a(ParseUser parseuser)
    {
        j j1 = k.i().c();
        j1.a("user_id", parseuser.getObjectId());
        j1.a("email", parseuser.getEmail());
        try
        {
            k.i().a(j1);
        }
        catch (b b1)
        {
            android.support.v7.aqo.b(b1, "Kahuna: Error invalid credentials identifying user", new Object[0]);
        }
        e(parseuser);
    }

    public void b()
    {
        k.i().a("logout");
        k.i().e();
    }

    public void b(Activity activity)
    {
        activity = new HashMap();
        activity.put("last_session_start_date", (new SimpleDateFormat("yyyy-MM-dd", Locale.US)).format(new Date()));
        k.i().a(activity);
        k.i().a("session_start");
    }

    public void b(Context context, String s, Map map, ParseUser parseuser)
    {
        byte byte0 = -1;
        s.hashCode();
        JVM INSTR tableswitch -1499863611 -1499863611: default 24
    //                   -1499863611 45;
           goto _L1 _L2
_L2:
        if (s.equals("product-sell-start"))
        {
            byte0 = 0;
        }
_L1:
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
            c();
            break;
        }
        return;
    }

    public void c(Activity activity)
    {
        k.i().a();
    }

    public void d(Activity activity)
    {
    }

    public void e(Activity activity)
    {
    }

    public void f(Activity activity)
    {
        k.i().b();
    }
}
