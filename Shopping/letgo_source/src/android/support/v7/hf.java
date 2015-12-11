// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import com.parse.ParseUser;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            at, gi

public abstract class hf
{

    final gi a;
    final ParseUser b;

    public hf(gi gi1, ParseUser parseuser)
    {
        a = gi1;
        b = parseuser;
    }

    private Map a(String s)
    {
        at at1 = new at(1);
        at1.put("location-type", s);
        return at1;
    }

    protected Map a()
    {
        at at1 = new at(1);
        if (b != null)
        {
            at1.put("user-id", b.getObjectId());
        }
        return at1;
    }

    public abstract void a(Context context);

    protected void a(Context context, String s, Map map)
    {
        a.a(context, s, map, b);
    }

    public void a(ParseUser parseuser)
    {
        a.b();
        a.a(parseuser);
    }

    protected Map b()
    {
        at at1 = new at(2);
        if (b != null)
        {
            at1.put("user-id", b.getObjectId());
        }
        at1.put("distance-unit", "miles");
        return at1;
    }

    public abstract void b(Context context);

    protected void b(Context context, String s, Map map)
    {
        a.b(context, s, map, b);
    }

    protected Map c()
    {
        at at1 = new at(2);
        if (b != null)
        {
            at1.put("user-id", b.getObjectId());
        }
        at1.put("distance-unit", "km");
        return at1;
    }

    public abstract void c(Context context);

    protected Map d()
    {
        return a("auto");
    }

    public abstract void d(Context context);

    protected Map e()
    {
        return a("manual");
    }

    public abstract void e(Context context);

    public abstract void f(Context context);

    public abstract void g(Context context);

    public abstract void h(Context context);

    public abstract void i(Context context);
}
