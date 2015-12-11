// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import com.sun.jna.ptr.IntByReference;

// Referenced classes of package com.pointinside.maps:
//            PIMap

abstract class EventTypeHandler
{

    protected final PIMap map;

    protected EventTypeHandler(PIMap pimap)
    {
        map = pimap;
    }

    public abstract void execute();

    public abstract void execute(IntByReference intbyreference);
}
