// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package a.a:
//            du, eo, en, fc, 
//            v, ej, ee, dm, 
//            dx, dw, fb, aa, 
//            ak, ay

public final class dk extends du
{

    private v a;
    private Context b;
    private String c;
    private JSONObject d;
    private JSONObject e;
    private boolean f;

    public dk(ay ay, ay ay1, String s, Context context, v v1)
    {
        super(ay, ay1);
        c = s;
        b = context;
        a = v1;
    }

    public final void a(boolean flag, int i, JSONObject jsonobject)
    {
        super.a(flag, i, jsonobject);
        if (jsonobject == null) goto _L2; else goto _L1
_L1:
        Object obj;
        Object obj1;
        if (jsonobject.optBoolean("internalExceptionReporting", false))
        {
            en.a = eo.b;
            fc.d();
        } else
        {
            en.a = eo.c;
        }
        obj = a.m();
        if (obj == null) goto _L4; else goto _L3
_L3:
        obj1 = jsonobject.optJSONObject("rateMyApp");
        if (obj1 != null) goto _L6; else goto _L5
_L5:
        ((ej) (obj)).a(false);
_L4:
        if (jsonobject.optInt("needPkg", 0) == 1)
        {
            String s;
            int j;
            try
            {
                (new ee((new dm(a)).a("device_name", a.i()).a("pkg", b.getPackageName()), new dx((new dw(c, "/android_v2/update_package_name")).a()), null)).run();
            }
            catch (IOException ioexception)
            {
                (new StringBuilder("IOException in handleResponse(): ")).append(ioexception.getMessage());
                en.b();
                en.c();
            }
            f = true;
        }
        d = jsonobject.optJSONObject("apm");
        if (d != null)
        {
            obj = new fb(d);
            obj1 = b;
            if (((fb) (obj)).c)
            {
                fb.b(((Context) (obj1)));
            } else
            {
                File file = fb.a(((Context) (obj1)));
                if (!file.delete() && file.exists())
                {
                    en.b("Unable to reenable OPTMZ instrumentation");
                }
            }
            obj1 = ((Context) (obj1)).getSharedPreferences("com.crittercism.optmz.config", 0).edit();
            if (((fb) (obj)).b)
            {
                ((android.content.SharedPreferences.Editor) (obj1)).putBoolean("enabled", ((fb) (obj)).a);
                ((android.content.SharedPreferences.Editor) (obj1)).putBoolean("kill", ((fb) (obj)).c);
                ((android.content.SharedPreferences.Editor) (obj1)).putBoolean("persist", ((fb) (obj)).b);
                ((android.content.SharedPreferences.Editor) (obj1)).putInt("interval", ((fb) (obj)).d);
            } else
            {
                ((android.content.SharedPreferences.Editor) (obj1)).clear();
            }
            ((android.content.SharedPreferences.Editor) (obj1)).commit();
            aa.A().a(((fb) (obj)));
        }
        e = jsonobject.optJSONObject("txnConfig");
        if (e != null)
        {
            jsonobject = new ak(e);
            obj = b.getSharedPreferences("com.crittercism.txn.config", 0).edit();
            ((android.content.SharedPreferences.Editor) (obj)).putBoolean("enabled", ((ak) (jsonobject)).a);
            ((android.content.SharedPreferences.Editor) (obj)).putInt("interval", ((ak) (jsonobject)).b);
            ((android.content.SharedPreferences.Editor) (obj)).putInt("defaultTimeout", ((ak) (jsonobject)).c);
            ((android.content.SharedPreferences.Editor) (obj)).putString("transactions", ((ak) (jsonobject)).d.toString());
            ((android.content.SharedPreferences.Editor) (obj)).commit();
            aa.A().a(jsonobject);
        }
_L2:
        return;
_L6:
        j = ((JSONObject) (obj1)).getInt("rateAfterLoadNum");
        i = j;
        if (j < 0)
        {
            i = 0;
        }
        ((ej) (obj)).a.edit().putInt("rateAfterNumLoads", i).commit();
        j = ((JSONObject) (obj1)).getInt("remindAfterLoadNum");
        i = j;
        if (j <= 0)
        {
            i = 1;
        }
        try
        {
            ((ej) (obj)).a.edit().putInt("remindAfterNumLoads", i).commit();
            s = ((JSONObject) (obj1)).getString("message");
            ((ej) (obj)).a.edit().putString("rateAppMessage", s).commit();
            obj1 = ((JSONObject) (obj1)).getString("title");
            ((ej) (obj)).a.edit().putString("rateAppTitle", ((String) (obj1))).commit();
            ((ej) (obj)).a(true);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            ((ej) (obj)).a(false);
        }
          goto _L4
    }
}
