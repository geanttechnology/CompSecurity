// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.common.internal.x;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            wd

public final class ux extends wd
{

    private final Map a = new HashMap();

    public ux()
    {
    }

    private String a(String s)
    {
        x.a(s);
        String s1 = s;
        if (s != null)
        {
            s1 = s;
            if (s.startsWith("&"))
            {
                s1 = s.substring(1);
            }
        }
        x.a(s1, "Name can not be empty or \"&\"");
        return s1;
    }

    public Map a()
    {
        return Collections.unmodifiableMap(a);
    }

    public void a(ux ux1)
    {
        x.a(ux1);
        ux1.a.putAll(a);
    }

    public volatile void a(wd wd1)
    {
        a((ux)wd1);
    }

    public void a(String s, String s1)
    {
        s = a(s);
        a.put(s, s1);
    }

    public String toString()
    {
        return a(a);
    }
}
