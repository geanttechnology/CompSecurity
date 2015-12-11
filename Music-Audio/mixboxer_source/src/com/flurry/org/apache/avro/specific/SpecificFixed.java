// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.specific;


// Referenced classes of package com.flurry.org.apache.avro.specific:
//            SpecificData

public abstract class SpecificFixed extends com.flurry.org.apache.avro.generic.GenericData.Fixed
{

    public SpecificFixed()
    {
        setSchema(SpecificData.get().getSchema(getClass()));
    }

    public SpecificFixed(byte abyte0[])
    {
        this();
        bytes(abyte0);
    }
}
