// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.type;

import com.twinprime.msgpack.packer.Packer;
import java.io.IOException;

// Referenced classes of package com.twinprime.msgpack.type:
//            ValueType

public interface Value
{

    public abstract ValueType getType();

    public abstract Value getValue();

    public abstract StringBuilder toString(StringBuilder stringbuilder);

    public abstract void writeTo(Packer packer)
        throws IOException;
}
