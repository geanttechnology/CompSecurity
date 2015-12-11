// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.Schema;
import java.io.IOException;

// Referenced classes of package com.flurry.org.apache.avro.io:
//            Decoder

public interface DatumReader
{

    public abstract Object read(Object obj, Decoder decoder)
        throws IOException;

    public abstract void setSchema(Schema schema);
}
