// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.signup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.aqo;
import android.support.v7.fn;
import android.support.v7.gs;
import android.support.v7.id;
import android.support.v7.iu;
import com.abtnprojects.ambatana.h;
import com.abtnprojects.ambatana.models.LetgoAddress;
import com.abtnprojects.ambatana.models.SignUpUserInfoBitmap;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.parse.ParseUser;

// Referenced classes of package com.abtnprojects.ambatana.ui.signup:
//            m, i, h, k

public class j extends m
{

    private final h d;
    private final k e;
    private final id f;
    private final com.abtnprojects.ambatana.ui.signup.h g;

    public j(k k1, i l, h h1, id id1, com.abtnprojects.ambatana.ui.signup.h h2, gs gs1)
    {
        super(gs1, l);
        e = k1;
        d = h1;
        f = id1;
        g = h2;
    }

    private void a(ParseUser parseuser, Context context)
    {
        if (context != null)
        {
            a.a(parseuser);
            a.e(context, parseuser);
        }
    }

    private void a(String s, String s1)
    {
        s = f.a(s, s1);
        aqo.a("intent action : %s", new Object[] {
            s.getAction()
        });
        b.a(s);
    }

    void a(int l, int i1, Intent intent)
    {
        super.a(l, i1, intent);
        d.a(l, i1, intent);
    }

    public void a(Activity activity)
    {
    }

    public void a(Context context)
    {
        a(ParseUser.getCurrentUser(), context);
        a(g.a, g.b);
    }

    void a(SignUpUserInfoBitmap signupuserinfobitmap, LetgoAddress letgoaddress, Context context)
    {
        signupuserinfobitmap = new fn(this, signupuserinfobitmap, letgoaddress, context);
        letgoaddress = new Void[0];
        if (!(signupuserinfobitmap instanceof AsyncTask))
        {
            signupuserinfobitmap.execute(letgoaddress);
            return;
        } else
        {
            AsyncTaskInstrumentation.execute((AsyncTask)signupuserinfobitmap, letgoaddress);
            return;
        }
    }

    public void a(Boolean boolean1, Context context)
    {
        if (boolean1 != null && boolean1.booleanValue())
        {
            e.m();
            a(context);
            return;
        } else
        {
            e.l();
            return;
        }
    }

    public void a(Class class1, com.abtnprojects.ambatana.ui.signup.h h1)
    {
    }

    public void a(String s, Context context)
    {
    }

    void a(String s, String s1, com.abtnprojects.ambatana.ui.signup.h h1, Context context)
    {
    }

    public void b(Activity activity)
    {
        super.b(activity);
        if (iu.c(ParseUser.getCurrentUser()))
        {
            b.a();
        }
    }
}
