// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.content.Context;
import com.parse.ParseUser;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            gi, at, iu

public class gs
{

    private final gi a;
    private final String b;
    private final iu c;

    public gs(gi gi1, String s, iu iu1)
    {
        a = gi1;
        b = s;
        c = iu1;
    }

    public void a()
    {
        a.a();
    }

    public void a(Activity activity)
    {
        a.b(activity);
    }

    public void a(Context context)
    {
        a(context, "login-abandon", b(), null);
    }

    public void a(Context context, ParseUser parseuser)
    {
        b(context, "login-screen", b(), parseuser);
    }

    protected void a(Context context, String s, Map map, ParseUser parseuser)
    {
        a.a(context, s, map, parseuser);
    }

    public void a(ParseUser parseuser)
    {
        a.a(parseuser);
    }

    protected Map b()
    {
        at at1 = new at(1);
        at1.put("login-type", b);
        return at1;
    }

    public void b(Activity activity)
    {
        a.d(activity);
    }

    public void b(Context context, ParseUser parseuser)
    {
        a(context, "login-reset-password", b(), parseuser);
    }

    protected void b(Context context, String s, Map map, ParseUser parseuser)
    {
        a.b(context, s, map, parseuser);
    }

    public void c(Activity activity)
    {
        a.e(activity);
    }

    public void c(Context context, ParseUser parseuser)
    {
        String s;
        if (c.b(parseuser))
        {
            s = "dummy-login-email";
        } else
        {
            s = "login-email";
        }
        a(context, s, b(), parseuser);
    }

    public void d(Context context, ParseUser parseuser)
    {
        String s;
        if (c.b(parseuser))
        {
            s = "dummy-login-fb";
        } else
        {
            s = "login-fb";
        }
        a(context, s, b(), parseuser);
    }

    public void e(Context context, ParseUser parseuser)
    {
        String s;
        if (c.b(parseuser))
        {
            s = "dummy-signup-email";
        } else
        {
            s = "signup-email";
        }
        a(context, s, b(), parseuser);
    }
}
