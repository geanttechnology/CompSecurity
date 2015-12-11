// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.template;

import com.twinprime.msgpack.packer.Packer;
import java.io.IOException;

public interface Template
{

    public abstract void write(Packer packer, Object obj)
        throws IOException;

    public abstract void write(Packer packer, Object obj, boolean flag)
        throws IOException;
}
