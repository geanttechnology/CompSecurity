// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.g.b;

import com.google.api.a.g.w;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.google.api.a.g.b:
//            e, d

public abstract class b
    implements e
{

    private static final Pattern c = Pattern.compile("\\w{1,30}");
    private final Lock a = new ReentrantLock();
    private final Map b = new HashMap();

    public b()
    {
    }

    public final d a(String s)
    {
        w.a(c.matcher(s).matches(), "%s does not match pattern %s", new Object[] {
            s, c
        });
        a.lock();
        d d2 = (d)b.get(s);
        d d1;
        d1 = d2;
        if (d2 != null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        d1 = b(s);
        b.put(s, d1);
        a.unlock();
        return d1;
        s;
        a.unlock();
        throw s;
    }

    protected abstract d b(String s);

}
