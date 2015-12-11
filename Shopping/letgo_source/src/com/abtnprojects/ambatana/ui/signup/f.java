// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.signup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.ajx;
import android.support.v7.aqo;
import android.support.v7.du;
import android.support.v7.dz;
import android.support.v7.eb;
import android.support.v7.ec;
import android.support.v7.et;
import android.support.v7.fm;
import android.support.v7.gs;
import android.support.v7.id;
import android.support.v7.iv;
import android.text.TextUtils;
import com.abtnprojects.ambatana.models.LetgoAddress;
import com.abtnprojects.ambatana.models.SignUpUserInfoBitmap;
import com.facebook.AccessToken;
import com.facebook.d;
import com.facebook.h;
import com.facebook.login.g;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.parse.LogInCallback;
import com.parse.ParseAnonymousUtils;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;
import java.lang.ref.WeakReference;

// Referenced classes of package com.abtnprojects.ambatana.ui.signup:
//            m, g, i, h

public class f extends m
{

    private final d d;
    private final com.abtnprojects.ambatana.ui.signup.h e;
    private final id f;
    private final du g;
    private final com.abtnprojects.ambatana.ui.signup.g h;
    private final WeakReference i;

    public f(com.abtnprojects.ambatana.ui.signup.g g1, i j, d d1, com.abtnprojects.ambatana.ui.signup.h h1, id id1, du du1, gs gs1, 
            Activity activity)
    {
        super(gs1, j);
        d = d1;
        e = h1;
        f = id1;
        g = du1;
        h = g1;
        i = new WeakReference(activity.getApplicationContext());
    }

    static com.abtnprojects.ambatana.ui.signup.g a(f f1)
    {
        return f1.h;
    }

    private void a(Context context, ParseException parseexception)
    {
        if (parseexception != null)
        {
            h.a(parseexception);
            aqo.b(parseexception, "onFacebookParseRegistrationEnded : error code : %d", new Object[] {
                Integer.valueOf(parseexception.getCode())
            });
            context = new fm(context.getApplicationContext());
            parseexception = new Void[0];
            if (!(context instanceof AsyncTask))
            {
                context.execute(parseexception);
                return;
            } else
            {
                AsyncTaskInstrumentation.execute((AsyncTask)context, parseexception);
                return;
            }
        }
        parseexception = g.a();
        ParseUser parseuser = ParseUser.getCurrentUser();
        boolean flag;
        if (parseuser.isNew() || TextUtils.isEmpty(parseuser.getEmail()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            context = new et(parseuser, context, parseexception, AccessToken.a());
            parseexception = new Void[0];
            if (!(context instanceof AsyncTask))
            {
                context.execute(parseexception);
                return;
            } else
            {
                AsyncTaskInstrumentation.execute((AsyncTask)context, parseexception);
                return;
            }
        } else
        {
            a(context, Boolean.valueOf(true));
            return;
        }
    }

    private void a(Context context, ParseUser parseuser)
    {
        if (parseuser != null)
        {
            a.a(parseuser);
            a.d(context, parseuser);
        }
    }

    private void a(Context context, ParseUser parseuser, String s, String s1)
    {
        if (a(parseuser))
        {
            a(context, parseuser);
            dz.a().a(new eb());
            aqo.a("Facebook result ok, notifying %s", new Object[] {
                s
            });
            b.a(f.a(s, s1));
            return;
        } else
        {
            aqo.c("Banned user detected", new Object[0]);
            a(context);
            return;
        }
    }

    static void a(f f1, Context context, ParseException parseexception)
    {
        f1.a(context, parseexception);
    }

    static WeakReference b(f f1)
    {
        return f1.i;
    }

    private void b(Context context, ParseUser parseuser)
    {
        a.a(context, parseuser);
    }

    private void d()
    {
        com.facebook.login.f.a().a(d, new com.facebook.f() {

            final f a;

            public void a(g g1)
            {
                aqo.a("Facebook login success", new Object[0]);
                f.a(a).a(0);
                a.b();
            }

            public void onCancel()
            {
                aqo.a("Facebook login cancelled", new Object[0]);
            }

            public void onError(h h1)
            {
                aqo.a("Facebook login error", new Object[0]);
                f.a(a).m();
            }

            public void onSuccess(Object obj)
            {
                a((g)obj);
            }

            
            {
                a = f.this;
                super();
            }
        });
    }

    void a()
    {
        super.a();
        iv.a(this);
    }

    void a(int j, int k, Intent intent)
    {
        super.a(j, k, intent);
        d.a(j, k, intent);
    }

    public void a(Activity activity)
    {
        a.a(activity);
    }

    protected void a(Context context)
    {
        context = new fm(context.getApplicationContext());
        Void avoid[] = new Void[0];
        if (!(context instanceof AsyncTask))
        {
            context.execute(avoid);
            return;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)context, avoid);
            return;
        }
    }

    void a(Context context, Boolean boolean1)
    {
        if (boolean1 != null && boolean1.booleanValue())
        {
            a(context, ParseUser.getCurrentUser(), e.a, e.b);
            return;
        } else
        {
            a(context);
            return;
        }
    }

    public void a(SignUpUserInfoBitmap signupuserinfobitmap, LetgoAddress letgoaddress, Context context)
    {
    }

    public void a(Class class1, com.abtnprojects.ambatana.ui.signup.h h1)
    {
        b.a(class1, h1.a, h1.b);
    }

    public void a(String s, Context context)
    {
    }

    public void a(String s, String s1, com.abtnprojects.ambatana.ui.signup.h h1, Context context)
    {
    }

    void b()
    {
        h.a(1);
        ParseFacebookUtils.logInInBackground(AccessToken.a(), new LogInCallback() {

            final f a;

            public void done(ParseUser parseuser, ParseException parseexception)
            {
                parseuser = (Context)f.b(a).get();
                if (parseuser != null)
                {
                    f.a(a, parseuser, parseexception);
                }
            }

            public volatile void done(Object obj, Throwable throwable)
            {
                done((ParseUser)obj, (ParseException)throwable);
            }

            
            {
                a = f.this;
                super();
            }
        });
    }

    public void b(Activity activity)
    {
        super.b(activity);
        ParseUser parseuser = ParseUser.getCurrentUser();
        if (e != null)
        {
            b(((Context) (activity)), parseuser);
        }
        if (parseuser == null || ParseAnonymousUtils.isLinked(parseuser))
        {
            d();
        } else
        if (ParseFacebookUtils.isLinked(parseuser) || parseuser.isAuthenticated())
        {
            b.b();
            return;
        }
    }

    public void c(Activity activity)
    {
        super.c(activity);
        iv.a(this);
    }

    public void d(Activity activity)
    {
        super.d(activity);
        iv.b(this);
    }

    public void onEvent(ec ec1)
    {
        Context context = (Context)i.get();
        if (context != null)
        {
            a(context, ec1.a);
        }
    }
}
