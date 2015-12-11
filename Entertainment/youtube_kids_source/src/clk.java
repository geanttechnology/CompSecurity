// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class clk extends lv
{

    clk()
    {
        super(2500, 3, 1.0F);
    }

    public final void a(mp mp)
    {
        if (mp instanceof mn)
        {
            int i = ((mn)mp).a.a;
            if (i >= 400 && i < 500)
            {
                throw mp;
            }
        }
        super.a(mp);
    }
}
