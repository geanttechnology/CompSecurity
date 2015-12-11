// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.content.Context;
import com.parse.ParseUser;

// Referenced classes of package android.support.v7:
//            hb, ic

public class if
{
    public static interface a
    {

        public abstract void k();
    }


    final ParseUser a;
    final hb b;
    private final a c;
    private final ic d;
    private String e;
    private final Context f;

    public if(Context context, a a1, ic ic1, ParseUser parseuser, hb hb1)
    {
        f = context;
        c = a1;
        d = ic1;
        a = parseuser;
        b = hb1;
    }

    public void a()
    {
        if (a != null)
        {
            b.c(f);
            d.b(a.getObjectId());
        }
    }

    public void a(Activity activity)
    {
        b.a(activity);
    }

    public void a(String s)
    {
        e = s;
        c.k();
        b.a(f);
    }

    public void b()
    {
        b.b(f);
        d.a();
    }

    public void b(Activity activity)
    {
        b.b(activity);
    }
}
