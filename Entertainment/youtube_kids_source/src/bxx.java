// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;

public class bxx
{

    public final Activity a;
    public final boq b;
    public final act c;

    public bxx(Activity activity, act act, boq boq)
    {
        a = activity;
        c = act;
        b = boq;
    }

    public bxw a(dxa dxa1, Object obj)
    {
        b.a(dxa1);
        if (dxa1.d != null)
        {
            return new ade(a, b, c, dxa1, obj);
        } else
        {
            return null;
        }
    }
}
