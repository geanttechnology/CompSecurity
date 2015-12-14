// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.DataInputStream;
import java.io.InputStream;

// Referenced classes of package com.flurry.sdk:
//            ld

class eam extends DataInputStream
{

    final ld a;

    public void close()
    {
    }

    eam(ld ld1, InputStream inputstream)
    {
        a = ld1;
        super(inputstream);
    }
}
