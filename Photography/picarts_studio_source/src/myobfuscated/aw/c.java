// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.aw;

import com.photo.effect.Effect;
import java.util.List;

// Referenced classes of package myobfuscated.aw:
//            e, a, b, d

public final class c extends e
{

    public c(Effect effect)
    {
        a(new a(effect));
        a(new b(effect));
    }

    public final void a(int i)
    {
        List list = super.c;
        int j = 0;
        while (j < list.size()) 
        {
            d d1 = (d)list.get(j);
            if (d1 instanceof a)
            {
                ((a)d1).a(i);
            } else
            if (d1 instanceof b)
            {
                ((b)d1).a(i);
            }
            j++;
        }
    }
}
