// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class cki
    implements Runnable
{

    private ckh a;

    cki(ckh ckh1)
    {
        a = ckh1;
        super();
    }

    public final void run()
    {
        a.setKeepScreenOn(true);
    }
}
