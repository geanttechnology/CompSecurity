// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.c.a.a;


// Referenced classes of package com.google.c.a.a:
//            j, i

public final class m extends j
{

    public m()
    {
    }

    protected final i a()
    {
        return i.b;
    }

    public final boolean a(String s)
    {
        s = c(s);
        return s.startsWith("smtp:") || s.startsWith("SMTP:");
    }
}
