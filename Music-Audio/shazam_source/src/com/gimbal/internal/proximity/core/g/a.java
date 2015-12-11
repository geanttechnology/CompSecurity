// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gimbal.internal.proximity.core.g;

import com.gimbal.internal.proximity.core.f.b;
import com.gimbal.internal.proximity.core.f.e;
import com.gimbal.internal.proximity.impl.TransmitterInternal;

// Referenced classes of package com.gimbal.internal.proximity.core.g:
//            b

public final class a
{

    public e a;

    public a()
    {
        a = new b(com/gimbal/internal/proximity/impl/TransmitterInternal, "proximity.transmitters");
    }

    public final void a(TransmitterInternal transmitterinternal, String s)
    {
        com.gimbal.internal.proximity.core.g.b b1 = b.a();
        String s1 = transmitterinternal.getIdentifier();
        s = b.a(s);
        b1.a.a(s, s1);
        a.a(transmitterinternal.getIdentifier(), transmitterinternal);
    }
}
