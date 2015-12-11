// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Handler;

final class bhd extends bmr
{

    private bgv a;

    bhd(bgv bgv1)
    {
        a = bgv1;
        super();
    }

    public final Object a()
    {
        return new Handler(a.b.getMainLooper());
    }
}
