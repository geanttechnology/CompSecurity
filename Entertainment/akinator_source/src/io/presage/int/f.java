// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.int;

import io.presage.Presage;
import io.presage.utils.do.do.b;
import java.util.Map;

// Referenced classes of package io.presage.int:
//            b, g

public final class f extends io.presage.int.b
    implements g
{

    public f(String s)
    {
        super(s);
    }

    public final void a(b b1)
    {
        b1 = (String)a().get(c());
        Presage.getInstance().setId(b1);
    }
}
