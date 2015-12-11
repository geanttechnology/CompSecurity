// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class cnd
{

    private static Set d;
    private static final Pattern e = Pattern.compile("[a-z.]+");
    public final String a;
    public final int b;
    public final Object c;

    public cnd(String s, int i)
    {
        this(s, i, null);
    }

    public cnd(String s, int i, Object obj)
    {
        b.a(s);
        if (!e.matcher(s).matches())
        {
            s = String.valueOf(s);
            if (s.length() != 0)
            {
                s = "Invalid code: ".concat(s);
            } else
            {
                s = new String("Invalid code: ");
            }
            throw new IllegalArgumentException(s);
        } else
        {
            a = s;
            b = i;
            c = obj;
            return;
        }
    }

    public final boolean a()
    {
        return d.contains(a) || a.endsWith(".fatal");
    }

    public final cnd b()
    {
        if (a())
        {
            return this;
        }
        String s = String.valueOf(a);
        String s1 = String.valueOf(".fatal");
        if (s1.length() != 0)
        {
            s = s.concat(s1);
        } else
        {
            s = new String(s);
        }
        return new cnd(s, b, c);
    }

    static 
    {
        HashSet hashset = new HashSet();
        hashset.add("drm");
        hashset.add("drm.auth");
        hashset.add("drm.missingapi");
        hashset.add("drm.keyerror");
        hashset.add("heartbeat");
        hashset.add("net.nomobiledata");
        hashset.add("fmt.noneavailable");
        hashset.add("fmt.unplayable");
        hashset.add("fmt.unparseable");
        hashset.add("fmt.decode");
        d = Collections.unmodifiableSet(hashset);
    }
}
