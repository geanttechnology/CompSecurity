// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import android.content.Context;
import com.parse.ParseUser;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            gi

public abstract class hb
{

    protected final Map a;
    protected final ParseUser b;
    private final gi c;

    public hb(gi gi1, ParseUser parseuser, String s)
    {
        c = gi1;
        a = a(parseuser, s);
        b = parseuser;
    }

    protected Map a(ParseUser parseuser, String s)
    {
        HashMap hashmap = new HashMap();
        if (s != null && !s.trim().isEmpty())
        {
            hashmap.put("product-id", s);
        }
        if (parseuser != null)
        {
            hashmap.put("user-id", parseuser.getObjectId());
        }
        return hashmap;
    }

    public void a(Activity activity)
    {
        c.e(activity);
    }

    public abstract void a(Context context);

    protected void a(Context context, String s)
    {
        c.b(context, s, a, b);
    }

    public void b(Activity activity)
    {
        c.d(activity);
    }

    public abstract void b(Context context);

    protected void b(Context context, String s)
    {
        c.a(context, s, a, b);
    }

    public abstract void c(Context context);
}
