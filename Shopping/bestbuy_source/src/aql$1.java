// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Map;

class ang.Object
    implements aqi
{

    final aql a;

    public void a(Map map)
    {
        map = ((Map) (map.get("event")));
        if (map != null)
        {
            aql.a(a, map.toString());
        }
    }

    (aql aql1)
    {
        a = aql1;
        super();
    }
}
