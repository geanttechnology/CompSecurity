// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;

public class acn
{

    private final Context a;
    private final afj b;

    private acn(Context context, afj afj)
    {
        a = context;
        b = afj;
    }

    public static acn a(Context context, afj afj)
    {
        return new acn(context, afj);
    }
}
