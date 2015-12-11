// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


class arm
{

    public static wk a(wk wk1)
    {
        wk wk2 = new wk();
        wk2.a = wk1.a;
        wk2.k = (int[])wk1.k.clone();
        if (wk1.l)
        {
            wk2.l = wk1.l;
        }
        return wk2;
    }
}
