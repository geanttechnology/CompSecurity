// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.login;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.Fragment;
import android.support.v7.jn;
import android.support.v7.kc;
import com.facebook.AccessToken;
import com.facebook.FacebookActivity;
import com.facebook.Profile;
import com.facebook.d;
import com.facebook.e;
import com.facebook.h;
import com.facebook.k;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

// Referenced classes of package com.facebook.login:
//            c, a, d, e, 
//            g, h, LoginClient

public class f
{
    private static class a
        implements com.facebook.login.h
    {

        private final Activity a;

        public Activity a()
        {
            return a;
        }

        public void a(Intent intent, int i)
        {
            a.startActivityForResult(intent, i);
        }

        a(Activity activity)
        {
            kc.a(activity, "activity");
            a = activity;
        }
    }

    private static class b
        implements com.facebook.login.h
    {

        private final Fragment a;

        public Activity a()
        {
            return a.j();
        }

        public void a(Intent intent, int i)
        {
            a.a(intent, i);
        }

        b(Fragment fragment)
        {
            kc.a(fragment, "fragment");
            a = fragment;
        }
    }


    private static final Set a = c();
    private static volatile f b;
    private c c;
    private com.facebook.login.a d;
    private LoginClient.Request e;
    private HashMap f;
    private com.facebook.login.e g;

    f()
    {
        c = c.a;
        d = com.facebook.login.a.c;
        kc.b();
    }

    private Intent a(LoginClient.Request request)
    {
        Intent intent = new Intent();
        intent.setClass(k.f(), com/facebook/FacebookActivity);
        intent.setAction(request.b().toString());
        intent.putExtras(com.facebook.login.d.a(request));
        return intent;
    }

    private com.facebook.login.e a(Context context)
    {
        if (context != null && e != null) goto _L2; else goto _L1
_L1:
        com.facebook.login.e e1 = null;
_L4:
        return e1;
_L2:
        com.facebook.login.e e2;
        e2 = g;
        if (e2 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        e1 = e2;
        if (e2.a().equals(e.d())) goto _L4; else goto _L3
_L3:
        return new com.facebook.login.e(context, e.d());
    }

    public static f a()
    {
        if (b != null) goto _L2; else goto _L1
_L1:
        com/facebook/login/f;
        JVM INSTR monitorenter ;
        if (b == null)
        {
            b = new f();
        }
        com/facebook/login/f;
        JVM INSTR monitorexit ;
_L2:
        return b;
        Exception exception;
        exception;
        com/facebook/login/f;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static g a(LoginClient.Request request, AccessToken accesstoken)
    {
        Set set = request.a();
        HashSet hashset = new HashSet(accesstoken.d());
        if (request.f())
        {
            hashset.retainAll(set);
        }
        request = new HashSet(set);
        request.removeAll(hashset);
        return new g(accesstoken, hashset, request);
    }

    private void a(AccessToken accesstoken, h h1, boolean flag, com.facebook.f f1)
    {
        if (accesstoken != null)
        {
            AccessToken.a(accesstoken);
            Profile.b();
        }
        if (f1 == null) goto _L2; else goto _L1
_L1:
        g g1;
        if (accesstoken != null)
        {
            g1 = a(e, accesstoken);
        } else
        {
            g1 = null;
        }
        if (!flag && (g1 == null || g1.b().size() != 0)) goto _L4; else goto _L3
_L3:
        f1.onCancel();
_L2:
        e = null;
        g = null;
        return;
_L4:
        if (h1 != null)
        {
            f1.onError(h1);
        } else
        if (accesstoken != null)
        {
            f1.onSuccess(g1);
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    private void a(LoginClient.Result.a a1, Map map, Exception exception)
    {
        if (g == null)
        {
            return;
        }
        if (e == null)
        {
            g.b("fb_mobile_login_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.");
            return;
        } else
        {
            g.a(e.e(), f, a1, map, exception);
            return;
        }
    }

    private void a(com.facebook.login.h h1, LoginClient.Request request)
        throws h
    {
        e = request;
        f = new HashMap();
        g = a(((Context) (h1.a())));
        d();
        jn.a(android.support.v7.jn.b.a.a(), new android.support.v7.jn.a() {

            final f a;

            public boolean a(int i, Intent intent)
            {
                return a.a(i, intent);
            }

            
            {
                a = f.this;
                super();
            }
        });
        boolean flag = b(h1, request);
        request = f;
        if (flag)
        {
            h1 = "1";
        } else
        {
            h1 = "0";
        }
        request.put("try_login_activity", h1);
        if (!flag)
        {
            h1 = new h("Log in attempt failed: FacebookActivity could not be started. Please make sure you added FacebookActivity to the AndroidManifest.");
            a(LoginClient.Result.a.c, ((Map) (null)), ((Exception) (h1)));
            e = null;
            throw h1;
        } else
        {
            return;
        }
    }

    private void a(Collection collection)
    {
        if (collection != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s;
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            s = (String)collection.next();
        } while (!a(s));
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        throw new h(String.format("Cannot pass a publish or manage permission (%s) to a request for read authorization", new Object[] {
            s
        }));
    }

    private boolean a(Intent intent)
    {
        return k.f().getPackageManager().resolveActivity(intent, 0) != null;
    }

    static boolean a(String s)
    {
        return s != null && (s.startsWith("publish") || s.startsWith("manage") || a.contains(s));
    }

    private void b(Collection collection)
    {
        if (collection != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        String s;
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            s = (String)collection.next();
        } while (a(s));
        break; /* Loop/switch isn't completed */
        if (true) goto _L1; else goto _L3
_L3:
        throw new h(String.format("Cannot pass a read permission (%s) to a request for publish authorization", new Object[] {
            s
        }));
    }

    private boolean b(com.facebook.login.h h1, LoginClient.Request request)
    {
        request = a(request);
        if (!a(request))
        {
            return false;
        }
        try
        {
            h1.a(request, com.facebook.login.LoginClient.d());
        }
        // Misplaced declaration of an exception variable
        catch (com.facebook.login.h h1)
        {
            return false;
        }
        return true;
    }

    private LoginClient.Request c(Collection collection)
    {
        c c1 = c;
        boolean flag;
        if (collection != null)
        {
            collection = new HashSet(collection);
        } else
        {
            collection = new HashSet();
        }
        collection = new LoginClient.Request(c1, Collections.unmodifiableSet(collection), d, k.i(), UUID.randomUUID().toString());
        if (AccessToken.a() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        collection.a(flag);
        return collection;
    }

    private static Set c()
    {
        return Collections.unmodifiableSet(new HashSet() {

            
            {
                add("ads_management");
                add("create_event");
                add("rsvp_event");
            }
        });
    }

    private void d()
    {
        if (g != null && e != null)
        {
            g.a(e);
        }
    }

    public void a(Activity activity, Collection collection)
    {
        a(collection);
        collection = c(collection);
        a(((com.facebook.login.h) (new a(activity))), ((LoginClient.Request) (collection)));
    }

    public void a(Fragment fragment, Collection collection)
    {
        a(collection);
        collection = c(collection);
        a(((com.facebook.login.h) (new b(fragment))), ((LoginClient.Request) (collection)));
    }

    public void a(d d1, com.facebook.f f1)
    {
        if (!(d1 instanceof jn))
        {
            throw new h("Unexpected CallbackManager, please use the provided Factory.");
        } else
        {
            ((jn)d1).b(android.support.v7.jn.b.a.a(), new android.support.v7.jn.a(f1) {

                final com.facebook.f a;
                final f b;

                public boolean a(int i, Intent intent)
                {
                    return b.a(i, intent, a);
                }

            
            {
                b = f.this;
                a = f2;
                super();
            }
            });
            return;
        }
    }

    boolean a(int i, Intent intent)
    {
        return a(i, intent, ((com.facebook.f) (null)));
    }

    boolean a(int i, Intent intent, com.facebook.f f1)
    {
        boolean flag1 = false;
        boolean flag2 = false;
        boolean flag = false;
        Object obj3 = null;
        Object obj2 = null;
        Object obj1 = null;
        if (e == null)
        {
            return false;
        }
        Object obj = LoginClient.Result.a.c;
        if (intent != null)
        {
            obj2 = (LoginClient.Result)intent.getParcelableExtra("com.facebook.LoginFragment:Result");
            if (obj2 != null)
            {
                obj3 = ((LoginClient.Result) (obj2)).a;
                if (i == -1)
                {
                    if (((LoginClient.Result) (obj2)).a == LoginClient.Result.a.a)
                    {
                        intent = ((LoginClient.Result) (obj2)).b;
                        obj = obj1;
                    } else
                    {
                        obj = new e(((LoginClient.Result) (obj2)).c);
                        intent = null;
                    }
                } else
                if (i == 0)
                {
                    flag = true;
                    intent = null;
                    obj = obj1;
                } else
                {
                    intent = null;
                    obj = obj1;
                }
                obj1 = ((LoginClient.Result) (obj2)).f;
                obj2 = obj;
                obj = obj1;
                obj1 = intent;
                intent = ((Intent) (obj3));
            } else
            {
                intent = ((Intent) (obj));
                obj2 = null;
                obj1 = null;
                flag = flag1;
                obj = obj3;
            }
            obj3 = obj2;
            obj2 = obj;
            obj = intent;
            intent = ((Intent) (obj3));
        } else
        if (i == 0)
        {
            obj = LoginClient.Result.a.b;
            flag = true;
            obj1 = null;
            intent = null;
        } else
        {
            obj1 = null;
            intent = null;
            flag = flag2;
        }
        obj3 = intent;
        if (intent == null)
        {
            obj3 = intent;
            if (obj1 == null)
            {
                obj3 = intent;
                if (!flag)
                {
                    obj3 = new h("Unexpected call to LoginManager.onActivityResult");
                }
            }
        }
        a(((LoginClient.Result.a) (obj)), ((Map) (obj2)), ((Exception) (obj3)));
        a(((AccessToken) (obj1)), ((h) (obj3)), flag, f1);
        return true;
    }

    public void b()
    {
        AccessToken.a(null);
        Profile.a(null);
    }

    public void b(Activity activity, Collection collection)
    {
        b(collection);
        collection = c(collection);
        a(new a(activity), collection);
    }

    public void b(Fragment fragment, Collection collection)
    {
        b(collection);
        collection = c(collection);
        a(new b(fragment), collection);
    }

}
