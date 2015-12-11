// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.login;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.facebook.AccessToken;
import com.facebook.FacebookActivity;
import com.facebook.Profile;
import com.facebook.b.u;
import com.facebook.e;
import com.facebook.h;
import com.facebook.k;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.facebook.login:
//            c, a, e, g, 
//            LoginClient, h

public class f
{
    private static final class a
        implements com.facebook.login.h
    {

        private final Activity a;

        public final Activity a()
        {
            return a;
        }

        public final void a(Intent intent, int i)
        {
            a.startActivityForResult(intent, i);
        }

        public a(Activity activity)
        {
            u.a(activity, "activity");
            a = activity;
        }
    }

    private static final class b
    {

        private static volatile com.facebook.login.e a;

        public static com.facebook.login.e a(Context context)
        {
            com/facebook/login/f$b;
            JVM INSTR monitorenter ;
            if (context == null) goto _L2; else goto _L1
_L1:
            if (context != null) goto _L4; else goto _L3
_L3:
            context = null;
_L6:
            com/facebook/login/f$b;
            JVM INSTR monitorexit ;
            return context;
_L2:
            context = k.g();
            continue; /* Loop/switch isn't completed */
_L4:
            if (a == null)
            {
                a = new com.facebook.login.e(context, k.j());
            }
            context = a;
            if (true) goto _L6; else goto _L5
_L5:
            context;
            throw context;
            if (true) goto _L1; else goto _L7
_L7:
        }
    }


    private static final Set c = Collections.unmodifiableSet(new HashSet() {

            
            {
                add("ads_management");
                add("create_event");
                add("rsvp_event");
            }
    });
    private static volatile f d;
    public c a;
    public com.facebook.login.a b;

    f()
    {
        a = c.a;
        b = com.facebook.login.a.c;
        u.b();
    }

    public static f a()
    {
        if (d != null) goto _L2; else goto _L1
_L1:
        com/facebook/login/f;
        JVM INSTR monitorenter ;
        if (d == null)
        {
            d = new f();
        }
        com/facebook/login/f;
        JVM INSTR monitorexit ;
_L2:
        return d;
        Exception exception;
        exception;
        com/facebook/login/f;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static void a(Context context, LoginClient.Result.a a1, Map map, Exception exception, boolean flag, LoginClient.Request request)
    {
        com.facebook.login.e e1 = b.a(context);
        if (e1 == null)
        {
            return;
        }
        if (request == null)
        {
            e1.a("fb_mobile_login_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", "");
            return;
        }
        HashMap hashmap = new HashMap();
        if (flag)
        {
            context = "1";
        } else
        {
            context = "0";
        }
        hashmap.put("try_login_activity", context);
        e1.a(request.e, hashmap, a1, map, exception);
    }

    static boolean a(int i, Intent intent, com.facebook.f f1)
    {
        Object obj6 = null;
        Object obj = LoginClient.Result.a.c;
        boolean flag1 = false;
        boolean flag = false;
        if (intent != null)
        {
            Object obj1 = (LoginClient.Result)intent.getParcelableExtra("com.facebook.LoginFragment:Result");
            Object obj2;
            Map map;
            if (obj1 != null)
            {
                obj2 = ((LoginClient.Result) (obj1)).e;
                Object obj3 = ((LoginClient.Result) (obj1)).a;
                Object obj5;
                if (i == -1)
                {
                    if (((LoginClient.Result) (obj1)).a == LoginClient.Result.a.a)
                    {
                        obj = ((LoginClient.Result) (obj1)).b;
                        intent = null;
                        i = ((flag) ? 1 : 0);
                    } else
                    {
                        intent = new e(((LoginClient.Result) (obj1)).c);
                        obj = null;
                        i = ((flag) ? 1 : 0);
                    }
                } else
                if (i == 0)
                {
                    i = 1;
                    obj = null;
                    intent = null;
                } else
                {
                    obj = null;
                    intent = null;
                    i = ((flag) ? 1 : 0);
                }
                map = ((LoginClient.Result) (obj1)).f;
                obj1 = obj;
                obj = obj2;
                obj2 = intent;
                intent = ((Intent) (obj3));
            } else
            {
                map = null;
                intent = ((Intent) (obj));
                obj1 = null;
                obj2 = null;
                Object obj4 = null;
                obj = map;
                i = ((flag1) ? 1 : 0);
                map = obj4;
            }
            obj3 = obj2;
            obj2 = obj1;
            obj5 = obj;
            obj1 = intent;
            obj = obj2;
            obj2 = obj5;
            intent = ((Intent) (obj3));
        } else
        if (i == 0)
        {
            obj1 = LoginClient.Result.a.b;
            i = 1;
            obj2 = null;
            map = null;
            obj = null;
            intent = null;
        } else
        {
            i = 0;
            obj2 = null;
            obj3 = null;
            map = null;
            intent = null;
            obj1 = obj;
            obj = obj3;
        }
        obj3 = intent;
        if (intent == null)
        {
            obj3 = intent;
            if (obj == null)
            {
                obj3 = intent;
                if (i == 0)
                {
                    obj3 = new h("Unexpected call to LoginManager.onActivityResult");
                }
            }
        }
        a(null, ((LoginClient.Result.a) (obj1)), map, ((Exception) (obj3)), true, ((LoginClient.Request) (obj2)));
        if (obj != null)
        {
            AccessToken.a(((AccessToken) (obj)));
            Profile.b();
        }
        if (f1 != null)
        {
            intent = obj6;
            if (obj != null)
            {
                obj1 = ((LoginClient.Request) (obj2)).b;
                intent = new HashSet(((AccessToken) (obj)).b);
                if (((LoginClient.Request) (obj2)).f)
                {
                    intent.retainAll(((java.util.Collection) (obj1)));
                }
                obj1 = new HashSet(((java.util.Collection) (obj1)));
                ((Set) (obj1)).removeAll(intent);
                intent = new g(((AccessToken) (obj)), intent, ((Set) (obj1)));
            }
            if (i != 0 || intent != null && ((g) (intent)).b.size() == 0)
            {
                f1.a();
            } else
            {
                if (obj3 != null)
                {
                    f1.b();
                    return true;
                }
                if (obj != null)
                {
                    f1.a(intent);
                    return true;
                }
            }
        }
        return true;
    }

    public static boolean a(com.facebook.login.h h1, LoginClient.Request request)
    {
        Intent intent = new Intent();
        intent.setClass(k.g(), com/facebook/FacebookActivity);
        intent.setAction(request.a.toString());
        Bundle bundle = new Bundle();
        bundle.putParcelable("request", request);
        intent.putExtras(bundle);
        boolean flag;
        if (k.g().getPackageManager().resolveActivity(intent, 0) == null)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (!flag)
        {
            return false;
        }
        try
        {
            h1.a(intent, LoginClient.a());
        }
        // Misplaced declaration of an exception variable
        catch (com.facebook.login.h h1)
        {
            return false;
        }
        return true;
    }

    public static boolean a(String s)
    {
        return s != null && (s.startsWith("publish") || s.startsWith("manage") || c.contains(s));
    }

    public static void b()
    {
        AccessToken.a(null);
        Profile.a(null);
    }


    // Unreferenced inner class com/facebook/login/f$1

/* anonymous class */
    public final class _cls1
        implements com.facebook.b.a
    {

        final com.facebook.f a;
        final f b;

        public final boolean a(int i, Intent intent)
        {
            return f.a(i, intent, a);
        }

            public 
            {
                b = f.this;
                a = f2;
                super();
            }
    }


    // Unreferenced inner class com/facebook/login/f$3

/* anonymous class */
    public final class _cls3
        implements com.facebook.b.a
    {

        final f a;

        public final boolean a(int i, Intent intent)
        {
            return f.a(i, intent, null);
        }

            public 
            {
                a = f.this;
                super();
            }
    }

}
