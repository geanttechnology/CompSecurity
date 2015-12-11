// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;


// Referenced classes of package RLSDK:
//            v, t, ag, ah

public abstract class o
{

    private final t a;

    protected o(t t)
    {
        if (t == null)
        {
            throw new IllegalArgumentException("Source must be non-null.");
        } else
        {
            a = t;
            return;
        }
    }

    public abstract ag a(int i, ag ag)
        throws v;

    public final t a()
    {
        return a;
    }

    public abstract ah b()
        throws v;
}
