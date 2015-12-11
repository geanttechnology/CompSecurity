// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class azl
    implements Runnable
{

    private int a;
    private azk b;

    azl(azk azk1, int i)
    {
        b = azk1;
        a = i;
        super();
    }

    public final void run()
    {
        if (azh.d(b.b) != null)
        {
            azh.d(b.b).a(a);
        }
    }
}
