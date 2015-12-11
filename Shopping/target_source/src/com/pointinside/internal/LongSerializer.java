// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.internal;

import com.google.b.l;
import com.google.b.r;
import com.google.b.s;
import com.google.b.t;
import com.pointinside.internal.utils.StringUtils;
import java.lang.reflect.Type;

public class LongSerializer
    implements t
{

    public LongSerializer()
    {
    }

    public l serialize(Long long1, Type type, s s)
    {
        return new r(StringUtils.getDatetimeInString(long1.longValue()));
    }

    public volatile l serialize(Object obj, Type type, s s)
    {
        return serialize((Long)obj, type, s);
    }
}
