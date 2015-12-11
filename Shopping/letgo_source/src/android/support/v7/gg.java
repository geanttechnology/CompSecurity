// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import com.parse.ParseUser;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            at, gi

public class gg
{

    private final gi a;

    public gg(gi gi1)
    {
        a = gi1;
    }

    protected Map a(String s)
    {
        at at1 = new at(1);
        if (s != null)
        {
            s = s.trim();
            if (!s.isEmpty())
            {
                at1.put("search-keyword", s);
            }
        }
        return at1;
    }

    public void a(Context context, ParseUser parseuser)
    {
        a.b(context, "search-start", new HashMap(), parseuser);
    }

    public void a(Context context, String s, ParseUser parseuser)
    {
        a.a(context, "search-complete", a(s), parseuser);
    }
}
