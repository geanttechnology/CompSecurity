// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack;

import com.twinprime.msgpack.packer.Packer;
import java.io.IOException;

public interface MessagePackable
{

    public abstract void writeTo(Packer packer)
        throws IOException;
}
