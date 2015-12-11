// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;

final class aiv extends gd
{

    private aiu X;

    aiv(aiu aiu1)
    {
        X = aiu1;
        super();
    }

    public final fz a(Context context)
    {
        context = X.a(context);
        context.a(X.a.a);
        aix aix1 = new aix(X, context);
        aiq aiq1 = X.a;
        chq chq;
        if (aiq1.c != null)
        {
            chq = aiq1.b;
        }
        aiq1.c = aix1;
        return context;
    }
}
