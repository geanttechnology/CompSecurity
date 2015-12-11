// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.signup;

import android.app.Activity;
import android.content.Context;
import android.support.v7.gs;
import android.support.v7.iu;
import android.text.TextUtils;
import android.util.Patterns;
import com.abtnprojects.ambatana.models.LetgoAddress;
import com.abtnprojects.ambatana.models.SignUpUserInfoBitmap;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;
import java.lang.ref.WeakReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.abtnprojects.ambatana.ui.signup:
//            m, c, i, h

public class b extends m
{
    private class a
        implements RequestPasswordResetCallback
    {

        final b a;
        private final WeakReference b;
        private final WeakReference c;
        private final String d;

        public void done(ParseException parseexception)
        {
            b b1 = (b)b.get();
            if (parseexception == null)
            {
                if (b1 != null)
                {
                    b.a(b1, (Context)c.get(), d);
                }
            } else
            if (b1 != null)
            {
                b.a(b1);
                return;
            }
        }

        public volatile void done(Throwable throwable)
        {
            done((ParseException)throwable);
        }

        public a(b b2, Context context, String s)
        {
            a = b.this;
            super();
            b = new WeakReference(b2);
            c = new WeakReference(context);
            d = s;
        }
    }


    private final c d;

    public b(c c1, i j, gs gs1)
    {
        super(gs1, j);
        d = c1;
    }

    private void a(Context context, String s)
    {
        if (context != null)
        {
            a.b(context, null);
        }
        d.o();
        d.b(s);
        b.a(null);
    }

    static void a(b b1)
    {
        b1.b();
    }

    static void a(b b1, Context context, String s)
    {
        b1.a(context, s);
    }

    private void b()
    {
        d.n();
    }

    public void a(Activity activity)
    {
    }

    void a(SignUpUserInfoBitmap signupuserinfobitmap, LetgoAddress letgoaddress, Context context)
    {
    }

    public void a(Class class1, h h)
    {
    }

    public void a(String s, Context context)
    {
        if (TextUtils.isEmpty(s))
        {
            d.m();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(s).matches())
        {
            d.l();
            return;
        } else
        {
            b(s, context);
            return;
        }
    }

    void a(String s, String s1, h h, Context context)
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

    public void b(String s, Context context)
    {
        ParseUser.requestPasswordResetInBackground(s, new a(this, context, s));
    }
}
