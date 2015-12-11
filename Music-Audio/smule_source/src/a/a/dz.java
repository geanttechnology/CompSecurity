// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;


// Referenced classes of package a.a:
//            ed

public final class dz extends ed
{

    private Runnable a;

    public dz(Runnable runnable)
    {
        a = runnable;
    }

    public final void a()
    {
        a.run();
    }
}
