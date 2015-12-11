// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.d;

import com.google.api.a.f.a.a.a.a.c;
import com.google.api.a.g.a.a;
import java.util.Map;

// Referenced classes of package com.google.api.a.d:
//            ab

private static final class m extends Enum
{

    public static final h a;
    public static final h b;
    public static final h c;
    public static final h d;
    public static final h e;
    public static final h f;
    public static final h g;
    public static final h h;
    private static final h n[];
    final Character i;
    final String j;
    final String k;
    final boolean l;
    final boolean m;

    public static m valueOf(String s)
    {
        return (m)Enum.valueOf(com/google/api/a/d/ab$a, s);
    }

    public static m[] values()
    {
        return (m[])n.clone();
    }

    final String a(String s)
    {
        if (m)
        {
            return com.google.api.a.g.a.a.c(s);
        } else
        {
            return com.google.api.a.g.a.a.a(s);
        }
    }

    static 
    {
        a = new <init>("PLUS", 0, Character.valueOf('+'), "", ",", false, true);
        b = new <init>("HASH", 1, Character.valueOf('#'), "#", ",", false, true);
        c = new <init>("DOT", 2, Character.valueOf('.'), ".", ".", false, false);
        d = new <init>("FORWARD_SLASH", 3, Character.valueOf('/'), "/", "/", false, false);
        e = new <init>("SEMI_COLON", 4, Character.valueOf(';'), ";", ";", true, false);
        f = new <init>("QUERY", 5, Character.valueOf('?'), "?", "&", true, false);
        g = new <init>("AMP", 6, Character.valueOf('&'), "&", "&", true, false);
        h = new <init>("SIMPLE", 7, null, "", ",", false, false);
        n = (new n[] {
            a, b, c, d, e, f, g, h
        });
    }

    private .a.c(String s, int i1, Character character, String s1, String s2, boolean flag, boolean flag1)
    {
        super(s, i1);
        i = character;
        j = (String)com.google.api.a.f.a.a.a.a.c.a(s1);
        k = (String)com.google.api.a.f.a.a.a.a.c.a(s2);
        l = flag;
        m = flag1;
        if (character != null)
        {
            com.google.api.a.d.ab.a.put(character, this);
        }
    }
}
