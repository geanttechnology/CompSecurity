// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.generic;

import com.flurry.org.apache.avro.util.WeakIdentityHashMap;
import java.util.Map;

// Referenced classes of package com.flurry.org.apache.avro.generic:
//            GenericDatumReader

static final class  extends ThreadLocal
{

    protected volatile Object initialValue()
    {
        return initialValue();
    }

    protected Map initialValue()
    {
        return new WeakIdentityHashMap();
    }

    ()
    {
    }
}
