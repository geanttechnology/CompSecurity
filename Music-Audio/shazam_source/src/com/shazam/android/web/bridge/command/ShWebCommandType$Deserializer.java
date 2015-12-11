// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.web.bridge.command;

import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.r;
import java.lang.reflect.Type;

// Referenced classes of package com.shazam.android.web.bridge.command:
//            ShWebCommandType

public static class I
    implements k
{

    public ShWebCommandType deserialize(l l1, Type type, j j)
    {
        return ShWebCommandType.forString(l1.h().b());
    }

    public volatile Object deserialize(l l1, Type type, j j)
    {
        return deserialize(l1, type, j);
    }

    public I()
    {
    }
}
