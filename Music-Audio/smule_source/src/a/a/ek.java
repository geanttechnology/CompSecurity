// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;


// Referenced classes of package a.a:
//            bc, y

public final class ek
    implements bc
{

    public int a;

    public ek(int i)
    {
        a = i;
    }

    public final void a(y y1, String s, String s1)
    {
        this;
        JVM INSTR monitorenter ;
        y1.a(s, s1, Integer.valueOf(a).intValue());
        this;
        JVM INSTR monitorexit ;
        return;
        y1;
        throw y1;
    }

    public final Object b()
    {
        return Integer.valueOf(a);
    }
}
