// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import com.crashlytics.android.Crashlytics;
import com.wantu.weibo.other.facebook.DialogError;
import com.wantu.weibo.other.facebook.FacebookError;
import com.wantu.weibo.other.facebook.FbDialog;
import org.json.JSONException;
import org.json.JSONObject;

public class zb
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
    private Activity j;
    private String k[];
    private int l;
    private zd m;
    private final long n = 0x5265c00L;
    private boolean o;
    private zc p;

    public zb(String s)
    {
        f = null;
        g = 0L;
        h = 0L;
        o = true;
        p = null;
        if (s == null)
        {
            throw new IllegalArgumentException("You must specify your application ID when instantiating a Facebook object. See README for details.");
        } else
        {
            i = s;
            return;
        }
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

    static zc a(zb zb1, zc zc1)
    {
        zb1.p = zc1;
        return zc1;
    }

    static zd a(zb zb1)
    {
        return zb1.m;
    }

    private void a(Activity activity, String as[])
    {
        Bundle bundle = new Bundle();
        if (as.length > 0)
        {
            bundle.putString("scope", TextUtils.join(",", as));
        }
        CookieSyncManager.createInstance(activity);
        a(((Context) (activity)), "oauth", bundle, new zd() {

            final zb a;

            public void a()
            {
                ze.a("Facebook-authorize", "Login canceled");
                zb.a(a).a();
            }

            public void a(Bundle bundle1)
            {
                CookieSyncManager.getInstance().sync();
                a.a(bundle1.getString("access_token"));
                a.b(bundle1.getString("expires_in"));
                if (a.a())
                {
                    ze.a("Facebook-authorize", (new StringBuilder()).append("Login Success! access_token=").append(a.b()).append(" expires=").append(a.c()).toString());
                    zb.a(a).a(bundle1);
                    return;
                } else
                {
                    zb.a(a).a(new FacebookError("Failed to receive access token."));
                    return;
                }
            }

            public void a(DialogError dialogerror)
            {
                ze.a("Facebook-authorize", (new StringBuilder()).append("Login failed: ").append(dialogerror).toString());
                zb.a(a).a(dialogerror);
            }

            public void a(FacebookError facebookerror)
            {
                ze.a("Facebook-authorize", (new StringBuilder()).append("Login failed: ").append(facebookerror).toString());
                zb.a(a).a(facebookerror);
            }

            
            {
                a = zb.this;
                super();
            }
        });
    }

    static void a(zb zb1, String s, Context context)
    {
        b(zb1, s, context);
    }

    private boolean a(Activity activity, String s, String as[], int i1)
    {
        boolean flag = true;
        Intent intent = new Intent();
        intent.setClassName("com.facebook.katana", "com.facebook.katana.ProxyAuth");
        intent.putExtra("client_id", s);
        if (as.length > 0)
        {
            intent.putExtra("scope", TextUtils.join(",", as));
        }
        if (!a(((Context) (activity)), intent))
        {
            return false;
        }
        j = activity;
        k = as;
        l = i1;
        try
        {
            activity.startActivityForResult(intent, i1);
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            Crashlytics.logException(activity);
            flag = false;
        }
        return flag;
    }

    private boolean a(Context context, Intent intent)
    {
        intent = context.getPackageManager().resolveActivity(intent, 0);
        if (intent == null)
        {
            return false;
        } else
        {
            return a(context, ((ResolveInfo) (intent)).activityInfo.packageName);
        }
    }

    private boolean a(Context context, String s)
    {
        boolean flag1 = false;
        int i1;
        int j1;
        try
        {
            context = context.getPackageManager().getPackageInfo(s, 64);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Crashlytics.logException(context);
            return false;
        }
        context = ((PackageInfo) (context)).signatures;
        j1 = context.length;
        i1 = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i1 < j1)
                {
                    if (!context[i1].toCharsString().equals("30820268308201d102044a9c4610300d06092a864886f70d0101040500307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e3020170d3039303833313231353231365a180f32303530303932353231353231365a307a310b3009060355040613025553310b3009060355040813024341311230100603550407130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c653111300f060355040b130846616365626f6f6b311d301b0603550403131446616365626f6f6b20436f72706f726174696f6e30819f300d06092a864886f70d010101050003818d0030818902818100c207d51df8eb8c97d93ba0c8c1002c928fab00dc1b42fca5e66e99cc3023ed2d214d822bc59e8e35ddcf5f44c7ae8ade50d7e0c434f500e6c131f4a2834f987fc46406115de2018ebbb0d5a3c261bd97581ccfef76afc7135a6d59e8855ecd7eacc8f8737e794c60a761c536b72b11fac8e603f5da1a2d54aa103b8a13c0dbc10203010001300d06092a864886f70d0101040500038181005ee9be8bcbb250648d3b741290a82a1c9dc2e76a0af2f2228f1d9f9c4007529c446a70175c5a900d5141812866db46be6559e2141616483998211f4a673149fb2232a10d247663b26a9031e15f84bc1c74d141ff98a02d76f85b2c8ab2571b6469b232d8e768a7f7ca04f7abe4a775615916c07940656b58717457b42bd928a2"))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i1++;
        } while (true);
    }

    private static void b(zb zb1, String s, Context context)
    {
        String s1 = a(context.getContentResolver());
        SharedPreferences sharedpreferences = context.getSharedPreferences("com.facebook.sdk.attributionTracking", 0);
        context = (new StringBuilder()).append(s).append("ping").toString();
        if (sharedpreferences.getLong(context, 0L) == 0L && s1 != null)
        {
            Object obj = new Bundle();
            ((Bundle) (obj)).putString("fields", "supports_attribution");
            obj = (Boolean)ze.c(zb1.a(s, ((Bundle) (obj)))).get("supports_attribution");
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
                zb1.a(String.format("%s/activities", new Object[] {
                    s
                }), bundle, "POST");
                zb1 = sharedpreferences.edit();
                zb1.putLong(context, System.currentTimeMillis());
                zb1.commit();
            }
        }
    }

    public String a(Context context)
    {
        ze.a(context);
        (new Bundle()).putString("method", "auth.expireSession");
        a(((String) (null)));
        a(0L);
        return "";
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
        return ze.a(s, s1, bundle);
    }

    public void a(long l1)
    {
        h = l1;
    }

    public void a(Activity activity, String as[], int i1, zd zd)
    {
        boolean flag = false;
        m = zd;
        b(activity.getApplicationContext());
        if (i1 >= 0)
        {
            flag = a(activity, i, as, i1);
        }
        if (!flag)
        {
            a(activity, as);
        }
    }

    public void a(Activity activity, String as[], zd zd)
    {
        a(activity, as, 32665, zd);
    }

    public void a(Context context, String s, Bundle bundle, zd zd)
    {
        String s1 = (new StringBuilder()).append(b).append(s).toString();
        bundle.putString("display", "touch");
        bundle.putString("redirect_uri", "fbconnect://success");
        if (s.equals("oauth"))
        {
            bundle.putString("type", "user_agent");
            bundle.putString("client_id", i);
        } else
        {
            bundle.putString("app_id", i);
        }
        if (a())
        {
            bundle.putString("access_token", b());
        }
        s = (new StringBuilder()).append(s1).append("?").append(ze.a(bundle)).toString();
        if (context.checkCallingOrSelfPermission("android.permission.INTERNET") != 0)
        {
            ze.a(context, "Error", "Application requires permission to access the Internet");
            return;
        } else
        {
            (new FbDialog(context, s, zd)).show();
            return;
        }
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

    void b(Context context)
    {
        Object obj = null;
        this;
        JVM INSTR monitorenter ;
        zc zc1 = obj;
        if (p != null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        zc1 = obj;
        String s;
        if (!d())
        {
            break MISSING_BLOCK_LABEL_52;
        }
        s = i;
        zc1 = obj;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_52;
        }
        zc1 = new zc(this, s, context);
        p = zc1;
        this;
        JVM INSTR monitorexit ;
        if (zc1 != null)
        {
            zc1.execute(new Void[0]);
        }
        return;
        context;
        this;
        JVM INSTR monitorexit ;
        throw context;
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

    public boolean d()
    {
        return o;
    }

}
