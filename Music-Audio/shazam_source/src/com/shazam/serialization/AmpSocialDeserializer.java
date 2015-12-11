// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.serialization;

import com.google.b.b.g;
import com.google.b.j;
import com.google.b.k;
import com.google.b.l;
import com.google.b.o;
import com.shazam.server.response.config.AmpHref;
import com.shazam.server.response.config.AmpSocial;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AmpSocialDeserializer
    implements k
{

    public AmpSocialDeserializer()
    {
    }

    public AmpSocial deserialize(l l1, Type type, j j1)
    {
        type = l1.g().a.entrySet();
        l1 = new HashMap();
        java.util.Map.Entry entry;
        AmpHref amphref;
        for (type = type.iterator(); type.hasNext(); l1.put(entry.getKey(), amphref))
        {
            entry = (java.util.Map.Entry)type.next();
            amphref = (AmpHref)j1.a((l)entry.getValue(), com/shazam/server/response/config/AmpHref);
        }

        return com.shazam.server.response.config.AmpSocial.Builder.ampSocial().withHrefMap(l1).build();
    }

    public volatile Object deserialize(l l1, Type type, j j1)
    {
        return deserialize(l1, type, j1);
    }
}
