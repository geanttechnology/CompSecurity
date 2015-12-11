// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class aoi
    implements Runnable
{

    private int a;
    private int b;
    private float c;
    private aoh d;

    aoi(aoh aoh1, int i, int j, float f)
    {
        d = aoh1;
        a = i;
        b = j;
        c = f;
        super();
    }

    public final void run()
    {
        aol aol1 = d.a;
        int i = a;
        int j = b;
        float f = c;
        aol1.a(i, j);
    }
}
