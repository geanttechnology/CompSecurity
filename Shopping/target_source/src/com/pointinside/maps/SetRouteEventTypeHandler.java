// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.maps;

import com.sun.jna.ptr.IntByReference;

// Referenced classes of package com.pointinside.maps:
//            EventTypeHandler, PIMap

class SetRouteEventTypeHandler extends EventTypeHandler
{

    protected SetRouteEventTypeHandler(PIMap pimap)
    {
        super(pimap);
    }

    public void execute()
    {
        map.drawRoute();
    }

    public void execute(IntByReference intbyreference)
    {
    }
}
