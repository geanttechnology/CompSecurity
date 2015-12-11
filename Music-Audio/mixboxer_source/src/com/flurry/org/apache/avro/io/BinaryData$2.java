// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;


// Referenced classes of package com.flurry.org.apache.avro.io:
//            BinaryData

static final class shData extends ThreadLocal
{

    protected shData initialValue()
    {
        return new shData();
    }

    protected volatile Object initialValue()
    {
        return initialValue();
    }

    shData()
    {
    }
}
