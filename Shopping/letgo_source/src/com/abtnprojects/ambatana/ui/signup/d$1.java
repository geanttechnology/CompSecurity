// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.signup;

import android.content.Context;
import com.parse.LogInCallback;
import com.parse.LogOutCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import java.lang.ref.WeakReference;

// Referenced classes of package com.abtnprojects.ambatana.ui.signup:
//            d, e, h

class d
    implements LogInCallback
{

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

    protected void a(e e1, d d1, ParseUser parseuser, Context context, h h1)
    {
        if (e1 != null)
        {
            e1.n();
        }
        if (d1 != null)
        {
            if (context != null)
            {
                com.abtnprojects.ambatana.ui.signup.d.a(e, context, parseuser);
            }
            com.abtnprojects.ambatana.ui.signup.d.a(d1, h1.a, h1.b);
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
            ParseUser.logOutInBackground(new LogOutCallback(e1) {

                final e a;
                final d._cls1 b;

                public void done(ParseException parseexception1)
                {
                    b.a(a);
                }

                public volatile void done(Throwable throwable)
                {
                    done((ParseException)throwable);
                }

            
            {
                b = d._cls1.this;
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

    _cls1.a(d d1, WeakReference weakreference, WeakReference weakreference1, WeakReference weakreference2, h h1)
    {
        e = d1;
        a = weakreference;
        b = weakreference1;
        c = weakreference2;
        d = h1;
        super();
    }
}
