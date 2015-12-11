// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.e;

import b.a.a.i;
import java.util.Collections;
import java.util.Set;

// Referenced classes of package b.a.a.e:
//            k

public final class l
    implements k
{

    public l()
    {
    }

    public final i a(String s)
    {
        if ("UTC".equalsIgnoreCase(s))
        {
            return i.a;
        } else
        {
            return null;
        }
    }

    public final Set a()
    {
        return Collections.singleton("UTC");
    }
}
