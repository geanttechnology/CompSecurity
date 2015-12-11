// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a;

import b.a.a.a.d;
import b.a.a.d.aa;
import java.io.Serializable;

// Referenced classes of package b.a.a:
//            w, c, i

public final class t extends d
    implements w, Serializable, Cloneable
{

    private c c;
    private int d;

    public t()
    {
    }

    public t(i i)
    {
        super(i, (byte)0);
    }

    public final void a(long l)
    {
        long l1 = l;
        d;
        JVM INSTR tableswitch 0 5: default 44
    //                   0 46
    //                   1 52
    //                   2 64
    //                   3 76
    //                   4 88
    //                   5 100;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L2:
        break; /* Loop/switch isn't completed */
_L1:
        l1 = l;
_L9:
        super.a(l1);
        return;
_L3:
        l1 = c.d(l);
        continue; /* Loop/switch isn't completed */
_L4:
        l1 = c.e(l);
        continue; /* Loop/switch isn't completed */
_L5:
        l1 = c.f(l);
        continue; /* Loop/switch isn't completed */
_L6:
        l1 = c.g(l);
        continue; /* Loop/switch isn't completed */
_L7:
        l1 = c.h(l);
        if (true) goto _L9; else goto _L8
_L8:
    }

    public final Object clone()
    {
        Object obj;
        try
        {
            obj = super.clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            throw new InternalError("Clone error");
        }
        return obj;
    }

    public final String toString()
    {
        return aa.b().a(this);
    }
}
