// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;

public class aiu extends gk
{

    public final aiq a;
    public final ajb b;

    public aiu(aiq aiq, ajb ajb)
    {
        a = aiq;
        b = ajb;
    }

    public aja a(Context context)
    {
        return new aja(context, 0, a);
    }

    public aiy b(Context context)
    {
        return new aiy(context, 0, b);
    }

    public final gd b()
    {
        return new aiv(this);
    }

    public final gj c()
    {
        return new aiw(this);
    }
}
