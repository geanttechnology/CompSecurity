// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.v;

import com.shazam.model.auto.NcmRange;
import com.shazam.server.response.config.AmpNcmRange;
import java.util.HashMap;
import java.util.Map;

public final class a
    implements com.shazam.b.a.a
{

    private final Map a = new HashMap(2);

    public a()
    {
        a.put("SONIC", "0");
        a.put("ULTRASONIC", "1");
    }

    public final Object a(Object obj)
    {
        AmpNcmRange ampncmrange = (AmpNcmRange)obj;
        obj = ampncmrange.getType();
        com.shazam.model.auto.NcmRange.Builder builder;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = (String)a.get(obj);
        }
        builder = com.shazam.model.auto.NcmRange.Builder.a();
        builder.type = ((String) (obj));
        builder.start = ampncmrange.getStart();
        builder.stop = ampncmrange.getStop();
        return new NcmRange(builder, null);
    }
}
