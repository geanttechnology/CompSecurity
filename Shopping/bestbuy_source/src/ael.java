// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;

public class ael
{

    private final Context a;
    private final String b;
    private final afj c;
    private final String d;
    private aen e;

    private ael(Context context, String s, String s1, afj afj)
    {
        a = context;
        b = s;
        c = afj;
        e = null;
        d = s1;
    }

    public static ael a(Context context, String s, String s1, afj afj)
    {
        return new ael(context, s, s1, afj);
    }
}
