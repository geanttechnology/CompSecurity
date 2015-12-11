// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;
import java.io.IOException;
import org.json.JSONObject;

// Referenced classes of package crittercism.android:
//            ci, dg, i, df, 
//            dc, cs, ce, au, 
//            ck, cj, h, ay, 
//            bj, ch, cg

public final class cd extends ci
{
    public static final class a
        implements ch
    {

        public final cg a(bj bj, bj bj1, String s, Context context, au au1, df df1)
        {
            return new cd(bj, bj1, s, context, au1, df1);
        }

        public a()
        {
        }
    }


    private String a;
    private Context b;
    private au c;
    private df d;
    private JSONObject e;
    private JSONObject f;
    private JSONObject g;
    private boolean h;

    public cd(bj bj, bj bj1, String s, Context context, au au1, df df1)
    {
        super(bj, bj1);
        a = s;
        b = context;
        c = au1;
        d = df1;
        h = false;
    }

    public final void a(boolean flag, int j, JSONObject jsonobject)
    {
        super.a(flag, j, jsonobject);
        if (jsonobject != null)
        {
            Object obj;
            if (jsonobject.optBoolean("report_internal_exceptions", false))
            {
                dg.a = dg.a.b;
                i.d();
            } else
            {
                dg.a = dg.a.c;
            }
            obj = jsonobject.optJSONObject("me");
            if (obj != null)
            {
                e = ((JSONObject) (obj)).optJSONObject("notify");
                obj = d.a();
                if (e == null)
                {
                    ((dc) (obj)).c();
                } else
                if (e.optString("type") != null && e.optString("type").equals("rate_my_app"))
                {
                    obj = new dc(((dc) (obj)));
                    JSONObject jsonobject1 = e;
                    obj.d = jsonobject1.optInt("rate_after_load_num", 5);
                    obj.e = jsonobject1.optInt("remind_after_load_num", 5);
                    obj.f = jsonobject1.optString("message", "Would you mind taking a second to rate my app?  I would really appreciate it!");
                    obj.g = jsonobject1.optString("title", "Rate My App");
                    ((dc) (obj)).a();
                    d.a(((dc) (obj)));
                }
            }
            obj = jsonobject.optJSONObject("app_settings");
            if (obj != null)
            {
                g = ((JSONObject) (obj)).optJSONObject("settings");
            }
            if (g != null && g.optInt("need_pkg", 0) == 1)
            {
                try
                {
                    (new cs((new ce(c)).a("device_name", c.f()).a("pkg", b.getPackageName()), new ck((new cj(a, "/android_v2/update_package_name")).a()), null)).run();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    (new StringBuilder("IOException in handleResponse(): ")).append(((IOException) (obj)).getMessage());
                    dg.b();
                    dg.c();
                }
                h = true;
            }
            f = jsonobject.optJSONObject("apm");
            if (f != null)
            {
                jsonobject = new h(f);
                obj = b;
                if (((h) (jsonobject)).c)
                {
                    crittercism.android.h.b(((Context) (obj)));
                } else
                {
                    File file = crittercism.android.h.a(((Context) (obj)));
                    if (!file.delete() && file.exists())
                    {
                        dg.b("Crittercism", "Unable to reenable OPTMZ instrumentation");
                    }
                }
                obj = ((Context) (obj)).getSharedPreferences("com.crittercism.optmz.config", 0).edit();
                if (((h) (jsonobject)).b)
                {
                    ((android.content.SharedPreferences.Editor) (obj)).putBoolean("enabled", ((h) (jsonobject)).a);
                    ((android.content.SharedPreferences.Editor) (obj)).putBoolean("kill", ((h) (jsonobject)).c);
                    ((android.content.SharedPreferences.Editor) (obj)).putBoolean("persist", ((h) (jsonobject)).b);
                    ((android.content.SharedPreferences.Editor) (obj)).putInt("interval", ((h) (jsonobject)).d);
                } else
                {
                    ((android.content.SharedPreferences.Editor) (obj)).clear();
                }
                ((android.content.SharedPreferences.Editor) (obj)).commit();
                ay.t().a(jsonobject);
            }
        }
    }
}
