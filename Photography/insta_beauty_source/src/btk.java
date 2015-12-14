// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


class btk extends bts
{

    final bti a;
    final btj b;

    btk(btj btj1, bti bti1)
    {
        b = btj1;
        a = bti1;
        super();
    }

    public void onRun()
    {
        bti bti1 = btj.a(b);
        if (!a.equals(bti1))
        {
            bso.h().a("Fabric", "Asychronously getting Advertising Info and storing it to preferences");
            btj.a(b, bti1);
        }
    }
}
