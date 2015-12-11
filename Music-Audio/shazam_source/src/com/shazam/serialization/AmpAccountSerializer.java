// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.serialization;

import com.google.b.l;
import com.google.b.o;
import com.google.b.s;
import com.google.b.t;
import com.shazam.server.response.config.AmpAccount;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class AmpAccountSerializer
    implements t
{

    public AmpAccountSerializer()
    {
    }

    public l serialize(AmpAccount ampaccount, Type type, s s1)
    {
        type = new o();
        java.util.Map.Entry entry;
        l l;
        for (ampaccount = ampaccount.getHrefMap().entrySet().iterator(); ampaccount.hasNext(); type.a((String)entry.getKey(), l))
        {
            entry = (java.util.Map.Entry)ampaccount.next();
            l = s1.a(entry.getValue());
        }

        return type;
    }

    public volatile l serialize(Object obj, Type type, s s1)
    {
        return serialize((AmpAccount)obj, type, s1);
    }
}
