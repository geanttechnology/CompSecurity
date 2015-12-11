// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.SharedPreferences;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package android.support.v7:
//            apm, aot, alt, amc, 
//            apl, apa, app, ams, 
//            apn, apr, aos, alz, 
//            amq, apq

class apd
    implements apm
{

    private final apq a;
    private final app b;
    private final ams c;
    private final apa d;
    private final apr e;
    private final alz f;
    private final aos g;

    public apd(alz alz1, apq apq, ams ams1, app app1, apa apa1, apr apr1)
    {
        f = alz1;
        a = apq;
        c = ams1;
        b = app1;
        d = apa1;
        e = apr1;
        g = new aot(f);
    }

    private void a(JSONObject jsonobject, String s)
        throws JSONException
    {
        alt.h().a("Fabric", (new StringBuilder()).append(s).append(jsonobject.toString()).toString());
    }

    private apn b(apl apl1)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = null;
        if (apl.b.equals(apl1)) goto _L2; else goto _L1
_L1:
        JSONObject jsonobject = d.a();
        if (jsonobject == null) goto _L4; else goto _L3
_L3:
        obj = b.a(c, jsonobject);
        if (obj == null) goto _L6; else goto _L5
_L5:
        long l;
        a(jsonobject, "Loaded cached settings: ");
        l = c.a();
        if (apl.c.equals(apl1)) goto _L8; else goto _L7
_L7:
        boolean flag = ((apn) (obj)).a(l);
        if (flag) goto _L9; else goto _L8
_L8:
        alt.h().a("Fabric", "Returning cached settings.");
_L2:
        return ((apn) (obj));
_L9:
        alt.h().a("Fabric", "Cached settings have expired.");
        return null;
        obj;
        apl1 = obj1;
_L11:
        alt.h().e("Fabric", "Failed to get cached settings", ((Throwable) (obj)));
        return apl1;
_L6:
        alt.h().e("Fabric", "Failed to transform cached settings data.", null);
        return null;
_L4:
        alt.h().a("Fabric", "No cached settings data found.");
        return null;
        Exception exception;
        exception;
        apl1 = ((apl) (obj));
        obj = exception;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public apn a()
    {
        return a(apl.a);
    }

    public apn a(apl apl1)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = obj1;
        if (alt.i())
        {
            break MISSING_BLOCK_LABEL_25;
        }
        obj = obj1;
        if (!d())
        {
            obj = b(apl1);
        }
        Exception exception;
        apl1 = ((apl) (obj));
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        apl1 = ((apl) (obj));
        JSONObject jsonobject;
        try
        {
            jsonobject = e.a(a);
        }
        // Misplaced declaration of an exception variable
        catch (Exception exception)
        {
            continue; /* Loop/switch isn't completed */
        }
        apl1 = ((apl) (obj));
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        apl1 = ((apl) (obj));
        obj = b.a(c, jsonobject);
        apl1 = ((apl) (obj));
        d.a(((apn) (obj)).g, jsonobject);
        apl1 = ((apl) (obj));
        a(jsonobject, "Loaded settings: ");
        apl1 = ((apl) (obj));
        a(b());
        apl1 = ((apl) (obj));
        obj = apl1;
        if (apl1 != null)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        obj = b(apl.c);
        return ((apn) (obj));
        exception;
        apl1 = null;
_L2:
        alt.h().e("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", exception);
        return apl1;
        exception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    boolean a(String s)
    {
        android.content.SharedPreferences.Editor editor = g.b();
        editor.putString("existing_instance_identifier", s);
        return g.a(editor);
    }

    String b()
    {
        return amq.a(new String[] {
            amq.m(f.getContext())
        });
    }

    String c()
    {
        return g.a().getString("existing_instance_identifier", "");
    }

    boolean d()
    {
        return !c().equals(b());
    }
}
