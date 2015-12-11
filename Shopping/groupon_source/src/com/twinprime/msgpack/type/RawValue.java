// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.type;


// Referenced classes of package com.twinprime.msgpack.type:
//            Value

public interface RawValue
    extends Value
{

    public abstract byte[] getByteArray();

    public abstract String getString();
}
