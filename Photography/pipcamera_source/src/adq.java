// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.SharedPreferences;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.settings.SettingsCacheBehavior;
import org.json.JSONObject;

class adq
    implements aea
{

    private final aee a;
    private final aed b;
    private final aaz c;
    private final adn d;
    private final aef e;
    private final aad f;
    private final adf g;

    public adq(aad aad1, aee aee, aaz aaz1, aed aed1, adn adn1, aef aef1)
    {
        f = aad1;
        a = aee;
        c = aaz1;
        b = aed1;
        d = adn1;
        e = aef1;
        g = new adg(f);
    }

    private void a(JSONObject jsonobject, String s)
    {
        zw.h().a("Fabric", (new StringBuilder()).append(s).append(jsonobject.toString()).toString());
    }

    private aeb b(SettingsCacheBehavior settingscachebehavior)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = null;
        if (SettingsCacheBehavior.SKIP_CACHE_LOOKUP.equals(settingscachebehavior)) goto _L2; else goto _L1
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
        if (SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION.equals(settingscachebehavior)) goto _L8; else goto _L7
_L7:
        boolean flag = ((aeb) (obj)).a(l);
        if (flag) goto _L9; else goto _L8
_L8:
        zw.h().a("Fabric", "Returning cached settings.");
_L2:
        return ((aeb) (obj));
_L9:
        zw.h().a("Fabric", "Cached settings have expired.");
        return null;
        obj;
        settingscachebehavior = obj1;
_L11:
        zw.h().e("Fabric", "Failed to get cached settings", ((Throwable) (obj)));
        return settingscachebehavior;
_L6:
        zw.h().e("Fabric", "Failed to transform cached settings data.", null);
        return null;
_L4:
        zw.h().a("Fabric", "No cached settings data found.");
        return null;
        Exception exception;
        exception;
        settingscachebehavior = ((SettingsCacheBehavior) (obj));
        obj = exception;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public aeb a()
    {
        return a(SettingsCacheBehavior.USE_CACHE);
    }

    public aeb a(SettingsCacheBehavior settingscachebehavior)
    {
        Object obj;
        Object obj1;
        obj1 = null;
        obj = obj1;
        if (zw.i())
        {
            break MISSING_BLOCK_LABEL_25;
        }
        obj = obj1;
        if (!d())
        {
            obj = b(settingscachebehavior);
        }
        Exception exception;
        settingscachebehavior = ((SettingsCacheBehavior) (obj));
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        settingscachebehavior = ((SettingsCacheBehavior) (obj));
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
        settingscachebehavior = ((SettingsCacheBehavior) (obj));
        if (jsonobject == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        settingscachebehavior = ((SettingsCacheBehavior) (obj));
        obj = b.a(c, jsonobject);
        settingscachebehavior = ((SettingsCacheBehavior) (obj));
        d.a(((aeb) (obj)).g, jsonobject);
        settingscachebehavior = ((SettingsCacheBehavior) (obj));
        a(jsonobject, "Loaded settings: ");
        settingscachebehavior = ((SettingsCacheBehavior) (obj));
        a(b());
        settingscachebehavior = ((SettingsCacheBehavior) (obj));
        obj = settingscachebehavior;
        if (settingscachebehavior != null)
        {
            break MISSING_BLOCK_LABEL_122;
        }
        obj = b(SettingsCacheBehavior.IGNORE_CACHE_EXPIRATION);
        return ((aeb) (obj));
        exception;
        settingscachebehavior = null;
_L2:
        zw.h().e("Fabric", "Unknown error while loading Crashlytics settings. Crashes will be cached until settings can be retrieved.", exception);
        return settingscachebehavior;
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
        return CommonUtils.a(new String[] {
            CommonUtils.m(f.getContext())
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
