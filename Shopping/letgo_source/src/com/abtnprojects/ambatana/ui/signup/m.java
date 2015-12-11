// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.signup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.aqo;
import android.support.v7.ef;
import android.support.v7.gs;
import android.support.v7.iv;
import com.abtnprojects.ambatana.models.LetgoAddress;
import com.abtnprojects.ambatana.models.SignUpUserInfoBitmap;
import com.parse.ParseUser;
import java.util.List;

// Referenced classes of package com.abtnprojects.ambatana.ui.signup:
//            a, i, h

public abstract class m
{

    protected final gs a;
    final i b;
    protected Object c;

    public m(gs gs1, i j)
    {
        c = new Object() {

            final m a;

            public void onEvent(ef ef)
            {
                a.b.a(null);
            }

            
            {
                a = m.this;
                super();
            }
        };
        a = gs1;
        b = j;
    }

    List a(a a1)
    {
        return a1.a();
    }

    void a()
    {
        iv.a(c);
    }

    void a(int j, int k, Intent intent)
    {
        if (j == 537 && k == -1)
        {
            aqo.a("Result ok %s", new Object[] {
                intent
            });
            b.a(intent);
        }
    }

    public abstract void a(Activity activity);

    abstract void a(SignUpUserInfoBitmap signupuserinfobitmap, LetgoAddress letgoaddress, Context context);

    public abstract void a(Class class1, h h);

    public abstract void a(String s, Context context);

    abstract void a(String s, String s1, h h, Context context);

    protected boolean a(ParseUser parseuser)
    {
        return !parseuser.getBoolean("is_scammer");
    }

    public void b(Activity activity)
    {
        a.a(activity);
    }

    void c()
    {
        a.a();
    }

    public void c(Activity activity)
    {
        a.b(activity);
        iv.a(c);
    }

    void d(Activity activity)
    {
        a.c(activity);
        iv.b(c);
    }
}
