// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.file;


// Referenced classes of package com.flurry.org.apache.avro.file:
//            CodecFactory, SnappyCodec, Codec

static class  extends CodecFactory
{

    protected Codec createInstance()
    {
        return new SnappyCodec(null);
    }

    ()
    {
    }
}
