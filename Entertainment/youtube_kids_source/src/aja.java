// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;

public class aja extends fz
{

    private final aiq a;

    public aja(Context context, int i, aiq aiq1)
    {
        super(context, i);
        a = aiq1;
    }

    public final boolean a(iz iz1)
    {
        if (ais.a(iz1) && iz1.m != null)
        {
            ame ame1 = ame.a(iz1.m);
            if (ame1 != null && ame1.h() && a.a(ame1.f()) != null)
            {
                return false;
            }
        }
        return super.a(iz1);
    }
}
