// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class bms
    implements Runnable
{

    private bmr a;

    bms(bmr bmr1)
    {
        a = bmr1;
        super();
    }

    public final void run()
    {
        a.b();
    }
}
