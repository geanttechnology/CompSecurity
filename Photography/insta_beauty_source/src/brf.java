// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

public class brf
{

    public static final Uri a = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");
    protected static String b = "https://m.facebook.com/dialog/";
    protected static String c = "https://graph.facebook.com/";
    protected static String d = "https://api.facebook.com/restserver.php";
    private static int e = 720;
    private String f;
    private long g;
    private long h;
    private String i;
    private final long j = 0x5265c00L;
    private boolean k;
    private brg l;

    public brf(String s)
    {
        f = null;
        g = 0L;
        h = 0L;
        k = true;
        l = null;
        if (s == null)
        {
            throw new IllegalArgumentException("You must specify your application ID when instantiating a Facebook object. See README for details.");
        } else
        {
            i = s;
            return;
        }
    }

    static brg a(brf brf1, brg brg)
    {
        brf1.l = brg;
        return brg;
    }

    public static String a(ContentResolver contentresolver)
    {
        contentresolver = contentresolver.query(a, new String[] {
            "aid"
        }, null, null, null);
        if (contentresolver == null || !contentresolver.moveToFirst())
        {
            return null;
        } else
        {
            return contentresolver.getString(contentresolver.getColumnIndex("aid"));
        }
    }

    static void a(brf brf1, String s, Context context)
    {
        b(brf1, s, context);
    }

    private static void b(brf brf1, String s, Context context)
    {
        String s1 = a(context.getContentResolver());
        SharedPreferences sharedpreferences = context.getSharedPreferences("com.facebook.sdk.attributionTracking", 0);
        context = (new StringBuilder()).append(s).append("ping").toString();
        if (sharedpreferences.getLong(context, 0L) == 0L && s1 != null)
        {
            Object obj = new Bundle();
            ((Bundle) (obj)).putString("fields", "supports_attribution");
            obj = (Boolean)brh.a(brf1.a(s, ((Bundle) (obj)))).get("supports_attribution");
            if (!(obj instanceof Boolean))
            {
                throw new JSONException(String.format("%s contains %s instead of a Boolean", new Object[] {
                    "supports_attribution", obj
                }));
            }
            if (((Boolean)obj).booleanValue())
            {
                Bundle bundle = new Bundle();
                bundle.putString("event", "MOBILE_APP_INSTALL");
                bundle.putString("attribution", s1);
                brf1.a(String.format("%s/activities", new Object[] {
                    s
                }), bundle, "POST");
                brf1 = sharedpreferences.edit();
                brf1.putLong(context, System.currentTimeMillis());
                brf1.commit();
            }
        }
    }

    public String a(String s, Bundle bundle)
    {
        return a(s, bundle, "GET");
    }

    public String a(String s, Bundle bundle, String s1)
    {
        bundle.putString("format", "json");
        if (a())
        {
            bundle.putString("access_token", b());
        }
        if (s != null)
        {
            s = (new StringBuilder()).append(c).append(s).toString();
        } else
        {
            s = d;
        }
        return brh.a(s, s1, bundle);
    }

    public void a(long l1)
    {
        h = l1;
    }

    public void a(String s)
    {
        f = s;
        g = System.currentTimeMillis();
    }

    public boolean a()
    {
        return b() != null && (c() == 0L || System.currentTimeMillis() < c());
    }

    public String b()
    {
        return f;
    }

    public void b(String s)
    {
        if (s != null)
        {
            long l1;
            if (s.equals("0"))
            {
                l1 = 0L;
            } else
            {
                l1 = System.currentTimeMillis() + Long.parseLong(s) * 1000L;
            }
            a(l1);
        }
    }

    public long c()
    {
        return h;
    }

}
