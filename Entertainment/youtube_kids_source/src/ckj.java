// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


final class ckj
    implements Runnable
{

    private ckh a;

    ckj(ckh ckh1)
    {
        a = ckh1;
        super();
    }

    public final void run()
    {
        a.setKeepScreenOn(false);
    }
}
