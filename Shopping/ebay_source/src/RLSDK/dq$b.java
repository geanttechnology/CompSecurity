// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;


// Referenced classes of package RLSDK:
//            al, dq, dp

private static final class <init>
    implements al
{

    private final float a;

    public final int a(Object obj, Object obj1)
    {
        float f = Math.abs(((dp)obj1).c() - a);
        float f1 = Math.abs(((dp)obj).c() - a);
        if (f < f1)
        {
            return -1;
        }
        return f != f1 ? 1 : 0;
    }

    private bject(float f)
    {
        a = f;
    }

    a(float f, byte byte0)
    {
        this(f);
    }
}
