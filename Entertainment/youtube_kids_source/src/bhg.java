// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;

final class bhg extends bmr
{

    private bgv a;

    bhg(bgv bgv1)
    {
        a = bgv1;
        super();
    }

    public final Object a()
    {
        return a.b.getSharedPreferences("youtube", 0);
    }
}
