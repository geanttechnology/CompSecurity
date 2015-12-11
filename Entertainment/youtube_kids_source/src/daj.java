// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Log;

public final class daj
{

    public final int a;
    public final int b;
    private final Object c;

    public daj(int i, ewg ewg)
    {
        a = i;
        b = 2;
        c = ewg;
    }

    private daj(int i, exf exf1)
    {
        a = i;
        b = 1;
        c = f.b(exf1);
    }

    public static daj a(int i, exf exf1)
    {
        if (!exf1.b)
        {
            return new daj(i, exf1);
        }
        exl exl1 = exf1.c;
        if (exl1.a == exl1.c)
        {
            Log.w("RecognitionResponse", (new StringBuilder("Invalid response. Expecting exactly one recognition or endpointer event:")).append(daw.a(exf1)).toString());
        }
        if (exf1.c.c)
        {
            return new daj(i, exf1.c.d);
        } else
        {
            return new daj(i, exf1);
        }
    }

    public final Object a(int i)
    {
        if (i == b)
        {
            return c;
        } else
        {
            throw new IllegalStateException((new StringBuilder("Requested type: ")).append(i).append(", but was: ").append(b).toString());
        }
    }

    public final String toString()
    {
        return super.toString();
    }
}
