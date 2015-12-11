// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.msgpack.object;

import org.msgpack.MessagePackObject;

// Referenced classes of package org.msgpack.object:
//            DoubleTypeIMPL, FloatTypeIMPL

public abstract class FloatType extends MessagePackObject
{

    public FloatType()
    {
    }

    public static FloatType create(double d)
    {
        return new DoubleTypeIMPL(d);
    }

    public static FloatType create(float f)
    {
        return new FloatTypeIMPL(f);
    }
}
