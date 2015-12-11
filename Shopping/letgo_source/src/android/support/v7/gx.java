// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import com.abtnprojects.ambatana.models.ProductInserted;
import com.parse.ParseUser;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            at, gi

public abstract class gx
{

    protected final gi a;
    protected final ParseUser b;

    public gx(gi gi1, ParseUser parseuser)
    {
        a = gi1;
        b = parseuser;
    }

    protected Map a(String s)
    {
        at at1 = new at(1);
        if (s != null && !s.isEmpty())
        {
            at1.put("description", s);
        }
        return at1;
    }

    protected Map a(String s, int i, String s1)
    {
        at at1 = new at(3);
        if (s != null && !s.isEmpty())
        {
            at1.put("product-id", s);
        }
        at1.put("category-id", String.valueOf(i));
        at1.put("location-type", s1);
        return at1;
    }

    public abstract void a(Context context);

    public abstract void a(Context context, ProductInserted productinserted, String s);

    public abstract void a(Context context, String s);

    protected void a(Context context, String s, String s1)
    {
        a.a(context, s, b(s1), b);
    }

    protected void a(Context context, String s, Map map)
    {
        a.a(context, s, map, b);
    }

    protected Map b(String s)
    {
        at at1 = new at(1);
        if (s != null && !s.isEmpty())
        {
            at1.put("product-id", s);
        }
        return at1;
    }

    public abstract void b(Context context, String s);

    protected void b(Context context, String s, Map map)
    {
        a.b(context, s, map, b);
    }
}
