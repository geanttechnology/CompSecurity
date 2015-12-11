// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;


// Referenced classes of package android.support.v7:
//            vz, xs

public class oq
    implements vz
{

    private int a;
    private int b;
    private final int c;
    private final float d;

    public oq()
    {
        this(2500, 1, 1.0F);
    }

    public oq(int i, int j, float f)
    {
        a = i;
        c = j;
        d = f;
    }

    public int a()
    {
        return a;
    }

    public void a(xs xs1)
        throws xs
    {
        b = b + 1;
        a = (int)((float)a + (float)a * d);
        if (!c())
        {
            throw xs1;
        } else
        {
            return;
        }
    }

    public int b()
    {
        return b;
    }

    protected boolean c()
    {
        return b <= c;
    }
}
