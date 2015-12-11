// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.signup;

import android.app.Activity;
import android.content.Context;
import android.support.v7.gs;
import android.support.v7.id;
import android.support.v7.iu;
import com.abtnprojects.ambatana.models.LetgoAddress;
import com.abtnprojects.ambatana.models.SignUpUserInfoBitmap;
import com.parse.LogInCallback;
import com.parse.LogOutCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import java.lang.ref.WeakReference;

// Referenced classes of package com.abtnprojects.ambatana.ui.signup:
//            m, i, e, h

public class d extends m
{

    private final e d;
    private final id e;

    public d(e e1, i j, id id1, gs gs1)
    {
        super(gs1, j);
        d = e1;
        e = id1;
    }

    private void a(Context context, ParseUser parseuser)
    {
        a.a(parseuser);
        a.c(context, parseuser);
    }

    static void a(d d1, Context context, ParseUser parseuser)
    {
        d1.a(context, parseuser);
    }

    static void a(d d1, String s, String s1)
    {
        d1.a(s, s1);
    }

    private void a(String s, String s1)
    {
        b.a(e.a(s, s1));
    }

    public void a(Activity activity)
    {
    }

    public void a(SignUpUserInfoBitmap signupuserinfobitmap, LetgoAddress letgoaddress, Context context)
    {
    }

    public void a(Class class1, h h)
    {
    }

    public void a(String s, Context context)
    {
    }

    void a(String s, String s1, h h, Context context)
    {
        ParseUser.logInInBackground(s, s1, new LogInCallback(new WeakReference(d), new WeakReference(this), new WeakReference(context.getApplicationContext()), h) {

            final WeakReference a;
            final WeakReference b;
            final WeakReference c;
            final h d;
            final d e;

            protected void a(e e1)
            {
                if (e1 != null)
                {
                    e1.m();
                }
            }

            protected void a(e e1, d d1, ParseUser parseuser, Context context1, h h1)
            {
                if (e1 != null)
                {
                    e1.n();
                }
                if (d1 != null)
                {
                    if (context1 != null)
                    {
                        d.a(e, context1, parseuser);
                    }
                    d.a(d1, h1.a, h1.b);
                }
            }

            public void done(ParseUser parseuser, ParseException parseexception)
            {
                e e1;
label0:
                {
label1:
                    {
                        e1 = (e)a.get();
                        d d1 = (d)b.get();
                        if (parseexception != null)
                        {
                            break label0;
                        }
                        if (d1 != null)
                        {
                            if (!d1.a(parseuser))
                            {
                                break label1;
                            }
                            a(e1, d1, parseuser, (Context)c.get(), d);
                        }
                        return;
                    }
                    ParseUser.logOutInBackground(new LogOutCallback(this, e1) {

                        final e a;
                        final _cls1 b;

                        public void done(ParseException parseexception)
                        {
                            b.a(a);
                        }

                        public volatile void done(Throwable throwable)
                        {
                            done((ParseException)throwable);
                        }

            
            {
                b = _pcls1;
                a = e1;
                super();
            }
                    });
                    return;
                }
                a(e1);
            }

            public volatile void done(Object obj, Throwable throwable)
            {
                done((ParseUser)obj, (ParseException)throwable);
            }

            
            {
                e = d.this;
                a = weakreference;
                b = weakreference1;
                c = weakreference2;
                d = h1;
                super();
            }
        });
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
