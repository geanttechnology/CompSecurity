// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro;

import java.util.IdentityHashMap;
import java.util.Map;

// Referenced classes of package com.flurry.org.apache.avro:
//            Schema

static final class  extends ThreadLocal
{

    protected volatile Object initialValue()
    {
        return initialValue();
    }

    protected Map initialValue()
    {
        return new IdentityHashMap();
    }

    ()
    {
    }
}
