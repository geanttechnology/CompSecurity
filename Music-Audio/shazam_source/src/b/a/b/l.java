// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.b;

import b.a.d.b;
import com.google.b.c.a;
import com.google.b.f;
import com.google.b.x;
import com.google.b.y;
import java.lang.reflect.ParameterizedType;

// Referenced classes of package b.a.b:
//            k

public final class l
    implements y
{

    public l()
    {
    }

    public final x a(f f, a a1)
    {
        if (a1.a == b/a/d/b)
        {
            if (a1.b instanceof ParameterizedType)
            {
                return new k(f, ((ParameterizedType)a1.b).getActualTypeArguments()[0]);
            } else
            {
                return new k(f, java/lang/Object);
            }
        } else
        {
            return null;
        }
    }
}
