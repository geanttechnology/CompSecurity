// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cm;

import com.photo.effect.Effect;
import myobfuscated.cj.c;

// Referenced classes of package myobfuscated.cm:
//            c, e

public class g
{

    e a;
    boolean b;
    myobfuscated.cm.c c;

    public g(myobfuscated.cm.c c1, e e1, boolean flag)
    {
        c = c1;
        a = e1;
        b = flag;
        super();
    }

    public void a(Effect effect, c c1, boolean flag, long l)
    {
        if (flag)
        {
            c.e = false;
        }
        if (a != null)
        {
            a.a(c1, flag, l, b);
        }
    }
}
