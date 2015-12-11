// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.d.a;


// Referenced classes of package e.d.d.a:
//            a

abstract class r extends a
{

    private static final Integer d = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);

    public r(int i)
    {
        super(i);
        Math.min(i / 4, d.intValue());
    }

}
